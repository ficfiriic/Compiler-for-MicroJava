// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class TermExpr extends Expr {

    private MayMinus MayMinus;
    private Term Term;

    public TermExpr (MayMinus MayMinus, Term Term) {
        this.MayMinus=MayMinus;
        if(MayMinus!=null) MayMinus.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public MayMinus getMayMinus() {
        return MayMinus;
    }

    public void setMayMinus(MayMinus MayMinus) {
        this.MayMinus=MayMinus;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MayMinus!=null) MayMinus.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MayMinus!=null) MayMinus.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MayMinus!=null) MayMinus.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermExpr(\n");

        if(MayMinus!=null)
            buffer.append(MayMinus.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermExpr]");
        return buffer.toString();
    }
}
