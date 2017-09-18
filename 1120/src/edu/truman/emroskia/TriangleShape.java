package edu.truman.emroskia;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * A triangle shape.
 * @author Arber Emroski
 * @version November 20, 2015
 */
public class TriangleShape extends AbstractShapes
{
   // Constants for factors of the triangle shape
   private static final int MIDPT_FTR = 2;

   /**
    * Creates a triangle shape object
    * @param x top left coordinate of the rectangle bounding the triangle shape
    * @param y top left coordinate of the rectangle bounding the triangle shape
    * @param width the width of the bounding rectangle of the triangle shape
    */
   public TriangleShape(int x, int y, int width)
   {

      super(x, y, width);
   }

   /**
    * Draws the triangle shape.
    * @param g2 the graphics context
    */
   public void drawNormal(Graphics2D g2)
   {
      // local variables
      int x = getX();
      int y = getY();
      int width = getWidth();

      Point2D.Double leftPoint = new Point2D.Double(x, y + width);
      Point2D.Double topPoint = new Point2D.Double(x + width / MIDPT_FTR, y);
      Point2D.Double rightPoint = new Point2D.Double(x + width, y + width);

      Line2D.Double leftSide = new Line2D.Double(leftPoint, topPoint);
      Line2D.Double rightSide = new Line2D.Double(topPoint, rightPoint);
      Line2D.Double base = new Line2D.Double(leftPoint, rightPoint);

      g2.setColor(Color.LIGHT_GRAY);
      g2.draw(leftSide);
      g2.draw(rightSide);
      g2.draw(base);
   }

   /**
    * Tests a bounding area of the triangle for a selected point.
    * @param p the point being tested
    * @return boolean representing whether point is within bounded area
    */
   public boolean contains(Point2D p)
   {
      // local variables
      int x = getX();
      int y = getY();
      int width = getWidth();

      return x <= p.getX() && p.getX() <= x + width && y <= p.getY()
            && p.getY() <= y + width;
   }

}