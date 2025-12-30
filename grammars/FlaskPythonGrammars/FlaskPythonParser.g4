parser grammar FlaskPythonParser;

options {
	tokenVocab = FlaskPythonLexer;
}

program: line* EOF;

line: importStmt | assignment | functionDecl | statement;

importStmt: FROM ID IMPORT importList;

importList: importItem (COMMA importItem)*;

importItem:
	ID
	| FLASK_CLASS
	| RENDER_TEMPLATE
	| REDIRECT
	| URL_FOR;

functionDecl:
	routeDecorator? DEF ID LPAREN paramList? RPAREN COLON block;

routeDecorator:
	AT ID DOT ROUTE LPAREN STRING (COMMA ID ASSIGN list)? RPAREN;

paramList: ID (COMMA ID)*;

block: statement* BLOCK_END;

statement:
	ifStmt
	| forStmt
	| returnStmt
	| assignment
	| expressionStmt
	| printStmt;

printStmt: PRINT LPAREN expression RPAREN;

ifStmt: IF condition COLON block (ELSE COLON block)?;

condition:
	expression (EQUALS | NOT_EQUALS) expression	# CompareCond
	| ID										# VarCond
	| BOOLEAN									# BoolCond;

forStmt: FOR ID IN ID COLON block;

returnStmt: RETURN expression;

assignment: ID ASSIGN expression;

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
	| expression DOT ID LPAREN argList? RPAREN		# MethodCallExpr
	| expression DOT ID								# MemberAccessExpr
	| ID											# IdExpr
	| INT											# IntExpr
	| BOOLEAN										# boolExpr
	| STRING										# StringExpr;

flaskFunc: RENDER_TEMPLATE | REDIRECT | URL_FOR | FLASK_CLASS;

argList: argument (COMMA argument)*;

argument: expression | ID ASSIGN expression;

list: LBRACKET (elements | listComp)? RBRACKET;

elements: expression (COMMA expression)*;

listComp: expression FOR ID IN expression (IF expression)?;

dictionary: LBRACE dictEntry (COMMA dictEntry)* RBRACE;

dictEntry: STRING COLON expression;