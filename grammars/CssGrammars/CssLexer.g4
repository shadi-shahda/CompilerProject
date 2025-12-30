lexer grammar CssLexer;

LBRACE: '{';
RBRACE: '}';
LPAREN: '(';
RPAREN: ')';
COLON: ':';
SEMICOLON: ';';
COMMA: ',';

PX: [0-9]+ 'px';
PERCENT: [0-9]+ '%';
FLOAT: [0-9]* '.' [0-9]+;
INT: [0-9]+;
STRING: '"' ~["]* '"' | '\'' ~[']* '\'';

HASH: '#' [0-9a-fA-F]+;

CLASS_SELECTOR: '.' [a-zA-Z0-9_-]+;

ID_SELECTOR: '#' [a-zA-Z0-9_-]+;

IDENTIFIER: [a-zA-Z-][a-zA-Z0-9-]*;

COMMENT: '/*' .*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;