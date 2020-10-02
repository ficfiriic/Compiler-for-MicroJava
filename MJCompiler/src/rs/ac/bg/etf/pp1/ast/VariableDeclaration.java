// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class VariableDeclaration extends VarDeclTemp {

    private Type Type;
    private VarDeclHelper VarDeclHelper;

    public VariableDeclaration (Type Type, VarDeclHelper VarDeclHelper) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDeclHelper=VarDeclHelper;
        if(VarDeclHelper!=null) VarDeclHelper.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarDeclHelper getVarDeclHelper() {
        return VarDeclHelper;
    }

    public void setVarDeclHelper(VarDeclHelper VarDeclHelper) {
        this.VarDeclHelper=VarDeclHelper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarDeclHelper!=null) VarDeclHelper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDeclHelper!=null) VarDeclHelper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDeclHelper!=null) VarDeclHelper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclHelper!=null)
            buffer.append(VarDeclHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableDeclaration]");
        return buffer.toString();
    }
}
