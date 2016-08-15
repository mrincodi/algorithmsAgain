package algorithmsAgain;

import java.math.BigInteger;
import java.util.ArrayList;

public class SeatsGoodWithIntegers {

	public int seats(String a) {
		//Calculate the median. If there are 2, calculate the two and return the smallest.

		//int minJumps = -1;
		ArrayList <Integer> positions = new ArrayList <Integer> ();
		for ( int i = 0; i < a.length(); i++){
			if ( a.charAt(i) == 'x') positions.add(i);
		}
		if (positions.isEmpty()) return 0;
		//Get median.
		int medianIndex=positions.size()/2;
		int medianPos = positions.get(medianIndex);

		int totalJumps=0;

		//Calculate jumps before.
		int seatToJump = medianPos-1;
		for (int i = medianIndex-1; i>=0;i--){
			int busyPos = positions.get(i);
			int thisJump=seatToJump-busyPos;
			seatToJump--;
			totalJumps+=thisJump;
		}

		//Calculate jumps after.
		seatToJump = medianPos+1;
		for (int i = medianIndex+1; i<positions.size();i++){
			int busyPos = positions.get(i);
			int thisJump=busyPos-seatToJump;
			seatToJump++;
			totalJumps+=thisJump;
		}
//		
//		if ( minJumps == -1 ) minJumps=totalJumps;
//		else minJumps=Math.min(totalJumps, minJumps);
		
			return totalJumps;
	}

	



	public static void main(String[] args) {
		String s = "....x..xx...x..";
		s="....x.x.xxx.x.x.x..x..x..xx.x.xxxxxx.x.x.xxxxx.xx.......x.x.x......";
		int n = new SeatsGoodWithIntegers().seats(s);
		System.out.println(n);

	}

}
