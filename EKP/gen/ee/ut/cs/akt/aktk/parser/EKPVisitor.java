// Generated from C:/Users/Markus/Documents/lahedakutidtiimAKT/EKP/src/ee/ut/cs/akt/aktk/parser\EKP.g4 by ANTLR 4.x
package ee.ut.cs.akt.aktk.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EKPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EKPVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EKPParser#LiitmineLahutamine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiitmineLahutamine(@NotNull EKPParser.LiitmineLahutamineContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#Vordlemine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVordlemine(@NotNull EKPParser.VordlemineContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#ifLause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfLause(@NotNull EKPParser.IfLauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#avaldis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvaldis(@NotNull EKPParser.AvaldisContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#Suluavaldis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuluavaldis(@NotNull EKPParser.SuluavaldisContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#lause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLause(@NotNull EKPParser.LauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#omistamine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOmistamine(@NotNull EKPParser.OmistamineContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#programm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramm(@NotNull EKPParser.ProgrammContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#FunktsiooniValjakutse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunktsiooniValjakutse(@NotNull EKPParser.FunktsiooniValjakutseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#SoneliteraalR}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoneliteraalR(@NotNull EKPParser.SoneliteraalRContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#ArvuliteraalR}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArvuliteraalR(@NotNull EKPParser.ArvuliteraalRContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#UnaarneMiinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaarneMiinus(@NotNull EKPParser.UnaarneMiinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#lauseteJada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLauseteJada(@NotNull EKPParser.LauseteJadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#MuutujaNimiR}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuutujaNimiR(@NotNull EKPParser.MuutujaNimiRContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#KorrutamineJagamine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKorrutamineJagamine(@NotNull EKPParser.KorrutamineJagamineContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull EKPParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(@NotNull EKPParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#muutujaDeklaratsioon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuutujaDeklaratsioon(@NotNull EKPParser.MuutujaDeklaratsioonContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#whileLause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLause(@NotNull EKPParser.WhileLauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#TriviaalneAvaldis5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriviaalneAvaldis5(@NotNull EKPParser.TriviaalneAvaldis5Context ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#TriviaalneAvaldis4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriviaalneAvaldis4(@NotNull EKPParser.TriviaalneAvaldis4Context ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#TriviaalneAvaldis3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriviaalneAvaldis3(@NotNull EKPParser.TriviaalneAvaldis3Context ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#TriviaalneAvaldis2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriviaalneAvaldis2(@NotNull EKPParser.TriviaalneAvaldis2Context ctx);
	/**
	 * Visit a parse tree produced by {@link EKPParser#TriviaalneAvaldis1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriviaalneAvaldis1(@NotNull EKPParser.TriviaalneAvaldis1Context ctx);
}