package fbExercises;

/**
 * 
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.

Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.

Note that since Java does not have unsigned int, use long for Java

 * @author mrincodi
 * 2016-11-12
 * Comment: The obvious solution...
 *
 */
public class Num1Bits2 {


	public int numSetBits(long a) {
		int result = 0;
		while (a>0){
			a=(a-1)&a;
			result++;
		}
		return result;
		
//		for ( int i = 0; i <= 32; i++){
//			result += a%2L;
//			a=a>>1;
//		}
//		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
