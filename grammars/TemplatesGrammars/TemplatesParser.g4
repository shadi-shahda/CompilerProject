parser grammar TemplatesParser;

options {
	tokenVocab = TemplatesLexer;
}

template: content* EOF;

content: htmlElement | jinjaElement | TEXT;

htmlElement:
	TAG_OPEN TAG_ID attribute* TAG_EXIT content* TAG_CLOSE_TAG TAG_ID TAG_END	# NormalTag
	| TAG_OPEN TAG_ID attribute* TAG_EXIT_SELF									# SelfClosingTag;

attribute: TAG_ID TAG_EQUALS TAG_STRING;

jinjaElement: jinjaPrint | jinjaIf | jinjaFor;

jinjaPrint: J_EXPR_OPEN expression J_EXPR_CLOSE;

jinjaIf:
	J_IF expression J_TAG_CLOSE content* (J_ELSE content*)? J_ENDIF;

jinjaFor: J_FOR ID J_IN ID J_TAG_CLOSE content* J_ENDFOR;

expression:
	J_LPAREN expression J_RPAREN				# ParenExpr
	| expression J_DOT ID					# MemberAccessExpr
	| expression J_LBRACK STRING J_RBRACK	# DictAccessExpr
	| expression (J_EQ | J_NEQ) expression	# BinaryExpr
	| ID									# VarExpr
	| STRING								# StringExpr
	| INT									# IntExpr;