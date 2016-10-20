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
 * Comment: Ugh. Horrible code that does the work albeit it takes 
 * too long for interviwBit. Uses two matrices: one for values and another one
 * for number sequences (shame!) ;)
 *
 */
public class RodCuttingUgly {

	private int matrix[][];
	private ArrayList<Integer> [][] cutsMatrix;
	public ArrayList<Integer> rodCut(int length, ArrayList<Integer> cuts) {


		Collections.sort(cuts);
		cuts.add(0,0);
		cuts.add(length);
		ArrayList <Integer> result = new ArrayList <Integer> ();
		if ( length <= 1 || cuts.size() == 0 ) return result;
		
		matrix = new int  [ cuts.size()+1][cuts.size()+1];
		cutsMatrix = new ArrayList [ cuts.size()+1][cuts.size()+1];
		for ( int [] row: matrix ){
			Arrays.fill (row, -1);
		}
		
		int min = rodCut(cuts,0,cuts.size()-1, result);
		return result;
	}

	private int rodCut( ArrayList<Integer> cuts, int startIndex, int endIndex,  ArrayList<Integer> resultArray){
		if ( endIndex -1 == startIndex) return 0;
		if ( matrix[startIndex][endIndex]!= -1) {
			resultArray.addAll(cutsMatrix[startIndex][endIndex]);
			return matrix[startIndex][endIndex];
		}

		int length = cuts.get(endIndex)-cuts.get(startIndex);

		int resultVal = Integer.MAX_VALUE;

		for (int index = startIndex + 1; index < endIndex; index++){
			ArrayList<Integer> resultArrayLeft  = new ArrayList<Integer> ();
			ArrayList<Integer> resultArrayRight = new ArrayList<Integer> ();
			int resultLeft  = rodCut (cuts, startIndex, index, resultArrayLeft);
			int resultRight = rodCut (cuts, index, endIndex, resultArrayRight);
			int thisResult = length + resultLeft + resultRight;
			if ( thisResult < resultVal){
				resultVal = thisResult;
				resultArray.clear();
				resultArray.add(cuts.get(index));
				resultArray.addAll(resultArrayLeft);
				resultArray.addAll ( resultArrayRight);

			}
		}
		matrix[startIndex][endIndex]=resultVal;
		cutsMatrix[startIndex][endIndex]=resultArray;
		return resultVal;
	}



	public static void main(String[] args) {
		ArrayList<Integer> cuts = new ArrayList<Integer> (Arrays.asList(1,2,5));
		ArrayList<Integer> result = new RodCuttingUgly().rodCut(6, cuts);
		System.out.println(result);

	}

}
