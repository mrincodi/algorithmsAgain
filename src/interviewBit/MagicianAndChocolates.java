package interviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7
 * @author mrincodi
 * 2016-11-19
 * Comment: Elementary, save that silly 10^9 constraint.
 *
 */
public class MagicianAndChocolates {

	public int nchoc(int k, ArrayList<Integer> a) {
		long resultL = 0L;

		if ( k <=0 ) return 0;
		PriorityQueue <Long> heap = new PriorityQueue <Long> (Collections.reverseOrder()); //TODO: check syntax.

		//Fill the heap.
		for ( int num:a ){
			heap.add((long)num);
		}

		for ( int i = 1; i<= k; i++){
			long num = heap.remove();
			resultL += num;
			resultL = resultL % 1000000007;
			long newNum = num/2;
			heap.add(newNum);
		}

		return (int) resultL;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
