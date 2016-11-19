package fbExercises;

/**
 * 
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 

 * @author mrincodi
 * 2016-11-17
 * Comment: Cool. I didn't use "pow", as InterviewBit does.
 *
 */
public class IsPower {

	public boolean isPower(int n) {
		if ( n == 1 || n == 0) return true;
		for ( int q=2; q <= n/2; q++){
			if (exactLog (n,q)) return true;
		}
		return false;
	}

	private boolean exactLog (int n, int q){
		if ( n==q ) return true;
		if ( n < q ) return false;
		if ( n % q != 0 ) return false;
		return exactLog (n/q,q);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
