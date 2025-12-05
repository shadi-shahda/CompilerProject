lexer grammar Jinja2HtmlCssLexer;

WS: [ \t\r\n]+ -> skip;

COMMENT: '<!--' .*? '-->' -> channel(HIDDEN);

STRING : '"' [a-zA-Z0-9] '"';
