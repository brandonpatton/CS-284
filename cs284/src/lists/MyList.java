package lists;

import java.util.Arrays;

public class MyList<E> {
	//Data Field
	final static int INITIAL_CAPACITY = 10;
	private E[] data;
	int size;
	int capacity;		//Current Capacity
	
	//Constructor
	MyList(int size){
		data = (E[]) new Object[INITIAL_CAPACITY];
		this.size = 0;
		capacity = INITIAL_CAPACITY;
	}
	
	//Methods
	
	private void enlarge_array() {
		capacity = capacity*2;
		data = Arrays.copyOf(data, capacity);
	}
	
	public boolean add(E item) {
		if (size==data.length) {
			enlarge_array();
		}
		data[size] = item;
		size++;
		return true;
	}
	
	public String toString() {
		return Arrays.toString(data);
	}
	
	public void add(int index, E item) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if (size == data.length) {
			enlarge_array();
		}
		
		for (int i = data.length; i>index; i--) {
			data[i] = data[i-1];
		}
		data[index] = item;
		size++;
	}
	
	public void remove(int index, E item) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
	}
	
	public static void main(String[] args) {
		MyList<Integer> is = new MyList<Integer>(5);
		is.add(1);
		is.add(2);
		is.add(3);
		System.out.println(is);
	}
}
