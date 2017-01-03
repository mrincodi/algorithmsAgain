package interviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.


 * @author mrincodi
 * 2016-12-11
 * Comment: I just sorted it and did it as I had done diffk...
 */
public class DiffK2WithSorting {

	public int diffPossible(final List<Integer> a, int b) {

		if (a.size() <=1 ) return 0;

		ArrayList <Integer> numbers = new ArrayList <Integer> (a);

		Collections.sort(numbers);

		int i = 0, j = 1;

		while (j < numbers.size() && i <= j){
			int big = numbers.get(j);
			int small = numbers.get(i);
			int diff = big -small;
			if ( diff == b ){
				if (i != j) return 1;
				else j++;   //When b is 0.
			}
			else if ( diff < b) j++;
			else i++;
		}
		return 0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
