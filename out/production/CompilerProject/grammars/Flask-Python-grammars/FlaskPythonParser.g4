parser grammar FlaskPythonParser;

options { tokenVocab=FlaskPythonLexer; }

program : statement* EOF;

statement
    : importStmt        # ImportStmtRule
    | flaskAppInit      # AppInitStmt
    | flaskRoute        # RouteStmt
    | functionDef       # FuncStmt
    | assignment        # AssignStmt
    | appRun            # RunStmt
    | returnStmt        # ReturnStmtRule
    | NEWLINE           # EmptyLine
    ;

importStmt : FROM ID IMPORT (ID | FLASK) NEWLINE;

flaskAppInit : ID ASSIGN FLASK LPAREN ID RPAREN NEWLINE;

flaskRoute : AT ID DOT ID LPAREN STRING RPAREN NEWLINE functionDef;

functionDef : DEF ID LPAREN RPAREN COLON NEWLINE block;

block : (statement | returnStmt)+; 

returnStmt : RETURN expression NEWLINE;

assignment : ID ASSIGN expression NEWLINE;

appRun : APP_RUN LPAREN RPAREN NEWLINE?; 

// --- FIXED EXPRESSION RULE ---
expression
    : expression (COMMA expression)+ # ListExpr // <--- CHANGED * TO +
    | LBRACK expression? RBRACK      # ListDef
    | STRING                         # StringExpr
    | INT                            # IntExpr
    | TRUE                           # BoolExpr
    | FALSE                          # BoolExpr
    | ID                             # IdExpr
    ;