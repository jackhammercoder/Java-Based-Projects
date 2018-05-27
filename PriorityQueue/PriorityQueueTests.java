/**
 * Simple Queue interface.
 *
 * @author Jonathan Kisch
 * @version 2/5/2016 Developed for CPE 103 project 3
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;

public class PriorityQueueTests {
	
	@Test //this is a test to see if my first constructor has a Priority Queue of size 0 when formed
	   public void test01_sizeAtConstruction1()
	   {
	      PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	      assertTrue(q.size() == 0);
	   }
	
	@Test //this is a test to see if my Second constructor has a Priority Queue of size 0 when formed
	   public void test02_sizeAtConstruction2()
	   {
	      PriorityQueue<Integer> q1 = new PriorityQueue<Integer>(false);  // if i specify false
	      assertTrue(q1.size() == 0);
	      
	      PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(true);  // if i specify true it should be the same
	      assertTrue(q2.size() == 0);
	       
	   }
	
	 @Test
	   public void test03_sizeAtConstruction3()
	   {
	      Integer[] a = new Integer[] {9};
	      PriorityQueue<Integer> q = new PriorityQueue<Integer>(a, 1);
	      assertTrue(q.size() == 1);
	      
	      a = new Integer[] {33, 21837213, 12098321, 01235, 984324};
	      q = new PriorityQueue<Integer>(a, 4);
	      assertTrue(q.size() == 4);
	      
	      a = new Integer[] {1, 1, 1, 1, 1,  1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,};
	      q = new PriorityQueue<Integer>(a, 10);
	      assertTrue(q.size() == 10);
	   }

	   @Test
	   public void test04_sizeAtConstruction4()
	   {
	      Integer[] a = new Integer[] {10};
	      PriorityQueue<Integer> q = new PriorityQueue<Integer>(a, 1, true);
	      assertTrue(q.size() == 1);
	      
	      a = new Integer[] {1, 2, 3, 56, 999 , 9324};
	      q = new PriorityQueue<Integer>(a, 5, true);
	      assertTrue(q.size() == 5);
	      
	      a = new Integer[] {32748, 29834};
	      q = new PriorityQueue<Integer>(a, 2, true);
	      assertTrue(q.size() == 2);
	      
	      a = new Integer[] {-100000};
	      q = new PriorityQueue<Integer>(a, 1, false);
	      assertTrue(q.size() == 1);
	      
	      a = new Integer[] {1, 2, 3};
	      q = new PriorityQueue<Integer>(a, 2, false);
	      assertTrue(q.size() == 2);
	      
	      a = new Integer[] {1, 2, 3, -1, -1, -1, -1, -1, -1,};
	      q = new PriorityQueue<Integer>(a, 6, false);
	      assertTrue(q.size() == 6);
	   }

	   @Test(expected = NoSuchElementException.class)
	   public void test5_dequeueAtConstruction1()
	   {
	      PriorityQueue<String> q = new PriorityQueue<String>();
	      q.dequeue();
	   }

	   @Test(expected = NoSuchElementException.class)
	   public void test6_dequeueAtConstruction2True()
	   {
	      PriorityQueue<String> q = new PriorityQueue<String>(true);
	      q.dequeue();
	   }
	   
	   @Test(expected = NoSuchElementException.class)
	   public void test7_dequeueAtConstruction2False()
	   {
	      PriorityQueue<String> q = new PriorityQueue<String>(false);
	      q.dequeue();
	   }
	   
	   @Test
	   public void test8_dequeueAtConstruction3()
	   {
	      String[] array = new String[] { "hello", "there", "jonathan" , "amazing", "a" };
	      PriorityQueue<String> q = new PriorityQueue<String>(array, array.length);
	      assertEquals(array[4], q.dequeue());
	      assertEquals(array[3], q.dequeue());
	   }

	   @Test
	   public void test9_dequeueAtConstruction4()
	   {
	      String[] array = new String[] { "hello", "world", "aardvark" };
	      PriorityQueue<String> q = new PriorityQueue<String>(array, array.length, true);
	      PriorityQueue<String> p = new PriorityQueue<String>(array, array.length, false);
	      assertEquals(array[1], q.dequeue());
	      assertEquals(array[0], q.dequeue());
	      assertEquals(array[2], p.dequeue());
	      assertEquals(array[0], p.dequeue());
	   }

	   
	   @Test(expected = NoSuchElementException.class)
	   public void test10_peekAtConstruction1()
	   {
	      PriorityQueue<String> q = new PriorityQueue<String>();
	      q.peek();
	   }

	   @Test(expected = NoSuchElementException.class)
	   public void test11_peekAtConstruction2()
	   {
	      PriorityQueue<String> q = new PriorityQueue<String>(true);
	      q.peek();
	      PriorityQueue<String> p = new PriorityQueue<String>(false);
	      p.peek();
	   }

	  
	   @Test
	   public void test12_peekAtConstruction3()
	   {
	      String[] array = new String[] { "what" , "is" , "up?"};
	      PriorityQueue<String> q = new PriorityQueue<String>(array, array.length);
	      assertEquals(array[1], q.peek());
	   }

	   @Test
	   public void test13_peekAtConstruction4()
	   {
	      String[] array = new String[] { "a", "bb", "ccc", "dddd" };
	      PriorityQueue<String> q = new PriorityQueue<String>(array, array.length, true);
	      assertEquals(array[3], q.peek());
	      PriorityQueue<String> p = new PriorityQueue<String>(array, array.length, false);
	      assertEquals(array[0], p.peek());
	   }

	   @Test
	   public void test14_enqueuealotpeek()
	   {
	      PriorityQueue<Integer> q = new PriorityQueue<Integer>();

	      q.enqueue(39);
	      q.enqueue(1);
	      q.enqueue(14);
	      q.enqueue(15);
	      q.enqueue(16);
	      q.enqueue(0);
	      q.enqueue(-1000);
	      q.enqueue(14);
	      q.enqueue(14);
	      assertTrue(q.size() == 9);
	      assertTrue(q.peek() == -1000);
	   }
	   
	   @Test
	   public void test15_enqueuealotpeekusingmax()
	   {
	      PriorityQueue<Integer> q = new PriorityQueue<Integer>(true);

	      q.enqueue(39);
	      q.enqueue(1);
	      q.enqueue(14);
	      q.enqueue(15);
	      q.enqueue(16);
	      q.enqueue(0);
	      q.enqueue(-1000);
	      q.enqueue(14);
	      q.enqueue(14);
	      assertTrue(q.size() == 9);
	      assertTrue(q.peek() == 39);
	   }

	   @Test
	   public void test16_dequeuechecktopandsize()
	   {
		   PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		      q.enqueue(39);
		      q.enqueue(1);
		      q.enqueue(14);
		      q.enqueue(15);
		      q.enqueue(16);
		      q.enqueue(0);
		      q.enqueue(-1000);
		      q.enqueue(14);
		      q.enqueue(14);
		      assertTrue(q.size() == 9);
		      assertTrue(q.peek() == -1000);
		      
		     assertTrue(q.dequeue() == -1000);
		     assertTrue(q.size() == 8);
		     assertTrue(q.dequeue() == 0);
		     assertTrue(q.size() == 7);
		     assertTrue(q.dequeue() == 1);
		     assertTrue(q.size() == 6);
		     assertTrue(q.dequeue() == 14);
		     assertTrue(q.size() == 5);
		     assertTrue(q.dequeue() == 14);
		     assertTrue(q.size() == 4);
		     assertTrue(q.dequeue() == 14);
		     assertTrue(q.size() == 3);
		     assertTrue(q.dequeue() == 15);
		     assertTrue(q.size() == 2);
		     assertTrue(q.dequeue() == 16);
		     assertTrue(q.size() == 1);
		     assertTrue(q.dequeue() == 39);
		     assertTrue(q.size() == 0);
	      
	   }
	   
	   @Test
	   public void test16_dequeuechecktopandsizeFalse()
	   {
		   PriorityQueue<Integer> q = new PriorityQueue<Integer>(true);

		      q.enqueue(39);
		      q.enqueue(1);
		      q.enqueue(14);
		      q.enqueue(15);
		      q.enqueue(16);
		      q.enqueue(0);
		      q.enqueue(-1000);
		      q.enqueue(14);
		      q.enqueue(14);
		      assertTrue(q.size() == 9);
		      assertTrue(q.peek() == 39);
		     
		     assertTrue(q.dequeue() == 39); 
		     assertTrue(q.size() == 8);
		     assertTrue(q.dequeue() == 16);
		     assertTrue(q.size() == 7);
		     assertTrue(q.dequeue() == 15);
		     assertTrue(q.size() == 6);
		     assertTrue(q.dequeue() == 14);
		     assertTrue(q.size() == 5);
		     assertTrue(q.dequeue() == 14);
		     assertTrue(q.size() == 4);
		     assertTrue(q.dequeue() == 14);
		     assertTrue(q.size() == 3);
		     assertTrue(q.dequeue() == 1);
		     assertTrue(q.size() == 2);
		     assertTrue(q.dequeue() == 0);
		     assertTrue(q.size() == 1);
		     assertTrue(q.dequeue() == -1000);
		     assertTrue(q.size() == 0);
	      
	   }

	   @Test
	   public void test18_sortmethodtest()
	   {
		  Integer[] a = new Integer[] {-99, -180, 2 , 5};
		  Integer[] e = new Integer[] {-180, -99, 2, 5};
		  PriorityQueue.sort(a, a.length);
	      for(int i = 0 ; i < a.length ; i++){
	    	  assertTrue(Math.abs(a[i] - e[i]) < .000001); // thinks they are doubles for some reason so use this to compare
	      }
	   }

	   @Test
	   public void test19_kthTest()
	   {
	      Integer[] a = new Integer[] {13, 26, 9, 27, 5, 3, 33, 8, 99, 100, 56, 88, 100000, -100000, 4444, 8888};

	      assertTrue(PriorityQueue.kth(a, a.length, 1) == 100000);
	      assertTrue(PriorityQueue.kth(a, a.length, 2) == 8888);
	      assertTrue(PriorityQueue.kth(a, a.length, 3) == 4444);
	      assertTrue(PriorityQueue.kth(a, a.length, 4) == 100);
	      assertFalse(PriorityQueue.kth(a, a.length, 5) == 13);
	      assertTrue(PriorityQueue.kth(a, a.length, 16) == -100000);
	      
	   }

	   

	   private void verifyQueue(PriorityQueue<Integer> q, Integer[] expected)
	   {
	      for (int i = 0; i < expected.length; i++)
	      {
	         assertTrue(q.size() == expected.length - i);
	         assertTrue(q.peek() == expected[i]);
	         assertTrue(q.dequeue() == expected[i]);
	      }

	      assertTrue(q.size() == 0);
	   }
	}


