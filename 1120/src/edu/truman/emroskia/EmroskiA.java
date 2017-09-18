package edu.truman.emroskia;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A program that edits a scene by drawing various shapes.
 * @author Arber Emroski
 * @version November 20, 2015
 */
public class EmroskiA
{
   // Attributes for components
   private JFrame frame;
   private SceneComponent scene;
   private JButton removeButton;
   private JButton rectangleButton;
   private JButton circleButton;
   private JButton triangleButton;
   private JPanel buttons;
   private JPanel sliderPanel;
   private JSlider sizeSlider;
   private KeyListener listener;
   // Constants
   private static final int WIDTH = 100;
   private static final int SLIDER_MIN = 50;
   private static final int SLIDER_MAX = 150;
   private static final int INITIAL_SLIDER_VAL = 100;

   /**
    * Constructs a scene editor object.
    */
   public EmroskiA()
   {
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      scene = new SceneComponent();

      // Shape created by key press of shape's first letter
      listener = new KeyAdapter()
      {
         @Override
         public void keyPressed(KeyEvent event)
         {
            int keyCode = event.getKeyCode();
            if (keyCode == KeyEvent.VK_C)
            {
               scene.add(new CircleShape(scene.generateRandomInt(),
                     scene.generateRandomInt(), WIDTH));

            }
            else if (keyCode == KeyEvent.VK_R)
            {
               scene.add(new RectangleShape(scene.generateRandomInt(),
                     scene.generateRandomInt(), WIDTH));

            }
            else if (keyCode == KeyEvent.VK_T)
            {
               scene.add(new TriangleShape(scene.generateRandomInt(),
                     scene.generateRandomInt(), WIDTH));
            }
         }
      };

      sizeSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX,
            INITIAL_SLIDER_VAL);

      // How frequently major ticks appear on the size slider
      final int MAJOR_TICKS = 10;
      sizeSlider.setMajorTickSpacing(MAJOR_TICKS);

      // How frequently minor ticks appear on the size slider
      final int MINOR_TICKS = 5;
      sizeSlider.setMinorTickSpacing(MINOR_TICKS);

      sizeSlider.setPaintTicks(true);
      sizeSlider.setPaintLabels(true);
      sizeSlider.setFocusable(false);

      // Message displayed in button that creates a circle
      final String CIRCLE_MSG = "Circle";
      circleButton = new JButton(CIRCLE_MSG);
      circleButton.setFocusable(false);

      // Message displayed in button that creates a rectangle
      final String RECTANGLE_MSG = "Rectangle";
      rectangleButton = new JButton(RECTANGLE_MSG);
      rectangleButton.setFocusable(false);

      // Message displayed in button that creates a triangle
      final String TRIANGLE_MSG = "Triangle";
      triangleButton = new JButton(TRIANGLE_MSG);
      triangleButton.setFocusable(false);

      // Message displayed in button that removes shapes
      final String REMOVE_MSG = "Remove";
      removeButton = new JButton(REMOVE_MSG);
      removeButton.setFocusable(false);

      buttons = new JPanel();
      sliderPanel = new JPanel(new BorderLayout());
      sliderPanel.add(sizeSlider, BorderLayout.CENTER);

      buttons.add(circleButton);
      buttons.add(rectangleButton);
      buttons.add(triangleButton);
      buttons.add(removeButton);
      frame.add(scene, BorderLayout.CENTER);
      frame.add(buttons, BorderLayout.NORTH);
      frame.add(sliderPanel, BorderLayout.SOUTH);
      frame.addKeyListener(listener);
      frame.setResizable(false);

      // Constants for size of frame
      final int FRAME_WIDTH = 500;
      final int FRAME_HEIGHT = 500;
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setVisible(true);
   }

   /**
    * Creates and removes the shapes.
    */
   public void runAnimation()
   {
      sizeSlider.addChangeListener(new ChangeListener()
      {
         @Override
         public void stateChanged(ChangeEvent e)
         {
            JSlider source = (JSlider) e.getSource();
            int size = (int) source.getValue();
            scene.resizeSelected(size);
            scene.repaint();
         }
      });

      circleButton.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent event)
         {
            scene.add(new CircleShape(scene.generateRandomInt(),
                  scene.generateRandomInt(), WIDTH));
         }
      });

      rectangleButton.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent event)
         {
            scene.add(new RectangleShape(scene.generateRandomInt(),
                  scene.generateRandomInt(), WIDTH));
         }
      });

      triangleButton.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent event)
         {
            scene.add(new TriangleShape(scene.generateRandomInt(),
                  scene.generateRandomInt(), WIDTH));
         }
      });

      removeButton.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent event)
         {
            scene.removesSelected();
         }
      });
   }

   public static void main(String[] args)
   {
      EmroskiA editor = new EmroskiA();
      editor.runAnimation();
   }
}
