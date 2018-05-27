/**
 * HashQuadratic class
 * @author Jonathan Kisch
 * version 2/24/2016
 */

public class HashQuadratic<E> extends HashTable<E> implements HashMetrics {
	private long collisions = 0;
	private int opCollisions = 0;
	private int maxCollisions = 0;
	private int insert_count = 0;
	private HashTableEntry[] hashArray;

	public HashQuadratic(int tableSize) {
		this.tableSize = nextPrime(tableSize);
		hashArray = new HashTableEntry[this.tableSize];

	}

	public long collisions() {
		return collisions;
	}

	public int lastOpCollisions() {
		return opCollisions;
	}

	public int maxCollisions() {
		return maxCollisions;
	}

	public double avgCollisions() {
		if (insert_count == 0) {
			return 0.0;
		}
		return (double) collisions / (double) insert_count;
	}

	public boolean contains(E element) {
		opCollisions = 0;
		if (size == 0) {
			return false;
		}
		int hashcode = Math.abs(element.hashCode());
		if (hashcode >= tableSize) {
			hashcode = hashcode % tableSize; // this make a too large of a hash
												// into useable hash

		}
		HashTableEntry temp = hashArray[hashcode]; // keep going until the you
													// find an empty spot

		double nextlookup = 0;
		double inc = 0;
		int index = hashcode;
		while (temp != null) {
			if (temp.data.equals(element) && temp.empty == false) { // has to be
				return true;
			} 
			else if (temp.data.equals(element) && temp.empty == true) {
				return false;
			}
			nextlookup =  Math.pow((inc + 1), 2); // where to look
			inc++;												// next

			index = (int) ((hashcode + nextlookup) % tableSize); // hashcode of where
															// to look next

			temp = hashArray[index];

			opCollisions++;

		}
		return false;

	}

	public void insert(E element) {
		opCollisions = 0;
		if (loadFactor() >= .5) {
			throw new HashLoadFactorException();
		}
		insert_count++;
		HashTableEntry<E> insert = new HashTableEntry<E>(element, false);
		int hashcode = Math.abs(element.hashCode());
		if (hashcode >= tableSize) {
			hashcode = hashcode % tableSize; // this make a too large of a hash
												// into useable hash

		}
		HashTableEntry temp = hashArray[hashcode]; // keep going until the you
													// find an empty spot

		double nextlookup = 0;
		double increment = 0;
		int index = hashcode;
		if (temp == null || temp.empty == true) {
			hashArray[index] = insert;
			size++;
			return; // you are done!
		}
		while (temp != null && temp.empty != true && !temp.data.equals(element)) {
			nextlookup = Math.pow((increment + 1), 2);
			increment++;  // where to look
															// next

			index = (int) ((hashcode + nextlookup) % tableSize); // hashcode of where
															// to look next
		
			temp = hashArray[index];
			opCollisions++;
			collisions++;
		}
		if (opCollisions > maxCollisions) {
			maxCollisions = opCollisions;
		}
		if (temp == null || temp.empty == true) {
			hashArray[index] = insert;
			size++;
			return; // you are done!
		}

		if (temp.data.equals(element)) { // this means the first hash lookup is
											// the current element
			return;
		}

	}

	public double loadFactor() {
		return (double) size() / (double) tableSize();
	}

	public void remove(E element) {
		opCollisions = 0;
		int hashcode = Math.abs(element.hashCode());
		if (hashcode >= tableSize) {
			hashcode = hashcode % tableSize; // this make a too large of a hash
												// into useable hash

		}
		HashTableEntry temp = hashArray[hashcode]; // keep going until the you
													// find an empty spot

		double nextlookup = 0;
		double inc =0;
		int index = hashcode;
		while (temp != null) {
			if (temp.data.equals(element) && temp.empty == false) { // has to be
																	// not
																	// lazily
																	// deleted
				HashTableEntry<E> insert = new HashTableEntry<E>(element, true);
				hashArray[index] = insert;
				size--;
				return;
			} 
			else if (temp.data.equals(element) && temp.empty == true) {
				return;
			}
			nextlookup =  Math.pow(inc + 1, 2); // where to look
			inc++;												// next

			index = (int) (hashcode + nextlookup) % tableSize; // hashcode of where
															// to look next

			temp = hashArray[index];
			opCollisions++;

		}

	}

	public int size() {
		return size;
	}

	public int tableSize() {
		return this.tableSize;
	}

	private class HashTableEntry<E> {
		private E data;
		private boolean empty;

		public HashTableEntry(E element, boolean isempty) {
			data = element;
			empty = isempty;
		}
	}

}
