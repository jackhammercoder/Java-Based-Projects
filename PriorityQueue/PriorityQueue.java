/**
 * Priority Queue Class
 *
 * @author Jonathan Kisch
 * @version 2/5/2016 Developed for CPE 103 project 3
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<? super E>> implements SimpleQueue<E> {
	private ArrayList<E> Holder = new ArrayList<E>();
	private boolean isMax;

	public PriorityQueue() {
		isMax = false;
		Holder.add(null);
	}

	public PriorityQueue(boolean is_maximum) {
		if (is_maximum == true) {
			isMax = true;
		} 
		else{
			isMax = false;
		}
		Holder.add(null);
	}

	public PriorityQueue(E[] array, int size) {
		Holder.add(null);
		isMax = false;
		for (int i = 0; i < size; i++) {
			enqueue(array[i]);
		}
	}
	
	public PriorityQueue(E[] array, int size, boolean is_maximum) {
		Holder.add(null);
		if (is_maximum == true) {
			isMax = true;
		} 
		else {
			isMax = false;
		}
		for (int i = 0; i < size; i++) {
			enqueue(array[i]);
		}
	}

	public E dequeue() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		Collections.swap(Holder, 1, size()); // swapping the top of the tree with the right most element at the bottom
		E smallest = Holder.remove(size()); // getting that element we will use to restructure the tree
		int current_node = 1;
		int n =  (int) (Math.log(size())/Math.log(2));
		while(n > 0){
		if (isMax == false ) {
			if (current_node * 2  == size()){
				if (Holder.get(current_node).compareTo(Holder.get(2 * current_node)) <= 0){
					return smallest;
				}
				else {
					Collections.swap(Holder, current_node, 2 * current_node);
					return smallest;
				}
			
			}
			if (current_node * 2 > size()){
				return smallest;
			}
			if (Holder.get(current_node).compareTo(Holder.get(2 * current_node)) == -1 && Holder.get(current_node).compareTo(Holder.get(2 * current_node + 1)) == -1) {
				return smallest;
			}
			if (Holder.get(current_node *2).compareTo(Holder.get(2 * current_node + 1)) <= 0) {
				Collections.swap(Holder, current_node, 2 * current_node);
				current_node = current_node * 2;
				n--;
			}
			else{
				Collections.swap(Holder, current_node, 2 * current_node + 1);
				current_node = (current_node * 2) + 1;
				n--;
			}
		}
		else{
			if (current_node * 2  == size()){
				if (Holder.get(current_node).compareTo(Holder.get(2 * current_node)) >= 0)
					return smallest;
				else {
					Collections.swap(Holder, current_node, 2 * current_node);
					return smallest;
				}
			}
			if (current_node * 2 > size()){
				return smallest;
			}
			
			if (Holder.get(current_node).compareTo(Holder.get(2 * current_node)) == 1 && Holder.get(current_node).compareTo(Holder.get(2 * current_node + 1)) == 1) {
				return smallest;
			}
			if (Holder.get(current_node *2).compareTo(Holder.get(2 * current_node + 1)) >= 0) {
				Collections.swap(Holder, current_node, 2 * current_node);
				current_node = current_node * 2;
				n--;
			}
			else{
				Collections.swap(Holder, current_node, 2 * current_node + 1);
				current_node = (current_node * 2) + 1;
				n--;
			}
		}
		}
		return smallest;
	}

	public void enqueue(E element) {
		Integer current_node = 0;
		if (size() == 0){
			Holder.add(1, element);
			return;
		}
		else{
		Holder.add(element);
		current_node = size();
		}
		if (isMax == false) {
			while(Holder.get(current_node).compareTo(Holder.get(current_node / 2)) < 0){
				Collections.swap(Holder, current_node, current_node / 2);
				current_node = current_node / 2;
				if (current_node == 1){
					break;
				}
			}
		} 
		if (isMax == true){
			while(Holder.get(current_node).compareTo(Holder.get(current_node / 2)) > 0) {
				Collections.swap(Holder, current_node, current_node / 2);
				current_node = current_node / 2;
				if (current_node == 1){
					break;
				}
		}
		}
		
	}

	public E peek() {
		if (size() == 0){
			throw new NoSuchElementException();
		}
		return Holder.get(1);
	}

	
	public int size() {
		return Holder.size() -1;
	}

	public static <E extends java.lang.Comparable<? super E>> void sort(E[] array, int size) {
		PriorityQueue<E> sort = new PriorityQueue<E>(array, size);
		for (int i = 0; i < size ; i++){
			array[i] = sort.dequeue();
		}
		
	}
	
	public static <E extends java.lang.Comparable<? super E>> E kth( E[] array, int size, int k ){
		if (k < size - k + 1){
			PriorityQueue<E> sort = new PriorityQueue<E>(array, k );
			for (int i = k  ; i < size; i++){
				if (sort.peek().compareTo(array[i]) < 0){
					sort.dequeue();
					sort.enqueue(array[i]);
				}
			}
			return sort.peek();
		}
		else {
			PriorityQueue<E> sort = new PriorityQueue<E>(array, size - k + 1 , true);
			for (int i = size - k + 1 ; i < size; i++){
				if (sort.peek().compareTo(array[i]) > 0){
					sort.dequeue();
					sort.enqueue(array[i]);
				}
			}
			return sort.peek();
		}
		
	}

}