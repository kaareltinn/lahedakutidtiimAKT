// Generated from C:/Users/Markus/Desktop/Kooli stuff/IV semester/Automaadid, keeled ja translaaatorid/EKP/src/ee/ut/cs/akt/aktk/parser\EKP.g4 by ANTLR 4.x
package ee.ut.cs.akt.aktk.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EKPParser}.
 */
public interface EKPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EKPParser#LiitmineLahutamine}.
	 * @param ctx the parse tree
	 */
	void enterLiitmineLahutamine(@NotNull EKPParser.LiitmineLahutamineContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#LiitmineLahutamine}.
	 * @param ctx the parse tree
	 */
	void exitLiitmineLahutamine(@NotNull EKPParser.LiitmineLahutamineContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#Vordlemine}.
	 * @param ctx the parse tree
	 */
	void enterVordlemine(@NotNull EKPParser.VordlemineContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#Vordlemine}.
	 * @param ctx the parse tree
	 */
	void exitVordlemine(@NotNull EKPParser.VordlemineContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#ifLause}.
	 * @param ctx the parse tree
	 */
	void enterIfLause(@NotNull EKPParser.IfLauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#ifLause}.
	 * @param ctx the parse tree
	 */
	void exitIfLause(@NotNull EKPParser.IfLauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#avaldis}.
	 * @param ctx the parse tree
	 */
	void enterAvaldis(@NotNull EKPParser.AvaldisContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#avaldis}.
	 * @param ctx the parse tree
	 */
	void exitAvaldis(@NotNull EKPParser.AvaldisContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#Suluavaldis}.
	 * @param ctx the parse tree
	 */
	void enterSuluavaldis(@NotNull EKPParser.SuluavaldisContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#Suluavaldis}.
	 * @param ctx the parse tree
	 */
	void exitSuluavaldis(@NotNull EKPParser.SuluavaldisContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#lause}.
	 * @param ctx the parse tree
	 */
	void enterLause(@NotNull EKPParser.LauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#lause}.
	 * @param ctx the parse tree
	 */
	void exitLause(@NotNull EKPParser.LauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#omistamine}.
	 * @param ctx the parse tree
	 */
	void enterOmistamine(@NotNull EKPParser.OmistamineContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#omistamine}.
	 * @param ctx the parse tree
	 */
	void exitOmistamine(@NotNull EKPParser.OmistamineContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#programm}.
	 * @param ctx the parse tree
	 */
	void enterProgramm(@NotNull EKPParser.ProgrammContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#programm}.
	 * @param ctx the parse tree
	 */
	void exitProgramm(@NotNull EKPParser.ProgrammContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#FunktsiooniValjakutse}.
	 * @param ctx the parse tree
	 */
	void enterFunktsiooniValjakutse(@NotNull EKPParser.FunktsiooniValjakutseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#FunktsiooniValjakutse}.
	 * @param ctx the parse tree
	 */
	void exitFunktsiooniValjakutse(@NotNull EKPParser.FunktsiooniValjakutseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#SoneliteraalR}.
	 * @param ctx the parse tree
	 */
	void enterSoneliteraalR(@NotNull EKPParser.SoneliteraalRContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#SoneliteraalR}.
	 * @param ctx the parse tree
	 */
	void exitSoneliteraalR(@NotNull EKPParser.SoneliteraalRContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#ArvuliteraalR}.
	 * @param ctx the parse tree
	 */
	void enterArvuliteraalR(@NotNull EKPParser.ArvuliteraalRContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#ArvuliteraalR}.
	 * @param ctx the parse tree
	 */
	void exitArvuliteraalR(@NotNull EKPParser.ArvuliteraalRContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#UnaarneMiinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaarneMiinus(@NotNull EKPParser.UnaarneMiinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#UnaarneMiinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaarneMiinus(@NotNull EKPParser.UnaarneMiinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#lauseteJada}.
	 * @param ctx the parse tree
	 */
	void enterLauseteJada(@NotNull EKPParser.LauseteJadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#lauseteJada}.
	 * @param ctx the parse tree
	 */
	void exitLauseteJada(@NotNull EKPParser.LauseteJadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#MuutujaNimiR}.
	 * @param ctx the parse tree
	 */
	void enterMuutujaNimiR(@NotNull EKPParser.MuutujaNimiRContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#MuutujaNimiR}.
	 * @param ctx the parse tree
	 */
	void exitMuutujaNimiR(@NotNull EKPParser.MuutujaNimiRContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#KorrutamineJagamine}.
	 * @param ctx the parse tree
	 */
	void enterKorrutamineJagamine(@NotNull EKPParser.KorrutamineJagamineContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#KorrutamineJagamine}.
	 * @param ctx the parse tree
	 */
	void exitKorrutamineJagamine(@NotNull EKPParser.KorrutamineJagamineContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull EKPParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull EKPParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(@NotNull EKPParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(@NotNull EKPParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#muutujaDeklaratsioon}.
	 * @param ctx the parse tree
	 */
	void enterMuutujaDeklaratsioon(@NotNull EKPParser.MuutujaDeklaratsioonContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#muutujaDeklaratsioon}.
	 * @param ctx the parse tree
	 */
	void exitMuutujaDeklaratsioon(@NotNull EKPParser.MuutujaDeklaratsioonContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#whileLause}.
	 * @param ctx the parse tree
	 */
	void enterWhileLause(@NotNull EKPParser.WhileLauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#whileLause}.
	 * @param ctx the parse tree
	 */
	void exitWhileLause(@NotNull EKPParser.WhileLauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#TriviaalneAvaldis5}.
	 * @param ctx the parse tree
	 */
	void enterTriviaalneAvaldis5(@NotNull EKPParser.TriviaalneAvaldis5Context ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#TriviaalneAvaldis5}.
	 * @param ctx the parse tree
	 */
	void exitTriviaalneAvaldis5(@NotNull EKPParser.TriviaalneAvaldis5Context ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#TriviaalneAvaldis4}.
	 * @param ctx the parse tree
	 */
	void enterTriviaalneAvaldis4(@NotNull EKPParser.TriviaalneAvaldis4Context ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#TriviaalneAvaldis4}.
	 * @param ctx the parse tree
	 */
	void exitTriviaalneAvaldis4(@NotNull EKPParser.TriviaalneAvaldis4Context ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#TriviaalneAvaldis3}.
	 * @param ctx the parse tree
	 */
	void enterTriviaalneAvaldis3(@NotNull EKPParser.TriviaalneAvaldis3Context ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#TriviaalneAvaldis3}.
	 * @param ctx the parse tree
	 */
	void exitTriviaalneAvaldis3(@NotNull EKPParser.TriviaalneAvaldis3Context ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#TriviaalneAvaldis2}.
	 * @param ctx the parse tree
	 */
	void enterTriviaalneAvaldis2(@NotNull EKPParser.TriviaalneAvaldis2Context ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#TriviaalneAvaldis2}.
	 * @param ctx the parse tree
	 */
	void exitTriviaalneAvaldis2(@NotNull EKPParser.TriviaalneAvaldis2Context ctx);
	/**
	 * Enter a parse tree produced by {@link EKPParser#TriviaalneAvaldis1}.
	 * @param ctx the parse tree
	 */
	void enterTriviaalneAvaldis1(@NotNull EKPParser.TriviaalneAvaldis1Context ctx);
	/**
	 * Exit a parse tree produced by {@link EKPParser#TriviaalneAvaldis1}.
	 * @param ctx the parse tree
	 */
	void exitTriviaalneAvaldis1(@NotNull EKPParser.TriviaalneAvaldis1Context ctx);
}