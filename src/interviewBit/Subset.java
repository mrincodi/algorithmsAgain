package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * Given a set of distinct integers, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
 * @author mrincodi
 *
 * Notes: Can be totally enhanced with dynamic programming.
 */
public class Subset {
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
	    
	    Collections.sort(a);
	    
	    return subsets2 (a);
	}
	
	public ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> a) {

	    ArrayList <ArrayList<Integer>> results = new ArrayList <ArrayList<Integer>> ();

		ArrayList  <Integer> emptySet = new ArrayList <Integer> ();

		results.add (emptySet);
		if ( a.size() == 0 ) return results;

		for ( int i = 0; i < a.size(); i++ ){

			ArrayList <Integer> aMinusElements = new ArrayList  <Integer> (a.subList (i+1, a.size()));
			ArrayList <ArrayList<Integer>> subResults = subsets2 (aMinusElements);

			for ( int j = 0 ; j < subResults.size(); j++ ){
				ArrayList<Integer> elementAndSubResult = (ArrayList<Integer> ) subResults.get(j).clone();
				elementAndSubResult.add (0,a.get(i));
				results.add(elementAndSubResult);
			}
		}
		return results;
	}

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer> ();
		a.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));


		ArrayList<ArrayList<Integer>> ss = new Subset().subsets(a);

		for ( int i = 0; i < ss.size(); i++){
			System.out.print("-> ");
			for  ( int j = 0; j < ss.get(i).size(); j++){
				System.out.print(ss.get(i).get(j) + " ");
			}
			System.out.println();
		}
		// TODO Auto-generated method stub

	}

}
