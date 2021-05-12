/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paint;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author
 */
public class GUI extends JPanel {
    

  private int x1, y1, x2, y2;
  
  private final int DEFAULT_WIDTH  = 800;
  private final int DEFAULT_HEIGHT = 800;
  private final Color BACK_COLOR   = Color.WHITE;

  private MyMouseHandler handler;
  private Graphics g, g2;
  private Color color;
  private BufferedImage bufferedImage;

  // CONSTRUCTOR
  public GUI()
  {
    setBackground( BACK_COLOR );
    setPreferredSize( new Dimension( DEFAULT_WIDTH, DEFAULT_HEIGHT ) );

    handler  = new MyMouseHandler();
    bufferedImage = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);

    this.addMouseListener( handler );
    this.addMouseMotionListener( handler );
    initGraphics2();
  }

  // METHOD
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
  }

  private void initGraphics2() {
      g2 = bufferedImage.createGraphics();
      g2.setColor(Color.WHITE);
      g2.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
      g2.setColor(Color.BLACK);
  }

  private void setupGraphics()
  {
      
    g = getGraphics();
    g.setColor(color);
    g2.setColor(color);
  }

  public void changeColor(Color c)
  {
      System.out.println(c);
      color = c;
      setupGraphics();
  }

  public void clearGraphics()
  {
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
      g.setColor(color);
      g2.setColor(Color.WHITE);
      g2.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
      g2.setColor(color);
  }
  
  public void saveImage() throws IOException {
      // Save as PNG
      File file = new File("myimage.jpg");
      ImageIO.write(bufferedImage, "jpg", file);
  }

  // INNER CLASS
  private class MyMouseHandler extends MouseAdapter
  {
    public void mouseDragged( MouseEvent e )
    {
      x1 = e.getX();
      y1 = e.getY();

      g.drawLine(x1,y1,x2,y2);
      g2.drawLine(x1,y1,x2,y2);

      x2=x1;
      y2=y1;
    }
    
    public void mousePressed( MouseEvent e )
    {
      x1 = e.getX();
      y1 = e.getY();

      setupGraphics();

      x2=x1;
      y2=y1;
    }
  }
  
  
}