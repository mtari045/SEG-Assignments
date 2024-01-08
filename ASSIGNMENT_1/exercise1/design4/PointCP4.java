package design4;
// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 


/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 */
public class PointCP4 {
	//Instance variables ************************************************
	/**
	* Contains the current value of X 
	*/
	private double x;
	
	/**
	* Contains the current value of Y
	*/
	private double y;
	
	/**
	* Contains the current value of rho 
	*/
	private double rho;
	
	/**
	* Contains the current value of theta
	*/
	private double theta;	
	
	//Constructors ******************************************************
	
	/**
	* Constructs a coordinate object
	*/
	public PointCP4(double x, double y, double rho, double theta){
	
	this.x = x;
	this.y = y;
	this.rho = rho;
	this.theta = theta;
	
	}
		
	//Instance methods **************************************************
	
	public double getX(){
		// Add your code here...
		
		return x; 
	}
	
	public double getY(){
		// Add your code here...
		
		return y; 
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
	* Calculates the distance in between two points using the Pythagorean
	* theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	* IMPORTANT: This method does not have to be implemented for designs 2,3, and 4
	* 
	* @param pointA The first point.
	* @param pointB The second point.
	* @return The distance between the two points.
	*/
	public double getDistance(PointCP4 pointB){
		// Add your code here...
		double diffX = getX() - pointB.getX();
        double diffY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(diffX, 2) + Math.pow(diffY, 2)));
	}
	
	
	/**
	* Returns information about the coordinates.
	*
	* @return A String containing information about the coordinates.
	*/
	public String toString(){
		return "Cartesian  (" + getX() + "," + getY() + ") and Polar [" + getRho() + "," + getTheta() + "]\n";
	}
}
