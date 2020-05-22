package shapes;

public class Fruit implements HasColor {
	//Data Fields
	private String fruitColor;
	
	//Constructor
	Fruit(String color){
		this.fruitColor = color;
	}
	
	//Methods
	public String getColor() {
		return fruitColor;
		
	}
	public void setColor(String fruitColor) {
		this.fruitColor = fruitColor;
	}
}
