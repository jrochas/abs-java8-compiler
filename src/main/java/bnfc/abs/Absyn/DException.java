package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class DException extends Decl {
  public final ConstrIdent constrident_;
  public DException(ConstrIdent p1) { constrident_ = p1; }

  public <R,A> R accept(bnfc.abs.Absyn.Decl.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.DException) {
      bnfc.abs.Absyn.DException x = (bnfc.abs.Absyn.DException)o;
      return this.constrident_.equals(x.constrident_);
    }
    return false;
  }

  public int hashCode() {
    return this.constrident_.hashCode();
  }


}
