package design5;

/**
 * This class contains instances of coordinates in the polar format.
 * This class is based on the implementation of PointCP from the text book:
 * "Object Oriented Software Engineering" and is issued under the open-source
 */
public class PointCP3 extends PointCP5 {
	//Constructors ******************************************************

	/**
	* Constructs a coordinate object, with a type identifier.
	*/
	public PointCP3(double x, double y)
	{
		  super(x,y);
	}
		
	//Instance methods **************************************************
	
	public double getX(){
		// Add your code here...
		
		return this.xOrRho; // this line should be replaced when you add your code
	}
	public double getY(){
		// Add your code here...
		
		return this.yOrTheta; // this line should be replaced when you add your code
	}
	public double getRho(){
		// Add your code here...
		return (Math.sqrt(Math.pow(this.xOrRho, 2) + Math.pow(this.yOrTheta, 2)));
	
	}
	public double getTheta(){
		// Add your code here...
		return Math.toDegrees(Math.atan2(this.yOrTheta, this.xOrRho));
	}	
	@Override
	public PointCP5 convertStorageToPolar() {
		PointCP5 convert = new PointCP2(getRho(),getTheta());
		return convert;
	}
	
	@Override
	public PointCP5 convertStorageToCartesian() {
		return this;
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
