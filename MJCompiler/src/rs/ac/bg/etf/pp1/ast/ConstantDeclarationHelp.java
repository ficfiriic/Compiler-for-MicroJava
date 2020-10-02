// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:18


package rs.ac.bg.etf.pp1.ast;

public class ConstantDeclarationHelp extends ConstDeclHelper {

    private String constName;
    private ConstDeclOptions ConstDeclOptions;

    public ConstantDeclarationHelp (String constName, ConstDeclOptions ConstDeclOptions) {
        this.constName=constName;
        this.ConstDeclOptions=ConstDeclOptions;
        if(ConstDeclOptions!=null) ConstDeclOptions.setParent(this);
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public ConstDeclOptions getConstDeclOptions() {
        return ConstDeclOptions;
    }

    public void setConstDeclOptions(ConstDeclOptions ConstDeclOptions) {
        this.ConstDeclOptions=ConstDeclOptions;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclOptions!=null) ConstDeclOptions.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclOptions!=null) ConstDeclOptions.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclOptions!=null) ConstDeclOptions.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantDeclarationHelp(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        if(ConstDeclOptions!=null)
            buffer.append(ConstDeclOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantDeclarationHelp]");
        return buffer.toString();
    }
}
