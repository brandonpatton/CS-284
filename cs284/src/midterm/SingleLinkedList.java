package midterm;

import lists.MyListLL.Node;

public class SingleLinkedList<E> {
	
	private class Node<E>{
		// Data fields
		private E data;
		private Node<E> next;
		// Constructors
		Node(E data) {
			this.data=data;
			this.next=null;
		}
		Node(E data, Node<E> next) {
			this.data=data;
			this.next=next;
		}
	}
	// Data fields
	private Node<E> head;
	private int size;
			
	//Constructor
	SingleLinkedList() {
		head=null;
		size=0;
	}
	
	public boolean isSingleton(Node<E> node) {
		if (node.next == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean allEven(Node<Integer> node) {
		Node<Integer> egg = node;	
		while (egg != null){
			 if(egg.data %2 == 0) {
				egg = egg.next;
			 } 
			 else {
				 return false;
			 }
		}
		return true;
	}
	
	public Integer sumL(Node<Integer> node) {
		Node<Integer> current = node;
		int sum = 0;
		while (current != null) {
			sum += current.data;
			current = current.next;	
		}
		return sum;
	}
	
	public boolean nonDuplicates(Node<Integer> node) {
		Node<Integer> current = node;
		while (current != null) {
			if(current != current.next) {
				current = current.next;
			} else {
				return false;
			}
		}
		return true;	
	}
	
	public Node<E> copyL(Node<E> node){
		if (head==null) { // list is empty
			head = new Node<E>(item);
		} else {          // list is non-empty
			Node<E> current=head;
			while (current.next!=null) {
				current=current.next;
			}
			current.next = new Node<E>(item);
		}
		size++;
		return true;
	}
	
	public Node<E> append(Node<E> node1, Node<E> node2){
		Node<E> appendedList = null;
		if(node1 == null) {
			return node2;
		}
		else if(node2 == null) {
			return node1;
		}
		else if(node1 == null) {
			if(node2 == null) {
				return null;
			}
		}
	}
	
	public Node<E> reverse(Node<E> node){
		
	}
	
	public Node<Integer> doubleL(Node<Integer> node){
		
	}
}
