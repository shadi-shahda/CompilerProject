lexer grammar FlaskLexer;

NICE: 'nice';

WS: [ \r\t\n] -> skip;

COMMENT: '#' ~('\n' | '\r')* -> skip;

IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

// Operators and Delimiters
ASSIGN_OPERATRO : '=';
COMMA     : ',';

INTEGER_LITERAL : '-'? NUM;
fragment NUM: '0' | [1-9] DIGIT*;
fragment DIGIT: [0-9];