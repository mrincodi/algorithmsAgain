package interviewBit;

import java.util.HashMap;


/**
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be atleast N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).

 * @author mrincodi
 *
 *Comment: Works... but InterviewBit complains about some memory issue or division 	by zero. Hmm...
 *No idea. It works, though.
 */
public class WindowString {


	public String minWindow(String S, String T) {

		int bestStartPos = -1;
		int bestLength   = -1;

		String result = "";
		if ( T.length () > S.length () || T.length() == 0 || S.length () == 0) return result; 

		HashMap <Character, Integer> h1 = new HashMap <Character, Integer> ();

		//Create the hashmap.

		for ( int i = 0; i < T.length (); i++){
			char letter = T.charAt(i);
			if ( h1.containsKey (letter)){
				h1.put(letter,h1.get(letter)+1);
			}
			else
				h1.put(letter,1);
		}

		HashMap <Character, Integer> h = new HashMap <Character, Integer> ();

		for ( int i = 0; i < S.length () - T.length () + 1; i++){
			//Is there a character from T in S[i]?
			char letter = S.charAt(i);
			if ( h1.containsKey (letter) ){
				h = ( HashMap <Character, Integer>) h1.clone();

				h.put (letter,h.get(letter)-1);
				if (h.get(letter) == 0){
					h.remove(letter);
				}

				if ( h.keySet().size() == 0 ){
					//Well, that was the only one.
					return letter + "";
				}

				//Let's get the rest of letters!
				boolean chainFound=false;
				for ( int j = i+1; j < S.length() && !chainFound;j++){
					letter = S.charAt(j);
					if (h.containsKey (letter) ){

						h.put (letter,h.get(letter)-1);
						if (h.get(letter) == 0){
							h.remove(letter);
						}
						if ( h.keySet().size() == 0 ){
							chainFound=true;
							//We found a solution!
							// If the current size of that string is better
							// than what we have (if we have one), overwrite it.

							if ( bestStartPos == -1 ){
								bestStartPos = i;
								bestLength = j - i + 1;
							}
							else {
								int thisLength = j - i + 1;
								if ( thisLength < bestLength ){
									bestStartPos = i;
									bestLength = thisLength;
								}
							}
						}
					}
				}
			}
		}

		if ( bestStartPos != -1)
			result = S.substring (bestStartPos, bestStartPos + bestLength);

		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String S= "AAAAAAAAAAASAAAAAAAAAAAAAAAAAAASSAAAAAAAAAAAAAssssssAAAAASAAAAAAASSSA";
		String T = "SSSSA";
		
		String qq = new WindowString().minWindow(S, T);
		
		System.out.println(qq);
	}

}
