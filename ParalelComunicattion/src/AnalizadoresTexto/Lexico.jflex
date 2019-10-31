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
                    return new Symbol(Symc.tLlaveA,yycolumn,yyline,yytext());}
    "}"         {   System.out.println("Llave Cierra");
                    return new Symbol(Symc.tLlaveC,yycolumn,yyline,yytext());}
    "\"coordenadas\"" {System.out.println("Token coordenadas");
                    return new Symbol(Symc.tCoordenada,yycolumn,yyline,yytext());}
    ":"         {   System.out.println("Dos puntos");
                    return new Symbol(Symc.tDospuntos,yycolumn,yyline,yytext());}
    "["         {   System.out.println("Corch abre");
                    return new Symbol(Symc.tCorcheteA,yycolumn,yyline,yytext());}
    "]"         {   System.out.println("Corch Abre");
                    return new Symbol(Symc.tCorcheteC, yycolumn,yyline,yytext());}
    "\"x\""     {   System.out.println("Token X");
                    return new Symbol(Symc.tX,yycolumn,yyline,yytext());}
    "\"y\""     {   System.out.println("Token Y");
                    return new Symbol(Symc.tY,yycolumn,yyline,yytext());}
    ","         {   System.out.println("Coma");
                    return new Symbol(Symc.tComa,yycolumn,yyline,yytext());}
    {numero}    {   System.out.println("Digito");
                    return new Symbol(Symc.tDigito,yycolumn,yyline,yytext());}
    

    {espacio} { /* ignorar */ }
    .       {System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}
}


