package googleInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;



class SorterBySize implements Comparator <String> {
	@Override
	public int compare (String a, String b){
		if ( a == null || b == null ) return -2;
		if ( a.length () > b.length ()) return 1;
		if ( a.length () == b.length ()) return a.compareTo(b);
		return -1;
	}

}



public class GoogleChallengeBefore {


	ArrayList < String > findWords ( ArrayList <String> words, ArrayList <Character> letters){

		ArrayList < String > result = new ArrayList <String > ();

		HashMap < Character, Integer > lettersHashMap = new HashMap < Character, Integer > ();

		//Create the hashMap.
		for ( char c: letters ){
			if ( !lettersHashMap.containsKey ( c))
				lettersHashMap.put (c,1);
			else 
				lettersHashMap.put (c,lettersHashMap.get(c)+1);
		}

		for ( String word: words ){
			//See if it's valid.
			HashMap <Character, Integer> checkerHashMap = new HashMap  <Character, Integer> (lettersHashMap);
			char [] wordLetters = word.toCharArray();

			boolean valid = true;
			for ( int i = 0; i < wordLetters.length; i++ ){
				char c = wordLetters[i];
				if ( !checkerHashMap.containsKey(c))
					valid = false;
				else {
					int amount = checkerHashMap.get(c);
					if ( amount > 1 )
						checkerHashMap.put(c,amount-1);
					else 
						checkerHashMap.remove(c);
				}
			}
			if (valid)
				result.add ( word);
		}

		Collections.sort(result,  Collections.reverseOrder(new SorterBySize()));

		return result;
	}

	ArrayList <String > getLongestWords ( ArrayList <String > words ){
		ArrayList <String > result = new ArrayList <String > ();
		int maxSizeSoFar = 0;

		for (String word:words){
			if (word.length () > maxSizeSoFar ){
				result = new ArrayList <String > ();
				result.add ( word);
				maxSizeSoFar = word.length () ;
			}
			else if (word.length () == maxSizeSoFar ){
				result.add (word);
			}
		}

		return result;
	}



	public static void main ( String [] args ){

		ArrayList <Character >chars = new ArrayList <Character> ( Arrays.asList( 't', 'i', 'm', 'e' ));

		ArrayList <String> dictionary = new ArrayList <String > (Arrays.asList( "timeline",
				"limit", 
				"elite", 
				"inlet", 
				"tile", 
				"lien", 
				"lite", 
				"emit", 
				"teen", 
				"teem", 
				"tine", 
				"item", 
				"lime", 
				"time", 
				"lint", 
				"line", 
				"mite", 
				"mint", 
				"mini", 
				"mine", 
				"milt", 
				"mile", 
				"lent", 
				"mien", 
				"meet", 
				"mete", 
				"nite", 
				"limn", 
				"melt", 
				"lee", 
				"men", 
				"lie", 
				"lit", 
				"net", 
				"nee", 
				"eel", 
				"met", 
				"nit", 
				"tie", 
				"tee", 
				"let", 
				"mil", 
				"lei", 
				"ten", 
				"tin", 
				"elm", 
				"nil", 
				"in", 
				"me", 
				"en", 
				"mi", 
				"em", 
				"it", 
				"ti", 
				"el", 
		"i"));
		
		ArrayList <String> wordies = new GoogleChallengeBefore().findWords(dictionary, chars);
//		ArrayList <String> wordies2 = new GoogleChallengeBefore().getLongestWords(wordies);
		
		for ( String word: wordies){
			System.out.println(word);
		}
	}
}
