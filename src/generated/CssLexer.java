package generated;
// Generated from grammars/CssGrammars/CssLexer.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CssLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LBRACE=1, RBRACE=2, COLON=3, SEMICOLON=4, COMMA=5, PX=6, PERCENT=7, INT=8, 
		STRING=9, HASH=10, CLASS_SELECTOR=11, ID_SELECTOR=12, IDENTIFIER=13, COMMENT=14, 
		WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LBRACE", "RBRACE", "COLON", "SEMICOLON", "COMMA", "PX", "PERCENT", "INT", 
			"STRING", "HASH", "CLASS_SELECTOR", "ID_SELECTOR", "IDENTIFIER", "COMMENT", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "':'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBRACE", "RBRACE", "COLON", "SEMICOLON", "COMMA", "PX", "PERCENT", 
			"INT", "STRING", "HASH", "CLASS_SELECTOR", "ID_SELECTOR", "IDENTIFIER", 
			"COMMENT", "WS"
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


	public CssLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CssLexer.g4"; }

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
		"\u0004\u0000\u000f}\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005+\b"+
		"\u0005\u000b\u0005\f\u0005,\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0004\u00063\b\u0006\u000b\u0006\f\u00064\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0004\u0007:\b\u0007\u000b\u0007\f\u0007;\u0001\b\u0001\b"+
		"\u0005\b@\b\b\n\b\f\bC\t\b\u0001\b\u0001\b\u0001\b\u0005\bH\b\b\n\b\f"+
		"\bK\t\b\u0001\b\u0003\bN\b\b\u0001\t\u0001\t\u0004\tR\b\t\u000b\t\f\t"+
		"S\u0001\n\u0001\n\u0004\nX\b\n\u000b\n\f\nY\u0001\u000b\u0001\u000b\u0004"+
		"\u000b^\b\u000b\u000b\u000b\f\u000b_\u0001\f\u0001\f\u0005\fd\b\f\n\f"+
		"\f\fg\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\rm\b\r\n\r\f\rp\t\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0004\u000ex\b\u000e\u000b"+
		"\u000e\f\u000ey\u0001\u000e\u0001\u000e\u0001n\u0000\u000f\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u0001\u0000\b\u0001\u000009\u0001\u0000\"\"\u0001\u0000\'\'\u0003\u0000"+
		"09AFaf\u0005\u0000--09AZ__az\u0003\u0000--AZaz\u0004\u0000--09AZaz\u0003"+
		"\u0000\t\n\r\r  \u0088\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0001\u001f\u0001\u0000"+
		"\u0000\u0000\u0003!\u0001\u0000\u0000\u0000\u0005#\u0001\u0000\u0000\u0000"+
		"\u0007%\u0001\u0000\u0000\u0000\t\'\u0001\u0000\u0000\u0000\u000b*\u0001"+
		"\u0000\u0000\u0000\r2\u0001\u0000\u0000\u0000\u000f9\u0001\u0000\u0000"+
		"\u0000\u0011M\u0001\u0000\u0000\u0000\u0013O\u0001\u0000\u0000\u0000\u0015"+
		"U\u0001\u0000\u0000\u0000\u0017[\u0001\u0000\u0000\u0000\u0019a\u0001"+
		"\u0000\u0000\u0000\u001bh\u0001\u0000\u0000\u0000\u001dw\u0001\u0000\u0000"+
		"\u0000\u001f \u0005{\u0000\u0000 \u0002\u0001\u0000\u0000\u0000!\"\u0005"+
		"}\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000#$\u0005:\u0000\u0000$\u0006"+
		"\u0001\u0000\u0000\u0000%&\u0005;\u0000\u0000&\b\u0001\u0000\u0000\u0000"+
		"\'(\u0005,\u0000\u0000(\n\u0001\u0000\u0000\u0000)+\u0007\u0000\u0000"+
		"\u0000*)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000"+
		"\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0005"+
		"p\u0000\u0000/0\u0005x\u0000\u00000\f\u0001\u0000\u0000\u000013\u0007"+
		"\u0000\u0000\u000021\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000067\u0005%\u0000\u00007\u000e\u0001\u0000\u0000\u00008:\u0007\u0000"+
		"\u0000\u000098\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<\u0010\u0001\u0000\u0000"+
		"\u0000=A\u0005\"\u0000\u0000>@\b\u0001\u0000\u0000?>\u0001\u0000\u0000"+
		"\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000BD\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DN\u0005"+
		"\"\u0000\u0000EI\u0005\'\u0000\u0000FH\b\u0002\u0000\u0000GF\u0001\u0000"+
		"\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000"+
		"LN\u0005\'\u0000\u0000M=\u0001\u0000\u0000\u0000ME\u0001\u0000\u0000\u0000"+
		"N\u0012\u0001\u0000\u0000\u0000OQ\u0005#\u0000\u0000PR\u0007\u0003\u0000"+
		"\u0000QP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000T\u0014\u0001\u0000\u0000\u0000"+
		"UW\u0005.\u0000\u0000VX\u0007\u0004\u0000\u0000WV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000Z\u0016\u0001\u0000\u0000\u0000[]\u0005#\u0000\u0000\\^\u0007\u0004"+
		"\u0000\u0000]\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\u0018\u0001\u0000\u0000"+
		"\u0000ae\u0007\u0005\u0000\u0000bd\u0007\u0006\u0000\u0000cb\u0001\u0000"+
		"\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000f\u001a\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000hi\u0005/\u0000\u0000ij\u0005*\u0000\u0000jn\u0001\u0000\u0000\u0000"+
		"km\t\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000"+
		"no\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000"+
		"\u0000pn\u0001\u0000\u0000\u0000qr\u0005*\u0000\u0000rs\u0005/\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000tu\u0006\r\u0000\u0000u\u001c\u0001\u0000\u0000"+
		"\u0000vx\u0007\u0007\u0000\u0000wv\u0001\u0000\u0000\u0000xy\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{|\u0006\u000e\u0000\u0000|\u001e\u0001\u0000\u0000"+
		"\u0000\r\u0000,4;AIMSY_eny\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}