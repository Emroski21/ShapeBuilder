package edu.truman.emroskia;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

/**
 * A component that shows a scene composed of shapes.
 * @author Arber Emroski
 * @version November 20, 2015
 */
public class SceneComponent extends JComponent
{
   // Attributes
   private ArrayList<SceneShape> shapes;
   private Point mousePoint;
   private Point lastPoint;
   private Random random;

   /**
    * Constructs a scene component object.
    */
   public SceneComponent()
   {
      shapes = new ArrayList<SceneShape>();
      addMouseListener(new MouseAdapter()
      {
         public void mousePressed(MouseEvent event)
         {
            mousePoint = event.getPoint();
            lastPoint = event.getPoint();
            for (SceneShape s : shapes)
            {
               if (s.contains(mousePoint))
               {
                  s.setSelected(!s.isSelected());
               }
            }
            repaint();
         }
      });

      addMouseMotionListener(new MouseMotionAdapter()
      {
         public void mouseDragged(MouseEvent event)
         {
            Point lastMousePoint = mousePoint;
            mousePoint = event.getPoint();
            for (SceneShape s : shapes)
            {
               if (s.isSelected() || s.contains(lastPoint))
               {
                  s.setSelected(true);
                  double dx = mousePoint.getX() - lastMousePoint.getX();
                  double dy = mousePoint.getY() - lastMousePoint.getY();
                  s.translate((int) dx, (int) dy);
               }
            }
            repaint();
         }
      });
   }

   /**
    * Adds a shape to the scene.
    * @param s the shape to add
    */
   public void add(SceneShape s)
   {
      shapes.add(s);
      repaint();
   }

   /**
    * Removes all selected shapes from the scene.
    */
   public void removesSelected()
   {
      for (int i = shapes.size() - 1; i >= 0; i--)
      {
         SceneShape s = shapes.get(i);
         if (s.isSelected())
         {
            shapes.remove(i);
         }
      }
      repaint();
   }

   /**
    * Paints the component and scene.
    * @param g the graphics context
    */
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      for (SceneShape s : shapes)
      {
         s.drawNormal(g2);
         if (s.isSelected())
         {
            s.drawSelected(g2);
         }
      }
   }

   /**
    * Changes the size of all selected shape.
    * @param size the size of the width
    */
   public void resizeSelected(int size)
   {

      for (SceneShape s : shapes)
      {
         if (s.isSelected())
         {
            s.setWidth(size);
         }
         repaint();
      }
   }

   /**
    * Generates a random integer value.
    * @return an integer value between 0 and 300
    */
   public int generateRandomInt()
   {
      random = new Random();
      final int rangeOfIntegers = 500;
      int randomInt = random.nextInt(rangeOfIntegers);
      return randomInt;
   }
}
