// generated with ast extension for cup
// version 0.8
// 12/0/2020 0:51:20


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ClassHelperMethod ClassHelperMethod);
    public void visit(MethodDecl MethodDecl);
    public void visit(Mulop Mulop);
    public void visit(ClassHelperExtending ClassHelperExtending);
    public void visit(Relop Relop);
    public void visit(VarDeclHelper VarDeclHelper);
    public void visit(StatementList StatementList);
    public void visit(ConstDeclTemp ConstDeclTemp);
    public void visit(ConditionTerm ConditionTerm);
    public void visit(ConstDeclOptions ConstDeclOptions);
    public void visit(Factor Factor);
    public void visit(ChooseMethodList ChooseMethodList);
    public void visit(DesignatorHelper DesignatorHelper);
    public void visit(DeclList DeclList);
    public void visit(VarDeclTemp VarDeclTemp);
    public void visit(Term Term);
    public void visit(Condition Condition);
    public void visit(ChooseMethod ChooseMethod);
    public void visit(ConstDeclHelper ConstDeclHelper);
    public void visit(ActualParamList ActualParamList);
    public void visit(MayMinus MayMinus);
    public void visit(VarDeclList VarDeclList);
    public void visit(FormalParamList FormalParamList);
    public void visit(Expr Expr);
    public void visit(DesignatorHelperList DesignatorHelperList);
    public void visit(ActualPars ActualPars);
    public void visit(OptionalCondition OptionalCondition);
    public void visit(MethodReturnType MethodReturnType);
    public void visit(OptionalDesignatorStatement OptionalDesignatorStatement);
    public void visit(ConditionFact ConditionFact);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(DesignatorStatementHelper DesignatorStatementHelper);
    public void visit(ConstDecl ConstDecl);
    public void visit(Declaration Declaration);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(AbstractClassHelper AbstractClassHelper);
    public void visit(FormPars FormPars);
    public void visit(Modop Modop);
    public void visit(Divop Divop);
    public void visit(Multipleop Multipleop);
    public void visit(Subop Subop);
    public void visit(Addop Addop);
    public void visit(Relop_lessOrEqual Relop_lessOrEqual);
    public void visit(Relop_less Relop_less);
    public void visit(Relop_greaterOrEqual Relop_greaterOrEqual);
    public void visit(Relop_greater Relop_greater);
    public void visit(Relop_notEqual Relop_notEqual);
    public void visit(Relop_equal Relop_equal);
    public void visit(Assignop Assignop);
    public void visit(ConditionFactWithRelopExpr ConditionFactWithRelopExpr);
    public void visit(ConditionFactMain ConditionFactMain);
    public void visit(ConditionTermSingle ConditionTermSingle);
    public void visit(ConditionTermList ConditionTermList);
    public void visit(SingleCondition SingleCondition);
    public void visit(ConditionsList ConditionsList);
    public void visit(NoConditions NoConditions);
    public void visit(Conditions Conditions);
    public void visit(Expression Expression);
    public void visit(NewWithOutSquare NewWithOutSquare);
    public void visit(NewWithSquare NewWithSquare);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(FuncCall FuncCall);
    public void visit(Var Var);
    public void visit(NumConst NumConst);
    public void visit(FactCharConst FactCharConst);
    public void visit(FactBoolConst FactBoolConst);
    public void visit(FactNumConst FactNumConst);
    public void visit(TermMain TermMain);
    public void visit(MulTerm MulTerm);
    public void visit(TermExpr TermExpr);
    public void visit(AddExpr AddExpr);
    public void visit(NonMinus NonMinus);
    public void visit(Minus Minus);
    public void visit(ActualParam ActualParam);
    public void visit(ActualParams ActualParams);
    public void visit(NoActuals NoActuals);
    public void visit(Actuals Actuals);
    public void visit(Designator Designator);
    public void visit(NoDesignatorHelperList NoDesignatorHelperList);
    public void visit(DesignatorHelperListMain DesignatorHelperListMain);
    public void visit(ArrayPartHelper ArrayPartHelper);
    public void visit(ClassPartHelper ClassPartHelper);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(DesignatorStatementHelperDec DesignatorStatementHelperDec);
    public void visit(DesignatorStatementHelperInc DesignatorStatementHelperInc);
    public void visit(ProcCall ProcCall);
    public void visit(DesignatorStatementHelperEqual DesignatorStatementHelperEqual);
    public void visit(DesignatorStatementNo DesignatorStatementNo);
    public void visit(DesignatorStatementYes DesignatorStatementYes);
    public void visit(ForStmt ForStmt);
    public void visit(IfElseStmt IfElseStmt);
    public void visit(IfStmt IfStmt);
    public void visit(StatementStmt StatementStmt);
    public void visit(ReadStmt ReadStmt);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(BreakStmt BreakStmt);
    public void visit(ReturnNoExpr ReturnNoExpr);
    public void visit(ReturnExpr ReturnExpr);
    public void visit(PrintStmtWithNumConst PrintStmtWithNumConst);
    public void visit(PrintStmtWithOutNumConst PrintStmtWithOutNumConst);
    public void visit(ErrAssignment ErrAssignment);
    public void visit(Assignment Assignment);
    public void visit(NoStmt NoStmt);
    public void visit(Statements Statements);
    public void visit(Type Type);
    public void visit(SingleFormalParamDecl SingleFormalParamDecl);
    public void visit(FormalParamDecls FormalParamDecls);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(NoFormParam NoFormParam);
    public void visit(FormParams FormParams);
    public void visit(AbstractMethodDecl AbstractMethodDecl);
    public void visit(MethodDeclMain MethodDeclMain);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(MethodVoidReturnType MethodVoidReturnType);
    public void visit(MethodReturnTypeMain MethodReturnTypeMain);
    public void visit(NoMethodDecl NoMethodDecl);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(AbstractClassDecl AbstractClassDecl);
    public void visit(AbstractClassDeclTemp AbstractClassDeclTemp);
    public void visit(ChooseMethodDerived2 ChooseMethodDerived2);
    public void visit(ChooseMethodDerived1 ChooseMethodDerived1);
    public void visit(NoChooseMethodList NoChooseMethodList);
    public void visit(ChooseMethodListMain ChooseMethodListMain);
    public void visit(NoAbstractClassHelperChoosing NoAbstractClassHelperChoosing);
    public void visit(AbstractClassHelperChoosing AbstractClassHelperChoosing);
    public void visit(ClassDecl ClassDecl);
    public void visit(ClassName ClassName);
    public void visit(ClassWithOutMethodDecl ClassWithOutMethodDecl);
    public void visit(ClassWithMethodDecl ClassWithMethodDecl);
    public void visit(NoExtendingClassTypes NoExtendingClassTypes);
    public void visit(ClassExtendingTypes ClassExtendingTypes);
    public void visit(VarDeclMain VarDeclMain);
    public void visit(VariableDeclaration VariableDeclaration);
    public void visit(VariablesDeclarations VariablesDeclarations);
    public void visit(VarDeclName VarDeclName);
    public void visit(ErrAssignment2 ErrAssignment2);
    public void visit(VarDeclHelperDerived2 VarDeclHelperDerived2);
    public void visit(VarDeclHelperDerived1 VarDeclHelperDerived1);
    public void visit(NoVarDecl NoVarDecl);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ConstDeclarationMain ConstDeclarationMain);
    public void visit(ConstantDeclaration ConstantDeclaration);
    public void visit(ConstantDeclarations ConstantDeclarations);
    public void visit(ConstantDeclarationHelp ConstantDeclarationHelp);
    public void visit(BoolConstant BoolConstant);
    public void visit(CharConstant CharConstant);
    public void visit(NumConstant NumConstant);
    public void visit(DeclarationDerived4 DeclarationDerived4);
    public void visit(DeclarationDerived3 DeclarationDerived3);
    public void visit(DeclarationDerived2 DeclarationDerived2);
    public void visit(DeclarationDerived1 DeclarationDerived1);
    public void visit(DeclListNoDecl DeclListNoDecl);
    public void visit(DeclListFirst DeclListFirst);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
