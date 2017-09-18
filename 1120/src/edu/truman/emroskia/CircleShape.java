package edu.truman.emroskia;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * A circle shape.
 * @author Arber Emroski
 * @version November 20, 2015
 */
public class CircleShape extends AbstractShapes
{

   /**
    * Creates a circle shape object
    * @param x top left coordinate of rectangle bounding the circle shape
    * @param y top left coordinate of rectangle bounding the circle shape
    * @param width the width of the bounding rectangle of the circle shape
    */
   public CircleShape(int x, int y, int width)
   {
      super(x, y, width);
   }

   /**
    * Draws the circle shape.
    * @param g2 the graphics context
    */
   public void drawNormal(Graphics2D g2)
   {
      // local variables
      int x = getX();
      int y = getY();
      // Width is represented by diameter for the circle shape
      int diameter = getWidth();

      Ellipse2D.Double circle = new Ellipse2D.Double(x, y, diameter, diameter);

      g2.setColor(Color.BLUE);
      g2.draw(circle);
      g2.fill(circle);
   }

   /**
    * Tests a bounding area of the circle for a selected point.
    * @param p the point being tested
    * @return boolean representing whether point is within bounded area
    */
   public boolean contains(Point2D p)
   {
      // local variables
      int x = getX();
      int y = getY();
      // Width is represented by diameter for the circle shape
      int diameter = getWidth();

      return x <= p.getX() && p.getX() <= x + (diameter) && y <= p.getY()
            && p.getY() <= y + (diameter);
   }

}