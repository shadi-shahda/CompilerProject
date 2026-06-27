lexer grammar FlaskPythonLexer;

tokens {
    INDENT,
    DEDENT
}

@members {
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
}

DEF: 'def';
RETURN: 'return';
IF: 'if';
ELSE: 'else';
FOR: 'for';
IN: 'in';
FROM: 'from';
IMPORT: 'import';

FLASK_CLASS: 'Flask';
ROUTE: 'route';
RENDER_TEMPLATE: 'render_template';
REDIRECT: 'redirect';
URL_FOR: 'url_for';
METHODS: 'methods';
PRINT: 'print';
GLOBAL: 'global';
BREAK: 'break';
CONTINUE: 'continue';

LPAREN: '(' {opened++;};
RPAREN: ')' {opened--;};
LBRACE: '{' {opened++;};
RBRACE: '}' {opened--;};
LBRACKET: '[' {opened++;};
RBRACKET: ']' {opened--;};
COLON: ':';
COMMA: ',';
DOT: '.';
AT: '@';
ASSIGN: '=';
EQUALS: '==';
NOT_EQUALS: '!=';
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';

NEWLINE
    : ({atStartOfInput()}? SPACES
      | ('\r'? '\n' | '\r' | '\f') SPACES?)
      {
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
      }
    ;

fragment SPACES: [ \t]+;

BOOLEAN: 'True' | 'False';
ID: [a-zA-Z_] [a-zA-Z0-9_]*;
INT: [0-9]+;
STRING: '"' .*? '"' | '\'' .*? '\'';

COMMENT: '#' ~[\r\n]* -> skip;
WS: [ \t]+ -> skip;