package tokens;

import java.util.EmptyStackException;

public class StackSLL<E> {
	private static class Node<E> {
		E data;
		Node<E> next;

		Node(E item) {
			data = item;
			next = null;
		}

		Node(E item, Node<E> aNode) {
			data = item;
			next = aNode;
		}
	}

	Node<E> top;
	Integer size;

	StackSLL() {
		top = null;
		size = 0;
	}

	public E push(E item) {
		top = new Node<E>(item, top);
		size++;
		return item;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public E peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	public E pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		E temp = top.data;
		top = top.next;
		size--;
		return temp;
	}
}
