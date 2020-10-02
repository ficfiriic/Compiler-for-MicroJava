// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:20


package rs.ac.bg.etf.pp1.ast;

public class NumConst extends Factor {

    private FactNumConst FactNumConst;

    public NumConst (FactNumConst FactNumConst) {
        this.FactNumConst=FactNumConst;
        if(FactNumConst!=null) FactNumConst.setParent(this);
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
        if(FactNumConst!=null) FactNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactNumConst!=null) FactNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactNumConst!=null) FactNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NumConst(\n");

        if(FactNumConst!=null)
            buffer.append(FactNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumConst]");
        return buffer.toString();
    }
}
