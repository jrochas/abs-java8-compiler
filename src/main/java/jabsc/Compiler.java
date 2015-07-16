package jabsc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import bnfc.abs.Yylex;
import bnfc.abs.parser;
import bnfc.abs.Absyn.Modul;
import bnfc.abs.Absyn.Module;
import bnfc.abs.Absyn.Prog;
import bnfc.abs.Absyn.Program;

/**
 * Entry point to ABS to Java compiler.
 */
public class Compiler implements Runnable {

  public static final String DEFAULT_OUTPUT_DIRECTORY_NAME = "generated-sources/jabsc";

  /**
   * The version of JABSC Compiler.
   */
  private static final String VERSION;

  static {
    VERSION = Optional.ofNullable(Compiler.class.getPackage().getImplementationVersion())
        .orElse("1.x-SNAPSHOT");
    SLF4JBridgeHandler.install();
  }

  /**
   * .java
   */
  private static final String JAVA_FILE_EXTENSION = ".java";

  private final Logger logger = LoggerFactory.getLogger(getClass());

  private final List<Path> sources;
  private final Path outputDirectory;

  public Compiler(String source, String outputDirectory) {
    this(createPath(source), createOutputDirectoryPath(outputDirectory, createPath(source)));
  }

  public Compiler(Path source, Path outputDirectory) {
    this(Collections.singletonList(source), outputDirectory);
  }

  public Compiler(List<Path> sources, Path outputDirectory) {
    this.sources = createSources(sources);
    this.outputDirectory = outputDirectory.normalize().toAbsolutePath();
    validate(sources, outputDirectory);
    logger.info("JABSC Compiler {} initialized", VERSION);
  }

  /**
   * @return
   * @throws Exception
   */
  public List<Path> compile() throws Exception {
    logger.info("Compiling from {} to {}", sources, outputDirectory);
    final List<Path> compilations = new ArrayList<>();
    for (Path source : sources) {
      if (Files.isDirectory(source) && Files.list(source).count() == 0) {
        logger.info("Source directory {} is empty. Skipping.", source);
        continue;
      }
      Path compilation = compile(source, outputDirectory);
      compilations.add(compilation);
    }
    logger.info("Compiled {} Java sources to: {}", compilations.size(), outputDirectory);
    return compilations;
  }

  @Override
  public void run() {
    try {
      compile();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * @param source
   * @param outputDirectory
   * @return
   * @throws Exception
   */
  protected Path compile(Path source, Path outputDirectory) throws Exception {
    try (final BufferedReader reader = Files.newBufferedReader(source)) {
      final Program program = parseSource(reader);
      return generateSource(program, source, outputDirectory);
    }
  }

  /**
   * @param program
   * @param source
   * @param outputDirectory
   * @return
   * @throws IOException
   */
  protected Path generateSource(Program program, Path source, Path outputDirectory)
      throws IOException {
    final Prog prog = (Prog) program;
    final String packageName = getPackageName(prog);
    final Path sourcePath = createSourcePath(packageName, source, outputDirectory);
    final Visitor visitor = new Visitor(packageName, prog,
        new DefaultJavaWriterSupplier(this, packageName, outputDirectory),
        new JavaTypeTranslator());
    Files.createDirectories(sourcePath.getParent());
    try (final Writer writer = createWriter(sourcePath)) {
      JavaWriter jw = new JavaWriter(writer);
      prog.accept(visitor, jw);
      return sourcePath;
    }
  }

  /**
   * @param packageName
   * @param source
   * @param outputDirectory
   * @return
   */
  protected Path createSourcePath(String packageName, Path source, Path outputDirectory) {
    final String fullFileName = source.getFileName().toString();
    int dotIndex = fullFileName.lastIndexOf('.');
    final String fileName = dotIndex == -1 ? fullFileName : fullFileName.substring(0, dotIndex);
    outputDirectory = resolveOutputDirectory(packageName, outputDirectory);
    return outputDirectory.resolve(fileName + JAVA_FILE_EXTENSION);
  }

  /**
   * @param sourcePath
   * @return
   * @throws IOException
   */
  protected BufferedWriter createWriter(final Path sourcePath) throws IOException {
    return Files.newBufferedWriter(sourcePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
  }

  /**
   * @param reader
   * @return
   * @throws Exception
   */
  protected Program parseSource(final BufferedReader reader) throws Exception {
    final Yylex lexer = new Yylex(reader);
    final parser parser = new parser(lexer);
    return parser.pProgram();
  }

  /**
   * @param prog
   * @return
   */
  protected String getPackageName(final Prog prog) {
    Module module = prog.listmodule_.iterator().next();
    Visitor v = new Visitor(null, prog, null, new JavaTypeTranslator());
    return v.getQTypeName(((Modul) module).qtype_).toLowerCase();
  }

  /**
   * @param packageName
   * @param outputDirectory
   * @return
   */
  protected Path resolveOutputDirectory(String packageName, Path outputDirectory) {
    if (packageName == null || packageName.isEmpty()) {
      return outputDirectory;
    }
    String[] parts = packageName.split("\\.");
    for (String packagePart : parts) {
      outputDirectory = outputDirectory.resolve(packagePart);
    }
    return outputDirectory;
  }

  /**
   * Traverses the source paths and collects all possible ABS
   * source files.
   * 
   * @param sources
   * @return
   */
  protected List<Path> createSources(List<Path> sources) {
    Set<Path> result = new HashSet<>();
    if (sources == null || sources.isEmpty()) {
      return new ArrayList<>();
    }
    for (Path source : sources) {
      if (Files.isDirectory(source)) {
        try {
          for (Path p : Files.newDirectoryStream(source, "*.abs")) {
            result.add(p.toAbsolutePath());
          }
        } catch (IOException e) {
          throw new IllegalArgumentException("Source directory is not valid: " + source);
        }
      } else if (Files.isRegularFile(source)) {
        result.add(source.toAbsolutePath());
      }
    }
    return new ArrayList<>(result);
  }

  protected void validate(List<Path> sources, Path outputDirectory) {
    if (!Files.exists(outputDirectory)) {
      try {
        Files.createDirectories(outputDirectory);
      } catch (IOException e) {
        throw new IllegalArgumentException(e);
      }
    }
    if (!Files.isWritable(outputDirectory)) {
      throw new IllegalArgumentException("Cannot write to output directory: " + outputDirectory);
    }
    for (Path p : sources) {
      if (!Files.isReadable(p)) {
        throw new IllegalArgumentException("Cannot read from source directory: " + p);
      }
    }
  }

  protected static Path createOutputDirectoryPath(String outputDirectory, Path source) {
    final boolean isSourceDirectory = Files.isDirectory(source) && Files.isReadable(source);
    if (outputDirectory != null) {
      return createPath(outputDirectory);
    } else {
      return isSourceDirectory
          ? source.getParent().resolve(DEFAULT_OUTPUT_DIRECTORY_NAME).toAbsolutePath()
          : source.getParent().getParent().resolve(DEFAULT_OUTPUT_DIRECTORY_NAME).toAbsolutePath();
    }
  }

  private static Path createPath(String source) {
    return Paths.get(source).toAbsolutePath().normalize();
  }

}
