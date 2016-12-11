package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 
         
         
 * @author mrincodi
 * 2016-09-12
 * Comment: I had to think this one a lot. I had a couple approaches that didn't work. All clarified after looking at the solution approach.
 *
 */
public class Array3Pointers {

	public int minimize(final List<Integer> aL, final List<Integer> bL, final List<Integer> cL) {

		int i = 0,j=0,k=0;
		
		int minDiff=Integer.MAX_VALUE;
		while ( i < aL.size() && j < bL.size() && k < cL.size()){
			int a = aL.get(i);
			int b = bL.get(j);
			int c = cL.get(k);
			
			int min = Math.min(a, b);
			min = Math.min(min,c);
			
			int max = Math.max(a, b);
			max = Math.max(max,c);
			
			int diff = Math.abs(min-max);
			minDiff=Math.min(minDiff,diff);
			
			if ( a == min )i++;
			else if ( b == min )j++;
			else k++;
		}
		
		return minDiff;
	}
	
	public static void main(String[] args) {
		ArrayList <Integer> aL = new ArrayList <Integer> ( Arrays.asList(1,4,10));
		ArrayList <Integer> bL = new ArrayList <Integer> ( Arrays.asList(2,15,20));
		ArrayList <Integer> cL = new ArrayList <Integer> ( Arrays.asList(10,12));
		int min = new Array3Pointers().minimize(aL, bL, cL);
		System.out.println(min);

	}

}
