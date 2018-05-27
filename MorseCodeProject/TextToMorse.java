import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/** 
 * Text to MOres Class 
 * 
 * @author Jonathan Kisch
 * @version Project 4
 */ 

public class TextToMorse implements BSTTranslator<CharacterOrder> {
	private ArrayList<CharacterOrder> stufftoadd = getarray();
	private BST<CharacterOrder> bst = new BST<CharacterOrder>();
	public TextToMorse(){ // default constructor
		makeBST(stufftoadd, 0, stufftoadd.size() -1);
		
	}
	
	
	public BST<CharacterOrder> getBST() {
		return bst;
	}

	public String translate(String str) {
		CharacterOrder find;
		Scanner input = new Scanner(str);
		String output = "";
		while(input.hasNext()){
			String bob = input.next(); 
			for(int i = 0 ; i < bob.length() ; i++){
				Character sally = bob.charAt(i);
				find = new CharacterOrder(sally, null);  
				if (bst.contains(find)){
				CharacterOrder lookup = bst.get(find);
				output = output + lookup.getCode() + " ";
				}
			}
			output = output + " ";
			
		}
		input.close();
		String newoutput = output.trim();
		return newoutput;
	}
	
	private ArrayList<CharacterOrder> getarray(){			// helper method to get morse ordered array;
		ArrayList<CharacterOrder> ordered = new ArrayList<>();
		for ( int i = 0 ; i < MorseCode.size(); i++){
			MorseCode bob = MorseCode.get(i);
			CharacterOrder add = new CharacterOrder(bob);
			ordered.add(add);
		}
		Collections.sort(ordered);
		return ordered;
		
	}
	
	private void makeBST(ArrayList<CharacterOrder> stuff , int low, int high) {  //// helper method to get morse ordered binary tree;
	
		if (high < low){
			return;
		}
		 
		int mid = (low + high) / 2;
		 
		 bst.insert(stuff.get(mid));
		 
		 makeBST(stuff, low , mid -1);
		 
		 makeBST(stuff, mid + 1, high);
		 
	}

}
