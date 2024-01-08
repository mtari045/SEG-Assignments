package design5;
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
public abstract class PointCP5Test {
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP
   * object.  The  program prompts the user to enter the coordinate 
   * type and  values.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompt them to correct their inputs.
   */
  public static void main(String[] args)
  {
    PointCP5 point;
    PointCP5 newPoint;
    
    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Call the method that prompts the user for inputs
    point = getInput();
		

    System.out.println("\nYou entered:\n" + point);
    newPoint = point.convertStorageToCartesian();
    System.out.println("\nAfter asking to store as Cartesian:\n" + newPoint);
    newPoint = point.convertStorageToPolar();
    System.out.println("\nAfter asking to store as Polar:\n" + newPoint);
  }

  
  
  
  
  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP5
   * object.
   *
   * @return A PointCP5 constructed using information obtained 
   *         from the user.
   */
  private static PointCP5 getInput () {
	  
	  Scanner scanner = new Scanner(System.in);
  
	  char coordType='A';
	  String input;

	double a = 0.0;
	double b = 0.0;
  
  
  
	// Read the coordinates type
  
	do {
  
		System.out.print("Enter the type of Coordinates you "
				+ "are inputting ((C)artesian / (P)olar): ");
  
  
		// Read from console
		input = scanner.nextLine();
  
		// Set to upper case in case the user enter a lowercase character 
		input = input.toUpperCase();
 
		if (input.charAt(0)=='C')
			coordType = 'C'; // Temporary default, to be set to P or C
		else if (input.charAt(0)=='P')
			coordType = 'P';
		else
			System.out.println("Inorrect input. Please enter the letter 'C' or 'P'.");
  
	}
	while (coordType=='A');
  
  
	// Read the first coordinate
	boolean readOk = false; // flag that indicates whether the coordinate value is valid
  
	while (!readOk) {
  
		System.out.print("Enter the value of " 
				+ (coordType == 'C' ?  "X " : "Rho ") 
				+ "using a decimal point(.): ");
  

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
	  
		System.out.print("Enter the value of " 
				+ (coordType == 'C' ?  "Y " : "Theta ") 
				+ "using a decimal point(.): ");
  
  
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
  
  
	//Return a new PointCP2 or PointCP3 object
	PointCP5 point;

	if (coordType == 'P') {
		point = new PointCP2(a,b);
	}
	else {
		point = new PointCP3(a,b);
	}
	
	return point;
  }
  
}
