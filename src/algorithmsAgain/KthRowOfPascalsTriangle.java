package algorithmsAgain;

import java.util.ArrayList;

/**
 * 
 * Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?

 * @author mrincodi
 * 2016-10-16
 * Comment: With a single array. Cute.
 *
 */
public class KthRowOfPascalsTriangle {



	public ArrayList<Integer> getRow(int a) {
		if ( a < 0 ) return null; //Or throw exception.

		ArrayList<Integer> sol = new ArrayList<Integer>();

		for (int level = 0; level <= a; level ++){
			for ( int i = 0; i < sol.size()-1; i++){
				sol.set(i,sol.get(i)+sol.get(i+1));
			}
			sol.add(0,1);
		}

		return sol;
	}

	public static void main(String[] args) {
		System.out.println(( new KthRowOfPascalsTriangle().getRow(10)));

	}

}
