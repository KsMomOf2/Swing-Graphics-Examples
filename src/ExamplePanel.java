// Mrs. Kelly
// A JPanel with a random color and a bunch of buttons on it
// The buttons are capable of displaying stored information, to include their name
// You are required to send in (or set later) the layout of the JPanel
// This class demonstrates how different layouts impact alignment of components
// What happens when you resize the JFrame with different layouts showing

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExamplePanel extends JPanel {

    public ExamplePanel(LayoutManager layout) {
        setBackground(Library.getRandomColor());    // Set the background color
        setLayout(layout);                          // Set the layout
        addButtons(100);                            // Add Buttons
    }

    private void addButtons(int numButtons) {       // adds the specified number of buttons
        for (int i = 1; i <= numButtons; i++) {
            add(createButton(i));
        }
    }

// Creates a button with the following properties:
//          the text of the button is set to the number sent in:  for example, "Button   1" 
//          it demonstrates that you can use a thing called an Action Command to store information and 
//                        retrieve it in the action listener for when the button is clicked
//          an action listener that displays the button text, action command, and layout the button is on
    private JButton createButton(int num) {        
        JButton button = new JButton("Button" + String.format("%3d", num));
        button.setActionCommand("Info for Button " + num); // buttons can store information for later
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (! (e.getSource() instanceof JButton)) return; // if the action was not a click on a button return
                JButton b = (JButton) e.getSource();    // get the precise button clicked on
                // Display the text on the button,any stored info, and
                //                     the layoutname of the layout the button is on
                // if you have stored information in the action command you can retrieve it
                // with b.getActionCommand()
                JOptionPane.showMessageDialog(null, b.getText() + 
                                            "\n" + b.getActionCommand() +
                                            "\n" + getLayoutName());
            }
        });
        return button;
    }

// Gets the toString representation of the layout and then manipulates it
// to get a shortened version of the layout name

    private String getLayoutName() {
        String strLayout = getLayout().toString();
        int bracketLocation = strLayout.indexOf("[");
        int firstDot = strLayout.indexOf(".");
        int secondDot = strLayout.indexOf(".", firstDot+1);
        if (bracketLocation == -1) { // BoxLayout does not have a [, it has an @, and it is javax.swing
          bracketLocation = strLayout.indexOf("@");
          }
        return strLayout.substring(secondDot+1,bracketLocation);
    }
}