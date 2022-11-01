// Generated from /Users/stanly/Project/Veridise/V/V.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LBRACK=3, RBRACK=4, COMMA=5, SENT=6, FSUM=7, WILDCARD=8, 
		DOT=9, SEQ=10, ASSN=11, LET=12, FOREACH=13, IN=14, IMPORT=15, VARS_LABEL=16, 
		PRECOND_LABEL=17, POSTCOND_LABEL=18, INIT_LABEL=19, SPEC_LABEL=20, SYNTH_LABEL=21, 
		LTLFAIR_LABEL=22, LTLPROP_LABEL=23, INV_LABEL=24, ATOM_PRE_LOC=25, ATOM_POST_LOC=26, 
		CONTRACT_INV=27, PRE_SEP=28, IMP=29, T_BIN=30, T_UN=31, PATH=32, IDENTIFIER=33, 
		A1_BIN=34, A2_BIN=35, A_UN=36, C_BIN=37, L_BIN=38, L_UN=39, NUM=40, NEG_NUM=41, 
		NEWLINE=42, WHITESPACE=43, LINE_COMMENT=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LPAREN", "RPAREN", "LBRACK", "RBRACK", "COMMA", "SENT", "FSUM", "WILDCARD", 
			"DOT", "SEQ", "ASSN", "LET", "FOREACH", "IN", "IMPORT", "VARS_LABEL", 
			"PRECOND_LABEL", "POSTCOND_LABEL", "INIT_LABEL", "SPEC_LABEL", "SYNTH_LABEL", 
			"LTLFAIR_LABEL", "LTLPROP_LABEL", "INV_LABEL", "ATOM_PRE_LOC", "ATOM_POST_LOC", 
			"CONTRACT_INV", "PRE_SEP", "IMP", "T_BIN", "T_UN", "PATH", "IDENTIFIER", 
			"A1_BIN", "A2_BIN", "A_UN", "C_BIN", "L_BIN", "L_UN", "NUM", "NEG_NUM", 
			"NEWLINE", "WHITESPACE", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "','", "'sent'", "'fsum'", "'*'", "'.'", 
			"';'", "':='", "'let'", "'foreach'", "':'", "'import:'", null, null, 
			null, null, null, null, "'LTLFairness:'", "'LTLProperty:'", null, null, 
			null, "'Cinv'", "'|=>'", "'==>'", null, null, null, null, null, null, 
			"'-'", null, null, "'!'", null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LBRACK", "RBRACK", "COMMA", "SENT", "FSUM", 
			"WILDCARD", "DOT", "SEQ", "ASSN", "LET", "FOREACH", "IN", "IMPORT", "VARS_LABEL", 
			"PRECOND_LABEL", "POSTCOND_LABEL", "INIT_LABEL", "SPEC_LABEL", "SYNTH_LABEL", 
			"LTLFAIR_LABEL", "LTLPROP_LABEL", "INV_LABEL", "ATOM_PRE_LOC", "ATOM_POST_LOC", 
			"CONTRACT_INV", "PRE_SEP", "IMP", "T_BIN", "T_UN", "PATH", "IDENTIFIER", 
			"A1_BIN", "A2_BIN", "A_UN", "C_BIN", "L_BIN", "L_UN", "NUM", "NEG_NUM", 
			"NEWLINE", "WHITESPACE", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public VLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "V.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0241\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00ad\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00d3\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00fd\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u0117\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u014d\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0171"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u01a9\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u01c5\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u01d7\n\33\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \5 \u01eb\n \3!"+
		"\3!\3!\6!\u01f0\n!\r!\16!\u01f1\3!\3!\3\"\3\"\7\"\u01f8\n\"\f\"\16\"\u01fb"+
		"\13\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\5&\u020b\n&\3\'\3\'\3"+
		"\'\3\'\5\'\u0211\n\'\3(\3(\3)\6)\u0216\n)\r)\16)\u0217\3)\6)\u021b\n)"+
		"\r)\16)\u021c\3)\3)\6)\u0221\n)\r)\16)\u0222\5)\u0225\n)\3*\3*\3*\3+\5"+
		"+\u022b\n+\3+\3+\6+\u022f\n+\r+\16+\u0230\3+\3+\3,\3,\3,\3,\3-\3-\7-\u023b"+
		"\n-\f-\16-\u023e\13-\3-\3-\2\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.\3\2\f"+
		"\4\2TTWW\4\2\60\61BB\6\2/;C\\aac|\5\2C\\aac|\6\2\62;C\\aac|\4\2,,\61\61"+
		"\4\2--//\4\2>>@@\3\2\62;\4\2\f\f\17\17\2\u026a\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13c\3\2\2\2\re\3"+
		"\2\2\2\17j\3\2\2\2\21o\3\2\2\2\23q\3\2\2\2\25s\3\2\2\2\27u\3\2\2\2\31"+
		"x\3\2\2\2\33|\3\2\2\2\35\u0084\3\2\2\2\37\u0086\3\2\2\2!\u00ac\3\2\2\2"+
		"#\u00d2\3\2\2\2%\u00fc\3\2\2\2\'\u0116\3\2\2\2)\u014c\3\2\2\2+\u0170\3"+
		"\2\2\2-\u0172\3\2\2\2/\u017f\3\2\2\2\61\u01a8\3\2\2\2\63\u01c4\3\2\2\2"+
		"\65\u01d6\3\2\2\2\67\u01d8\3\2\2\29\u01dd\3\2\2\2;\u01e1\3\2\2\2=\u01e5"+
		"\3\2\2\2?\u01ea\3\2\2\2A\u01ec\3\2\2\2C\u01f5\3\2\2\2E\u01fc\3\2\2\2G"+
		"\u01fe\3\2\2\2I\u0200\3\2\2\2K\u020a\3\2\2\2M\u0210\3\2\2\2O\u0212\3\2"+
		"\2\2Q\u0224\3\2\2\2S\u0226\3\2\2\2U\u022e\3\2\2\2W\u0234\3\2\2\2Y\u0238"+
		"\3\2\2\2[\\\7*\2\2\\\4\3\2\2\2]^\7+\2\2^\6\3\2\2\2_`\7]\2\2`\b\3\2\2\2"+
		"ab\7_\2\2b\n\3\2\2\2cd\7.\2\2d\f\3\2\2\2ef\7u\2\2fg\7g\2\2gh\7p\2\2hi"+
		"\7v\2\2i\16\3\2\2\2jk\7h\2\2kl\7u\2\2lm\7w\2\2mn\7o\2\2n\20\3\2\2\2op"+
		"\7,\2\2p\22\3\2\2\2qr\7\60\2\2r\24\3\2\2\2st\7=\2\2t\26\3\2\2\2uv\7<\2"+
		"\2vw\7?\2\2w\30\3\2\2\2xy\7n\2\2yz\7g\2\2z{\7v\2\2{\32\3\2\2\2|}\7h\2"+
		"\2}~\7q\2\2~\177\7t\2\2\177\u0080\7g\2\2\u0080\u0081\7c\2\2\u0081\u0082"+
		"\7e\2\2\u0082\u0083\7j\2\2\u0083\34\3\2\2\2\u0084\u0085\7<\2\2\u0085\36"+
		"\3\2\2\2\u0086\u0087\7k\2\2\u0087\u0088\7o\2\2\u0088\u0089\7r\2\2\u0089"+
		"\u008a\7q\2\2\u008a\u008b\7t\2\2\u008b\u008c\7v\2\2\u008c\u008d\7<\2\2"+
		"\u008d \3\2\2\2\u008e\u008f\7X\2\2\u008f\u0090\7c\2\2\u0090\u0091\7t\2"+
		"\2\u0091\u0092\7u\2\2\u0092\u00ad\7<\2\2\u0093\u0094\7x\2\2\u0094\u0095"+
		"\7c\2\2\u0095\u0096\7t\2\2\u0096\u0097\7u\2\2\u0097\u00ad\7<\2\2\u0098"+
		"\u0099\7X\2\2\u0099\u009a\7c\2\2\u009a\u009b\7t\2\2\u009b\u009c\7k\2\2"+
		"\u009c\u009d\7c\2\2\u009d\u009e\7d\2\2\u009e\u009f\7n\2\2\u009f\u00a0"+
		"\7g\2\2\u00a0\u00a1\7u\2\2\u00a1\u00ad\7<\2\2\u00a2\u00a3\7x\2\2\u00a3"+
		"\u00a4\7c\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7c\2\2"+
		"\u00a7\u00a8\7d\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab"+
		"\7u\2\2\u00ab\u00ad\7<\2\2\u00ac\u008e\3\2\2\2\u00ac\u0093\3\2\2\2\u00ac"+
		"\u0098\3\2\2\2\u00ac\u00a2\3\2\2\2\u00ad\"\3\2\2\2\u00ae\u00af\7R\2\2"+
		"\u00af\u00b0\7t\2\2\u00b0\u00b1\7g\2\2\u00b1\u00d3\7<\2\2\u00b2\u00b3"+
		"\7r\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7g\2\2\u00b5\u00d3\7<\2\2\u00b6"+
		"\u00b7\7R\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7e\2\2"+
		"\u00ba\u00bb\7q\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7f\2\2\u00bd\u00be"+
		"\7k\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7q\2\2\u00c1"+
		"\u00c2\7p\2\2\u00c2\u00c3\7u\2\2\u00c3\u00d3\7<\2\2\u00c4\u00c5\7r\2\2"+
		"\u00c5\u00c6\7t\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7e\2\2\u00c8\u00c9"+
		"\7q\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cb\7f\2\2\u00cb\u00cc\7k\2\2\u00cc"+
		"\u00cd\7v\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7q\2\2\u00cf\u00d0\7p\2\2"+
		"\u00d0\u00d1\7u\2\2\u00d1\u00d3\7<\2\2\u00d2\u00ae\3\2\2\2\u00d2\u00b2"+
		"\3\2\2\2\u00d2\u00b6\3\2\2\2\u00d2\u00c4\3\2\2\2\u00d3$\3\2\2\2\u00d4"+
		"\u00d5\7R\2\2\u00d5\u00d6\7q\2\2\u00d6\u00d7\7u\2\2\u00d7\u00d8\7v\2\2"+
		"\u00d8\u00fd\7<\2\2\u00d9\u00da\7r\2\2\u00da\u00db\7q\2\2\u00db\u00dc"+
		"\7u\2\2\u00dc\u00dd\7v\2\2\u00dd\u00fd\7<\2\2\u00de\u00df\7R\2\2\u00df"+
		"\u00e0\7q\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7e\2\2"+
		"\u00e3\u00e4\7q\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7f\2\2\u00e6\u00e7"+
		"\7k\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea\7q\2\2\u00ea"+
		"\u00eb\7p\2\2\u00eb\u00ec\7u\2\2\u00ec\u00fd\7<\2\2\u00ed\u00ee\7r\2\2"+
		"\u00ee\u00ef\7q\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2"+
		"\7e\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7f\2\2\u00f5"+
		"\u00f6\7k\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\7k\2\2\u00f8\u00f9\7q\2\2"+
		"\u00f9\u00fa\7p\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fd\7<\2\2\u00fc\u00d4"+
		"\3\2\2\2\u00fc\u00d9\3\2\2\2\u00fc\u00de\3\2\2\2\u00fc\u00ed\3\2\2\2\u00fd"+
		"&\3\2\2\2\u00fe\u00ff\7K\2\2\u00ff\u0100\7p\2\2\u0100\u0101\7k\2\2\u0101"+
		"\u0102\7v\2\2\u0102\u0117\7<\2\2\u0103\u0104\7k\2\2\u0104\u0105\7p\2\2"+
		"\u0105\u0106\7k\2\2\u0106\u0107\7v\2\2\u0107\u0117\7<\2\2\u0108\u0109"+
		"\7C\2\2\u0109\u010a\7u\2\2\u010a\u010b\7u\2\2\u010b\u010c\7w\2\2\u010c"+
		"\u010d\7o\2\2\u010d\u010e\7g\2\2\u010e\u0117\7<\2\2\u010f\u0110\7c\2\2"+
		"\u0110\u0111\7u\2\2\u0111\u0112\7u\2\2\u0112\u0113\7w\2\2\u0113\u0114"+
		"\7o\2\2\u0114\u0115\7g\2\2\u0115\u0117\7<\2\2\u0116\u00fe\3\2\2\2\u0116"+
		"\u0103\3\2\2\2\u0116\u0108\3\2\2\2\u0116\u010f\3\2\2\2\u0117(\3\2\2\2"+
		"\u0118\u0119\7U\2\2\u0119\u011a\7r\2\2\u011a\u011b\7g\2\2\u011b\u011c"+
		"\7e\2\2\u011c\u014d\7<\2\2\u011d\u011e\7U\2\2\u011e\u011f\7r\2\2\u011f"+
		"\u0120\7g\2\2\u0120\u0121\7e\2\2\u0121\u0122\7k\2\2\u0122\u0123\7h\2\2"+
		"\u0123\u0124\7k\2\2\u0124\u0125\7e\2\2\u0125\u0126\7c\2\2\u0126\u0127"+
		"\7v\2\2\u0127\u0128\7k\2\2\u0128\u0129\7q\2\2\u0129\u012a\7p\2\2\u012a"+
		"\u014d\7<\2\2\u012b\u012c\7u\2\2\u012c\u012d\7r\2\2\u012d\u012e\7g\2\2"+
		"\u012e\u012f\7e\2\2\u012f\u014d\7<\2\2\u0130\u0131\7u\2\2\u0131\u0132"+
		"\7r\2\2\u0132\u0133\7g\2\2\u0133\u0134\7e\2\2\u0134\u0135\7k\2\2\u0135"+
		"\u0136\7h\2\2\u0136\u0137\7k\2\2\u0137\u0138\7e\2\2\u0138\u0139\7c\2\2"+
		"\u0139\u013a\7v\2\2\u013a\u013b\7k\2\2\u013b\u013c\7q\2\2\u013c\u013d"+
		"\7p\2\2\u013d\u014d\7<\2\2\u013e\u013f\7C\2\2\u013f\u0140\7u\2\2\u0140"+
		"\u0141\7u\2\2\u0141\u0142\7g\2\2\u0142\u0143\7t\2\2\u0143\u0144\7v\2\2"+
		"\u0144\u014d\7<\2\2\u0145\u0146\7c\2\2\u0146\u0147\7u\2\2\u0147\u0148"+
		"\7u\2\2\u0148\u0149\7g\2\2\u0149\u014a\7t\2\2\u014a\u014b\7v\2\2\u014b"+
		"\u014d\7<\2\2\u014c\u0118\3\2\2\2\u014c\u011d\3\2\2\2\u014c\u012b\3\2"+
		"\2\2\u014c\u0130\3\2\2\2\u014c\u013e\3\2\2\2\u014c\u0145\3\2\2\2\u014d"+
		"*\3\2\2\2\u014e\u014f\7U\2\2\u014f\u0150\7{\2\2\u0150\u0151\7p\2\2\u0151"+
		"\u0152\7v\2\2\u0152\u0153\7j\2\2\u0153\u0171\7<\2\2\u0154\u0155\7U\2\2"+
		"\u0155\u0156\7{\2\2\u0156\u0157\7p\2\2\u0157\u0158\7v\2\2\u0158\u0159"+
		"\7j\2\2\u0159\u015a\7g\2\2\u015a\u015b\7u\2\2\u015b\u015c\7k\2\2\u015c"+
		"\u015d\7|\2\2\u015d\u015e\7g\2\2\u015e\u0171\7<\2\2\u015f\u0160\7u\2\2"+
		"\u0160\u0161\7{\2\2\u0161\u0162\7p\2\2\u0162\u0163\7v\2\2\u0163\u0164"+
		"\7j\2\2\u0164\u0171\7<\2\2\u0165\u0166\7u\2\2\u0166\u0167\7{\2\2\u0167"+
		"\u0168\7p\2\2\u0168\u0169\7v\2\2\u0169\u016a\7j\2\2\u016a\u016b\7g\2\2"+
		"\u016b\u016c\7u\2\2\u016c\u016d\7k\2\2\u016d\u016e\7|\2\2\u016e\u016f"+
		"\7g\2\2\u016f\u0171\7<\2\2\u0170\u014e\3\2\2\2\u0170\u0154\3\2\2\2\u0170"+
		"\u015f\3\2\2\2\u0170\u0165\3\2\2\2\u0171,\3\2\2\2\u0172\u0173\7N\2\2\u0173"+
		"\u0174\7V\2\2\u0174\u0175\7N\2\2\u0175\u0176\7H\2\2\u0176\u0177\7c\2\2"+
		"\u0177\u0178\7k\2\2\u0178\u0179\7t\2\2\u0179\u017a\7p\2\2\u017a\u017b"+
		"\7g\2\2\u017b\u017c\7u\2\2\u017c\u017d\7u\2\2\u017d\u017e\7<\2\2\u017e"+
		".\3\2\2\2\u017f\u0180\7N\2\2\u0180\u0181\7V\2\2\u0181\u0182\7N\2\2\u0182"+
		"\u0183\7R\2\2\u0183\u0184\7t\2\2\u0184\u0185\7q\2\2\u0185\u0186\7r\2\2"+
		"\u0186\u0187\7g\2\2\u0187\u0188\7t\2\2\u0188\u0189\7v\2\2\u0189\u018a"+
		"\7{\2\2\u018a\u018b\7<\2\2\u018b\60\3\2\2\2\u018c\u018d\7K\2\2\u018d\u018e"+
		"\7p\2\2\u018e\u018f\7x\2\2\u018f\u01a9\7<\2\2\u0190\u0191\7k\2\2\u0191"+
		"\u0192\7p\2\2\u0192\u0193\7x\2\2\u0193\u01a9\7<\2\2\u0194\u0195\7K\2\2"+
		"\u0195\u0196\7p\2\2\u0196\u0197\7x\2\2\u0197\u0198\7c\2\2\u0198\u0199"+
		"\7t\2\2\u0199\u019a\7k\2\2\u019a\u019b\7c\2\2\u019b\u019c\7p\2\2\u019c"+
		"\u019d\7v\2\2\u019d\u01a9\7<\2\2\u019e\u019f\7k\2\2\u019f\u01a0\7p\2\2"+
		"\u01a0\u01a1\7x\2\2\u01a1\u01a2\7c\2\2\u01a2\u01a3\7t\2\2\u01a3\u01a4"+
		"\7k\2\2\u01a4\u01a5\7c\2\2\u01a5\u01a6\7p\2\2\u01a6\u01a7\7v\2\2\u01a7"+
		"\u01a9\7<\2\2\u01a8\u018c\3\2\2\2\u01a8\u0190\3\2\2\2\u01a8\u0194\3\2"+
		"\2\2\u01a8\u019e\3\2\2\2\u01a9\62\3\2\2\2\u01aa\u01ab\7u\2\2\u01ab\u01ac"+
		"\7v\2\2\u01ac\u01ad\7c\2\2\u01ad\u01ae\7t\2\2\u01ae\u01af\7v\2\2\u01af"+
		"\u01b0\7g\2\2\u01b0\u01c5\7f\2\2\u01b1\u01b2\7t\2\2\u01b2\u01b3\7g\2\2"+
		"\u01b3\u01b4\7x\2\2\u01b4\u01b5\7g\2\2\u01b5\u01b6\7t\2\2\u01b6\u01b7"+
		"\7v\2\2\u01b7\u01b8\7g\2\2\u01b8\u01c5\7f\2\2\u01b9\u01ba\7y\2\2\u01ba"+
		"\u01bb\7k\2\2\u01bb\u01bc\7n\2\2\u01bc\u01bd\7n\2\2\u01bd\u01be\7U\2\2"+
		"\u01be\u01bf\7w\2\2\u01bf\u01c0\7e\2\2\u01c0\u01c1\7e\2\2\u01c1\u01c2"+
		"\7g\2\2\u01c2\u01c3\7g\2\2\u01c3\u01c5\7f\2\2\u01c4\u01aa\3\2\2\2\u01c4"+
		"\u01b1\3\2\2\2\u01c4\u01b9\3\2\2\2\u01c5\64\3\2\2\2\u01c6\u01c7\7g\2\2"+
		"\u01c7\u01c8\7z\2\2\u01c8\u01c9\7g\2\2\u01c9\u01ca\7e\2\2\u01ca\u01cb"+
		"\7w\2\2\u01cb\u01cc\7v\2\2\u01cc\u01cd\7g\2\2\u01cd\u01d7\7f\2\2\u01ce"+
		"\u01cf\7h\2\2\u01cf\u01d0\7k\2\2\u01d0\u01d1\7p\2\2\u01d1\u01d2\7k\2\2"+
		"\u01d2\u01d3\7u\2\2\u01d3\u01d4\7j\2\2\u01d4\u01d5\7g\2\2\u01d5\u01d7"+
		"\7f\2\2\u01d6\u01c6\3\2\2\2\u01d6\u01ce\3\2\2\2\u01d7\66\3\2\2\2\u01d8"+
		"\u01d9\7E\2\2\u01d9\u01da\7k\2\2\u01da\u01db\7p\2\2\u01db\u01dc\7x\2\2"+
		"\u01dc8\3\2\2\2\u01dd\u01de\7~\2\2\u01de\u01df\7?\2\2\u01df\u01e0\7@\2"+
		"\2\u01e0:\3\2\2\2\u01e1\u01e2\7?\2\2\u01e2\u01e3\7?\2\2\u01e3\u01e4\7"+
		"@\2\2\u01e4<\3\2\2\2\u01e5\u01e6\t\2\2\2\u01e6>\3\2\2\2\u01e7\u01e8\7"+
		">\2\2\u01e8\u01eb\7@\2\2\u01e9\u01eb\7Z\2\2\u01ea\u01e7\3\2\2\2\u01ea"+
		"\u01e9\3\2\2\2\u01eb@\3\2\2\2\u01ec\u01ed\7$\2\2\u01ed\u01ef\t\3\2\2\u01ee"+
		"\u01f0\t\4\2\2\u01ef\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01ef\3\2"+
		"\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\7$\2\2\u01f4"+
		"B\3\2\2\2\u01f5\u01f9\t\5\2\2\u01f6\u01f8\t\6\2\2\u01f7\u01f6\3\2\2\2"+
		"\u01f8\u01fb\3\2\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01faD\3"+
		"\2\2\2\u01fb\u01f9\3\2\2\2\u01fc\u01fd\t\7\2\2\u01fdF\3\2\2\2\u01fe\u01ff"+
		"\t\b\2\2\u01ffH\3\2\2\2\u0200\u0201\7/\2\2\u0201J\3\2\2\2\u0202\u020b"+
		"\7?\2\2\u0203\u0204\7#\2\2\u0204\u020b\7?\2\2\u0205\u020b\t\t\2\2\u0206"+
		"\u0207\7>\2\2\u0207\u020b\7?\2\2\u0208\u0209\7@\2\2\u0209\u020b\7?\2\2"+
		"\u020a\u0202\3\2\2\2\u020a\u0203\3\2\2\2\u020a\u0205\3\2\2\2\u020a\u0206"+
		"\3\2\2\2\u020a\u0208\3\2\2\2\u020bL\3\2\2\2\u020c\u020d\7(\2\2\u020d\u0211"+
		"\7(\2\2\u020e\u020f\7~\2\2\u020f\u0211\7~\2\2\u0210\u020c\3\2\2\2\u0210"+
		"\u020e\3\2\2\2\u0211N\3\2\2\2\u0212\u0213\7#\2\2\u0213P\3\2\2\2\u0214"+
		"\u0216\t\n\2\2\u0215\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0215\3\2"+
		"\2\2\u0217\u0218\3\2\2\2\u0218\u0225\3\2\2\2\u0219\u021b\t\n\2\2\u021a"+
		"\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2"+
		"\2\2\u021d\u021e\3\2\2\2\u021e\u0220\7g\2\2\u021f\u0221\t\n\2\2\u0220"+
		"\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0220\3\2\2\2\u0222\u0223\3\2"+
		"\2\2\u0223\u0225\3\2\2\2\u0224\u0215\3\2\2\2\u0224\u021a\3\2\2\2\u0225"+
		"R\3\2\2\2\u0226\u0227\7/\2\2\u0227\u0228\5Q)\2\u0228T\3\2\2\2\u0229\u022b"+
		"\7\17\2\2\u022a\u0229\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022c\3\2\2\2"+
		"\u022c\u022f\7\f\2\2\u022d\u022f\7\17\2\2\u022e\u022a\3\2\2\2\u022e\u022d"+
		"\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231"+
		"\u0232\3\2\2\2\u0232\u0233\b+\2\2\u0233V\3\2\2\2\u0234\u0235\7\"\2\2\u0235"+
		"\u0236\3\2\2\2\u0236\u0237\b,\2\2\u0237X\3\2\2\2\u0238\u023c\7%\2\2\u0239"+
		"\u023b\n\13\2\2\u023a\u0239\3\2\2\2\u023b\u023e\3\2\2\2\u023c\u023a\3"+
		"\2\2\2\u023c\u023d\3\2\2\2\u023d\u023f\3\2\2\2\u023e\u023c\3\2\2\2\u023f"+
		"\u0240\b-\2\2\u0240Z\3\2\2\2\31\2\u00ac\u00d2\u00fc\u0116\u014c\u0170"+
		"\u01a8\u01c4\u01d6\u01ea\u01f1\u01f9\u020a\u0210\u0217\u021c\u0222\u0224"+
		"\u022a\u022e\u0230\u023c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}