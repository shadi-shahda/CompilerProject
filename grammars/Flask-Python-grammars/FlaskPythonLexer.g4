lexer grammar FlaskPythonLexer;

WS: [ \t\r\n]+ -> skip;

COMMENT: '#' ~[\r\n]* -> skip;

STRING: '"' [a-zA-Z0-9] '"';
