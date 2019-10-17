/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paralelcomunicattion;

import Estructuras.Celda;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
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
    
    public void ejecutar(LinkedList<Celda> matriz){
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
            
            int x, y;
            
            for(int i = 0; i<matriz.size(); i++){
                Celda celda = matriz.get(i);
                if(celda.getEstado() == 1){
                    x = celda.getX();
                    y = celda.getY();
                    String binaryX = Integer.toBinaryString(x);
                    String binaryY = Integer.toBinaryString(y);
                    int tam = binaryX.length();
                    System.out.println("Imprimiendo x " + x + " binario: " + binaryX);
                    for(int j=0; j<8; j++){
                        if(j < tam){
                            if(binaryX.charAt(j) == '0')
                                dataOutputStream.write(0);
                            else
                                dataOutputStream.write(1);
                        }else{
                            dataOutputStream.write(0);
                        }
                        dataOutputStream.flush();
                        System.out.println("segundo" + j);
                        Thread.sleep(1000);
                    }
                    System.out.println("Imprimiendo y " + y + " binario: " + binaryY);
                    int tam2 = binaryY.length();
                    if(y>9){
                        int numero2 = y - 10;
                        String a = Integer.toBinaryString(numero2);
                        int b = a.length();
                        //Imprimiendo numero uno en y
                        System.out.println("Imprimiendo y1 " + numero2);
                        for(int j=0; j<8; j++){
                            if(j < b){
                                if(a.charAt(j) == '0')
                                    dataOutputStream.write(0);
                                else
                                    dataOutputStream.write(1);
                            }else
                                dataOutputStream.write(0);
                            dataOutputStream.flush();
                            System.out.println("segundo" + j);
                            Thread.sleep(1000);
                        }
                        System.out.println("Imprimiendo y2 1");
                        for(int j=0; j<8; j++){
                            if(j == 0){
                                dataOutputStream.write(1);
                            }else
                                dataOutputStream.write(0);
                            dataOutputStream.flush();
                            System.out.println("segundo" + j);
                            Thread.sleep(1000);
                        }
                    }else{
                        String a = Integer.toBinaryString(y);
                        int b = a.length();
                        //Imprimiendo numero uno en y
                        System.out.println("Imprimiendo y1 " + a);
                        for(int j=0; j<8; j++){
                            if(j < b){
                                if(a.charAt(j) == '0')
                                    dataOutputStream.write(0);
                                else
                                    dataOutputStream.write(1);
                            }else
                                dataOutputStream.write(0);
                            dataOutputStream.flush();
                            System.out.println("segundo" + j);
                            Thread.sleep(1000);
                        }
                        System.out.println("Imprimiendo y2 0");
                        for(int j=0; j<8; j++){
                            dataOutputStream.write(0);
                            dataOutputStream.flush();
                            System.out.println("segundo" + j);
                            Thread.sleep(1000);
                        }
                    }
//                    for(int j=0; j<binaryY.length(); j++){
//                        if(binaryY.charAt(tam2-1) == '0')
//                            dataOutputStream.write(0);
//                        else
//                            dataOutputStream.write(1);
//                        dataOutputStream.flush();
//                        Thread.sleep(1000);
//                        tam2--;
//                    }
                }
            }
            
//            //Convert string to bytes to be sended throw parallel port
//            inputStream = new FileReader("content.txt");
//            int counter;
//            int hexa;
//            char character;
//            String binary;
//            byte[] byteArray = new byte[1];
//            byteArray[0] = (byte)50;
//            for(int i=0; i<byteArray.length; i++){
//                binary = Integer.toBinaryString(678);
//                System.out.println(binary);
//                int tam = binary.length();
//                for(int j=0; j<binary.length(); j++){
//                    if(binary.charAt(tam-1) == '0')
//                        dataOutputStream.write(0);
//                    else
//                        dataOutputStream.write(1);
//                    dataOutputStream.flush();
//                    Thread.sleep(1000);
//                    tam--;
//                }
//                
//                
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
