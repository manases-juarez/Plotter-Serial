/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paralelcomunicattion;

import jnpout32.pPort;


/**
 *
 * @author Grupo1
 */
public class Comunicacion {        
        
    public Comunicacion(){
        
    }
    
    public String convertir_binario(int x, int y){
        String cadena = "";
        
        String a = "";
        String b = "";
        switch(x){
            case 0:
                a = "000";
                break;    
            case 1:
                a = "001";
                break;    
            case 2:
                a = "010";
                break;    
            case 3:
                a = "011";
                break;    
            case 4:
                a = "100";
                break;    
            case 5:
                a = "101";
                break;    
            case 6:
                a = "110";
                break;    
            case 7:
                a = "111";
                break;
            default:
                break;                
        }
        switch(y){
            case 0:
                b = "0000";
                break;    
            case 1:
                b = "0001";
                break;    
            case 2:
                b = "0010";
                break;    
            case 3:
                b = "0011";
                break;    
            case 4:
                b = "0100";
                break;    
            case 5:
                b = "0101";
                break;    
            case 6:
                b = "0110";
                break;    
            case 7:
                b = "0111";
                break;
            case 8:
                b = "1000";
                break;    
            case 9:
                b = "1001";
                break;    
            case 10:
                b = "1010";
                break;    
            case 11:
                b = "1011";
                break;    
            case 12:
                b = "1100";
                break;    
            case 13:
                b = "1101";
                break;    
            case 14:
                b = "1110";
                break;    
            case 15:
                b = "1111";
                break;    
            default:
                break;                
        }        
        cadena = a + b;
        System.out.println(cadena);        
        return cadena;
    }
    
    public void ejecutar_(String cadena){
        System.out.println("Star connection...");
        
        try{
            pPort puerto = new pPort();
            short pin = 2;
            
            for(int i=0; i<cadena.length(); i++){
                if(cadena.charAt(i) == '0')
                    puerto.setPin(pin, (short)0);
                else
                    puerto.setPin(pin, (short)1);
                System.out.println("Pin "+cadena.charAt(i));
                Thread.sleep(1000);
            }                                              
        }catch (Exception e){
            System.out.println("Failed to open port with exeption: " + e);
        }
        System.out.println("END ---------- XXXXXXX");
    }       
}
