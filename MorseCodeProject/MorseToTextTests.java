/** 
	 * MorseToText JUNIT TEST Class 
	 * 
	 * @author Jonathan Kisch 
	 * @version Project 4
	 */ 

	import static org.junit.Assert.*; 

	import java.util.ArrayList;
	import java.util.NoSuchElementException;

	import javax.swing.text.html.HTMLDocument.Iterator;

	import org.junit.*; 

public class MorseToTextTests {
	
	@Test
	public void testGet(){
		MorseToText test = new MorseToText();
		BST<MorseOrder> bst = test.getBST();
		MorseOrder n = new MorseOrder(null, ".-.");
		MorseOrder m = new MorseOrder(null, "..--.-");
		MorseOrder o = new MorseOrder(null, ".-..-.");
		assertTrue(bst.contains(n));
		assertTrue(bst.contains(m));
		assertTrue(bst.contains(o));
	}
	
	@Test
	public void testconvert(){
		MorseToText test = new MorseToText();
		String str = test.translate("    .... . .-.. .-.. ---   .--. / .- ..- .-.. /////   "); //some invaliud things inbetween;
		assertTrue(str.equals("HELLO  PAUL"));
		
	}
	
	@Test
	public void testconvert2(){
		MorseToText test = new MorseToText();
		String str = test.translate("-- -.--  -... --- .-.. --- --. -. .  .... .- ...  .-  ... . -.-. --- -. -..  -. .- -- .  ..--.. ..--.. ..--.. .-.-.- .-.-.- .-.-.- .-.-.-     ");
		assertTrue(str.equals("MY BOLOGNE HAS A SECOND NAME ???...."));
		
	}
	
	

}
