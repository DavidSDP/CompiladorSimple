package analisisLexico;
import analisisSintactico.sym;
import analisisSemantico.simbolos.*;
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
tipoVoid	=	"void"

llaveIzq	=	"{"
llaveDer	=	"}"

igual		=	"="
puntocoma	=	";"
coma		=	","

parenIzq	=	"("
parenDer	=	")"

opSuma		=	"+"|"-"
opProd		=	"*"|"/"

comparador	=	"=="|"!="|">"|"<"|">="|"<="
opLogico	=	"&&"|"||"
booleano	=	"true"|"false"

string		=	[\"][A-Za-z0-9_]*[\"]
numero		=	(0|[1-9][0-9]*)

id			=	[A-Za-z][A-Za-z0-9_]*

%%

{ESPACIO}		{/* nada que hacer */}

{tClass}		{return symbol(sym.tclass, this.yytext());}
{tipoVar}		{return symbol(sym.tipoVar, this.yytext());}
{tipoVoid}		{return symbol(sym.tipoVoid, this.yytext());}

{llaveIzq}		{return symbol(sym.llaveIzq, null);}
{llaveDer}		{return symbol(sym.llaveDer, null);}

{igual}			{return symbol(sym.igual, null);}
{puntocoma}		{return symbol(sym.puntocoma, null);}
{coma}			{return symbol(sym.coma, null);}

{parenIzq}		{return symbol(sym.parenIzq, null);}
{parenDer}		{return symbol(sym.parenDer, null);}

{opSuma}		{return symbol(sym.opSuma, this.yytext());}
{opProd}		{return symbol(sym.opProd, this.yytext());}

{comparador}	{return symbol(sym.comparador, this.yytext());}

{opLogico}		{return symbol(sym.opLogico, this.yytext());}

{booleano}		{return symbol(sym.booleano, this.yytext());}

{string}		{return symbol(sym.string, this.yytext());}
{numero}		{return symbol(sym.numero, this.yytext());}
{id}			{return symbol(sym.id, this.yytext());}

[^]				{throw new Error("Carácter no reconocido: <"+yytext()+">"); }
