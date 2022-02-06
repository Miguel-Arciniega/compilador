/* JFlex example: partial Java language lexer specification */

package com.deimos.compilador.services.paint;

import com.deimos.compilador.model.painter.PaintRequest;
import com.deimos.compilador.utils.EditorColors;
import java.awt.Color;
import java.util.List;

%%
%class LexerPainter
%type Tokens
%unicode
%full
%line
%char
%column

%{
  private void addPaintRequest(int posIni, int posFin, Color color){
    List<PaintRequest> paintRequests = PaintService.paintRequestList.getPaintRequests();
    PaintRequest paintRequest = new PaintRequest(posIni, posFin, color);
    paintRequests.add(paintRequest);
  }
%}

/* --------------------- RegEx --------------------- */

Letter = [a-zA-Z_]
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

// --- Constant

Constant = [A-Z][A-Z_]+

// --- Number

Number = 0 | [1-9]{Digit}*

// --- Pin

Pin = [A-Z]{Digit}

/* ------------------ Tokens/Patterns ------------------- */

%%

// --- Methods

"init"                         
| "iterate"                    { addPaintRequest(yychar, yylength(), EditorColors.METHODS); }

// --- Functions

"start"            
| "wait"            
| "aRead"
| "dRead"                 
| "print"
| "mode"
| "dWrite"   
| "aWrite"                      { addPaintRequest(yychar, yylength(), EditorColors.FUNCTIONS); }    

// --- Number

{Pin}
| "OUTPUT"
| "HIGH"
| "LOW"
| {Number}                     { addPaintRequest(yychar, yylength(), EditorColors.NUMBERS); }      

// --- Keywords

"program"              
| "if"                
| "else"               
| "for"                
| "while"              
| "abstract"           
| "boolean"            
| "break"              
| "int"                
| "string"             
| "float"                      { addPaintRequest(yychar, yylength(), EditorColors.KEYWORDS); }

// --- String

\"                             
| (\"[^\"\n]*\")               { addPaintRequest(yychar, yylength(), EditorColors.STRING); }

// --- Semicolon

";"                            { addPaintRequest(yychar, yylength(), EditorColors.SEMICOLON); }

// --- Defualt

  "{"                           
  | "}"                            
  | "("                     
  | ")"                           
  | "+"                            
  | "-"                             
  | "*"                             
  | "/"                             
  | "%"                             
  | "++"                            
  | "--"                            
  | "="                             
  | "+="                            
  | "-="                            
  | "*="                            
  | "/="                            
  | "%="                           
  | "=="                            
  | "!="                           
  | ">"                             
  | "<"                         
  | ">="                            
  | "<="                            
  | "&& "                          
  | "||"
  | ","                       
  | {Identifier}               { addPaintRequest(yychar, yylength(), EditorColors.DEFAULT); }

// --- Comments

{Comment}                      { addPaintRequest(yychar, yylength(), EditorColors.COMMENTS); }
{WhiteSpace}                   { /* ignore */ }

// --- Errors

[0]{Digit}+
| [^]                           { addPaintRequest(yychar, yylength(), EditorColors.ERROR); }
