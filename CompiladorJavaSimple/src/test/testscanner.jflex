package test;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

%%

%public			// Per indicar que la classe és pública
%class Scanner	// El nom de la classe

%unicode
%line
%column
%cup

%{
    public ComplexSymbol symbol(int type){
		return new ComplexSymbol(sym.terminalNames[type], type);
    }
    public ComplexSymbol symbol(int type, String lexem){
		return new ComplexSymbol(sym.terminalNames[type], type, lexem);
    }
%}

/* definiciones regulares */

FINLINEA	= \r|\n|\r\n
ESPACIO		= {FINLINEA} | [ \t\f]

tClass		=	"class"
tipoVar		=	"int"|"boolean"|"String"

llaveIzq	=	"{"
llaveDer	=	"}"

igual		=	"="
puntocoma	=	";"
numero		=	(0|[1-9][0-9]*)

id			=	[A-Za-z][A-Za-z0-9_]*

%%

{ESPACIO}		{/* nada que hacer */}

{tClass}		{return symbol(sym.tclass, null);}
{tipoVar}		{return symbol(sym.tipoVar, this.yytext());}

{llaveIzq}		{return symbol(sym.llaveIzq, null);}
{llaveDer}		{return symbol(sym.llaveDer, null);}

{igual}			{return symbol(sym.igual, null);}
{puntocoma}		{return symbol(sym.puntocoma, null);}

{numero}		{return symbol(sym.numero, this.yytext());}
{id}			{return new SimboloID(symbol(sym.id, this.yytext()));}

[^]				{throw new Error("Carácter no reconocido: <"+yytext()+">"); }
