package edu.truman.emroskia;

import java.awt.Graphics2D;

/**
 * A shape that manages its selection state.
 * @author Arber Emroski
 * @version November 20, 2015
 */
public abstract class AbstractShapes implements SceneShape
{
   // Attributes
   private boolean selected;
   private int x;
   private int y;
   private int width;

   /**
    * Creates a abstract shape object
    * @param x top left coordinate of the bounding rectangle
    * @param y top left coordinate of the bounding rectangle
    * @param width the width of the bounding rectangle
    */
   public AbstractShapes(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
   }

   /**
    * Designates whether a shape is selected or not.
    * @param b designates when a shape is selected
    */
   public void setSelected(boolean b)
   {
      selected = b;
   }

   /**
    * Returns whether a shape is selected or not.
    * @return true if the shape is selected and false otherwise.
    */
   public boolean isSelected()
   {
      return selected;
   }

   /**
    * Draws the shape in selected form.
    * @param g2 the graphics context
    */
   public void drawSelected(Graphics2D g2)
   {
      // Constant for velocity
      final int HORIZONTAL_VEL = 1;
      final int VERT_VEL = 1;
      final int RESTORE_HORIZONTAL = -2;
      final int RESTORE_VERT = -2;

      translate(HORIZONTAL_VEL, VERT_VEL);
      drawNormal(g2);
      translate(HORIZONTAL_VEL, VERT_VEL);
      drawNormal(g2);
      translate(RESTORE_HORIZONTAL, RESTORE_VERT);
   }

   /**
    * Moves the shape by a given amount.
    * @param dx the amount to translate in x-direction
    * @param dy the amount to translate in y-direction
    */
   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;
   }

   /**
    * Sets the width of a shape.
    * @param width the width of a shape
    */
   public void setWidth(int width)
   {
      this.width = width;
   }

   /**
    * Accesses the value of x.
    * @return the value of x
    */
   public int getX()
   {
      return x;
   }

   /**
    * Accesses the value of y.
    * @return the value of y
    */
   public int getY()
   {
      return y;
   }

   /**
    * Accesses the value of width
    * @return the value of width
    */
   public int getWidth()
   {
      return width;
   }
}
