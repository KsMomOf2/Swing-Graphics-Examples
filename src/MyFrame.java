// Mrs. Kelly
//
// Creates a generic JFrame with a key listener
// sets the properties of the JFrame using the Options.java class, where the size and location are set

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame implements KeyListener {
 
   public MyFrame() {
      this("My Frame");
   }

   public MyFrame(String title) {
      super(title);
      setup();
   }
   
   public void setup() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(Options.gameSize.width, Options.gameSize.height);
      setLocation(Options.gameLocation.x, Options.gameLocation.y);
      setFocusable(true); // this is to make the KeyListener work
                           // right before you make the frame visible
                           // you will need to request focus: frameVariable.requestFocus();
      addKeyListener(this);
   }


   // These three methods are used for a KeyListener

   @Override
   public void keyTyped (KeyEvent e) {
      System.out.println(e.getKeyChar());
   }

   @Override
   public void keyPressed (KeyEvent e) {
    switch(e.getKeyCode()) {
    case KeyEvent.VK_UP:
      System.out.println("Up");
      break;
    case KeyEvent.VK_DOWN:
      System.out.println("Down");
      break;
    case KeyEvent.VK_LEFT:
        System.out.println("Left");
        break;
    case KeyEvent.VK_RIGHT:
        System.out.println("Right");
        break;

    }
      //System.out.println(e.getKeyCode());
   }

   @Override
   public void keyReleased (KeyEvent e) {
      //System.out.println(e.getKeyCode());
   }
}