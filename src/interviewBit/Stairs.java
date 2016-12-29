package interviewBit;

/**
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example :

Input : 3
Return : 3

Steps : [1 1 1], [1 2], [2 1]

 * @author mrincodi
 * 2016-12-12
 * Comment: The quintessential DP problem.
 * 
 */
public class Stairs {

	public int climbStairs(int a) {

		if ( a <= 1 ) return 1; 
		if ( a == 2 ) return 2;
		int [] stairs = new int [a];

		stairs [ a - 1 ] = 1;
		stairs [ a - 2 ] = 2;

		for ( int i = a - 3; i >= 0; i--){
			stairs [ i ] = stairs [ i + 1 ] + stairs [ i + 2 ];
		}

		return stairs [ 0 ];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
