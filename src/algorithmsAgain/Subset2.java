package algorithmsAgain;

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
 * 2016-08-20
 *
 * Comment: This is a MUCH better answer; not need to enhance it with DP!
 * Need to sort it after it's done, though! 
 * This can be done either with a comparator,
 * or transferring it to string (comma separated) and then sorting the strings.
 */
public class Subset2 {
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
	    
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if ( a.size() == 0 ) {
			result.add( new ArrayList<Integer> ());
			return result;
		}
		
		//Get all the subsets and then, to that set of elements, add yourself.
		
		ArrayList<Integer> b = new ArrayList<Integer> (a.subList(1, a.size()));
		ArrayList<ArrayList<Integer>> otherSubsets = (subsets (b));
		
		result.addAll(otherSubsets);
		
		//Add this element to the set of subsets.
		Integer element = a.get(0);
		for ( ArrayList<Integer> subset : otherSubsets){
			ArrayList<Integer> newSubSet = new ArrayList<Integer> (subset);
			newSubSet.add(0,element);
			result.add(newSubSet);
		}
		
		return result;
		
		
	}

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer> ();
		a.addAll(Arrays.asList(1, 2, 3, 4, 5));


		ArrayList<ArrayList<Integer>> ss = new Subset2().subsets(a);

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
