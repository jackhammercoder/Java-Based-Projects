import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Sorts<E> {

	public static <E extends Comparable<? super E>> void mergeSort(List<E> list) {

		ArrayList<E> bob = new ArrayList<E>();
		LinkedList<E> billy = new LinkedList<E>();
		if (list instanceof LinkedList) {
			Iterator<E> itr = list.iterator();
			while (itr.hasNext()) {
				bob.add(itr.next());
			}

			List<E> sally = merge_Sort(bob);
			Iterator<E> itr2 = sally.iterator();

			while (itr2.hasNext()) {
				billy.add(itr2.next());
			}
			Collections.copy(list, billy);
		}
		else{
			Collections.copy(list, merge_Sort(list));
		}
		
	}

	private static <E extends Comparable<? super E>> List<E> merge_Sort(List<E> m) {
		// Base case. A list of zero or one elements is sorted, by definition.
		int size = m.size();

		if (size <= 1) {
			return m;
		}

		// Recursive case. First, divide the list into equal-sized sublists
		// consisting of the even and odd-indexed elements.
		ArrayList<E> odds = new ArrayList<E>();
		ArrayList<E> evens = new ArrayList<E>();

		Iterator<E> m_list = m.iterator();

		for (int i = 0; i < size; i++) {
			int isEven = i % 2;
			if (isEven == 1) {
				odds.add(m_list.next());
			} else {
				evens.add(m_list.next());
			}
		}

		// Recursively sort both sublists.

		odds = (ArrayList<E>) merge_Sort(odds);
		evens = (ArrayList<E>) merge_Sort(evens);

		// Then merge the now-sorted sublists.
		return merge(odds, evens);
	}

	private static <E extends Comparable<? super E>> List<E> merge(List<E> left, List<E> right) {
		ArrayList<E> result = new ArrayList<E>();
		E left_item = null;
		E right_item = null;
		int l = 0;
		int r = 0;

		while (l != left.size() && r != right.size()) {
			left_item = left.get(l);
			right_item = right.get(r);
			if (left_item.compareTo(right_item) <= 0) {
				result.add(left_item);
				l++;
			} else {
				result.add(right_item);
				r++;
			}
		}

		// Either left or right may have elements left; consume them.
		// (Only one of the following loops will actually be entered.)

		while (l != left.size()) {
			result.add(left.get(l));
			l++;
		}
		while (r != right.size()) {
			result.add(right.get(r));
			r++;
		}

		return result;
	}

	public static <E extends Comparable<? super E>> void quickSort(List<E> list) {
		ArrayList<E> bob = new ArrayList<E>();
		LinkedList<E> billy = new LinkedList<E>();
		if (list instanceof LinkedList) {
			Iterator<E> itr = list.iterator();
			while (itr.hasNext()) {
				bob.add(itr.next());
			}

			List<E> sally = quick_Sort(bob, 0, bob.size() - 1);
			Iterator<E> itr2 = sally.iterator();

			while (itr2.hasNext()) {
				billy.add(itr2.next());
			}
			Collections.copy(list, billy);
		}
		else{
			Collections.copy(list, quick_Sort(list, 0, list.size() - 1));
		}
		

	}

	private static <E extends Comparable<? super E>> List<E> quick_Sort(List<E> list, int lo, int hi) {

		if (lo < hi) {
			int pindex = partition(list, lo, hi);
			quick_Sort(list, lo, pindex - 1);
			quick_Sort(list, pindex + 1, hi);
		}
		return list;
	}

	private static <E extends Comparable<? super E>> int partition(List<E> list, int lo, int hi) {
		E pivot = list.get(hi);
		int pindex = lo;
		Iterator<E> itr = list.listIterator(lo);
		for (int j = lo; j < hi; j++) {
			if (itr.next().compareTo(pivot) <= 0) {
				Collections.swap(list, j, pindex);
				pindex = pindex + 1;
			}
		}
		Collections.swap(list, pindex, hi);
		return pindex;
	}

}
