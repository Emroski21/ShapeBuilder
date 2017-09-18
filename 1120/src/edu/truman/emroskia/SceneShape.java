package edu.truman.emroskia;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * A shape with selection options.
 * @author Arber Emroski
 * @version November 20, 2015
 */
public interface SceneShape
{
   /**
    * Designates when a shape is selected.
    * @param b designates when a shape is selected
    */
   void setSelected(boolean b);

   /**
    * Returns whether a shape is selected or not.
    * @return true if the shape is selected and false otherwise
    */
   boolean isSelected();

   /**
    * Draws the shape.
    * @param g2 the graphics context
    */
   void drawNormal(Graphics2D g2);

   /**
    * Draws the shape in selected form.
    * @param g2 the graphics context
    */
   void drawSelected(Graphics2D g2);

   /**
    * Moves the shape by a given amount.
    * @param dx the amount to translate in x-direction
    * @param dy the amount to translate in y-direction
    */
   void translate(int dx, int dy);

   /**
    * Tests a bounding area of a shape for a selected point.
    * @param aPoint the point being tested
    * @return boolean representing whether point is within bounded area
    */
   boolean contains(Point2D aPoint);

   /**
    * Sets the width of a shape.
    * @param width the width of a shape
    */
   public void setWidth(int width);
}
