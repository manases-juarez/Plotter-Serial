/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instrucciones;

import Estructuras.Celda;
import Interfaz.Ventana;
import java.util.LinkedList;
import jnpout32.pPort;

/**
 *
 * @author Grupo1
 */
public class Hilo extends Thread{
    
    Boolean done = false;
    pPort puerto = new pPort();
    short valor;
    
    public void run(){
        String x = "", y = "";
        while(!done){
            try{
                short direccion =888;
                //short pin = 2;
                //puerto.setPin(pin, (short)1);
                for(int i = 0; i<3; i++){
                    valor = puerto.input((short)(direccion ));
                    x = x + valor;
                    Thread.sleep(500);
                }
                for(int i = 0; i<4; i++){
                    valor = puerto.input((short)(direccion ));
                    y = y + valor;
                    Thread.sleep(500);
                }
                System.out.println("variable x: "+x);
                System.out.println("variable y: "+y);
                int var_x = Integer.parseInt(x, 2);
                int var_y = Integer.parseInt(y, 2);
                System.out.println("variable x: "+var_x);
                System.out.println("variable y: "+var_y);
                Ventana.coorX.setText(var_x+"");
                Ventana.coorY.setText(var_y+"");
                Ventana.coorX.repaint();
                Ventana.coorY.repaint();
                
                x = "";
                y = "";
            }catch(Exception e){

            }
        }
    }
    
    public void safeStop(){
        this.done = true;
    }
}

