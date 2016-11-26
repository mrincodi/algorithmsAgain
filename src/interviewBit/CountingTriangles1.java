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
 * Comment: Naive approach.
 */
public class CountingTriangles1 {


	public int nTriang(ArrayList<Integer> A) {
		long resultL = 0;
		if ( A.size() < 3 ) return 0;
		Collections.sort(A);
		for ( int i = 0; i < A.size () - 2; i++){
			for ( int j = i+1; j < A.size () -1; j++){
				for ( int k = j + 1; k < A.size(); k++ ){
					if (A.get(i)+A.get(j)>A.get(k)) resultL++;
				}
			}
		}
		return (int) (resultL % 1000000007L);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
