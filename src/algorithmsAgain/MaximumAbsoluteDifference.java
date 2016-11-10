package algorithmsAgain;

import java.util.ArrayList;

/**
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.

 * @author mrincodi
 * 2016-11-09
 * Comment: Very interesting approach by analyzing the definition of absolute value.
 */
public class MaximumAbsoluteDifference {

	public int maxArr(ArrayList<Integer> A) {
		int result = 0;
		if ( A.size () <=1 ) return 0;

		int maxAPlusPos=Integer.MIN_VALUE;
		int maxAMinusPos=Integer.MIN_VALUE;        
		int minAPlusPos=Integer.MAX_VALUE;
		int minAMinusPos=Integer.MAX_VALUE;

		for ( int i = 0; i < A.size (); i++){
			maxAPlusPos  = Math.max (maxAPlusPos,  A.get(i)+i);
			maxAMinusPos = Math.max (maxAMinusPos, A.get(i)-i);
			minAPlusPos  = Math.min (minAPlusPos,  A.get(i)+i);
			minAMinusPos = Math.min (minAMinusPos, A.get(i)-i);
		}

		int sub1 = Math.abs (maxAPlusPos-minAPlusPos);
		int sub2 = Math.abs (maxAMinusPos-minAMinusPos);

		result=Math.max (sub1, sub2);
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
