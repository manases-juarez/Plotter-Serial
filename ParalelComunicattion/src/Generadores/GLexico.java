package Generadores;

import java.util.logging.Level;
import java.util.logging.Logger;
import jflex.SilentExit;

public class GLexico 
{
    public static void main(String[] args) 
    {
        String  pathDestino = "src/Analizadores/";
        System.out.println("\n--------------------------------------------------------------------------");
        generarLexer(pathDestino, "src/AnalizadoresTexto/Lexico.jflex");        
    } 
    
    public static void generarLexer(String pathDestino, String archivoOrigenTexto)
    {
        int n = 0;
        String  argumentos[] = new String[3];
        argumentos[n] = "-d"; n++;
        argumentos[n] = pathDestino; n++;
        argumentos[n] = archivoOrigenTexto;
        
        try {
            jflex.Main.generate(argumentos);
        } catch (SilentExit ex) {
            Logger.getLogger(GLexico.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}

