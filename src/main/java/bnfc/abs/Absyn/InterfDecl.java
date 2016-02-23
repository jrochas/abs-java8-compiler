package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class InterfDecl extends Decl {
  public final Ann ann_;
  public final String uident_;
  public final ListMethSignat listmethsignat_;
  public InterfDecl(Ann p1, String p2, ListMethSignat p3) { ann_ = p1; uident_ = p2; listmethsignat_ = p3; }

  public <R,A> R accept(bnfc.abs.Absyn.Decl.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.InterfDecl) {
      bnfc.abs.Absyn.InterfDecl x = (bnfc.abs.Absyn.InterfDecl)o;
      return this.ann_.equals(x.ann_) && this.uident_.equals(x.uident_) && this.listmethsignat_.equals(x.listmethsignat_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.ann_.hashCode())+this.uident_.hashCode())+this.listmethsignat_.hashCode();
  }


}
