package shapes;

public class Triangle extends Shape{
// Data fields
	public double base;
	public double height;
	
	// Constructor
	Triangle (double base, double height){
		this.base = base;
		this.height = height;
		this.color = "blue";
	}
	
	public void setHeight(double h) {
		this.height = h;
	}

	public void setBase(double b) {
		this.base = b;
	}

	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
	
}
