package interviewBit;
/**
 * 
 * 
 * 
 * Add One To Number

Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0�s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0�s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
import java.util.ArrayList;

public class AddOne {


	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		ArrayList <Integer> result = new ArrayList <Integer> ();
		//First, prune the 0's at the beginning.

		if (a.size() == 0 ){
			result.add (1);
			return result;
		} 

		int ii=0;
		while (ii < a.size() && a.get(ii) == 0) ii++;

		if (ii==a.size()){
			result.add (1);
			return result;
		}

		//Now, let's copy the values of a into the new array.
		for ( ; ii < a.size(); ii++ ){
			result.add (a.get (ii));
		}

		//Now, let's start modifying the array if needed.

		ii=result.size () - 1;

		boolean stop = false;

		while (ii >=0 && !stop) {
			int newVal = result.get(ii) + 1;
			if (newVal < 10 ){
				result.set(ii, newVal);
				stop=true;
			}
			else {
				result.set(ii, 0);
				ii--;
			}
		}

		if ( !stop ){
			//Add a "1" at the beginning of the array.
			ArrayList <Integer> result2 = new ArrayList <Integer> ();
			result2.add (1);
			result2.addAll (result);
			result = result2;
		}

		return result;


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
