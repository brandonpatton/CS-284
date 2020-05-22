package hw1;


//Brandon Patton
//CS 284A
//I pledge my honor that I have abided by the Stevens Honor System

public class BinaryNumber{
	//Data Fields
	/*
	 * private int data[];:
	 * 		This is the binary number
	 * 
	 * private boolean overflow;:
	 * 		This is the field that handles the overflow for carries in binary addition
	 */
	private int data[];  
	
	private boolean overflow;  
	
	
	
	//Constructors
	/*
	 * BinaryNumber(int length):
	 * 		Creates a binary number of length "length" and consists of only zeros.
	 */
	public BinaryNumber(int length) {
		int[] newBinaryArray = new int[length];
		data = newBinaryArray;
	}
	
	/*
	 * BinaryNumber(String str):
	 * 		Creates a binary number given a string.
	 */	
	public BinaryNumber(String str) {
		int[] newBinaryArray = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			newBinaryArray[i] = java.lang.Character.getNumericValue(str.charAt(i));
		}
		data = newBinaryArray;
	}
	
	
	
	//Methods
	
	/*
	 * getLength():
	 * 		Determines the length of a binary number.
	 */
	public int getLength() {
		return data.length;
	}
	
	/*
	 * getDigit(int index):
	 * 		Obtains the digit of a binary number given an index.
	 * 		The starting index given is 0.
	 * 		If the index is out of bounds, a message will be printed on screen.
	 */
	public int getDigit(int index) {		
		if(index < 0 || index > data.length) {
			throw new IndexOutOfBoundsException("Error: Index out of bounds.");
			
		} else {
			
			return data[index];
		}
	}
	
	/*
	 * shiftR(int amount):
	 * 		Shifts all digits in a binary number any number of places to the right, as indicated by
	 * 		a parameter "amountToShift."
	 * 		The new digit(s) as a result of the shift is/are 0.
	 *
	 */
	public void shiftR(int amount) {
		BinaryNumber amountToShift = new BinaryNumber(data.length + amount);
		for (int i = amount; i < amountToShift.getLength(); i++) {
			amountToShift.data[i] = data[i-amount];			
		}
		data = amountToShift.data;
	}
	
	/*
	 * add(BinaryNumber aBinaryNumber):
	 * 		Adds two binary numbers. One of the numbers receives the message and the other
	 * 		is given as a parameter.
	 * 		If the lengths of the two binary numbers do not coincide, then a message is printed on the
	 * 		screen indicating that the two numbers are not the same length.
	 * 		
	 * 		Modifies the receiving binary number with the result of the addition.
	 * 
	 */
	public void add(BinaryNumber aBinaryNumber) {
		BinaryNumber sum = new BinaryNumber(this.getLength() + 1);
		if(data.length != aBinaryNumber.getLength()) {
			System.out.println("Error: Binary Numbers entered are not the same length.");
			throw new ArrayIndexOutOfBoundsException();
		} else {
		if(this.data.length == aBinaryNumber.data.length) {
			for(int i = 0; i < data.length; i++) {
				if(this.data[i] == 1 && aBinaryNumber.data[i] == 1 && sum.overflow == true) {
					sum.data[i] = 1;
					sum.overflow = true;
				}
				else if(this.data[i] == 1 && aBinaryNumber.data[i] == 1 && sum.overflow == false) {
					sum.data[i] = 0;
					sum.overflow = true;
				}
				else if(this.data[i] != aBinaryNumber.data[i] && sum.overflow == true) {
					sum.data[i] = 0;
					sum.overflow = true;
				}
				else if(this.data[i] != aBinaryNumber.data[i] && sum.overflow == false) {
					sum.data[i] = 1;
				}
				else if(this.data[i] == 0 && aBinaryNumber.data[i] == 0 && sum.overflow == false) {
					sum.data[i] = 0;
				}
				else {
					sum.data[i] = 1;
					sum.overflow = false;
				}
			}
			if(sum.overflow == true) {
				sum.data[this.getLength()] = 1;
				this.overflow = true;
			}
			else {
			}
			this.data = sum.data;
		}
		}
		}
	
	/*
	 * String toString():
	 * 		Transforms the binary number to a String.
	 * 
	 * 		If the number is the result of an overflow, the string "Overflow" is returned.
	 */
	public String toString() {
		if (overflow == true) {
			return "Overflow";
		}
		else { 
			String binaryString = "";
			for (int i = 0; i < data.length; i++) {
				binaryString += data[i];
			}
			return binaryString;
			}
		}
	
	/*
	 * toDecimal():
	 * 		Transforms a binary number to its decimal notation.
	 */
	public int toDecimal(){
		int decimal = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i]==1) {
				decimal += Math.pow(2, i);
			}
		}
		return decimal;
	}
	
	/*
	 * clearOverflow():
	 * 		Clears the overflow flag.
	 */
	public void clearOverflow() {
		overflow = false;
	}
	
	
	public static void main(String[] args) {
		BinaryNumber b1 = new BinaryNumber("101");
		BinaryNumber b2 = new BinaryNumber("010");
		b1.add(b2);
		System.out.println(b1);
		b1.shiftR(3);
		System.out.println(b1);
	}
}