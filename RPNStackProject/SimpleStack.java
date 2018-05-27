/**
 * SimpleStack Interface.
 *
 * @author  Jonathan Kisch
 * @version 1/15/2016 Developed for CPE 103 Project 2
 */
public interface SimpleStack<E> {

	public E peek(); // returns the element at top of a stack

	public E pop(); // removes and returns the element at the top of a stack

	public void push(E element); // adds a specified element to the top of a

	public int size(); // return the number of elements currently in the stack
}

