package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class Bloc extends Block {
  public final ListStm liststm_;
  public Bloc(ListStm p1) { liststm_ = p1; }

  public <R,A> R accept(bnfc.abs.Absyn.Block.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.Bloc) {
      bnfc.abs.Absyn.Bloc x = (bnfc.abs.Absyn.Bloc)o;
      return this.liststm_.equals(x.liststm_);
    }
    return false;
  }

  public int hashCode() {
    return this.liststm_.hashCode();
  }


}
