package design2;
/**
 * This class contains instances of coordinates in the polar format.
 * This class is based on the implementation of PointCP from the text book:
 * "Object Oriented Software Engineering" and is issued under the open-source
 */
public class PointCP2 {
	//Instance variables ************************************************
	/**
	* Contains the current value of RHO
	*/
	private double rho;
	/**
	* Contains the current value of THETA 
	*/
	private double theta;

	//Constructors ******************************************************
	/**
	* Constructs a polar coordinate object
	*/
	public PointCP2(double rho, double theta){
		this.rho = rho;
		this.theta = theta;
	}
	
	//Instance methods **************************************************

	public double getX(){
		
	    return (Math.cos(Math.toRadians(theta)) * rho); 
	}
	
	public double getY(){
		
		return (Math.sin(Math.toRadians(theta)) * rho); 
	}
	
	public double getRho(){
		// Add your code here...
		return rho; 
	
	}
	
	public double getTheta(){
		// Add your code here...
		return theta; 
	}
	
	/**
	* Calculates the distance in between two polar points using the Pythagorean
	* theorem  (C ^ 2 = A ^ 2 + B ^ 2). 
	* IMPORTANT: This method does not have to be implemented for designs 2,3, and 4
	*
	* @param pointA The first point.
	* @param pointB The second point.
	* @return The distance between the two points.
	*/
	public double getDistance(PointCP2 pointB){
		// Add your code here...
	
		double diffX = getX()- pointB.getX();
		double diffY = getY() - pointB.getY();
	
		return Math.sqrt((Math.pow(diffX, 2) + Math.pow(diffY, 2)));
	}

	/**
	* Returns information about the coordinates.
	*
	* @return A String containing information about the coordinates.
	*/
	public String toString(){
		return "Stored as Polar [" + getRho() + "," + getTheta() + "]\n";
	}
}

