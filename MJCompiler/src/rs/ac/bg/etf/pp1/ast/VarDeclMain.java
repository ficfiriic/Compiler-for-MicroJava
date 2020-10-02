// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class VarDeclMain extends VarDecl {

    private VarDeclTemp VarDeclTemp;

    public VarDeclMain (VarDeclTemp VarDeclTemp) {
        this.VarDeclTemp=VarDeclTemp;
        if(VarDeclTemp!=null) VarDeclTemp.setParent(this);
    }

    public VarDeclTemp getVarDeclTemp() {
        return VarDeclTemp;
    }

    public void setVarDeclTemp(VarDeclTemp VarDeclTemp) {
        this.VarDeclTemp=VarDeclTemp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclTemp!=null) VarDeclTemp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclTemp!=null) VarDeclTemp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclTemp!=null) VarDeclTemp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclMain(\n");

        if(VarDeclTemp!=null)
            buffer.append(VarDeclTemp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclMain]");
        return buffer.toString();
    }
}
