package interviewBit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * 
 * You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. Since this multiple could be large, return it in form of a string.

Note:
- Returned string should not contain leading zeroes.

For example,

For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
For N = 2, 10 is the answer.
 * 
 * @author mrincodi
 * 2016-08-15
 * Comment: DOESN'T WORK. Don't even run it. There's still a lot to do.
 * I stopped working on this to study other things.
 * I guess it will run OK if I work on it at least 1 hour.
 */
public class SmallestMultipleWith0and1Wrong {


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

		//Create all values to test first in a list, then sort the list, then test the value.
		ArrayList<String> testValues = new ArrayList<String> ();
		for ( int i = 0; i < possibleLowerDigits.size(); i++){
			String xS = possibleLowerDigits.get(i);
			for (int j = 0; j <= 9 ;j++){
				testValues.add(j + xS);
			}
		}
		Collections.sort(testValues);

		ArrayList<String> possibleLowerDigits2 = new ArrayList <String> ();

		boolean found = false;
		int digitLevel=2;
		for ( int i = 0; i < testValues.size() && !found ; i++){
			String testValueS = testValues.get(i);
			BigInteger x = new BigInteger ( testValueS );

			BigInteger product = n.multiply(x);
			if (product.toString().length()<digitLevel) 
				//TODO: NO, First add to possibleLowerDigits2, then continue.
				continue;

			String digitsICareFor=product.toString().substring(product.toString().length()-digitLevel,product.toString().length());

			char digitC = digitsICareFor.charAt(0);

			if ( digitC == '0' || digitC == '1') { 
				if ( valid (product.toString())) 
					return product.toString();
				if (!valid ( digitsICareFor))
					System.out.println("What??" + product + ", x=" + x );

				possibleLowerDigits2.add(testValueS);
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
	String qq = new SmallestMultipleWith0and1Wrong().multiple(x);
	System.out.println(qq);
}
}
