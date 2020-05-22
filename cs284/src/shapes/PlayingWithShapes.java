package shapes;

import java.util.Arrays;

public class PlayingWithShapes {
	
	public static void myPrint(Shape s) {
		System.out.println(s);
		// By making the parameter Shape, anything that is a shape can be applied
		// Don't need toString() after the s in line 6 because java calls it automatically
		// Run-time type of "s" in line 6 is dependent on the type of object calling the method
	}
	
	public static String[] colors(HasColor[] ss) {
		String[] res = new String[ss.length];
		int i = 0;
		for (HasColor s:ss) {
			res[i] = s.getColor();
			i++;
		}
		return res;
	}
	public static void main(String[] args) {
		Rectangle r = new Rectangle(3.4, 4.3, "blue");
		Rectangle r2 = new Rectangle(3.4, 4.3, "blue2");
		Rectangle r3 = new Rectangle(3.4, 4.3, "blue3");
		Circle c = new Circle(2.4, "red");
		// Shape s = new Shape("green"); becomes invalid because shape is abstract, so it's a different type of object
		
		Shape[] rs = new Shape [3];
		
		rs[0] = r;
		rs[1] = r2;
		rs[2] = c;
		
		
		for (Shape aShape:rs) {
			System.out.println(aShape.area()); // Line will automatically call toString()
			// Can't write System.out.println(aShape.area()) because the type has only been decided to be shape.
			// No guarantee that the shape has an area method
			// Shape Class given area method
			// Now that shape class has area operation, it will run
			// Changing shape to abstract means the class is for collective behavior
			// System.out.println(aShape.area()) will work because shape's area method is now abstract and is implemented in circle and rectangle
			} 
		Fruit[] fs = new Fruit[3];
		fs[0] = new Fruit("yellow");
		fs[1] = new Fruit("orange");
		fs[2] = new Fruit("maroon");
		fs[3] = new Fruit("zeal");
		
		System.out.println(Arrays.toString(colors(rs)));
		System.out.println(Arrays.toString(colors(fs)));
		System.out.print(r.getBaseHeight());
		
		
	//	myPrint(r);
	//	myPrint(c);
	//	myPrint(s);
		
	/** 
	 * 1. Subtype polymorphism: whenever a method or content expects a value of class C, you may supply a value of class D, for D a subclass of C.
	 * 2. Dynamic method dispatch: The process of establsihing the code that is to be executed in response to a message.
	 * 		o.methodName(arg1,...,argn)   This process takes place at run-time.
	 * 3. Abstract classes: Classes that collect common behavior and are not meant to be instantiated.
	 */
	}

}
