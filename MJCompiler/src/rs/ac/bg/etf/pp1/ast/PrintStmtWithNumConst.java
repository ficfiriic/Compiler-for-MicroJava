// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class PrintStmtWithNumConst extends Statement {

    private Expr Expr;
    private FactNumConst FactNumConst;

    public PrintStmtWithNumConst (Expr Expr, FactNumConst FactNumConst) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.FactNumConst=FactNumConst;
        if(FactNumConst!=null) FactNumConst.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public FactNumConst getFactNumConst() {
        return FactNumConst;
    }

    public void setFactNumConst(FactNumConst FactNumConst) {
        this.FactNumConst=FactNumConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(FactNumConst!=null) FactNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(FactNumConst!=null) FactNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(FactNumConst!=null) FactNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStmtWithNumConst(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactNumConst!=null)
            buffer.append(FactNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStmtWithNumConst]");
        return buffer.toString();
    }
}
