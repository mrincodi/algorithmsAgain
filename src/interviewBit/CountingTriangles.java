package interviewBit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * 
 * You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
Considering each array element Ai as the edge length of some line segment, count the number of triangles which you can form using these array values.

Notes:

You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn’t matter. Any triangle formed should have a positive area.

Return answer modulo 109 + 7.

For example,

A = [1, 1, 1, 2, 2]

Return: 4

 * @author mrincodi
 * 2016-10-22
 * Comment: O(n^2). If A[i] + A[j] > A[k] then all the indexes between j and k will also give 
 * a sum greater than k.  IMPORTANT: I didn't use a HashMap. Nice little problem.
 */
public class CountingTriangles {


	public int nTriang(ArrayList<Integer> A) {
		long resultL = 0;
		if ( A.size() < 3 ) return 0;
		Collections.sort(A);

		for ( int i = 0; i < A.size () - 2; i++){
			int j = i+1;
			for ( int k = i + 2; k < A.size(); k++ ){
				inner:
					for ( ; j < k; j++){
						if (A.get(i)+A.get(j)>A.get(k)){
							resultL+=(k-j);
							break inner;
						}
					}
			}
		}
		return (int) (resultL % 1000000007L);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
