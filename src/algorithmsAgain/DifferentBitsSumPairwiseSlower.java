package algorithmsAgain;

import java.util.ArrayList;

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
 * 
 * Comment: This works. InterviewBit complains it takes too long. I don't know how to enhance it...
 * I don't understand their enhancement (plus, it's not in Java)
 */
public class DifferentBitsSumPairwiseSlower {

	    public int cntBits(ArrayList<Integer> A) {
	        long result = 0;
	        for ( int i = 0; i < A.size(); i++ ){
	            for ( int j = i + 1; j < A.size(); j++ ){
	                result += diffBits (A.get(i),A.get(j));
	            }
	        }
	        return (int) ((result * 2L) % 1000000007L);
	    }
	    
	    public long diffBits ( int a, int b){
	        
	        int c = a ^ b; 
	        byte sum = 0;
	        while ( c > 0){
	            sum += c%2;
	            c=c>>>1;
	        }
	        
	        return (long) sum;

	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
