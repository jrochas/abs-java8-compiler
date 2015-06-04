package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class FieldClassBody extends ClassBody {
  public final Type type_;
  public final String lident_;
  public FieldClassBody(Type p1, String p2) { type_ = p1; lident_ = p2; }

  public <R,A> R accept(bnfc.abs.Absyn.ClassBody.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.FieldClassBody) {
      bnfc.abs.Absyn.FieldClassBody x = (bnfc.abs.Absyn.FieldClassBody)o;
      return this.type_.equals(x.type_) && this.lident_.equals(x.lident_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.type_.hashCode())+this.lident_.hashCode();
  }


}