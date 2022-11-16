// Mrs. Kelly
//
// Creates a generic JFrame with a key listener sets the properties of the
// JFrame using the Options.java class, where the size and location are set

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame implements KeyListener {

private final static boolean console = true; // set to true if you want to see messages in the console

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
        // right before you make the frame visible you will need to request focus:
        // frameVariable.requestFocus();
        addKeyListener(this);
    }


    // These three methods are used for a KeyListener

    @Override public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    private void display(String keyDescription) {
        if (console) {
            System.out.println(keyDescription);
        } else {
            JOptionPane.showMessageDialog(null, keyDescription);
        }
    }


    @Override public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                display("Up");
                break;
            case KeyEvent.VK_DOWN:
                display("Down");
                break;
            case KeyEvent.VK_LEFT:
                display("Left");
                break;
            case KeyEvent.VK_RIGHT:
                display("Right");
                break;

        }
        //display(e.getKeyCode());
    }

    @Override public void keyReleased(KeyEvent e) {
        //display(e.getKeyCode());
    }
}