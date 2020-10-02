// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:18


package rs.ac.bg.etf.pp1.ast;

public class ConstantDeclaration extends ConstDeclTemp {

    private Type Type;
    private ConstDeclHelper ConstDeclHelper;

    public ConstantDeclaration (Type Type, ConstDeclHelper ConstDeclHelper) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstDeclHelper=ConstDeclHelper;
        if(ConstDeclHelper!=null) ConstDeclHelper.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(ConstDeclHelper!=null) ConstDeclHelper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDeclHelper!=null) ConstDeclHelper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDeclHelper!=null) ConstDeclHelper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclHelper!=null)
            buffer.append(ConstDeclHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantDeclaration]");
        return buffer.toString();
    }
}
