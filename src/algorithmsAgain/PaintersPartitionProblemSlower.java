package algorithmsAgain;

import java.util.ArrayList;
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
 * Comment: Works, but slower than InterviewBit's solution.
 *
 */
public class PaintersPartitionProblemSlower {

	public int paint(int k, int t, ArrayList<Integer> lengths) {

		k = Math.min ( k, lengths.size()); // In case there are more painters than boards.

		long val = paintL (k, t, lengths );

		return ( int) ( val  % 10000003);
	}

	HashMap <String, Long > savedPaintings = new HashMap <String, Long > ();
	public long paintL(int k, int t, ArrayList<Integer> lengths) {
		String keyString = k + "_" + lengths.size();
		if ( savedPaintings.containsKey (keyString)) return savedPaintings.get(keyString);

		if ( k == 1 ) {
			long result = 0;
			//Add the lenghts and multiply by t.
			for ( int length : lengths )
				result += length;

			result = result * t;
			savedPaintings.put(keyString, result);
			return result;
		}

		else {
			//Take all the subsets that can be done with the first lengths.size() - k - 1 boards.
			long minimum = Long.MAX_VALUE;
			k--;

			long thisPaintersTime = 0;

			for ( int i = 0; i < lengths.size () - k; i++ ){
				thisPaintersTime += lengths.get(i) * t;

				if ( thisPaintersTime >= minimum ) {
					savedPaintings.put(keyString, minimum);   
					return minimum;
				}
				long minOtherPainters = paintL ( k, t, new ArrayList <Integer> ( lengths.subList ( i+1, lengths.size())));
				long minPainting =Math.max ( thisPaintersTime, minOtherPainters);
				minimum = Math.min (minimum, minPainting);
			}

			savedPaintings.put(keyString, minimum);   
			return minimum;        
		}


	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
