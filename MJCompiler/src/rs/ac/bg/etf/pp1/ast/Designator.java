// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String desName;
    private DesignatorHelperList DesignatorHelperList;

    public Designator (String desName, DesignatorHelperList DesignatorHelperList) {
        this.desName=desName;
        this.DesignatorHelperList=DesignatorHelperList;
        if(DesignatorHelperList!=null) DesignatorHelperList.setParent(this);
    }

    public String getDesName() {
        return desName;
    }

    public void setDesName(String desName) {
        this.desName=desName;
    }

    public DesignatorHelperList getDesignatorHelperList() {
        return DesignatorHelperList;
    }

    public void setDesignatorHelperList(DesignatorHelperList DesignatorHelperList) {
        this.DesignatorHelperList=DesignatorHelperList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorHelperList!=null) DesignatorHelperList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorHelperList!=null) DesignatorHelperList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorHelperList!=null) DesignatorHelperList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        buffer.append(" "+tab+desName);
        buffer.append("\n");

        if(DesignatorHelperList!=null)
            buffer.append(DesignatorHelperList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
