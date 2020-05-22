package recitation;

public class SortedList<E extends Comparable<E>> {
	private Node<E> head;
	private int size;
	
	private static class Node<E> {
		private E data;
		private Node<E> next;
		
	/**
	 * Constructor for Node<E>
	 * @param data - the value of the new data.
	 */
		
		public Node(E data) {
			if(data == null) {
				throw new IllegalArgumentException();
			}
			this.data = data;
			this.next = null;
		}
	}
	/**
	 * Constructor for Sorted List
	 */
	public SortedList() {
		this.head = null;
		this.size = 0;
	}
	
	/**
	 * Getter method for the size of the SortedList
	 * @return integer for the size of the List.
	 */
	public int size() {
		return this.size;
	}
	
	
	public boolean add(E elem) {
		if (elem == null) {
			throw new IllegalArgumentException();
		}
		Node<E> newNode = new Node<E>(elem);
		Node<E> prev = null;
		Node<E> current = head;
		
		while(current != null) {
			if (elem.compareTo(current.data) > 0) {
				//elem > current.data
				//move on
				prev = current;
				current = current.next;
			}
			else {
				//elem < current.data
				break;
			}
		}
		if (prev == null) {
			Node<E> oldHead = head;
			head = newNode;
			head.next = oldHead;
		}
		else {
			//prev != null
			prev.next = newNode;
			newNode.next = current;
		}
		size++;
		return true;
	}
	public E get(int index) {
		//TODO: Get item using the index. Ie: index = 3 => get data of the 4th node.
		for(int i = 0; i < index; i++) {
			if (head != null) {
				head = head.next;
			}
			else {
				return null;
			}
		}
		return head.next.data;
	}
	public E getLast() {
		//TODO: Get the element of the last node.
		while (head.next != null) {
			head = head.next;
		}
		return head.data;
	}
	public E remove(int index) {
		//TODO: Remove the node at the index-th index.
		Node<E> current = head;
		for(int i = 0; i < index; i ++) {
			if(current != null) {
				current = current.next;
			}
			else {
				return null;
			}
		}
		E data = current.next.data;
		current.next = current.next.next;
		size--;
		return data;
	}
	public Node<E> removeAdjacentDuplicates(Node<E> lst) {
		//TODO: Remove all adjacent Duplicats
		Node<E> current = head;
		while(current.next != null) {
			if(current.data.compareTo(current.next.data) == 0) {
				current.next = current.next.next;
				continue;
			}
			current = current.next;
		}
		return head;
	}
}
	


