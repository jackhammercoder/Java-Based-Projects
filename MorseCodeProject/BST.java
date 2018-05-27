
/**
 * Provided BST class skeleton for students to complete. This class makes
 * use of Object Oriented structural recursion to solve the problem.
 *
 * Original Revision:
 * @author Paul Hatalsky
 * @version project 4
 *
 * Completed By:
 * @author Jonathan Kisch
 */

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class BST<E extends Comparable<? super E>> implements Iterable<E> {
	// Instance variables for BST class.
	// These are the only ones allowed!
	private BSTNode<E> root = new EmptyNode();
	private int size;

	// Polymorphic BST node type!
	private interface BSTNode<E> {
		public BSTNode<E> insert(E element);

		public boolean contains(E element);

		public E minimum(E minimum);

		public E maximum(E maximum);

		public void toSortedList(List<E> list);

		public BSTNode<E> remove(E element);

		public int treeHeight();

		public long internalPathLength(long depth);

		public E get(E element);
	}

	////////////////////////////////////////////////////////////////////////////
	// BST class methods...
	//

	/**
	 * Inserts an element into the BST. If the element is already in the BST,
	 * the element being inserted is discarded.
	 *
	 * @param element
	 *            The element to insert into the BST.
	 *
	 * @throws IllegalArgumentException
	 *             If the element is null.
	 */
	public void insert(E element) {
		if (element == null) {
			throw new IllegalArgumentException();
		}

		root = root.insert(element);
	}

	/**
	 * Determines whether or not an element is in the BST.
	 *
	 * @param element
	 *            The element to search for in the BST.
	 *
	 * @return True if the element is in the BST, false if not.
	 */
	public boolean contains(E element) {
		if (element == null) {
			return false;
		}

		return root.contains(element);
	}

	/**
	 * Finds the minimum element in the BST.
	 *
	 * @return The minimum element in the BST.
	 * 
	 * @throws NoSuchElementException
	 *             If the BST is empty.
	 */
	public E minimum() {
		if (size == 0) {
			throw new NoSuchElementException();
		}

		return root.minimum(((Node) root).element);
	}

	/**
	 * Finds the maximum element in the BST.
	 *
	 * @return The maximum element in the BST.
	 *
	 * @throws NoSuchElementException
	 *             If the BST is empty.
	 */
	public E maximum() {
		if (size == 0) {
			throw new NoSuchElementException();
		}

		return root.maximum(((Node) root).element);
	}

	/**
	 * Takes the elements in the BST and places them in ascending order into the
	 * List.
	 *
	 * @param element
	 *            The element to search for in the BST.
	 */
	public void toSortedList(List<E> list) {
		root.toSortedList(list);
	}

	public int size() {
		return size;
	}

	// removes the specififed element from the BST.
	public void remove(E element) {
		if (size == 0) {
			throw new NoSuchElementException();
		}

		root = root.remove(element);
		size--;

	}

	public int treeHeight() {
		return root.treeHeight();
	}

	public long internalPathLength() {
		if (size == 0) {
			return -1;
		}
		// if (size == 1){
		// return 0;
		// }
		return root.internalPathLength(1);
	}

	public E get(E element) {
		if (root instanceof BST.EmptyNode) {
			throw new NoSuchElementException();
		}
		E elem = root.get(element);
		return elem;
	}

	////////////////////////////////////////////////////////////////////////////
	// private EmptyNode class...
	//
	private class EmptyNode implements BSTNode<E> {
		// No instance variables needed or allowed!

		public BSTNode<E> insert(E element) {

			Node insert = new Node();
			insert.element = element;
			insert.left = new EmptyNode();
			insert.right = new EmptyNode();
			size++;
			return insert;

		}

		public boolean contains(E element) {
			return false;
		}

		public E minimum(E element) {
			E temp = element;
			return temp;
		}

		public E maximum(E element) {
			return element;
		}

		public void toSortedList(List<E> list) {
			return;
		}

		public BSTNode<E> remove(E element) {
			throw new NoSuchElementException();
		}

		public int treeHeight() {
			return -1;
		}

		public long internalPathLength(long depth) {
			return -(depth - 1);
		}

		public E get(E element) {
			throw new NoSuchElementException();
		}

	}

	////////////////////////////////////////////////////////////////////////////
	// private Node class...
	//
	private class Node implements BSTNode<E> {
		// These are the only instance variables needed
		// and the only ones allowed!
		E element;
		BSTNode<E> left, right;

		public BSTNode<E> insert(E element) {
			if (size == 0) {
				Node insert = new Node();
				insert.element = element;
				insert.left = new EmptyNode();
				insert.right = new EmptyNode();
				size++;
				return insert;
			}

			if (this.element.compareTo(element) < 0) {
				this.right = this.right.insert(element);
			} else if (this.element.compareTo(element) > 0) {
				this.left = this.left.insert(element);
			}
			return this;

		}

		public boolean contains(E element) {

			if (element.compareTo(this.element) < 0) {
				return this.left.contains(element);
			} else if (element.compareTo(this.element) > 0) {
				return this.right.contains(element);
			} else {
				return true;
			}

		}

		public E minimum(E element) {
			E temp = this.element;
			return this.left.minimum(temp);

		}

		public E maximum(E element) {
			E temp = this.element;
			return this.right.maximum(temp);
		}

		public void toSortedList(List<E> list) {
			this.left.toSortedList(list);
			list.add(this.element);
			this.right.toSortedList(list);
		}

		public BSTNode<E> remove(E data) {

			if (data.compareTo(this.element) < 0) {
				this.left = this.left.remove(data);
			}

			else if (data.compareTo(this.element) > 0) {
				this.right = this.right.remove(data);
			}

			else {
				if (isEmpty(this.left) && isEmpty(this.right)) {
					EmptyNode temp = new EmptyNode();
					return temp;
				}

				else if (isEmpty(this.left) && !isEmpty(this.right)) {
					return this.right;
				}

				else if (isEmpty(this.right) && !isEmpty(this.left)) {
					return this.left;
				}

				else {
					this.element = this.right.minimum(((Node) this.right).element);
					this.right = this.right.remove(this.element);
					return this;
				}
			}
			return this;
		}

		public int treeHeight() {
			return 1 + Math.max(this.right.treeHeight(), this.left.treeHeight());
		}

		public long internalPathLength(long depth) {
			return (depth + this.right.internalPathLength(depth + 1))
					+ (depth + this.left.internalPathLength(depth + 1));
		}

		public E get(E element) {
			E elem = this.element;
			if (this.element.compareTo(element) == 0) {
				return this.element;
			}else if (this.element.compareTo(element) > 0) {
				return this.left.get(element);
			} else {
				return this.right.get(element);
				
			}
			

		}
	}

	private boolean isEmpty(BSTNode<E> n) {
		if (n instanceof BST.EmptyNode) {
			return true;
		} else {
			return false;
		}
	}
	
	private class treeIterator implements Iterator<E>{
		SimpleArrayStack<Node> traverse = new SimpleArrayStack<Node>();
		
		
		public treeIterator(BSTNode<E> b){
			if (b instanceof BST.EmptyNode){
				return;
			}
			Node currentpoint = (BST<E>.Node) b;
			E start = currentpoint.element;
			E minimum = minimum();
			traverse.push(currentpoint);
			while (start != minimum ){
				currentpoint = (BST<E>.Node) currentpoint.left;
				traverse.push(currentpoint);
				start = currentpoint.element;
			}
		}
		public boolean hasNext() {
			if (traverse.size() == 0){
				return false;
			}
			return true;
		}

		public E next() {
			if (hasNext() == false){
				throw new NoSuchElementException();
			}
			Node current_node = traverse.peek();
			E current_node_element = traverse.pop().element;
			if (current_node.right instanceof BST.Node){
				current_node = (BST<E>.Node) current_node.right;
			}
			else if (current_node.right instanceof BST.EmptyNode){
				return current_node_element;
			}
			while(current_node.left instanceof BST.Node ){
				traverse.push(current_node);
				current_node = (BST<E>.Node) current_node.left;
			}
			traverse.push(current_node); // this is to push the very last one;
			return current_node_element;
			
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
	}

	public Iterator<E> iterator() {
		return new treeIterator(root);
	}

}
