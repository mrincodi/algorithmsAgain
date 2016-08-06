package algorithmsAgain;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Example:

Input : A : [4, 5, 2, 10]
Return : [-1, 4, -1, 2]

Example 2:

Input : A : [3, 2, 1]
Return : [-1, -1, -1]

   Much better than solution 1 (after checking the solution hint).
 * @author mrincodi
 *
 */
public class NearestSmallerElement2 {

	public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {

		ArrayList <Integer> result = new ArrayList <Integer> ();

		Stack <Integer> numbers = new Stack <Integer> ();

		if (arr == null ) return null;

		for ( int i = 0; i < arr.size(); i++ ){
			int current = arr.get (i);

			//Get closest smaller one.
			while (!numbers.empty()){
				int val = numbers.peek ();
				if ( val >= current ){
					numbers.pop ();
				}
				else {
					result.add (numbers.peek());
					break;
				}
			}

			if (numbers.empty() ) result.add (-1);

			numbers.push(current);

		}

		return result;
	}



}
