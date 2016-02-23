package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class SExp extends Stm {
  public final Exp exp_;
  public SExp(Exp p1) { exp_ = p1; }

  public <R,A> R accept(bnfc.abs.Absyn.Stm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.SExp) {
      bnfc.abs.Absyn.SExp x = (bnfc.abs.Absyn.SExp)o;
      return this.exp_.equals(x.exp_);
    }
    return false;
  }

  public int hashCode() {
    return this.exp_.hashCode();
  }


}
