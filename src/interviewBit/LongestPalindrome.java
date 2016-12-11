package interviewBit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Longest Palindromic SubstringBookmark Suggest Edit
Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"

 * @author mrincodi
 *
 */
public class LongestPalindrome {

		public String longestPalindrome(String a) {
		    String response = "";
		    
		    if (a.length () <= 1 ) return a;
		    
		    HashMap <Character, ArrayList <Integer> > h = new HashMap <Character, ArrayList <Integer> > ();
		    
		    response = a.charAt(0) + "";
		    
		    for ( int i = 0; i < a.length (); i++ ){
		        char c = a.charAt (i);
		        //System.out.println ( "Checando " + i + ",  " + a.charAt (i));
		        
		        ArrayList <Integer> al = new ArrayList <Integer> ();
		        if (!h.containsKey (c)){
		            al.add (i);
		            h.put(c,al);
		            //System.out.println ( "MetI " + c + " con entrada " + h.get (c).get(0));
		        }
		        else {
		            //Check if there is a palindrome
		            //by checking the previous positions.
		            //j=index over the arraylist of previous positions.
		            al = h.get(c);
		            al.add(i);
	                //System.out.println ( "Analyzing " + c);
		            for ( int j = 0; j < al.size();j++){
		                //k=counter inside the string, to check for palindromes.
		                int initial = al.get(j);
	                    //If the palindrome I may get is smaller than the current one I have, don't even bother.
	                    
	                    //System.out.println ("initial es " + initial + " e i es " + i + " y response es " + response);
	                    
	                    if ( i - initial + 1 <= response.length () ) break;
	                    
	                    //System.out.println ("PasE");
	                    
		                boolean isPal = true;
		                for ( int k = 0; k <= ( i - initial  )/2 ; k++ ){
		                	//System.out.println ("Comparando " + a.charAt(k + initial) + " y " + a.charAt( i - k) );

		                    if ( a.charAt(k + initial) != a.charAt( i - k) ) { 
		                        isPal=false;
		                        break;
		                    }
		                }
		                if (isPal){
		                    response = a.substring ( initial, i + 1 );
		                    break;
		                }
		            }
		        }
	            
		    }
		    return response;
		}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "xxxxxxxaaaabaaaaaaabaaaaaaabaaaaxaaabaaaaaaabaaa";
		String maxPal= new LongestPalindrome ().longestPalindrome(s);
		System.out.println ( maxPal);

	}

}
