/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paralelcomunicattion;

import Interfaz.Ventana;
import java.io.DataOutputStream;
import java.io.FileReader;
//import javax.comm.CommPortIdentifier;
//import javax.comm.NoSuchPortException;
//import javax.comm.ParallelPort;
//import javax.comm.PortInUseException;

import java.io.OutputStream;




/**
 *
 * @author Grupo1
 */
public class ParalelComunicattion {

    private static OutputStream outputStream;
    private static FileReader inputStream;
    private static DataOutputStream dataOutputStream;

    
    public static final String PARALLEL_PORT  = "LPT1";
    public static final String[] PORT_TYPE = {"Serial Port", "Paralel Port"};
    
    public static Ventana ventana = new Ventana();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
                
        ventana.setTitle("Impresora");
        ventana.show();
        // TODO code application logic here
        
        

    }
    
  
}
