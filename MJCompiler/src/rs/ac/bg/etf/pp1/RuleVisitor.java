package rs.ac.bg.etf.pp1;

import org.apache.log4j.*;
import rs.ac.bg.etf.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor{
	
	int printCallCount = 0;
	int ConstCallCount = 0;
	int VarCallCount = 0;
	int ClassCallCount = 0;
	int MethodCnt = 0;
	int MethodListCnt = 0;
	
	public void visit(PrintStmtWithOutNumConst PrintStmtWithOutNumConst) { 
		
		printCallCount++;
	}
	

    public void visit(VarDeclMain VarDeclMain) { VarCallCount++;}
    

    public void visit(ConstDeclarationMain ConstDeclarationMain) {ConstCallCount++; }
    
    public void visit(ClassDecl ClassDecl) { ClassCallCount++; }
    
    public void visit(MethodDeclMain MethodDeclMain) { MethodCnt++;}
    
    public void visit(MethodDeclarations MethodDeclarations) { MethodListCnt++; }
}
