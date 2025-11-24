parser grammar FlaskParser;

options {tokenVocab = FlaskLexer ; }

program: statement*;

statement: var_declaration;

var_declaration: IDENTIFIER ASSIGN_OPERATRO INTEGER_LITERAL;