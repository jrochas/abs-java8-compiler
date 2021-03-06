package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class ProTry extends EffExp {
  public final PureExp pureexp_;
  public ProTry(PureExp p1) { pureexp_ = p1; }

  public <R,A> R accept(bnfc.abs.Absyn.EffExp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.ProTry) {
      bnfc.abs.Absyn.ProTry x = (bnfc.abs.Absyn.ProTry)o;
      return this.pureexp_.equals(x.pureexp_);
    }
    return false;
  }

  public int hashCode() {
    return this.pureexp_.hashCode();
  }


}
