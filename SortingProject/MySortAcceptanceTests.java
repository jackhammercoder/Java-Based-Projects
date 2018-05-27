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
public class MySortAcceptanceTests
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

   private static ArrayList<Integer> list_random_1M   = new ArrayList<Integer>(100000);
   
   private static ArrayList<Integer>  list_expected_10K =  new ArrayList<Integer>(10000);
   private static ArrayList<Integer>  list_10K_AL_1     =  new ArrayList<Integer>(10000);
   private static LinkedList<Integer> list_10K_LL_1     = new LinkedList<Integer>();

   private static ArrayList<Integer>  list_expected_100K =  new ArrayList<Integer>(100000);
   private static ArrayList<Integer>  list_100K_AL_1     =  new ArrayList<Integer>(100000);
   private static LinkedList<Integer> list_100K_LL_1     = new LinkedList<Integer>();

   @BeforeClass
   public static void before()
   {      
      Random random = new Random(555);
      Integer value;

      for (int i = 0; i < 100000; i++)
      {
         int val = random.nextInt();
         list_random_1M.add(val);
      }
      
      for (int i = 0; i < 10000; i++)
      {
         value = list_random_1M.get(i);
         list_expected_10K.add(value);
         list_10K_AL_1.add(value);
         list_10K_LL_1.add(value);
      }
      Collections.sort(list_expected_10K);
      
      for (int i = 0; i < 100000; i++)
      {
         value = list_random_1M.get(i);
         list_expected_100K.add(value);
         list_100K_AL_1.add(value);
         list_100K_LL_1.add(value);
      }
      Collections.sort(list_expected_100K);
      
   }

   @Test(timeout = 1000)
   public void test01_myArrayListPerformance_10K()
   {
      MySort.sort(list_10K_AL_1);
   }
   
   @Test
   public void test02_mySortArrayListVerifyOrder_10K()
   {
      int i = 0;
      for (Integer item : list_10K_AL_1)
         assertEquals(item, list_expected_10K.get(i++));
   }
   
   @Test(timeout = 2000)
   public void test03_mySortArrayListPerformance_100K()
   {
      MySort.sort(list_100K_AL_1);
   }
   
   @Test
   public void test04_mySortArrayListVerifyOrder_100K()
   {
      int i = 0;
      for (Integer item : list_100K_AL_1)
         assertEquals(item, list_expected_100K.get(i++));
   }
     
   @Test(timeout = 1000)
   public void test05_mergeSortLinkedListPerformance_10K()
   {
      MySort.sort(list_10K_LL_1);
   }
   
   @Test
   public void test06_mySortLinkedListVerifyOrder_10K()
   {
      int i = 0;
      for (Integer item : list_10K_LL_1)
         assertEquals(item, list_expected_10K.get(i++));
   }
   
   @Test(timeout = 2000)
   public void test07_mySortLinkedListPerformance_100K()
   {
      MySort.sort(list_100K_LL_1);
   }
   
   @Test
   public void test08_mySortLinkedListVerifyOrder_100K()
   {
      int i = 0;
      for (Integer item : list_100K_LL_1)
         assertEquals(item, list_expected_100K.get(i++));
   }

} 
