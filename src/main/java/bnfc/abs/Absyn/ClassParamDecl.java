package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class ClassParamDecl extends Decl {
  public final String uident_;
  public final ListParam listparam_;
  public final ListClassBody listclassbody_1, listclassbody_2;
  public final MaybeBlock maybeblock_;
  public ClassParamDecl(String p1, ListParam p2, ListClassBody p3, MaybeBlock p4, ListClassBody p5) { uident_ = p1; listparam_ = p2; listclassbody_1 = p3; maybeblock_ = p4; listclassbody_2 = p5; }

  public <R,A> R accept(bnfc.abs.Absyn.Decl.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.ClassParamDecl) {
      bnfc.abs.Absyn.ClassParamDecl x = (bnfc.abs.Absyn.ClassParamDecl)o;
      return this.uident_.equals(x.uident_) && this.listparam_.equals(x.listparam_) && this.listclassbody_1.equals(x.listclassbody_1) && this.maybeblock_.equals(x.maybeblock_) && this.listclassbody_2.equals(x.listclassbody_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(37*(37*(this.uident_.hashCode())+this.listparam_.hashCode())+this.listclassbody_1.hashCode())+this.maybeblock_.hashCode())+this.listclassbody_2.hashCode();
  }


}
