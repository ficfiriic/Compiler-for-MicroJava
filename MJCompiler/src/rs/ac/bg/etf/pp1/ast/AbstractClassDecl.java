// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private AbstractClassDeclTemp AbstractClassDeclTemp;
    private ClassHelperExtending ClassHelperExtending;
    private VarDeclList VarDeclList;
    private AbstractClassHelper AbstractClassHelper;

    public AbstractClassDecl (AbstractClassDeclTemp AbstractClassDeclTemp, ClassHelperExtending ClassHelperExtending, VarDeclList VarDeclList, AbstractClassHelper AbstractClassHelper) {
        this.AbstractClassDeclTemp=AbstractClassDeclTemp;
        if(AbstractClassDeclTemp!=null) AbstractClassDeclTemp.setParent(this);
        this.ClassHelperExtending=ClassHelperExtending;
        if(ClassHelperExtending!=null) ClassHelperExtending.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.AbstractClassHelper=AbstractClassHelper;
        if(AbstractClassHelper!=null) AbstractClassHelper.setParent(this);
    }

    public AbstractClassDeclTemp getAbstractClassDeclTemp() {
        return AbstractClassDeclTemp;
    }

    public void setAbstractClassDeclTemp(AbstractClassDeclTemp AbstractClassDeclTemp) {
        this.AbstractClassDeclTemp=AbstractClassDeclTemp;
    }

    public ClassHelperExtending getClassHelperExtending() {
        return ClassHelperExtending;
    }

    public void setClassHelperExtending(ClassHelperExtending ClassHelperExtending) {
        this.ClassHelperExtending=ClassHelperExtending;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public AbstractClassHelper getAbstractClassHelper() {
        return AbstractClassHelper;
    }

    public void setAbstractClassHelper(AbstractClassHelper AbstractClassHelper) {
        this.AbstractClassHelper=AbstractClassHelper;
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
        if(AbstractClassDeclTemp!=null) AbstractClassDeclTemp.accept(visitor);
        if(ClassHelperExtending!=null) ClassHelperExtending.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(AbstractClassHelper!=null) AbstractClassHelper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractClassDeclTemp!=null) AbstractClassDeclTemp.traverseTopDown(visitor);
        if(ClassHelperExtending!=null) ClassHelperExtending.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(AbstractClassHelper!=null) AbstractClassHelper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractClassDeclTemp!=null) AbstractClassDeclTemp.traverseBottomUp(visitor);
        if(ClassHelperExtending!=null) ClassHelperExtending.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(AbstractClassHelper!=null) AbstractClassHelper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDecl(\n");

        if(AbstractClassDeclTemp!=null)
            buffer.append(AbstractClassDeclTemp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassHelperExtending!=null)
            buffer.append(ClassHelperExtending.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbstractClassHelper!=null)
            buffer.append(AbstractClassHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDecl]");
        return buffer.toString();
    }
}
