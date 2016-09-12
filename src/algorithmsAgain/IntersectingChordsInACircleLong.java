package algorithmsAgain;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Given a number N, return number of ways you can draw N chords in a circle with 2*N points such that no 2 chords intersect.
Two ways are different if there exists a chord which is present in one way and not in other.

For example,

N=2
If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:
{(1-2), (3-4)} and {(1-4), (2-3)}

So, we return 2.
Notes:

1 ≤ N ≤ 1000
Return answer modulo 109+7.

 * @author mrincodi
 * 2016-08-11
 * Comment: With sets. Works for small values of N. I am using longs.
 */
public class IntersectingChordsInACircleLong {

	//For a number of x free points, how many intersecting lines do I have?
	HashMap <Integer, Long> h = new HashMap <Integer, Long>();

	java.math.BigInteger b = java.math.BigInteger.valueOf (0); 

	public int chordCnt(int A) {

		long totalL = chordCnt1(A);
		//System.out.println("TENGO... " + totalL);
		long totalL2 = (totalL % (long)(Math.pow(10, 9) + 7));
		//System.out.println("AHORA TENGO... " + totalL2);
		int totalI = (int) totalL2;
		return totalI;
	}

	public long chordCnt1(int A) {
		long total =0;
		if (h.containsKey(A)) total = h.get(A);
		else {
			//2*A is the number of free points (size).
			if (A==0) return 1;
			if ( 2*A == 2 ) return 1;

			for ( int i = 1; i < 2*A; i+=2){
				int size1 = i-1;
				int size2 = (2*A)-size1 - 2;

				long partial1 = chordCnt1 (size1/2);
				long partial2 = chordCnt1 (size2/2);
				long thisTotal = (partial1 * partial2);
				total += thisTotal;
			}

			h.put(A, total);
		}

		return total;
	}





	public static void main ( String [] args ){
		int a = new IntersectingChordsInACircleLong ().chordCnt(10);

		System.out.println(a);
	}

}
