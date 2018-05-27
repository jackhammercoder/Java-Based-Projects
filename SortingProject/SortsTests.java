import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;

public class SortsTests {
	
	private static  ArrayList<Integer> makeRandomIntegerArrayList(int seed, int size)
	   {
	      ArrayList<Integer> random = new ArrayList<>();
	      Random rand = new Random(seed);

	      for (int i = 0; i < size; i++)
	      {
	         random.add(rand.nextInt());
	      }

	      return random;
	   }
	
	private static  LinkedList<Integer> makeRandomIntegerLinkedList(int seed, int size)
	   {
	      LinkedList<Integer> random = new LinkedList<>();
	      Random rand = new Random(seed);

	      for (int i = 0; i < size; i++)
	      {
	         random.add(rand.nextInt());
	      }

	      return random;
	   }
	
	@Test
	public void test01_firstMergeSort(){
		int k;
		ArrayList<Integer> bob = new ArrayList<Integer>();
		bob.add(5);
		bob.add(6);
		bob.add(3);
		bob.add(1);
		bob.add(2);
		Sorts.mergeSort(bob);
		
		for (int i = 0 ; i < bob.size() -1 ; i++){
			k = i +1;
			assertTrue(bob.get(i) <= bob.get(k));
		}
	}
	
	@Test
	public void test01_SECONDmergeSort(){
		int k;
		LinkedList<Integer> bob = new LinkedList<Integer>();
		bob.add(5);
		bob.add(6);
		bob.add(3);
		bob.add(1);
		bob.add(2);
		Sorts.mergeSort(bob);
		for (int i = 0 ; i < bob.size() -1 ; i++){
			k = i +1;
			assertTrue(bob.get(i) <= bob.get(k));
		}
	}
	
	@Test
	public void test03_RandomMergeSort(){
		int k;
		ArrayList<Integer> bob = makeRandomIntegerArrayList(-12340, 1000);
		Sorts.mergeSort(bob);
		
		for (int i = 0 ; i < bob.size() -1 ; i++){
			k = i +1;
			assertTrue(bob.get(i) <= bob.get(k));
		}
	}
	
	@Test
	public void test04_firstQuickSort(){
		int k;
		ArrayList<Integer> bob = new ArrayList<Integer>();
		bob.add(5);
		bob.add(6);
		bob.add(3);
		bob.add(1);
		bob.add(2);
		Sorts.quickSort(bob);
		
		for (int i = 0 ; i < bob.size() -1 ; i++){
			k = i +1;
			assertTrue(bob.get(i) <= bob.get(k));
		}
	}
	
	@Test
	public void test05_SECONDquickSort(){
		int k;
		LinkedList<Integer> bob = new LinkedList<Integer>();
		bob.add(5);
		bob.add(6);
		bob.add(3);
		bob.add(1);
		bob.add(2);
		Sorts.quickSort(bob);
		
		for (int i = 0 ; i < bob.size() -1 ; i++){
			k = i +1;
			assertTrue(bob.get(i) <= bob.get(k));
		}
	}
	
	@Test
	public void test06_RandomquickSort(){
		int k;
		ArrayList<Integer> bob = makeRandomIntegerArrayList(-14321, 100000);
		Sorts.quickSort(bob);
		
		for (int i = 0 ; i < bob.size() -1 ; i++){
			k = i +1;
			assertTrue(bob.get(i) <= bob.get(k));
		}
	}
	
	@Test
	public void test07_RandommergeSortLL(){
		int k;
		LinkedList<Integer> bob = makeRandomIntegerLinkedList(-14321, 100000);
		Sorts.mergeSort(bob);
		
		for (int i = 0 ; i < bob.size() -1 ; i++){
			k = i +1;
			assertTrue(bob.get(i) <= bob.get(k));
		}
	}
	
	@Test
	public void test07_QuickSort(){
		ArrayList<Integer> quick = makeRandomIntegerArrayList(-12340, 1000000);
		
	

    	
    	double beforequick = System.currentTimeMillis();
    	Sorts.quickSort(quick);
    	double afterquick = System.currentTimeMillis();
    	double quicktime = afterquick - beforequick;
    	System.out.println(" quick              1,000,000 elements   (observed):   " + quicktime + "ms");
	}
	
	
	
	@Test
	public void test09_javakSort(){
		ArrayList<Integer> java = makeRandomIntegerArrayList(-14321, 1000000);
		
	

    	
    	double beforequick = System.currentTimeMillis();
    	Collections.sort(java);
    	double afterquick = System.currentTimeMillis();
    	double quicktime = afterquick - beforequick;
    	System.out.println(" javautil              1,000,000 elements   (observed):   " + quicktime + "ms");
	}
	
	@Test
	public void test010_mergeSort(){
		ArrayList<Integer> merge = makeRandomIntegerArrayList(-12340, 1000000);
	
		
		double beforemerge = System.currentTimeMillis();
    	Sorts.mergeSort(merge);
    	double aftermerge = System.currentTimeMillis();
    	double mergetime = aftermerge - beforemerge;
    	System.out.println("  merge             1,000,000 elements   (observed):   " + mergetime + "ms");

	}
	
	@Test
	public void test011_mergeSortLL(){
		LinkedList<Integer> merge = makeRandomIntegerLinkedList(-12340, 1000000);
	
		
		double beforemerge = System.currentTimeMillis();
    	Sorts.mergeSort(merge);
    	double aftermerge = System.currentTimeMillis();
    	double mergetime = aftermerge - beforemerge;
    	System.out.println("  mergeLL            1,000,000 elements   (observed):   " + mergetime + "ms");

	}
	@Test
	public void test012_QuickSort(){
		LinkedList<Integer> quick = makeRandomIntegerLinkedList(-12340, 1000000);
		
	

    	
    	double beforequick = System.currentTimeMillis();
    	Sorts.quickSort(quick);
    	double afterquick = System.currentTimeMillis();
    	double quicktime = afterquick - beforequick;
    	System.out.println(" quick              1,000,000 elements   (observed):   " + quicktime + "ms");
	}
	
	

}
