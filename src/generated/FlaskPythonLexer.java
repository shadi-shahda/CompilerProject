// Generated from C:/Users/VICTUS/Desktop/lectures/projects/CompilerProject/grammars/FlaskPythonGrammars/FlaskPythonLexer.g4 by ANTLR 4.13.2
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
public class FlaskPythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, DEF=3, RETURN=4, IF=5, ELSE=6, FOR=7, IN=8, FROM=9, 
		IMPORT=10, FLASK_CLASS=11, ROUTE=12, RENDER_TEMPLATE=13, REDIRECT=14, 
		URL_FOR=15, METHODS=16, PRINT=17, GLOBAL=18, BREAK=19, CONTINUE=20, LPAREN=21, 
		RPAREN=22, LBRACE=23, RBRACE=24, LBRACKET=25, RBRACKET=26, COLON=27, COMMA=28, 
		DOT=29, AT=30, ASSIGN=31, EQUALS=32, NOT_EQUALS=33, PLUS=34, MINUS=35, 
		MUL=36, DIV=37, NEWLINE=38, BOOLEAN=39, ID=40, INT=41, STRING=42, COMMENT=43, 
		WS=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DEF", "RETURN", "IF", "ELSE", "FOR", "IN", "FROM", "IMPORT", "FLASK_CLASS", 
			"ROUTE", "RENDER_TEMPLATE", "REDIRECT", "URL_FOR", "METHODS", "PRINT", 
			"GLOBAL", "BREAK", "CONTINUE", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LBRACKET", "RBRACKET", "COLON", "COMMA", "DOT", "AT", "ASSIGN", "EQUALS", 
			"NOT_EQUALS", "PLUS", "MINUS", "MUL", "DIV", "NEWLINE", "SPACES", "BOOLEAN", 
			"ID", "INT", "STRING", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'def'", "'return'", "'if'", "'else'", "'for'", "'in'", 
			"'from'", "'import'", "'Flask'", "'route'", "'render_template'", "'redirect'", 
			"'url_for'", "'methods'", "'print'", "'global'", "'break'", "'continue'", 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "':'", "','", "'.'", "'@'", 
			"'='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "DEF", "RETURN", "IF", "ELSE", "FOR", "IN", 
			"FROM", "IMPORT", "FLASK_CLASS", "ROUTE", "RENDER_TEMPLATE", "REDIRECT", 
			"URL_FOR", "METHODS", "PRINT", "GLOBAL", "BREAK", "CONTINUE", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "LBRACKET", "RBRACKET", "COLON", "COMMA", 
			"DOT", "AT", "ASSIGN", "EQUALS", "NOT_EQUALS", "PLUS", "MINUS", "MUL", 
			"DIV", "NEWLINE", "BOOLEAN", "ID", "INT", "STRING", "COMMENT", "WS"
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


	    private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
	    private java.util.Stack<Integer> indents = new java.util.Stack<>();
	    private int opened = 0;

	    @Override
	    public void emit(Token token) {
	        super.setToken(token);
	        tokens.offer(token);
	    }

	    @Override
	    public Token nextToken() {
	        if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
	            emit(commonToken(NEWLINE, "\n"));

	            while (!indents.isEmpty()) {
	                emit(createDedent());
	                indents.pop();
	            }

	            emit(commonToken(EOF, "<EOF>"));
	        }

	        if (!tokens.isEmpty()) {
	            return tokens.poll();
	        }

	        Token next = super.nextToken();

	        if (!tokens.isEmpty()) {
	            return tokens.poll();
	        }

	        return next;
	    }

	    private Token createDedent() {
	        CommonToken dedent = commonToken(DEDENT, "");
	        dedent.setLine(this.getLine());
	        return dedent;
	    }

	    private CommonToken commonToken(int type, String text) {
	        int stop = this.getCharIndex() - 1;
	        int start = text.isEmpty() ? stop : stop - text.length() + 1;
	        return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
	    }

	    static int getIndentationCount(String spaces) {
	        int count = 0;

	        for (char ch : spaces.toCharArray()) {
	            if (ch == '\t') {
	                count += 8 - (count % 8);
	            } else {
	                count++;
	            }
	        }

	        return count;
	    }

	    boolean atStartOfInput() {
	        return super.getCharPositionInLine() == 0 && super.getLine() == 1;
	    }


	public FlaskPythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FlaskPythonLexer.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 18:
			LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 19:
			RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 20:
			LBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 21:
			RBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 22:
			LBRACKET_action((RuleContext)_localctx, actionIndex);
			break;
		case 23:
			RBRACKET_action((RuleContext)_localctx, actionIndex);
			break;
		case 35:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			opened++;
			break;
		}
	}
	private void RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			opened--;
			break;
		}
	}
	private void LBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			opened++;
			break;
		}
	}
	private void RBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			opened--;
			break;
		}
	}
	private void LBRACKET_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			opened++;
			break;
		}
	}
	private void RBRACKET_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			opened--;
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:

			          String newLine = getText().replaceAll("[^\\r\\n\\f]+", "");
			          String spaces = getText().replaceAll("[\\r\\n\\f]+", "");

			          int next = _input.LA(1);

			          if (opened > 0 || next == '\r' || next == '\n' || next == '\f' || next == '#') {
			              skip();
			          } else {
			              emit(commonToken(NEWLINE, newLine));

			              int indent = getIndentationCount(spaces);
			              int previous = indents.isEmpty() ? 0 : indents.peek();

			              if (indent == previous) {
			                  skip();
			              } else if (indent > previous) {
			                  indents.push(indent);
			                  emit(commonToken(INDENT, spaces));
			              } else {
			                  while (!indents.isEmpty() && indents.peek() > indent) {
			                      emit(createDedent());
			                      indents.pop();
			                  }
			              }
			          }
			      
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 35:
			return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0000,\u0146\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#"+
		"\u0001#\u0001#\u0003#\u00fc\b#\u0001#\u0001#\u0003#\u0100\b#\u0001#\u0003"+
		"#\u0103\b#\u0003#\u0105\b#\u0001#\u0001#\u0001$\u0004$\u010a\b$\u000b"+
		"$\f$\u010b\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0003%\u0117\b%\u0001&\u0001&\u0005&\u011b\b&\n&\f&\u011e\t&\u0001\'"+
		"\u0004\'\u0121\b\'\u000b\'\f\'\u0122\u0001(\u0001(\u0005(\u0127\b(\n("+
		"\f(\u012a\t(\u0001(\u0001(\u0001(\u0005(\u012f\b(\n(\f(\u0132\t(\u0001"+
		"(\u0003(\u0135\b(\u0001)\u0001)\u0005)\u0139\b)\n)\f)\u013c\t)\u0001)"+
		"\u0001)\u0001*\u0004*\u0141\b*\u000b*\f*\u0142\u0001*\u0001*\u0002\u0128"+
		"\u0130\u0000+\u0001\u0003\u0003\u0004\u0005\u0005\u0007\u0006\t\u0007"+
		"\u000b\b\r\t\u000f\n\u0011\u000b\u0013\f\u0015\r\u0017\u000e\u0019\u000f"+
		"\u001b\u0010\u001d\u0011\u001f\u0012!\u0013#\u0014%\u0015\'\u0016)\u0017"+
		"+\u0018-\u0019/\u001a1\u001b3\u001c5\u001d7\u001e9\u001f; =!?\"A#C$E%"+
		"G&I\u0000K\'M(O)Q*S+U,\u0001\u0000\u0005\u0002\u0000\t\t  \u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0001\u000009\u0002\u0000\n\n\r\r\u0151\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000"+
		"\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000"+
		"\u0000G\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M"+
		"\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000"+
		"\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000"+
		"\u0001W\u0001\u0000\u0000\u0000\u0003[\u0001\u0000\u0000\u0000\u0005b"+
		"\u0001\u0000\u0000\u0000\u0007e\u0001\u0000\u0000\u0000\tj\u0001\u0000"+
		"\u0000\u0000\u000bn\u0001\u0000\u0000\u0000\rq\u0001\u0000\u0000\u0000"+
		"\u000fv\u0001\u0000\u0000\u0000\u0011}\u0001\u0000\u0000\u0000\u0013\u0083"+
		"\u0001\u0000\u0000\u0000\u0015\u0089\u0001\u0000\u0000\u0000\u0017\u0099"+
		"\u0001\u0000\u0000\u0000\u0019\u00a2\u0001\u0000\u0000\u0000\u001b\u00aa"+
		"\u0001\u0000\u0000\u0000\u001d\u00b2\u0001\u0000\u0000\u0000\u001f\u00b8"+
		"\u0001\u0000\u0000\u0000!\u00bf\u0001\u0000\u0000\u0000#\u00c5\u0001\u0000"+
		"\u0000\u0000%\u00ce\u0001\u0000\u0000\u0000\'\u00d1\u0001\u0000\u0000"+
		"\u0000)\u00d4\u0001\u0000\u0000\u0000+\u00d7\u0001\u0000\u0000\u0000-"+
		"\u00da\u0001\u0000\u0000\u0000/\u00dd\u0001\u0000\u0000\u00001\u00e0\u0001"+
		"\u0000\u0000\u00003\u00e2\u0001\u0000\u0000\u00005\u00e4\u0001\u0000\u0000"+
		"\u00007\u00e6\u0001\u0000\u0000\u00009\u00e8\u0001\u0000\u0000\u0000;"+
		"\u00ea\u0001\u0000\u0000\u0000=\u00ed\u0001\u0000\u0000\u0000?\u00f0\u0001"+
		"\u0000\u0000\u0000A\u00f2\u0001\u0000\u0000\u0000C\u00f4\u0001\u0000\u0000"+
		"\u0000E\u00f6\u0001\u0000\u0000\u0000G\u0104\u0001\u0000\u0000\u0000I"+
		"\u0109\u0001\u0000\u0000\u0000K\u0116\u0001\u0000\u0000\u0000M\u0118\u0001"+
		"\u0000\u0000\u0000O\u0120\u0001\u0000\u0000\u0000Q\u0134\u0001\u0000\u0000"+
		"\u0000S\u0136\u0001\u0000\u0000\u0000U\u0140\u0001\u0000\u0000\u0000W"+
		"X\u0005d\u0000\u0000XY\u0005e\u0000\u0000YZ\u0005f\u0000\u0000Z\u0002"+
		"\u0001\u0000\u0000\u0000[\\\u0005r\u0000\u0000\\]\u0005e\u0000\u0000]"+
		"^\u0005t\u0000\u0000^_\u0005u\u0000\u0000_`\u0005r\u0000\u0000`a\u0005"+
		"n\u0000\u0000a\u0004\u0001\u0000\u0000\u0000bc\u0005i\u0000\u0000cd\u0005"+
		"f\u0000\u0000d\u0006\u0001\u0000\u0000\u0000ef\u0005e\u0000\u0000fg\u0005"+
		"l\u0000\u0000gh\u0005s\u0000\u0000hi\u0005e\u0000\u0000i\b\u0001\u0000"+
		"\u0000\u0000jk\u0005f\u0000\u0000kl\u0005o\u0000\u0000lm\u0005r\u0000"+
		"\u0000m\n\u0001\u0000\u0000\u0000no\u0005i\u0000\u0000op\u0005n\u0000"+
		"\u0000p\f\u0001\u0000\u0000\u0000qr\u0005f\u0000\u0000rs\u0005r\u0000"+
		"\u0000st\u0005o\u0000\u0000tu\u0005m\u0000\u0000u\u000e\u0001\u0000\u0000"+
		"\u0000vw\u0005i\u0000\u0000wx\u0005m\u0000\u0000xy\u0005p\u0000\u0000"+
		"yz\u0005o\u0000\u0000z{\u0005r\u0000\u0000{|\u0005t\u0000\u0000|\u0010"+
		"\u0001\u0000\u0000\u0000}~\u0005F\u0000\u0000~\u007f\u0005l\u0000\u0000"+
		"\u007f\u0080\u0005a\u0000\u0000\u0080\u0081\u0005s\u0000\u0000\u0081\u0082"+
		"\u0005k\u0000\u0000\u0082\u0012\u0001\u0000\u0000\u0000\u0083\u0084\u0005"+
		"r\u0000\u0000\u0084\u0085\u0005o\u0000\u0000\u0085\u0086\u0005u\u0000"+
		"\u0000\u0086\u0087\u0005t\u0000\u0000\u0087\u0088\u0005e\u0000\u0000\u0088"+
		"\u0014\u0001\u0000\u0000\u0000\u0089\u008a\u0005r\u0000\u0000\u008a\u008b"+
		"\u0005e\u0000\u0000\u008b\u008c\u0005n\u0000\u0000\u008c\u008d\u0005d"+
		"\u0000\u0000\u008d\u008e\u0005e\u0000\u0000\u008e\u008f\u0005r\u0000\u0000"+
		"\u008f\u0090\u0005_\u0000\u0000\u0090\u0091\u0005t\u0000\u0000\u0091\u0092"+
		"\u0005e\u0000\u0000\u0092\u0093\u0005m\u0000\u0000\u0093\u0094\u0005p"+
		"\u0000\u0000\u0094\u0095\u0005l\u0000\u0000\u0095\u0096\u0005a\u0000\u0000"+
		"\u0096\u0097\u0005t\u0000\u0000\u0097\u0098\u0005e\u0000\u0000\u0098\u0016"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0005r\u0000\u0000\u009a\u009b\u0005"+
		"e\u0000\u0000\u009b\u009c\u0005d\u0000\u0000\u009c\u009d\u0005i\u0000"+
		"\u0000\u009d\u009e\u0005r\u0000\u0000\u009e\u009f\u0005e\u0000\u0000\u009f"+
		"\u00a0\u0005c\u0000\u0000\u00a0\u00a1\u0005t\u0000\u0000\u00a1\u0018\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0005u\u0000\u0000\u00a3\u00a4\u0005r\u0000"+
		"\u0000\u00a4\u00a5\u0005l\u0000\u0000\u00a5\u00a6\u0005_\u0000\u0000\u00a6"+
		"\u00a7\u0005f\u0000\u0000\u00a7\u00a8\u0005o\u0000\u0000\u00a8\u00a9\u0005"+
		"r\u0000\u0000\u00a9\u001a\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005m\u0000"+
		"\u0000\u00ab\u00ac\u0005e\u0000\u0000\u00ac\u00ad\u0005t\u0000\u0000\u00ad"+
		"\u00ae\u0005h\u0000\u0000\u00ae\u00af\u0005o\u0000\u0000\u00af\u00b0\u0005"+
		"d\u0000\u0000\u00b0\u00b1\u0005s\u0000\u0000\u00b1\u001c\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0005p\u0000\u0000\u00b3\u00b4\u0005r\u0000\u0000\u00b4"+
		"\u00b5\u0005i\u0000\u0000\u00b5\u00b6\u0005n\u0000\u0000\u00b6\u00b7\u0005"+
		"t\u0000\u0000\u00b7\u001e\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005g\u0000"+
		"\u0000\u00b9\u00ba\u0005l\u0000\u0000\u00ba\u00bb\u0005o\u0000\u0000\u00bb"+
		"\u00bc\u0005b\u0000\u0000\u00bc\u00bd\u0005a\u0000\u0000\u00bd\u00be\u0005"+
		"l\u0000\u0000\u00be \u0001\u0000\u0000\u0000\u00bf\u00c0\u0005b\u0000"+
		"\u0000\u00c0\u00c1\u0005r\u0000\u0000\u00c1\u00c2\u0005e\u0000\u0000\u00c2"+
		"\u00c3\u0005a\u0000\u0000\u00c3\u00c4\u0005k\u0000\u0000\u00c4\"\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0005c\u0000\u0000\u00c6\u00c7\u0005o\u0000"+
		"\u0000\u00c7\u00c8\u0005n\u0000\u0000\u00c8\u00c9\u0005t\u0000\u0000\u00c9"+
		"\u00ca\u0005i\u0000\u0000\u00ca\u00cb\u0005n\u0000\u0000\u00cb\u00cc\u0005"+
		"u\u0000\u0000\u00cc\u00cd\u0005e\u0000\u0000\u00cd$\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0005(\u0000\u0000\u00cf\u00d0\u0006\u0012\u0000\u0000"+
		"\u00d0&\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005)\u0000\u0000\u00d2\u00d3"+
		"\u0006\u0013\u0001\u0000\u00d3(\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005"+
		"{\u0000\u0000\u00d5\u00d6\u0006\u0014\u0002\u0000\u00d6*\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d8\u0005}\u0000\u0000\u00d8\u00d9\u0006\u0015\u0003\u0000"+
		"\u00d9,\u0001\u0000\u0000\u0000\u00da\u00db\u0005[\u0000\u0000\u00db\u00dc"+
		"\u0006\u0016\u0004\u0000\u00dc.\u0001\u0000\u0000\u0000\u00dd\u00de\u0005"+
		"]\u0000\u0000\u00de\u00df\u0006\u0017\u0005\u0000\u00df0\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e1\u0005:\u0000\u0000\u00e12\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0005,\u0000\u0000\u00e34\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005"+
		".\u0000\u0000\u00e56\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005@\u0000"+
		"\u0000\u00e78\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005=\u0000\u0000\u00e9"+
		":\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005=\u0000\u0000\u00eb\u00ec\u0005"+
		"=\u0000\u0000\u00ec<\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005!\u0000"+
		"\u0000\u00ee\u00ef\u0005=\u0000\u0000\u00ef>\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\u0005+\u0000\u0000\u00f1@\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005"+
		"-\u0000\u0000\u00f3B\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005*\u0000"+
		"\u0000\u00f5D\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005/\u0000\u0000\u00f7"+
		"F\u0001\u0000\u0000\u0000\u00f8\u00f9\u0004#\u0000\u0000\u00f9\u0105\u0003"+
		"I$\u0000\u00fa\u00fc\u0005\r\u0000\u0000\u00fb\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000"+
		"\u0000\u00fd\u0100\u0005\n\u0000\u0000\u00fe\u0100\u0002\f\r\u0000\u00ff"+
		"\u00fb\u0001\u0000\u0000\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100"+
		"\u0102\u0001\u0000\u0000\u0000\u0101\u0103\u0003I$\u0000\u0102\u0101\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0105\u0001"+
		"\u0000\u0000\u0000\u0104\u00f8\u0001\u0000\u0000\u0000\u0104\u00ff\u0001"+
		"\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0107\u0006"+
		"#\u0006\u0000\u0107H\u0001\u0000\u0000\u0000\u0108\u010a\u0007\u0000\u0000"+
		"\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000"+
		"\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000"+
		"\u0000\u010cJ\u0001\u0000\u0000\u0000\u010d\u010e\u0005T\u0000\u0000\u010e"+
		"\u010f\u0005r\u0000\u0000\u010f\u0110\u0005u\u0000\u0000\u0110\u0117\u0005"+
		"e\u0000\u0000\u0111\u0112\u0005F\u0000\u0000\u0112\u0113\u0005a\u0000"+
		"\u0000\u0113\u0114\u0005l\u0000\u0000\u0114\u0115\u0005s\u0000\u0000\u0115"+
		"\u0117\u0005e\u0000\u0000\u0116\u010d\u0001\u0000\u0000\u0000\u0116\u0111"+
		"\u0001\u0000\u0000\u0000\u0117L\u0001\u0000\u0000\u0000\u0118\u011c\u0007"+
		"\u0001\u0000\u0000\u0119\u011b\u0007\u0002\u0000\u0000\u011a\u0119\u0001"+
		"\u0000\u0000\u0000\u011b\u011e\u0001\u0000\u0000\u0000\u011c\u011a\u0001"+
		"\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011dN\u0001\u0000"+
		"\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011f\u0121\u0007\u0003"+
		"\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000"+
		"\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000"+
		"\u0000\u0000\u0123P\u0001\u0000\u0000\u0000\u0124\u0128\u0005\"\u0000"+
		"\u0000\u0125\u0127\t\u0000\u0000\u0000\u0126\u0125\u0001\u0000\u0000\u0000"+
		"\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000"+
		"\u0128\u0126\u0001\u0000\u0000\u0000\u0129\u012b\u0001\u0000\u0000\u0000"+
		"\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u0135\u0005\"\u0000\u0000\u012c"+
		"\u0130\u0005\'\u0000\u0000\u012d\u012f\t\u0000\u0000\u0000\u012e\u012d"+
		"\u0001\u0000\u0000\u0000\u012f\u0132\u0001\u0000\u0000\u0000\u0130\u0131"+
		"\u0001\u0000\u0000\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0131\u0133"+
		"\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0133\u0135"+
		"\u0005\'\u0000\u0000\u0134\u0124\u0001\u0000\u0000\u0000\u0134\u012c\u0001"+
		"\u0000\u0000\u0000\u0135R\u0001\u0000\u0000\u0000\u0136\u013a\u0005#\u0000"+
		"\u0000\u0137\u0139\b\u0004\u0000\u0000\u0138\u0137\u0001\u0000\u0000\u0000"+
		"\u0139\u013c\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000"+
		"\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013d\u0001\u0000\u0000\u0000"+
		"\u013c\u013a\u0001\u0000\u0000\u0000\u013d\u013e\u0006)\u0007\u0000\u013e"+
		"T\u0001\u0000\u0000\u0000\u013f\u0141\u0007\u0000\u0000\u0000\u0140\u013f"+
		"\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0140"+
		"\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0144"+
		"\u0001\u0000\u0000\u0000\u0144\u0145\u0006*\u0007\u0000\u0145V\u0001\u0000"+
		"\u0000\u0000\u000e\u0000\u00fb\u00ff\u0102\u0104\u010b\u0116\u011c\u0122"+
		"\u0128\u0130\u0134\u013a\u0142\b\u0001\u0012\u0000\u0001\u0013\u0001\u0001"+
		"\u0014\u0002\u0001\u0015\u0003\u0001\u0016\u0004\u0001\u0017\u0005\u0001"+
		"#\u0006\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}