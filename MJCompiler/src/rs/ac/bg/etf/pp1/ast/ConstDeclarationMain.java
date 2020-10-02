// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:18


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationMain extends ConstDecl {

    private ConstDeclTemp ConstDeclTemp;

    public ConstDeclarationMain (ConstDeclTemp ConstDeclTemp) {
        this.ConstDeclTemp=ConstDeclTemp;
        if(ConstDeclTemp!=null) ConstDeclTemp.setParent(this);
    }

    public ConstDeclTemp getConstDeclTemp() {
        return ConstDeclTemp;
    }

    public void setConstDeclTemp(ConstDeclTemp ConstDeclTemp) {
        this.ConstDeclTemp=ConstDeclTemp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclTemp!=null) ConstDeclTemp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclTemp!=null) ConstDeclTemp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclTemp!=null) ConstDeclTemp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationMain(\n");

        if(ConstDeclTemp!=null)
            buffer.append(ConstDeclTemp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationMain]");
        return buffer.toString();
    }
}
