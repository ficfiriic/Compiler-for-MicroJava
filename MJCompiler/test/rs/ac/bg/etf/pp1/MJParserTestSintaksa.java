/*
package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.ac.bg.etf.pp1.ast.*;

public class MJParserTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger(MJParserTest.class);
	
		
		Reader br = null;
		try {
			
			File sourceCode = new File("test/program.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());

			br = new BufferedReader(new FileReader(sourceCode));
			
			
			Yylex lexer = new Yylex(br);
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	        log.info("------Ovde bi trebalo stablo------");
	        Program prog = (Program)(s.value);
	        //ispis sintaksnog stabla
	        String ispis = prog.toString();
	        log.info(ispis);
	        log.info("==========================");
	        
	        //ispis prepoznatih programskih konstrukcija
	        RuleVisitor v = new RuleVisitor();
	        prog.traverseBottomUp(v);
		
	        log.info("Print count call = " + v.printCallCount);
	        log.info("Var count calls = " + v.VarCallCount);
	        log.info("Const count calls = " + v.ConstCallCount);
	        log.info("Class count calls = " + v.ClassCallCount);
	        log.info("Method count calls = " + v.ClassCallCount);
	        
		}finally {
			if (br!=null) try {br.close();} catch (IOException e) {log.error(e.getMessage(),e);}
		}
	}
}
*/

package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;

public class MJParserTestSintaksa {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(MJParserTestSintaksa.class);
		
		Reader br = null;
		try {
			File sourceCode = new File("test/program.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	        
	        Program prog = (Program)(s.value); 
			// ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");

			// ispis prepoznatih programskih konstrukcija
			RuleVisitor v = new RuleVisitor();
			prog.traverseBottomUp(v); 
	      
			log.info("Print count call = " + v.printCallCount);
	        log.info("Var count calls = " + v.VarCallCount);
	        log.info("Const count calls = " + v.ConstCallCount);
	        log.info("Class count calls = " + v.ClassCallCount);
	        log.info("Method count calls = " + v.MethodCnt);			
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}

	}
	
	
}
