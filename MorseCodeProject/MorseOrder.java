/** 
 * MorseOrder class
 * 
 * @author Jonathan Kisch
 * @version Project 4
 */ 
public class MorseOrder extends MorseCode implements Comparable<MorseOrder> {

	protected MorseOrder(MorseCode that) {
		super(that);
	}
	
	protected MorseOrder(Character character, String code)
	   {
	      super(character, code);
	   }

	public int compareTo(MorseOrder morse) {
	   if (this.getCode().compareTo(morse.getCode()) < 0){
		   return -1;
	   }
	   else if (this.getCode().compareTo(morse.getCode()) > 0 ){
		   return 1;
	   }
	   return 0;
	}
	

}
