package interviewBit;

import java.math.BigInteger;


public class SeatsBadWithBigIntegers {

	public int seats(String a) {
		//Calculate the numbers for each position. Then, return the smaller one.

		if ( a == null || a.length()==0 ) return 0;
		int startPos=0;

		BigInteger minJumps = BigInteger.ZERO;
		
		boolean ONE_X=false;
		while (startPos < a.length ()){
			if (a.charAt(startPos) == 'x' ){
				ONE_X=true;
				if ( startPos != 0 && a.charAt (startPos-1) == 'x') {
					startPos++;
					continue;
				}

				//values less than this position.
				BigInteger totalJumps = BigInteger.ZERO;
				int nextAvailable = startPos-1;
				for ( int i = startPos - 2; i >=0; i--){
					if (a.charAt(i)=='x'){
						long jump = nextAvailable - i;
						totalJumps=totalJumps.add(BigInteger.valueOf(jump));
						nextAvailable--;
					}
				}

				//values more than this position.
				int endPos = startPos + 1;
				while (endPos < a.length () && a.charAt(endPos) == 'x' )
					endPos++;

				nextAvailable = endPos;
				endPos=endPos-1;

				for ( int i = endPos + 2; i < a.length (); i++ ){
					if (a.charAt(i)=='x'){
						long jump = i - nextAvailable;
						totalJumps=totalJumps.add(BigInteger.valueOf(jump));
						nextAvailable++;
					}
				}
				if ( minJumps.equals(BigInteger.ZERO)) minJumps=totalJumps;
				else
					minJumps=minJumps.min(totalJumps);
			}
			startPos++;
		}

		if ( !ONE_X ) return 0;
		
		minJumps=minJumps.mod(BigInteger.valueOf(10000003));
		return minJumps.intValue();
//				(int)(minJumps % 10000003);
	}




	public static void main(String[] args) {
		String s = "....x..xx...x..";
		int n = new SeatsBadWithBigIntegers().seats(s);
		System.out.println(n);

	}

}
