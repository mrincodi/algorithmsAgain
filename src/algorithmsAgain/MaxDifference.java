package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * From http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 * Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after the smaller number in arr[].

Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)

 * @author mrincodi
 * 2016-10-04
 * Comment: This is the method "2" of the 3 explained in the page.
 */
public class MaxDifference {


	public int maxDifference ( ArrayList <Integer> a ){

		if ( a.size () <= 1 ) return 0;

		int minimum =  a.get(0);
		int maxDiff = Integer.MIN_VALUE;

		for ( int i = 1; i < a.size(); i++){
			int thisDiff = a.get(i) - minimum;
			maxDiff = Math.max(thisDiff, maxDiff);

			minimum = Math.min(minimum, a.get(i));
		}

		return maxDiff;
	}


	public static void main ( String [] args){
		ArrayList <Integer> a = new ArrayList <Integer> ( Arrays.asList(2, 3, 10, 6, 4, 8, 1));
		int maxDiff = new MaxDifference().maxDifference(a);
		System.out.println (maxDiff);
	}
}
