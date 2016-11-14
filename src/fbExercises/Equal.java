package fbExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * 
 * 
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

Note:

1) Return the indices `A1 B1 C1 D1`, so that 
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1 

2) If there are more than one solutions, 
   then return the tuple of values which are lexicographical smallest. 

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )  
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
If no solution is possible, return an empty list.

 * @author mrincodi
 * 2016-11-12
 * Comment: FB solves it without LinkedHashMap, so I don't 
 * need to go over the numbers again. Cool. ;)
 * Can't this be enhanced? Hmmm...
 *
 */
public class Equal {

	public ArrayList<Integer> equal(ArrayList<Integer> a) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if ( a.size() < 4) return result;

		LinkedHashMap <Integer, ArrayList <ArrayList<Integer>>> sums = new LinkedHashMap <Integer, ArrayList <ArrayList<Integer>>>();

		for ( int i = 0; i < a.size()-1; i++){
			inner:
				for (int j = i+1; j < a.size(); j++){
					int sum = a.get(i)+a.get(j);
					if (!sums.containsKey(sum))
						sums.put(sum,new ArrayList <ArrayList<Integer>>());

					//Let's check if I already have couples with one of the positions already.
					ArrayList <ArrayList<Integer>> pairs = sums.get(sum);
					for ( int k = 0; k < pairs.size(); k++ ){
						ArrayList<Integer> thisPair = pairs.get(k);
						if ( thisPair.get(0)==i || thisPair.get(0)==j || thisPair.get(1)==i || thisPair.get(1)==j)
							continue inner;
					}

					sums.get(sum).add(new ArrayList<Integer>(Arrays.asList(i,j)));
				}
		}

		for ( int sum: sums.keySet ()){
			ArrayList <ArrayList<Integer>> pairs = sums.get(sum);
			if ( pairs.size() > 1 ){
				result = new ArrayList<Integer> ( Arrays.asList (pairs.get(0).get(0),pairs.get(0).get(1),pairs.get(1).get(0),pairs.get(1).get(1)));
				return result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
