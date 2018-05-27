/**
 * SimpleArrayStack Class.
 *
 * @author  Jonathan Kisch
 * @version 1/15/2016 Developed for CPE 103 project 4
 */

import java.util.NoSuchElementException;

public class SimpleArrayStack<E> implements SimpleStack<E> {

	private Object[] holder;
	private int size;

	public SimpleArrayStack() {
		size = 0;
		holder = new Object[10];
	}

	@SuppressWarnings("unchecked")
	public E peek() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return (E) holder[size - 1];
	}

	@SuppressWarnings("unchecked")
	public E pop() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		E temp = (E) holder[size - 1];
		size--;
		return temp;
	}

	public void push(E element) {
		if (size == holder.length) {
			Object[] newholder = new Object[2 * holder.length];
			for (int i = 0; i < holder.length; i++) {
				newholder[i] = holder[i];
			}
			holder = newholder;
		}
		holder[size] = element;
		size++;
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return holder.length;
	}

}
