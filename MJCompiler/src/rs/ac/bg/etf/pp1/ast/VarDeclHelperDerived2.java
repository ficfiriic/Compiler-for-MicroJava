// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:18


package rs.ac.bg.etf.pp1.ast;

public class VarDeclHelperDerived2 extends VarDeclHelper {

    private VarDeclName VarDeclName;

    public VarDeclHelperDerived2 (VarDeclName VarDeclName) {
        this.VarDeclName=VarDeclName;
        if(VarDeclName!=null) VarDeclName.setParent(this);
    }

    public VarDeclName getVarDeclName() {
        return VarDeclName;
    }

    public void setVarDeclName(VarDeclName VarDeclName) {
        this.VarDeclName=VarDeclName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclName!=null) VarDeclName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclName!=null) VarDeclName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclName!=null) VarDeclName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclHelperDerived2(\n");

        if(VarDeclName!=null)
            buffer.append(VarDeclName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclHelperDerived2]");
        return buffer.toString();
    }
}
