package algorithmsAgain;

import java.util.Arrays;

/**
 * 
 * You are given a sequence of black and white horses, and a set of K stables numbered 1 to K. You have to accommodate the horses into the stables in such a way that the following conditions are satisfied:

You fill the horses into the stables preserving the relative order of horses. For instance, you cannot put horse 1 into stable 2 and horse 2 into stable 1. You have to preserve the ordering of the horses.
No stable should be empty and no horse should be left unaccommodated.
Take the product (number of white horses * number of black horses) for each stable and take the sum of all these products. This value should be the minimum among all possible accommodation arrangements
Example:


Input: {WWWB} , K = 2
Output: 0

Explanation:
We have 3 choices {W, WWB}, {WW, WB}, {WWW, B}
for first choice we will get 1*0 + 2*1 = 2.
for second choice we will get 2*0 + 1*1 = 1.
for third choice we will get 3*0 + 0*1 = 0.

Of the 3 choices, the third choice is the best option. 

If a solution is not possible, then return -1
 * @author mrincodi
 * 2016-10-15
 * Comment: With recursion and a little table for previously calculated values.
 * InterviewBit's solution doesn't use recursion. Hmmm...
 * After closer examination, InterviewBit's solutions also do a lot of calculation of substrings.
 * I think my solution is even better, as I calculate the value for the current stable gradually, without
 * a total recalculation per new horse.
 *
 */
public class ArrangeII {

	int matrix [][]= new int[1][1];

	public int arrange(String a, int stables) {

		if ( a.length()<stables) return -1;
		
		matrix = new int [stables + 1][a.length() + 1];
		for ( int [] array: matrix ){
			Arrays.fill(array, -1);
		}
		return arrange (a, stables, 0);
	}
	
	private int arrange(String a, int stables, int start) {
		if ( matrix[stables][start] != -1) return matrix[stables][start];
		int result = 0;
		int whites = 0;
		int blacks = 0;
		if (stables == 1){
			for ( int i = start; i < a.length(); i++){
				char c = a.charAt(i);
				if ( c == 'W') whites++;
				else blacks++;				
			}
			result=whites*blacks;
			matrix[stables][start]=result;
			return result;
		}

		int numHorses = a.length();
		int thisStable =0;
		result = Integer.MAX_VALUE;
		for (int i = start; i <= numHorses - stables; i++){
			char c = a.charAt(i);
			if ( c == 'W') whites++;
			else blacks++;				
			
			thisStable=whites*blacks;
			int otherStables=arrange (a, stables - 1, i + 1);
			int total = thisStable + otherStables;
			result = Math.min(result, total);
		}
		matrix[stables][start]=result;
		return result;
	}


	public static void main(String[] args) {
		String a ="WBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWB";
		int stables = 2;
		int b = new ArrangeII().arrange(a, stables);
		System.out.println(b);

	}

}
