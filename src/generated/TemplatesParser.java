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
		TEXT=7, TAG_WS=8, TAG_EQUALS=9, DOUBLE_QUOTE=10, SINGLE_QUOTE=11, VOID_TAG_ID=12, 
		TAG_ID=13, TAG_EXIT=14, TAG_EXIT_SELF=15, ATTR_EXPR_START=16, ATTR_TEXT=17, 
		ATTR_QUOTE_END=18, ATTR_EXPR_START_SINGLE=19, ATTR_TEXT_SINGLE=20, ATTR_SINGLE_QUOTE_END=21, 
		J_WS=22, J_IF=23, J_ELSE=24, J_ENDIF=25, J_FOR=26, J_ENDFOR=27, J_IN=28, 
		J_AND=29, J_OR=30, J_NOT=31, J_SET=32, J_TRUE=33, J_FALSE=34, J_BLOCK_CLOSE=35, 
		J_EXPR_CLOSE=36, J_EQ=37, J_NEQ=38, PLUS=39, MINUS=40, MUL=41, DIV=42, 
		J_LBRACK=43, J_RBRACK=44, J_DOT=45, J_LPAREN=46, J_RPAREN=47, J_GT=48, 
		J_LT=49, J_GTE=50, J_LTE=51, J_STRING=52, J_INT=53, J_ID=54, J_ASSIGN=55;
	public static final int
		RULE_template = 0, RULE_content = 1, RULE_htmlElement = 2, RULE_attribute = 3, 
		RULE_attributeValue = 4, RULE_attributePart = 5, RULE_singleAttributePart = 6, 
		RULE_jinjaElement = 7, RULE_jinjaPrint = 8, RULE_jinjaIf = 9, RULE_jinjaFor = 10, 
		RULE_jinjaSet = 11, RULE_expression = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"template", "content", "htmlElement", "attribute", "attributeValue", 
			"attributePart", "singleAttributePart", "jinjaElement", "jinjaPrint", 
			"jinjaIf", "jinjaFor", "jinjaSet", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'</'", "'{%'", null, null, null, null, null, 
			null, null, null, null, "'/>'", null, null, null, null, null, null, null, 
			"'if'", "'else'", "'endif'", "'for'", "'endfor'", "'in'", "'and'", "'or'", 
			"'not'", "'set'", null, null, "'%}'", "'}}'", "'=='", "'!='", "'+'", 
			"'-'", "'*'", "'/'", "'['", "']'", "'.'", "'('", "')'", null, null, "'>='", 
			"'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOCTYPE", "COMMENT", "TAG_OPEN", "TAG_CLOSE_TAG", "J_BLOCK_START", 
			"J_EXPR_START", "TEXT", "TAG_WS", "TAG_EQUALS", "DOUBLE_QUOTE", "SINGLE_QUOTE", 
			"VOID_TAG_ID", "TAG_ID", "TAG_EXIT", "TAG_EXIT_SELF", "ATTR_EXPR_START", 
			"ATTR_TEXT", "ATTR_QUOTE_END", "ATTR_EXPR_START_SINGLE", "ATTR_TEXT_SINGLE", 
			"ATTR_SINGLE_QUOTE_END", "J_WS", "J_IF", "J_ELSE", "J_ENDIF", "J_FOR", 
			"J_ENDFOR", "J_IN", "J_AND", "J_OR", "J_NOT", "J_SET", "J_TRUE", "J_FALSE", 
			"J_BLOCK_CLOSE", "J_EXPR_CLOSE", "J_EQ", "J_NEQ", "PLUS", "MINUS", "MUL", 
			"DIV", "J_LBRACK", "J_RBRACK", "J_DOT", "J_LPAREN", "J_RPAREN", "J_GT", 
			"J_LT", "J_GTE", "J_LTE", "J_STRING", "J_INT", "J_ID", "J_ASSIGN"
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
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 232L) != 0)) {
				{
				{
				setState(26);
				content();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
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
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_OPEN:
				_localctx = new HtmlContentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				htmlElement();
				}
				break;
			case J_BLOCK_START:
			case J_EXPR_START:
				_localctx = new JinjaContentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				jinjaElement();
				}
				break;
			case TEXT:
				_localctx = new TextContentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
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
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new NormalTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(TAG_OPEN);
				setState(40);
				match(TAG_ID);
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID_TAG_ID || _la==TAG_ID) {
					{
					{
					setState(41);
					attribute();
					}
					}
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(47);
				match(TAG_EXIT);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 232L) != 0)) {
					{
					{
					setState(48);
					content();
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54);
				match(TAG_CLOSE_TAG);
				setState(55);
				match(TAG_ID);
				setState(56);
				match(TAG_EXIT);
				}
				break;
			case 2:
				_localctx = new VoidElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(TAG_OPEN);
				setState(58);
				match(VOID_TAG_ID);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID_TAG_ID || _la==TAG_ID) {
					{
					{
					setState(59);
					attribute();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				match(TAG_EXIT);
				}
				break;
			case 3:
				_localctx = new SelfClosingTagContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(TAG_OPEN);
				setState(67);
				_la = _input.LA(1);
				if ( !(_la==VOID_TAG_ID || _la==TAG_ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID_TAG_ID || _la==TAG_ID) {
					{
					{
					setState(68);
					attribute();
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(74);
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
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
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
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new KeyValueAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				_la = _input.LA(1);
				if ( !(_la==VOID_TAG_ID || _la==TAG_ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(78);
				match(TAG_EQUALS);
				setState(79);
				attributeValue();
				}
				break;
			case 2:
				_localctx = new OnlyKeyAttributeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
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
	public static class AttributeValueContext extends ParserRuleContext {
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
	 
		public AttributeValueContext() { }
		public void copyFrom(AttributeValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleQuotedAttributeContext extends AttributeValueContext {
		public TerminalNode DOUBLE_QUOTE() { return getToken(TemplatesParser.DOUBLE_QUOTE, 0); }
		public TerminalNode ATTR_QUOTE_END() { return getToken(TemplatesParser.ATTR_QUOTE_END, 0); }
		public List<AttributePartContext> attributePart() {
			return getRuleContexts(AttributePartContext.class);
		}
		public AttributePartContext attributePart(int i) {
			return getRuleContext(AttributePartContext.class,i);
		}
		public DoubleQuotedAttributeContext(AttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterDoubleQuotedAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitDoubleQuotedAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitDoubleQuotedAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleQuotedAttributeContext extends AttributeValueContext {
		public TerminalNode SINGLE_QUOTE() { return getToken(TemplatesParser.SINGLE_QUOTE, 0); }
		public TerminalNode ATTR_SINGLE_QUOTE_END() { return getToken(TemplatesParser.ATTR_SINGLE_QUOTE_END, 0); }
		public List<SingleAttributePartContext> singleAttributePart() {
			return getRuleContexts(SingleAttributePartContext.class);
		}
		public SingleAttributePartContext singleAttributePart(int i) {
			return getRuleContext(SingleAttributePartContext.class,i);
		}
		public SingleQuotedAttributeContext(AttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterSingleQuotedAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitSingleQuotedAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitSingleQuotedAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attributeValue);
		int _la;
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTE:
				_localctx = new DoubleQuotedAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(DOUBLE_QUOTE);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_EXPR_START || _la==ATTR_TEXT) {
					{
					{
					setState(84);
					attributePart();
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(90);
				match(ATTR_QUOTE_END);
				}
				break;
			case SINGLE_QUOTE:
				_localctx = new SingleQuotedAttributeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(SINGLE_QUOTE);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_EXPR_START_SINGLE || _la==ATTR_TEXT_SINGLE) {
					{
					{
					setState(92);
					singleAttributePart();
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
				match(ATTR_SINGLE_QUOTE_END);
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
	public static class AttributePartContext extends ParserRuleContext {
		public AttributePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributePart; }
	 
		public AttributePartContext() { }
		public void copyFrom(AttributePartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeExpressionPartContext extends AttributePartContext {
		public TerminalNode ATTR_EXPR_START() { return getToken(TemplatesParser.ATTR_EXPR_START, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode J_EXPR_CLOSE() { return getToken(TemplatesParser.J_EXPR_CLOSE, 0); }
		public AttributeExpressionPartContext(AttributePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterAttributeExpressionPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitAttributeExpressionPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitAttributeExpressionPart(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeTextPartContext extends AttributePartContext {
		public TerminalNode ATTR_TEXT() { return getToken(TemplatesParser.ATTR_TEXT, 0); }
		public AttributeTextPartContext(AttributePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterAttributeTextPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitAttributeTextPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitAttributeTextPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributePartContext attributePart() throws RecognitionException {
		AttributePartContext _localctx = new AttributePartContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attributePart);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTR_TEXT:
				_localctx = new AttributeTextPartContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(ATTR_TEXT);
				}
				break;
			case ATTR_EXPR_START:
				_localctx = new AttributeExpressionPartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(ATTR_EXPR_START);
				setState(103);
				expression(0);
				setState(104);
				match(J_EXPR_CLOSE);
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
	public static class SingleAttributePartContext extends ParserRuleContext {
		public SingleAttributePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleAttributePart; }
	 
		public SingleAttributePartContext() { }
		public void copyFrom(SingleAttributePartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleAttributeTextPartContext extends SingleAttributePartContext {
		public TerminalNode ATTR_TEXT_SINGLE() { return getToken(TemplatesParser.ATTR_TEXT_SINGLE, 0); }
		public SingleAttributeTextPartContext(SingleAttributePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterSingleAttributeTextPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitSingleAttributeTextPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitSingleAttributeTextPart(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleAttributeExpressionPartContext extends SingleAttributePartContext {
		public TerminalNode ATTR_EXPR_START_SINGLE() { return getToken(TemplatesParser.ATTR_EXPR_START_SINGLE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode J_EXPR_CLOSE() { return getToken(TemplatesParser.J_EXPR_CLOSE, 0); }
		public SingleAttributeExpressionPartContext(SingleAttributePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).enterSingleAttributeExpressionPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplatesParserListener ) ((TemplatesParserListener)listener).exitSingleAttributeExpressionPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplatesParserVisitor ) return ((TemplatesParserVisitor<? extends T>)visitor).visitSingleAttributeExpressionPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleAttributePartContext singleAttributePart() throws RecognitionException {
		SingleAttributePartContext _localctx = new SingleAttributePartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_singleAttributePart);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTR_TEXT_SINGLE:
				_localctx = new SingleAttributeTextPartContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(ATTR_TEXT_SINGLE);
				}
				break;
			case ATTR_EXPR_START_SINGLE:
				_localctx = new SingleAttributeExpressionPartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(ATTR_EXPR_START_SINGLE);
				setState(110);
				expression(0);
				setState(111);
				match(J_EXPR_CLOSE);
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
		enterRule(_localctx, 14, RULE_jinjaElement);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				jinjaPrint();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				jinjaIf();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				jinjaFor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
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
		enterRule(_localctx, 16, RULE_jinjaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(J_EXPR_START);
			setState(122);
			expression(0);
			setState(123);
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
		enterRule(_localctx, 18, RULE_jinjaIf);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(J_BLOCK_START);
			setState(126);
			match(J_IF);
			setState(127);
			expression(0);
			setState(128);
			match(J_BLOCK_CLOSE);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(129);
					((JinjaIfContext)_localctx).content = content();
					((JinjaIfContext)_localctx).thenBlock.add(((JinjaIfContext)_localctx).content);
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(135);
				match(J_BLOCK_START);
				setState(136);
				match(J_ELSE);
				setState(137);
				match(J_BLOCK_CLOSE);
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(138);
						((JinjaIfContext)_localctx).content = content();
						((JinjaIfContext)_localctx).elseBlock.add(((JinjaIfContext)_localctx).content);
						}
						} 
					}
					setState(143);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				}
				break;
			}
			setState(146);
			match(J_BLOCK_START);
			setState(147);
			match(J_ENDIF);
			setState(148);
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
		enterRule(_localctx, 20, RULE_jinjaFor);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(J_BLOCK_START);
			setState(151);
			match(J_FOR);
			setState(152);
			match(J_ID);
			setState(153);
			match(J_IN);
			setState(154);
			match(J_ID);
			setState(155);
			match(J_BLOCK_CLOSE);
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(156);
					content();
					}
					} 
				}
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(162);
			match(J_BLOCK_START);
			setState(163);
			match(J_ENDFOR);
			setState(164);
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
		enterRule(_localctx, 22, RULE_jinjaSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(J_BLOCK_START);
			setState(167);
			match(J_SET);
			setState(168);
			match(J_ID);
			setState(169);
			match(J_ASSIGN);
			setState(170);
			expression(0);
			setState(171);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case J_LPAREN:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(174);
				match(J_LPAREN);
				setState(175);
				expression(0);
				setState(176);
				match(J_RPAREN);
				}
				break;
			case J_NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(J_NOT);
				setState(179);
				expression(7);
				}
				break;
			case J_ID:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(J_ID);
				}
				break;
			case J_STRING:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(J_STRING);
				}
				break;
			case J_INT:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(J_INT);
				}
				break;
			case J_TRUE:
			case J_FALSE:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
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
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(205);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new MathExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(187);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(188);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new MathExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(190);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(193);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4222536967520256L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new LogicalExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(196);
						_la = _input.LA(1);
						if ( !(_la==J_AND || _la==J_OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(197);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new MemberAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(199);
						match(J_DOT);
						setState(200);
						match(J_ID);
						}
						break;
					case 6:
						{
						_localctx = new DictAccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(202);
						match(J_LBRACK);
						setState(203);
						match(J_STRING);
						setState(204);
						match(J_RBRACK);
						}
						break;
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		case 12:
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
		"\u0004\u00017\u00d3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000\u001f"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001&\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002+\b\u0002"+
		"\n\u0002\f\u0002.\t\u0002\u0001\u0002\u0001\u0002\u0005\u00022\b\u0002"+
		"\n\u0002\f\u00025\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002=\b\u0002\n\u0002\f\u0002@\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002F\b\u0002"+
		"\n\u0002\f\u0002I\t\u0002\u0001\u0002\u0003\u0002L\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003R\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0005\u0004V\b\u0004\n\u0004\f\u0004Y\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004^\b\u0004\n\u0004\f\u0004a\t\u0004"+
		"\u0001\u0004\u0003\u0004d\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005k\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006r\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007x\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0083"+
		"\b\t\n\t\f\t\u0086\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u008c\b"+
		"\t\n\t\f\t\u008f\t\t\u0003\t\u0091\b\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u009e"+
		"\b\n\n\n\f\n\u00a1\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u00b9\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00ce\b\f\n\f\f\f\u00d1\t\f"+
		"\u0001\f\u0000\u0001\u0018\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u0000\u0006\u0001\u0000\f\r\u0001\u0000!\"\u0001"+
		"\u0000)*\u0001\u0000\'(\u0002\u0000%&03\u0001\u0000\u001d\u001e\u00e6"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0002%\u0001\u0000\u0000\u0000\u0004"+
		"K\u0001\u0000\u0000\u0000\u0006Q\u0001\u0000\u0000\u0000\bc\u0001\u0000"+
		"\u0000\u0000\nj\u0001\u0000\u0000\u0000\fq\u0001\u0000\u0000\u0000\u000e"+
		"w\u0001\u0000\u0000\u0000\u0010y\u0001\u0000\u0000\u0000\u0012}\u0001"+
		"\u0000\u0000\u0000\u0014\u0096\u0001\u0000\u0000\u0000\u0016\u00a6\u0001"+
		"\u0000\u0000\u0000\u0018\u00b8\u0001\u0000\u0000\u0000\u001a\u001c\u0003"+
		"\u0002\u0001\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001f\u0001"+
		"\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001"+
		"\u0000\u0000\u0000\u001e \u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000"+
		"\u0000\u0000 !\u0005\u0000\u0000\u0001!\u0001\u0001\u0000\u0000\u0000"+
		"\"&\u0003\u0004\u0002\u0000#&\u0003\u000e\u0007\u0000$&\u0005\u0007\u0000"+
		"\u0000%\"\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%$\u0001\u0000"+
		"\u0000\u0000&\u0003\u0001\u0000\u0000\u0000\'(\u0005\u0003\u0000\u0000"+
		"(,\u0005\r\u0000\u0000)+\u0003\u0006\u0003\u0000*)\u0001\u0000\u0000\u0000"+
		"+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000"+
		"\u0000-/\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/3\u0005\u000e"+
		"\u0000\u000002\u0003\u0002\u0001\u000010\u0001\u0000\u0000\u000025\u0001"+
		"\u0000\u0000\u000031\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u0000"+
		"46\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000067\u0005\u0004\u0000"+
		"\u000078\u0005\r\u0000\u00008L\u0005\u000e\u0000\u00009:\u0005\u0003\u0000"+
		"\u0000:>\u0005\f\u0000\u0000;=\u0003\u0006\u0003\u0000<;\u0001\u0000\u0000"+
		"\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?A\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AL\u0005"+
		"\u000e\u0000\u0000BC\u0005\u0003\u0000\u0000CG\u0007\u0000\u0000\u0000"+
		"DF\u0003\u0006\u0003\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000JL\u0005\u000f\u0000\u0000K\'\u0001"+
		"\u0000\u0000\u0000K9\u0001\u0000\u0000\u0000KB\u0001\u0000\u0000\u0000"+
		"L\u0005\u0001\u0000\u0000\u0000MN\u0007\u0000\u0000\u0000NO\u0005\t\u0000"+
		"\u0000OR\u0003\b\u0004\u0000PR\u0007\u0000\u0000\u0000QM\u0001\u0000\u0000"+
		"\u0000QP\u0001\u0000\u0000\u0000R\u0007\u0001\u0000\u0000\u0000SW\u0005"+
		"\n\u0000\u0000TV\u0003\n\u0005\u0000UT\u0001\u0000\u0000\u0000VY\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Zd\u0005\u0012\u0000"+
		"\u0000[_\u0005\u000b\u0000\u0000\\^\u0003\f\u0006\u0000]\\\u0001\u0000"+
		"\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000"+
		"bd\u0005\u0015\u0000\u0000cS\u0001\u0000\u0000\u0000c[\u0001\u0000\u0000"+
		"\u0000d\t\u0001\u0000\u0000\u0000ek\u0005\u0011\u0000\u0000fg\u0005\u0010"+
		"\u0000\u0000gh\u0003\u0018\f\u0000hi\u0005$\u0000\u0000ik\u0001\u0000"+
		"\u0000\u0000je\u0001\u0000\u0000\u0000jf\u0001\u0000\u0000\u0000k\u000b"+
		"\u0001\u0000\u0000\u0000lr\u0005\u0014\u0000\u0000mn\u0005\u0013\u0000"+
		"\u0000no\u0003\u0018\f\u0000op\u0005$\u0000\u0000pr\u0001\u0000\u0000"+
		"\u0000ql\u0001\u0000\u0000\u0000qm\u0001\u0000\u0000\u0000r\r\u0001\u0000"+
		"\u0000\u0000sx\u0003\u0010\b\u0000tx\u0003\u0012\t\u0000ux\u0003\u0014"+
		"\n\u0000vx\u0003\u0016\u000b\u0000ws\u0001\u0000\u0000\u0000wt\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000x\u000f"+
		"\u0001\u0000\u0000\u0000yz\u0005\u0006\u0000\u0000z{\u0003\u0018\f\u0000"+
		"{|\u0005$\u0000\u0000|\u0011\u0001\u0000\u0000\u0000}~\u0005\u0005\u0000"+
		"\u0000~\u007f\u0005\u0017\u0000\u0000\u007f\u0080\u0003\u0018\f\u0000"+
		"\u0080\u0084\u0005#\u0000\u0000\u0081\u0083\u0003\u0002\u0001\u0000\u0082"+
		"\u0081\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0090\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005\u0005\u0000\u0000\u0088\u0089\u0005\u0018\u0000\u0000\u0089"+
		"\u008d\u0005#\u0000\u0000\u008a\u008c\u0003\u0002\u0001\u0000\u008b\u008a"+
		"\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0091"+
		"\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0087"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u0005\u0000\u0000\u0093\u0094"+
		"\u0005\u0019\u0000\u0000\u0094\u0095\u0005#\u0000\u0000\u0095\u0013\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0005\u0005\u0000\u0000\u0097\u0098\u0005"+
		"\u001a\u0000\u0000\u0098\u0099\u00056\u0000\u0000\u0099\u009a\u0005\u001c"+
		"\u0000\u0000\u009a\u009b\u00056\u0000\u0000\u009b\u009f\u0005#\u0000\u0000"+
		"\u009c\u009e\u0003\u0002\u0001\u0000\u009d\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u0005\u0000\u0000"+
		"\u00a3\u00a4\u0005\u001b\u0000\u0000\u00a4\u00a5\u0005#\u0000\u0000\u00a5"+
		"\u0015\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0005\u0000\u0000\u00a7"+
		"\u00a8\u0005 \u0000\u0000\u00a8\u00a9\u00056\u0000\u0000\u00a9\u00aa\u0005"+
		"7\u0000\u0000\u00aa\u00ab\u0003\u0018\f\u0000\u00ab\u00ac\u0005#\u0000"+
		"\u0000\u00ac\u0017\u0001\u0000\u0000\u0000\u00ad\u00ae\u0006\f\uffff\uffff"+
		"\u0000\u00ae\u00af\u0005.\u0000\u0000\u00af\u00b0\u0003\u0018\f\u0000"+
		"\u00b0\u00b1\u0005/\u0000\u0000\u00b1\u00b9\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0005\u001f\u0000\u0000\u00b3\u00b9\u0003\u0018\f\u0007\u00b4\u00b9"+
		"\u00056\u0000\u0000\u00b5\u00b9\u00054\u0000\u0000\u00b6\u00b9\u00055"+
		"\u0000\u0000\u00b7\u00b9\u0007\u0001\u0000\u0000\u00b8\u00ad\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b2\u0001\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b5\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u00cf\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\n\t\u0000\u0000\u00bb\u00bc\u0007\u0002\u0000"+
		"\u0000\u00bc\u00ce\u0003\u0018\f\n\u00bd\u00be\n\b\u0000\u0000\u00be\u00bf"+
		"\u0007\u0003\u0000\u0000\u00bf\u00ce\u0003\u0018\f\t\u00c0\u00c1\n\u0006"+
		"\u0000\u0000\u00c1\u00c2\u0007\u0004\u0000\u0000\u00c2\u00ce\u0003\u0018"+
		"\f\u0007\u00c3\u00c4\n\u0005\u0000\u0000\u00c4\u00c5\u0007\u0005\u0000"+
		"\u0000\u00c5\u00ce\u0003\u0018\f\u0006\u00c6\u00c7\n\u000b\u0000\u0000"+
		"\u00c7\u00c8\u0005-\u0000\u0000\u00c8\u00ce\u00056\u0000\u0000\u00c9\u00ca"+
		"\n\n\u0000\u0000\u00ca\u00cb\u0005+\u0000\u0000\u00cb\u00cc\u00054\u0000"+
		"\u0000\u00cc\u00ce\u0005,\u0000\u0000\u00cd\u00ba\u0001\u0000\u0000\u0000"+
		"\u00cd\u00bd\u0001\u0000\u0000\u0000\u00cd\u00c0\u0001\u0000\u0000\u0000"+
		"\u00cd\u00c3\u0001\u0000\u0000\u0000\u00cd\u00c6\u0001\u0000\u0000\u0000"+
		"\u00cd\u00c9\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d0\u0019\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000"+
		"\u0015\u001d%,3>GKQW_cjqw\u0084\u008d\u0090\u009f\u00b8\u00cd\u00cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}