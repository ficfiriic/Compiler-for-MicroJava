// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:19


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ClassName ClassName;
    private ClassHelperExtending ClassHelperExtending;
    private VarDeclList VarDeclList;
    private ClassHelperMethod ClassHelperMethod;

    public ClassDecl (ClassName ClassName, ClassHelperExtending ClassHelperExtending, VarDeclList VarDeclList, ClassHelperMethod ClassHelperMethod) {
        this.ClassName=ClassName;
        if(ClassName!=null) ClassName.setParent(this);
        this.ClassHelperExtending=ClassHelperExtending;
        if(ClassHelperExtending!=null) ClassHelperExtending.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.ClassHelperMethod=ClassHelperMethod;
        if(ClassHelperMethod!=null) ClassHelperMethod.setParent(this);
    }

    public ClassName getClassName() {
        return ClassName;
    }

    public void setClassName(ClassName ClassName) {
        this.ClassName=ClassName;
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

    public ClassHelperMethod getClassHelperMethod() {
        return ClassHelperMethod;
    }

    public void setClassHelperMethod(ClassHelperMethod ClassHelperMethod) {
        this.ClassHelperMethod=ClassHelperMethod;
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
        if(ClassName!=null) ClassName.accept(visitor);
        if(ClassHelperExtending!=null) ClassHelperExtending.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(ClassHelperMethod!=null) ClassHelperMethod.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassName!=null) ClassName.traverseTopDown(visitor);
        if(ClassHelperExtending!=null) ClassHelperExtending.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(ClassHelperMethod!=null) ClassHelperMethod.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassName!=null) ClassName.traverseBottomUp(visitor);
        if(ClassHelperExtending!=null) ClassHelperExtending.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(ClassHelperMethod!=null) ClassHelperMethod.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        if(ClassName!=null)
            buffer.append(ClassName.toString("  "+tab));
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

        if(ClassHelperMethod!=null)
            buffer.append(ClassHelperMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
