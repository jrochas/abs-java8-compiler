package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class DataDecl extends Decl {
  public final String uident_;
  public final ListConstrIdent listconstrident_;
  public DataDecl(String p1, ListConstrIdent p2) { uident_ = p1; listconstrident_ = p2; }

  public <R,A> R accept(bnfc.abs.Absyn.Decl.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.DataDecl) {
      bnfc.abs.Absyn.DataDecl x = (bnfc.abs.Absyn.DataDecl)o;
      return this.uident_.equals(x.uident_) && this.listconstrident_.equals(x.listconstrident_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.uident_.hashCode())+this.listconstrident_.hashCode();
  }


}