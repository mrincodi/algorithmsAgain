package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * 
 * There is a rod of length N lying on x-axis with its left end at x = 0 and right end at x = N. Now, there are M weak points on this rod denoted by positive integer values(all less than N) A1, A2, …, AM. You have to cut rod at all these weak points. You can perform these cuts in any order. After a cut, rod gets divided into two smaller sub-rods. Cost of making a cut is the length of the sub-rod in which you are making a cut.

Your aim is to minimise this cost. Return an array denoting the sequence in which you will make cuts. If two different sequences of cuts give same cost, return the lexicographically smallest.

Notes: 
- Sequence a1, a2 ,…, an is lexicographically smaller than b1, b2 ,…, bm, if and only if at the first i where ai and bi differ, ai < bi, or if no such i found, then n < m.
- N can be upto 109.

For example,

N = 6
A = [1, 2, 5]

If we make cuts in order [1, 2, 5], let us see what total cost would be.
For first cut, the length of rod is 6.
For second cut, the length of sub-rod in which we are making cut is 5(since we already have made a cut at 1).
For third cut, the length of sub-rod in which we are making cut is 4(since we already have made a cut at 2).
So, total cost is 6 + 5 + 4.

Cut order          | Sum of cost
(lexicographically | of each cut
 sorted)           |
___________________|_______________
[1, 2, 5]          | 6 + 5 + 4 = 15
[1, 5, 2]          | 6 + 5 + 4 = 15
[2, 1, 5]          | 6 + 2 + 4 = 12
[2, 5, 1]          | 6 + 4 + 2 = 12
[5, 1, 2]          | 6 + 5 + 4 = 15
[5, 2, 1]          | 6 + 5 + 2 = 13


So, we return [2, 1, 5].
 * @author mrincodi
 * 2016-10-16
 * Comment: WOOOOOOW... What a ******** problem!!!!
 * VERY challenging, despite its simple definition!
 * 
 */
public class RodCutting {

	long [][] matrix;
	int [][] bestCuts;

	public ArrayList<Integer> rodCut(int length, ArrayList<Integer> cuts) {
		if ( cuts.size() <= 1 ) return cuts;

		cuts.add(0,0);
		cuts.add(length);

		matrix= new long [cuts.size()][cuts.size()];
		bestCuts  = new int [cuts.size()][cuts.size()];

		// iCounter represent the number of cuts in the interval -1. We start with "2" (3).
		// because an interval with "1" (2) (only the boundaries; no cuts) has as cost "0".
		// We'll start calculating all the costs for cutting the sub-rods whose 
		// limits are the cuts (cuts[0],cuts[2]), (cuts[1],cuts[3]),...,(cuts[n-3]cuts[n-1]).
		// Remember we added the lower (0) and upper (length) limits to cuts.
		// In this case, obviously the values will be the length of each segment.
		// After we calculate these numbers for iCounter = 3 (4), etc...

		for ( int iCounter = 2; iCounter < cuts.size(); iCounter++){
			for ( int jCounter = 0; jCounter < cuts.size() - iCounter; jCounter++ ){
				int row=jCounter;
				int col=iCounter + jCounter;
				int thisLength = cuts.get(col)-cuts.get(row);
				long minResult = Long.MAX_VALUE;

				for ( int midIndex = 1; midIndex < iCounter; midIndex++){
					long thisResult = matrix [ row ][ midIndex + row ] + matrix [ midIndex + row ][col] + thisLength;
					if ( thisResult < minResult ){
						minResult=thisResult;
						matrix[row][col]= thisResult;
						bestCuts[row][col]= midIndex + row;
					}
				}
			}
		}

		//Now, to top it off, make a beautiful recursive method to get the list of cuts. Sweet Jeebus...
		System.out.println ( matrix [0][cuts.size()-1]);
		return makeCutsArray(0, cuts.size()-1, cuts);
	}

	private ArrayList<Integer> makeCutsArray ( int row, int col, ArrayList <Integer> cuts ){
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if ( bestCuts[row][col] == 0 ) return result;
		else {
			result.add(cuts.get(bestCuts[row][col]));
			result.addAll (makeCutsArray (row, bestCuts[row][col], cuts));
			result.addAll (makeCutsArray (bestCuts[row][col], col, cuts));	
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> cuts = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5,6,7,8,9,10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 
20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 
30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 
40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 
50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 
60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 
70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 
80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 
90, 91, 92, 93, 94, 95, 96, 97, 98, 99));
		ArrayList<Integer> result = new RodCutting().rodCut(100, cuts);
		System.out.println(result);
	}
}
