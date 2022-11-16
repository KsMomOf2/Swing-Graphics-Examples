// Mrs. Kelly 

// Sets up a JPanel with a button group of radio buttons Includes the
// item listener so that when a button is selected an action is taken - for this
// example a card in the card layout is changed

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ChoosePanel extends JPanel {

    private CardLayout cardLayout;
    private LayoutsExample panel;

    public ChoosePanel(LayoutsExample panel) {
        this.cardLayout = panel.getCardLayout();        // save these values so that the ItemListener can use them 
        this.panel = panel;                             // when an item is selected

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));    // Use a vertical box layout
        setBackground(Color.LIGHT_GRAY);                        // Always use a Light Gray background

        ButtonGroup group = new ButtonGroup();              // The button group handles only allowing one radio button
                                                            // to be selected at a time

        // These method calls create the radio buttons - the 
        // constant from the Layotus Example class is sent in for the text
        // of the radio button and the group is sent in so all the buttons are added

        createRadioButton(LayoutsExample.FLOW, group);
        createRadioButton(LayoutsExample.GRID, group);
        createRadioButton(LayoutsExample.BOX_P, group);
        createRadioButton(LayoutsExample.BOX_L, group);
        createRadioButton(LayoutsExample.BORDER, group);
    }

//  Takes in the text for the radio button and the group to add the button to
// it creates the radio button and adds it to that group and to the panel
// it also creates the item listener to associate with the radio button -
// the item listener changes the card on the main screen to the selected card with that layout

    private void createRadioButton(String name, ButtonGroup group) {

        JRadioButton button = new JRadioButton(name);   // create the radio button

        if (name.equals(LayoutsExample.FLOW)) {         // If it is the FLow button, set selected to true
            button.setSelected(true);
        }
        button.addItemListener(new ItemListener() { // create and add the item listener
            @Override public void itemStateChanged(ItemEvent e) {
                cardLayout.show(panel, name);       // This uses the fields cardLayout and panel - to show
                                                // the correct panel. The name is the name of the card and also
                                                // doubles as the text of the radio button
            }
        });
        group.add(button);                  // add the button to the group
        add(button);                        // add the button to the panel
    }

}