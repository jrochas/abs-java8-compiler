package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public abstract class PureExp implements java.io.Serializable {
  public abstract <R,A> R accept(PureExp.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(bnfc.abs.Absyn.EOr p, A arg);
    public R visit(bnfc.abs.Absyn.EAnd p, A arg);
    public R visit(bnfc.abs.Absyn.EEq p, A arg);
    public R visit(bnfc.abs.Absyn.ENeq p, A arg);
    public R visit(bnfc.abs.Absyn.ELt p, A arg);
    public R visit(bnfc.abs.Absyn.ELe p, A arg);
    public R visit(bnfc.abs.Absyn.EGt p, A arg);
    public R visit(bnfc.abs.Absyn.EGe p, A arg);
    public R visit(bnfc.abs.Absyn.EAdd p, A arg);
    public R visit(bnfc.abs.Absyn.ESub p, A arg);
    public R visit(bnfc.abs.Absyn.EMul p, A arg);
    public R visit(bnfc.abs.Absyn.EDiv p, A arg);
    public R visit(bnfc.abs.Absyn.EMod p, A arg);
    public R visit(bnfc.abs.Absyn.ELogNeg p, A arg);
    public R visit(bnfc.abs.Absyn.EIntNeg p, A arg);
    public R visit(bnfc.abs.Absyn.EFunCall p, A arg);
    public R visit(bnfc.abs.Absyn.EQualFunCall p, A arg);
    public R visit(bnfc.abs.Absyn.ENaryFunCall p, A arg);
    public R visit(bnfc.abs.Absyn.ENaryQualFunCall p, A arg);
    public R visit(bnfc.abs.Absyn.EVar p, A arg);
    public R visit(bnfc.abs.Absyn.EThis p, A arg);
    public R visit(bnfc.abs.Absyn.EQualVar p, A arg);
    public R visit(bnfc.abs.Absyn.ESinglConstr p, A arg);
    public R visit(bnfc.abs.Absyn.EParamConstr p, A arg);
    public R visit(bnfc.abs.Absyn.ELit p, A arg);
    public R visit(bnfc.abs.Absyn.Let p, A arg);
    public R visit(bnfc.abs.Absyn.If p, A arg);
    public R visit(bnfc.abs.Absyn.Case p, A arg);

  }

}
