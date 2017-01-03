package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes: 
- Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].

 * @author mrincodi
 * 2016-12-28
 * Comment: A beautiful, beautiful problem. Got to enhance it. I really don't need a matrix.
 *
 */
public class Flip1 {

	public ArrayList<Integer> flip(String A) {
		ArrayList<Integer> result = new ArrayList<Integer> ();

		if (A.length() == 0) return result;
		//First, count the number of ones.
		int numOnes = 0;

		for ( char c : A.toCharArray() ){
			numOnes += Integer.parseInt (c + "");
		}

		if ( numOnes == A.length() ) return result;
		if ( numOnes == A.length() ) return new ArrayList <Integer> (Arrays.asList (1,A.length()));

		int [][] m = new int [ A.length()][A.length()];

		//Let's do the first row first.

		m[0][0] = A.charAt(0)=='0'?numOnes+1:numOnes-1;
		int maxValSoFar = m[0][0];
		int maxLLimitSoFar = 0;
		int maxRLimitSoFar = 0;
		for ( int i = 1; i < A.length(); i++ ){
			char c = A.charAt(i);
			m[0][i] = c=='0'?m[0][i-1]+1:m[0][i-1]-1;
			if (m[0][i] > maxValSoFar ){
				maxValSoFar=m[0][i];
				maxRLimitSoFar=i;
			}

		}


		for ( int row = 1; row < A.length(); row++ ){
			char c = A.charAt (row - 1);
			for ( int col = row; col < A.length(); col++ ){
				int diff = c=='1'?1:-1;
				m[row][col] = m[row-1][col]+diff;
				if (m[row][col] > maxValSoFar ){
					maxValSoFar=m[row][col];
					maxLLimitSoFar=row;
					maxRLimitSoFar=col;
				}
			}
		}
		result.add(maxLLimitSoFar + 1);
		result.add(maxRLimitSoFar + 1);
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
