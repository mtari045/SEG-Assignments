package design5;

/**
 * This class contains instances of coordinates in the polar format.
 * This class is based on the implementation of PointCP from the text book:
 * "Object Oriented Software Engineering" and is issued under the open-source
 */
public class PointCP2 extends PointCP5{


	  //Constructors ******************************************************
	
	  /**
	   * Constructs a coordinate object
	   */
	  public PointCP2(double rho, double theta){
		super(rho, theta);
	  }
	  
		//Instance methods **************************************************
		
		public double getX(){
			// Add your code here...
	
			return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
		}
		
		public double getY(){
			// Add your code here...
	
			return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
		}
		
		public double getRho(){
			// Add your code here...

			return this.xOrRho; // this line should be replaced when you add your code
		
		}
		
		public double getTheta(){
			// Add your code here...
			
			return this.yOrTheta; // this line should be replaced when you add your code
		}
	  

	@Override
	public PointCP5 convertStorageToPolar() {
		return this; 
	}
	
	
	@Override
	public PointCP5 convertStorageToCartesian() {
		PointCP5 change = new PointCP3(getX(),getY());
		return change;
	}

	/**
	* Returns information about the coordinates.
	*
	* @return A String containing information about the coordinates.
	*/
	@Override 
	public String toString()
	{
	    return "Stored as Polar [" + getRho() + "," + getTheta() + "]\n";
	}
}
