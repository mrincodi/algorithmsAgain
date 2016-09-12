package algorithmsAgain;

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
 * Comment: Good news: Works... Bad news: ...for small values of N. The number of 
 * chords grows... exponentially? A lot, anyways.
 * The trick is to consider sets of empty dots, not to use strings of used dots
 * (for 100 points I'd have 2^100 key strings. Ugh.)
 * I'll do the right answer in another program.
 */
public class IntersectingChordsInACircleBad {

	HashMap <String, Long> h = new HashMap <String, Long>();

	public int chordCnt(int A) {
		if (A<=1 ) return 1;
		long val = 0;
		StringBuffer sb = new StringBuffer ();
		for ( int i = 0; i < 2*A; i++){
			sb.append("0");
		}
		String s0 = sb.toString();

		for ( int i = 1; i < 2*A; i=i+2){
			StringBuilder sbu = new StringBuilder(s0);
			sbu.setCharAt(0,'1');
			sbu.setCharAt(i,'1');

			String s1=sbu.toString();

			val += chordCnt (A, s1, (2*A)-2);
		}
		val = val%(long)(Math.pow(10,9)+7);

		return (int) val;

	}

	long chordCnt(int A, String usedPos, int left) {
		if (left == 0 ) return 1;

		if (h.containsKey (usedPos)) return h.get(usedPos);

		//Find the smallest integer not used.
		int i = 1;
		while (usedPos.charAt(i)!='0' ) i++;

		// Found. Now, we need to find the numbers I can make a non-intersecting 
		// couple with.
		int j = i;
		while ( j < 2*A && usedPos.charAt(j)!='1') j++;

		j=j-1;

		long total = 0;
		StringBuilder sbu = new StringBuilder (usedPos);
		sbu.setCharAt(i,'1');
		for ( int k=i+1; k <= j; k=k+2){
			sbu.setCharAt(k,'1');
			total+=chordCnt( A, sbu.toString(), left-2);
			sbu.setCharAt(k,'0');
		}
		sbu.setCharAt(i,'0');
		h.put(usedPos, total);
		return total;
	}

	public static void main ( String [] args ){
		int a = new IntersectingChordsInACircleBad ().chordCnt(10);

		System.out.println(a);
	}

}
