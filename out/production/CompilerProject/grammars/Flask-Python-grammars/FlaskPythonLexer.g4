lexer grammar FlaskPythonLexer;

// --- Keywords ---
FROM    : 'from';
IMPORT  : 'import';
DEF     : 'def';
RETURN  : 'return';
IF      : 'if';
FLASK   : 'Flask';
APP_RUN : 'app.run';
TRUE    : 'True';
FALSE   : 'False';
NONE    : 'None';

// --- Symbols ---
LBRACK  : '[';  // <--- NEW: For lists
RBRACK  : ']';  // <--- NEW
AT      : '@';
ASSIGN  : '=';
LPAREN  : '(';
RPAREN  : ')';
DOT     : '.';
COMMA   : ',';
COLON   : ':';

// --- Literals ---
STRING  : '"' .*? '"' | '\'' .*? '\'';
INT     : [0-9]+;
ID      : [a-zA-Z_] [a-zA-Z0-9_]*;

// --- Whitespace ---
COMMENT : '#' ~[\r\n]* -> skip;
NEWLINE : [\r\n]+;
WS      : [ \t]+ -> skip;