/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Grupo1
 */
public class Panel {
    public JPanel panel;
    public String nombre;
    public int index;
    public LinkedList<Celda> elementos = new LinkedList<Celda>();
    public String url;
    public String contenido;
    
    public Panel(JPanel panel, String nombre, LinkedList<Celda> elementos, int index, String contenido, String url){
        this.panel = panel;
        this.nombre = nombre;
        this.elementos = elementos;
        this.index = index;
        this.url = url;
        this.contenido = contenido;
    }
    
}
