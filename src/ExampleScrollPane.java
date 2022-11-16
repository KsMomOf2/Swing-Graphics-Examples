// Mrs. Kelly
// A very simple class to demonstrate how to allow scrolling of your JPanel
// This is actually a really powerful tool, but this just demonstrates that it is possible

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ExampleScrollPane extends JScrollPane {
 
 // Create the JScrollPane and add the JPanel to it
 
    public ExampleScrollPane(JPanel panel) {
        getViewport().add(panel);
    }
}