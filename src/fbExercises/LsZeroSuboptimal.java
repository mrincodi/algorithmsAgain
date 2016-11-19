package fbExercises;

import java.util.ArrayList;

/**
 * 
 * Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

 * @author mrincodi
 * 2016-11-17
 * Comment: O(n^2) solution. Could also have used a matrix.
 *
 */
public class LsZeroSuboptimal {
	public ArrayList<Integer> lszero(ArrayList<Integer> a) {

		ArrayList<Integer> result = new ArrayList<Integer> ();

		if ( a == null || a.size() == 0 ) return result;

		int totalSum = a.get(0);

		int startZeroSeq = 0;
		int endZeroSeq = 0;
		int lengthZeroSeq = 0;
		if (a.get(0) == 0 ){
			lengthZeroSeq = 1;
		}

		outer:
			for ( int i = 1; i < a.size(); i++ ){
				totalSum += a.get(i);
				if ( totalSum == 0){
					startZeroSeq=0;
					endZeroSeq=i;
					lengthZeroSeq = i+1;
				}
				else {
					int thisSum = totalSum;
					for ( int j = 0; i - j > lengthZeroSeq; j++ ){
						thisSum = thisSum - a.get(j);
						if ( thisSum == 0 ){
							startZeroSeq=j+1;
							endZeroSeq=i;
							lengthZeroSeq = i - j;
							continue outer;
						}
					}
				}
			}

		//Now, show the sequence.
		if ( lengthZeroSeq != 0 ){
			for ( int i = startZeroSeq; i <= endZeroSeq; i++){
				result.add (a.get(i));
			}
		}

		return result;
	}

}
