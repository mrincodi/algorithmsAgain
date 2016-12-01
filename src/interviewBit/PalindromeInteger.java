package interviewBit;
/**
 * Palindrome IntegerBookmark
Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False

2016-07-06
 * @author mrincodi
 *
 */
public class PalindromeInteger {


	int pos ( int n, int p ){
		//	        System.out.println ( "pos of " + n + " and " + p );

		if ( p == 1) return ( n % 10 );   

		int ret = ( n / (( int ) Math.pow ( 10, ( p - 1) ) ) ) % 10;
		//	        System.out.println ( "I get "+ ret );
		return ret;
	}

	public boolean isPalindrome(int a) {
		//Get how many position does this number have.
		int size = String.valueOf ( a ).length ();

		for ( int i = 1; i <= size/2; i++){
			int x = pos ( a, i );
			int y = pos ( a, size - i + 1);
			//	            System.out.println ( "Comparing " + x + " and " + y );
			if ( x != y ) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
