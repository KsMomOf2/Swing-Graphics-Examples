// Mrs. Kelly

// Several useful methods that I often need

import java.awt.Color;

public class Library {

// An array of colors, so I can choose a random color
   public static final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, 
                                      Color.MAGENTA, Color.ORANGE, Color.CYAN};

  // Returns a random number that is at most upper - 1 (it is between 0 and upper - 1)                                    
   public static int getRandom(int upper) {
      return getRandom(0, upper - 1);
   }

// returns an integer between lower and upper. If you send in upper < lower, you get an error

   public static int getRandom(int lower, int upper) {
      if (lower > upper) throw new IllegalArgumentException();
   
      return (int) (Math.random() * (upper - lower + 1) + lower);
   }

// can return a positive or a negative number between lower and upper and -upper and -lower
// if disjointed is false, it just returns a positive integer between lower and upper

   public static int getRandom(int lower, int upper, boolean disjointed) {
   
   // if lower < 0 and upper > 0 and disjointed then return a number
   // from -upper to -lower OR lower to upper, but not between
   // -lower to lower
   
      if (!(lower < upper)) 
         throw new IllegalArgumentException(String.format("getRandom(%d, %d, %b)", lower, upper, disjointed));
      
      if (disjointed) 
         if (getRandom(2) == 0) // if random returns 0 return a negative number, otherwise a positive
            return getRandom(-upper, -lower);
         else
            return getRandom(lower, upper);
      else                          // if not disjointed, then just return a positive number
         return getRandom(lower, upper);
   }

// return a random color from the color array

   public static Color getRandomColor() {
      int c = getRandom(colors.length);
      return colors[c];
   }
}