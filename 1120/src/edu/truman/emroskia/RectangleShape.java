package edu.truman.emroskia;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * A rectangle shape.
 * @author Arber Emroski
 * @version November 20, 2015
 */
public class RectangleShape extends AbstractShapes
{
   /**
    * Creates a rectangle shape object
    * @param x top left coordinate of rectangle bounding the rectangle shape
    * @param y top left coordinate of rectangle bounding the rectangle shape
    * @param width the width of bounding rectangle of the rectangle shape
    */
   public RectangleShape(int x, int y, int width)
   {
      super(x, y, width);
   }

   /**
    * Draws the rectangle shape.
    * @param g2 the graphics context
    */
   public void drawNormal(Graphics2D g2)
   {
      // local variables
      int x = getX();
      int y = getY();
      int width = getWidth();
      int height = width * 2;

      Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, width,
            height);

      g2.setColor(Color.RED);
      g2.draw(rectangle);
      g2.fill(rectangle);
   }

   /**
    * Tests a bounding area of the rectangle for a selected point.
    * @param p the point being tested
    * @return boolean representing whether point is within bounded area
    */
   public boolean contains(Point2D p)
   {
      // local variables
      int x = getX();
      int y = getY();
      int width = getWidth();
      int height = width * 2;

      return x <= p.getX() && p.getX() <= x + width && y <= p.getY()
            && p.getY() <= y + height;
   }
}
