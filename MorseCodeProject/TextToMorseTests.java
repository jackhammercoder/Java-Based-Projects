/** 
 * Text to morse JUNIT TEST Class 
 * 
 * @author Jonathan Kisch
 * @version Project 4
 */ 

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TextToMorseTests {
	@Test
	public void testGet(){
		TextToMorse test = new TextToMorse();
		BST<CharacterOrder> bst = test.getBST();
		CharacterOrder n = new CharacterOrder("0".charAt(0), null);
		CharacterOrder m = new CharacterOrder("B".charAt(0), null);
		CharacterOrder o = new CharacterOrder("@".charAt(0), null);
		assertTrue(bst.contains(n));
		assertTrue(bst.contains(m));
		assertTrue(bst.contains(o));
	}
	
	@Test
	public void testconvert(){
		TextToMorse test = new TextToMorse();
		String str = test.translate("HE^LL^O  P^AU^L? ^^^^^     "); //some invaliud things inbetween;
		assertTrue(str.equals(".... . .-.. .-.. ---  .--. .- ..- .-.. ..--.."));
		
	}
	
	@Test
	public void testconvert2(){
		TextToMorse test = new TextToMorse();
		String str = test.translate("BO^B   IS 403    YEARS    O^LD?    ");
		assertTrue(str.equals("-... --- -...  .. ...  ....- ----- ...--  -.-- . .- .-. ...  --- .-.. -.. ..--.."));
		
	}
	

}
