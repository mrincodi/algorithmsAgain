package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LetterPhone {

	HashMap <Character, ArrayList<Character>> numToLetters = new HashMap <Character, ArrayList<Character>>();

	public ArrayList<String> letterCombinations(String a) {

		numToLetters.put ('0', new ArrayList<Character>(Arrays.asList('0')));
		numToLetters.put ('1', new ArrayList<Character>(Arrays.asList('1')));
		numToLetters.put ('2', new ArrayList<Character>(Arrays.asList('a','b','c')));
		numToLetters.put ('3', new ArrayList<Character>(Arrays.asList('d','e','f')));
		numToLetters.put ('4', new ArrayList<Character>(Arrays.asList('g','h','i')));
		numToLetters.put ('5', new ArrayList<Character>(Arrays.asList('j','k','l')));
		numToLetters.put ('6', new ArrayList<Character>(Arrays.asList('m','n','o')));
		numToLetters.put ('7', new ArrayList<Character>(Arrays.asList('p','q','r','s')));
		numToLetters.put ('8', new ArrayList<Character>(Arrays.asList('t','u','v')));
		numToLetters.put ('9', new ArrayList<Character>(Arrays.asList('w','x','y','z')));

		return letterCombinations1 (a, numToLetters);
	}		    		

	public ArrayList<String> letterCombinations1(String a, HashMap <Character, ArrayList<Character>> numToLetters) {

		ArrayList<String> result = new ArrayList<String> ();
		if ( a.length ()==0) return result;

		char number = a.charAt(0);

		if (a.length() == 1){

			ArrayList <Character> chars =  new ArrayList <Character>( numToLetters.get(number));
			for ( char c:chars){
				result.add("" + c);
			}

			return result;
		}

		ArrayList<String> partialResult = letterCombinations (a.substring(1));

		ArrayList<Character>initialLetters = numToLetters.get(a.charAt(0));

		for ( String partialResultString: partialResult ){
			for ( char initial:initialLetters){
				result.add (initial + partialResultString);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
