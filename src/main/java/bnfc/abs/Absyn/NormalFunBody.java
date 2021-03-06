package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class NormalFunBody extends FunBody {
  public final PureExp pureexp_;
  public NormalFunBody(PureExp p1) { pureexp_ = p1; }

  public <R,A> R accept(bnfc.abs.Absyn.FunBody.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.NormalFunBody) {
      bnfc.abs.Absyn.NormalFunBody x = (bnfc.abs.Absyn.NormalFunBody)o;
      return this.pureexp_.equals(x.pureexp_);
    }
    return false;
  }

  public int hashCode() {
    return this.pureexp_.hashCode();
  }


}
