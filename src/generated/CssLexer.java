// Generated from C:/Users/VICTUS/Desktop/lectures/projects/CompilerProject/grammars/CssGrammars/CssLexer.g4 by ANTLR 4.13.2
package generated;
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
		LBRACE=1, RBRACE=2, LPAREN=3, RPAREN=4, COLON=5, SEMICOLON=6, COMMA=7, 
		PX=8, PERCENT=9, FLOAT=10, INT=11, STRING=12, HASH=13, CLASS_SELECTOR=14, 
		ID_SELECTOR=15, IDENTIFIER=16, COMMENT=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LBRACE", "RBRACE", "LPAREN", "RPAREN", "COLON", "SEMICOLON", "COMMA", 
			"PX", "PERCENT", "FLOAT", "INT", "STRING", "HASH", "CLASS_SELECTOR", 
			"ID_SELECTOR", "IDENTIFIER", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "':'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBRACE", "RBRACE", "LPAREN", "RPAREN", "COLON", "SEMICOLON", "COMMA", 
			"PX", "PERCENT", "FLOAT", "INT", "STRING", "HASH", "CLASS_SELECTOR", 
			"ID_SELECTOR", "IDENTIFIER", "COMMENT", "WS"
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
		"\u0004\u0000\u0012\u0093\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u00075\b\u0007\u000b\u0007"+
		"\f\u00076\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0004\b=\b\b\u000b"+
		"\b\f\b>\u0001\b\u0001\b\u0001\t\u0005\tD\b\t\n\t\f\tG\t\t\u0001\t\u0001"+
		"\t\u0004\tK\b\t\u000b\t\f\tL\u0001\n\u0004\nP\b\n\u000b\n\f\nQ\u0001\u000b"+
		"\u0001\u000b\u0005\u000bV\b\u000b\n\u000b\f\u000bY\t\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b^\b\u000b\n\u000b\f\u000ba\t\u000b"+
		"\u0001\u000b\u0003\u000bd\b\u000b\u0001\f\u0001\f\u0004\fh\b\f\u000b\f"+
		"\f\fi\u0001\r\u0001\r\u0004\rn\b\r\u000b\r\f\ro\u0001\u000e\u0001\u000e"+
		"\u0004\u000et\b\u000e\u000b\u000e\f\u000eu\u0001\u000f\u0001\u000f\u0005"+
		"\u000fz\b\u000f\n\u000f\f\u000f}\t\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u0083\b\u0010\n\u0010\f\u0010\u0086\t\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0004\u0011\u008e\b\u0011\u000b\u0011\f\u0011\u008f\u0001\u0011\u0001"+
		"\u0011\u0001\u0084\u0000\u0012\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012\u0001"+
		"\u0000\u0007\u0001\u000009\u0001\u0000\"\"\u0001\u0000\'\'\u0005\u0000"+
		"--09AZ__az\u0003\u0000--AZaz\u0004\u0000--09AZaz\u0003\u0000\t\n\r\r "+
		" \u00a0\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001%\u0001"+
		"\u0000\u0000\u0000\u0003\'\u0001\u0000\u0000\u0000\u0005)\u0001\u0000"+
		"\u0000\u0000\u0007+\u0001\u0000\u0000\u0000\t-\u0001\u0000\u0000\u0000"+
		"\u000b/\u0001\u0000\u0000\u0000\r1\u0001\u0000\u0000\u0000\u000f4\u0001"+
		"\u0000\u0000\u0000\u0011<\u0001\u0000\u0000\u0000\u0013E\u0001\u0000\u0000"+
		"\u0000\u0015O\u0001\u0000\u0000\u0000\u0017c\u0001\u0000\u0000\u0000\u0019"+
		"e\u0001\u0000\u0000\u0000\u001bk\u0001\u0000\u0000\u0000\u001dq\u0001"+
		"\u0000\u0000\u0000\u001fw\u0001\u0000\u0000\u0000!~\u0001\u0000\u0000"+
		"\u0000#\u008d\u0001\u0000\u0000\u0000%&\u0005{\u0000\u0000&\u0002\u0001"+
		"\u0000\u0000\u0000\'(\u0005}\u0000\u0000(\u0004\u0001\u0000\u0000\u0000"+
		")*\u0005(\u0000\u0000*\u0006\u0001\u0000\u0000\u0000+,\u0005)\u0000\u0000"+
		",\b\u0001\u0000\u0000\u0000-.\u0005:\u0000\u0000.\n\u0001\u0000\u0000"+
		"\u0000/0\u0005;\u0000\u00000\f\u0001\u0000\u0000\u000012\u0005,\u0000"+
		"\u00002\u000e\u0001\u0000\u0000\u000035\u0007\u0000\u0000\u000043\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u0000"+
		"67\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000089\u0005p\u0000\u0000"+
		"9:\u0005x\u0000\u0000:\u0010\u0001\u0000\u0000\u0000;=\u0007\u0000\u0000"+
		"\u0000<;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0005"+
		"%\u0000\u0000A\u0012\u0001\u0000\u0000\u0000BD\u0007\u0000\u0000\u0000"+
		"CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000HJ\u0005.\u0000\u0000IK\u0007\u0000\u0000\u0000JI\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000M\u0014\u0001\u0000\u0000\u0000NP\u0007\u0000\u0000"+
		"\u0000ON\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000R\u0016\u0001\u0000\u0000\u0000"+
		"SW\u0005\"\u0000\u0000TV\b\u0001\u0000\u0000UT\u0001\u0000\u0000\u0000"+
		"VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Zd\u0005\"\u0000"+
		"\u0000[_\u0005\'\u0000\u0000\\^\b\u0002\u0000\u0000]\\\u0001\u0000\u0000"+
		"\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bd\u0005"+
		"\'\u0000\u0000cS\u0001\u0000\u0000\u0000c[\u0001\u0000\u0000\u0000d\u0018"+
		"\u0001\u0000\u0000\u0000eg\u0005#\u0000\u0000fh\u0007\u0003\u0000\u0000"+
		"gf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000j\u001a\u0001\u0000\u0000\u0000km\u0005"+
		".\u0000\u0000ln\u0007\u0003\u0000\u0000ml\u0001\u0000\u0000\u0000no\u0001"+
		"\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"p\u001c\u0001\u0000\u0000\u0000qs\u0005#\u0000\u0000rt\u0007\u0003\u0000"+
		"\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000uv\u0001\u0000\u0000\u0000v\u001e\u0001\u0000\u0000\u0000"+
		"w{\u0007\u0004\u0000\u0000xz\u0007\u0005\u0000\u0000yx\u0001\u0000\u0000"+
		"\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000| \u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f"+
		"\u0005/\u0000\u0000\u007f\u0080\u0005*\u0000\u0000\u0080\u0084\u0001\u0000"+
		"\u0000\u0000\u0081\u0083\t\u0000\u0000\u0000\u0082\u0081\u0001\u0000\u0000"+
		"\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000"+
		"\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000"+
		"\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0088\u0005*\u0000\u0000"+
		"\u0088\u0089\u0005/\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0006\u0010\u0000\u0000\u008b\"\u0001\u0000\u0000\u0000\u008c\u008e"+
		"\u0007\u0006\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0006\u0011\u0000\u0000\u0092$\u0001\u0000\u0000\u0000\u000f\u00006>"+
		"ELQW_ciou{\u0084\u008f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}