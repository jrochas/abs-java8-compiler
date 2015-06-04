package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class CatchBranc extends CatchBranch {
  public final Pattern pattern_;
  public final Stm stm_;
  public CatchBranc(Pattern p1, Stm p2) { pattern_ = p1; stm_ = p2; }

  public <R,A> R accept(bnfc.abs.Absyn.CatchBranch.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.CatchBranc) {
      bnfc.abs.Absyn.CatchBranc x = (bnfc.abs.Absyn.CatchBranc)o;
      return this.pattern_.equals(x.pattern_) && this.stm_.equals(x.stm_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.pattern_.hashCode())+this.stm_.hashCode();
  }


}
