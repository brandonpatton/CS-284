package person;
/**
 * This class is for creating persons
 * @author bpatton
 *
 */

public class Person {
	//Attributes
	private String name;
	private int age;
	private String address;
	//private boolean adult;
	
	//Constructor
	/**
	 * This method creates a new person with the given name, age, and address
	 * @param name The name
	 * @param age The age
	 * @param address The address
	 */
	Person (String name, int age, String address){
		this.name = name;
		this.age = age;
		this.address = address;
	}
	//Methods
	/**
	 * This method returns the name of the person
	 * @return The name
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method sets the name of the person
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCredentials() {
		return "My name is " + name + ", I am " + age + " years old, and I live in " + address + ".";	
	}
	
	//Main Method
	public static void main(String[] args) {
		Person p1 = new Person("Bob", 42, "New Jersey");
		//Person p2 = new Person("Joe", 36, "New York");
		System.out.println("Person 1's name is " + p1.getName());
		System.out.println(p1.getCredentials());
		//System.out.println("Person 1 is " + p2.getAge());
		//System.out.println(p1.getName() + " live in " + p1.getAddres());
	}
	
	
}










