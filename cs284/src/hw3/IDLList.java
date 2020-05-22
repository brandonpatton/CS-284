//Brandon Patton

//I pledge my honor that I have abided by the Stevens Honor System.

package hw3;

import java.util.ArrayList;

public class IDLList<E> {
	
	private class Node<E>{
		//Data Fields
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		Node (E elem){
			this.data = elem;
			this.next = null;
			this.prev = null;
		}
		
		Node(E elem, Node<E> prev, Node<E> next){
			this.data = elem;
			this.next = next;
			this.prev = prev;
		}
	}
	//Data Fields
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices = new ArrayList<Node<E>>();
	
	/*
	 * IDLList()
	 * 
	 * Creates an empty double-linked list.
	 */
	public IDLList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.indices = new ArrayList<Node<E>>();
	}
	//Methods
	
	/*
	 * public boolean add(int index, E elem)
	 * 
	 * Adds elem at position index counting from wherever head is. 
	 * Uses index for fast access. 
	 */
	public boolean add(int index, E elem) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if(index == 0){
			this.add(elem);
		} else {
			Node<E> temp = head;
			for(int i = 0; i < index; i++) {
				temp = temp.next;
				i++;
			}
			Node<E> curr = new Node(elem, temp, temp.next);
			temp.next = curr;
			indices.add(index, curr);
			size++;
			Node<E> loop = curr;
			while(loop.next != null) {
				loop = loop.next;
			}
			tail = loop;
		}
		return true;
	}
	
	/*
	 * public boolean add (E elem)
	 * 
	 * Adds elem at the head, and elem becomes the first element of the list.
	 */
	public boolean add(E elem) {
		if(head == null) {
			head = new Node(elem, null, null);
			tail = head;
			size++;
			indices.add(0, head);
			return true;
		} else {
			Node<E> header = new Node(elem, null, head);
			head = header;
			size++;
			indices.add(0, head);
			Node<E> temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			tail = temp;
			return true;
		}
	}
	
	/*
	 * public boolean append(E elem)
	 * 
	 * Adds elem as the new last element of the list (at the tail).
	 */
	public boolean append(E elem) {
		if(head == null) {
			head = new Node(elem, null, null);
			tail = head;
			size++;
			indices.add(0, tail);
			return true;
		} else {
			Node<E> curr = new Node(elem, tail, null);
			if (tail != null) {
				tail.next=curr;
			}
			// tail.next => curr
			tail = curr;
			size++;
			indices.add(size-1, tail);
			return true;
		}
	}
	
	/*
	 * public E get(int index)
	 * 
	 * Returns the object at position index from the head. It uses the index for fast access.
	 * Indexing starts from 0, thus get(0) returns the head of the list.
	 */
	public E get(int index) {
		if(index >= size || index < 0 || head == null) {
			throw new IllegalArgumentException();
		}
		int i = 0;
		while(i < index) {
			i++;
		}
		return indices.get(i).data;
	}
	
	/*
	 * public E getHead()
	 * 
	 * Returns the object at the head. 
	 */
	public E getHead() {
		if(head==null) {
			throw new IllegalArgumentException();
		} else {
			return indices.get(0).data;
		}
	}
	
	/*
	 * public E getLast()
	 * 
	 * Returns the object at the tail.
	 */
	public E getLast() {
		if (head == null) {
			throw new IllegalArgumentException();
		} else {
			return indices.get(size-1).data;
		}
	}
	
	/*
	 * public int size()
	 * 
	 * Returns the size of the list.
	 */
	public int size() {
		return this.size;
	}
	
	/*
	 * public E remove()
	 * 
	 * Removes and returns the element at the head.
	 */
	public E remove() {
		if (head == null) {
			throw new IllegalArgumentException();
		} else {
			Node<E> temp = head;
			head = head.next;
			size--;
			indices.remove(0);
			return temp.data;
		}
	}
	
	/*
	 * public E removeLast()
	 * 
	 * Removes and returns the element at the tail.
	 */
	public E removeLast() {
		if (head == null) {
			throw new IllegalArgumentException();
		} else {
			Node<E> temp = tail;
			tail = tail.prev;
			indices.remove(size-1);
			size--;
			return temp.data;
		}
	}
	
	/*
	 * public E removeAt(int index)
	 * 
	 * Removes and returns the element at the index "index."
	 * Uses the index for fast access.
	 */
	public E removeAt(int index) {
		if(head==null || index >= size || index < 0) {
			throw new IllegalArgumentException();
		} else if(index == 0) {
			return this.remove();
		} else if(index == size) {
			return this.removeLast();
		} else {
			int i = 0;
			Node<E> temp = head;
			while(i < index-1) {
				i++;
				temp = temp.next;
			}
			temp.next = temp.next.next;
			E dataHold = indices.get(i+1).data;
			indices.remove(i+1);
			size--;
			return dataHold;
		}
	}
	
	/*
	 * public boolean remove(E elem)
	 * 
	 * Removes the first occurrence of elem in the list and returns true. Returns false if
	 * elem is not in the list.
	 */
	public boolean remove(E elem) {
		if(head==null) {
			throw new IllegalArgumentException();
		} else {
			Node<E> temp = head;
			int i = 0;
			while(temp!=null) {
				if(temp.data == elem) {
					this.removeAt(i);
					return true;
				}
				temp = temp.next;
				i++;
			}
			return false;
		}
	}
	
	/*
	 * public String toString()
	 * 
	 * Presents a string representation of the list.
	 */
	public String toString() {
		if(head == null) {
			throw new IllegalArgumentException();
		} else {
			String s = "Head --> ";
			Node<E> temp = head;
			while (temp.next != null) {
				
				s += "[" + temp.data + "] <--> ";
				temp = temp.next;
			}
			s += "[" + temp.data + "] <-- Tail";
			return s;
		}
	}
	
	public static void main(String[] args) {
	}

}
