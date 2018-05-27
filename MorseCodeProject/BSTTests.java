/** 
 * BST JUNIT TEST Class 
 * 
 * @author Jonathan Kisch
 * @version Project 4
 */ 

import static org.junit.Assert.*; 

import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.*; 
 
public class BSTTests {
	
	@Test 
	public void test01_insertAndSize() { 
		BST<Integer> bst = new BST<Integer>() ;
		
		for(int i=-2; i < 5; i++){
			bst.insert(i) ;
		}
		
		assertEquals(7, bst.size()) ;
		for(int i=-2; i < 5; i++){
			assertTrue(bst.contains(i)) ;
		}
	} 
 
	@Test 
	public void test02_insertDoublesAndSize() { 
		BST<Integer> bst = new BST<Integer>() ;
		
		for(int i=-2; i < 5; i++){
			bst.insert(i) ;
			
		}
		bst.insert(-2);
		assertEquals(7, bst.size()) ;
	} 
	
	@Test 
	public void test03_minAndMax() { 
		BST<Integer> bst = new BST<Integer>() ;
		ArrayList<Integer> randomCrap = new ArrayList<Integer>() ;
		randomCrap.add(8) ;
		randomCrap.add(10) ;
		randomCrap.add(2) ;
		randomCrap.add(-45) ;
		randomCrap.add(-6) ;
		for(int i = 0; i < randomCrap.size(); i++){
			bst.insert(randomCrap.get(i)) ;
		}
		assertEquals((Integer) (-45), bst.minimum()) ;
		assertEquals((Integer) 10, bst.maximum()) ;
		
	}
	
	@Test 
	public void test04_sortingStuff() { 
		BST<Integer> bst = new BST<Integer>() ;
		
		ArrayList<Integer> randomCrap = new ArrayList<Integer>() ;
		randomCrap.add(8) ;
		randomCrap.add(10) ;
		randomCrap.add(2) ;
		randomCrap.add(-45) ;
		randomCrap.add(-6) ;
		
		ArrayList<Integer> sorted = new ArrayList<Integer>() ;
		sorted.add(-45) ;
		sorted.add(-6) ;
		sorted.add(2) ;
		sorted.add(8) ;
		sorted.add(10) ;
		
		for(int i = 0; i < randomCrap.size(); i++){
			bst.insert(randomCrap.get(i)) ;
		}
		ArrayList<Integer> expected = new ArrayList<Integer>() ;
		bst.toSortedList(expected) ;
		assertEquals(sorted, expected) ;

	}
	
	@Test 
	public void test04_removingStuff() { 
		BST<Integer> bst = new BST<Integer>() ;
		
		bst.insert(1) ;
		bst.insert(2) ;
		bst.insert(3) ;
		bst.insert(4) ;
		bst.insert(5) ;
		
		bst.remove(5);
		assertTrue(bst.maximum() == 4);
		bst.remove(4);
		assertTrue(bst.maximum() == 3);
		
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertTrue(bst.contains(3));
		assertFalse(bst.contains(5));
		assertFalse(bst.contains(4));
			

	}
	
	@Test 
	public void test04_internalPathandTreeheight() { 
		BST<Integer> bst = new BST<Integer>() ;
		
		bst.insert(1) ;
		bst.insert(2) ;
		bst.insert(3) ;
		bst.insert(4) ;
		bst.insert(5) ;
		
		long length = bst.internalPathLength();
		int height = bst.treeHeight();
		
	
		
		
	
}
	 @Test
	    public void test1_insertContain()
	    {
	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(12);
	        assertTrue(bst.contains(12));
	    }
	   
	    @Test
	    public void test2_insertContain2()
	    {
	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(12);
	        bst.insert(4);
	        bst.insert(9);
	        bst.insert(8);
	        bst.insert(1);
	        bst.insert(2);
	        bst.insert(3);
	        bst.insert(4);
	       
	        assertTrue(bst.contains(4));
	        assertTrue(bst.contains(1));
	        assertTrue(bst.contains(12));
	        assertTrue(bst.contains(9));
	    }
	   
	    @Test
	    public void test3_max()
	    {
	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(12);
	        bst.insert(4);
	        bst.insert(9);
	        bst.insert(8);
	        bst.insert(1);
	        bst.insert(2);
	        bst.insert(3);
	        bst.insert(4);
	       
	        assertTrue(bst.maximum() == 12);
	    }

	    @Test
	    public void test4_removes()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	        bst.insert(4);
	        bst.insert(9);
	        bst.insert(8);
	        bst.insert(1);
	        bst.insert(2);
	        bst.insert(3);
	   
	        bst.remove(4);
	        assertTrue(bst.size() == 6);
	        assertFalse(bst.contains(4));
	       
	       bst.remove(12);
	       assertTrue(bst.size() == 5);
	       assertFalse(bst.contains(12));
	       
