parser grammar FlaskPythonParser;

options {
	tokenVocab = FlaskPythonLexer;
}

program: (NEWLINE | line)* EOF;

line:
	importStmt NEWLINE	# importStatement
	| functionDecl		# functionDeclarationStatement
	| statement			# regularStatement;

importStmt: FROM ID IMPORT importList;

importList: importItem (COMMA importItem)*;

importItem:
	ID
	| FLASK_CLASS
	| RENDER_TEMPLATE
	| REDIRECT
	| URL_FOR;

functionDecl:
	(routeDecorator NEWLINE)? DEF ID LPAREN paramList? RPAREN COLON block;

routeDecorator:
	AT ID DOT ROUTE LPAREN STRING (COMMA methodsParam)? RPAREN;

methodsParam:
	METHODS ASSIGN LBRACKET (STRING (COMMA STRING)*)? RBRACKET;

paramList: ID (COMMA ID)*;

block: NEWLINE INDENT statement+ DEDENT;

statement:
	simpleStmt NEWLINE	# simpleStatement
	| ifStmt			# ifStatement
	| forStmt			# forStatement;

simpleStmt:
	returnStmt
	| assignment
	| globalStmt
	| expressionStmt
	| printStmt
	| breakStmt
	| continueStmt;

printStmt: PRINT LPAREN expression RPAREN;

breakStmt: BREAK;

continueStmt: CONTINUE;

ifStmt: IF condition COLON block (ELSE COLON block)?;

condition: expression;
//	expression (EQUALS | NOT_EQUALS) expression	# CompareCond
//	| ID										# VarCond
//	| BOOLEAN									# BoolCond;

forStmt: FOR ID IN expression COLON block;

returnStmt: RETURN expression;

assignment: ID ASSIGN expression;

globalStmt: GLOBAL ID (COMMA ID)*;

expressionStmt: expression;

expression:
	expression DOT ID LPAREN argList? RPAREN		# MethodCallExpr
	| expression LBRACKET expression RBRACKET		# ListAccessExpr
	| expression DOT ID								# MemberAccessExpr
	| ID LPAREN argList? RPAREN						# FunctionCallExpr
	| flaskFunc LPAREN argList? RPAREN				# FlaskCallExpr
	| expression (MUL | DIV) expression				# MathExpr
	| expression (PLUS | MINUS) expression			# MathExpr
	| expression (EQUALS | NOT_EQUALS) expression	# ComparisonExpr
	| list											# ListExpr
	| dictionary									# DictExpr
	| ID											# IdExpr
	| INT											# IntExpr
	| BOOLEAN										# boolExpr
	| STRING										# StringExpr;

flaskFunc: RENDER_TEMPLATE | REDIRECT | URL_FOR | FLASK_CLASS;

argList: argument (COMMA argument)*;

argument:
	value = expression
	| keyword = ID ASSIGN value = expression;

list: LBRACKET (elements | listComp)? RBRACKET;

elements: expression (COMMA expression)*;

listComp: expression FOR ID IN expression (IF expression)?;

dictionary: LBRACE dictEntry (COMMA dictEntry)* RBRACE;

dictEntry: expression COLON expression;