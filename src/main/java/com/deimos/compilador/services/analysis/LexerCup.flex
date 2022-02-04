/* JFlex example: partial Java language lexer specification */

package com.deimos.compilador.services.analysis;
import com.deimos.compilador.services.ErrorHandlerService;
import com.deimos.compilador.model.errors.ErrorType;
import com.deimos.compilador.model.errors.CompilationError;
import java.util.List;

import java_cup.runtime.Symbol;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%unicode
%cup
%full
%line
%char
%column

%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }

    private void addLexicalError(String id, int line, String message, String content){
       List<CompilationError> errors = ErrorHandlerService.compilationErrors.getErrors();
       CompilationError lexicalError = new CompilationError(id, message, content, ErrorType.LEXICAL, line);
       errors.add(lexicalError); 
    }

    private static final String INVALID_CHARACTER_ERROR_CODE = "001";
    private static final String INVALID_NUMBER_ERROR_CODE = "002";
    private static final String UNCLOSED_STRING_ERROR_CODE = "014";

    private static final String UNCLOSED_STRING_MESSAGE = "Unclosed string literal";
    private static final String INVALID_CHARACTER_MESSAGE = "Invalid character";
    private static final String INVALID_NUMBER_MESSAGE = "Invalid number";
%}

/* --------------------- RegEx --------------------- */

Letter = [a-zA-Z]
Digit = [0-9]
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

// --- Comments

Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"

// Comment can be the last line of the file, without line terminator.

EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

// --- Identifier

Identifier = {Letter}+ ({Letter} | {Digit})*

// --- Number

Number = 0 | [1-9]{Digit}*

/* ------------------ Tokens/Patterns ------------------- */

%state STRING

%%

// --- Keywords
<YYINITIAL> "class"              { return symbol(sym.CLASS); }
<YYINITIAL> "init"               { return symbol(sym.INIT); }
<YYINITIAL> "iterate"            { return symbol(sym.ITERATE); }

<YYINITIAL> "if"                 { return symbol(sym.IF); }
<YYINITIAL> "else"               { return symbol(sym.ELSE); }
<YYINITIAL> "for"                { return symbol(sym.FOR); }
<YYINITIAL> "while"              { return symbol(sym.WHILE); }
<YYINITIAL> "abstract"           { return symbol(sym.ABSTRACT); }
<YYINITIAL> "boolean"            { return symbol(sym.BOOLEAN); }
<YYINITIAL> "break"              { return symbol(sym.BREAK); }

<YYINITIAL> "int"                { return symbol(sym.INT); }
<YYINITIAL> "string"             { return symbol(sym.STRING); }
<YYINITIAL> "float"              { return symbol(sym.FLOAT); }
<YYINITIAL> {

  // --- Identifier

  {Identifier}                   { return symbol(sym.IDENTIFIER, yytext()); }

  // --- Number

  {Number}                       { return symbol(sym.INTEGER_LITERAL, new Integer(yytext())); }
  \"                             { string.setLength(0); yybegin(STRING); }

  // --- delimiters

  ";"                            { return symbol(sym.SEMI); }
  "{"                            { return symbol(sym.LBRACKET); }
  "}"                            { return symbol(sym.RBRACKET); }
  "("                            { return symbol(sym.LPAR); }
  ")"                            { return symbol(sym.RPAR); }

  // --- operators

  "+"                             { return symbol(sym.ADDITION); }
  "-"                             { return symbol(sym.SUBTRACTION); }
  "*"                             { return symbol(sym.MULTIPLICATION); }
  "/"                             { return symbol(sym.DIVISION); }
  "%"                             { return symbol(sym.MODULUS); }
  "++"                            { return symbol(sym.INCREMENT); }
  "--"                            { return symbol(sym.DECREMENT); }

  "="                             { return symbol(sym.ASSIGNMENT); }
  "+="                            { return symbol(sym.ASSIGNMENT_ADDITION); }
  "-="                            { return symbol(sym.ASSIGNMENT_SUBTRACTION); }
  "*="                            { return symbol(sym.ASSIGNMENT_MULTIPLICATION); }
  "/="                            { return symbol(sym.ASSIGNMENT_DIVISION); }
  "%="                            { return symbol(sym.ASSIGNMENT_MODULUS); }

  "=="                            { return symbol(sym.EQUAL_TO); }
  "!="                            { return symbol(sym.NOT_EQUAL); }
  ">"                             { return symbol(sym.GREATER_THAN); }
  "<"                             { return symbol(sym.LESS_THAN); }
  ">="                            { return symbol(sym.GREATHER_THAN_OR_EQUAL_TO); }
  "<="                            { return symbol(sym.LESS_THAN_OR_EQUAL_TO); }

  "&& "                           { return symbol(sym.AND); }
  "||"                            { return symbol(sym.OR); }

  // --- comments

  {Comment}                      { /* ignore */ }

  // --- whitespace

  {WhiteSpace}                   { /* ignore */ }
}

// --- String

<STRING> {
  \"                             { yybegin(YYINITIAL);
                                   return symbol(sym.STRING_LITERAL,
                                   string.toString()); }
  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}

/* ------------------ Errors ------------------- */

// --- Invalid Number

[0]{Digit}+                                     { addLexicalError(INVALID_NUMBER_ERROR_CODE, yyline+1, INVALID_NUMBER_MESSAGE, yytext()); return symbol(sym.INVALID_NUMBER); }
[\n][^\"\n]*[\"][^\"\n]*[\n]                    { addLexicalError(INVALID_CHARACTER_ERROR_CODE, yyline+1, UNCLOSED_STRING_MESSAGE, yytext()); return symbol(sym.ERROR); }

// --- Invalid Character

[^]                                             { addLexicalError(INVALID_CHARACTER_ERROR_CODE, yyline+1, INVALID_CHARACTER_MESSAGE, yytext()); return symbol(sym.ERROR); }


// modificar el reges de string unclosed