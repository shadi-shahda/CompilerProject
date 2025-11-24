// Generated from C:/Users/VICTUS/IdeaProjects/CompilerProject/grammars/Falsk/FlaskLexer.g4 by ANTLR 4.13.2
package grammars.Falsk;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class FlaskLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NICE=1, WS=2, COMMENT=3, IDENTIFIER=4, ASSIGN_OPERATRO=5, COMMA=6, INTEGER_LITERAL=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NICE", "WS", "COMMENT", "IDENTIFIER", "ASSIGN_OPERATRO", "COMMA", "INTEGER_LITERAL", 
			"NUM", "DIGIT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'nice'", null, null, null, "'='", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NICE", "WS", "COMMENT", "IDENTIFIER", "ASSIGN_OPERATRO", "COMMA", 
			"INTEGER_LITERAL"
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


	public FlaskLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FlaskLexer.g4"; }

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
		"\u0004\u0000\u0007A\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0005\u0002\u001f\b\u0002\n\u0002\f\u0002\"\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003(\b\u0003"+
		"\n\u0003\f\u0003+\t\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0003\u00062\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u00079\b\u0007\n\u0007\f\u0007<\t\u0007"+
		"\u0003\u0007>\b\u0007\u0001\b\u0001\b\u0000\u0000\t\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\u0000"+
		"\u0011\u0000\u0001\u0000\u0006\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r"+
		"\r\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000019\u0001\u000009C"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0001\u0013\u0001\u0000\u0000\u0000\u0003\u0018"+
		"\u0001\u0000\u0000\u0000\u0005\u001c\u0001\u0000\u0000\u0000\u0007%\u0001"+
		"\u0000\u0000\u0000\t,\u0001\u0000\u0000\u0000\u000b.\u0001\u0000\u0000"+
		"\u0000\r1\u0001\u0000\u0000\u0000\u000f=\u0001\u0000\u0000\u0000\u0011"+
		"?\u0001\u0000\u0000\u0000\u0013\u0014\u0005n\u0000\u0000\u0014\u0015\u0005"+
		"i\u0000\u0000\u0015\u0016\u0005c\u0000\u0000\u0016\u0017\u0005e\u0000"+
		"\u0000\u0017\u0002\u0001\u0000\u0000\u0000\u0018\u0019\u0007\u0000\u0000"+
		"\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001b\u0006\u0001\u0000"+
		"\u0000\u001b\u0004\u0001\u0000\u0000\u0000\u001c \u0005#\u0000\u0000\u001d"+
		"\u001f\b\u0001\u0000\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f\""+
		"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000"+
		"\u0000\u0000!#\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000#$\u0006"+
		"\u0002\u0000\u0000$\u0006\u0001\u0000\u0000\u0000%)\u0007\u0002\u0000"+
		"\u0000&(\u0007\u0003\u0000\u0000\'&\u0001\u0000\u0000\u0000(+\u0001\u0000"+
		"\u0000\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*\b\u0001"+
		"\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000,-\u0005=\u0000\u0000-\n\u0001"+
		"\u0000\u0000\u0000./\u0005,\u0000\u0000/\f\u0001\u0000\u0000\u000002\u0005"+
		"-\u0000\u000010\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000023\u0001"+
		"\u0000\u0000\u000034\u0003\u000f\u0007\u00004\u000e\u0001\u0000\u0000"+
		"\u00005>\u00050\u0000\u00006:\u0007\u0004\u0000\u000079\u0003\u0011\b"+
		"\u000087\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001"+
		"\u0000\u0000\u0000=5\u0001\u0000\u0000\u0000=6\u0001\u0000\u0000\u0000"+
		">\u0010\u0001\u0000\u0000\u0000?@\u0007\u0005\u0000\u0000@\u0012\u0001"+
		"\u0000\u0000\u0000\u0006\u0000 )1:=\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}