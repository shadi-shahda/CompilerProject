lexer grammar Jinja2HtmlCssLexer;

// --- 1. DEFAULT MODE ---
DOCTYPE : '<!DOCTYPE' .*? '>' -> skip;
HTML_COMMENT : '<!--' .*? '-->' -> skip;

JINJA_VAR_OPEN   : '{{' -> pushMode(JINJA_MODE);
JINJA_BLOCK_OPEN : '{%' -> pushMode(JINJA_MODE);

TAG_OPEN       : '<'  -> pushMode(TAG_MODE);
TAG_CLOSE_OPEN : '</' -> pushMode(TAG_MODE);

HTML_TEXT : ~[<{]+;

// --- 2. TAG MODE ---
mode TAG_MODE;

TAG_CLOSE   : '>' -> popMode;
SLASH_CLOSE : '/>' -> popMode;

// Improved Style Trigger: Matches style=" or style = "
STYLE_ATTR : 'style' [ \t]* '=' [ \t]* '"' -> pushMode(CSS_MODE);

EQUALS : '=';
STRING : '"' .*? '"' | '\'' .*? '\''; 
TAG_ID : [a-zA-Z0-9:-]+; 
WS_TAG : [ \t\r\n]+ -> skip;

// --- 3. CSS MODE ---
mode CSS_MODE;

CSS_END   : '"' -> popMode;
CSS_PROP  : [a-zA-Z-]+;
CSS_COLON : ':';
CSS_SEMI  : ';';
CSS_VAL   : ~[;"]+;
WS_CSS    : [ \t\r\n]+ -> skip;

// --- 4. JINJA MODE ---
mode JINJA_MODE;

JINJA_VAR_CLOSE   : '}}' -> popMode;
JINJA_BLOCK_CLOSE : '%}' -> popMode;

IF     : 'if';
ELSE   : 'else';
ENDIF  : 'endif';
FOR    : 'for';
ENDFOR : 'endfor';
IN     : 'in';

J_ID     : [a-zA-Z_][a-zA-Z0-9_]*;
WS_JINJA : [ \t\r\n]+ -> skip;