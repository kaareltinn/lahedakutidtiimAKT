// Generated from C:/Users/Markus/Documents/lahedakutidtiimAKT/EKP/src/ee/ut/cs/akt/aktk/parser\EKP.g4 by ANTLR 4.x
package ee.ut.akt.aktk.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EKPLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__24=1, T__23=2, T__22=3, T__21=4, T__20=5, T__19=6, T__18=7, T__17=8, 
		T__16=9, T__15=10, T__14=11, T__13=12, T__12=13, T__11=14, T__10=15, T__9=16, 
		T__8=17, T__7=18, T__6=19, T__5=20, T__4=21, T__3=22, T__2=23, T__1=24, 
		T__0=25, MuutujaNimi=26, Arvuliteraal=27, Soneliteraal=28, Kommentaar=29, 
		Rida_Kommentaar=30, Whitespace=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'"
	};
	public static final String[] ruleNames = {
		"T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", 
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"MuutujaNimi", "Arvuliteraal", "Soneliteraal", "Kommentaar", "Rida_Kommentaar", 
		"Whitespace"
	};


	public EKPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EKP.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00e4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\7\33\u00a5\n\33\f\33\16\33\u00a8\13\33\3\34"+
		"\3\34\3\34\7\34\u00ad\n\34\f\34\16\34\u00b0\13\34\5\34\u00b2\n\34\3\34"+
		"\3\34\6\34\u00b6\n\34\r\34\16\34\u00b7\5\34\u00ba\n\34\3\35\3\35\7\35"+
		"\u00be\n\35\f\35\16\35\u00c1\13\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36"+
		"\u00c9\n\36\f\36\16\36\u00cc\13\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\7\37\u00d7\n\37\f\37\16\37\u00da\13\37\3\37\3\37\3 \6 \u00df"+
		"\n \r \16 \u00e0\3 \3 \3\u00ca\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\t\f\2C\\c|\u00c6\u00c6\u00d7"+
		"\u00d8\u00de\u00de\u00e6\u00e6\u00f7\u00f8\u00fe\u00fe\u0162\u0163\u017f"+
		"\u0180\16\2\62;C\\aac|\u00c6\u00c6\u00d7\u00d8\u00de\u00de\u00e6\u00e6"+
		"\u00f7\u00f8\u00fe\u00fe\u0162\u0163\u017f\u0180\3\2\63;\3\2\62;\5\2\f"+
		"\f\17\17$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u00ec\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\3A\3\2\2\2\5F\3\2\2\2\7H\3\2\2\2\tJ\3\2\2\2\13L\3\2\2\2\rN\3\2"+
		"\2\2\17P\3\2\2\2\21S\3\2\2\2\23[\3\2\2\2\25^\3\2\2\2\27`\3\2\2\2\31k\3"+
		"\2\2\2\33q\3\2\2\2\35s\3\2\2\2\37u\3\2\2\2!w\3\2\2\2#}\3\2\2\2%\u0081"+
		"\3\2\2\2\'\u0083\3\2\2\2)\u0085\3\2\2\2+\u0090\3\2\2\2-\u0092\3\2\2\2"+
		"/\u009a\3\2\2\2\61\u009d\3\2\2\2\63\u009f\3\2\2\2\65\u00a2\3\2\2\2\67"+
		"\u00b1\3\2\2\29\u00bb\3\2\2\2;\u00c4\3\2\2\2=\u00d2\3\2\2\2?\u00de\3\2"+
		"\2\2AB\7u\2\2BC\7\u00f7\2\2CD\7p\2\2DE\7g\2\2E\4\3\2\2\2FG\7.\2\2G\6\3"+
		"\2\2\2HI\7,\2\2I\b\3\2\2\2JK\7/\2\2K\n\3\2\2\2LM\7*\2\2M\f\3\2\2\2NO\7"+
		">\2\2O\16\3\2\2\2PQ\7#\2\2QR\7?\2\2R\20\3\2\2\2ST\7v\2\2TU\7\u00e6\2\2"+
		"UV\7k\2\2VW\7u\2\2WX\7c\2\2XY\7t\2\2YZ\7x\2\2Z\22\3\2\2\2[\\\7>\2\2\\"+
		"]\7?\2\2]\24\3\2\2\2^_\7}\2\2_\26\3\2\2\2`a\7w\2\2ab\7l\2\2bc\7w\2\2c"+
		"d\7m\2\2de\7q\2\2ef\7o\2\2fg\7c\2\2gh\7c\2\2hi\7t\2\2ij\7x\2\2j\30\3\2"+
		"\2\2kl\7m\2\2lm\7q\2\2mn\7t\2\2no\7f\2\2op\7c\2\2p\32\3\2\2\2qr\7\177"+
		"\2\2r\34\3\2\2\2st\7+\2\2t\36\3\2\2\2uv\7-\2\2v \3\2\2\2wx\7o\2\2xy\7"+
		"w\2\2yz\7k\2\2z{\7f\2\2{|\7w\2\2|\"\3\2\2\2}~\7m\2\2~\177\7w\2\2\177\u0080"+
		"\7k\2\2\u0080$\3\2\2\2\u0081\u0082\7?\2\2\u0082&\3\2\2\2\u0083\u0084\7"+
		"=\2\2\u0084(\3\2\2\2\u0085\u0086\7h\2\2\u0086\u0087\7w\2\2\u0087\u0088"+
		"\7p\2\2\u0088\u0089\7m\2\2\u0089\u008a\7v\2\2\u008a\u008b\7u\2\2\u008b"+
		"\u008c\7k\2\2\u008c\u008d\7q\2\2\u008d\u008e\7q\2\2\u008e\u008f\7p\2\2"+
		"\u008f*\3\2\2\2\u0090\u0091\7@\2\2\u0091,\3\2\2\2\u0092\u0093\7v\2\2\u0093"+
		"\u0094\7c\2\2\u0094\u0095\7i\2\2\u0095\u0096\7c\2\2\u0096\u0097\7u\2\2"+
		"\u0097\u0098\7v\2\2\u0098\u0099\7c\2\2\u0099.\3\2\2\2\u009a\u009b\7?\2"+
		"\2\u009b\u009c\7?\2\2\u009c\60\3\2\2\2\u009d\u009e\7\61\2\2\u009e\62\3"+
		"\2\2\2\u009f\u00a0\7@\2\2\u00a0\u00a1\7?\2\2\u00a1\64\3\2\2\2\u00a2\u00a6"+
		"\t\2\2\2\u00a3\u00a5\t\3\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\66\3\2\2\2\u00a8\u00a6\3\2\2"+
		"\2\u00a9\u00b2\7\62\2\2\u00aa\u00ae\t\4\2\2\u00ab\u00ad\t\5\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00a9\3\2\2\2\u00b1"+
		"\u00aa\3\2\2\2\u00b2\u00b9\3\2\2\2\u00b3\u00b5\7\60\2\2\u00b4\u00b6\t"+
		"\5\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b3\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba8\3\2\2\2\u00bb\u00bf\7$\2\2\u00bc\u00be\n\6\2\2\u00bd\u00bc"+
		"\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7$\2\2\u00c3:\3\2\2\2\u00c4"+
		"\u00c5\7\61\2\2\u00c5\u00c6\7,\2\2\u00c6\u00ca\3\2\2\2\u00c7\u00c9\13"+
		"\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00cb\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7,"+
		"\2\2\u00ce\u00cf\7\61\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\b\36\2\2\u00d1"+
		"<\3\2\2\2\u00d2\u00d3\7\61\2\2\u00d3\u00d4\7\61\2\2\u00d4\u00d8\3\2\2"+
		"\2\u00d5\u00d7\n\7\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00d8\3\2\2\2\u00db"+
		"\u00dc\b\37\2\2\u00dc>\3\2\2\2\u00dd\u00df\t\b\2\2\u00de\u00dd\3\2\2\2"+
		"\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e2\u00e3\b \2\2\u00e3@\3\2\2\2\f\2\u00a6\u00ae\u00b1\u00b7"+
		"\u00b9\u00bf\u00ca\u00d8\u00e0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}