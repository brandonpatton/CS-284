package queues;

import java.util.NoSuchElementException;

import queues.QueueLL.Node;

public class QueueC {
	//Data Fields
	private E[] data;
	private int front;
	private int rear;
	private int capacity;
	private int size;
	private static final int INITIAL_CAPACITY = 10;
	
	//Constructor
	QueueC(){
		data = (E[]) new Object[INITIAL_CAPACITY];
		capacity = INITIAL_CAPACITY;
		front = 0;
		rear = capacity - 1;
		size = 0;
	}
	//Methods
	public E element() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			return data[front];
		}
		
	}
	
	public void resize() {
		
	}
	
	public boolean offer(E item) {
		if (size == capacity) {
			resize();
		}
	}
	
	public E remove() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			E temp = data[front];
			front = (front + 1) % capacity;
			return temp;
		}
	}
	
	public E poll() {
		return null;
	}
	
	public int size() {
		return size;
		
	}
	public String toString() {
		
	}
	
	public static void main(String[] args) {
		QueueLL<Integer> q = new QueueLL<Integer>();
		
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		System.out.println(q);
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		q.offer(4);
		System.out.println(q);
	}
}
	

