parser grammar FlaskPythonParser;

options {
	tokenVocab = FlaskPythonLexer;
}

// -------------------------------------------------------- 1. نقطة البداية (The Root)
// --------------------------------------------------------
program: line* EOF;

line:
	importStmt // استيراد المكتبات
	| assignment // تعريف متغيرات عامة (مثل app, products)
	| functionDecl // تعريف الدوال
	| statement ; // جمل أخرى

// -------------------------------------------------------- 2. التصريحات الرئيسية (Declarations)
// --------------------------------------------------------

// استيراد: from flask import Flask, render_template
importStmt: FROM (ID | FLASK_LIB) IMPORT importList;

importList: importItem (COMMA importItem)*;

importItem:
	ID
	| FLASK_CLASS
	| RENDER_TEMPLATE
	| REQUEST
	| REDIRECT
	| URL_FOR;

// تعريف دالة مع Decorator اختياري لاحظ استخدام BLOCK_END في نهاية جسم الدالة
functionDecl:
	routeDecorator? DEF ID LPAREN paramList? RPAREN COLON block;

// الـ Decorator: @app.route('/path', methods=['GET'])
routeDecorator:
	AT APP DOT ROUTE LPAREN STRING (COMMA METHODS ASSIGN list)? RPAREN;

paramList: ID (COMMA ID)*;

// -------------------------------------------------------- 3. هيكل الكود والبلوكات (Code Structure)
// --------------------------------------------------------

// البلوك هو مجموعة جمل تنتهي بـ # end
block: statement* BLOCK_END;

statement: ifStmt | returnStmt | assignment | expressionStmt;

// الشرط: if ... : ... # end
ifStmt: IF expression COLON block (ELSE COLON block)?;

returnStmt: RETURN expression;

// إسناد قيمة: x = 5
assignment: ID ASSIGN expression;

// استدعاء دالة كجملة مستقلة (مثل append)
expressionStmt: expression;

// -------------------------------------------------------- 4. التعابير (Expressions)
// --------------------------------------------------------

expression:
	expression LBRACKET expression RBRACKET			# ListAccessExpr // products[0]
	| expression DOT ID								# MemberAccessExpr // product.id
	| ID LPAREN argList? RPAREN						# FunctionCallExpr // my_func()
	| flaskFunc LPAREN argList? RPAREN				# FlaskCallExpr // render_template()
	| expression (EQUALS | NOT_EQUALS) expression	# ComparisonExpr // x == y
	| list											# ListExpr // [1, 2]
	| dictionary									# DictExpr // {'id': 1}
	| ID											# IdExpr // x
	| INT											# IntExpr // 10
	| STRING										# StringExpr ; // "hello"

// الدوال الخاصة بفلاسك (فصلناها لتمييزها في الـ AST)
flaskFunc: RENDER_TEMPLATE | REDIRECT | URL_FOR | FLASK_CLASS;

argList: argument (COMMA argument)*;

// الحجة يمكن أن تكون قيمة عادية (x) أو مسماة (products=products)
argument: expression | ID ASSIGN expression;

// -------------------------------------------------------- 5. هياكل البيانات (Data Structures)
// --------------------------------------------------------

// القائمة: [1, 2] أو List Comprehension للحذف
list: LBRACKET (elements | listComp)? RBRACKET;

elements: expression (COMMA expression)*;

// دعم بسيط لـ List Comprehension المستخدمة في الحذف [p for p in products if ...]
listComp: expression FOR ID IN expression (IF expression)?;

// القاموس: {'key': value}
dictionary: LBRACE dictEntry (COMMA dictEntry)* RBRACE;

dictEntry: STRING COLON expression;