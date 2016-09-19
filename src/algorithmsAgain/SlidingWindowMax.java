package algorithmsAgain;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position.

Example :

The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position	Max
 	 
[1 3 -1] -3 5 3 6 7	3
1 [3 -1 -3] 5 3 6 7	3
1 3 [-1 -3 5] 3 6 7	5
1 3 -1 [-3 5 3] 6 7	5
1 3 -1 -3 [5 3 6] 7	6
1 3 -1 -3 5 [3 6 7]	7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

 Note: If w > length of the array, return 1 element with the max of the array. 
 
 * @author mrincodi
 * 2016-09-18
 * Comment: Good one. Not too difficult. I wonder if there are other enhancements.
 */
public class SlidingWindowMax {

		// DO NOT MODIFY THE LIST
		public ArrayList<Integer> slidingMaximum(final List<Integer> a, int w) {
		    ArrayList <Integer> result = new ArrayList <Integer> ();
		    
		    if (a.size()==0 || w <= 0 )return result;
		    
		    w = Math.min (a.size(), w );
		    
		    int max = 0, maxPos = -1;
		    
		    for ( int start = 0; start < a.size() - w + 1 ; start++ ){
		        int end = start + w - 1;
		        if ( maxPos < start ){
		           // Calculate maxPos.
		           maxPos = getMaxInWindow (a,  start, end );
		           max = a.get ( maxPos );
		   	    }
		   	    else {
		   	        if (a.get(end) >= max ){
		   	            maxPos = end;
		   	            max = a.get(end);
		   	        }
		   	    }
		   	    result.add (max);
		    }
		    
		    return result;

		}

	    private int getMaxInWindow (final List<Integer> a, int start, int end){
	        int max = a.get(start);
	        int pos = start;
	        for ( int i = start + 1; i <= end; i++){
	           if ( a.get(i) >= max ){
	               max = a.get(i);
	               pos = i;
	           }
	        }
	        return pos;
	    }
	    
	    

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
