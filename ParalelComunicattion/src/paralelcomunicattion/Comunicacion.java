/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paralelcomunicattion;

import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.ParallelPort;
import javax.comm.PortInUseException;
import javax.comm.UnsupportedCommOperationException;

/**
 *
 * @author Grupo1
 */
public class Comunicacion {
    private static OutputStream outputStream;
    private static FileReader inputStream;
    private static DataOutputStream dataOutputStream;
    private static ParallelPort parallelPort;
    private static CommPortIdentifier port;
    
    public static final String PARALLEL_PORT  = "LPT1";
    public static final String[] PORT_TYPE = {"Serial Port", "Paralel Port"};
    
    public Comunicacion(){
        
    }
    
    public void ejecutar(){
        System.out.println("Star connection...");
        
        try{
            port = CommPortIdentifier.getPortIdentifier("LPT1");
            int port_type = port.getPortType();
            String port_name = port.getName();
            
            System.out.println("Port type: " + PORT_TYPE[port_type - 1]);
            System.out.println("Port name: " + port_name);
            
            //open port            
            parallelPort = (ParallelPort) port.open("MyApp", 500);
            outputStream = parallelPort.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            System.out.println("Owned by: " + port.getCurrentOwner());
            parallelPort.setMode(1);
            
            //Convert string to bytes to be sended throw parallel port
            inputStream = new FileReader("content.txt");
            int counter;
            int hexa;
            char character;
            String binary;
            byte[] byteArray = new byte[1];
            byteArray[0] = (byte)50;
            for(int i=0; i<byteArray.length; i++){
                binary = Integer.toBinaryString(678);
                System.out.println(binary);
                int tam = binary.length();
                for(int j=0; j<binary.length(); j++){
                    if(binary.charAt(tam-1) == '0')
                        dataOutputStream.write(0);
                    else
                        dataOutputStream.write(1);
                    dataOutputStream.flush();
                    Thread.sleep(1000);
                    tam--;
                }
                
                
            }
            
//            while((counter = inputStream.read()) != -1){
//                character = (char) counter;
//                binary = Integer.toBinaryString(counter);
//                byteArray[0] = (byte)counter;
//                System.out.println("ASCCII: " + counter + " Symbol: " + character + " Binary: " + binary);
//                dataOutputStream.write(byteArray);
//                
//                dataOutputStream.flush();
//                Thread.sleep(1000);
//            }
            
            System.out.println("Close...");
            dataOutputStream.close();
            parallelPort.close();
            //System.exit(0);        
        }catch (NoSuchPortException nspe) {
            System.out.println("Port not found: " + nspe);        
        }catch (PortInUseException piuse){
            System.out.println("Port in use " + piuse);
        }catch (UnsupportedCommOperationException ucoe){
            System.out.println(ucoe);
        }catch (IOException ioe){
            System.out.println("Error, failed to write: " + ioe);
        }catch (Exception e){
            System.out.println("Failed to open port with exeption: " + e);
        } finally{
            if(port != null && port.isCurrentlyOwned()){
                parallelPort.close();
            }
            System.out.println("Closed all resources.");
        }
        System.out.println("END ---------- XXXXXXX");
    }
}
