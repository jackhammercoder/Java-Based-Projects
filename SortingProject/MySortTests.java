import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;

public class MySortTests {
	
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
	public void test01_100000SortArrayList(){
		ArrayList<Integer> expected = makeRandomIntegerArrayList(-14322, 100000);
		double jsortbefore = System.currentTimeMillis();
		Collections.sort(expected);
		double jsortafter = System.currentTimeMillis();
		ArrayList<Integer> actual = makeRandomIntegerArrayList(-14322, 100000);
		double mysortbefore = System.currentTimeMillis();
		MySort.sort(actual);
		double mysortafter = System.currentTimeMillis();
		double jspeed = jsortafter - jsortbefore;
		double myspeed = mysortafter - mysortbefore;
		
		int i = 0;
	      for (Integer item : actual){
	         assertEquals(item, expected.get(i++));
	      }
	      
	      System.out.println("Java sort 100,000(AL) time: " + jspeed + " ms ");
	      System.out.println("Kisch sort 100,000(AL) time: " + myspeed + " ms \n ");
	      
	}
	
	@Test
	public void test01_1000000SortArrayList(){
		ArrayList<Integer> expected = makeRandomIntegerArrayList(-232322, 1000000);
		double jsortbefore = System.currentTimeMillis();
		Collections.sort(expected);
		double jsortafter = System.currentTimeMillis();
		ArrayList<Integer> actual = makeRandomIntegerArrayList(-232322, 1000000);
		double mysortbefore = System.currentTimeMillis();
		MySort.sort(actual);
		double mysortafter = System.currentTimeMillis();
		double jspeed = jsortafter - jsortbefore;
		double myspeed = mysortafter - mysortbefore;
		
		int i = 0;
	      for (Integer item : actual){
	         assertEquals(item, expected.get(i++));
	      }
	      
	      System.out.println("Java sort Million(AL) time: " + jspeed + " ms ");
	      System.out.println("Kisch sort Million(AL) time: " + myspeed + " ms \n ");
	      
	}
	
	@Test
	public void test01_100000SortLinkedList(){
		LinkedList<Integer> expected = makeRandomIntegerLinkedList(-14322, 100000);
		double jsortbefore = System.currentTimeMillis();
		Collections.sort(expected);
		double jsortafter = System.currentTimeMillis();
		LinkedList<Integer> actual = makeRandomIntegerLinkedList(-14322, 100000);
		double mysortbefore = System.currentTimeMillis();
		MySort.sort(actual);
		double mysortafter = System.currentTimeMillis();
		double jspeed = jsortafter - jsortbefore;
		double myspeed = mysortafter - mysortbefore;
		
	      
	      System.out.println("Java sort 100,000(LL) time: " + jspeed + " ms ");
	      System.out.println("Kisch sort 100,000(LL) time: " + myspeed + " ms \n ");
	      
	}
	
	@Test
	public void test01_1000000SortLinkedList(){
		LinkedList<Integer> expected = makeRandomIntegerLinkedList(-232322, 1000000);
		double jsortbefore = System.currentTimeMillis();
		Collections.sort(expected);
		double jsortafter = System.currentTimeMillis();
		LinkedList<Integer> actual = makeRandomIntegerLinkedList(-232322, 1000000);
		double mysortbefore = System.currentTimeMillis();
		MySort.sort(actual);
		double mysortafter = System.currentTimeMillis();
		double jspeed = jsortafter - jsortbefore;
		double myspeed = mysortafter - mysortbefore;
		
	      
	      System.out.println("Java sort Million(LL) time: " + jspeed + " ms ");
	      System.out.println("Kisch sort Million(LL) time: " + myspeed + " ms \n ");
	      
	}
	
	@Test
	public void test01_1000SortArrayList(){
		ArrayList<Integer> expected = makeRandomIntegerArrayList(-2222322, 10000);
		double jsortbefore = System.currentTimeMillis();
		Collections.sort(expected);
		double jsortafter = System.currentTimeMillis();
		ArrayList<Integer> actual = makeRandomIntegerArrayList(-2222322, 10000);
		double mysortbefore = System.currentTimeMillis();
		MySort.sort(actual);
		double mysortafter = System.currentTimeMillis();
		double jspeed = jsortafter - jsortbefore;
		double myspeed = mysortafter - mysortbefore;
		
		int i = 0;
	      for (Integer item : actual){
	         assertEquals(item, expected.get(i++));
	      }
	      
	      System.out.println("Java sort 10000(AL) time: " + jspeed + " ms ");
	      System.out.println("Kisch sort 10000(AL) time: " + myspeed + " ms \n ");
	      
	}
	
	@Test
	public void test01_1000SortLinkedList(){
		LinkedList<Integer> expected = makeRandomIntegerLinkedList(-2222322, 10000);
		double jsortbefore = System.currentTimeMillis();
		Collections.sort(expected);
		double jsortafter = System.currentTimeMillis();
		LinkedList<Integer> actual = makeRandomIntegerLinkedList(-2222322, 10000);
		double mysortbefore = System.currentTimeMillis();
		MySort.sort(actual);
		double mysortafter = System.currentTimeMillis();
		double jspeed = jsortafter - jsortbefore;
		double myspeed = mysortafter - mysortbefore;
		
		int i = 0;
	      for (Integer item : actual){
	         assertEquals(item, expected.get(i++));
	      }
	      
	      System.out.println("Java sort 10000(LL) time: " + jspeed + " ms ");
	      System.out.println("Kisch sort 10000(LL) time: " + myspeed + " ms \n ");
	      
	}
	

}
