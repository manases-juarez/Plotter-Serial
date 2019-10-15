package Generadores;

public class GSintactico
{
   public static void main(String[] args)
    {
        int n = 0;
        String  opciones[] = new String[7];
        
        String destino = "-destdir",
        carpetaTexto = "src/AnalizadoresTexto/",
        carpetaCodigo = "src/Analizadores/",
        simbols = "-symbols",
        simbolsCSS = "Symc",
        par = "-parser",
        sintactico = "Sintactico";
        
        //Seleccionamos la opción de dirección de destino
        opciones[n] = destino;
        
        //Le damos la dirección, carpeta donde se va a generar el parser.java & el simbolosxxx.java        
        n++;
        opciones[n] = carpetaCodigo;
        
        //Seleccionamos la opción de nombre de archivo simbolos
        n++;
        opciones[n] = simbols;
        
        //Le damos el nombre que queremos que tenga
        n++;
        opciones[n] = simbolsCSS;
                
        //Seleccionamos la opcion de clase parser
        n++;
        opciones[n] = par;
        
        //Le damos nombre a esa clase del paso anterior
        n++;
        opciones[n] = sintactico;
        
        //Le decimos donde se encuentra el archivo .cup 
        n++;
        opciones[n] = carpetaTexto + sintactico +".cup";

        try 
        {
            System.out.println("\n--------------------------------------------------------------------------");
            java_cup.Main.main(opciones);

        } 
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }
}
