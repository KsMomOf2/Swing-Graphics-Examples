// Mrs. Kelly - An example of how to use basic Swing Graphics

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Game {

    private JLabel txtScore, txtTime;   // Labels to display the score and time
    private int score,time;             // variables to keep track of the score and time
    private Timer timer;                // Timer to allow the time to count down
    
    public Game(String title) {

        time = Options.gameTime;            // set the amount of seconds (located in the Options.java class)
        MyFrame frame = new MyFrame(title);        // create the JFrame using the MyFrame class, which sets the properties

        createTimer(1000);                  // create the timer, but do not start it

        frame.add(createHeader(), BorderLayout.PAGE_START); // Add the header panel
        frame.add(createFooter(frame), BorderLayout.PAGE_END);   // Add the footer panel
        LayoutsExample layoutsExample = new LayoutsExample();
        frame.add(layoutsExample);                          // add a panel that is the LayoutsExample
        frame.add(new ChoosePanel(layoutsExample), BorderLayout.LINE_END); // add the Choose panel to the side
        frame.setVisible(true);                             // make the frame visible
        frame.requestFocus(); // this allows the key listener to work
    }

    // Header Panel

    private JPanel createHeader() {
        JPanel panel = new JPanel(); // create a panel that you will eventually return

        panel.setBackground(Color.BLACK); // set the background color
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS)); // set the layout into a horizontal layout
        panel.add(Box.createHorizontalGlue()); // Helps center the components on the panel in the box layout
        
        panel.add(LibraryGUI.createLabel("Time Left", false)); // create and add a label for Time
        panel.add(Box.createRigidArea(new Dimension(25, 10))); // add a space

        txtTime = LibraryGUI.createField("" + Options.gameTime, true); // create the txtTime label
        panel.add(txtTime); // add label to the header panel
        panel.add(Box.createRigidArea(new Dimension(250, 10))); // add a space

        panel.add(LibraryGUI.createLabel("Score", false)); // create and add a label for the Score
        panel.add(Box.createRigidArea(new Dimension(25, 10))); // add a space

        txtScore = LibraryGUI.createField("0", true); // create the txtScore label
        panel.add(txtScore); // add label to the header panel
        panel.add(Box.createHorizontalGlue()); // Helps center the components on the panel

        return panel; // return panel to the calling method, where it will get added to the frame
    }

    // Main Panel Footer Panel

    private JPanel createFooter(MyFrame frame) {
        JPanel panel = new JPanel(); // create the Panel
        panel.setBackground(Color.BLUE); // set the background color
        JButton button = LibraryGUI.createButton("Start Timer"); // create a button

// Create the action that will happen when the button is clicked on
        button.addActionListener(
            new ActionListener() { // create and add an ActionListener to the button
                @Override //      so that the button can react to clicks
                public void actionPerformed(ActionEvent e) {
                    score += 1; // increment the score
                    txtScore.setText("" + score); // display the new score

                    // start and stop the timer and change the buttons label
                    switch (button.getText()) { // get the text from the button and change it
                        case "Start Timer":
                            button.setText("Stop Timer");
                            timer.start();
                            break;
                        case "Stop Timer":
                            button.setText("Start Timer");
                            timer.stop();
                            break;
                    }
                }
            }
        );

        panel.add(button);                  // add the button to the panel
        
        
        // create button to return focus to JFrame, so key listener will fire
        
        JButton button2 = LibraryGUI.createButton("Keys");
        button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          frame.requestFocus();
        }
        });
        
        panel.add(button2);
        
        return panel;                       // return the panel to the calling method where it is added to the frame
    }

    // TIMER

    // create and return a timer
    private void createTimer(int ms) {
        timer = new Timer(ms, new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                time--;                         // decrement the time
                if (time < 0) {                 // if time < 0, stop the timer and change time to 0
                    time = 0;
                    timer.stop();
                }
                txtTime.setText("" + time);     // display the new time
            }
        });

    }

    public static void main(String[] args) {
        // Create the game
        new Game("Demonstration of Swing Graphics");
    }

}
