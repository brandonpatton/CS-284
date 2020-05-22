package Maze;

public class PairInt {
	//Data Fields
	private int x;
	private int y;
	
	public PairInt(int x, int y) {
		//Constructor
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/*
	 * public boolean equals(Object p):
	 * 		Returns true if the object taken in is equal to the object calling it.
	 */
	public boolean equals(Object p) {
		if(!(p instanceof PairInt)){
			return false;
		}
		else{
			PairInt P = (PairInt)p;
			return P.x == this.x && P.y ==this.y;
		}
		
	}
	
	public String toString() {
		return "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
	}
	
	/*
	 * public PairInt copy():
	 * 		Returns a new copy of PairInt.
	 */
	public PairInt copy() {
		PairInt answer = new PairInt(x,y);
		return answer;
	}
}
