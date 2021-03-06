package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class GExp extends AwaitGuard {
  public final PureExp pureexp_;
  public GExp(PureExp p1) { pureexp_ = p1; }

  public <R,A> R accept(bnfc.abs.Absyn.AwaitGuard.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.GExp) {
      bnfc.abs.Absyn.GExp x = (bnfc.abs.Absyn.GExp)o;
      return this.pureexp_.equals(x.pureexp_);
    }
    return false;
  }

  public int hashCode() {
    return this.pureexp_.hashCode();
  }


}
