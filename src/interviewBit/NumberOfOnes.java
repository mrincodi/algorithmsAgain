package interviewBit;

/**
 * Number of 1 BitsBookmark Suggest Edit
Write a function that takes an unsigned integer and returns the number of 1 bits it has.

Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.

Note that since Java does not have unsigned int, use long for Java

 * @author mrincodi
 *
 */
public class NumberOfOnes {


	public int numSetBits(long a) {
		int n = 0;
		while ( a >0 ){
			if ( a%2 == 1) n++;
			a=a/2;
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
