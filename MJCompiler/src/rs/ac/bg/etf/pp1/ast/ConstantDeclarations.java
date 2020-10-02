// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:18


package rs.ac.bg.etf.pp1.ast;

public class ConstantDeclarations extends ConstDeclTemp {

    private ConstDeclTemp ConstDeclTemp;
    private ConstDeclHelper ConstDeclHelper;

    public ConstantDeclarations (ConstDeclTemp ConstDeclTemp, ConstDeclHelper ConstDeclHelper) {
        this.ConstDeclTemp=ConstDeclTemp;
        if(ConstDeclTemp!=null) ConstDeclTemp.setParent(this);
        this.ConstDeclHelper=ConstDeclHelper;
        if(ConstDeclHelper!=null) ConstDeclHelper.setParent(this);
    }

    public ConstDeclTemp getConstDeclTemp() {
        return ConstDeclTemp;
    }

    public void setConstDeclTemp(ConstDeclTemp ConstDeclTemp) {
        this.ConstDeclTemp=ConstDeclTemp;
    }

    public ConstDeclHelper getConstDeclHelper() {
        return ConstDeclHelper;
    }

    public void setConstDeclHelper(ConstDeclHelper ConstDeclHelper) {
        this.ConstDeclHelper=ConstDeclHelper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclTemp!=null) ConstDeclTemp.accept(visitor);
        if(ConstDeclHelper!=null) ConstDeclHelper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclTemp!=null) ConstDeclTemp.traverseTopDown(visitor);
        if(ConstDeclHelper!=null) ConstDeclHelper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclTemp!=null) ConstDeclTemp.traverseBottomUp(visitor);
        if(ConstDeclHelper!=null) ConstDeclHelper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantDeclarations(\n");

        if(ConstDeclTemp!=null)
            buffer.append(ConstDeclTemp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclHelper!=null)
            buffer.append(ConstDeclHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantDeclarations]");
        return buffer.toString();
    }
}
