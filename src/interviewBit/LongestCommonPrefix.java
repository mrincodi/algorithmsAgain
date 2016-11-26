package interviewBit;

import java.util.ArrayList;

/**
 * 
Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.

 * @author mrincodi
 * 2016-10-21
 * Comment: Easy, suspiciously easy.
 *
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(ArrayList<String> a) {
		String prefix = "";

		if ( a.size() == 0 ) return prefix;
		if ( a.size() == 1 ) return a.get(0);

		for ( int i=0; i < a.get(0).length(); i++){
			char thisChar = a.get(0).charAt(i);

			for ( int j = 1; j < a.size();j++ ){
				if ( a.get(j).length () == i || 
						a.get(j).charAt(i) != thisChar ) return prefix;
			}
			prefix = prefix + thisChar;
		}

		return a.get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
