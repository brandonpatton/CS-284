package lists;

public class MyListLL<E extends Comparable<E>> implements Pair<E,F> {
	
	private class Node<E> {
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
	MyListLL() {
		head=null;
		size=0;
	}
	
	public boolean add(E item) {
		head = new Node<E>(item,head);
		size++;
		return true;
	}
	
	public boolean addLast(E item) {
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
	/**
	 * Removes first item from the list
	 * @return returns item removed
	 */
	public E removeFirst() {
		if (head==null) {
			throw new IllegalArgumentException("List is empty");
		}
		E temp = head.data;
		head = head.next;
		size--;
		return temp;		
	}
	/**
	 * Removes last item from the list
	 * @return returns last item
	 */
	public E removeLast() {
	    if (head==null) {      // list is empty
	    		throw new IllegalArgumentException("List is empty");
	    }
	    if (head.next==null) { // list is a singleton list
	        return this.removeFirst();
	    }
	    // list has two or more items
	    Node<E> current=head;
	    
	    while(current.next.next!=null) {
	    		current=current.next;
	    }
	    E temp = current.next.data;
	    current.next=null;
	    size--;
	    return temp;
	    
	}
	/** 
	 * Removes item at index index
	 * @param index Index of item to remove; must be greater 
	 * than 0 and less than the size of the list
	 * @return item removed
	 */
	public E remove(int index) {
		if (index<0 || index>size-1) {
			throw new IllegalArgumentException();
		}
		if (index==0) {
			return this.removeFirst();
		}
		// remove an item that is not the first one
		Node<E> current=head;
		
		for(int i=0; i<index-1; i++) {
			current=current.next;
		}
		E temp = current.next.data;
		current.next=current.next.next;
		size--;
		return temp;
		
	}
	
	public static MyListLL<Pair<E,E>> zip (MyListLL<E> list1, MyListLL<E> list2){
		MyListLL<Pair<E,E>> l = new MyListLL<Pair<E,E>>();
		
		l.head = zipN(list1.head, list2.head);
		l.size = Math.min(list1.size, list2.size);
		return l;
			
		}
	
	public static Node<E> merge(Node<E> list1, Node<E> list 2){
		
	}
	
	private Node<E> take(int n, Node<E> list){
		if(n==0) {
			return null;
		} else {
			return (list==null)?null:new Node<E>(list.data, take(n-1, list.next));
			return new Node<E>(list.data, take(n-1, list.next));
		}
	}
	
	public MyListLL<E> take(int n){
		MyListLL<E> result = new MyListLL<E>();
		result.size = Math.min(n, this.size);
		result.head = take(n, this.head);
		return result;
	}
	
	private boolean isSingleton(Node<E> list) {
		return list != null && list.next == null;
	}
	
	public String toString() {
		String r="";
		Node<E> current=head;

		while (current!=null) {
			r = r + ","+current.data;
			current = current.next;
		}
		return r;

	}

	public static void main(String[] args) {
		MyListLL<String> l = new MyListLL<String>();
		
		l.add("Charly");
		l.add("Anne");
		l.add("Tom");
		l.add("Julia");
		l.addLast("Jill");
		System.out.println(l);
		l.removeLast();
		System.out.println(l);

	}
	
}
