package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class StarFromExport extends Export {
  public final QType qtype_;
  public StarFromExport(QType p1) { qtype_ = p1; }

  public <R,A> R accept(bnfc.abs.Absyn.Export.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.StarFromExport) {
      bnfc.abs.Absyn.StarFromExport x = (bnfc.abs.Absyn.StarFromExport)o;
      return this.qtype_.equals(x.qtype_);
    }
    return false;
  }

  public int hashCode() {
    return this.qtype_.hashCode();
  }


}
