lexer grammar Jinja2HtmlCssLexer;

WS: [ \r\t\n] ->skip;

COMMENT: '#' ~('\n' | '\r')* -> skip;

HTML_TAG: '<html>';
