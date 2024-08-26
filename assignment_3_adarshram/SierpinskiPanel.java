import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SierpinskiPanel extends JPanel {
    
   int width;
   int height;
   int sideLength;
  
   public void paintComponent(Graphics g) {
       
       super.paintComponent(g);
       width = getWidth();
       height = getHeight();
       if (width >= height)
       {
           sideLength = height;
       }
       else
       {
           sideLength = width;
       }
       drawTriangle(g, 0, 0, sideLength);
       repaint();
   }
  
   public void drawTriangle(Graphics g, int x, int y, int sideLength) {
      
       if(sideLength == 1) {
            g.drawRect(x, y, 1, 1);
       }
        else {
            int c1X = x;
            int c1Y = y + (sideLength / 2);
            int c2X = x + (sideLength / 2);
            int c2Y = y + (sideLength / 2);
            int c3X = x + (sideLength / 4);
            int c3Y = y;

            drawTriangle(g, c1X, c1Y, sideLength / 2);
            drawTriangle(g, c2X, c2Y, sideLength / 2);
            drawTriangle(g, c3X, c3Y, sideLength / 2);
        }
    }
}