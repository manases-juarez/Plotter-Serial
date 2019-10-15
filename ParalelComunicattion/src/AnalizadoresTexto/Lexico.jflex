package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;
%%
%{
    String cadena="", cadenaInterna = "";
    int c = 0;
%}

%public
%class Lexico
%cupsym Symc
%cup
%char
%line
%column
%full
%unicode
%ignorecase

digito = [0-9]
numero = {digito}+
letra = [a-zA-ZñÑ]
id = {letra}+({letra}|{digito}|"_")*   
espacio = \t|\f|" "|\r|\n

%%



<YYINITIAL>{ 
    "{"         {   System.out.println("Llave Abre");
                    return new Symbol(Symh.tLlaveA,yycolumn,yyline,yytext());}
    "}"         {   System.out.println("Llave Cierra");
                    return new Symbol(Symh.tLlaveC,yycolumn,yyline,yytext());}
    [\"coordenadas\"]{System.out.println("Token coordenadas");
                    return new Symbol(Symh.tCoordenada,yycolumn,yyline,yytext());}
    ":"         {   System.out.println("Dos puntos");
                    return new Symbol(Symh.tDospuntos,yycolumn,yyline,yytext());}
    "["         {   System.out.println("Corch abre");
                    return new Symbol(Symh.tCorcheteA,yycolumn,yyline,yytext());}
    "]"         {   System.out.println("Corch Abre");
                    return new Symbol(Symh.tCorcheteC, yycolumn,yyline,yytext());}
    [\"x\"]     {   System.out.println("Token X");
                    return new Symbol(Symh.tX,yycolumn,yyline,yytext());}
    [\"y\"]     {   System.out.println("Token Y");
                    return new Symbol(Symh.tY,yycolumn,yyline,yytext());}
    ","         {   System.out.println("Coma");
                    return new Symbol(Symh.tComa,yycolumn,yyline,yytext());}
    {numero}    {   System.out.println("Digito");
                    return new Symbol(Symh.tDigito,yycolumn,yyline,yytext());}
    

    {espacio} { /* ignorar */ }
    .       {System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}
}


