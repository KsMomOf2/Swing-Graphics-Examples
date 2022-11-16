// Mrs. Kelly

// More methods that I find useful
// These mostly deal with swing graphics and allow you to set the properties
// for each type of component consistently across your application


import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.io.File;

public class LibraryGUI {

 // Generic font 
   public static String fontName = "Serif";
   public static int fontStyle = Font.PLAIN;
   public static int fontSize = 20;
   public static Font font = new Font(fontName, fontStyle, fontSize);
   
   // Colors that will be used throughout the project

   public static Color backgroundColor = Color.BLACK,
                     labelTextColor = Color.GREEN,
                     labelBackColor = Color.YELLOW,
                     fieldTextColor = Color.BLACK,
                     fieldBackColor = Color.LIGHT_GRAY,
                     textFieldTextColor = Color.BLUE,
                     textFieldBackColor = Color.LIGHT_GRAY,
                     buttonTextColor = Color.BLACK,
                     buttonBackColor = Color.LIGHT_GRAY;

// Method that creates a label that will be used as a label (value does not change)

   public static JLabel createLabel(String text, boolean opaque) {
      JLabel label = new JLabel(text, SwingConstants.CENTER);
      label.setForeground(labelTextColor);
      label.setBackground(labelBackColor);
      label.setFont(font);
      label.setOpaque(opaque);
      return label;
   }

  // Creates a label with a different background/foreground to make it look more like a field
   public static JLabel createField(String text, boolean opaque) {
      JLabel label = new JLabel(text, SwingConstants.CENTER);
      label.setForeground(fieldTextColor);
      label.setBackground(fieldBackColor);
      label.setFont(font);
      label.setOpaque(opaque);
      return label;
   }

   // creates a text field, the size is the number of characters based on font size
   // the text is what is displayed
   
   public static JTextField createTextField(int size, String text) {
      JTextField field = new JTextField(size);
      field.setFont(font);
      field.setForeground(textFieldTextColor);
      field.setBackground(textFieldBackColor);
      field.setText(text);
      return field;
   }

   // creates a generic button
   
   public static JButton createButton(String text) {
      JButton button = new JButton(text);
      button.setFont(LibraryGUI.font);
      button.setForeground(buttonTextColor);
      button.setBackground(buttonBackColor);
      return button;  
   }
   
   // Creates a combo box of strings
   public static JComboBox<String> createComboBox(String[] items) {
      JComboBox<String> box = new JComboBox<String>();
   
      box.setBackground(Color.GREEN);
      box.setForeground(Color.BLUE);
      for (String item : items) {
         box.addItem(item);
      }
      box.setSelectedIndex(0);
   
      return box;
   } 
}