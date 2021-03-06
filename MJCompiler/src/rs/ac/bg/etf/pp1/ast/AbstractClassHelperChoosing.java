// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassHelperChoosing extends AbstractClassHelper {

    private ChooseMethodList ChooseMethodList;

    public AbstractClassHelperChoosing (ChooseMethodList ChooseMethodList) {
        this.ChooseMethodList=ChooseMethodList;
        if(ChooseMethodList!=null) ChooseMethodList.setParent(this);
    }

    public ChooseMethodList getChooseMethodList() {
        return ChooseMethodList;
    }

    public void setChooseMethodList(ChooseMethodList ChooseMethodList) {
        this.ChooseMethodList=ChooseMethodList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ChooseMethodList!=null) ChooseMethodList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ChooseMethodList!=null) ChooseMethodList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ChooseMethodList!=null) ChooseMethodList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassHelperChoosing(\n");

        if(ChooseMethodList!=null)
            buffer.append(ChooseMethodList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassHelperChoosing]");
        return buffer.toString();
    }
}
