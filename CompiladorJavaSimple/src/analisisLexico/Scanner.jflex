package analisisLexico;
import analisisSintactico.sym;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

%%

%public			// Per indicar que la classe és pública
%class Scanner	// El nom de la classe

%unicode
%line
%column
%cup

%{

    public Symbol symbol(int type){
		return new ComplexSymbol(sym.terminalNames[type], type,
						new Location(yyline+1, yycolumn+1, yychar),
						new Location(yyline+1, yycolumn+yylength(), yychar+yylength())
		);
    }
    public Symbol symbol(int type, String lexem){
		return new ComplexSymbol(sym.terminalNames[type], type,
							new Location(yyline+1, yycolumn +1, yychar), 
							new Location(yyline+1, yycolumn+yylength(), yychar+yylength()),
							lexem
		);
    }
%}

/* definiciones regulares */

FINLINEA	= \r|\n|\r\n
ESPACIO		= {FINLINEA} | [ \t\f]

tclass		=	"class"
tipoInt		=	"int"
tipoBoolean	=	"boolean"
tipoString	=	"String"
llaveIzq	=	"{"
llaveDer	=	"}"
igual		=	"="
puntocoma	=	";"
coma		=	","
parenIzq	=	"("
parenDer	=	")"
mas			=	"+"
menos		=	"-"
asterisco	=	"*"
barra		=	"/"
equals		=	"=="
notequals	=	"!="
mayorque	=	">"
menorque	=	"<"
mayorigu	=	">="
menorigu	=	"<="
logicand	=	"&&"
logicor		=	"||"
booltru		=	"true"
boolfal		=	"false"
string		=	[\"][A-Za-z0-9_]*[\"]
numero		=	(0|[1-9][0-9]*)

id			=	[A-Za-z][A-Za-z0-9_]*

%%

{ESPACIO}		{/* nada que hacer */}

{tclass}		{return symbol(sym.tclass, null);}
{tipoBoolean}	{return symbol(sym.tipoBoolean, "boolean");}
{tipoInt}		{return symbol(sym.tipoInt, "int");}
{tipoString}	{return symbol(sym.tipoString, "String");}
{llaveIzq}		{return symbol(sym.llaveIzq, null);}
{llaveDer}		{return symbol(sym.llaveDer, null);}
{igual}			{return symbol(sym.igual, null);}
{puntocoma}		{return symbol(sym.puntocoma, null);}
{coma}			{return symbol(sym.coma, null);}
{parenIzq}		{return symbol(sym.parenIzq, null);}
{parenDer}		{return symbol(sym.parenDer, null);}
{mas}			{return symbol(sym.mas, "+");}
{menos}			{return symbol(sym.menos, "-");}
{asterisco}		{return symbol(sym.asterisco, "*");}
{barra}			{return symbol(sym.barra, "/");}
{equals}		{return symbol(sym.equals, "==");}
{notequals}		{return symbol(sym.notequals, "!=");}
{mayorque}		{return symbol(sym.mayorque, ">");}
{menorque}		{return symbol(sym.menorque, "<");}
{mayorigu}		{return symbol(sym.mayorigu, ">=");}
{menorigu}		{return symbol(sym.menorigu, "<=");}
{logicand}		{return symbol(sym.logicand, "&&");}
{logicor}		{return symbol(sym.logicor, "||");}
{booltru}		{return symbol(sym.booltru, "true");}
{boolfal}		{return symbol(sym.boolfal, "false");}
{string}		{return symbol(sym.string, this.yytext());}
{numero}		{return symbol(sym.numero, this.yytext());}
{id}			{return symbol(sym.id, this.yytext());}

[^]				{throw new Error("Carácter no reconocido: <"+yytext()+">"); }
