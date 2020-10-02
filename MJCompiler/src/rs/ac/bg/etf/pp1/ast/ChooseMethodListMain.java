// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class ChooseMethodListMain extends ChooseMethodList {

    private ChooseMethodList ChooseMethodList;
    private ChooseMethod ChooseMethod;

    public ChooseMethodListMain (ChooseMethodList ChooseMethodList, ChooseMethod ChooseMethod) {
        this.ChooseMethodList=ChooseMethodList;
        if(ChooseMethodList!=null) ChooseMethodList.setParent(this);
        this.ChooseMethod=ChooseMethod;
        if(ChooseMethod!=null) ChooseMethod.setParent(this);
    }

    public ChooseMethodList getChooseMethodList() {
        return ChooseMethodList;
    }

    public void setChooseMethodList(ChooseMethodList ChooseMethodList) {
        this.ChooseMethodList=ChooseMethodList;
    }

    public ChooseMethod getChooseMethod() {
        return ChooseMethod;
    }

    public void setChooseMethod(ChooseMethod ChooseMethod) {
        this.ChooseMethod=ChooseMethod;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ChooseMethodList!=null) ChooseMethodList.accept(visitor);
        if(ChooseMethod!=null) ChooseMethod.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ChooseMethodList!=null) ChooseMethodList.traverseTopDown(visitor);
        if(ChooseMethod!=null) ChooseMethod.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ChooseMethodList!=null) ChooseMethodList.traverseBottomUp(visitor);
        if(ChooseMethod!=null) ChooseMethod.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ChooseMethodListMain(\n");

        if(ChooseMethodList!=null)
            buffer.append(ChooseMethodList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ChooseMethod!=null)
            buffer.append(ChooseMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ChooseMethodListMain]");
        return buffer.toString();
    }
}
