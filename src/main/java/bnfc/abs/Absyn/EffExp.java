package bnfc.abs.Absyn; // Java Package generated by the BNF Converter.

public abstract class EffExp implements java.io.Serializable {
  public abstract <R,A> R accept(EffExp.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(bnfc.abs.Absyn.New p, A arg);
    public R visit(bnfc.abs.Absyn.NewLocal p, A arg);
    public R visit(bnfc.abs.Absyn.SyncMethCall p, A arg);
    public R visit(bnfc.abs.Absyn.ThisSyncMethCall p, A arg);
    public R visit(bnfc.abs.Absyn.AsyncMethCall p, A arg);
    public R visit(bnfc.abs.Absyn.ThisAsyncMethCall p, A arg);
    public R visit(bnfc.abs.Absyn.Get p, A arg);
    public R visit(bnfc.abs.Absyn.Spawns p, A arg);

  }

}
