// Generated from C:/Users/Markus/Desktop/Kooli stuff/IV semester/Automaadid, keeled ja translaaatorid/EKP/src/ee/ut/cs/akt/aktk/parser\EKP.g4 by ANTLR 4.x
package ee.ut.akt.aktk.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EKPParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__28=1, T__27=2, T__26=3, T__25=4, T__24=5, T__23=6, T__22=7, T__21=8, 
		T__20=9, T__19=10, T__18=11, T__17=12, T__16=13, T__15=14, T__14=15, T__13=16, 
		T__12=17, T__11=18, T__10=19, T__9=20, T__8=21, T__7=22, T__6=23, T__5=24, 
		T__4=25, T__3=26, T__2=27, T__1=28, T__0=29, MuutujaNimi=30, Arvuliteraal=31, 
		Soneliteraal=32, Kommentaar=33, Rida_Kommentaar=34, Whitespace=35;
	public static final String[] tokenNames = {
		"<INVALID>", "'sõne'", "','", "'-'", "'*'", "'('", "'<'", "'täisarv'", 
		"'!='", "'<='", "'{'", "'tühi'", "'ujukomaarv'", "'korda'", "'}'", "')'", 
		"'ta'", "'+'", "'muidu'", "'kui'", "'='", "';'", "'fun'", "'funktsioon'", 
		"'>'", "'uka'", "'tagasta'", "'=='", "'/'", "'>='", "MuutujaNimi", "Arvuliteraal", 
		"Soneliteraal", "Kommentaar", "Rida_Kommentaar", "Whitespace"
	};
	public static final int
		RULE_programm = 0, RULE_lauseteJada = 1, RULE_lause = 2, RULE_ifLause = 3, 
		RULE_whileLause = 4, RULE_omistamine = 5, RULE_muutujaDeklaratsioon = 6, 
		RULE_dataType = 7, RULE_function = 8, RULE_avaldis = 9, RULE_avaldis5 = 10, 
		RULE_avaldis4 = 11, RULE_avaldis3 = 12, RULE_avaldis2 = 13, RULE_avaldis1 = 14, 
		RULE_avaldis0 = 15;
	public static final String[] ruleNames = {
		"programm", "lauseteJada", "lause", "ifLause", "whileLause", "omistamine", 
		"muutujaDeklaratsioon", "dataType", "function", "avaldis", "avaldis5", 
		"avaldis4", "avaldis3", "avaldis2", "avaldis1", "avaldis0"
	};

	@Override
	public String getGrammarFileName() { return "EKP.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EKPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgrammContext extends ParserRuleContext {
		public LauseteJadaContext lauseteJada() {
			return getRuleContext(LauseteJadaContext.class,0);
		}
		public ProgrammContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterProgramm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitProgramm(this);
		}
	}

	public final ProgrammContext programm() throws RecognitionException {
		ProgrammContext _localctx = new ProgrammContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); lauseteJada();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LauseteJadaContext extends ParserRuleContext {
		public LauseContext lause(int i) {
			return getRuleContext(LauseContext.class,i);
		}
		public List<LauseContext> lause() {
			return getRuleContexts(LauseContext.class);
		}
		public LauseteJadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lauseteJada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterLauseteJada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitLauseteJada(this);
		}
	}

	public final LauseteJadaContext lauseteJada() throws RecognitionException {
		LauseteJadaContext _localctx = new LauseteJadaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_lauseteJada);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__26) | (1L << T__24) | (1L << T__22) | (1L << T__19) | (1L << T__18) | (1L << T__17) | (1L << T__16) | (1L << T__13) | (1L << T__10) | (1L << T__7) | (1L << T__6) | (1L << T__4) | (1L << MuutujaNimi) | (1L << Arvuliteraal) | (1L << Soneliteraal))) != 0)) {
				{
				{
				setState(34); lause();
				setState(35); match(T__8);
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LauseContext extends ParserRuleContext {
		public MuutujaDeklaratsioonContext muutujaDeklaratsioon() {
			return getRuleContext(MuutujaDeklaratsioonContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public WhileLauseContext whileLause() {
			return getRuleContext(WhileLauseContext.class,0);
		}
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public OmistamineContext omistamine() {
			return getRuleContext(OmistamineContext.class,0);
		}
		public IfLauseContext ifLause() {
			return getRuleContext(IfLauseContext.class,0);
		}
		public LauseteJadaContext lauseteJada() {
			return getRuleContext(LauseteJadaContext.class,0);
		}
		public LauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterLause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitLause(this);
		}
	}

	public final LauseContext lause() throws RecognitionException {
		LauseContext _localctx = new LauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lause);
		try {
			setState(52);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42); ifLause();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43); whileLause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(44); omistamine();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(45); muutujaDeklaratsioon();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(46); avaldis();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(47); match(T__19);
				setState(48); lauseteJada();
				setState(49); match(T__15);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(51); function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfLauseContext extends ParserRuleContext {
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public LauseteJadaContext lauseteJada(int i) {
			return getRuleContext(LauseteJadaContext.class,i);
		}
		public List<LauseteJadaContext> lauseteJada() {
			return getRuleContexts(LauseteJadaContext.class);
		}
		public IfLauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifLause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterIfLause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitIfLause(this);
		}
	}

	public final IfLauseContext ifLause() throws RecognitionException {
		IfLauseContext _localctx = new IfLauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifLause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); match(T__10);
			setState(55); match(T__24);
			setState(56); avaldis();
			setState(57); match(T__14);
			setState(58); match(T__19);
			setState(59); lauseteJada();
			setState(60); match(T__15);
			setState(61); match(T__11);
			setState(62); match(T__19);
			setState(63); lauseteJada();
			setState(64); match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileLauseContext extends ParserRuleContext {
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public LauseteJadaContext lauseteJada() {
			return getRuleContext(LauseteJadaContext.class,0);
		}
		public WhileLauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterWhileLause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitWhileLause(this);
		}
	}

	public final WhileLauseContext whileLause() throws RecognitionException {
		WhileLauseContext _localctx = new WhileLauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whileLause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); match(T__16);
			setState(67); match(T__24);
			setState(68); avaldis();
			setState(69); match(T__14);
			setState(70); match(T__19);
			setState(71); lauseteJada();
			setState(72); match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OmistamineContext extends ParserRuleContext {
		public TerminalNode MuutujaNimi() { return getToken(EKPParser.MuutujaNimi, 0); }
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public OmistamineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_omistamine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterOmistamine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitOmistamine(this);
		}
	}

	public final OmistamineContext omistamine() throws RecognitionException {
		OmistamineContext _localctx = new OmistamineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_omistamine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(MuutujaNimi);
			setState(75); match(T__9);
			setState(76); avaldis();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MuutujaDeklaratsioonContext extends ParserRuleContext {
		public TerminalNode MuutujaNimi() { return getToken(EKPParser.MuutujaNimi, 0); }
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public MuutujaDeklaratsioonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_muutujaDeklaratsioon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterMuutujaDeklaratsioon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitMuutujaDeklaratsioon(this);
		}
	}

	public final MuutujaDeklaratsioonContext muutujaDeklaratsioon() throws RecognitionException {
		MuutujaDeklaratsioonContext _localctx = new MuutujaDeklaratsioonContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_muutujaDeklaratsioon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); dataType();
			setState(79); match(MuutujaNimi);
			setState(82);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(80); match(T__9);
				setState(81); avaldis();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitDataType(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dataType);
		int _la;
		try {
			setState(88);
			switch (_input.LA(1)) {
			case T__22:
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__17:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 3);
				{
				setState(86); match(T__28);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(87); match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public List<MuutujaDeklaratsioonContext> muutujaDeklaratsioon() {
			return getRuleContexts(MuutujaDeklaratsioonContext.class);
		}
		public MuutujaDeklaratsioonContext muutujaDeklaratsioon(int i) {
			return getRuleContext(MuutujaDeklaratsioonContext.class,i);
		}
		public TerminalNode MuutujaNimi() { return getToken(EKPParser.MuutujaNimi, 0); }
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public LauseteJadaContext lauseteJada() {
			return getRuleContext(LauseteJadaContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__6) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(91); dataType();
			setState(92); match(MuutujaNimi);
			setState(93); match(T__24);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__22) | (1L << T__18) | (1L << T__17) | (1L << T__13) | (1L << T__4))) != 0)) {
				{
				{
				setState(94); muutujaDeklaratsioon();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27) {
					{
					{
					setState(95); match(T__27);
					setState(96); muutujaDeklaratsioon();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107); match(T__14);
			setState(108); match(T__19);
			setState(109); lauseteJada();
			setState(110); match(T__3);
			setState(111); avaldis();
			setState(112); match(T__8);
			setState(113); match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AvaldisContext extends ParserRuleContext {
		public Avaldis5Context avaldis5() {
			return getRuleContext(Avaldis5Context.class,0);
		}
		public AvaldisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterAvaldis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitAvaldis(this);
		}
	}

	public final AvaldisContext avaldis() throws RecognitionException {
		AvaldisContext _localctx = new AvaldisContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_avaldis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); avaldis5();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Avaldis5Context extends ParserRuleContext {
		public Avaldis5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis5; }
	 
		public Avaldis5Context() { }
		public void copyFrom(Avaldis5Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VordlemineContext extends Avaldis5Context {
		public List<Avaldis4Context> avaldis4() {
			return getRuleContexts(Avaldis4Context.class);
		}
		public Avaldis4Context avaldis4(int i) {
			return getRuleContext(Avaldis4Context.class,i);
		}
		public VordlemineContext(Avaldis5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterVordlemine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitVordlemine(this);
		}
	}
	public static class TriviaalneAvaldis5Context extends Avaldis5Context {
		public Avaldis4Context avaldis4() {
			return getRuleContext(Avaldis4Context.class,0);
		}
		public TriviaalneAvaldis5Context(Avaldis5Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterTriviaalneAvaldis5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitTriviaalneAvaldis5(this);
		}
	}

	public final Avaldis5Context avaldis5() throws RecognitionException {
		Avaldis5Context _localctx = new Avaldis5Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_avaldis5);
		int _la;
		try {
			setState(122);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new VordlemineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117); avaldis4(0);
				setState(118);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__21) | (1L << T__20) | (1L << T__5) | (1L << T__2) | (1L << T__0))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(119); avaldis4(0);
				}
				break;
			case 2:
				_localctx = new TriviaalneAvaldis5Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121); avaldis4(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Avaldis4Context extends ParserRuleContext {
		public Avaldis4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis4; }
	 
		public Avaldis4Context() { }
		public void copyFrom(Avaldis4Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LiitmineLahutamineContext extends Avaldis4Context {
		public Avaldis4Context avaldis4() {
			return getRuleContext(Avaldis4Context.class,0);
		}
		public Avaldis3Context avaldis3() {
			return getRuleContext(Avaldis3Context.class,0);
		}
		public LiitmineLahutamineContext(Avaldis4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterLiitmineLahutamine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitLiitmineLahutamine(this);
		}
	}
	public static class TriviaalneAvaldis4Context extends Avaldis4Context {
		public Avaldis3Context avaldis3() {
			return getRuleContext(Avaldis3Context.class,0);
		}
		public TriviaalneAvaldis4Context(Avaldis4Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterTriviaalneAvaldis4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitTriviaalneAvaldis4(this);
		}
	}

	public final Avaldis4Context avaldis4() throws RecognitionException {
		return avaldis4(0);
	}

	private Avaldis4Context avaldis4(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Avaldis4Context _localctx = new Avaldis4Context(_ctx, _parentState);
		Avaldis4Context _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_avaldis4, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TriviaalneAvaldis4Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(125); avaldis3(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LiitmineLahutamineContext(new Avaldis4Context(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_avaldis4);
					setState(127);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(128);
					_la = _input.LA(1);
					if ( !(_la==T__26 || _la==T__12) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(129); avaldis3(0);
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Avaldis3Context extends ParserRuleContext {
		public Avaldis3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis3; }
	 
		public Avaldis3Context() { }
		public void copyFrom(Avaldis3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TriviaalneAvaldis3Context extends Avaldis3Context {
		public Avaldis2Context avaldis2() {
			return getRuleContext(Avaldis2Context.class,0);
		}
		public TriviaalneAvaldis3Context(Avaldis3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterTriviaalneAvaldis3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitTriviaalneAvaldis3(this);
		}
	}
	public static class KorrutamineJagamineContext extends Avaldis3Context {
		public Avaldis3Context avaldis3() {
			return getRuleContext(Avaldis3Context.class,0);
		}
		public Avaldis2Context avaldis2() {
			return getRuleContext(Avaldis2Context.class,0);
		}
		public KorrutamineJagamineContext(Avaldis3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterKorrutamineJagamine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitKorrutamineJagamine(this);
		}
	}

	public final Avaldis3Context avaldis3() throws RecognitionException {
		return avaldis3(0);
	}

	private Avaldis3Context avaldis3(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Avaldis3Context _localctx = new Avaldis3Context(_ctx, _parentState);
		Avaldis3Context _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_avaldis3, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TriviaalneAvaldis3Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(136); avaldis2();
			}
			_ctx.stop = _input.LT(-1);
			setState(143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new KorrutamineJagamineContext(new Avaldis3Context(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_avaldis3);
					setState(138);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(139);
					_la = _input.LA(1);
					if ( !(_la==T__25 || _la==T__1) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(140); avaldis2();
					}
					} 
				}
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Avaldis2Context extends ParserRuleContext {
		public Avaldis2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis2; }
	 
		public Avaldis2Context() { }
		public void copyFrom(Avaldis2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaarneMiinusContext extends Avaldis2Context {
		public Avaldis2Context avaldis2() {
			return getRuleContext(Avaldis2Context.class,0);
		}
		public UnaarneMiinusContext(Avaldis2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterUnaarneMiinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitUnaarneMiinus(this);
		}
	}
	public static class TriviaalneAvaldis2Context extends Avaldis2Context {
		public Avaldis1Context avaldis1() {
			return getRuleContext(Avaldis1Context.class,0);
		}
		public TriviaalneAvaldis2Context(Avaldis2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterTriviaalneAvaldis2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitTriviaalneAvaldis2(this);
		}
	}

	public final Avaldis2Context avaldis2() throws RecognitionException {
		Avaldis2Context _localctx = new Avaldis2Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_avaldis2);
		try {
			setState(149);
			switch (_input.LA(1)) {
			case T__26:
				_localctx = new UnaarneMiinusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(146); match(T__26);
				setState(147); avaldis2();
				}
				break;
			case T__24:
			case MuutujaNimi:
			case Arvuliteraal:
			case Soneliteraal:
				_localctx = new TriviaalneAvaldis2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(148); avaldis1();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Avaldis1Context extends ParserRuleContext {
		public Avaldis1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis1; }
	 
		public Avaldis1Context() { }
		public void copyFrom(Avaldis1Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunktsiooniValjakutseContext extends Avaldis1Context {
		public TerminalNode MuutujaNimi() { return getToken(EKPParser.MuutujaNimi, 0); }
		public List<AvaldisContext> avaldis() {
			return getRuleContexts(AvaldisContext.class);
		}
		public AvaldisContext avaldis(int i) {
			return getRuleContext(AvaldisContext.class,i);
		}
		public FunktsiooniValjakutseContext(Avaldis1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterFunktsiooniValjakutse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitFunktsiooniValjakutse(this);
		}
	}
	public static class TriviaalneAvaldis1Context extends Avaldis1Context {
		public Avaldis0Context avaldis0() {
			return getRuleContext(Avaldis0Context.class,0);
		}
		public TriviaalneAvaldis1Context(Avaldis1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterTriviaalneAvaldis1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitTriviaalneAvaldis1(this);
		}
	}

	public final Avaldis1Context avaldis1() throws RecognitionException {
		Avaldis1Context _localctx = new Avaldis1Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_avaldis1);
		int _la;
		try {
			setState(165);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new FunktsiooniValjakutseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(151); match(MuutujaNimi);
				setState(152); match(T__24);
				setState(161);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__24) | (1L << MuutujaNimi) | (1L << Arvuliteraal) | (1L << Soneliteraal))) != 0)) {
					{
					setState(153); avaldis();
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__27) {
						{
						{
						setState(154); match(T__27);
						setState(155); avaldis();
						}
						}
						setState(160);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(163); match(T__14);
				}
				break;
			case 2:
				_localctx = new TriviaalneAvaldis1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164); avaldis0();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Avaldis0Context extends ParserRuleContext {
		public Avaldis0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avaldis0; }
	 
		public Avaldis0Context() { }
		public void copyFrom(Avaldis0Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SuluavaldisContext extends Avaldis0Context {
		public AvaldisContext avaldis() {
			return getRuleContext(AvaldisContext.class,0);
		}
		public SuluavaldisContext(Avaldis0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterSuluavaldis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitSuluavaldis(this);
		}
	}
	public static class SoneliteraalRContext extends Avaldis0Context {
		public TerminalNode Soneliteraal() { return getToken(EKPParser.Soneliteraal, 0); }
		public SoneliteraalRContext(Avaldis0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterSoneliteraalR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitSoneliteraalR(this);
		}
	}
	public static class ArvuliteraalRContext extends Avaldis0Context {
		public TerminalNode Arvuliteraal() { return getToken(EKPParser.Arvuliteraal, 0); }
		public ArvuliteraalRContext(Avaldis0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterArvuliteraalR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitArvuliteraalR(this);
		}
	}
	public static class MuutujaNimiRContext extends Avaldis0Context {
		public TerminalNode MuutujaNimi() { return getToken(EKPParser.MuutujaNimi, 0); }
		public MuutujaNimiRContext(Avaldis0Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).enterMuutujaNimiR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EKPListener ) ((EKPListener)listener).exitMuutujaNimiR(this);
		}
	}

	public final Avaldis0Context avaldis0() throws RecognitionException {
		Avaldis0Context _localctx = new Avaldis0Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_avaldis0);
		try {
			setState(174);
			switch (_input.LA(1)) {
			case MuutujaNimi:
				_localctx = new MuutujaNimiRContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(167); match(MuutujaNimi);
				}
				break;
			case Arvuliteraal:
				_localctx = new ArvuliteraalRContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(168); match(Arvuliteraal);
				}
				break;
			case Soneliteraal:
				_localctx = new SoneliteraalRContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(169); match(Soneliteraal);
				}
				break;
			case T__24:
				_localctx = new SuluavaldisContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(170); match(T__24);
				setState(171); avaldis();
				setState(172); match(T__14);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11: return avaldis4_sempred((Avaldis4Context)_localctx, predIndex);
		case 12: return avaldis3_sempred((Avaldis3Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean avaldis3_sempred(Avaldis3Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean avaldis4_sempred(Avaldis4Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%\u00b3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4\67\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\bU\n\b\3"+
		"\t\3\t\3\t\3\t\5\t[\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nd\n\n\f\n\16\n"+
		"g\13\n\7\ni\n\n\f\n\16\nl\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\5\f}\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0085\n\r"+
		"\f\r\16\r\u0088\13\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0090\n\16\f\16"+
		"\16\16\u0093\13\16\3\17\3\17\3\17\5\17\u0098\n\17\3\20\3\20\3\20\3\20"+
		"\3\20\7\20\u009f\n\20\f\20\16\20\u00a2\13\20\5\20\u00a4\n\20\3\20\3\20"+
		"\5\20\u00a8\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00b1\n\21\3"+
		"\21\2\4\30\32\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\b\4\2\t\t\22"+
		"\22\4\2\16\16\33\33\3\2\30\31\7\2\b\b\n\13\32\32\35\35\37\37\4\2\5\5\23"+
		"\23\4\2\6\6\36\36\u00b9\2\"\3\2\2\2\4)\3\2\2\2\6\66\3\2\2\2\b8\3\2\2\2"+
		"\nD\3\2\2\2\fL\3\2\2\2\16P\3\2\2\2\20Z\3\2\2\2\22\\\3\2\2\2\24u\3\2\2"+
		"\2\26|\3\2\2\2\30~\3\2\2\2\32\u0089\3\2\2\2\34\u0097\3\2\2\2\36\u00a7"+
		"\3\2\2\2 \u00b0\3\2\2\2\"#\5\4\3\2#\3\3\2\2\2$%\5\6\4\2%&\7\27\2\2&(\3"+
		"\2\2\2\'$\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+)\3\2\2\2"+
		",\67\5\b\5\2-\67\5\n\6\2.\67\5\f\7\2/\67\5\16\b\2\60\67\5\24\13\2\61\62"+
		"\7\f\2\2\62\63\5\4\3\2\63\64\7\20\2\2\64\67\3\2\2\2\65\67\5\22\n\2\66"+
		",\3\2\2\2\66-\3\2\2\2\66.\3\2\2\2\66/\3\2\2\2\66\60\3\2\2\2\66\61\3\2"+
		"\2\2\66\65\3\2\2\2\67\7\3\2\2\289\7\25\2\29:\7\7\2\2:;\5\24\13\2;<\7\21"+
		"\2\2<=\7\f\2\2=>\5\4\3\2>?\7\20\2\2?@\7\24\2\2@A\7\f\2\2AB\5\4\3\2BC\7"+
		"\20\2\2C\t\3\2\2\2DE\7\17\2\2EF\7\7\2\2FG\5\24\13\2GH\7\21\2\2HI\7\f\2"+
		"\2IJ\5\4\3\2JK\7\20\2\2K\13\3\2\2\2LM\7 \2\2MN\7\26\2\2NO\5\24\13\2O\r"+
		"\3\2\2\2PQ\5\20\t\2QT\7 \2\2RS\7\26\2\2SU\5\24\13\2TR\3\2\2\2TU\3\2\2"+
		"\2U\17\3\2\2\2V[\t\2\2\2W[\t\3\2\2X[\7\3\2\2Y[\7\r\2\2ZV\3\2\2\2ZW\3\2"+
		"\2\2ZX\3\2\2\2ZY\3\2\2\2[\21\3\2\2\2\\]\t\4\2\2]^\5\20\t\2^_\7 \2\2_j"+
		"\7\7\2\2`e\5\16\b\2ab\7\4\2\2bd\5\16\b\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2"+
		"ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2h`\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"km\3\2\2\2lj\3\2\2\2mn\7\21\2\2no\7\f\2\2op\5\4\3\2pq\7\34\2\2qr\5\24"+
		"\13\2rs\7\27\2\2st\7\20\2\2t\23\3\2\2\2uv\5\26\f\2v\25\3\2\2\2wx\5\30"+
		"\r\2xy\t\5\2\2yz\5\30\r\2z}\3\2\2\2{}\5\30\r\2|w\3\2\2\2|{\3\2\2\2}\27"+
		"\3\2\2\2~\177\b\r\1\2\177\u0080\5\32\16\2\u0080\u0086\3\2\2\2\u0081\u0082"+
		"\f\4\2\2\u0082\u0083\t\6\2\2\u0083\u0085\5\32\16\2\u0084\u0081\3\2\2\2"+
		"\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\31"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\b\16\1\2\u008a\u008b\5\34\17"+
		"\2\u008b\u0091\3\2\2\2\u008c\u008d\f\4\2\2\u008d\u008e\t\7\2\2\u008e\u0090"+
		"\5\34\17\2\u008f\u008c\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\33\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095"+
		"\7\5\2\2\u0095\u0098\5\34\17\2\u0096\u0098\5\36\20\2\u0097\u0094\3\2\2"+
		"\2\u0097\u0096\3\2\2\2\u0098\35\3\2\2\2\u0099\u009a\7 \2\2\u009a\u00a3"+
		"\7\7\2\2\u009b\u00a0\5\24\13\2\u009c\u009d\7\4\2\2\u009d\u009f\5\24\13"+
		"\2\u009e\u009c\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1"+
		"\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u009b\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8\7\21\2\2\u00a6\u00a8\5"+
		" \21\2\u00a7\u0099\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\37\3\2\2\2\u00a9"+
		"\u00b1\7 \2\2\u00aa\u00b1\7!\2\2\u00ab\u00b1\7\"\2\2\u00ac\u00ad\7\7\2"+
		"\2\u00ad\u00ae\5\24\13\2\u00ae\u00af\7\21\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00a9\3\2\2\2\u00b0\u00aa\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00ac\3\2"+
		"\2\2\u00b1!\3\2\2\2\20)\66TZej|\u0086\u0091\u0097\u00a0\u00a3\u00a7\u00b0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}