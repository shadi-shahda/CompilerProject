parser grammar TemplatesParser;

options {
	tokenVocab = TemplatesLexer;
}

template: content* EOF;

content:
	htmlElement		# HtmlContent
	| jinjaElement	# JinjaContent
	| TEXT			# TextContent;

// --- HTML ---
htmlElement:
	TAG_OPEN TAG_ID attribute* TAG_EXIT content* TAG_CLOSE_TAG TAG_ID TAG_EXIT	# NormalTag
	| TAG_OPEN VOID_TAG_ID attribute* TAG_EXIT									# VoidElement
	| TAG_OPEN (TAG_ID | VOID_TAG_ID) attribute* TAG_EXIT_SELF					# SelfClosingTag;

attribute: (TAG_ID | VOID_TAG_ID) TAG_EQUALS TAG_STRING	# keyValueAttribute
	| (TAG_ID | VOID_TAG_ID)							# onlyKeyAttribute;

jinjaElement: jinjaPrint | jinjaIf | jinjaFor;

jinjaPrint: J_EXPR_START expression J_EXPR_CLOSE;

jinjaIf:
	J_BLOCK_START J_IF expression J_BLOCK_CLOSE thenBlock += content* (
		J_BLOCK_START J_ELSE J_BLOCK_CLOSE elseBlock += content*
	)? J_BLOCK_START J_ENDIF J_BLOCK_CLOSE;

jinjaFor:
	J_BLOCK_START J_FOR J_ID J_IN J_ID J_BLOCK_CLOSE content* J_BLOCK_START J_ENDFOR J_BLOCK_CLOSE;

expression:
	J_LPAREN expression J_RPAREN											# ParenExpr
	| expression J_DOT J_ID													# MemberAccessExpr
	| expression J_LBRACK J_STRING J_RBRACK									# DictAccessExpr
	| J_NOT expression														# NotExpr
	| expression (J_EQ | J_NEQ | J_GT | J_LT | J_GTE | J_LTE) expression	# BinaryExpr
	| expression (J_AND | J_OR) expression									# LogicalExpr
	| J_ID																	# VarExpr
	| J_STRING																# StringExpr
	| J_INT																	# IntExpr
	| (J_TRUE | J_FALSE)													# BoolExpr;