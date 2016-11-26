package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * @author mrincodi
 * 2016-11-21
 * Comment: Beautiful problem. I took advantage of LinkedHashMap.
 * I am so verbose! LeetCode solution is super short!
 * I think I need to go over the brute force solution slowly, and explore the following possibilities slowly too.
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if ( s.length () <= 1 ) return s.length();
        LinkedHashMap <Character, Integer> letterLastPosition = new LinkedHashMap <Character, Integer> ();
        int result = 1;
        int lengthEndingHere = 1;
        
        letterLastPosition.put ( s.charAt(0), 0);
        
        for ( int i = 1; i < s.length() ; i++ ){
            //Get current letter.
            char c = s.charAt (i);
            if ( !letterLastPosition.containsKey (c)){
                letterLastPosition.put (c,i);
                lengthEndingHere++;
            }
            else {
                int repeatedLetterPos = letterLastPosition.get(c);
                //We need to remove all the letters that are before c, and c.
                Iterator <Character> iter = letterLastPosition.keySet().iterator();
                ArrayList <Character> charsBefore = new ArrayList <Character> ();
                boolean endRemoving = false;
                while ( !endRemoving && iter.hasNext () ){
                    char cc = iter.next ();
                    charsBefore.add(cc);

                    if ( cc == c)
                        endRemoving=true;
                }
                
                for ( char cc: charsBefore)
                    letterLastPosition.remove(cc);
                
                
                lengthEndingHere = i - repeatedLetterPos;

                letterLastPosition.put(c,i);
            }
            result=Math.max(result, lengthEndingHere);
        }
        return result;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
