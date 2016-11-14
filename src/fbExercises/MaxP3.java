package fbExercises;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}
NOTE: Solution will fit in a 32-bit signed integer
Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000

 * @author mrincodi
 * 2016-11-12
 * 
 *
 */
public class MaxP3 {

	public int maxp3(ArrayList<Integer> a) {
		if (a.size() <3 ) return -1; //Or throw exception.
		if (a.size()==3) return a.get(0)*a.get(1)*a.get(2);

		Collections.sort(a);

		if (a.get(0) >=0) return a.get(a.size()-1)*a.get(a.size()-2)*a.get(a.size()-3);

		//The first number is negative.
		//What about the last one?
		if ( a.get(a.size()-1) <= 0 )
			return a.get(a.size()-1)*a.get(a.size()-2)*a.get(a.size()-3);
		else{
			//Final case.
			return Math.max (a.get(0)*a.get(1)*a.get(a.size()-1), a.get(a.size()-1)*a.get(a.size()-2)*a.get(a.size()-3));
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
