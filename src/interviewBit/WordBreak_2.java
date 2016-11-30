package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.TreeSet;

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
 * Comment: Enhanced with a TreeSet. Can be enhanced even further by using a variable for the "largestWordSize" (in dictionary).
 * This could also be done with an array of positions for which there is a valid division of words until each position.
 *
 */
public class WordBreak_2 {

	//int largestWordSize = 0;
	LinkedHashSet <String> dict = new LinkedHashSet<String>();
	TreeSet <Integer> OKStart = new TreeSet <Integer>();
	public int wordBreak(String string, ArrayList<String> dictArray) {
		if ( string.length () == 0 || dictArray.size() == 0 ) return 0;


		for ( String s:dictArray){
			dict.add(s);
			//largestWordSize=Math.max(largestWordSize,s.length());
		}

		outer:
			for ( int i = string.length()-1; i>=0; i--){
				if ( dict.contains(string.substring(i))){
					OKStart.add(i);
				}
				else {
					for ( int end:OKStart){
						String subWord = string.substring (i,end);
						if ( dict.contains(subWord)){
							OKStart.add(i);
							continue outer;
						}
					}
				}
			}


		return OKStart.contains(0)?1:0;
	}

	public static void main(String[] args) {
		String string = "holaperro";
		ArrayList <String> dictArray = new ArrayList <String> ( Arrays.asList("hola","perro"));
		int res = new WordBreak_2().wordBreak(string , dictArray);
		
		System.out.println(res);
	}

}
