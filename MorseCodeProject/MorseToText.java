/** 
 * MorseTOText Class 
 * 
 * @author Jonathan Kisch
 * @version Project 4
 */ 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MorseToText implements BSTTranslator<MorseOrder> {
	private ArrayList<MorseOrder> stufftoadd = getarray();
	private BST<MorseOrder> bst = new BST<MorseOrder>();
	public MorseToText(){ // default constructor
		makeBST(stufftoadd, 0, stufftoadd.size() -1);
	}
	
	
	public BST<MorseOrder> getBST() {
		return bst;
	}

	public String translate(String str) {
		MorseOrder find;
		Scanner input = new Scanner(str).useDelimiter("[ ]");
		String output = "";
		while(input.hasNext()){
			String bob = input.next();
			if (bob.equals("")){
				output = output + " ";
			}
			else {
				find = new MorseOrder(null, bob);  
				if (bst.contains(find)){
					
				
				MorseOrder lookup = bst.get(find);
				output = output + lookup.getCharacter();
				}
			}
			
		}
		input.close();
		String newoutput = output.trim();
		return newoutput;
	}
	
	private ArrayList<MorseOrder> getarray(){			// helper method to get morse ordered array;
		ArrayList<MorseOrder> ordered = new ArrayList<>();
		for ( int i = 0 ; i < MorseCode.size(); i++){
			MorseCode bob = MorseCode.get(i);
			MorseOrder add = new MorseOrder(bob);
			ordered.add(add);
		}
		Collections.sort(ordered);
		return ordered;
		
	}
	
	private void makeBST(ArrayList<MorseOrder> stuff , int low, int high) {  //// helper method to get morse ordered binary tree;
	
		if (high < low){
			return;
		}
		 
		int mid = (low + high) / 2;
		 
		 bst.insert(stuff.get(mid));
		 
		 makeBST(stuff, low , mid -1);
		 
		 makeBST(stuff, mid + 1, high);
		 
	}

}
