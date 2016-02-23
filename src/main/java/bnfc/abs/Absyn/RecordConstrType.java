package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public class RecordConstrType extends ConstrType {
  public final Type type_;
  public final String lident_;
  public RecordConstrType(Type p1, String p2) { type_ = p1; lident_ = p2; }

  public <R,A> R accept(bnfc.abs.Absyn.ConstrType.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof bnfc.abs.Absyn.RecordConstrType) {
      bnfc.abs.Absyn.RecordConstrType x = (bnfc.abs.Absyn.RecordConstrType)o;
      return this.type_.equals(x.type_) && this.lident_.equals(x.lident_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.type_.hashCode())+this.lident_.hashCode();
  }


}
