package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class EQualFunCall extends PureExp {
  public final TType ttype_;
  public final String lident_;
  public final ListPureExp listpureexp_;
  public EQualFunCall(TType p1, String p2, ListPureExp p3) { ttype_ = p1; lident_ = p2; listpureexp_ = p3; }

  public <R,A> R accept(bnfc.abs.Absyn.PureExp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.EQualFunCall) {
      bnfc.abs.Absyn.EQualFunCall x = (bnfc.abs.Absyn.EQualFunCall)o;
      return this.ttype_.equals(x.ttype_) && this.lident_.equals(x.lident_) && this.listpureexp_.equals(x.listpureexp_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.ttype_.hashCode())+this.lident_.hashCode())+this.listpureexp_.hashCode();
  }


}
