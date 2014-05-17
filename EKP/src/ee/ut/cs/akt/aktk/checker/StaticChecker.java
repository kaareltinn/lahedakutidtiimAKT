package ee.ut.cs.akt.aktk.checker;

import ee.ut.cs.akt.aktk.ast.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticChecker {
	public static void check(AstNode program) {
		// meetod peaks viskama erindi UndeclaredVariableException
		check(program, new HashMap<String, Type>());
	}

	public static void check(AstNode tipp, Map<String, Type> muutujad) {
		if (tipp instanceof Block) {
//			System.out.println("IN BLOCK");
			//{} vahel
			Map<String, Type> plokiSkoop = new HashMap<>(muutujad);

			for (Statement stmt : ((Block) tipp).getStatements()) {
//				System.out.println("Cheking " + stmt.toString());
				check(stmt, plokiSkoop);
			}
		} else if (tipp instanceof VariableDeclaration) {
			//kontrolli muutuja väärtustamist, peaks töötama korrektselt
//			System.out.println("VariableDec");
			Expression var = ((VariableDeclaration) tipp).getInitializer();
			if(var!=null){ //kui on null siis pole vaja kontrollida juht täisarv x;
				if(!((VariableDeclaration) tipp).getType().equals(checkExpression(var, muutujad))){
					throw new WrongTypeException();
				}			
				muutujad.put(((VariableDeclaration) tipp).getVariableName(),((VariableDeclaration) tipp).getType());
			}
		} else if (tipp instanceof IfStatement) {
//			System.out.println("IF STMT");
			//kas võrreldavad asjad on sama tüüpi?
			checkExpression(((IfStatement) tipp).getCondition(), muutujad);
//			System.out.println(((IfStatement) tipp).getThenBranch());
			check(((IfStatement) tipp).getThenBranch(), muutujad);
//			System.out.println(((IfStatement) tipp).getElseBranch());
			check(((IfStatement) tipp).getElseBranch(), muutujad);
		} else if (tipp instanceof FunctionCall) {
//			System.out.println("FN CALL");
			//olemasolev funktsioon või sisefunktsioon
		} else if (tipp instanceof ExpressionStatement) {
//			System.out.println("EXPR STMT");
			//võiks olla, et trüki kõik? siis pole kontrolli vaja
			check(((ExpressionStatement) tipp).getExpression(), muutujad);
		}else if (tipp instanceof FunctionDeclaration) {
//			System.out.println("FN DEC");
			muutujad.put(((FunctionDeclaration) tipp).getFunctionName(), ((FunctionDeclaration) tipp).getFunctionReturnType());
//			System.out.println(((FunctionDeclaration) tipp).getArguments());
			List<VariableDeclaration> functionArgs = ((FunctionDeclaration) tipp).getArguments();
			for(int i=0;i<functionArgs.size();i++){
				check(((FunctionDeclaration) tipp).getArguments().get(i), muutujad);
			}
			check(((FunctionDeclaration) tipp).getFunctionStatment(), muutujad);
//			System.out.println("Return exp " + ((FunctionDeclaration) tipp).getFunctionReturnExpression());
			if(((FunctionDeclaration) tipp).getFunctionReturnExpression()!=null){
				Type actualFunctionReturnType = checkExpression(((FunctionDeclaration) tipp).getFunctionReturnExpression(), muutujad);
				Type requiredFunctionReturnType = muutujad.get(((FunctionDeclaration) tipp).getFunctionName());
				if(!requiredFunctionReturnType.equals(actualFunctionReturnType)){
					throw new WrongTypeException();
				}
			}else{
				if(!((FunctionDeclaration) tipp).getFunctionReturnType().getName().equalsIgnoreCase("tühi")){
					throw new WrongTypeException();
				}
			}
		}else if (tipp instanceof Assignment) {
//			System.out.println("ASSINGMENT");
			Type arg1 = muutujad.get(((Assignment) tipp).getVariableName());
			Type arg2 = checkExpression(((Assignment) tipp).getExpression(), muutujad);
			if(!arg1.equals(arg2)){
				throw new WrongTypeException();
			}
		} else if (tipp instanceof WhileStatement) {
//			System.out.println("WHILE STMT");
			checkExpression(((WhileStatement) tipp).getCondition(), muutujad);
			check(((WhileStatement) tipp).getBody(), muutujad);
		}else {
			throw new UnsupportedOperationException(
					"See lause liik on veel lahendamata");
		}
	}// iga ploki jaoks eraldi komplekt
	private static Type checkExpression(Expression expression, Map<String, Type> variablesInScope) {
    	// See funktsioon peaks tagastama eduka kontrolli puhul avaldise tüübi
    	if (expression instanceof IntegerLiteral) {
    		return new SimpleType("täisarv");
    	}
    	else if (expression instanceof StringLiteral) {
    		return new SimpleType("sõne");
    	}else if (expression instanceof FloatingPointLiteral) {
    		return new SimpleType("ujukomaarv");
    	}else if (expression instanceof Variable){
    		if(variablesInScope.containsKey(((Variable) expression).getName())){
    			//var on olemas
    			return variablesInScope.get(((Variable) expression).getName());
    		}else{//seda vist vaja siis kui deklareeritud aga pole kasutatud??
    			return checkExpression(expression, variablesInScope);
    		}
    	}
    	else if (expression instanceof FunctionCall) {
//    		System.out.println("in functioncall");
    		Type arg1;
    		if(((FunctionCall) expression).isComparisonOperation()){
    			List<Expression> arguments = ((FunctionCall) expression).getArguments();
    			arg1 = checkExpression(arguments.get(0), variablesInScope);
    			Type arg2 = checkExpression(arguments.get(1), variablesInScope);
    			if(!arg1.equals(arg2)){
    				throw new WrongTypeException();
    			}
    		}else if(((FunctionCall) expression).isArithmeticOrLogicOperation()){
    			List<Expression> arguments = ((FunctionCall) expression).getArguments();
//    			System.out.println(arguments.toString());
    			arg1 = checkExpression(arguments.get(0), variablesInScope);
    			for(int i=1;i<arguments.size();i++){
    				Type arg2 = checkExpression(arguments.get(1), variablesInScope);
    				if(!arg1.equals(arg2)){
        				throw new WrongTypeException();
        			}
//    				System.out.println(arg1.toString()+""+arg2.toString());
    			}
    		}else{
    			throw new UnsupportedOperationException();
    		}
    		return arg1;
    	}
    	else {
    		throw new UnsupportedOperationException("See avaldise liik on veel lahendamata");
    	}
    }
}
