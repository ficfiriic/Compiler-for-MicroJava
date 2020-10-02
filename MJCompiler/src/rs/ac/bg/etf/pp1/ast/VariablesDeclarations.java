// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class VariablesDeclarations extends VarDeclTemp {

    private VarDeclTemp VarDeclTemp;
    private VarDeclHelper VarDeclHelper;

    public VariablesDeclarations (VarDeclTemp VarDeclTemp, VarDeclHelper VarDeclHelper) {
        this.VarDeclTemp=VarDeclTemp;
        if(VarDeclTemp!=null) VarDeclTemp.setParent(this);
        this.VarDeclHelper=VarDeclHelper;
        if(VarDeclHelper!=null) VarDeclHelper.setParent(this);
    }

    public VarDeclTemp getVarDeclTemp() {
        return VarDeclTemp;
    }

    public void setVarDeclTemp(VarDeclTemp VarDeclTemp) {
        this.VarDeclTemp=VarDeclTemp;
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
        if(VarDeclTemp!=null) VarDeclTemp.accept(visitor);
        if(VarDeclHelper!=null) VarDeclHelper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclTemp!=null) VarDeclTemp.traverseTopDown(visitor);
        if(VarDeclHelper!=null) VarDeclHelper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclTemp!=null) VarDeclTemp.traverseBottomUp(visitor);
        if(VarDeclHelper!=null) VarDeclHelper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariablesDeclarations(\n");

        if(VarDeclTemp!=null)
            buffer.append(VarDeclTemp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclHelper!=null)
            buffer.append(VarDeclHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariablesDeclarations]");
        return buffer.toString();
    }
}
