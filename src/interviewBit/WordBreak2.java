package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given

s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is
 [ "cats and dog", "cat sand dog" ] 

Make sure the strings are sorted in your result.

 * @author mrincodi
 * Comment: Another classic. One needs to make decisions with the boundary cases before even start.
 */
public class WordBreak2 {


	HashMap <String, ArrayList<String>> h = new HashMap <String, ArrayList <String>> ();
	public ArrayList<String> wordBreak(String a, ArrayList<String> b) {
		ArrayList<String> solution = new ArrayList<String> ();
		if (a.length () == 0 ) return solution;
		if (h.containsKey(a)) return h.get(a);

		for ( int i = 1; i <= a.length(); i++ ){

			//Look for the word in the dictionary. This can be enhanced with a hashSet,
			//instead of an ArrayList, but create another method for this.
			String possibleWord = a.substring (0,i);
			boolean isWord = false;
			for ( int j = 0; j < b.size() && !isWord; j++){
				if (b.get(j).equals(possibleWord)){
					//We found it!
					isWord=true;

					//If this word is the rest of the string, add this word.
					if ( i == a.length())
						solution.add (possibleWord);
					else{
						//Call the method with the rest of the string.
						ArrayList<String> rest = wordBreak (a.substring (i,a.length()),b);
						for ( int k = 0; k < rest.size(); k++ ){
							solution.add (possibleWord + " " + rest.get(k));
						}
					}
				}
			}
		}

		h.put(a,solution);

		return solution;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String hw = "helloworld";
		ArrayList<String> dict = new ArrayList <String> ( Arrays.asList("hello","world","he","llo"));
		ArrayList<String> al = new WordBreak2().wordBreak( hw, dict);

		for ( String word: al){
			System.out.println(word);
		}

	}

}
