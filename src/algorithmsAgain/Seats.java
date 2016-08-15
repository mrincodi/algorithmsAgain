package algorithmsAgain;

import java.util.ArrayList;

/**
 * There is a row of seats. Assume that it contains N seats adjacent to each other. There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.

An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')

Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.

Return minimum value % MOD where MOD = 10000003

Example

Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14) -

              . . . . x . . x x . . . x . .

Now to make them sit together one of approaches is -
                  . . . . . . x x x x . . . . .

Following are the steps to achieve this -
1 - Move the person sitting at 4th index to 6th index -  
    Number of jumps by him =   (6 - 4) = 2

2 - Bring the person sitting at 12th index to 9th index - 
    Number of jumps by him = (12 - 9) = 3

So now the total number of jumps made = 
    ( 2 + 3 ) % MOD = 
    5 which is the minimum possible jumps to make them seat together.

There are also other ways to make them sit together but the number of jumps will exceed 5 and that will not be minimum.

For example bring them all towards the starting of the row i.e. start placing them from index 0. 
In that case the total number of jumps will be 
    ( 4 + 6 + 6 + 9 )%MOD 
    = 25 which is very costly and not an optimized way to do this movement

 * @author mrincodi
 * 2016-08-13
 * Comment: Damn, these greedy exercises make you feel dumb... and then you see the hint
 * and you feel even dumber.
 * The hint here is that the median always gives you the best approach.
 *
 */
public class Seats {

	public int seats(String a) {

		//long minJumps = -1;
		ArrayList <Integer> positions = new ArrayList <Integer> ();
		for ( int i = 0; i < a.length(); i++){
			if ( a.charAt(i) == 'x') positions.add(i);
		}
		if (positions.isEmpty()) return 0;
		//Get median.
		int medianIndex=positions.size()/2;
		long medianPos = positions.get(medianIndex);

		long totalJumps=0;

		//Calculate jumps before.
		long seatToJump = medianPos-1;
		for (int i = medianIndex-1; i>=0;i--){
			long busyPos = positions.get(i);
			long thisJump=seatToJump-busyPos;
			seatToJump--;
			totalJumps+=thisJump;
		}

		//Calculate jumps after.
		seatToJump = medianPos+1;
		for (int i = medianIndex+1; i<positions.size();i++){
			int busyPos = positions.get(i);
			long thisJump=busyPos-seatToJump;
			seatToJump++;
			totalJumps+=thisJump;
		}
//		
//		if ( minJumps == -1 ) minJumps=totalJumps;
//		else minJumps=Math.min(totalJumps, minJumps);
		
			return (int)(totalJumps%10000003L);
	}

	



	public static void main(String[] args) {
		String s = "....x..xx...x..";
		s="....x.x.xxx.x.x.x..x..x..xx.x.xxxxxx.x.x.xxxxx.xx.......x.x.x......";
		long n = new Seats().seats(s);
		System.out.println(n);

	}

}
