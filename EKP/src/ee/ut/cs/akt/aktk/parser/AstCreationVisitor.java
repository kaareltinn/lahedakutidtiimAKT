package ee.ut.cs.akt.aktk.parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ee.ut.cs.akt.aktk.ast.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import ee.ut.cs.akt.aktk.parser.EKPBaseListener;
import ee.ut.cs.akt.aktk.parser.EKPParser.ArvuliteraalRContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.FunktsiooniValjakutseContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.FunctionContext;

import ee.ut.cs.akt.aktk.parser.EKPParser.IfLauseContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.KorrutamineJagamineContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.LauseContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.LauseteJadaContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.LiitmineLahutamineContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.MuutujaDeklaratsioonContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.MuutujaNimiRContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.OmistamineContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.SoneliteraalRContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.SuluavaldisContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.UnaarneMiinusContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.VordlemineContext;
import ee.ut.cs.akt.aktk.parser.EKPParser.WhileLauseContext;


public class AstCreationVisitor extends EKPBaseVisitor<AstNode> {
	@Override
	public AstNode visitMuutujaNimiR(MuutujaNimiRContext ctx) {
		return new Variable(ctx.getText());
	}
	
	@Override
	public AstNode visitArvuliteraalR(ArvuliteraalRContext ctx) {
		// tuleb arvestada, et tegemist võib olla täisarvu või murdarvuga
		if (ctx.getText().contains(".")) {
			return new FloatingPointLiteral(Double.parseDouble(ctx.getText()));
		}
		else {
			return new IntegerLiteral(Integer.parseInt(ctx.getText()));
		}
	}

    @Override
    public AstNode visitDataType(EKPParser.DataTypeContext ctx) {
        return new SimpleType(ctx.getText());
    }

    @Override
	public AstNode visitSoneliteraalR(SoneliteraalRContext ctx) {
		// arvesta, et sõneliteraalil on ümber jutumärgid, mis ei kuulu sõne sisu hulka
		return new StringLiteral(ctx.getText().substring(1, ctx.getText().length()-1));
	}
	
	@Override
	public AstNode visitSuluavaldis(SuluavaldisContext ctx) {
		return this.visit(ctx.getChild(1));
	}
	
	@Override
	public AstNode visitFunktsiooniValjakutse(FunktsiooniValjakutseContext ctx) {
		// NB! siin tuleb kontrollida, kuidas näeb välja 
		//   - ilma argumentideta 
		//   - ühe argumendiga
		//   - mitme argumendiga 
		// funktsiooni väljakutse parse-puu
		String funktsiooniNimi = ctx.getChild(0).getText();
		
		List<Expression> argumendid = new ArrayList<Expression>();
		
		if (ctx.getChildCount() > 3) {
			// argumentavaldised on paarisarvulise indeksiga lapsed
			for (int i=2; i < ctx.getChildCount(); i += 2) {
				argumendid.add((Expression)this.visit(ctx.getChild(i)));
			}
		}
		
		return new FunctionCall(funktsiooniNimi, argumendid);
		
	}

    @Override
    public AstNode visitFunction(FunctionContext ctx){

        String funktsiooniNimi = ctx.getChild(2).getText();
        SimpleType tyyp = new SimpleType(ctx.getChild(1).getText());

        List<VariableDeclaration> argumendid = new ArrayList<VariableDeclaration>();

        int j = 7;

        for (int i=4; i < ctx.getChildCount(); i += 2) {
            if(ctx.getChild(i).getText().equals("{")){
                j = i + 1;
                break;
            }else if(ctx.getChild(i).getText().equals(")")){
                j = i + 2;
                break;
            }
            argumendid.add((VariableDeclaration) this.visit(ctx.getChild(i)));
        }


        Statement keha = (Statement) this.visit(ctx.getChild(j));

        Expression tagastus = (Expression) this.visit(ctx.getChild(j + 2));


        return new FunctionDeclaration(tyyp, funktsiooniNimi, argumendid, keha, tagastus);
    }
	
	@Override
	public AstNode visitUnaarneMiinus(UnaarneMiinusContext ctx) {
		// võime eeldada, et miinuse argument on avaldis
		Expression arg = (Expression) this.visit(ctx.getChild(1));
		return new FunctionCall("-", Arrays.asList(arg));
	}
	
