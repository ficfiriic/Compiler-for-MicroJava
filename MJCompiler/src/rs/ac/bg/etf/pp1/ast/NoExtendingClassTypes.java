// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class NoExtendingClassTypes extends ClassHelperExtending {

    public NoExtendingClassTypes () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoExtendingClassTypes(\n");

        buffer.append(tab);
        buffer.append(") [NoExtendingClassTypes]");
        return buffer.toString();
    }
}
