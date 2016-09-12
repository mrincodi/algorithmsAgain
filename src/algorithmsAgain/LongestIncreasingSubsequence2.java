package algorithmsAgain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * Find the longest increasing subsequence of a given sequence / array.

In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.
In this case, we only care about the length of the longest increasing subsequence.

Example :

Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output : 6
The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]

 * @author mrincodi
 * 2016-08-31
 * Comment: An enhancement in the previous solution. I am giving the lexicographical 
 * best array too.
 */
public class LongestIncreasingSubsequence2 {

	ArrayList <Integer> lis (final List<Integer> a){

		ArrayList <Integer> bestWithMe = new ArrayList <Integer> ();
		ArrayList <Integer> bestWithoutMe = new ArrayList <Integer> ();

		if ( a.size() == 0) return bestWithoutMe;
		
		bestWithMe.add(a.get(0));
		
		for ( int i = 1; i < a.size(); i++){
			
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
