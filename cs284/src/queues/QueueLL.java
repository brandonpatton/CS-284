package queues;

import java.util.NoSuchElementException;

public class QueueLL<E> {

		public class Node<E> {
			// Data fields
			private E data;
			Node<E> next;
			//Constructor
			Node(E item) {
				data=item;
				next=null;
			}
			Node(E item,Node<E> next) {
				data=item;
				this.next=next;
			}
		}
		// Data fields
		Node<E> front;
		Node<E> rear;
		int size=0;
		
		// Constructor
		QueueLL() {
			front=null;
			rear=null;
			size=0;
		}
		
		// Methods
		public E element() {
			// IllegalStateException
			if (front == null) {
				throw new NoSuchElementException();
			}
			return front.data;
		}
		
		public boolean offer(E item) {
			if (front == null) {
				front = new Node<E>(item);
				rear = front;
			} else {
				rear.next = new Node<E>(item);
				rear = rear.next;
			}
			size++;
			return true;
		}
		
		public E remove() {
			if (front == null) {
				throw new NoSuchElementException();
			} else {
				E temp = front.data;
				front = front.next;
				if(front == null) {
					rear = null;
				}
				size--;
				return temp;
			}
		}
		
		public E remove2() {
			if(front == null) { //the queue is empty
				throw new NoSuchElementException();
			}
			if(front == rear) { //the queue is a singleton queue
				E temp = front.data;
				front = null;
				rear = null;
				size = 0;
				return temp;
			}
			//the queue has two or more items
			
			Node<E> current = rear;
			while(current.next!=front) {
				current = current.next;
			}
			E temp = front.data;
			current.next = null;
			front = current;
			size--;
			return temp;
			
		}
		public E poll() {
			return null;
		}
		
		public int size() {
			return size;
			
		}
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append("<");
			Node<E> current = front;
			
			while (current != null) {
				s.append(current.data);
				current = current.next;
			}
			
			return s.toString();
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
		
