// Generated from C:/Users/VICTUS/Desktop/lectures/projects/CompilerProject/grammars/TemplatesGrammars/TemplatesParser.g4 by ANTLR 4.13.2
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TemplatesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOCTYPE=1, COMMENT=2, TAG_OPEN=3, TAG_CLOSE_TAG=4, J_BLOCK_START=5, J_EXPR_START=6, 
		TEXT=7, TAG_WS=8, TAG_EQUALS=9, TAG_STRING=10, VOID_TAG_ID=11, TAG_ID=12, 
		TAG_EXIT=13, TAG_EXIT_SELF=14, J_WS=15, J_IF=16, J_ELSE=17, J_ENDIF=18, 
		J_FOR=19, J_ENDFOR=20, J_IN=21, J_AND=22, J_OR=23, J_NOT=24, J_SET=25, 
		J_TRUE=26, J_FALSE=27, J_BLOCK_CLOSE=28, J_EXPR_CLOSE=29, J_EQ=30, J_NEQ=31, 
		PLUS=32, MINUS=33, MUL=34, DIV=35, J_LBRACK=36, J_RBRACK=37, J_DOT=38, 
		J_LPAREN=39, J_RPAREN=40, J_GT=41, J_LT=42, J_GTE=43, J_LTE=44, J_STRING=45, 
		J_INT=46, J_ID=47, J_ASSIGN=48;
	public static final int
		RULE_template = 0, RULE_content = 1, RULE_htmlElement = 2, RULE_attribute = 3, 
		RULE_jinjaElement = 4, RULE_jinjaPrint = 5, RULE_jinjaIf = 6, RULE_jinjaFor = 7, 
		RULE_jinjaSet = 8, RULE_expression = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"template", "content", "htmlElement", "attribute", "jinjaElement", "jinjaPrint", 
			"jinjaIf", "jinjaFor", "jinjaSet", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'</'", "'{%'", "'{{'", null, null, null, null, 
			null, null, null, "'/>'", null, "'if'", "'else'", "'endif'", "'for'", 
			"'endfor'", "'in'", "'and'", "'or'", "'not'", "'set'", null, null, "'%}'", 
			"'}}'", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'['", "']'", "'.'", 
			"'('", "')'", null, null, "'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOCTYPE", "COMMENT", "TAG_OPEN", "TAG_CLOSE_TAG", "J_BLOCK_START", 
			"J_EXPR_START", "TEXT", "TAG_WS", "TAG_EQUALS", "TAG_STRING", "VOID_TAG_ID", 
			"TAG_ID", "TAG_EXIT", "TAG_EXIT_SELF", "J_WS", "J_IF", "J_ELSE", "J_ENDIF", 
			"J_FOR", "J_ENDFOR", "J_IN", "J_AND", "J_OR", "J_NOT", "J_SET", "J_TRUE", 
			"J_FALSE", "J_BLOCK_CLOSE", "J_EXPR_CLOSE", "J_EQ", "J_NEQ", "PLUS", 
			"MINUS", "MUL", "DIV", "J_LBRACK", "J_RBRACK", "J_DOT", "J_LPAREN", "J_RPAREN", 
			"J_GT", "J_LT", "J_GTE", "J_LTE", "J_STRING", "J_INT", "J_ID", "J_ASSIGN"
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
	public String getGrammarFileName() { return "TemplatesParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TemplatesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TemplatesParser.EOF, 0); }
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitTemplate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitTemplate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_template);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 232L) != 0)) {
				{
				{
				setState(20);
				content();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
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
	public static class ContentContext extends ParserRuleContext {
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
	 
		public ContentContext() { }
		public void copyFrom(ContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentContext extends ContentContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public HtmlContentContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterHtmlContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitHtmlContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitHtmlContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextContentContext extends ContentContext {
		public TerminalNode TEXT() { return getToken(TemplatesParser.TEXT, 0); }
		public TextContentContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterTextContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitTextContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitTextContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaContentContext extends ContentContext {
		public JinjaElementContext jinjaElement() {
			return getRuleContext(JinjaElementContext.class,0);
		}
		public JinjaContentContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterJinjaContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitJinjaContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitJinjaContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_content);
		try {
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_OPEN:
				_localctx = new HtmlContentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				htmlElement();
				}
				break;
			case J_BLOCK_START:
			case J_EXPR_START:
				_localctx = new JinjaContentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				jinjaElement();
				}
				break;
			case TEXT:
				_localctx = new TextContentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				match(TEXT);
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
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidElementContext extends HtmlElementContext {
		public TerminalNode TAG_OPEN() { return getToken(TemplatesParser.TAG_OPEN, 0); }
		public TerminalNode VOID_TAG_ID() { return getToken(TemplatesParser.VOID_TAG_ID, 0); }
		public TerminalNode TAG_EXIT() { return getToken(TemplatesParser.TAG_EXIT, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public VoidElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterVoidElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitVoidElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitVoidElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagContext extends HtmlElementContext {
		public TerminalNode TAG_OPEN() { return getToken(TemplatesParser.TAG_OPEN, 0); }
		public TerminalNode TAG_EXIT_SELF() { return getToken(TemplatesParser.TAG_EXIT_SELF, 0); }
		public TerminalNode TAG_ID() { return getToken(TemplatesParser.TAG_ID, 0); }
		public TerminalNode VOID_TAG_ID() { return getToken(TemplatesParser.VOID_TAG_ID, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public SelfClosingTagContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterSelfClosingTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitSelfClosingTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitSelfClosingTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalTagContext extends HtmlElementContext {
		public TerminalNode TAG_OPEN() { return getToken(TemplatesParser.TAG_OPEN, 0); }
		public List<TerminalNode> TAG_ID() { return getTokens(TemplatesParser.TAG_ID); }
		public TerminalNode TAG_ID(int i) {
			return getToken(TemplatesParser.TAG_ID, i);
		}
		public List<TerminalNode> TAG_EXIT() { return getTokens(TemplatesParser.TAG_EXIT); }
		public TerminalNode TAG_EXIT(int i) {
			return getToken(TemplatesParser.TAG_EXIT, i);
		}
		public TerminalNode TAG_CLOSE_TAG() { return getToken(TemplatesParser.TAG_CLOSE_TAG, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public NormalTagContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterNormalTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitNormalTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitNormalTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlElement);
		int _la;
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new NormalTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(TAG_OPEN);
				setState(34);
				match(TAG_ID);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID_TAG_ID || _la==TAG_ID) {
					{
					{
					setState(35);
					attribute();
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(41);
				match(TAG_EXIT);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 232L) != 0)) {
					{
					{
					setState(42);
					content();
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(48);
				match(TAG_CLOSE_TAG);
				setState(49);
				match(TAG_ID);
				setState(50);
				match(TAG_EXIT);
				}
				break;
			case 2:
				_localctx = new VoidElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(TAG_OPEN);
				setState(52);
				match(VOID_TAG_ID);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID_TAG_ID || _la==TAG_ID) {
					{
					{
					setState(53);
					attribute();
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(59);
				match(TAG_EXIT);
				}
				break;
			case 3:
				_localctx = new SelfClosingTagContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				match(TAG_OPEN);
				setState(61);
				_la = _input.LA(1);
				if ( !(_la==VOID_TAG_ID || _la==TAG_ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID_TAG_ID || _la==TAG_ID) {
					{
					{
					setState(62);
					attribute();
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(68);
				match(TAG_EXIT_SELF);
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
	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OnlyKeyAttributeContext extends AttributeContext {
		public TerminalNode TAG_ID() { return getToken(TemplatesParser.TAG_ID, 0); }
		public TerminalNode VOID_TAG_ID() { return getToken(TemplatesParser.VOID_TAG_ID, 0); }
		public OnlyKeyAttributeContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterOnlyKeyAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitOnlyKeyAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitOnlyKeyAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class KeyValueAttributeContext extends AttributeContext {
		public TerminalNode TAG_EQUALS() { return getToken(TemplatesParser.TAG_EQUALS, 0); }
		public TerminalNode TAG_STRING() { return getToken(TemplatesParser.TAG_STRING, 0); }
		public TerminalNode TAG_ID() { return getToken(TemplatesParser.TAG_ID, 0); }
		public TerminalNode VOID_TAG_ID() { return getToken(TemplatesParser.VOID_TAG_ID, 0); }
		public KeyValueAttributeContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterKeyValueAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitKeyValueAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitKeyValueAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attribute);
		int _la;
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new KeyValueAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				_la = _input.LA(1);
				if ( !(_la==VOID_TAG_ID || _la==TAG_ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(72);
				match(TAG_EQUALS);
				setState(73);
				match(TAG_STRING);
				}
				break;
			case 2:
				_localctx = new OnlyKeyAttributeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==VOID_TAG_ID || _la==TAG_ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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
	public static class JinjaElementContext extends ParserRuleContext {
		public JinjaPrintContext jinjaPrint() {
			return getRuleContext(JinjaPrintContext.class,0);
		}
		public JinjaIfContext jinjaIf() {
			return getRuleContext(JinjaIfContext.class,0);
		}
		public JinjaForContext jinjaFor() {
			return getRuleContext(JinjaForContext.class,0);
		}
		public JinjaSetContext jinjaSet() {
			return getRuleContext(JinjaSetContext.class,0);
		}
		public JinjaElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterJinjaElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitJinjaElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitJinjaElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaElementContext jinjaElement() throws RecognitionException {
		JinjaElementContext _localctx = new JinjaElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_jinjaElement);
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				jinjaPrint();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				jinjaIf();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				jinjaFor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				jinjaSet();
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
	public static class JinjaPrintContext extends ParserRuleContext {
		public TerminalNode J_EXPR_START() { return getToken(TemplatesParser.J_EXPR_START, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode J_EXPR_CLOSE() { return getToken(TemplatesParser.J_EXPR_CLOSE, 0); }
		public JinjaPrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaPrint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterJinjaPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitJinjaPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitJinjaPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaPrintContext jinjaPrint() throws RecognitionException {
		JinjaPrintContext _localctx = new JinjaPrintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_jinjaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(J_EXPR_START);
			setState(84);
			expression(0);
			setState(85);
			match(J_EXPR_CLOSE);
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
	public static class JinjaIfContext extends ParserRuleContext {
		public ContentContext content;
		public List<ContentContext> thenBlock = new ArrayList<ContentContext>();
		public List<ContentContext> elseBlock = new ArrayList<ContentContext>();
		public List<TerminalNode> J_BLOCK_START() { return getTokens(TemplatesParser.J_BLOCK_START); }
		public TerminalNode J_BLOCK_START(int i) {
			return getToken(TemplatesParser.J_BLOCK_START, i);
		}
		public TerminalNode J_IF() { return getToken(TemplatesParser.J_IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> J_BLOCK_CLOSE() { return getTokens(TemplatesParser.J_BLOCK_CLOSE); }
		public TerminalNode J_BLOCK_CLOSE(int i) {
			return getToken(TemplatesParser.J_BLOCK_CLOSE, i);
		}
		public TerminalNode J_ENDIF() { return getToken(TemplatesParser.J_ENDIF, 0); }
		public TerminalNode J_ELSE() { return getToken(TemplatesParser.J_ELSE, 0); }
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public JinjaIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterJinjaIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitJinjaIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitJinjaIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaIfContext jinjaIf() throws RecognitionException {
		JinjaIfContext _localctx = new JinjaIfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_jinjaIf);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(J_BLOCK_START);
			setState(88);
			match(J_IF);
			setState(89);
			expression(0);
			setState(90);
			match(J_BLOCK_CLOSE);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(91);
					((JinjaIfContext)_localctx).content = content();
					((JinjaIfContext)_localctx).thenBlock.add(((JinjaIfContext)_localctx).content);
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(97);
				match(J_BLOCK_START);
				setState(98);
				match(J_ELSE);
				setState(99);
				match(J_BLOCK_CLOSE);
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(100);
						((JinjaIfContext)_localctx).content = content();
						((JinjaIfContext)_localctx).elseBlock.add(((JinjaIfContext)_localctx).content);
						}
						} 
					}
					setState(105);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				break;
			}
			setState(108);
			match(J_BLOCK_START);
			setState(109);
			match(J_ENDIF);
			setState(110);
			match(J_BLOCK_CLOSE);
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
	public static class JinjaForContext extends ParserRuleContext {
		public List<TerminalNode> J_BLOCK_START() { return getTokens(TemplatesParser.J_BLOCK_START); }
		public TerminalNode J_BLOCK_START(int i) {
			return getToken(TemplatesParser.J_BLOCK_START, i);
		}
		public TerminalNode J_FOR() { return getToken(TemplatesParser.J_FOR, 0); }
		public List<TerminalNode> J_ID() { return getTokens(TemplatesParser.J_ID); }
		public TerminalNode J_ID(int i) {
			return getToken(TemplatesParser.J_ID, i);
		}
		public TerminalNode J_IN() { return getToken(TemplatesParser.J_IN, 0); }
		public List<TerminalNode> J_BLOCK_CLOSE() { return getTokens(TemplatesParser.J_BLOCK_CLOSE); }
		public TerminalNode J_BLOCK_CLOSE(int i) {
			return getToken(TemplatesParser.J_BLOCK_CLOSE, i);
		}
		public TerminalNode J_ENDFOR() { return getToken(TemplatesParser.J_ENDFOR, 0); }
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public JinjaForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaFor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterJinjaFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitJinjaFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitJinjaFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaForContext jinjaFor() throws RecognitionException {
		JinjaForContext _localctx = new JinjaForContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_jinjaFor);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(J_BLOCK_START);
			setState(113);
			match(J_FOR);
			setState(114);
			match(J_ID);
			setState(115);
			match(J_IN);
			setState(116);
			match(J_ID);
			setState(117);
			match(J_BLOCK_CLOSE);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(118);
					content();
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(124);
			match(J_BLOCK_START);
			setState(125);
			match(J_ENDFOR);
			setState(126);
			match(J_BLOCK_CLOSE);
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
	public static class JinjaSetContext extends ParserRuleContext {
		public TerminalNode J_BLOCK_START() { return getToken(TemplatesParser.J_BLOCK_START, 0); }
		public TerminalNode J_SET() { return getToken(TemplatesParser.J_SET, 0); }
		public TerminalNode J_ID() { return getToken(TemplatesParser.J_ID, 0); }
		public TerminalNode J_ASSIGN() { return getToken(TemplatesParser.J_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode J_BLOCK_CLOSE() { return getToken(TemplatesParser.J_BLOCK_CLOSE, 0); }
		public JinjaSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterJinjaSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitJinjaSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitJinjaSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaSetContext jinjaSet() throws RecognitionException {
		JinjaSetContext _localctx = new JinjaSetContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_jinjaSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(J_BLOCK_START);
			setState(129);
			match(J_SET);
			setState(130);
			match(J_ID);
			setState(131);
			match(J_ASSIGN);
			setState(132);
			expression(0);
			setState(133);
			match(J_BLOCK_CLOSE);
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
		public TerminalNode J_STRING() { return getToken(TemplatesParser.J_STRING, 0); }
		public StringExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitStringExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitStringExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExprContext extends ExpressionContext {
		public TerminalNode J_TRUE() { return getToken(TemplatesParser.J_TRUE, 0); }
		public TerminalNode J_FALSE() { return getToken(TemplatesParser.J_FALSE, 0); }
		public BoolExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode J_EQ() { return getToken(TemplatesParser.J_EQ, 0); }
		public TerminalNode J_NEQ() { return getToken(TemplatesParser.J_NEQ, 0); }
		public TerminalNode J_GT() { return getToken(TemplatesParser.J_GT, 0); }
		public TerminalNode J_LT() { return getToken(TemplatesParser.J_LT, 0); }
		public TerminalNode J_GTE() { return getToken(TemplatesParser.J_GTE, 0); }
		public TerminalNode J_LTE() { return getToken(TemplatesParser.J_LTE, 0); }
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarExprContext extends ExpressionContext {
		public TerminalNode J_ID() { return getToken(TemplatesParser.J_ID, 0); }
		public VarExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExpressionContext {
		public TerminalNode J_NOT() { return getToken(TemplatesParser.J_NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntExprContext extends ExpressionContext {
		public TerminalNode J_INT() { return getToken(TemplatesParser.J_INT, 0); }
		public IntExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DictAccessExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode J_LBRACK() { return getToken(TemplatesParser.J_LBRACK, 0); }
		public TerminalNode J_STRING() { return getToken(TemplatesParser.J_STRING, 0); }
		public TerminalNode J_RBRACK() { return getToken(TemplatesParser.J_RBRACK, 0); }
		public DictAccessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterDictAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitDictAccessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitDictAccessExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExpressionContext {
		public TerminalNode J_LPAREN() { return getToken(TemplatesParser.J_LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode J_RPAREN() { return getToken(TemplatesParser.J_RPAREN, 0); }
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode J_DOT() { return getToken(TemplatesParser.J_DOT, 0); }
		public TerminalNode J_ID() { return getToken(TemplatesParser.J_ID, 0); }
		public MemberAccessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterMemberAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitMemberAccessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitMemberAccessExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode J_AND() { return getToken(TemplatesParser.J_AND, 0); }
		public TerminalNode J_OR() { return getToken(TemplatesParser.J_OR, 0); }
		public LogicalExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterLogicalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitLogicalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitLogicalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MathExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(TemplatesParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(TemplatesParser.MUL, 0); }
		public TerminalNode PLUS() { return getToken(TemplatesParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TemplatesParser.MINUS, 0); }
		public MathExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterMathExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitMathExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitMathExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case J_LPAREN:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(136);
				match(J_LPAREN);
				setState(137);
				expression(0);
				setState(138);
				match(J_RPAREN);
				}
				break;
			case J_NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(J_NOT);
				setState(141);
				expression(7);
				}
				break;
			case J_ID:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(J_ID);
				}
				break;
			case J_STRING:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(J_STRING);
				}
				break;
			case J_INT:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(J_INT);
				}
				break;
			case J_TRUE:
			case J_FALSE:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				_la = _input.LA(1);
				if ( !(_la==J_TRUE || _la==J_FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(167);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new MathExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(148);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(149);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(150);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new MathExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(151);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(152);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(153);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(154);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(155);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32988570058752L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(156);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new LogicalExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(157);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(158);
						_la = _input.LA(1);
						if ( !(_la==J_AND || _la==J_OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(159);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new MemberAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(160);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(161);
						match(J_DOT);
						setState(162);
						match(J_ID);
						}
						break;
					case 6:
						{
						_localctx = new DictAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(163);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(164);
						match(J_LBRACK);
						setState(165);
						match(J_STRING);
						setState(166);
						match(J_RBRACK);
						}
						break;
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
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
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00010\u00ad\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0005\u0000\u0016\b\u0000\n\u0000"+
		"\f\u0000\u0019\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002%\b\u0002\n\u0002\f\u0002(\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002,\b\u0002\n\u0002\f\u0002/\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00027\b\u0002"+
		"\n\u0002\f\u0002:\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002@\b\u0002\n\u0002\f\u0002C\t\u0002\u0001\u0002\u0003\u0002"+
		"F\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"L\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"R\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006]\b\u0006"+
		"\n\u0006\f\u0006`\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006f\b\u0006\n\u0006\f\u0006i\t\u0006\u0003\u0006k\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007x\b"+
		"\u0007\n\u0007\f\u0007{\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u0093\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00a8\b\t\n\t\f\t\u00ab\t\t"+
		"\u0001\t\u0000\u0001\u0012\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0000\u0006\u0001\u0000\u000b\f\u0001\u0000\u001a\u001b\u0001\u0000"+
		"\"#\u0001\u0000 !\u0002\u0000\u001e\u001f),\u0001\u0000\u0016\u0017\u00be"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0002\u001f\u0001\u0000\u0000\u0000"+
		"\u0004E\u0001\u0000\u0000\u0000\u0006K\u0001\u0000\u0000\u0000\bQ\u0001"+
		"\u0000\u0000\u0000\nS\u0001\u0000\u0000\u0000\fW\u0001\u0000\u0000\u0000"+
		"\u000ep\u0001\u0000\u0000\u0000\u0010\u0080\u0001\u0000\u0000\u0000\u0012"+
		"\u0092\u0001\u0000\u0000\u0000\u0014\u0016\u0003\u0002\u0001\u0000\u0015"+
		"\u0014\u0001\u0000\u0000\u0000\u0016\u0019\u0001\u0000\u0000\u0000\u0017"+
		"\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018"+
		"\u001a\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0005\u0000\u0000\u0001\u001b\u0001\u0001\u0000\u0000\u0000\u001c"+
		" \u0003\u0004\u0002\u0000\u001d \u0003\b\u0004\u0000\u001e \u0005\u0007"+
		"\u0000\u0000\u001f\u001c\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000"+
		"\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000 \u0003\u0001\u0000\u0000"+
		"\u0000!\"\u0005\u0003\u0000\u0000\"&\u0005\f\u0000\u0000#%\u0003\u0006"+
		"\u0003\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001"+
		"\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000"+
		"(&\u0001\u0000\u0000\u0000)-\u0005\r\u0000\u0000*,\u0003\u0002\u0001\u0000"+
		"+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000-.\u0001\u0000\u0000\u0000.0\u0001\u0000\u0000\u0000/-\u0001\u0000"+
		"\u0000\u000001\u0005\u0004\u0000\u000012\u0005\f\u0000\u00002F\u0005\r"+
		"\u0000\u000034\u0005\u0003\u0000\u000048\u0005\u000b\u0000\u000057\u0003"+
		"\u0006\u0003\u000065\u0001\u0000\u0000\u00007:\u0001\u0000\u0000\u0000"+
		"86\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000;F\u0005\r\u0000\u0000<=\u0005\u0003\u0000"+
		"\u0000=A\u0007\u0000\u0000\u0000>@\u0003\u0006\u0003\u0000?>\u0001\u0000"+
		"\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000BD\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"DF\u0005\u000e\u0000\u0000E!\u0001\u0000\u0000\u0000E3\u0001\u0000\u0000"+
		"\u0000E<\u0001\u0000\u0000\u0000F\u0005\u0001\u0000\u0000\u0000GH\u0007"+
		"\u0000\u0000\u0000HI\u0005\t\u0000\u0000IL\u0005\n\u0000\u0000JL\u0007"+
		"\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000"+
		"L\u0007\u0001\u0000\u0000\u0000MR\u0003\n\u0005\u0000NR\u0003\f\u0006"+
		"\u0000OR\u0003\u000e\u0007\u0000PR\u0003\u0010\b\u0000QM\u0001\u0000\u0000"+
		"\u0000QN\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QP\u0001\u0000"+
		"\u0000\u0000R\t\u0001\u0000\u0000\u0000ST\u0005\u0006\u0000\u0000TU\u0003"+
		"\u0012\t\u0000UV\u0005\u001d\u0000\u0000V\u000b\u0001\u0000\u0000\u0000"+
		"WX\u0005\u0005\u0000\u0000XY\u0005\u0010\u0000\u0000YZ\u0003\u0012\t\u0000"+
		"Z^\u0005\u001c\u0000\u0000[]\u0003\u0002\u0001\u0000\\[\u0001\u0000\u0000"+
		"\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_j\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0005"+
		"\u0005\u0000\u0000bc\u0005\u0011\u0000\u0000cg\u0005\u001c\u0000\u0000"+
		"df\u0003\u0002\u0001\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000"+
		"\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hk\u0001\u0000"+
		"\u0000\u0000ig\u0001\u0000\u0000\u0000ja\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0005\u0005\u0000\u0000"+
		"mn\u0005\u0012\u0000\u0000no\u0005\u001c\u0000\u0000o\r\u0001\u0000\u0000"+
		"\u0000pq\u0005\u0005\u0000\u0000qr\u0005\u0013\u0000\u0000rs\u0005/\u0000"+
		"\u0000st\u0005\u0015\u0000\u0000tu\u0005/\u0000\u0000uy\u0005\u001c\u0000"+
		"\u0000vx\u0003\u0002\u0001\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001"+
		"\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000|}\u0005\u0005\u0000\u0000"+
		"}~\u0005\u0014\u0000\u0000~\u007f\u0005\u001c\u0000\u0000\u007f\u000f"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0005\u0000\u0000\u0081\u0082"+
		"\u0005\u0019\u0000\u0000\u0082\u0083\u0005/\u0000\u0000\u0083\u0084\u0005"+
		"0\u0000\u0000\u0084\u0085\u0003\u0012\t\u0000\u0085\u0086\u0005\u001c"+
		"\u0000\u0000\u0086\u0011\u0001\u0000\u0000\u0000\u0087\u0088\u0006\t\uffff"+
		"\uffff\u0000\u0088\u0089\u0005\'\u0000\u0000\u0089\u008a\u0003\u0012\t"+
		"\u0000\u008a\u008b\u0005(\u0000\u0000\u008b\u0093\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0005\u0018\u0000\u0000\u008d\u0093\u0003\u0012\t\u0007\u008e"+
		"\u0093\u0005/\u0000\u0000\u008f\u0093\u0005-\u0000\u0000\u0090\u0093\u0005"+
		".\u0000\u0000\u0091\u0093\u0007\u0001\u0000\u0000\u0092\u0087\u0001\u0000"+
		"\u0000\u0000\u0092\u008c\u0001\u0000\u0000\u0000\u0092\u008e\u0001\u0000"+
		"\u0000\u0000\u0092\u008f\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u00a9\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\n\t\u0000\u0000\u0095\u0096\u0007\u0002\u0000"+
		"\u0000\u0096\u00a8\u0003\u0012\t\n\u0097\u0098\n\b\u0000\u0000\u0098\u0099"+
		"\u0007\u0003\u0000\u0000\u0099\u00a8\u0003\u0012\t\t\u009a\u009b\n\u0006"+
		"\u0000\u0000\u009b\u009c\u0007\u0004\u0000\u0000\u009c\u00a8\u0003\u0012"+
		"\t\u0007\u009d\u009e\n\u0005\u0000\u0000\u009e\u009f\u0007\u0005\u0000"+
		"\u0000\u009f\u00a8\u0003\u0012\t\u0006\u00a0\u00a1\n\u000b\u0000\u0000"+
		"\u00a1\u00a2\u0005&\u0000\u0000\u00a2\u00a8\u0005/\u0000\u0000\u00a3\u00a4"+
		"\n\n\u0000\u0000\u00a4\u00a5\u0005$\u0000\u0000\u00a5\u00a6\u0005-\u0000"+
		"\u0000\u00a6\u00a8\u0005%\u0000\u0000\u00a7\u0094\u0001\u0000\u0000\u0000"+
		"\u00a7\u0097\u0001\u0000\u0000\u0000\u00a7\u009a\u0001\u0000\u0000\u0000"+
		"\u00a7\u009d\u0001\u0000\u0000\u0000\u00a7\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a3\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000"+
		"\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000"+
		"\u00aa\u0013\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000"+
		"\u0010\u0017\u001f&-8AEKQ^gjy\u0092\u00a7\u00a9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}