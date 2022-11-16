// Mrs. Kelly
// A Panel that creates a way of visualizing MULTIPLE layouts
// The panel has a card layout set for its own layout
//   Then each card of the card layout has a different layout
//   All panels use the Example Panel (or ExampleScrollPane) so 
//   the only difference between them is how the layout handles adding components

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.LayoutManager;

public class LayoutsExample extends JPanel {

// Constants that are used for the Card. When using a card layout, you give each "card" a 
// name as you add it. When you want to change the top card - you use the show command
// This is done in the ChoosePanel.java file - when a JRadioButton is selected the card on
// the layout changes

    public static final String FLOW = "Flow Layout";
    public static final String CARD = "Card Layout";
    public static final String GRID = "Grid Layout";
    public static final String BOX_P = "Box Layout Vert"; // Page or vertical
    public static final String BOX_L = "Box Layout Horiz"; // Line or horizontal
    public static final String BORDER = "Border Layout";

    private CardLayout cardLayout;

    // Creates all JPanels
    public LayoutsExample() {

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Add the Example Cards ... each with a different layout
        add(new ExamplePanel(new FlowLayout()), FLOW);
        add(new ExamplePanel(new GridLayout(25, 4)), GRID); // rows, cols
        add(createBoxLayout(BoxLayout.PAGE_AXIS), BOX_P);
        add(createBoxLayout(BoxLayout.LINE_AXIS), BOX_L);
        add(createBorderLayout(), BORDER);
    }

/*
    // You can only have one constructor example at a time
    // this constructor creates scroll panes for the box layouts
    // If you want to see this how this changes things, make sure you block comment out 
    // the first constructor
    // Creates ScrollPanes for the Box Layouts

    public LayoutsExample() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        add(new ExamplePanel(new FlowLayout()), FLOW);
        add(new ExamplePanel(new GridLayout(25, 4)), GRID); // rows, cols
        add(createScrollingBoxLayout(BoxLayout.PAGE_AXIS), BOX_P);
        add(createScrollingBoxLayout(BoxLayout.LINE_AXIS), BOX_L);
        add(createBorderLayout(), BORDER);
    }
*/


    private ExampleScrollPane createScrollingBoxLayout(int orientation) {
        ExamplePanel panel = createBoxLayout(orientation); // Creates the normal panel

        // If the panel is in the header or footer it will have a line axis setting and
        // the way border layout works, it limits the size of the panels unless you
        // change the panel size, using the setPreferredSize method. 
        // (FYI: there are also setMinimumSize and setMaximumSize methods)

        if (orientation == BoxLayout.LINE_AXIS) {
            panel.setPreferredSize(new Dimension(Options.gameSize.width, 40));
        }

        // This sends the panel into the ExampleScrollPane
        ExampleScrollPane pane = new ExampleScrollPane(panel);
        return pane;
    }

    // The box layout requires that you send in the JPanel you are applying it to,
    // so you have to create the panel first, then create the layout and then
    // apply the layout to the panel.
    // I do not know why this is ... feel free to research

    private ExamplePanel createBoxLayout(int orientation) {
        ExamplePanel panel = new ExamplePanel(null);
        LayoutManager layout = new BoxLayout(panel, orientation);
        panel.setLayout(layout);
        return panel;
    }

    // The border layout has 5 areas (header, footer, center, left panel, right panel)
    // This method creates 5 panels and adds one to each.
    // Note that it is creating scrolling panels for the header, footer, left and right panels

    private JPanel createBorderLayout() {
        JPanel panel = new JPanel(new BorderLayout(10, 20));
        panel.add(
            createScrollingBoxLayout(BoxLayout.LINE_AXIS),
            BorderLayout.PAGE_START
        ); // header
        panel.add(
            createScrollingBoxLayout(BoxLayout.PAGE_AXIS),
            BorderLayout.LINE_START
        ); // left side panel
        panel.add(new ExamplePanel(new BorderLayout()), BorderLayout.CENTER); // center
        panel.add(createScrollingBoxLayout(BoxLayout.PAGE_AXIS), BorderLayout.LINE_END); // right side panel
        panel.add(createScrollingBoxLayout(BoxLayout.LINE_AXIS), BorderLayout.PAGE_END); // footer
        return panel;
    }

// This is used in the ChoosePanel class to allow the 
// cards to be switched when a radio button is selected

    public CardLayout getCardLayout() {
        return cardLayout;
    }

}