package interviewBit;

import java.util.List;

/**
 * 
 * 
 * Find the size of the longest increasing subsequence of a given sequence / array.

In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.
In this case, we only care about the length of the longest increasing subsequence.

Example :

Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output : 6
The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]

 * @author mrincodi
 * 2016-08-10
 * Comment: A typical problem. My solution is equal to InterviewBits (cool).
 */
public class LongestIncreasingSubsequence {

	public int lis(final List<Integer> a) {
		if ( a.size() == 0 ) return 0;
		int [] numSeq = new int [ a.size() ];

		numSeq[0]=1;
		int maxSoFar=1;

		for (int i = 0; i<numSeq.length; i++){
			int lengthSeq=1;
			for ( int j = 0; j < i; j++){
				if (a.get(j)<a.get(i) && numSeq[j] + 1 > lengthSeq)
					lengthSeq = numSeq[j] + 1;
			}
			numSeq[i]=lengthSeq;
			maxSoFar=Math.max(maxSoFar,lengthSeq);
		}
		return maxSoFar;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
