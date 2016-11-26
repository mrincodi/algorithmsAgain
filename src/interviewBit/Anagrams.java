package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

 Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
 Note: All inputs will be in lower-case. 
Example :

Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4. 
dog and god are another set of anagrams which correspond to index 2 and 3.
The indices are 1 based ( the first element has index 1 instead of index 0).

 Ordering of the result : You should not change the relative ordering of the words / phrases 
 
 * @author mrincodi
 * 2016-09-16
 * Comment: Easy...
 *
 */
public class Anagrams {

		public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
		    
		    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		    
		    HashMap <String, ArrayList <Integer> > anagrams  = new HashMap < String, ArrayList < Integer>> ();
		    
		    for ( int i = 0 ; i < a.size();i++ ){
		        String word = a.get(i);
		        String sortedLetters = sortLetters (word); //TODO
		        
		        if ( !anagrams.containsKey ( sortedLetters ) ){
		            ArrayList <Integer> newEntry = new ArrayList <Integer> ( );
		            newEntry.add (i+1);

		            anagrams.put ( sortedLetters, newEntry );
		        }
		        else {
		            anagrams.get(sortedLetters).add(i+1);
		        }
		    }

	        Iterator <String> iter = anagrams.keySet().iterator();
	        
	        while ( iter.hasNext ()){
	            ArrayList<Integer> entry = anagrams.get (iter.next());
	                
	            result.add ( entry);
	        }
	        
	        return result;
		}
		
		public String sortLetters ( String s ){
		    if ( s == null) return s;
		    
		    char [] letters = s.toCharArray ();
		    
		    Arrays.sort ( letters );
		    
		    return new String (letters);
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
