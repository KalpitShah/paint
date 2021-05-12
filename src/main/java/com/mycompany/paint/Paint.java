/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author
 */
public class Paint {
    
    static JButton red, green, blue, eraser, clear, save;
    static JPanel panel;
    static GUI paintpanel;
    
    public static void main(String args[]) {
        JFrame jframe = new JFrame();
        jframe.setSize(800, 900);
        jframe.setTitle("Paint Program");
        jframe.setLayout(new FlowLayout());
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        red = new JButton("Red");
        green = new JButton("Green");
        blue = new JButton("Blue");
        eraser = new JButton("Eraser");
        clear = new JButton("Clear");
        save = new JButton("Save Image");
        
        panel = new JPanel();
        paintpanel = new GUI();
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        
        red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paintpanel.changeColor(Color.RED);
            }
        });
        
        blue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paintpanel.changeColor(Color.BLUE);
            }
        });
        
        green.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paintpanel.changeColor(Color.GREEN);
            }
        });
        
        eraser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paintpanel.changeColor(Color.WHITE);
            }
        });
        
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paintpanel.clearGraphics();
            }
        });
        
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    paintpanel.saveImage();
                } catch (IOException ex) {
                    Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        panel.add(red);
        panel.add(green);
        panel.add(blue);
        panel.add(eraser);
        panel.add(clear);
        panel.add(save);
        jframe.add(paintpanel);
        jframe.add(panel);
    }
    
    
}