	        bst.remove(1);
	        assertTrue(bst.size() == 4);
	        assertFalse(bst.contains(1));
	    }
	   
	    @Test(expected = NoSuchElementException.class)
	    public void test5_removes2()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	        bst.insert(4);
	        bst.insert(9);
	        bst.insert(8);
	        bst.insert(1);
	        bst.insert(2);
	        bst.insert(3);
	       
	        bst.remove(20);
	    }
	   
	    @Test(expected = NoSuchElementException.class)
	    public void test5_removesEmpty()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.remove(20);
	    }
	   
	    @Test
	    public void test6_internalPathLength()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	        bst.insert(4);
	        bst.insert(13);
	       
	        assertTrue(bst.internalPathLength() == 2);
	       
	    }
	   
	    @Test
	    public void test7_internalPathLength2()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	       
	        assertTrue(bst.internalPathLength() == 0);
	       
	    }
	   
	    @Test
	    public void test8_internalPathLength3()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	        bst.insert(13);
	       
	        assertTrue(bst.internalPathLength() == 1);
	       
	    }
	   
	    @Test
	    public void test9_internalPathLength4()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	        bst.insert(13);
	        bst.insert(4);
	        bst.insert(5);
	        bst.insert(3);
	   
	        assertTrue(bst.internalPathLength() == 6);
	    }
	   
	    @Test
	    public void test10_treeHeight()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	        bst.insert(13);
	        bst.insert(4);
	        bst.insert(5);
	        bst.insert(3);
	   
	        assertTrue(bst.treeHeight() == 2);
	    }
	   
	    @Test
	    public void test11_treeHeight2()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	        bst.insert(13);
	        bst.insert(4);
	        bst.insert(5);
	        bst.insert(3);
	        bst.insert(1);
	   
	        assertTrue(bst.treeHeight() == 3);
	    }
	   
	    @Test
	    public void test12_treeHeight3()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	        bst.insert(13);
	        bst.insert(4);
	        bst.insert(5);
	        bst.insert(3);
	        bst.insert(1);
	        bst.insert(15);
	   
	        assertTrue(bst.treeHeight() == 3);
	    }
	   
	    @Test
	    public void test13_treeHeight4()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	       
	        assertTrue(bst.treeHeight() == 0);
	    }
	   
	    @Test
	    public void test14_treeHeight5()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        assertTrue(bst.treeHeight() == -1);
	    }
	    
	    @Test
	    public void test20_internalPathLength4()
	    {
	        BST<Integer> bst = new BST<Integer>();
	       
	        bst.insert(12);
	       
	   
	        assertTrue(bst.internalPathLength() == 0);
	    }
	    
	    @Test
	    public void test21_GetMethod1()
	    {
	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(3);
	        bst.insert(4);
	        bst.insert(9);
	        bst.insert(8);
	        bst.insert(1);
	        bst.insert(2);
	        bst.insert(3);
	        bst.insert(4);
	       
	        assertTrue(bst.get(3) == 3);
	        assertTrue(bst.get(4) == 4);
	        assertTrue(bst.get(9) == 9);
	        assertTrue(bst.get(8) == 8);
	        assertTrue(bst.get(1) == 1);
	        assertTrue(bst.get(2) == 2);
	        assertTrue(bst.get(3) == 3);
	        assertTrue(bst.get(4) == 4);
	    }
	    
	    @Test (expected = NoSuchElementException.class)
	    public void test22_GetMethodFailure()
	    {
	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(12);
	        bst.insert(4);
	        bst.insert(9);
	        bst.insert(8);
	        bst.insert(1);
	        bst.insert(2);
	        bst.insert(3);
	        bst.insert(4);
	       
	        bst.get(10);
	    }
	    
	    @Test (expected = NoSuchElementException.class)
	    public void test23_GetMethodFailure()
	    {
	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(12);
	        bst.insert(4);
	        bst.insert(9);
	        bst.insert(8);
	        bst.insert(1);
	        bst.insert(2);
	        bst.insert(3);
	        bst.insert(4);
	       
	        bst.get(5);
	    }
	    
	    @Test (expected = NoSuchElementException.class)
	    public void test24_GetMethodFailure()
	    {
	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(12);
	        bst.insert(4);
	        bst.insert(9);
	        bst.insert(8);
	        bst.insert(1);
	        bst.insert(2);
	        bst.insert(3);
	        bst.insert(4);
	       
	        bst.get(-100000);
	    }
	    
	    @Test 
	    public void test25_next()
	    {
	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(5);
	        bst.insert(4);
	        bst.insert(6);
	        bst.insert(3);
	        bst.insert(4);
	        
	        java.util.Iterator<Integer> bob = bst.iterator();
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 3);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 4);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 5);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 6);
	        
	        assertTrue(bob.hasNext() == false);
	    }
	    
	    @Test 
	    public void test26_nexttest2()
	    {
	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(-500);
	        bst.insert(40000);
	        bst.insert(1111);
	        bst.insert(2);
	        bst.insert(0);
	        bst.insert(34);
	        bst.insert(37);
	        bst.insert(1);
	        
	        
	        java.util.Iterator<Integer> bob = bst.iterator();
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == -500);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 0);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 1);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 2);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 34);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 37);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 1111);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 40000);
	        
	        assertTrue(bob.hasNext() == false);
	    }
	    
	    @Test(expected = NoSuchElementException.class) 
	    public void test27_nexttesttheException()
	    {
	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(-500);
	        bst.insert(40000);
	        bst.insert(1111);
	        bst.insert(2);
	        bst.insert(0);
	        bst.insert(34);
	        bst.insert(37);
	        bst.insert(1);
	        
	        
	        java.util.Iterator<Integer> bob = bst.iterator();
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == -500);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 0);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 1);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 2);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 34);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 37);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 1111);
	        
	        assertTrue(bob.hasNext() == true);
	        assertTrue(bob.next() == 40000);
	        
	        bob.next();
	    }
	    
	    @Test (expected = UnsupportedOperationException.class)
	    public void test_28_removeunssuported(){

	        BST<Integer> bst = new BST<Integer>();
	        bst.insert(-500);
	        bst.insert(40000);
	        bst.insert(1111);
	        bst.insert(2);
	        bst.insert(0);
	        bst.insert(34);
	        bst.insert(37);
	        bst.insert(1);
	        
	        
	        java.util.Iterator<Integer> bob = bst.iterator();
	        bob.remove();
	    }
}



