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
 * Comment: OK, so I solved it the right way, and somewhat in linear space, but it would have been more elegant
 * if I were reusing the results array. This can be done if I start from the bottom.
 *
 */
public class MinSumPathInTriangle2 {

	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
		if ( a.size()==0) return 0;
		if (a.size()==1) return a.get(0).get(0);

		ArrayList <Integer> results = new ArrayList <Integer> ();

		results.add (a.get(0).get(0));
		ArrayList <Integer> oldResults = new ArrayList <Integer> (results);

		for ( int i = 1; i < a.size(); i++ ){
			results = new ArrayList <Integer> ();
			results.add(oldResults.get(0)+a.get(i).get(0));

			for ( int j = 1; j < i; j++){
				results.add(a.get(i).get(j) + Math.min (oldResults.get(j-1),oldResults.get(j)));
			}
			results.add(oldResults.get(i-1)+a.get(i).get(i));

			oldResults=results;
		}

		int min = Integer.MAX_VALUE;
		for (int val: results)
			min = Math.min(min,val);

		return min;
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

		int val = new MinSumPathInTriangle2().minimumTotal(a);

		System.out.println(val);

	}

}
