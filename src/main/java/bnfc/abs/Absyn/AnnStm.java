package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public abstract class AnnStm implements java.io.Serializable {
  public abstract <R,A> R accept(AnnStm.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(bnfc.abs.Absyn.AnnStatement p, A arg);

  }

}
