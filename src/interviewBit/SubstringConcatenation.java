package interviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).

 * @author mrincodi
 * Comments: Easy peasy. I learned a couple things:
 * isEmpty can be used to check if HashMap is empty,
 * and you can create a HashMap out of another by putting the second
 * one as a parameter of the first one's builder. h2 = new HashMap (h1)
 * 2016-08-05
 */
public class SubstringConcatenation {

		public ArrayList<Integer> findSubstring(String a, final List<String> b) {
		    
		    ArrayList<Integer> result = new ArrayList<Integer> ();
		    if ( a == null || b == null || b.size() == 0 ) return result;

	        int wordSize = b.get(0).length();
	        int numWords = b.size();
	        
	        if (a.length () < wordSize * numWords ) return result;

		    HashMap <String, Integer> h1 = new HashMap <String, Integer> ();

		    //Fill the hashMap.
		    for ( int i = 0; i < b.size(); i++ ){
		        String word = b.get(i);
		        if ( h1.containsKey (word)){
		            h1.put (word, h1.get(word)+1);
		        }
		        else {
	    	        h1.put (word, 1);
		        }
		    }
		    
		    boolean qq = false;
		    for ( int i = 0; i < a.length() - ( wordSize * numWords ) + 1; i++ ){
		        //Get the word starting by this counter.
		        //System.out.println ( "Checking " + i );
		        String firstToken = a.substring (i, i + wordSize );
	            if ( h1.containsKey (firstToken) ){
	                //System.out.println ( "Hey, I had " + firstToken + " in " + i );
	                //Wonderful! A word is there.
	                HashMap <String, Integer> h = (HashMap <String, Integer>) h1.clone ();   
	                
	                if ( i == 97 ) qq = true; else qq=false;
	                decrease (h, firstToken, qq);
	                
	                int j= i + wordSize;
	                
	                boolean found = true;
	                while (h.keySet().size() > 0 && found){
	                    String token = a.substring (j, j + wordSize );
	                    if ( !h.containsKey (token) ) found = false;
	                    else { 
	                        decrease (h, token, qq);
	                        j=j+wordSize;
	                    }
	                }
	                
	                if ( found )
	                    result.add (i);
	            }	        
		    }
		    return result;
		}
		
		void decrease (HashMap <String, Integer> h, String key, boolean qq){
		    //if (qq) System.out.println ("Removing key " + key);
		    int val = h.get (key);
		    val--;
		    if (val == 0) h.remove (key);
	        else h.put(key,val);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
