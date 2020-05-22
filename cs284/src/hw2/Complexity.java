package hw2;

/*
 * I pledge my honor that I have abided by the Stevens Honor System
 * Brandon Patton
 */

public class Complexity {
	
	/*
	 * method0:
	 * 	Illustrates a time complexity of O(n).
	 * 	Uses a single for loop.
	 */
	
	public void method0(int n) {   
		int counter = 0;
		for (int i = 0 ; i<n ; i++) {
			System.out.println("Operation " +counter);
			counter++;
		}
	}
	
	/*
	 * method1:
	 * 	Illustrates a time complexity of O(n^2).
	 * 	Uses two for loops.
	 */
	
	public void method1(int n) {
		int counter = 0;
		for(int i = 0; i<n ; i++) {
			for(int j = 0; j<n ; j++) {
				System.out.println("Operation " +counter);
				counter++;
			}
		}
	}
	
	/*
	 * method4:
	 * 	Illustrates a time complexity of O(n^3).
	 * 	Uses three for loops.
	 */
	
	public void method4(int n) {
		int counter = 0;
		for(int i = 0; i<n ; i++) {
			for(int j = 0; j<n ; j++) {
				for(int k = 0; k<n ; k++) {
					System.out.println("Operation " +counter);
					counter++;
				}
				
			}
		}
	}
	
	/*
	 * method2:
	 * 	Illustrates a time complexity of O(log n).
	 * 	Uses a single for loop and sets i = i * 2 at each iteration.
	 */
	
	public void method2(int n) {
		int counter = 0;
		for(int i = 1; i<n ; i *= 2) {
			System.out.println("Operation "+counter);
			counter++;
		}
	}
	
	/*
	 * method3:
	 * 	Illustrates a time complexity of O(nlog n).
	 * 	Uses a for loop and nested for loop with the structure of O(log n).
	 */
	
	public void method3(int n) {
		int counter = 0;
		for(int i = 0; i<n; i++) {
			for(i = 1; i<n; i *= 2) {
				System.out.println("Operation "+counter);
				counter++;
			}
		}
	}	
	
	/*
	 * method5:
	 * 	Illustrates a time complexity of O(log(log n)).
	 */
	public void method5(int n) {
		int counter = 0;
		for(double i = n; i > 2; i = Math.sqrt(i)) {
			System.out.println("Operation "+counter);
			counter++;
			}
		}
	
	public static void main(String[] args) {
		
	}
}
