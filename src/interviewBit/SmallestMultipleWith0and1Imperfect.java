package interviewBit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * 
 * 
 * You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. Since this multiple could be large, return it in form of a string.

Note:
- Returned string should not contain leading zeroes.

For example,

For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
For N = 2, 10 is the answer.

 * @author mrincodi
 * 2016-08-15
 * Comment: My imperfect solution provided to InterviewBit.
 * Gives a partially correct answer.
 * Still, it doesn't work Ok after a close inspection. It doesn't check the
 * possible options in order.
 */
public class SmallestMultipleWith0and1Imperfect {



	BigInteger TEN = new BigInteger ( 10 + "");
	public String multiple(int A) {
		//Try all the numbers from 0 to 9.
		BigInteger n = new BigInteger(A + "");

		ArrayList <String> possibleLowerDigits = new ArrayList <String> ();

		possibleLowerDigits.add ("0");
		//Let's start with the first entries.
		for (int i = 1; i <=9; i++){
			BigInteger x = new BigInteger(i + "");
			BigInteger product = n.multiply(x);
			BigInteger digit = product.mod(TEN);
			if (digit.equals(BigInteger.ZERO) || digit.equals(BigInteger.ONE )){
				//Check if this is a solution.
				if (valid (product.toString())) 
					return product.toString();
				else possibleLowerDigits.add ( x.toString() );
			}
		}

		boolean found = false;
		int digitLevel=2;
		while (!found){
			ArrayList<String> possibleLowerDigits2 = new ArrayList <String> ();

			for ( int i = 0; i < possibleLowerDigits.size() ; i++)
				possibleLowerDigits2.add( "0" + possibleLowerDigits.get(i).toString());

			for ( int i = 0; i < possibleLowerDigits.size() && !found ; i++){
				String xS = possibleLowerDigits.get(i);

				for (int j = 1; j <= 9 ;j++){
					BigInteger x = new BigInteger ( j + xS );
					BigInteger product = n.multiply(x);
					char digitC = product.toString().charAt(product.toString().length()-digitLevel);
					if ( digitC == '0' || digitC == '1') { 
						if ( valid (product.toString())) 
							return product.toString();
						if ( valid (product.toString().substring(product.toString().length()-digitLevel,product.toString().length())))
							possibleLowerDigits2.add(x.toString());
					}
				}
			}
			//System.out.println(possibleLowerDigits2.size());
			possibleLowerDigits = new ArrayList <String> (possibleLowerDigits2);
			Collections.sort(possibleLowerDigits);
			//for ( int qq = 0; qq < Math.min(100, possibleLowerDigits.size()); qq++){ System.out.print(possibleLowerDigits.get(qq) + " "); }
			digitLevel++;
			//System.out.println();
		}
		return null;
	}

	boolean valid ( String s){
		for (int i = 0; i < s.length();i++){
			if ( s.charAt(i) != '0' && s.charAt(i) != '1' ) return false;
		}
		return true;
	}



	public static void main (String [] args ){
		int x = 12;
		String qq = new SmallestMultipleWith0and1Imperfect().multiple(x);
		System.out.println(qq);
	}
}
