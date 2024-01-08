package design3;

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 */
public class PointCP3 {
	//Instance variables ************************************************
	/**
	* Contains the current value of X
	*/
	private double x;
	/**
	* Contains the current value of Y
	*/
	private double y;
		
	//Constructors ******************************************************
	
	/**
	* Constructs a cartesian coordinate object
	*/
	public PointCP3(double x, double y){
		this.x = x;
		this.y = y;
	}	
	
	//Instance methods **************************************************
	
	public double getX(){
		
		return x; // this line should be replaced when you add your code
	}
	
	public double getY(){
	
		return y; // this line should be replaced when you add your code
	}
	
	public double getRho(){
		return Math.sqrt(x * x + y * y); 
	}  
	
	
	public double getTheta(){
		// atan2= returns the angle theta: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
		return Math.atan2(y, x); // this line should be replaced when you add your code
	}
	
	
	/**
	* Returns information about the coordinates.
	*
	* @return A String containing information about the coordinates.
	*/
	public String toString(){
		return "Stored as Cartesian (" + getX() + "," + getY() + ")\n";
	}
}
