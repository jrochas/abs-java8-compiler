package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class ClassParamImplements extends Decl {
  public final Ann ann_;
  public final String uident_;
  public final ListParam listparam_;
  public final ListQType listqtype_;
  public final ListClassBody listclassbody_1, listclassbody_2;
  public final MaybeBlock maybeblock_;
  public ClassParamImplements(Ann p1, String p2, ListParam p3, ListQType p4, ListClassBody p5, MaybeBlock p6, ListClassBody p7) { ann_ = p1; uident_ = p2; listparam_ = p3; listqtype_ = p4; listclassbody_1 = p5; maybeblock_ = p6; listclassbody_2 = p7; }

  public <R,A> R accept(bnfc.abs.Absyn.Decl.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.ClassParamImplements) {
      bnfc.abs.Absyn.ClassParamImplements x = (bnfc.abs.Absyn.ClassParamImplements)o;
      return this.ann_.equals(x.ann_) && this.uident_.equals(x.uident_) && this.listparam_.equals(x.listparam_) && this.listqtype_.equals(x.listqtype_) && this.listclassbody_1.equals(x.listclassbody_1) && this.maybeblock_.equals(x.maybeblock_) && this.listclassbody_2.equals(x.listclassbody_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(37*(37*(37*(37*(this.ann_.hashCode())+this.uident_.hashCode())+this.listparam_.hashCode())+this.listqtype_.hashCode())+this.listclassbody_1.hashCode())+this.maybeblock_.hashCode())+this.listclassbody_2.hashCode();
  }


}
