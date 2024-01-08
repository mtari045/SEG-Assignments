package design2;
// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
import java.util.Scanner;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 */
public class PointCP2Test {
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP2
   * object.  The  program prompts the user to enter the coordinate 
   * type and  values.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompt them to correct their inputs.
   */
  public static void main(String[] args){
    PointCP2 point;

    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Call the method that prompts the user for inputs
    point = getInput();
		

	System.out.println("\nYou entered:\n" + point);
	
	// Notice that we are not converting storage here as this design only supports polar points

  }

  
  
  
  
  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP2
   * object.
   *
   * @return A PointCP2 constructed using information obtained 
   *         from the user.
   */
  private static PointCP2 getInput () {
	  
	  Scanner scanner = new Scanner(System.in);
	  
	  String input;

	  double a = 0.0;
	  double b = 0.0;
	  
  
	  
	  // Read the first coordinate
	  boolean readOk = false; // flag that indicates whether the coordinate value is valid
	  
	  while (!readOk) {
	  
		  System.out.print("Enter the value of Rho using a decimal point(.)");
		  

		  input = scanner.next();
		  
		  try {
		  
			  a = Double.valueOf(input).doubleValue();
			  readOk = true;
		  }
		  catch (NumberFormatException e){
			  readOk = false;
			  System.out.println("Inorrect input. Please enter a valid decimal number.");
		  }
	  
	  }
	  
	  // Read the second coordinate
	  readOk = false; // reset the flag
	  while (!readOk) {
		  
		  System.out.print("Enter the value of Theta using a decimal point(.)");
		  
		  
		  input = scanner.next();
		  
		  try {
		  
			  b = Double.valueOf(input).doubleValue();
			  readOk = true;
		  }
		  catch (NumberFormatException e){
			  readOk = false;
			  System.out.println("Inorrect input. Please enter a valid decimal number.");
		  }
	  
	  }
	  
	  scanner.close(); // close the scanner
	  
	  
	  //Return a new PointCP2 object
	  return (new PointCP2(a, b));
  }
  
}
