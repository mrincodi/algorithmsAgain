package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * https://www.careercup.com/question?id=5676588776554496
 * 
 * 
 * Given a dictionary and a string, find all the substrings that are valid words in dictionary. 

 * @author mrincodi
 *
 */
public class SubstringsInDict {

	public ArrayList <String > getVaidSubstrings ( ArrayList<String> dict, String s){
		ArrayList <String > result = new ArrayList <String > ();

		//Put words in HashSet
		HashSet <String> h = new HashSet <String> ();

		for ( String word:dict){h.add(word);}

		for ( int i = 0; i < s.length(); i++){
			for ( int j = i+1; j < s.length(); j++){
				String substring = s.substring(i,j);
				if ( h.contains(substring)) result.add(substring);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList < String > dict = new ArrayList <String> (Arrays.asList("a","empa", "nada"));
		String word = "empanadailla";
		ArrayList < String > subWords = new SubstringsInDict().getVaidSubstrings(dict, word);
		for ( String ss : subWords){
			System.out.println (ss);
		}
	}

}
