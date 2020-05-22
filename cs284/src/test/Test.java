package hw1;

import static org.junit.Assert.assertEquals;

//
//CS 284A
//I pledge my honor that I have abided by the Stevens Honor System

public class BinaryNumber{
	//Data Fields
	/*
	 * 
	 */
	private int[] data;  
	
	private boolean overflow;  
	
	
	
	//Constructors
	/*
	 * 
	 */
	public BinaryNumber(int length) {
		int[] newBinaryArray = new int[length];
		data = newBinaryArray;
	}
	
	/*
	 * 
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
	 * 
	 */
	public int getLength() {
		return data.length;
	}
	
	/*
	 * 
	 */
	public int getDigit(int index) {		
		if(index < 0 || index > data.length) {
			throw new IndexOutOfBoundsException("Error: Index out of bounds.");
			
		} else {
			
			return data[index];
		}
	}
	
	/*
	 * 
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
	 * 
	 */
	public void clearOverflow() {
		overflow = false;
	}
	
	
	public static void main(String[] args) {
		
	}
}