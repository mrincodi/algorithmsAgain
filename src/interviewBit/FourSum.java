package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example : 
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted.
Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
 * @author mrincodi
 * 2016-08-21
 * Comment: Four looped fors = Yuck...
 */
public class FourSum {

	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> numbers, int target) {

		ArrayList < ArrayList < Integer > > result = new ArrayList < ArrayList < Integer > > ();

		LinkedHashSet <String > resultsHash = new LinkedHashSet <String > ();

		if ( numbers.size () < 4 ) return result;

		Collections.sort ( numbers);

		for ( int i = 0; i < numbers.size () - 3; i++ ){
			for ( int j = i + 1; j < numbers.size () - 2; j++ ){
				for ( int k = j + 1; k < numbers.size () - 1; k++ ){
					boolean stop = false;
					for ( int l = k + 1; l < numbers.size () && !stop; l++ ){
						int nI = numbers.get (i );
						int nJ = numbers.get (j );
						int nK = numbers.get (k );
						int nL = numbers.get (l );

						int total = nI + nJ + nK + nL;

						if (total == target){
							String valString = nI+","+nJ+","+nK+","+nL;
							resultsHash.add (valString);
						}
						if (total > target ) stop = true;
					}
				}
			}
		}

		//Now, from a LinkedHashSet to the ArrayList of ArrayLists.
		Iterator <String> iter = resultsHash.iterator ();
		while (iter.hasNext()){
			String numbersString = iter.next();

			String [] words = numbersString.split (",");
			ArrayList < Integer > resultEntry = new ArrayList < Integer > ();
			for ( String word : words )
				resultEntry.add ( Integer.parseInt ( word ) );

			result.add (resultEntry);

		}
		return result;
	}


	public static void main(String[] args) {
		ArrayList <Integer> a = new ArrayList <Integer> (Arrays.asList(1,0,-1,0,-2,2));

		ArrayList < ArrayList < Integer > >  stt = new FourSum().fourSum(a, 0);

		for ( ArrayList <Integer> al: stt){
			for ( int x: al){
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

}