	@Override
	public AstNode visitKorrutamineJagamine(KorrutamineJagamineContext ctx) {
		return visitBinaryOperation(ctx);
	}
	
	@Override
	public AstNode visitLiitmineLahutamine(LiitmineLahutamineContext ctx) {
		return visitBinaryOperation(ctx);
	}
	
	@Override
	public AstNode visitVordlemine(VordlemineContext ctx) {
		return visitBinaryOperation(ctx);
	}
	
	private AstNode visitBinaryOperation(ParseTree ctx) {
		// kõik binaarsed operatsioonid saan käsitleda korraga
		String operaator = ctx.getChild(1).getText();
		Expression vasakArgument = (Expression) this.visit(ctx.getChild(0));
		Expression paremArgument = (Expression) this.visit(ctx.getChild(2));
		
		return new FunctionCall(operaator, Arrays.asList(vasakArgument, paremArgument));
	}
	
	@Override
	public AstNode visitMuutujaDeklaratsioon(MuutujaDeklaratsioonContext ctx) {
        // Muutuja deklaratsiooni esimene alluv (st. alluv 0) on datatype "täisarv,sõne jne"
        Type muutujaTyyp = (Type)this.visit(ctx.getChild(0));
		// teine alluv on muutuja nimi
		String muutujaNimi = ctx.getChild(1).getText();
		
		// Algväärtus võib olla, aga ei pruugi.
		// Kontrolli ANTLRi IntelliJ pluginaga järgi, mitu alluvat
		// on muutuja deklaratsioonil, millel on algväärtus ja mitu 
		// alluvat on sellel, millel algväärtust pole.
		Expression algVäärtustusAvaldis = null;
		if (ctx.getChildCount() == 4) {
			algVäärtustusAvaldis = (Expression) this.visit(ctx.getChild(3));
		}
		
		return new VariableDeclaration(muutujaNimi, muutujaTyyp, algVäärtustusAvaldis);
	}
	
	@Override
	public AstNode visitOmistamine(OmistamineContext ctx) {
		String muutujaNimi = ctx.getChild(0).getText();
		Expression avaldis = (Expression) this.visit(ctx.getChild(2));
		return new Assignment(muutujaNimi, avaldis);
	}
	
	@Override
	public AstNode visitWhileLause(WhileLauseContext ctx) {
		Expression tingimus = (Expression) this.visit(ctx.getChild(2));
		Statement keha = (Statement) this.visit(ctx.getChild(5));
		return new WhileStatement(tingimus, keha);
	}
	
	@Override
	public AstNode visitIfLause(IfLauseContext ctx) {
		Expression tingimus = (Expression) this.visit(ctx.getChild(2));
		Statement thenHaru = (Statement) this.visit(ctx.getChild(5));
		Statement elseHaru = (Statement) this.visit(ctx.getChild(9));
		
		return new IfStatement(tingimus, thenHaru, elseHaru);
	}
	
	@Override
	public AstNode visitLause(LauseContext ctx) {
		// grammatikast on näha, et lause võib olla ühe alluvaga,
		// (nt. ifLause, whileLause), mis on käsitletud mujal
		if (ctx.getChildCount() == 1) {
			AstNode child = this.visit(ctx.getChild(0)); 
			if (child instanceof Expression) {
				return new ExpressionStatement((Expression) child);
			} 
			else {
				return child;
			}
		}
		// ... aga lause võib olla ka loogelistes sulgudes olev lausete jada
		else {
			assert ctx.getChildCount() == 3;
			return this.visit(ctx.getChild(1));
		}
	}
	
	@Override
	public AstNode visitLauseteJada(LauseteJadaContext ctx) {
        // Siin on tähtis järgi uurida, kuidas näib välja mitme lausega
		// lauseteJada parse-puu.
		
		List<Statement> laused = new ArrayList<Statement>();
		// Nagu näha, on alluvate jadas vaheldumis laused ja semikoolonid.
		// Lausete läbikäimiseks võtan ette kõik paarisarvuliste indeksitega alluvad:
		for (int i=0; i < ctx.getChildCount(); i += 2) {
			Statement lause = (Statement) this.visit(ctx.getChild(i));
			laused.add(lause);
		}
		
		return new Block(laused);
	}
}
