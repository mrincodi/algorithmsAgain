package interviewBit;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example : 
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.

 * @author mrincodi
 * 2016-10-20
 * Comment: Somewhat challenging. Important.
 */
public class EditDistance {
	HashSet <String> prevWords = new HashSet <String> ();
	HashMap <String, Integer> prevSolutions = new HashMap <String, Integer> ();

	public int minDistance(String a, String b) {
		//Are they the same?
		if ( a.equals(b)) return 0;

		int result = Math.max (a.length(), b.length());

		if ( prevWords.contains (a)){
			if ( prevSolutions.containsKey (a)) return prevSolutions.get(a);
			else return result;
		}

		prevWords.add (a);

		//Find first difference.
		int firstDiffPos = -1;
		for ( int i = 0; i < Math.min(a.length(), b.length());i++){
			if (a.charAt(i)!= b.charAt(i)) { 
				firstDiffPos = i;
				break;
			}
		}

		if ( firstDiffPos == -1 ){
			//Just add or remove the missing characters.
			result = Math.abs (b.length() - a.length());
			prevSolutions.put(a, result);
			return result;
		}

		// First of all, value with a change:	    
		String changeString = a.substring (0,firstDiffPos) + 
				b.charAt(firstDiffPos) + a.substring (firstDiffPos+1,a.length());

		int valWithChange = 1 + minDistance (changeString, b);    
		result = Math.min (result, valWithChange);

		// In any case, remove the different character.
		String removeCharString = a.substring (0,firstDiffPos) + 
				a.substring (firstDiffPos +1);
		valWithChange = 1 + minDistance (removeCharString, b); 
		result = Math.min (result, valWithChange);

		// As a last resource, add the missing character.
		//if ( a.length () < b.length () ){
		String addCharString = a.substring (0,firstDiffPos) + 
				b.charAt(firstDiffPos) + a.substring (firstDiffPos);
		valWithChange = 1 + minDistance (addCharString, b); 
		result = Math.min (result, valWithChange);
		//}

		prevSolutions.put(a, result);
		return result;
	}

	public static void main(String[] args) {
		String a = "babaaabaaab";
		String b = "ababaabbab";
		int d = new EditDistance().minDistance(a, b);
		System.out.println(d);

	}

}
