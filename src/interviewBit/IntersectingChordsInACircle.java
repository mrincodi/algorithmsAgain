package interviewBit;

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
 * Comment: With sets. This solution works because I am using the all-time
 * favorite "BigInteger".
 */
public class IntersectingChordsInACircle {

	//For a number of x free points, how many intersecting lines do I have?
	HashMap <Integer, java.math.BigInteger> h = new HashMap <Integer, java.math.BigInteger>();

	public int chordCnt(int A) {
		
		java.math.BigInteger totalBI = chordCnt1(A);
		totalBI=totalBI.mod(java.math.BigInteger.valueOf(10).pow(9).add(java.math.BigInteger.valueOf(7)));
//		System.out.println("TENGO... " + totalL);
//		java.math.BigInteger totalL2 = (totalL % (java.math.BigInteger)(Math.pow(10, 9) + 7));
//		System.out.println("AHORA TENGO... " + totalL2);
		//int totalI = (int) totalL2;
		int totalI = totalBI.intValue();
		return totalI;
	}
	
	public java.math.BigInteger chordCnt1(int A) {
		java.math.BigInteger total =BigInteger.valueOf(0);
		if (h.containsKey(A)) total = h.get(A);
		else {
			//2*A is the number of free points (size).
			if (A==0) return BigInteger.valueOf(1);
			if ( 2*A == 2 ) return BigInteger.valueOf(1);

			for ( int i = 1; i < 2*A; i+=2){
				int size1 = i-1;
				int size2 = (2*A)-size1 - 2;

				java.math.BigInteger partial1 = chordCnt1 (size1/2);
				java.math.BigInteger partial2 = chordCnt1 (size2/2);
				java.math.BigInteger thisTotal = (partial1.multiply(partial2));
				total=total.add(thisTotal);
			}
			System.out.println(total);
			h.put(A, total);
		}

		return total;
	}


	//	private java.math.BigInteger chordCnt(int A, int a, int b) {
	//		// We assume the circle is free from a to b.
	//		int size = b - a - 1;
	//		
	//		if (h.containsKey(size)) return h.get(size);
	//		
	//		if ( size == 0 ) return 1;
	//		
	//		java.math.BigInteger total=0;
	//		for ( int i = a+2; i < b; i = i+2){
	//			total += chordCnt (A,a+1,b);
	//		}
	//		h.put(size, total);
	//		return total;
	//	}
	//




	public static void main ( String [] args ){
		int a = new IntersectingChordsInACircle ().chordCnt(100);

		System.out.println(a);
	}

}
