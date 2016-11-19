package fbExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

 * @author mrincodi
 * 2016-11-17
 * Comment: O(n) solution. Could be even faster if I had mixed both loops into one.
 * Actually, I don't even need an array! The HashMap suffices!
 *
 */
public class LsZero {
	public ArrayList<Integer> lszero(ArrayList<Integer> a) {

		ArrayList<Integer> result = new ArrayList<Integer> ();

		if ( a == null || a.size() == 0 ) return result;

		ArrayList<Integer> totalSums = new ArrayList<Integer> ();

		int totalSum = 0;
		for ( int i = 0; i < a.size(); i++ ){
			totalSum+= a.get(i);
			totalSums.add (totalSum);
		}

		//Now, let's find 2 repeated numbers.
		//TODO: This could be put inside the previous cycle, to do only one walk.

		HashMap <Integer, Integer> valAndPos = new HashMap <Integer, Integer> ();

		int start = 0;
		int end = 0;
		int length = 0;
		for ( int i = 0; i < totalSums.size(); i++){

			int thisSum = totalSums.get(i);

			if ( thisSum == 0){
				start = 0;
				end = i;
				length = i+1;
			}
			else {
				if (!valAndPos.containsKey(thisSum)){
					valAndPos.put(thisSum, i);
				}
				else {
					int thisLength = i - valAndPos.get(thisSum);
					if ( thisLength > length ){
						start = valAndPos.get(thisSum)+1;
						end = i;
						length = thisLength;
					}
				}
			}
		}

		if ( length != 0 ){
			for ( int i = start; i <= end; i++ ){
				result.add(a.get(i));
			}
		}

		return result;
	}

	
	public static void main ( String [] args ){
		ArrayList <Integer> nums = new ArrayList <Integer> ( Arrays.asList(4, -8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25 ));
		ArrayList <Integer> result = new LsZero().lszero(nums);
		System.out.println(result);
	}
}
