//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class KochPanel extends JPanel
{
   private final int PANEL_WIDTH = 400;
   private final int PANEL_HEIGHT = 400;

   private final double SQ = Math.sqrt(3.0) / 6;

   private final int TOPX = 200, TOPY = 250;
   private final int LEFTX = 200, LEFTY = 375;
   

   private int current; //current order

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public KochPanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (int order, int x1, int y1, int x5, int y5,
                            Graphics page, double angle)
   {
      int deltaX, deltaY, x2, y2, x3, y3, x4, y4;

      int r,g,b;
      //varies up the colors based on different factors
      r = (255*order)/current; //varies on order
      g = 128 + (int)Math.toDegrees(angle)/2;// varies on angle
      b = 255-255*(y1/400); // vaires on height
         
      page.setColor (new Color(r,g,b));
    
      if (order == 1)
         page.drawLine (x1, y1, x5, y5);
      else
      {
         deltaX = x5-x1;  // distance between end points
         deltaY = y5-y1;
         
         page.drawLine (x1, y1, x5, y5);
         double dist = 2*(Math.pow(Math.pow(deltaX,2)+Math.pow(deltaY,2),.5)/3);
         
         x2 = x5 + (int)(dist*Math.sin(angle+Math.PI/9));
         x3 = x5 + (int)(dist*Math.sin(angle-Math.PI/9));
         y2 = y5 - (int)(dist*Math.cos(angle+Math.PI/9));
         y3 = y5 - (int)(dist*Math.cos(angle-Math.PI/9));
         page.drawLine (x2, y2, x5, y5);
         page.drawLine (x3, y3, x5, y5);
         
         drawFractal(order-1,x5,y5,x2,y2,page,angle+Math.PI/9);
         drawFractal(order-1,x5,y5,x3,y3,page,angle-Math.PI/9);
         
         
      }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);

      page.setColor (Color.green);

      drawFractal (current, LEFTX, LEFTY, TOPX, TOPY, page, 0);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
