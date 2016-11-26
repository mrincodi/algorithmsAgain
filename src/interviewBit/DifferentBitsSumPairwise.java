package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * 
 * We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

For example,

A=[1, 3, 5]

We return

f(1, 1) + f(1, 3) + f(1, 5) + 
f(3, 1) + f(3, 3) + f(3, 5) +
f(5, 1) + f(5, 3) + f(5, 5) =

0 + 1 + 1 +
1 + 0 + 2 +
1 + 2 + 0 = 8

 * @author mrincodi
 * 2016-09-17
 * Comment: A beautiful enhancement!! See 
 * http://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/
 */
public class DifferentBitsSumPairwise {

    public int cntBits(ArrayList<Integer> A) {
    	
    	long result = 0;
    	for ( int i = 0; i < 32; i++ ){
    		long setBits = 0;
    		for ( int j = 0; j < A.size();j++)
    			if ( (A.get(j)>>>i) %2 == 1)setBits++;
    			
    		result += setBits * ((long)A.size() - setBits) * 2L;
    	}

    	return (int) (result % 1000000007L);
    }
    
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer> (Arrays.asList(1,3,5));
		
		int result = new DifferentBitsSumPairwise().cntBits(A);
		
		System.out.println(result);

	}

}
