lexer grammar FlaskPythonLexer;

// --- 1. الكلمات المفتاحية (Keywords) ---
DEF: 'def';
RETURN: 'return';
IF: 'if';
ELSE: 'else';
FOR: 'for';
IN: 'in';
FROM: 'from';
IMPORT: 'import';

// --- 2. كلمات فلاسك الخاصة (Flask Specifics) --- تم التعديل بناء على ملاحظتك
FLASK_LIB: 'flask'; // للمكتبة (from flask)
FLASK_CLASS: 'Flask'; // للكلاس (import Flask)
ROUTE: 'route';
RENDER_TEMPLATE: 'render_template';
REDIRECT: 'redirect';
URL_FOR: 'url_for';
GET: 'GET';
POST: 'POST';

// --- 3. الرموز والعمليات ---
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
PLUS      : '+';
MINUS     : '-';
MUL       : '*';
DIV       : '/';

// --- 4. الحل السحري للبلوكات (Block Handling) --- عندما يرى المترجم # end سيعتبرها رمز نهاية بلوك
BLOCK_END : '#' [ \t]+ 'end';

ID: [a-zA-Z_] [a-zA-Z0-9_]*;
INT: [0-9]+;
STRING: '"' .*? '"' | '\'' .*? '\'';

COMMENT: '#' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;