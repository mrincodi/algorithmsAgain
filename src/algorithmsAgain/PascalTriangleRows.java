package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
 * @author mrincodi
 * 2016-11-09
 * Comment: Easy.
 */
public class PascalTriangleRows {

	public ArrayList<ArrayList<Integer>> generate(int a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		if (a <=0 ) return result;
		result.add ( new ArrayList<Integer> (Arrays.asList (1)));
		if (a ==1 ) return result;
		result.add ( new ArrayList<Integer> (Arrays.asList (1,1)));
		if (a ==2 ) return result;

		for ( int i = 3; i <= a; i++ ){
			ArrayList<Integer> entry = new ArrayList<Integer> (Arrays.asList (1));
			ArrayList<Integer> prevArray = result.get(result.size()-1);
			for ( int j = 1; j < prevArray.size();j++){
				entry.add(prevArray.get(j) + prevArray.get(j-1));
			}
			entry.add(1);
			result.add (entry);
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
