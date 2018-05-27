/**
 * HashChaining class
 * @author Jonathan Kisch
 * version 2/24/2016
 */

public class HashChaining<E> extends HashTable<E> implements HashMetrics {
	private HashTableEntry[] hashArray;
	private long collisions = 0;
	private int opCollisions = 0;
	private int maxCollisions = 0;
	private int insert_count = 0;

	public HashChaining(int tableSize) { // Initializes the hash table size to
											// the next prime equal to or
											// greater than table size;
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
		int hashcode = Math.abs(element.hashCode());
		if (hashcode >= tableSize) {
			hashcode = hashcode % tableSize;
		}
		HashTableEntry cell = hashArray[hashcode];
		while (cell != null) {
			if (cell.data.equals(element)) {
				return true;
			}
			cell = cell.next;
			opCollisions++;
		}
		return false;

	}

	public void insert(E element) {
		opCollisions = 0;
		int hashcode = Math.abs(element.hashCode());
		if (hashcode >= tableSize) {
			hashcode = hashcode % tableSize;
		}
		HashTableEntry temp = new HashTableEntry<E>(element);

		HashTableEntry cell = hashArray[hashcode];

		if (cell == null) {
			hashArray[hashcode] = temp;
			size++;
			insert_count++;
			return;
		}
		if (cell.data.equals(element)) {
			insert_count++;
			return;
		}
		if (cell.next == null) {
			cell.next = temp;
			size++;
			insert_count++;
			collisions++;
			opCollisions++;
			if (opCollisions > maxCollisions) {
				maxCollisions = opCollisions;
			}
			return;
		}

		while (cell.next != null) {
			if (cell.data.equals(element)) {
				insert_count++;
				return;
			}
			collisions++;
			opCollisions++;
			cell = cell.next;

		}

		if (cell.data.equals(element)) {
			if (opCollisions > maxCollisions) {
				maxCollisions = opCollisions;
			}
			insert_count++;
			return;
		}
		opCollisions++;
		collisions++;
		if (opCollisions > maxCollisions) {
			maxCollisions = opCollisions;
		}
		cell.next = temp;

		size++;
		insert_count++;

	}

	public double loadFactor() {
		return (double) size() / (double) tableSize();
	}

	public void remove(E element) {
		opCollisions = 0;
		if (size == 0) {
			return;
		}
		int hashcode = Math.abs(element.hashCode());
		if (hashcode >= tableSize) {
			hashcode = hashcode % tableSize;
		}
		HashTableEntry cell = hashArray[hashcode];
		HashTableEntry temp;
		if (cell == null){
			return;
		}
		
		if (cell.data.equals(element)) {
			hashArray[hashcode] = cell.next;
			size--;
			return;
		}
		while (cell.next != null) {
			opCollisions++;
			temp = cell;
			cell = cell.next;
			if (cell.data.equals(element)) {
				temp.next = cell.next;
				size--;
				return;
			}
		}
		opCollisions++; // extra collision if the remove item is not in the
						// list;

	}

	public int size() {
		return size;
	}

	public int tableSize() {
		return tableSize;
	}

	private class HashTableEntry<E> {
		private E data;
		private HashTableEntry next;

		public HashTableEntry(E element) {
			data = element;
			next = null;
		}
	}

}