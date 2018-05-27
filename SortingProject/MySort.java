import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MySort {

	public static <E extends Comparable<? super E>> void sort(List<E> list) {
		ArrayList<E> bob = new ArrayList<E>();
		if (list instanceof LinkedList) {
			Iterator<E> itr = list.iterator();
			while (itr.hasNext()) {
				bob.add(itr.next());
			}
			Collections.copy(list, quick_Sort(bob, 0, bob.size() - 1));
		} else {
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
		E pivot;
		int middle = (lo + hi) /2;
		 if( list.get(middle).compareTo( list.get(lo) ) < 0 ){
             Collections.swap(list, lo, middle);
		 }
         if( list.get(hi).compareTo( list.get(lo) ) < 0 ){
             Collections.swap(list, lo, hi);
         }
         if( list.get(hi).compareTo( list.get(middle) ) < 0 ) {
        	 Collections.swap(list, middle, hi); 
         }
         
         Collections.swap(list, middle, hi-1);
         pivot = list.get(hi-1);
		

		int pindex = lo;
		Iterator<E> itr = list.listIterator(lo);
		for (int j = lo; j < hi; j++) {
			if (itr.next().compareTo(pivot) <= 0) {
				Collections.swap(list, j, pindex);
				pindex = pindex + 1;
			}
		}
		Collections.swap(list, pindex, hi);
		return pindex -1;
	}

}
