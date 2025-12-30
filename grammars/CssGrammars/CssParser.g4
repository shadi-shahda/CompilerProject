parser grammar CssParser;

options {
	tokenVocab = CssLexer;
}

stylesheet: rule* EOF;

rule: selectors block;

selectors: selector (COMMA selector)*;

selector:
	IDENTIFIER			# TagSelector
	| CLASS_SELECTOR	# ClassSelector
	| HASH				# IdSelector;

block:
	LBRACE (declaration (SEMICOLON declaration)*)? SEMICOLON? RBRACE;

declaration: property COLON value;

function:
	IDENTIFIER LPAREN valueTerm (COMMA? valueTerm)* RPAREN;

property: IDENTIFIER;

value: valueTerm (COMMA? valueTerm)*;

valueTerm:
	IDENTIFIER	# IdentValue
	| INT		# IntValue
	| STRING	# StringVlue
	| PX		# PxValue
	| PERCENT	# PercentValue
	| HASH		# HexValue
	| FLOAT		# FloatValue
	| function	# FunctionValue;