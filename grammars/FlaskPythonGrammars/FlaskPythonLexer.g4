lexer grammar FlaskPythonLexer;

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
GET: 'GET';
POST: 'POST';
PRINT: 'print';

LBRACE: '{';
RBRACE: '}';
LPAREN: '(';
RPAREN: ')';
LBRACKET: '[';
RBRACKET: ']';
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

BLOCK_END: '#' [ \t]+ 'end';

ID: [a-zA-Z_] [a-zA-Z0-9_]*;
INT: [0-9]+;
STRING: '"' .*? '"' | '\'' .*? '\'';
BOOLEAN: 'True' | 'False';

COMMENT: '#' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;