package interviewBit;

import java.util.ArrayList;

/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return 1 ( true ).

A = [3,2,1,0,4], return 0 ( false ).

Return 0/1 for this problem
 * @author mrincodi
 * 2016-08-10
 * Comment: Typical dynamic programming, BUT there is an approach that is linear,
 * that InterviewBit uses (greedy?).
 */
public class JumpGameArray {

	public int canJump(ArrayList<Integer> a) {
		if (a.size() <= 1 ) return 1;
		int [] positions = new int [ a.size() ];

		positions[a.size() - 1] = 1;
		for (int i = a.size() - 2; i >=0; i--){

			//Now, let's see if we find a value in the array, forward.
			boolean canDo=false;
			for ( int j = 1; !canDo && j <= a.get(i) && i+j < a.size()  ; j++ ){
				if (positions[i+j] == 1){
					positions[i]=1;
					canDo=true;
				}
			}
		}
		return positions[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
