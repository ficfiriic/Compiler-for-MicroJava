package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import org.omg.CORBA.StructMember;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class SemanticAnalyzer extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	int retKind = -1;
	Obj currentMethod = Tab.noObj;
	Obj currentClass = Tab.noObj;
	boolean returnFound = false;
	boolean errorDetected = false;
	boolean varToInsert = false;
	boolean absClass = false;
	boolean foundMain = false;
	boolean incDec = false;
	boolean procCall=false;
	boolean noDesList = false;
	boolean arrayDetectedTemp=false;
	boolean minus = false;
	boolean arrayDetected = false;
	boolean array = false;
	boolean eqNoteq=false;
	int retType=-1;
	int cntArray;
	int nVars;
	Struct varType = null;
	int constValue = -1;
	String className = "";
	SymbolTableVisitor stv;
	
	public static final Struct boolType = new Struct(Struct.Bool, new Struct(Struct.Bool));
	
	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
 
    public void visit(ProgName progName){
    	Obj o = new Obj(Obj.Type, "bool", new Struct(Struct.Bool));
    	Struct type = o.getType();
    	Tab.currentScope.addToLocals(o);
    	progName.obj = Tab.insert(Obj.Prog, progName.getPName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    	if (!foundMain) 
    		report_error("PROBLEM! Main funkcija ili ne postoji ili joj nije dobra povratna vrednost ili ima parametre!", null);
    }
   
    public void visit(Type type){
    	Obj typeNode = Tab.find(type.getTypeName());
    	if(typeNode == Tab.noObj ){
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola na liniji ! "+ type.getLine(), null);
    		type.struct = Tab.noType;
    	}else{
    		if(Obj.Type == typeNode.getKind()){
    			type.struct = typeNode.getType();
    			if (typeNode.getLevel()==-1 && typeNode.getType()!=Tab.charType && typeNode.getType()!=Tab.intType && typeNode.getType().getKind()!=Struct.Bool) report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip, ne moze se instancirati objekat apstraktne klase!", type);
    			//else 
    			varType = type.struct;
    		}else{
    			report_error("Greska na liniji " + type.getLine()+ " : Ime " + type.getTypeName() + " ne predstavlja tip!", null);
    			type.struct = Tab.noType;
    		}
    	}
    }
    
    //ubacivanje promenljivih
    public void visit(VarDeclName VarDeclName) { 
    	//bilo tab.find()
    	Obj typeNode = Tab.currentScope.findSymbol(VarDeclName.getVarName());
    	stv = new DumpSymbolTableVisitor();
    	
    	if(typeNode != null){
    		stv.visitObjNode(typeNode);
    		report_error("Greska na liniji " + VarDeclName.getLine()+" : Promenljiva " + VarDeclName.getVarName() + " vec postoji u tabeli simbola! ---"+stv.getOutput(), null);
    	}else{
    	varDeclCount++;
		report_info("Deklarisana promenljiva "+ VarDeclName.getVarName() + " na liniji: " + VarDeclName.getLine(), null);
		
		}
    }
    

	public void visit(VarDeclHelperDerived1 VarDeclHelperDerived1) {

		if (currentClass == Tab.noObj /*&& currentMethod == Tab.noObj*/) {
				Obj varNode = Tab.insert(Obj.Var, VarDeclHelperDerived1.getVarDeclName().getVarName(), varType);
				//Obj varNode = Tab.currentScope.addToLocals()(Obj.Var, VarDeclHelperDerived1.getVarDeclName().getVarName(), varType);
			} else {
					Obj varNode = Tab.insert(Obj.Fld, VarDeclHelperDerived1.getVarDeclName().getVarName(), varType);
					}
	}
    
    //ubacivanje nizova
    public void visit(VarDeclHelperDerived2 VarDeclHelperDerived2) {
    	
    	if (currentClass == Tab.noObj /*&& currentMethod == Tab.noObj*/) {
			Obj varNode = Tab.insert(Obj.Var, VarDeclHelperDerived2.getVarDeclName().getVarName(), new Struct(Struct.Array, varType));
		} else {
				Obj varNode = Tab.insert(Obj.Fld, VarDeclHelperDerived2.getVarDeclName().getVarName(), new Struct(Struct.Array, varType));
				}
    	}
    
    public void visit(FactCharConst FactCharConst) { constValue = FactCharConst.getCharValue(); FactCharConst.struct = Tab.charType;}
    public void visit(FactBoolConst FactBoolConst) { constValue = (FactBoolConst.getBoolValue() ? 1 : 0 ); FactBoolConst.struct = boolType;}
    public void visit(FactNumConst FactNumConst) { constValue = FactNumConst.getNumValue(); FactNumConst.struct = Tab.intType;}
    
    

    public void visit(ConstantDeclarationHelp ConstantDeclarationHelp) { 
    	Obj typeNode = Tab.find(ConstantDeclarationHelp.getConstName());
    	stv = new DumpSymbolTableVisitor();
    	
    	if(typeNode != Tab.noObj){
    		stv.visitObjNode(typeNode);
        	report_error("Greska na liniji " + ConstantDeclarationHelp.getLine() +" : Promenljiva " + ConstantDeclarationHelp.getConstName() + " vec postoji u tabeli simbola! ****" + stv.getOutput(), null);
    	}else {
    	report_info("Deklarisana konstanta "+ ConstantDeclarationHelp.getConstName()+" na liniji " + ConstantDeclarationHelp.getLine(), null);
		Obj varNode = Tab.insert(Obj.Con, ConstantDeclarationHelp.getConstName(), varType);
		Obj myNode = Tab.find(ConstantDeclarationHelp.getConstName());
		myNode.setAdr(constValue);
    	}
    }
    
    

    public void visit(FormParams FormParams) {
    	
    	if (currentMethod.getName().equals("main")) foundMain = false;
    
    }
    
    public void visit(MethodVoidReturnType MethodVoidReturnType) { varType = Tab.noType; retType = 0; }
    

    public void visit(MethodReturnTypeMain MethodReturnTypeMain) { retType = MethodReturnTypeMain.getType().struct.getKind();  }

    public void visit(MethodTypeName MethodTypeName) { 
    	Obj typeNode = Tab.currentScope().findSymbol(MethodTypeName.getMethName());
    	stv = new DumpSymbolTableVisitor();
    	
    	if(typeNode != null){
    		stv.visitObjNode(typeNode);
    		report_error("Greska na liniji " + MethodTypeName.getLine() +" : Ime funkcije " + MethodTypeName.getMethName() + " nije korektno, vec postoji u tabeli simbola!**** " + stv.getOutput(), null);
    	}else {
    	currentMethod = Tab.insert(Obj.Meth, MethodTypeName.getMethName(), varType);
    	MethodTypeName.obj = currentMethod;
    	
    	if (currentMethod.getName().equals("main") && varType==Tab.noType) foundMain = true;
    	
		report_info("Obradjuje se funkcija " + MethodTypeName.getMethName() + " na liniji " + MethodTypeName.getLine() , null);
    } 
   
    	Tab.openScope();
    }
   
    
    public void visit(MethodDeclMain methodDecl){
    	
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	if (returnFound==false && retType!=0) report_error("Greska na liniji "+methodDecl.getLine() + " : Funkciji " + methodDecl.getMethodTypeName().getMethName()+ " fali return iskaz!", null);
    	returnFound = false;
    	currentMethod = Tab.noObj;
    }
    

    public void visit(ClassName ClassName) { 
    	Obj typeNode = Tab.currentScope().findSymbol(ClassName.getClassName());
    	if(typeNode != null){
    		stv = new DumpSymbolTableVisitor();
        	stv.visitObjNode(typeNode);
        	report_error("Greska na liniji "+ClassName.getLine() + " : Ime klase " + ClassName.getClassName() + " nije korektno, vec postoji u tabeli simbola! **** " + stv.getOutput(), null);
    	}else {
    	currentClass = Tab.insert(Obj.Type, ClassName.getClassName(), new Struct(Struct.Class));
    	report_info("Obradjuje se klasa " + ClassName.getClassName() + " na liniji " + stv.getOutput(), ClassName);
    	
    	}
    	Tab.openScope();
    	
    }
    
    public void visit(ClassDecl ClassDecl) { 
    
    	Tab.chainLocalSymbols(currentClass.getType());
    	Tab.closeScope();
    	currentClass = Tab.noObj;
    	}
    

    public void visit(ClassExtendingTypes ClassExtendingTypes) { 
    	
    	Obj typeNode = Tab.find(ClassExtendingTypes.getType().getTypeName());
    	if(typeNode == null || typeNode.getType().getKind()!=Struct.Class){
    		report_error("Greska na liniji "+ClassExtendingTypes.getLine()+" : Klasa " + ClassExtendingTypes.getType().getTypeName() + " ne postoji! ", null);
    	}    	
    }
    

    public void visit(AbstractMethodDecl AbstractMethodDecl) { 
    	
    	if (!absClass)
    			report_error("Greska na liniji " + AbstractMethodDecl.getLine() +" : Abstraktne metode se mogu naci samo unutar abstraknih klasa!", null);
    
    }


    public void visit(AbstractClassDeclTemp AbstractClassDeclTemp) { 
    	
    	Obj typeNode = Tab.currentScope().findSymbol(AbstractClassDeclTemp.getAbsClassName());
    	if(typeNode != null){
        	report_error("Greska na liniji "+AbstractClassDeclTemp.getLine() + " : Ime klase " + AbstractClassDeclTemp.getAbsClassName() + " nije korektno, vec postoji u tabeli simbola! ", null);
    	}else {
    	currentClass = Tab.insert(Obj.Type, AbstractClassDeclTemp.getAbsClassName(), new Struct(Struct.Class));
    	report_info("Obradjuje se klasa " + AbstractClassDeclTemp.getAbsClassName() + " na liniji " + AbstractClassDeclTemp.getLine(),AbstractClassDeclTemp);
    	Obj Node = Tab.currentScope().findSymbol(AbstractClassDeclTemp.getAbsClassName());
    	Node.setLevel(-1);
    	absClass = true;
    	}
    	Tab.openScope();
}
    
    
    public void visit(AbstractClassDecl AbstractClassDecl) { 
    	
    	Tab.chainLocalSymbols(currentClass.getType());
    	Tab.closeScope();
    	currentClass = Tab.noObj;
    	
    }
    

    public void visit(NewWithOutSquare NewWithOutSquare) { 
    	NewWithOutSquare.struct = NewWithOutSquare.getType().struct;
    	if (NewWithOutSquare.getType().struct.getKind()!=Struct.Class) report_error("Greska na liniji "+NewWithOutSquare.getLine()+": Sa operatorom new mora da se koristi klasa! ", null);
    	
    }
    public void visit(NewWithSquare NewWithSquare) { 
    	NewWithSquare.struct = new Struct(Struct.Array, NewWithSquare.getType().struct);
    	if (NewWithSquare.getType().struct.getKind()!=Struct.Class && NewWithSquare.getType().struct.getKind()!=Struct.Bool && NewWithSquare.getType().struct.getKind()!=Struct.Int && NewWithSquare.getType().struct.getKind()!=Struct.Char ) report_error("Greska na liniji " +NewWithSquare.getLine() + " : Sa operatorom new mora da se koristi klasa, int, char ili bool tip! ", null);
    	if (NewWithSquare.getExpr().struct.getKind()!=Struct.Int) 	report_error("Greska na liniji "+NewWithSquare.getLine() +" : Expr u type mora da bude tipa int! ", null);
    	//retKind = NewWithSquare.struct.getKind();
    	
    }
 
    
    public void visit(ReadStmt ReadStmt) {
    	Struct kind = ReadStmt.getDesignator().obj.getType();
    	if (ReadStmt.getDesignator().obj.getType().getKind() == Struct.Array) kind = ReadStmt.getDesignator().obj.getType().getElemType();
	    if ((ReadStmt.getDesignator().obj.getKind() != Obj.Fld && ReadStmt.getDesignator().obj.getKind() != Obj.Var) || (kind != Tab.intType && kind != Tab.charType && kind.getKind() != Struct.Bool) )
    		report_error("Greska na liniji " + ReadStmt.getLine()+ " : ime "+ReadStmt.getDesignator().getDesName()+" mora da bude tipa bool, char ili int! ", null);
    	
    }


    public void visit(PrintStmtWithNumConst PrintStmtWithNumConst) { 
    	Struct kind = PrintStmtWithNumConst.getExpr().struct;
    	if (PrintStmtWithNumConst.getExpr().struct.getKind() == Struct.Array) kind = PrintStmtWithNumConst.getExpr().struct.getElemType();
	    if ((kind != Tab.intType && kind != Tab.charType && kind.getKind() != Struct.Bool) )
    		report_error("Greska na liniji " + PrintStmtWithNumConst.getLine()+ " : argument print instrukcije mora da bude tipa bool, char ili int! ", null);
   }
    public void visit(PrintStmtWithOutNumConst PrintStmtWithOutNumConst) {
    	Struct kind = PrintStmtWithOutNumConst.getExpr().struct;
    	if (PrintStmtWithOutNumConst.getExpr().struct.getKind() == Struct.Array) kind = PrintStmtWithOutNumConst.getExpr().struct.getElemType();
	    if ((kind != Tab.intType && kind != Tab.charType && kind.getKind() != Struct.Bool) )
			report_error("Greska na liniji " + PrintStmtWithOutNumConst.getLine()+ " : argument print instrukcije mora da bude tipa bool, char ili int! ", null);
	    if (cntArray!=0) cntArray=0;
    }
    
    public void visit(ArrayPartHelper ArrayPartHelper) { 
    	if ((ArrayPartHelper.getExpr().struct.getKind() == Struct.Array && ArrayPartHelper.getExpr().struct.getElemType().getKind() != Struct.Int)||(ArrayPartHelper.getExpr().struct.getKind() != Struct.Int && ArrayPartHelper.getExpr().struct.getKind() != Struct.Array))
			report_error("Greska na liniji " + ArrayPartHelper.getLine()+ ": indeks niza mora biti tipa int! ", null);
    	ArrayPartHelper.struct = ArrayPartHelper.getExpr().struct;
    	arrayDetected = true;//PRISTUPAM ELEMENTU NIZA
    	arrayDetectedTemp = true;
    	cntArray++; //sluzi samo za y=niz[3] i obrnuto, gde su y i niz nizovi int
    	}
    
    public void visit(DesignatorHelperListMain DesignatorHelperListMain) { 
    	//dodeljujem mu obj ArrayPartHelpera
    	DesignatorHelperListMain.struct = DesignatorHelperListMain.getDesignatorHelper().struct;
    	
    }
    

    
    public void visit(Designator designator){
    	Obj obj = Tab.find(designator.getDesName());
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getDesName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    	if (designator.obj.getType().getKind() != Struct.Array && arrayDetectedTemp) report_error("Greska na liniji: " + designator.getLine() +  " : pristup promenljivoj " + designator.getDesName() + " kao da je niz!", null );
    	if (designator.obj.getType().getKind() == Struct.Array && arrayDetectedTemp==false) array = true;
    	//if (noDesList) noDesList=false;*/
    	stv = new DumpSymbolTableVisitor();
    	stv.visitObjNode(designator.obj);
    	report_info("Koristi se promenljiva " + designator.getDesName()+" na liniji "+ designator.getLine() +" **** " +stv.getOutput(), null);
    	arrayDetectedTemp=false;
    }
    
    
    public void visit(FuncCall funcCall){
    	Obj func = funcCall.getDesignator().obj;
    	if(Obj.Meth == func.getKind()){
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
    	}else{
			report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
			funcCall.struct = Tab.noType;
    	}
    }
    

    public void visit(Expression Expression) { 
    	Expression.struct = Expression.getExpr().struct;
    	retKind = Expression.getExpr().struct.getKind();
    }


    public void visit(NumConst NumConst) { NumConst.struct = NumConst.getFactNumConst().struct;  retKind = NumConst.getFactNumConst().struct.getKind(); }
    public void visit(BoolConst BoolConst) { BoolConst.struct = BoolConst.getFactBoolConst().struct; retKind = BoolConst.getFactBoolConst().struct.getKind();}
    public void visit(CharConst CharConst) { CharConst.struct = CharConst.getFactCharConst().struct; retKind = CharConst.getFactCharConst().struct.getKind(); }
    
    
    public void visit(TermMain term){
    	term.struct = term.getFactor().struct;
    }
    
	public void visit(MulTerm MulTerm) {
		Struct te = MulTerm.getTerm().struct;
    	if (MulTerm.getTerm().struct.getKind()==Struct.Array) 
		    	if (array==false) te=MulTerm.getTerm().struct.getElemType();
				else report_error("Greska na liniji " +MulTerm.getLine() + " : mnozenje sa celim nizom!", null);
		Struct t = MulTerm.getFactor().struct;
    	if (MulTerm.getFactor().struct.getKind()==Struct.Array) 
			    	if (array==false) t=MulTerm.getFactor().struct.getElemType();
					else report_error("Greska na liniji "+ MulTerm.getLine() + " : mnozenje sa celim nizom!", null);
    	if (te.equals(t) && te == Tab.intType) {
			MulTerm.struct = te;
			// govorim sta je povratna vrendost onoga sto ja napravim kad saberem
			retKind = Struct.Int;
		} else {
			report_error("Greska na liniji " + MulTerm.getLine() + " : nekompatibilni tipovi u izrazu za mnozenje.",
					null);
			MulTerm.struct = Tab.noType;
		}
	}
    
    public void visit(Minus Minus) { minus = true; }
    
    public void visit(TermExpr termExpr){
    	termExpr.struct = termExpr.getTerm().struct;
    	if (minus && termExpr.getTerm().struct != Tab.intType)
    		report_error("Greska na liniji "+termExpr.getLine() + " : minus moze da se nadje samo ispred int tipa", null);
		minus = false;
    }
    
    public void visit(AddExpr addExpr){
    	//expr addop term
    	Struct te = addExpr.getExpr().struct;
    	if (addExpr.getExpr().struct.getKind()==Struct.Array)
    		if (array==false) te=addExpr.getExpr().struct.getElemType();
    		else report_error("Greska na liniji "+addExpr.getLine() + " : sabiranje sa celim nizom!", null);
    	Struct t = addExpr.getTerm().struct;
    	if (addExpr.getTerm().struct.getKind()==Struct.Array) 
		    	if (array==false) t=addExpr.getTerm().struct.getElemType();
				else report_error("Greska na liniji: "+addExpr.getLine() +  " : sabiranje sa celim nizom!", null);
    	if(te.equals(t) && te == Tab.intType){
    		addExpr.struct = te;
    		//govorim sta je povratna vrendost onoga sto ja napravim kad saberem
    		retKind = Struct.Int;
    	}else{
    		report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
			addExpr.struct = Tab.noType;
    	}
    }
    
    
    public void visit(Var var){
    	var.struct = var.getDesignator().obj.getType();
    	//ako je niz onda treba da tip bude tip elemenata niza
    	if (var.struct.getKind() == Struct.Array) retKind = var.struct.getElemType().getKind();
    	/*else if (var.struct.getKind()==Struct.Class) {retKind = 666;
    												 }*/
    	else retKind = var.getDesignator().obj.getType().getKind();
    }
    
    public void visit(ReturnExpr returnExpr){
    	returnFound = true;
    	Struct currMethType = currentMethod.getType();
    	int currRetKind = currentMethod.getType().getKind();
    	if(!currMethType.compatibleWith(returnExpr.getExpr().struct)){
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + " tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    	}
    	/*if(currRetKind != retType){
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    	}*/
    }
    public void visit(ProcCall ProcCall) { procCall=true; }

    public void visit(DesignatorStatementHelperDec DesignatorStatementHelperDec) { 
    		incDec = true;
    }
    
    public void visit(DesignatorStatementHelperInc DesignatorStatementHelperInc) {
    		incDec = true;
    }
    
    public void visit(DesignatorStatementHelperEqual DesignatorStatementHelperEqual) { 
    	
    	DesignatorStatementHelperEqual.struct = DesignatorStatementHelperEqual.getExpr().struct;
    	//uzimam povratnu vrenost, imam samo jedan operand Expr
    	if (DesignatorStatementHelperEqual.getExpr().struct.getKind()==Struct.Array) retKind = DesignatorStatementHelperEqual.getExpr().struct.getElemType().getKind();
    	//else if (DesignatorStatementHelperEqual.getExpr().struct.getKind()==Struct.Class) {retKind = 666;}
    	else retKind = DesignatorStatementHelperEqual.getExpr().struct.getKind();
    }


    public void visit(DesignatorStatement DesignatorStatement) { 
    	
    	if (incDec) {
    		if (DesignatorStatement.getDesignator().obj.getType().getKind() == Struct.Array && DesignatorStatement.getDesignator().obj.getType().getElemType() != Tab.intType)
    			report_error("Greska(Niz) na liniji "+DesignatorStatement.getLine() + ": ++/-- operacije mogu da stoje samo uz globalne ili lokalne int promenljive!", null);
    		else
    		if (arrayDetected==false && DesignatorStatement.getDesignator().obj.getType()!=Tab.intType || (DesignatorStatement.getDesignator().obj.getKind() != Obj.Var && DesignatorStatement.getDesignator().obj.getKind()!=Obj.Fld))
    			report_error("Greska na liniji " + DesignatorStatement.getLine() + " : ++/-- operacije mogu da stoje samo uz globalne ili lokalne int promenljive!", null);
        }
    	
    	if (!incDec) {
    		//detektovani niz
    		if (DesignatorStatement.getDesignator().obj.getType().compatibleWith(DesignatorStatement.getDesignatorStatementHelper().struct))
    			{//ako si isti po tipu i onda samo ono sranje
    			//uvde ulazi samo ako su dva prosta tipa ista ili ako su elementi niza isti
    			if (cntArray==1 && DesignatorStatement.getDesignator().obj.getType().getKind()==Struct.Array && DesignatorStatement.getDesignatorStatementHelper().struct.getKind()==Struct.Array) report_error("Greska na liniji " +DesignatorStatement.getLine() +  " : pokusaj dodele vrednosti ne niza nizu!", null);
    			else if (cntArray==1 && DesignatorStatement.getDesignator().obj.getType().getKind()==Struct.Array && DesignatorStatement.getDesignatorStatementHelper().struct==Tab.nullType) report_error("Greska na liniji " +DesignatorStatement.getLine() + " : nekompatibilni tipovi pri dodeli vrednosti elementu niza! v1", null);
    			else if (DesignatorStatement.getDesignator().obj.getKind()==Obj.Con) report_error("Greska na liniji "+ DesignatorStatement.getLine()+" : dodela vrednosti konstanti", null);
    			//else if (retKind==666 && DesignatorStatement.getDesignator().obj.getName().compareTo(className)!=0) report_error("Greska! Dodela vrednosti klasama", null);
    			}
    		else
    	
    		//pitam samo ovako, jer array moze da se postavi samo ako je levo od 
    			if (array)  report_error("Greska na liniji " + DesignatorStatement.getLine()+" : niz!", null);
    			else if (DesignatorStatement.getDesignator().obj.getType().getKind()==Struct.Array && DesignatorStatement.getDesignator().obj.getType().getElemType().getKind()!= retKind) report_error("Greska na liniji " + DesignatorStatement.getLine()+ " : nekompatibilni tipovi pri dodeli vrednosti elementu nizaa!", null);
    			else if (DesignatorStatement.getDesignator().obj.getType().getKind()==Struct.Class && (DesignatorStatement.getDesignatorStatementHelper().struct.getKind()==Struct.Class || DesignatorStatement.getDesignatorStatementHelper().struct.getKind()==Struct.Array)) report_error("Greska na liniji "+DesignatorStatement.getLine() + ": nekompatibilni tipovi klasa!", null);
    			else if (arrayDetected==false && procCall==false && (DesignatorStatement.getDesignator().obj.getType().getKind() != retKind || DesignatorStatement.getDesignator().obj.getKind()==Obj.Con)) 
							report_error("Greska na liniji " +DesignatorStatement.getLine() +  " : nekompatibilni tipovi pri dodeli vrednosti ili je pokusana dodela vrednosti konstanti!", null);
    	}
    	
    	
    	retKind = -1;
    	arrayDetected = false;
    	cntArray=0;
    	array=false;
    	incDec = false;
    	procCall=false;
    	className="";
    	
    }
    
    public void visit(ConditionFactWithRelopExpr ConditionFactWithRelopExpr) { 
    	
    	if (ConditionFactWithRelopExpr.getExpr().struct.compatibleWith(ConditionFactWithRelopExpr.getExpr1().struct)==false) 
    		report_error("Greska na liniji " + ConditionFactWithRelopExpr.getLine() + ": nekompatibilni tipovi u conditionFactu!", null);
    	
    	if ((ConditionFactWithRelopExpr.getExpr().struct.getKind()==Struct.Array ||ConditionFactWithRelopExpr.getExpr().struct.getKind()==Struct.Class) && eqNoteq==false)
    			report_error("Greska na liniji " +ConditionFactWithRelopExpr.getLine() + " : nizovi i klase se mogu porediti samo sa != i ==!",null);
    	
    	eqNoteq=false;
    }
    

    public void visit(Relop_notEqual Relop_notEqual) { eqNoteq = true; }
    public void visit(Relop_equal Relop_equal) { eqNoteq = true; }
    
    public boolean passed(){
    	return !errorDetected;
    }
    
}
