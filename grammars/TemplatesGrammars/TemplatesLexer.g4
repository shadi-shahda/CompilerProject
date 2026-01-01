lexer grammar TemplatesLexer;

// --- 1. Jinja2 Tokens ---

J_IF: '{%' [ \t]* 'if';
J_TAG_CLOSE: '%}';
J_ELSE: '{%' [ \t]* 'else' [ \t]* '%}';
J_ENDIF: '{%' [ \t]* 'endif' [ \t]* '%}';
J_FOR: '{%' [ \t]* 'for';
J_ENDFOR: '{%' [ \t]* 'endfor' [ \t]* '%}';
J_IN: 'in';
J_OR: 'or';
J_NOT: 'not';
J_TRUE    : 'True' | 'true';
J_FALSE   : 'False' | 'false';

J_EXPR_OPEN: '{{';
J_EXPR_CLOSE: '}}';

J_EQ: '==';
J_NEQ: '!=';
J_LBRACK: '[';
J_RBRACK: ']';
J_LPAREN: '(';
J_RPAREN: ')';
J_DOT: '.';

// --- 2. HTML Tokens ---

TAG_OPEN: '<' -> pushMode(TAG_MODE);
TAG_CLOSE_TAG: '</';
TAG_END: '>';
TAG_SELF_CLOSE: '/>';

// --- 3. Common Tokens ---
STRING: '"' .*? '"' | '\'' .*? '\'';
INT: [0-9]+;
ID: [a-zA-Z_][a-zA-Z0-9_-]*;
TEXT: ~[<{}]+;

// ---(HTML Attributes) ---
mode TAG_MODE;
TAG_EXIT_SELF: '/>' -> popMode;
TAG_WS: [ \t\r\n]+ -> skip;
TAG_EQUALS: '=';
TAG_STRING: '"' .*? '"' | '\'' .*? '\'';
TAG_ID: [a-zA-Z_][a-zA-Z0-9_-]*;
TAG_EXIT: '>' -> popMode;