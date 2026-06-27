// Generated from c:/Users/VICTUS/Desktop/lectures/projects/CompilerProject/grammars/FlaskPythonGrammars/FlaskPythonParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FlaskPythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_importStmt = 2, RULE_importList = 3, 
		RULE_importItem = 4, RULE_functionDecl = 5, RULE_routeDecorator = 6, RULE_methodsParam = 7, 
		RULE_paramList = 8, RULE_block = 9, RULE_statement = 10, RULE_simpleStmt = 11, 
		RULE_printStmt = 12, RULE_breakStmt = 13, RULE_continueStmt = 14, RULE_ifStmt = 15, 
		RULE_condition = 16, RULE_forStmt = 17, RULE_returnStmt = 18, RULE_assignment = 19, 
		RULE_globalStmt = 20, RULE_expressionStmt = 21, RULE_expression = 22, 
		RULE_flaskFunc = 23, RULE_argList = 24, RULE_argument = 25, RULE_list = 26, 
		RULE_elements = 27, RULE_listComp = 28, RULE_dictionary = 29, RULE_dictEntry = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "importStmt", "importList", "importItem", "functionDecl", 
			"routeDecorator", "methodsParam", "paramList", "block", "statement", 
			"simpleStmt", "printStmt", "breakStmt", "continueStmt", "ifStmt", "condition", 
			"forStmt", "returnStmt", "assignment", "globalStmt", "expressionStmt", 
			"expression", "flaskFunc", "argList", "argument", "list", "elements", 
			"listComp", "dictionary", "dictEntry"
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

	@Override
	public String getGrammarFileName() { return "FlaskPythonParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FlaskPythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FlaskPythonParser.EOF, 0); }
		public TerminalNode NEWLINE() { return getToken(FlaskPythonParser.NEWLINE, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				setState(62);
				match(NEWLINE);
				}
				break;
			case EOF:
			case DEF:
			case RETURN:
			case IF:
			case FOR:
			case FROM:
			case FLASK_CLASS:
			case RENDER_TEMPLATE:
			case REDIRECT:
			case URL_FOR:
			case PRINT:
			case GLOBAL:
			case BREAK:
			case CONTINUE:
			case LBRACE:
			case LBRACKET:
			case AT:
			case BOOLEAN:
			case ID:
			case INT:
			case STRING:
				{
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8247454919352L) != 0)) {
					{
					{
					setState(63);
					line();
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(71);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	 
		public LineContext() { }
		public void copyFrom(LineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationStatemetnContext extends LineContext {
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public FunctionDeclarationStatemetnContext(LineContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportStatementContext extends LineContext {
		public ImportStmtContext importStmt() {
			return getRuleContext(ImportStmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(FlaskPythonParser.NEWLINE, 0); }
		public ImportStatementContext(LineContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStatementContext extends LineContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentStatementContext(LineContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RegularStatementContext extends LineContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public RegularStatementContext(LineContext ctx) { copyFrom(ctx); }
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ImportStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				importStmt();
				setState(74);
				match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				assignment();
				}
				break;
			case 3:
				_localctx = new FunctionDeclarationStatemetnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				functionDecl();
				}
				break;
			case 4:
				_localctx = new RegularStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStmtContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(FlaskPythonParser.FROM, 0); }
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public TerminalNode IMPORT() { return getToken(FlaskPythonParser.IMPORT, 0); }
		public ImportListContext importList() {
			return getRuleContext(ImportListContext.class,0);
		}
		public ImportStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStmt; }
	}

	public final ImportStmtContext importStmt() throws RecognitionException {
		ImportStmtContext _localctx = new ImportStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(FROM);
			setState(82);
			match(ID);
			setState(83);
			match(IMPORT);
			setState(84);
			importList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportListContext extends ParserRuleContext {
		public List<ImportItemContext> importItem() {
			return getRuleContexts(ImportItemContext.class);
		}
		public ImportItemContext importItem(int i) {
			return getRuleContext(ImportItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FlaskPythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskPythonParser.COMMA, i);
		}
		public ImportListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importList; }
	}

	public final ImportListContext importList() throws RecognitionException {
		ImportListContext _localctx = new ImportListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			importItem();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(87);
				match(COMMA);
				setState(88);
				importItem();
				}
				}
				setState(93);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportItemContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public TerminalNode FLASK_CLASS() { return getToken(FlaskPythonParser.FLASK_CLASS, 0); }
		public TerminalNode RENDER_TEMPLATE() { return getToken(FlaskPythonParser.RENDER_TEMPLATE, 0); }
		public TerminalNode REDIRECT() { return getToken(FlaskPythonParser.REDIRECT, 0); }
		public TerminalNode URL_FOR() { return getToken(FlaskPythonParser.URL_FOR, 0); }
		public ImportItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importItem; }
	}

	public final ImportItemContext importItem() throws RecognitionException {
		ImportItemContext _localctx = new ImportItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1099511687168L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(FlaskPythonParser.DEF, 0); }
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(FlaskPythonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FlaskPythonParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(FlaskPythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RouteDecoratorContext routeDecorator() {
			return getRuleContext(RouteDecoratorContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(FlaskPythonParser.NEWLINE, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT) {
				{
				setState(96);
				routeDecorator();
				setState(97);
				match(NEWLINE);
				}
			}

			setState(101);
			match(DEF);
			setState(102);
			match(ID);
			setState(103);
			match(LPAREN);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(104);
				paramList();
				}
			}

			setState(107);
			match(RPAREN);
			setState(108);
			match(COLON);
			setState(109);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RouteDecoratorContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(FlaskPythonParser.AT, 0); }
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public TerminalNode DOT() { return getToken(FlaskPythonParser.DOT, 0); }
		public TerminalNode ROUTE() { return getToken(FlaskPythonParser.ROUTE, 0); }
		public TerminalNode LPAREN() { return getToken(FlaskPythonParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(FlaskPythonParser.STRING, 0); }
		public TerminalNode RPAREN() { return getToken(FlaskPythonParser.RPAREN, 0); }
		public TerminalNode COMMA() { return getToken(FlaskPythonParser.COMMA, 0); }
		public MethodsParamContext methodsParam() {
			return getRuleContext(MethodsParamContext.class,0);
		}
		public RouteDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routeDecorator; }
	}

	public final RouteDecoratorContext routeDecorator() throws RecognitionException {
		RouteDecoratorContext _localctx = new RouteDecoratorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_routeDecorator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(AT);
			setState(112);
			match(ID);
			setState(113);
			match(DOT);
			setState(114);
			match(ROUTE);
			setState(115);
			match(LPAREN);
			setState(116);
			match(STRING);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(117);
				match(COMMA);
				setState(118);
				methodsParam();
				}
			}

			setState(121);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodsParamContext extends ParserRuleContext {
		public TerminalNode METHODS() { return getToken(FlaskPythonParser.METHODS, 0); }
		public TerminalNode ASSIGN() { return getToken(FlaskPythonParser.ASSIGN, 0); }
		public TerminalNode LBRACKET() { return getToken(FlaskPythonParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(FlaskPythonParser.RBRACKET, 0); }
		public List<TerminalNode> STRING() { return getTokens(FlaskPythonParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FlaskPythonParser.STRING, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FlaskPythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskPythonParser.COMMA, i);
		}
		public MethodsParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodsParam; }
	}

	public final MethodsParamContext methodsParam() throws RecognitionException {
		MethodsParamContext _localctx = new MethodsParamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_methodsParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(METHODS);
			setState(124);
			match(ASSIGN);
			setState(125);
			match(LBRACKET);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(126);
				match(STRING);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(127);
					match(COMMA);
					setState(128);
					match(STRING);
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(136);
			match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(FlaskPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FlaskPythonParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FlaskPythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskPythonParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(ID);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(139);
				match(COMMA);
				setState(140);
				match(ID);
				}
				}
				setState(145);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(FlaskPythonParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(FlaskPythonParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(FlaskPythonParser.DEDENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(NEWLINE);
			setState(147);
			match(INDENT);
			setState(149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(148);
				statement();
				}
				}
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8246381177008L) != 0) );
			setState(153);
			match(DEDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStatementContext extends StatementContext {
		public SimpleStmtContext simpleStmt() {
			return getRuleContext(SimpleStmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(FlaskPythonParser.NEWLINE, 0); }
		public SimpleStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends StatementContext {
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ForStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends StatementContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
			case FLASK_CLASS:
			case RENDER_TEMPLATE:
			case REDIRECT:
			case URL_FOR:
			case PRINT:
			case GLOBAL:
			case BREAK:
			case CONTINUE:
			case LBRACE:
			case LBRACKET:
			case BOOLEAN:
			case ID:
			case INT:
			case STRING:
				_localctx = new SimpleStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				simpleStmt();
				setState(156);
				match(NEWLINE);
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				ifStmt();
				}
				break;
			case FOR:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				forStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStmtContext extends ParserRuleContext {
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public GlobalStmtContext globalStmt() {
			return getRuleContext(GlobalStmtContext.class,0);
		}
		public ExpressionStmtContext expressionStmt() {
			return getRuleContext(ExpressionStmtContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public SimpleStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStmt; }
	}

	public final SimpleStmtContext simpleStmt() throws RecognitionException {
		SimpleStmtContext _localctx = new SimpleStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_simpleStmt);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				returnStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				globalStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				expressionStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				printStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				breakStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(168);
				continueStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(FlaskPythonParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(FlaskPythonParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FlaskPythonParser.RPAREN, 0); }
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(PRINT);
			setState(172);
			match(LPAREN);
			setState(173);
			expression(0);
			setState(174);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(FlaskPythonParser.BREAK, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(BREAK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(FlaskPythonParser.CONTINUE, 0); }
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(CONTINUE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(FlaskPythonParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(FlaskPythonParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(FlaskPythonParser.COLON, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(FlaskPythonParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(IF);
			setState(181);
			condition();
			setState(182);
			match(COLON);
			setState(183);
			block();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(184);
				match(ELSE);
				setState(185);
				match(COLON);
				setState(186);
				block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolCondContext extends ConditionContext {
		public TerminalNode BOOLEAN() { return getToken(FlaskPythonParser.BOOLEAN, 0); }
		public BoolCondContext(ConditionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompareCondContext extends ConditionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(FlaskPythonParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(FlaskPythonParser.NOT_EQUALS, 0); }
		public CompareCondContext(ConditionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarCondContext extends ConditionContext {
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public VarCondContext(ConditionContext ctx) { copyFrom(ctx); }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_condition);
		int _la;
		try {
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new CompareCondContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				expression(0);
				setState(190);
				_la = _input.LA(1);
				if ( !(_la==EQUALS || _la==NOT_EQUALS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(191);
				expression(0);
				}
				break;
			case 2:
				_localctx = new VarCondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(ID);
				}
				break;
			case 3:
				_localctx = new BoolCondContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				match(BOOLEAN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(FlaskPythonParser.FOR, 0); }
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public TerminalNode IN() { return getToken(FlaskPythonParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(FlaskPythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(FOR);
			setState(198);
			match(ID);
			setState(199);
			match(IN);
			setState(200);
			expression(0);
			setState(201);
			match(COLON);
			setState(202);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(FlaskPythonParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(RETURN);
			setState(205);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(FlaskPythonParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(ID);
			setState(208);
			match(ASSIGN);
			setState(209);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalStmtContext extends ParserRuleContext {
		public TerminalNode GLOBAL() { return getToken(FlaskPythonParser.GLOBAL, 0); }
		public List<TerminalNode> ID() { return getTokens(FlaskPythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FlaskPythonParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FlaskPythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskPythonParser.COMMA, i);
		}
		public GlobalStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalStmt; }
	}

	public final GlobalStmtContext globalStmt() throws RecognitionException {
		GlobalStmtContext _localctx = new GlobalStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_globalStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(GLOBAL);
			setState(212);
			match(ID);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(213);
				match(COMMA);
				setState(214);
				match(ID);
				}
				}
				setState(219);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStmt; }
	}

	public final ExpressionStmtContext expressionStmt() throws RecognitionException {
		ExpressionStmtContext _localctx = new ExpressionStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expressionStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringExprContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(FlaskPythonParser.STRING, 0); }
		public StringExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public IdExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(FlaskPythonParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(FlaskPythonParser.NOT_EQUALS, 0); }
		public ComparisonExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlaskCallExprContext extends ExpressionContext {
		public FlaskFuncContext flaskFunc() {
			return getRuleContext(FlaskFuncContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(FlaskPythonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FlaskPythonParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FlaskCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListAccessExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBRACKET() { return getToken(FlaskPythonParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(FlaskPythonParser.RBRACKET, 0); }
		public ListAccessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(FlaskPythonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FlaskPythonParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctionCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DictExprContext extends ExpressionContext {
		public DictionaryContext dictionary() {
			return getRuleContext(DictionaryContext.class,0);
		}
		public DictExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListExprContext extends ExpressionContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntExprContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(FlaskPythonParser.INT, 0); }
		public IntExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExprContext extends ExpressionContext {
		public TerminalNode BOOLEAN() { return getToken(FlaskPythonParser.BOOLEAN, 0); }
		public BoolExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FlaskPythonParser.DOT, 0); }
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public MemberAccessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MathExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(FlaskPythonParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(FlaskPythonParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(FlaskPythonParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FlaskPythonParser.MINUS, 0); }
		public MathExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FlaskPythonParser.DOT, 0); }
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(FlaskPythonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FlaskPythonParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public MethodCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(223);
				match(ID);
				setState(224);
				match(LPAREN);
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8246379210752L) != 0)) {
					{
					setState(225);
					argList();
					}
				}

				setState(228);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new FlaskCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				flaskFunc();
				setState(230);
				match(LPAREN);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8246379210752L) != 0)) {
					{
					setState(231);
					argList();
					}
				}

				setState(234);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				list();
				}
				break;
			case 4:
				{
				_localctx = new DictExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				dictionary();
				}
				break;
			case 5:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				match(INT);
				}
				break;
			case 7:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240);
				match(BOOLEAN);
				}
				break;
			case 8:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
				match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(269);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new MathExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(245);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(246);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new MathExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(248);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ComparisonExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(250);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(251);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==NOT_EQUALS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(252);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new MethodCallExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(253);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(254);
						match(DOT);
						setState(255);
						match(ID);
						setState(256);
						match(LPAREN);
						setState(258);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8246379210752L) != 0)) {
							{
							setState(257);
							argList();
							}
						}

						setState(260);
						match(RPAREN);
						}
						break;
					case 5:
						{
						_localctx = new ListAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(261);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(262);
						match(LBRACKET);
						setState(263);
						expression(0);
						setState(264);
						match(RBRACKET);
						}
						break;
					case 6:
						{
						_localctx = new MemberAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(266);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(267);
						match(DOT);
						setState(268);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FlaskFuncContext extends ParserRuleContext {
		public TerminalNode RENDER_TEMPLATE() { return getToken(FlaskPythonParser.RENDER_TEMPLATE, 0); }
		public TerminalNode REDIRECT() { return getToken(FlaskPythonParser.REDIRECT, 0); }
		public TerminalNode URL_FOR() { return getToken(FlaskPythonParser.URL_FOR, 0); }
		public TerminalNode FLASK_CLASS() { return getToken(FlaskPythonParser.FLASK_CLASS, 0); }
		public FlaskFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flaskFunc; }
	}

	public final FlaskFuncContext flaskFunc() throws RecognitionException {
		FlaskFuncContext _localctx = new FlaskFuncContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_flaskFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 59392L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FlaskPythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskPythonParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			argument();
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(277);
				match(COMMA);
				setState(278);
				argument();
				}
				}
				setState(283);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentContext extends ParserRuleContext {
		public ExpressionContext value;
		public Token keyword;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(FlaskPythonParser.ASSIGN, 0); }
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_argument);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				((ArgumentContext)_localctx).value = expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				((ArgumentContext)_localctx).keyword = match(ID);
				setState(286);
				match(ASSIGN);
				setState(287);
				((ArgumentContext)_localctx).value = expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(FlaskPythonParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(FlaskPythonParser.RBRACKET, 0); }
		public ElementsContext elements() {
			return getRuleContext(ElementsContext.class,0);
		}
		public ListCompContext listComp() {
			return getRuleContext(ListCompContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(LBRACKET);
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(291);
				elements();
				}
				break;
			case 2:
				{
				setState(292);
				listComp();
				}
				break;
			}
			setState(295);
			match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FlaskPythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskPythonParser.COMMA, i);
		}
		public ElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elements; }
	}

	public final ElementsContext elements() throws RecognitionException {
		ElementsContext _localctx = new ElementsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			expression(0);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(298);
				match(COMMA);
				setState(299);
				expression(0);
				}
				}
				setState(304);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListCompContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FOR() { return getToken(FlaskPythonParser.FOR, 0); }
		public TerminalNode ID() { return getToken(FlaskPythonParser.ID, 0); }
		public TerminalNode IN() { return getToken(FlaskPythonParser.IN, 0); }
		public TerminalNode IF() { return getToken(FlaskPythonParser.IF, 0); }
		public ListCompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listComp; }
	}

	public final ListCompContext listComp() throws RecognitionException {
		ListCompContext _localctx = new ListCompContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_listComp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			expression(0);
			setState(306);
			match(FOR);
			setState(307);
			match(ID);
			setState(308);
			match(IN);
			setState(309);
			expression(0);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(310);
				match(IF);
				setState(311);
				expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DictionaryContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(FlaskPythonParser.LBRACE, 0); }
		public List<DictEntryContext> dictEntry() {
			return getRuleContexts(DictEntryContext.class);
		}
		public DictEntryContext dictEntry(int i) {
			return getRuleContext(DictEntryContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(FlaskPythonParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FlaskPythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FlaskPythonParser.COMMA, i);
		}
		public DictionaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionary; }
	}

	public final DictionaryContext dictionary() throws RecognitionException {
		DictionaryContext _localctx = new DictionaryContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_dictionary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(LBRACE);
			setState(315);
			dictEntry();
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(316);
				match(COMMA);
				setState(317);
				dictEntry();
				}
				}
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(323);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DictEntryContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COLON() { return getToken(FlaskPythonParser.COLON, 0); }
		public DictEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictEntry; }
	}

	public final DictEntryContext dictEntry() throws RecognitionException {
		DictEntryContext _localctx = new DictEntryContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_dictEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			expression(0);
			setState(326);
			match(COLON);
			setState(327);
			expression(0);
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
		case 22:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u014a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0001\u0000\u0005\u0000A\b\u0000\n\u0000\f\u0000D\t\u0000"+
		"\u0003\u0000F\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001P\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003Z\b\u0003\n\u0003\f\u0003]\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"d\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"j\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006x\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"\u0082\b\u0007\n\u0007\f\u0007\u0085\t\u0007\u0003\u0007\u0087\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u008e\b\b\n\b"+
		"\f\b\u0091\t\b\u0001\t\u0001\t\u0001\t\u0004\t\u0096\b\t\u000b\t\f\t\u0097"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00a1"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00aa\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00bc\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00c4\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00d8\b\u0014\n\u0014"+
		"\f\u0014\u00db\t\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u00e3\b\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u00e9\b\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u00f3\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0103\b\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u010e\b\u0016\n\u0016"+
		"\f\u0016\u0111\t\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0005\u0018\u0118\b\u0018\n\u0018\f\u0018\u011b\t\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0121\b\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0126\b\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u012d\b\u001b\n"+
		"\u001b\f\u001b\u0130\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0139\b\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u013f\b\u001d\n"+
		"\u001d\f\u001d\u0142\t\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0000\u0001,\u001f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<\u0000\u0005\u0003\u0000\u000b\u000b\r\u000f((\u0001\u0000"+
		" !\u0001\u0000$%\u0001\u0000\"#\u0002\u0000\u000b\u000b\r\u000f\u015a"+
		"\u0000E\u0001\u0000\u0000\u0000\u0002O\u0001\u0000\u0000\u0000\u0004Q"+
		"\u0001\u0000\u0000\u0000\u0006V\u0001\u0000\u0000\u0000\b^\u0001\u0000"+
		"\u0000\u0000\nc\u0001\u0000\u0000\u0000\fo\u0001\u0000\u0000\u0000\u000e"+
		"{\u0001\u0000\u0000\u0000\u0010\u008a\u0001\u0000\u0000\u0000\u0012\u0092"+
		"\u0001\u0000\u0000\u0000\u0014\u00a0\u0001\u0000\u0000\u0000\u0016\u00a9"+
		"\u0001\u0000\u0000\u0000\u0018\u00ab\u0001\u0000\u0000\u0000\u001a\u00b0"+
		"\u0001\u0000\u0000\u0000\u001c\u00b2\u0001\u0000\u0000\u0000\u001e\u00b4"+
		"\u0001\u0000\u0000\u0000 \u00c3\u0001\u0000\u0000\u0000\"\u00c5\u0001"+
		"\u0000\u0000\u0000$\u00cc\u0001\u0000\u0000\u0000&\u00cf\u0001\u0000\u0000"+
		"\u0000(\u00d3\u0001\u0000\u0000\u0000*\u00dc\u0001\u0000\u0000\u0000,"+
		"\u00f2\u0001\u0000\u0000\u0000.\u0112\u0001\u0000\u0000\u00000\u0114\u0001"+
		"\u0000\u0000\u00002\u0120\u0001\u0000\u0000\u00004\u0122\u0001\u0000\u0000"+
		"\u00006\u0129\u0001\u0000\u0000\u00008\u0131\u0001\u0000\u0000\u0000:"+
		"\u013a\u0001\u0000\u0000\u0000<\u0145\u0001\u0000\u0000\u0000>F\u0005"+
		"&\u0000\u0000?A\u0003\u0002\u0001\u0000@?\u0001\u0000\u0000\u0000AD\u0001"+
		"\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000E>\u0001\u0000\u0000"+
		"\u0000EB\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0005\u0000"+
		"\u0000\u0001H\u0001\u0001\u0000\u0000\u0000IJ\u0003\u0004\u0002\u0000"+
		"JK\u0005&\u0000\u0000KP\u0001\u0000\u0000\u0000LP\u0003&\u0013\u0000M"+
		"P\u0003\n\u0005\u0000NP\u0003\u0014\n\u0000OI\u0001\u0000\u0000\u0000"+
		"OL\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000ON\u0001\u0000\u0000"+
		"\u0000P\u0003\u0001\u0000\u0000\u0000QR\u0005\t\u0000\u0000RS\u0005(\u0000"+
		"\u0000ST\u0005\n\u0000\u0000TU\u0003\u0006\u0003\u0000U\u0005\u0001\u0000"+
		"\u0000\u0000V[\u0003\b\u0004\u0000WX\u0005\u001c\u0000\u0000XZ\u0003\b"+
		"\u0004\u0000YW\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u0007\u0001\u0000\u0000"+
		"\u0000][\u0001\u0000\u0000\u0000^_\u0007\u0000\u0000\u0000_\t\u0001\u0000"+
		"\u0000\u0000`a\u0003\f\u0006\u0000ab\u0005&\u0000\u0000bd\u0001\u0000"+
		"\u0000\u0000c`\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0001"+
		"\u0000\u0000\u0000ef\u0005\u0003\u0000\u0000fg\u0005(\u0000\u0000gi\u0005"+
		"\u0015\u0000\u0000hj\u0003\u0010\b\u0000ih\u0001\u0000\u0000\u0000ij\u0001"+
		"\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0005\u0016\u0000\u0000"+
		"lm\u0005\u001b\u0000\u0000mn\u0003\u0012\t\u0000n\u000b\u0001\u0000\u0000"+
		"\u0000op\u0005\u001e\u0000\u0000pq\u0005(\u0000\u0000qr\u0005\u001d\u0000"+
		"\u0000rs\u0005\f\u0000\u0000st\u0005\u0015\u0000\u0000tw\u0005*\u0000"+
		"\u0000uv\u0005\u001c\u0000\u0000vx\u0003\u000e\u0007\u0000wu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0005"+
		"\u0016\u0000\u0000z\r\u0001\u0000\u0000\u0000{|\u0005\u0010\u0000\u0000"+
		"|}\u0005\u001f\u0000\u0000}\u0086\u0005\u0019\u0000\u0000~\u0083\u0005"+
		"*\u0000\u0000\u007f\u0080\u0005\u001c\u0000\u0000\u0080\u0082\u0005*\u0000"+
		"\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000"+
		"\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000"+
		"\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000"+
		"\u0000\u0086~\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u001a\u0000\u0000"+
		"\u0089\u000f\u0001\u0000\u0000\u0000\u008a\u008f\u0005(\u0000\u0000\u008b"+
		"\u008c\u0005\u001c\u0000\u0000\u008c\u008e\u0005(\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0011"+
		"\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0005&\u0000\u0000\u0093\u0095\u0005\u0001\u0000\u0000\u0094\u0096\u0003"+
		"\u0014\n\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000"+
		"\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0002"+
		"\u0000\u0000\u009a\u0013\u0001\u0000\u0000\u0000\u009b\u009c\u0003\u0016"+
		"\u000b\u0000\u009c\u009d\u0005&\u0000\u0000\u009d\u00a1\u0001\u0000\u0000"+
		"\u0000\u009e\u00a1\u0003\u001e\u000f\u0000\u009f\u00a1\u0003\"\u0011\u0000"+
		"\u00a0\u009b\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000"+
		"\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u0015\u0001\u0000\u0000\u0000"+
		"\u00a2\u00aa\u0003$\u0012\u0000\u00a3\u00aa\u0003&\u0013\u0000\u00a4\u00aa"+
		"\u0003(\u0014\u0000\u00a5\u00aa\u0003*\u0015\u0000\u00a6\u00aa\u0003\u0018"+
		"\f\u0000\u00a7\u00aa\u0003\u001a\r\u0000\u00a8\u00aa\u0003\u001c\u000e"+
		"\u0000\u00a9\u00a2\u0001\u0000\u0000\u0000\u00a9\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a4\u0001\u0000\u0000\u0000\u00a9\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a6\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u0017\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0005\u0011\u0000\u0000\u00ac\u00ad\u0005\u0015\u0000"+
		"\u0000\u00ad\u00ae\u0003,\u0016\u0000\u00ae\u00af\u0005\u0016\u0000\u0000"+
		"\u00af\u0019\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u0013\u0000\u0000"+
		"\u00b1\u001b\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u0014\u0000\u0000"+
		"\u00b3\u001d\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005\u0005\u0000\u0000"+
		"\u00b5\u00b6\u0003 \u0010\u0000\u00b6\u00b7\u0005\u001b\u0000\u0000\u00b7"+
		"\u00bb\u0003\u0012\t\u0000\u00b8\u00b9\u0005\u0006\u0000\u0000\u00b9\u00ba"+
		"\u0005\u001b\u0000\u0000\u00ba\u00bc\u0003\u0012\t\u0000\u00bb\u00b8\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u001f\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0003,\u0016\u0000\u00be\u00bf\u0007\u0001"+
		"\u0000\u0000\u00bf\u00c0\u0003,\u0016\u0000\u00c0\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c4\u0005(\u0000\u0000\u00c2\u00c4\u0005\'\u0000\u0000"+
		"\u00c3\u00bd\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c4!\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005\u0007\u0000\u0000\u00c6\u00c7\u0005(\u0000\u0000\u00c7\u00c8"+
		"\u0005\b\u0000\u0000\u00c8\u00c9\u0003,\u0016\u0000\u00c9\u00ca\u0005"+
		"\u001b\u0000\u0000\u00ca\u00cb\u0003\u0012\t\u0000\u00cb#\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0005\u0004\u0000\u0000\u00cd\u00ce\u0003,\u0016"+
		"\u0000\u00ce%\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005(\u0000\u0000\u00d0"+
		"\u00d1\u0005\u001f\u0000\u0000\u00d1\u00d2\u0003,\u0016\u0000\u00d2\'"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u0012\u0000\u0000\u00d4\u00d9"+
		"\u0005(\u0000\u0000\u00d5\u00d6\u0005\u001c\u0000\u0000\u00d6\u00d8\u0005"+
		"(\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000"+
		"\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da)\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000"+
		"\u0000\u00dc\u00dd\u0003,\u0016\u0000\u00dd+\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0006\u0016\uffff\uffff\u0000\u00df\u00e0\u0005(\u0000\u0000\u00e0"+
		"\u00e2\u0005\u0015\u0000\u0000\u00e1\u00e3\u00030\u0018\u0000\u00e2\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e4\u00f3\u0005\u0016\u0000\u0000\u00e5\u00e6"+
		"\u0003.\u0017\u0000\u00e6\u00e8\u0005\u0015\u0000\u0000\u00e7\u00e9\u0003"+
		"0\u0018\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005\u0016"+
		"\u0000\u0000\u00eb\u00f3\u0001\u0000\u0000\u0000\u00ec\u00f3\u00034\u001a"+
		"\u0000\u00ed\u00f3\u0003:\u001d\u0000\u00ee\u00f3\u0005(\u0000\u0000\u00ef"+
		"\u00f3\u0005)\u0000\u0000\u00f0\u00f3\u0005\'\u0000\u0000\u00f1\u00f3"+
		"\u0005*\u0000\u0000\u00f2\u00de\u0001\u0000\u0000\u0000\u00f2\u00e5\u0001"+
		"\u0000\u0000\u0000\u00f2\u00ec\u0001\u0000\u0000\u0000\u00f2\u00ed\u0001"+
		"\u0000\u0000\u0000\u00f2\u00ee\u0001\u0000\u0000\u0000\u00f2\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f3\u010f\u0001\u0000\u0000\u0000\u00f4\u00f5\n\t"+
		"\u0000\u0000\u00f5\u00f6\u0007\u0002\u0000\u0000\u00f6\u010e\u0003,\u0016"+
		"\n\u00f7\u00f8\n\b\u0000\u0000\u00f8\u00f9\u0007\u0003\u0000\u0000\u00f9"+
		"\u010e\u0003,\u0016\t\u00fa\u00fb\n\u0007\u0000\u0000\u00fb\u00fc\u0007"+
		"\u0001\u0000\u0000\u00fc\u010e\u0003,\u0016\b\u00fd\u00fe\n\u000e\u0000"+
		"\u0000\u00fe\u00ff\u0005\u001d\u0000\u0000\u00ff\u0100\u0005(\u0000\u0000"+
		"\u0100\u0102\u0005\u0015\u0000\u0000\u0101\u0103\u00030\u0018\u0000\u0102"+
		"\u0101\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0001\u0000\u0000\u0000\u0104\u010e\u0005\u0016\u0000\u0000\u0105"+
		"\u0106\n\r\u0000\u0000\u0106\u0107\u0005\u0019\u0000\u0000\u0107\u0108"+
		"\u0003,\u0016\u0000\u0108\u0109\u0005\u001a\u0000\u0000\u0109\u010e\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\n\f\u0000\u0000\u010b\u010c\u0005\u001d"+
		"\u0000\u0000\u010c\u010e\u0005(\u0000\u0000\u010d\u00f4\u0001\u0000\u0000"+
		"\u0000\u010d\u00f7\u0001\u0000\u0000\u0000\u010d\u00fa\u0001\u0000\u0000"+
		"\u0000\u010d\u00fd\u0001\u0000\u0000\u0000\u010d\u0105\u0001\u0000\u0000"+
		"\u0000\u010d\u010a\u0001\u0000\u0000\u0000\u010e\u0111\u0001\u0000\u0000"+
		"\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000"+
		"\u0000\u0110-\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0007\u0004\u0000\u0000\u0113/\u0001\u0000\u0000\u0000\u0114"+
		"\u0119\u00032\u0019\u0000\u0115\u0116\u0005\u001c\u0000\u0000\u0116\u0118"+
		"\u00032\u0019\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u011b\u0001"+
		"\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u0119\u011a\u0001"+
		"\u0000\u0000\u0000\u011a1\u0001\u0000\u0000\u0000\u011b\u0119\u0001\u0000"+
		"\u0000\u0000\u011c\u0121\u0003,\u0016\u0000\u011d\u011e\u0005(\u0000\u0000"+
		"\u011e\u011f\u0005\u001f\u0000\u0000\u011f\u0121\u0003,\u0016\u0000\u0120"+
		"\u011c\u0001\u0000\u0000\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0121"+
		"3\u0001\u0000\u0000\u0000\u0122\u0125\u0005\u0019\u0000\u0000\u0123\u0126"+
		"\u00036\u001b\u0000\u0124\u0126\u00038\u001c\u0000\u0125\u0123\u0001\u0000"+
		"\u0000\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000"+
		"\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0128\u0005\u001a"+
		"\u0000\u0000\u01285\u0001\u0000\u0000\u0000\u0129\u012e\u0003,\u0016\u0000"+
		"\u012a\u012b\u0005\u001c\u0000\u0000\u012b\u012d\u0003,\u0016\u0000\u012c"+
		"\u012a\u0001\u0000\u0000\u0000\u012d\u0130\u0001\u0000\u0000\u0000\u012e"+
		"\u012c\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f"+
		"7\u0001\u0000\u0000\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0131\u0132"+
		"\u0003,\u0016\u0000\u0132\u0133\u0005\u0007\u0000\u0000\u0133\u0134\u0005"+
		"(\u0000\u0000\u0134\u0135\u0005\b\u0000\u0000\u0135\u0138\u0003,\u0016"+
		"\u0000\u0136\u0137\u0005\u0005\u0000\u0000\u0137\u0139\u0003,\u0016\u0000"+
		"\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000"+
		"\u01399\u0001\u0000\u0000\u0000\u013a\u013b\u0005\u0017\u0000\u0000\u013b"+
		"\u0140\u0003<\u001e\u0000\u013c\u013d\u0005\u001c\u0000\u0000\u013d\u013f"+
		"\u0003<\u001e\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013f\u0142\u0001"+
		"\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001"+
		"\u0000\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u0140\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0005\u0018\u0000\u0000\u0144;\u0001\u0000"+
		"\u0000\u0000\u0145\u0146\u0003,\u0016\u0000\u0146\u0147\u0005\u001b\u0000"+
		"\u0000\u0147\u0148\u0003,\u0016\u0000\u0148=\u0001\u0000\u0000\u0000\u001c"+
		"BEO[ciw\u0083\u0086\u008f\u0097\u00a0\u00a9\u00bb\u00c3\u00d9\u00e2\u00e8"+
		"\u00f2\u0102\u010d\u010f\u0119\u0120\u0125\u012e\u0138\u0140";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}