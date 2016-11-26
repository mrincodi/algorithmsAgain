package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example: 
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 * @author mrincodi
 * 2016-10-05
 * Comment: This works in O(n). I promise. It's convoluted, I admit, but does the
 * work. For some mysterious reason InterviewBit thinks it takes too long. I don't know why.
 * This works and is O(n). I guess there should be a shorter (codewise) way of 
 * doing this, though.
 */
public class LongestConsecutive {

	public int longestConsecutive(final List<Integer> a) {

		if ( a.size() <= 1 ) return a.size();

		HashMap <Integer, Integer> seq = new HashMap <Integer, Integer> ();
		HashSet <Integer> already = new HashSet <Integer> ();
		int maxSeq = 1;

		for ( int n: a){

			//Look for smaller and greater values in sequences.

			if ( already.contains (n) ) continue;
			already.add(n);

			if ( !seq.containsKey (n-1) && !seq.containsKey (n+1)){
				seq.put (n,1);
				continue;
			}

			if ( seq.containsKey (n-1) && !seq.containsKey (n+1)){
				int val = seq.get (n-1);

				if (val == 1){
					seq.put (n-1, 2);
					seq.put (n, -2);
					maxSeq = Math.max(maxSeq, 2);
				}
				else if ( val < 1){ // should always be the remaining case.
					//Find the source:
					int initialKey = n + val;
					seq.put (initialKey, -val + 1);
					seq.put (n, val - 1);
					seq.remove (n - 1);
					maxSeq = Math.max(maxSeq, -val + 1);
				}
			}
			else if ( !seq.containsKey (n-1) && seq.containsKey (n+1)){
				int val = seq.get (n+1);

				if (val == 1){
					seq.put (n+1, -2);
					seq.put (n, 2);
					maxSeq = Math.max(maxSeq, 2);
				}
				else if ( val > 1){ // should always be the remaining case.
					//Find the source:
					int finalKey = n + val;
					seq.put (finalKey, -val - 1);
					seq.put (n, val + 1);
					seq.remove (n + 1);
					maxSeq = Math.max(maxSeq, val + 1);
				}
			}
			else{
				//The most convoluted case. Joining two sequences.
				int prevVal = seq.get(n-1);
				int nextVal = seq.get(n+1);
				if (prevVal == 1 && nextVal == 1){
					seq.put(n-1, 3);
					seq.put(n+1, -3);
					maxSeq = Math.max(maxSeq, 3);
				}
				else if (prevVal == 1){
					seq.put(n + nextVal, -nextVal - 2 );
					seq.put(n - 1, nextVal + 2);
					seq.remove(n+1);
					maxSeq = Math.max(maxSeq, nextVal + 2);
				}
				else if (nextVal == 1){
					seq.put(n + prevVal, -prevVal + 2); //prevVal is negative.
					seq.put(n+1, prevVal - 2);
					seq.remove(n-1);
					maxSeq = Math.max(maxSeq, -prevVal + 2);
				}
				else {
					seq.put(n + prevVal, -prevVal + nextVal + 1 ); //prevVal is negative.
					seq.put(n + nextVal, prevVal - nextVal - 1);
					seq.remove(n-1);
					seq.remove(n+1);
					maxSeq = Math.max(maxSeq, -prevVal + nextVal + 1);
				}
			}
		}
		return maxSeq;
	}

	public static void main(String[] args) {
		Integer[]array={4,3,7,100,6,5,10,12,9,8, 400,500,11};
		//Integer[]array={37,38,39,40,41};
		ArrayList <Integer> a = new ArrayList <Integer> (Arrays.asList(array));
		int lc = new LongestConsecutive().longestConsecutive(a);
		System.out.println(lc);
	}

}
