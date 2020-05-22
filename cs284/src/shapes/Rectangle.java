package shapes;
/** The class rectangle models rectangles in Java
 * 
 * @author bpatton
 *
 */

public class Rectangle extends Shape {
	//Data fields
	private double base;
	private double height;
	// Static or class variables
	public static int noOfRectangles = 0;
			
	// Constructors		
	Rectangle (double b, double h, String c) {
		super(c); // Super class's constructor
		base = b; // "Its own stuff"
		height = h;
		noOfRectangles++;
	}
	
	// Methods
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double h) {
		this.height = h;
	}
	
	public void setBase(double b) {
		this.base = b;
	}
	/**area calculates the area of a rectangle
	 * 
	 * @return returns the area of the rectangle
	 */
	public double area() {
		return base * height;
	}
	
	public Pair<Double,Double> getBaseHeight() {
		return new Pair<Double,Double>(base, height);
	}
	
	public Pair<Double,String> getBaseColor() {
		return new Pair<Double,String>(base, color);
	}
	/** This method returns a string representation of rectangles
	 * 
	 */
	public String toString() {
		return "base: " + base + ", height: " + height + ", color: " + color;
	}
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(0.0, 0.0, "blue");
		Rectangle r2 = new Rectangle(2.7, 4.5, "red");
		r.setBase(2.4);
		r2.setHeight(3.4);
		r.setColor("green");
		System.out.println(r.getBase());
		System.out.println("The area of r is " + r.area());
		System.out.println("The area of r2 is " + r2.area());
		System.out.println(r);
		System.out.println(Rectangle.noOfRectangles);
	}
	
	}

