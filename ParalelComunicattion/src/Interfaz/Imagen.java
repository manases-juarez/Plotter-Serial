/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;


/**
 *
 * @author PICHU
 */
public class Imagen extends javax.swing.JPanel{
    public Imagen(){
        this.setSize(636, 583);
    }
    
    public void paint(Graphics grafico){
        Dimension height = getSize();
        ImageIcon img = new ImageIcon(getClass().getResource("about.png"));
        grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(grafico);
    }
}
