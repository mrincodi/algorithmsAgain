package interviewBit;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * 
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given

s = "myinterviewtrainer",
dict = ["trainer", "my", "interview"].
Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * @author mrincodi
 * 2016-11-26
 * Comment: The typical solution. Works, but breaks InterviewBit.
 *
 */
public class WordBreak {

	int [] tested;
	int largestWordSize = 0;
	LinkedHashSet <String> dict = new LinkedHashSet<String>();
	public int wordBreak(String string, ArrayList<String> dictArray) {
		if ( string.length () == 0 || dictArray.size() == 0 ) return 0;

		tested = new int [ string.length()+1];

		for ( String s:dictArray){
			dict.add(s);
			largestWordSize=Math.max(largestWordSize,s.length());
		}
		return wordBreak2 ( string, dict, 0);

	}

	private int wordBreak2(String string, LinkedHashSet<String> dict, int start) {
		if ( string.length () == 0 || dict.contains (string.substring(start))) return 1;

		for ( int i = 1; i <= Math.min (string.length () - start, largestWordSize); i++){
			String substring = string.substring (start, start + i);
			if ( tested [ start + i ] == 0 && dict.contains ( substring ) ){
				int result = wordBreak2( string, dict,  start + i);
				if ( result == 1 ) return 1;
			}
		}
		tested [ start ] = -1;
		return 0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
