package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example :
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

If it is not possible to reach the end index, return -1.

 * @author mrincodi
 * 2016-09-19
 * Comment: O(n) (!!!). As always with DP: obvious once you understand it.
 * Clue: https://github.com/AnkitChaudhary2601/ds/commit/6a9491768c848117ead70bcdc7c8b184c8009765
 * And it can even be done with O(1) memory!
 *  
 */
public class MinJumpsArray {
	public int jump(ArrayList<Integer> a) {
		if ( a == null || a.size() <= 1 ) return 0;

		int [] aux = new int [a.size()];
		int lim=0;

		for ( int i = 0; i < aux.length && lim < aux.length - 1; i++){
			if ( i > lim ) return -1;

			int thisLim = Math.min (i + a.get(i), aux.length - 1);
			for ( int j = lim + 1; j <= thisLim; j++){
				aux [ j ] = aux [ i ] + 1;
			}
			lim = Math.max(lim, thisLim);
		}

		return ( aux [ aux.length - 1]);
	}


	public static void main ( String [] args ){
		ArrayList <Integer> a = new ArrayList < Integer> ( Arrays.asList(2,3,1,1,4));
		int n = new MinJumpsArray().jump(a);
		System.out.println(n);
	}
}
