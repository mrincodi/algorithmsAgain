package interviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. 
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2

 * @author mrincodi
 * Comment: I have done this one so many times...
 *
 */
public class TwoSum {

	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
	    HashMap <Integer, Integer > h = new HashMap <Integer, Integer> ();
	    
        if ( a.size () <=1 ) return result;
        
        h.put ( a.get(0), 0 );
        
        for ( int i = 1; i < a.size(); i++ ){
            int val = a.get(i);
            int lookFor = b - val;
            
            if ( h.containsKey (lookFor)){
                //We found a match!
                result.add (h.get(lookFor) + 1 );
                result.add (i + 1);
                return result;
            }
            
            if ( !h.containsKey (val)){
                h.put (val, i);
            } // else it's there already.
        }
        return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
