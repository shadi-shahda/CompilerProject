lexer grammar TemplatesLexer;

DOCTYPE:
	'<!' [dD][oO][cC][tT][yY][pP][eE] .*? '>' -> skip;

TAG_OPEN: '<' -> pushMode(TAG_MODE);
TAG_CLOSE_TAG: '</' -> pushMode(TAG_MODE);

J_BLOCK_START: '{%' -> pushMode(JINJA_MODE);
J_EXPR_START: '{{' -> pushMode(JINJA_MODE);

TEXT: ~[<{}]+;

mode TAG_MODE;
TAG_WS: [ \t\r\n]+ -> skip;
TAG_EQUALS: '=';
TAG_STRING: '"' .*? '"' | '\'' .*? '\'';

VOID_TAG_ID: 'img' | 'br' | 'hr' | 'link' | 'meta' | 'input';

TAG_ID: [a-zA-Z_][a-zA-Z0-9_-]*;

TAG_EXIT: '>' -> popMode;
TAG_EXIT_SELF: '/>' -> popMode;

mode JINJA_MODE;
J_WS: [ \t\r\n]+ -> skip;

J_IF: 'if';
J_ELSE: 'else';
J_ENDIF: 'endif';
J_FOR: 'for';
J_ENDFOR: 'endfor';
J_IN: 'in';
J_AND: 'and';
J_OR: 'or';
J_NOT: 'not';
J_TRUE: 'True' | 'true';
J_FALSE: 'False' | 'false';

J_BLOCK_CLOSE: '%}' -> popMode;
J_EXPR_CLOSE: '}}' -> popMode;

J_EQ: '==';
J_NEQ: '!=';
J_LBRACK: '[';
J_RBRACK: ']';
J_DOT: '.';
J_LPAREN: '(';
J_RPAREN: ')';
J_GT: '>';
J_LT: '<';
J_GTE: '>=';
J_LTE: '<=';

J_STRING: '"' .*? '"' | '\'' .*? '\'';
J_INT: [0-9]+;
J_ID: [a-zA-Z_][a-zA-Z0-9_-]*;