package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].
 * 
 * 
 * @author mrincodi
 * 2016-09-17
 * Comment: Easy. It can be enhanced with a single call for finding the limits, instead of two.
 *
 */
public class SearchForARange {

		// DO NOT MODIFY THE LIST
		public ArrayList<Integer> searchRange(final List<Integer> orderedList, int number) {
		    if ( orderedList.size() == 0 ) return new ArrayList <Integer> (Arrays.asList ( -1, -1) );
		    int start = findStart (orderedList, number, 0, orderedList.size() -1 );
		    int end = findEnd (orderedList, number, 0, orderedList.size() -1 );
		    return new ArrayList <Integer> (Arrays.asList ( start, end) );

		}
		
		public int findStart ( final List<Integer> orderedList, int number, int leftLimit, int rightLimit ){
	        if ( leftLimit == rightLimit )
	            return orderedList.get(leftLimit)==number?leftLimit:-1;

	        //Split the list.
	        int medium = ( leftLimit + rightLimit ) / 2;

	        //Look at the border values.
	        if ( orderedList.get(medium) >= number )
	            return findStart (orderedList, number, leftLimit, medium);
	        
	        return findStart (orderedList, number, medium+1, rightLimit);
	    }
	    
	    public int findEnd ( final List<Integer> orderedList, int number, int leftLimit, int rightLimit ){
	        if ( leftLimit == rightLimit )
	            return orderedList.get(leftLimit)==number?leftLimit:-1;

	        //Split the list.
	        int medium = ( leftLimit + rightLimit ) / 2;

	        //Look at the border values.
	        if ( orderedList.get(medium+1) <= number )
	            return findEnd (orderedList, number, medium+1, rightLimit);
	        
	        return findEnd (orderedList, number, leftLimit, medium);
	    }
	    
	            

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
