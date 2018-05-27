import java.util.NoSuchElementException;

/**
 * SimpleLinkedStack Class.
 *
 * @author Jonathan Kisch
 * @version 1/25/2016 Developed for CPE 103 Project 2
 */

public class SimpleLinkedStack<E> implements SimpleStack<E> {
	private int size;
	private Node top = new Node(null);

	public SimpleLinkedStack() {
		size = 0;
	}

	public E peek() {
		if (size == 0){
			throw new NoSuchElementException();
		}
		return top.next.data;
	}

	public E pop() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		E temp = top.next.data;
		top.next = top.next.next;
		size--;
		return temp;

	}

	public void push(E element) {
		Node Node_to_add = new Node(element);
		Node_to_add.next = top.next;
		top.next = Node_to_add;
		size++;

	}

	
	public int size() {
		return size;
	}

	private class Node {
		private E data;
		private Node next;

		public Node(E data) {
			next = null;
			this.data = data;
		}
	}

}
