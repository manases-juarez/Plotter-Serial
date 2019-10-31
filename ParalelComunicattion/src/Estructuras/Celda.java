/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Interfaz.Ventana;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Grupo1
 */
public class Celda {
    int X = 0;
    int Y = 0;
    public JButton boton;
    int estado = 0;
    public enumColor color;
    
    public Celda(int x, int y, int estado, enumColor color, JPanel panel){
        this.X = x;
        this.Y = y;
        this.estado = estado;
        this.color = color;
        this.boton = crearBoton(x, y);
        panel.add(boton);
        panel.repaint();
        
    }
    
    public void setEstado(int i){
        this.estado = i;
    }
    
    public int getX(){
        return this.X;
    }
    
    public int getY(){
        return this.Y;
    }
    
    public int getEstado(){
        return this.estado;
    }
    
    private JButton crearBoton(int x, int y){
        JButton nuevo  = new JButton();
        nuevo.setLayout(null);
        nuevo.setBackground(Color.LIGHT_GRAY);
        nuevo.setBounds(x*40, y*40, 40, 40);
        //nuevo.setBackground(Color.red);
        nuevo.setText("");
        nuevo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Presionando boton: " + X + Y);
                if(estado == 0){
                    boton.setText("1");
                    switch(Ventana.color){
                        case ROJO:
                            boton.setBackground(Color.red);
                            break;
                        case AZUL:
                            boton.setBackground(Color.BLUE);
                            break;
                        case NEGRO:
                            boton.setBackground(Color.BLACK);
                            break;                            
                    }                                    
                    estado = 1;
                }                    
                else{
                    boton.setText("");
                    boton.setBackground(Color.LIGHT_GRAY);
                    estado = 0;
                }                    
            }
        });
        nuevo.repaint();
        return nuevo;
    }
    
    public enum enumColor{
        NEGRO,
        AZUL,
        ROJO
    }
}
