package interviewBit;

import java.util.List;
import java.util.TreeSet;

/**
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Example :

Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

 * @author mrincodi
 * 2016-10-10
 * Comment: Tsk, tsk. This is beautifully crisp.
 */
public class RainWaterTrappedInterviewBit {

		// DO NOT MODIFY THE LIST
		public int trap(final List<Integer> a) {
		    int result = 0;
		    TreeSet <Integer> values = new TreeSet <Integer> ();
		    // First of all, get the different numbers in a TreeSet.
		    for ( int val: a){
		        values.add(val);
		    }

	        int prevVal = values.first();
	        values.remove(prevVal);
	        
	        for ( int val:values){
	            //Get the limits of this value.
	            int start = 0;
	            int end = 0;
	            int i = 0;
	            while (a.get(i) < val ) i++;
	            start = i;
	            
	            i = a.size() - 1;
	            while (a.get(i) < val ) i--;
	            end = i;
	            
	            for ( int j = start + 1; j < end; j++){
	                if ( a.get(j) < val ) result+= (val - prevVal);
	            }
	            prevVal = val;
	        }
		    return result;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
