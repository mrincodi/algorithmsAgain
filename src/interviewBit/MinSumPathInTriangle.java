package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 


 * @author Mario
 * 2016-11-26
 * Comment: Now, reusing the result array and starting from the bottom!
 */
public class MinSumPathInTriangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
		if ( a.size()==0) return 0;

		int[] results = new int [a.size()+1];

		for ( int i = a.size()-1; i >=0; i-- ){
			for ( int j = 0; j <= i; j++){
				results[j]=Math.min(results[j],results[j+1]) + 
						a.get(i).get(j);
			}
		}

		return results[0];
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>> ();

		//8 9 3 8 0 2 4 8 3 9 0 5 2 2 7 3 7 9 0 2 3 9 9 7 0 3 9 8 6 5 7 6 2 7 0 3 9

		a.add(new ArrayList<Integer>(Arrays.asList(9)));
		a.add(new ArrayList<Integer>(Arrays.asList(3,8)));
		a.add(new ArrayList<Integer>(Arrays.asList(0,2,4)));
		a.add(new ArrayList<Integer>(Arrays.asList(8,3,9,0)));
		a.add(new ArrayList<Integer>(Arrays.asList(5,2,2,7,3)));
		a.add(new ArrayList<Integer>(Arrays.asList(7,9,0,2,3,9)));
		a.add(new ArrayList<Integer>(Arrays.asList(9,7,0,3,9,8,6)));
		a.add(new ArrayList<Integer>(Arrays.asList(5,7,6,2,7,0,3,9)));

		int val = new MinSumPathInTriangle().minimumTotal(a);

		System.out.println(val);

	}

}
