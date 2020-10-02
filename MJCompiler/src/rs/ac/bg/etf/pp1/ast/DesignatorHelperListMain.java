// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class DesignatorHelperListMain extends DesignatorHelperList {

    private DesignatorHelperList DesignatorHelperList;
    private DesignatorHelper DesignatorHelper;

    public DesignatorHelperListMain (DesignatorHelperList DesignatorHelperList, DesignatorHelper DesignatorHelper) {
        this.DesignatorHelperList=DesignatorHelperList;
        if(DesignatorHelperList!=null) DesignatorHelperList.setParent(this);
        this.DesignatorHelper=DesignatorHelper;
        if(DesignatorHelper!=null) DesignatorHelper.setParent(this);
    }

    public DesignatorHelperList getDesignatorHelperList() {
        return DesignatorHelperList;
    }

    public void setDesignatorHelperList(DesignatorHelperList DesignatorHelperList) {
        this.DesignatorHelperList=DesignatorHelperList;
    }

    public DesignatorHelper getDesignatorHelper() {
        return DesignatorHelper;
    }

    public void setDesignatorHelper(DesignatorHelper DesignatorHelper) {
        this.DesignatorHelper=DesignatorHelper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorHelperList!=null) DesignatorHelperList.accept(visitor);
        if(DesignatorHelper!=null) DesignatorHelper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorHelperList!=null) DesignatorHelperList.traverseTopDown(visitor);
        if(DesignatorHelper!=null) DesignatorHelper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorHelperList!=null) DesignatorHelperList.traverseBottomUp(visitor);
        if(DesignatorHelper!=null) DesignatorHelper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorHelperListMain(\n");

        if(DesignatorHelperList!=null)
            buffer.append(DesignatorHelperList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorHelper!=null)
            buffer.append(DesignatorHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorHelperListMain]");
        return buffer.toString();
    }
}
