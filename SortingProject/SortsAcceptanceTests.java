/**
 * JUnit tests for Sorts assignment.
 *
 * @author Paul Hatalsky
 * @version 3/3/2016 Developed for CPE 103 Program 6a - merge and quick sort. 
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortsAcceptanceTests
{
   @Rule
   public TestRule watcher = new TestWatcher() {
      protected void starting(Description description) {
         System.out.print("Starting: " + description.getMethodName() + "...");
      }
   };
   @Rule
   public Stopwatch sw = new Stopwatch() {
      protected void finished(long nanos, Description description) {
         System.out.println(" (" + runtime(TimeUnit.MILLISECONDS) + " ms)");
      }
      protected void succeeded(long nanos, Description description) {
         System.out.print("Passed");
      }
      protected void failed(long nanos, Throwable e, Description description) {
         System.out.print("Failed");
      }
   };

   private static final Class cls = Sorts.class;

   @Test
   public void test01_verifySuperClass()
   {
      assertTrue(cls.getSuperclass() == Object.class);
   }

   @Test
   public void test02_verifyInterfaces()
   {
      Class[] faces = cls.getInterfaces();
      assertTrue(faces.length == 0);
   }

   @Test
   public void test03_verifyFields()
   {
      Field[] fields = cls.getDeclaredFields();
      assertTrue(fields.length == 0);
   }

   @Test
   public void test04_verifyConstructors()
   {
      Constructor[] cons = cls.getDeclaredConstructors();
      assertTrue(cons.length <= 1);
   }

   @Test
   public void test05_verifyMethods()
   {
      int countPublic = 0;
      int countProtected = 0;
      int countPackage = 0;
      int countPrivate = 0;

      Method[] meths = cls.getDeclaredMethods();

      for (Method m : meths)
      {
         if (Modifier.isPublic(m.getModifiers()))
         {
            countPublic++;
         }
         else if (Modifier.isProtected(m.getModifiers()))
         {
            countProtected++;
         }
         else if (Modifier.isPrivate(m.getModifiers()))
         {
            countPrivate++;
         }
         else
         {
            countPackage++;
         }
      }

      assertEquals(2, countPublic);
      assertEquals(0, countPackage);
      assertEquals(0, countProtected);
   }

   private static ArrayList<Integer> list_random_1M   = new ArrayList<Integer>(1000000);
   
   private static ArrayList<Integer>  list_expected_10K =  new ArrayList<Integer>(10000);
   private static ArrayList<Integer>  list_10K_AL_1     =  new ArrayList<Integer>(10000);
   private static ArrayList<Integer>  list_10K_AL_2     =  new ArrayList<Integer>(10000);
   private static LinkedList<Integer> list_10K_LL_1     = new LinkedList<Integer>();
   private static LinkedList<Integer> list_10K_LL_2     = new LinkedList<Integer>();

   private static ArrayList<Integer>  list_expected_100K =  new ArrayList<Integer>(100000);
   private static ArrayList<Integer>  list_100K_AL_1     =  new ArrayList<Integer>(100000);
   private static ArrayList<Integer>  list_100K_AL_2     =  new ArrayList<Integer>(100000);
   private static LinkedList<Integer> list_100K_LL_1     = new LinkedList<Integer>();
   private static LinkedList<Integer> list_100K_LL_2     = new LinkedList<Integer>();

   private static ArrayList<Integer>  list_expected_1000K =  new ArrayList<Integer>(1000000);
   private static ArrayList<Integer>  list_1000K_AL_1     =  new ArrayList<Integer>(1000000);
   private static ArrayList<Integer>  list_1000K_AL_2     =  new ArrayList<Integer>(1000000);
   private static LinkedList<Integer> list_1000K_LL_1     = new LinkedList<Integer>();
   private static LinkedList<Integer> list_1000K_LL_2     = new LinkedList<Integer>();

   private static ArrayList<String>  list_expected_str =  new ArrayList<String>();
   private static ArrayList<String>  list_str_AL_1     =  new ArrayList<String>();
   private static ArrayList<String>  list_str_AL_2     =  new ArrayList<String>();
   private static LinkedList<String> list_str_LL_1     = new LinkedList<String>();
   private static LinkedList<String> list_str_LL_2     = new LinkedList<String>();

   @BeforeClass
   public static void before()
   {      
      Random random = new Random(555);
      Integer value;

      for (int i = 0; i < 1000000; i++)
      {
         int val = random.nextInt();
         list_random_1M.add(val);
      }
      
      for (int i = 0; i < 10000; i++)
      {
         value = list_random_1M.get(i);
         list_expected_10K.add(value);
         list_10K_AL_1.add(value);
         list_10K_AL_2.add(value);
         list_10K_LL_1.add(value);
         list_10K_LL_2.add(value);
      }
      Collections.sort(list_expected_10K);
      
      for (int i = 0; i < 100000; i++)
      {
         value = list_random_1M.get(i);
         list_expected_100K.add(value);
         list_100K_AL_1.add(value);
         list_100K_AL_2.add(value);
         list_100K_LL_1.add(value);
         list_100K_LL_2.add(value);
      }
      Collections.sort(list_expected_100K);
      
      for (int i = 0; i < 1000000; i++)
      {
         value = list_random_1M.get(i);
         list_expected_1000K.add(value);
         list_1000K_AL_1.add(value);
         list_1000K_AL_2.add(value);
         list_1000K_LL_1.add(value);
         list_1000K_LL_2.add(value);
      }
      Collections.sort(list_expected_1000K);
      
      String s = "this is a random string of words that should be able to be sorted by merge sort and quick sort";
      Scanner sc = new Scanner(s);
      String word;
      while (sc.hasNext())
      {
         word = sc.next();
         list_expected_str.add(word);
         list_str_AL_1.add(word);
         list_str_AL_2.add(word);
         list_str_LL_1.add(word);
         list_str_LL_2.add(word);
      }
       Collections.sort(list_expected_str);
   }

   @Test(timeout = 120)
   public void test06_mergeSortArrayListPerformance_10K()
   {
      Sorts.mergeSort(list_10K_AL_1);
   }
   
   @Test
   public void test07_mergeSortArrayListVerifyOrder_10K()
   {
      int i = 0;
      for (Integer item : list_10K_AL_1){
    	  assertEquals(item, list_expected_10K.get(i++));
      }
   }
   
   @Test(timeout = 200)
   public void test08_mergeSortArrayListPerformance_100K()
   {
      Sorts.mergeSort(list_100K_AL_1);
   }
   
   @Test
   public void test09_mergeSortArrayListVerifyOrder_100K()
   {
      int i = 0;
      for (Integer item : list_100K_AL_1)
         assertEquals(item, list_expected_100K.get(i++));
   }
   
   @Test(timeout = 2000)
   public void test10_mergeSortArrayListPerformance_1000K()
   {
      Sorts.mergeSort(list_1000K_AL_1);
   }
   
   @Test
   public void test11_mergeSortArrayListVerifyOrder_1000K()
   {
      int i = 0;
      
      
      for (Integer item : list_1000K_AL_1)
         assertEquals(item, list_expected_1000K.get(i++));
   }
   
   @Test(timeout = 120)
   public void test12_quickSortArrayListPerformance_10K()
   {
      Sorts.quickSort(list_10K_AL_2);
   }
   
   @Test
   public void test13_quickSortArrayListVerifyOrder_10K()
   {
      int i = 0;
      for (Integer item : list_10K_AL_2)
         assertEquals(item, list_expected_10K.get(i++));
   }
   
   @Test(timeout = 160)
   public void test14_quickSortArrayListPerformance_100K()
   {
      Sorts.quickSort(list_100K_AL_2);
   }
   
   @Test
   public void test15_quickSortArrayListVerifyOrder_100K()
   {
      int i = 0;
      for (Integer item : list_100K_AL_2)
         assertEquals(item, list_expected_100K.get(i++));
   }
   
   @Test(timeout = 1200)
   public void test16_quickSortArrayListPerformance_1000K()
   {
      Sorts.quickSort(list_1000K_AL_2);
   }
   
   @Test
   public void test17_quickSortArrayListVerifyOrder_1000K()
   {
      int i = 0;
      for (Integer item : list_1000K_AL_2)
         assertEquals(item, list_expected_1000K.get(i++));
   }

   @Test(timeout = 80)
   public void test18_mergeSortLinkedListPerformance_10K()
   {
      Sorts.mergeSort(list_10K_LL_1);
   }
   
   @Test
   public void test19_mergeSortLinkedListVerifyOrder_10K()
   {
      int i = 0;
      for (Integer item : list_10K_LL_1)
         assertEquals(item, list_expected_10K.get(i++));
   }
   
   @Test(timeout = 200)
   public void test20_mergeSortLinkedListPerformance_100K()
   {
      Sorts.mergeSort(list_100K_LL_1);
   }
   
   @Test
   public void test21_mergeSortLinkedListVerifyOrder_100K()
   {
      int i = 0;
      for (Integer item : list_100K_LL_1)
         assertEquals(item, list_expected_100K.get(i++));
   }
   
   @Test(timeout = 2000)
   public void test22_mergeSortLinkedListPerformance_1000K()
   {
      Sorts.mergeSort(list_1000K_LL_1);
   }
   
   @Test
   public void test23_mergeSortLinkedListVerifyOrder_1000K()
   {
      int i = 0;
      for (Integer item : list_1000K_LL_1)
         assertEquals(item, list_expected_1000K.get(i++));
   }
   
   @Test(timeout = 80)
   public void test24_quickSortLinkedListPerformance_10K()
   {
      Sorts.quickSort(list_10K_LL_2);
   }
   
   @Test
   public void test25_quickSortLinkedListVerifyOrder_10K()
   {
      int i = 0;
      for (Integer item : list_10K_LL_2)
         assertEquals(item, list_expected_10K.get(i++));
   }
   
   @Test(timeout = 160)
   public void test26_quickSortLinkedListPerformance_100K()
   {
      Sorts.quickSort(list_100K_LL_2);
   }
   
   @Test
   public void test26_quickSortLinkedListVerifyOrder_100K()
   {
      int i = 0;
      for (Integer item : list_100K_LL_2)
         assertEquals(item, list_expected_100K.get(i++));
   }
   
   @Test(timeout = 1600)
   public void test28_quickSortLinkedListPerformance_1000K()
   {
      Sorts.quickSort(list_1000K_LL_2);
   }
   
   @Test
   public void test29_quickSortLinkedListVerifyOrder_1000K()
   {
      int i = 0;
      for (Integer item : list_1000K_LL_2)
         assertEquals(item, list_expected_1000K.get(i++));
   }

   @Test
   public void test30_mergeSortArrayListStrings()
   {
      Sorts.mergeSort(list_str_AL_1);
      int i = 0;
      for (String s : list_str_AL_1)
         assertEquals(s, list_expected_str.get(i++));
   }

   @Test
   public void test31_quickSortArrayListStrings()
   {
      Sorts.quickSort(list_str_AL_2);
      int i = 0;
      for (String s : list_str_AL_2)
         assertEquals(s, list_expected_str.get(i++));
   }

   @Test
   public void test32_mergeSortLinkedListStrings()
   {
      Sorts.mergeSort(list_str_LL_1);
      int i = 0;
      for (String s : list_str_LL_1)
         assertEquals(s, list_expected_str.get(i++));
   }
 
   @Test
   public void test33_quickSortLinkedListStrings()
   {
      Sorts.quickSort(list_str_LL_2);
      int i = 0;
      for (String s : list_str_LL_2)
         assertEquals(s, list_expected_str.get(i++));
   }
} 
