package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12 
Return the numbers in sorted order.

 * @author mrincodi
 * 2016-10-21
 * Comment: My solution. Nothing to do with graphs.
 */
public class SteppingNumbers {

	public ArrayList<Integer> stepnum(int a, int b) {
		//TODO: Let's say smallest one is "a".

		ArrayList <Integer> result = new ArrayList <Integer> ();

		int numDigitsA = String.valueOf(a).length();
		int numDigitsB = String.valueOf(b).length();

		for ( int numDigits = numDigitsA; numDigits <= numDigitsB; numDigits++){
			result.addAll ( steppingNumbers (numDigits, 0, 0) );
		}

		int i = 0;
		while ( result.get(i)< a) i++;

		int j = result.size()-1;
		while ( result.get(j)> b) j--;

		result = new ArrayList <Integer> (result.subList (i, j+1));

		return result;
	}


	ArrayList <Integer> steppingNumbers ( int numDigits, int current, int pos ){
		//Pos is the current position to calculate, so start with 0. End when pos == numDigits.
		ArrayList <Integer> result = new ArrayList <Integer> ();
		if ( pos == numDigits ) return new ArrayList <Integer> (Arrays.asList (current));
		if ( pos == 0 ){	//Indicates 'start'
			int start=numDigits==1?0:1;
			for ( int i = start; i <=9; i++ ){
				ArrayList <Integer> thisResult = steppingNumbers (numDigits, i, 1);
				result.addAll (thisResult);
			}
			return result;
		}
		int smallestDigit = current%10;
		int neighbor1 = smallestDigit-1;
		int neighbor2 = smallestDigit+1;

		if ( neighbor1 != -1 ) result.addAll (steppingNumbers (numDigits, current * 10 + neighbor1, pos+1));         
		if ( neighbor2 != 10 ) result.addAll (steppingNumbers (numDigits, current * 10 + neighbor2, pos+1));

		return result;
	}

	public static void main(String[] args) {
		ArrayList <Integer> al = new SteppingNumbers().stepnum(0, 1200);
		
		System.out.println(al);

	}

}
