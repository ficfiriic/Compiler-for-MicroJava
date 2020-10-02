// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:18


package rs.ac.bg.etf.pp1.ast;

public class BoolConstant extends ConstDeclOptions {

    private FactBoolConst FactBoolConst;

    public BoolConstant (FactBoolConst FactBoolConst) {
        this.FactBoolConst=FactBoolConst;
        if(FactBoolConst!=null) FactBoolConst.setParent(this);
    }

    public FactBoolConst getFactBoolConst() {
        return FactBoolConst;
    }

    public void setFactBoolConst(FactBoolConst FactBoolConst) {
        this.FactBoolConst=FactBoolConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactBoolConst!=null) FactBoolConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactBoolConst!=null) FactBoolConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactBoolConst!=null) FactBoolConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BoolConstant(\n");

        if(FactBoolConst!=null)
            buffer.append(FactBoolConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolConstant]");
        return buffer.toString();
    }
}
