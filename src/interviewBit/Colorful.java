package interviewBit;

import java.util.HashSet;
/**
 * 
 * 
 * For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1

 * @author mrincodi
 * 2016-12-11
 * Comment: Easy.
 *
 */
public class Colorful {

	public int colorful(int a) {
		HashSet <Integer> numbers = new HashSet <Integer> ();
		
		char [] cDigits = String.valueOf(a).toCharArray();
		
		for ( char c: cDigits){
			int number=Character.getNumericValue( c);
			if ( numbers.contains(number)) return 0;
			numbers.add(number);
		}
		
		for (int size = 2; size <= cDigits.length; size++){
			for ( int i = 0; i <= cDigits.length-size ; i++){
				char cc = cDigits[i];
				int prod = Character.getNumericValue( cc);
				for ( int j = i+1; j < i+size; j++){
					char c = cDigits[j];
					int digit = Character.getNumericValue( c);
					prod *= digit;
				}
				if ( numbers.contains(prod)) return 0;
				numbers.add(prod);
			}
		}
		return 1;
	}
	
	
	public static void main(String[] args) {
		int a = 230;
		int r = new Colorful().colorful(a);
		
		System.out.println(r);

	}

}
