package interviewBit;


import java.util.HashSet;
import java.util.List;

/**
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
 * Comment: A little bit tricky, but OK.
 */
public class DiffK2 {

	public int diffPossible(final List<Integer> a, int b) {

		HashSet <Integer> numbers = new HashSet <Integer>();

		for ( int number:a){
			int needed1 = number - b;
			int needed2 = number + b;
			
			if ( numbers.contains(needed1) || numbers.contains(needed2))
				return 1;
			else
				numbers.add(number);
		}
		return 0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
