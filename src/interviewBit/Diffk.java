package interviewBit;

import java.util.ArrayList;

/**
 * 
 * 
Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example: Input : 
    A : [1 3 5] 
    k : 4
 Output : YES as 5 - 1 = 4 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.

 * @author mrincodi
 * 2016-12-02
 * Comment: There should be a better way to do this. Can this be done in linear time?
 *
 */
public class Diffk {

	public int diffPossible(ArrayList<Integer> a, int val) {

		for ( int i = 0; i < a.size() - 1; i++ ){
			inner:
				for ( int j = i + 1; j < a.size(); j++) {
					if ( a.get(j) - a.get(i) == val) return 1;
					if ( a.get(j) - a.get(i) > val) break inner;
				}
		}

		return 0;	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
