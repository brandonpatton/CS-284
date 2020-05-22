package shapes;

public abstract class Shape implements HasColor{
// Data field
	protected String color;
	
	Shape (String color){
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	/** Operation **must** be implemented in subclasses
	 * 
	 */
	public abstract double area();
	
	public String toString() {
		return "color: " + color;
	}
}
