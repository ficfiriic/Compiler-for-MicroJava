// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:20


package rs.ac.bg.etf.pp1.ast;

public class Relop_lessOrEqual extends Relop {

    public Relop_lessOrEqual () {
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
        buffer.append("Relop_lessOrEqual(\n");

        buffer.append(tab);
        buffer.append(") [Relop_lessOrEqual]");
        return buffer.toString();
    }
}
