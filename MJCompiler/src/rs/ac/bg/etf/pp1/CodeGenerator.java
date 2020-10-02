package rs.ac.bg.etf.pp1;

import java.util.Stack;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.mj.runtime.*;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	int methAdr; //koja je adresa na koju ide procCall
	boolean toIncDec=false;//da li treba da radi inc ili dec
	Stack<Boolean> arrayIndexes = new Stack<>();
	boolean array=false;
	boolean assign=false;
	int index;
	String arrayName="";
	Stack<Integer> neg= new Stack<>();
	Stack<Integer> incDec= new Stack<>(); //1 je za inc, 2 je za dec
	Stack<Integer> toDo= new Stack<>(); //za mul div i mod sta treba da radi
	Struct retType; //koji je tip povratne vrednosti, da bi skinuo ako je void
	Stack<Integer> addOrSub=new Stack<>(); //da li da radi sabiranje ili oduzimanje/ 1 za sabiranje, 2 za oduzimanje
	boolean arrayStackHelper=false;
	boolean newArray=false;
	boolean nonMinus=false;
	
	public static final Struct boolType = new Struct(Struct.Bool, new Struct(Struct.Bool));

	
	
	public int getMainPc(){
		return mainPc;
	}
	
	
	public void visit(PrintStmtWithOutNumConst printStmt){
		if(printStmt.getExpr().struct == Tab.intType || printStmt.getExpr().struct.getKind() == Struct.Bool || (printStmt.getExpr().struct.getKind()==Struct.Array && printStmt.getExpr().struct.getElemType()==Tab.intType)){
			Code.loadConst(5);
			Code.put(Code.print);
		}else{
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	

    public void visit(PrintStmtWithNumConst PrintStmtWithNumConst) { 
    		Code.loadConst(5);
			Code.put(Code.print);
		
    	if(PrintStmtWithNumConst.getExpr().struct == Tab.intType || PrintStmtWithNumConst.getExpr().struct.getKind() == Struct.Bool){
			Code.loadConst(5);
			Code.put(Code.print);
		}else{
			Code.loadConst(1);
			Code.put(Code.bprint);
		}   
    	}

	
	public void visit(FactNumConst FactNumConst){
		
		Obj con = Tab.insert(Obj.Con, "$", FactNumConst.struct);
		con.setLevel(0);
		
		con.setAdr(FactNumConst.getNumValue());
		//index=FactNumConst.getNumValue();
		//arrayIndexes.push(con);
		Code.load(con);
	
	}
	

	public void visit(FactCharConst FactCharConst){
		
		Obj con = Tab.insert(Obj.Con, "$", FactCharConst.struct);
		con.setLevel(0);
		con.setAdr(FactCharConst.getCharValue());
		
		Code.load(con);
	}
	

	public void visit(FactBoolConst FactBoolConst){
		
		FactBoolConst.struct = boolType;
		Obj con = Tab.insert(Obj.Con, "$", FactBoolConst.struct);
		con.setLevel(0);
		int adr=FactBoolConst.getBoolValue()?1:0;
		con.setAdr(adr);
		
		Code.load(con);
	}
	
	public void visit(ConstantDeclarationHelp ConstantDeclarationHelp) { 
    	Obj typeNode = Tab.find(ConstantDeclarationHelp.getConstName());
    		Code.load(typeNode);
	}
    	
	
	public void visit(MethodTypeName methodTypeName){
		
		if("main".equalsIgnoreCase(methodTypeName.getMethName())){
			mainPc = Code.pc;
		}
		methodTypeName.obj.setAdr(Code.pc);
		// Collect arguments and local variables
		SyntaxNode methodNode = methodTypeName.getParent();
	
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount() + varCnt.getCount());
	
	}
	
	public void visit(MethodDeclMain methodDecl){
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	

   public void visit(DesignatorStatement DesignatorStatement) {
	  
	   DesignatorStatement.obj = DesignatorStatement.getDesignator().obj;
	   if (toIncDec) {
		   			Obj ind = new Obj(Obj.Var,"", Tab.intType);
		   			Obj des = new Obj(Obj.Var,"", Tab.intType);
		   			if (DesignatorStatement.getDesignator().obj.getType().getKind()==Struct.Array) {Code.store(ind); Code.load(ind); /*Code.put(Code.aload);*/}

		   			Code.loadConst(1);
	   				
		   			if (DesignatorStatement.getDesignator().obj.getType().getKind()==Struct.Array) {
		   				//System.out.println("Ovde sam 123");
	   					//Code.store(ind);
	   					//Code.store(des);
	   					Code.load(DesignatorStatement.getDesignator().obj);
	   					Code.load(ind);
	   					Code.put(Code.aload);
	   					//if (ind==des) System.out.println("PROBLEMS 3 ");
	   					//Code.load(des);
	   					}

		   			//Code.loadConst(1);
	   				
		   			if(incDec.pop()==1) Code.put(Code.add);
	   				else {Code.put(Code.sub); 
	   				if (DesignatorStatement.getDesignator().obj.getType().getKind()==Struct.Array)	Code.put(Code.neg);}
	   			//	if (ind==des) System.out.println("PROBLEMS 1 ");
	   				/*Code.load(ind);
	   				if (DesignatorStatement.getDesignator().obj.getType().getKind()==Struct.Array) {
	   					System.out.println("Ovde sam 123");
	   					Code.store(ind);
	   					Code.store(des);
	   					Code.load(DesignatorStatement.getDesignator().obj);
	   					Code.load(ind);
	   					if (ind==des) System.out.println("PROBLEMS 3 ");
	   					Code.load(des);
	   					}*/
	   				}
	   toIncDec=false;
	   }
	
	
	public void visit(Assignment assignment){
		if (assignment.getDesignatorStatement().getDesignator().obj.getType().getKind()==Struct.Array && newArray==false) {array=true;/*System.out.println("ulazim kao niz "+assignment.getDesignatorStatement().getDesignator().getDesName());*/}
		else {/*System.out.println("NE ulazim kao niz "+assignment.getDesignatorStatement().getDesignator().getDesName());*/array=false;}
		//System.out.println("Ulazim u ass kap " + assignment.getDesignatorStatement().getDesignator().obj.getKind()+" array je " + array);
		
		/*if (arrayIndexes.empty()) array=false;
		else array=true;*/
		
		if (array) { 
			//System.out.println("Array ass " + assignment.getDesignatorStatement().getDesignator().getDesName());
			Code.store(new Obj(Obj.Elem, assignment.getDesignatorStatement().getDesignator().getDesName(), new Struct(Struct.Array,assignment.getDesignatorStatement().getDesignator().obj.getType().getElemType())));
		}else {
		//System.out.println("Not Array ass " + assignment.getDesignatorStatement().getDesignator().getDesName());
		Code.store(assignment.getDesignatorStatement().obj);}
		
		array=false;assign=false;/*System.out.println("Postavljam assign i array na false");*/
		newArray=false;
		
	}
	
	public void visit(ArrayPartHelper ArrayPartHelper) { array=true; arrayStackHelper=true; /*System.out.println("Ovde sam [] i array=true");*/
														arrayIndexes.push(true);	}
	
	
	public void visit(Designator designator){
		SyntaxNode parent = designator.getParent();
		if (arrayStackHelper) {
			//ovde ulazim samo ako sam bila u []
		Obj des = new Obj(Obj.Var,"", Tab.intType);
		//if (min) {min=false; Code.put(Code.neg); neg.push(1);}
		Code.store(des);
		//Code.put(Code.pop);
		Code.load(designator.obj);
		Code.load(des);
		
		if (DesignatorStatement.class != parent.getClass() && ReadStmt.class != parent.getClass()) {/*System.out.println("Uzimam vrednost niza " + designator.getDesName()+" array=false");*/Code.put(Code.aload);array=false;/*arrayIndexes.pop();*/}
		else if (DesignatorStatement.class == parent.getClass()) {array=true;/*System.out.println("array=true");*/}
		
		/*
		 * gore je bilo assign
		Obj con = Tab.insert(Obj.Con, "$", new Struct(Struct.Int));
		con.setLevel(0);
		con.setAdr(index);
		
		Code.load(con);*/
		arrayStackHelper=false;
		
		}
		else
			if(Assignment.class != parent.getClass() && FuncCall.class != parent.getClass() && ProcCall.class != parent.getClass()){
				
				//System.out.println("Usao sam ovde  "+ designator.getDesName());
				Code.load(designator.obj);
			}
			
		if (designator.obj.getKind()==Obj.Meth) {methAdr = designator.obj.getAdr(); retType = designator.obj.getType();}
		
		//if (designator.obj.getType().getKind()==Struct.Array) {array=true; arrayName = designator.getDesName();}
		//assign=false;
		//min=false;
	}
	
	
	public void visit(FuncCall funcCall){
		Obj functionObj = funcCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		
		Code.put2(offset);
	}
	
	
	public void visit(ProcCall procCall){
		//Obj functionObj = procedure;
		//int offset = functionObj.getAdr() - Code.pc;
		int offset = methAdr - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		if(retType != Tab.noType){
			Code.put(Code.pop);
		}
	}
	
	public void visit(ReturnExpr returnExpr){
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(ReturnNoExpr returnNoExpr){
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(Subop Subop) { addOrSub.push(2); }
    public void visit(Addop Addop) { addOrSub.push(1); }
    
	
	public void visit(AddExpr addExpr){
		int option = addOrSub.pop();
		if (option==1) Code.put(Code.add);
		else Code.put(Code.sub);
		
	}
	
	public void visit(Modop Modop) { toDo.push(1); }
    public void visit(Divop Divop) { toDo.push(2); }
    public void visit(Multipleop Multipleop) { toDo.push(3); }
    
	
	public void visit(MulTerm MulTerm) {
		int option = toDo.pop();
		switch (option) {
		case 1: Code.put(Code.rem); break;
		case 2:Code.put(Code.div); break;
		case 3:Code.put(Code.mul); break;
			default:
		}
	}
	

    public void visit(DesignatorStatementHelperInc DesignatorStatementHelperInc) { toIncDec=true; incDec.push(1);}

    public void visit(DesignatorStatementHelperDec DesignatorStatementHelperDec) { toIncDec=true; incDec.push(2); }
    

    public void visit(NonMinus NonMinus) { nonMinus=true; }
    
    public void visit(Minus Minus) { neg.push(1); }
    

    public void visit(TermMain TermMain) {if (nonMinus==false && neg.isEmpty()==false && neg.pop()==1) {Code.put(Code.neg);}
    nonMinus=false;										
    }
    

    public void visit(NewWithSquare NewWithSquare) { 
    	Code.put(Code.newarray);
    	int toPut = (NewWithSquare.getType().struct==Tab.charType) ? 0:1;
    	Code.put(toPut);
    	newArray = true;
    }
    
    public void visit(Assignop Assignop) { /*System.out.println("Postavljam assign na true"); */ assign=true; }
    
    public void visit(ReadStmt ReadStmt) { 
    	
    	if (ReadStmt.getDesignator().obj.getType().getKind()==Struct.Int || ReadStmt.getDesignator().obj.getType().getKind()==Struct.Bool) Code.put(Code.read);
    		else if (ReadStmt.getDesignator().obj.getType().getKind()==Struct.Char) Code.put(Code.bread);
    
    	
    	if (ReadStmt.getDesignator().obj.getType().getKind()==Struct.Array && ReadStmt.getDesignator().obj.getType().getElemType()==Tab.intType) {
    		//Code.put(Code.pop);
    		Code.put(Code.read);
    	}else if (ReadStmt.getDesignator().obj.getType().getKind()==Struct.Array && ReadStmt.getDesignator().obj.getType().getElemType()==Tab.charType) {
    		//Code.put(Code.pop);
    		Code.put(Code.bread);
    	}
    	
    	if (ReadStmt.getDesignator().obj.getType().getKind()==Struct.Array)
    			Code.store(new Obj(Obj.Elem, ReadStmt.getDesignator().getDesName(), new Struct(Struct.Array,ReadStmt.getDesignator().obj.getType().getElemType())));
    	else Code.store(ReadStmt.getDesignator().obj);
    }
}
