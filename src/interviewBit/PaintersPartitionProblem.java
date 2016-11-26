package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * 
 * 
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.
Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board

Output:
     return minimum time to paint all boards % 10000003
Example

Input : 
  K : 2
  T : 5
  L : [1, 10]
Output : 50


 * @author mrincodi
 * 2016-09-17
 * Comment: With InterviewBit's strategy. As all the tables' sizes are positives,
 * greedily choosing the times for each painter, works. See the canBePartitioned
 * method.
 *
 */
public class PaintersPartitionProblem {
	public int paint(int k, int t, ArrayList<Integer> lengths) {

		k = Math.min ( k, lengths.size()); // In case there are more painters than boards.

		long val = paintL (k, t, lengths );

		return ( int) ( val  % 10000003L);
	}

	public long paintL(int k, int t, ArrayList<Integer> lengths) {

		//Add all the times.
		long totalLength = 0;
		long result = 0;

		for ( int length: lengths)
			totalLength += (long)length;

		long start = 0, end = totalLength;
		
		while ( start <= end){
			long mid = start + ( (end - start )/ 2);
			if ( canBePartitioned ( lengths , k, mid)){
				result = mid;
				end = mid - 1;
			}
			else{
				start = mid + 1; 
			}
		}
		
		return (long) (result) * (long) t;
	}

	boolean canBePartitioned ( ArrayList<Integer> lengths, int k, long value){
		int paintersSoFar = 1;
		long thisPainter = 0;
		for ( int i = 0; i < lengths.size(); i++ ){
			if ( paintersSoFar > k ) return false;
			long thisLength = (long) lengths.get(i);
			if ( thisLength > value) return false;
			if ( thisPainter + thisLength > value ){
				//k--;
				paintersSoFar++;
				thisPainter = thisLength;
			}
			else {
				thisPainter += thisLength;
			}
		}
		if ( paintersSoFar > k ) return false;
		return true;
	}

	public static void main(String[] args) {
		int k = 1;
		int t = 1000000;
		ArrayList<Integer> lengths = new ArrayList <Integer> ( Arrays.asList( 1000000, 1000000 ));
		int val = new PaintersPartitionProblem().paint(k,t,lengths);
		System.out.println(val);
	}

}
