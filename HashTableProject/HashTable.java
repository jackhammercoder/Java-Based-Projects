
/**
 * HashTable abstract class
 * @author Jonathan Kisch
 * version 2/24/2016
 */

import java.util.NoSuchElementException;

public abstract class HashTable<E> {
	protected int size;
	protected int tableSize;

	public abstract boolean contains(E element); // this will check if an
													// element is in the
													// hashtable

	public abstract void insert(E element);

	public abstract double loadFactor();

	public abstract void remove(E element);

	public abstract int size();

	public abstract int tableSize();

	public static boolean isPrime(int value) {
		if (value < 2) {
			return false;
		}
		for (int i = 2; i <= (int) Math.sqrt(value); i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int nextPrime(int value) {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		if (value > Integer.MAX_VALUE) {
			throw new NoSuchElementException();
		}
		if (isPrime(value) == true) {
			return value;
		}

		boolean isItprime = false;
		while (isItprime == false) {

			if (value > Integer.MAX_VALUE) {
				throw new NoSuchElementException();
			}
			value = value + 1;
			isItprime = isPrime(value);
		}
		return value;
	}

}
