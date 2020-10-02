// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:18


package rs.ac.bg.etf.pp1.ast;

public class CharConstant extends ConstDeclOptions {

    private FactCharConst FactCharConst;

    public CharConstant (FactCharConst FactCharConst) {
        this.FactCharConst=FactCharConst;
        if(FactCharConst!=null) FactCharConst.setParent(this);
    }

    public FactCharConst getFactCharConst() {
        return FactCharConst;
    }

    public void setFactCharConst(FactCharConst FactCharConst) {
        this.FactCharConst=FactCharConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactCharConst!=null) FactCharConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactCharConst!=null) FactCharConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactCharConst!=null) FactCharConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CharConstant(\n");

        if(FactCharConst!=null)
            buffer.append(FactCharConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharConstant]");
        return buffer.toString();
    }
}
