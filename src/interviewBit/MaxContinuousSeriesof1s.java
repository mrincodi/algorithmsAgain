package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Max Continuous Series of 1s
You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.

 * @author mrincodi
 * 2017-01-02
 * Comment: Enhanced after a long time. Nice exercise. O(n). 
 *
 */
public class MaxContinuousSeriesof1s {
	public ArrayList<Integer> maxone(ArrayList<Integer> numbers, int numFlips) {

		ArrayList<Integer> result = new ArrayList<Integer> ();
		int start = -1;
		int end = -1;
		int size = 0;
		
		if ( numbers == null ) return result;
		
		//Save the position of the zero's.
		ArrayList <Integer > zeroPos = new ArrayList <Integer > ();
		zeroPos.add(-1);
		
		for (int i = 0; i < numbers.size(); i++){
			if (numbers.get(i)==0) zeroPos.add(i);
		}
		zeroPos.add(numbers.size());

		if ( zeroPos.size() - 2 <= numFlips ){
			start=0;
			end = numbers.size()-1;
		}
		else {
			for ( int i = 1; i < zeroPos.size() - numFlips; i++){
				int limInf = zeroPos.get(i-1) + 1;
				int limSup = zeroPos.get(i + numFlips) - 1;
				int thisSize = limSup - limInf;
				if ( thisSize > size){
					start = limInf;
					end = limSup;
					size = thisSize;
				}
			}
		
		}
			
		//Finally, return the positions.
		for ( int i = start; i <= end; i++){
			result.add(i);
		}
		
		return result;
	}

	public static void main(String[] args) {
		ArrayList <Integer>  al = new ArrayList <Integer> ( Arrays.asList(0,0,1,1,0,1,1,0,0,1));
		
		ArrayList <Integer>  result = new MaxContinuousSeriesof1s ().maxone(al, 1);
		
		for ( int i = 0; i < result.size(); i++ )
			System.out.println("--> "+ result.get(i));
		// TODO Auto-generated method stub

	}

}
