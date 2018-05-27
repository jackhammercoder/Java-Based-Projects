/** 
 * CharacterOrder class
 * 
 * @author Jonathan Kisch
 * @version Project 4
 */ 

public class CharacterOrder extends MorseCode implements Comparable<CharacterOrder> {

	protected CharacterOrder(Character character, String code) {
		super(character, code);
	}
	
	protected CharacterOrder(MorseCode that) {
		super(that);
	}

	public int compareTo(CharacterOrder morseobj) {
		if (this.getCharacter().compareTo(morseobj.getCharacter()) < 0){
			   return -1;
		   }
		   else if (this.getCharacter().compareTo(morseobj.getCharacter()) > 0 ){
			   return 1;
		   }
		   else{
			   return 0;
		   }
	}

}
