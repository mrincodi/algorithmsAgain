package interviewBit;

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
 * 2016-08-12
 * Comment: Compare with InterviewBit's solution. It was not my best moment.
 */
public class HighestProduct {

	public int maxp3(ArrayList<Integer> a) {
		Collections.sort(a);
		Collections.reverse(a);

		//	        System.out.println ( "El primero es " + a.get(0));

		int positives=0, zeroes=0, negatives=0;
		for ( int i = 0; i < a.size(); i++){
			if ( a.get(i) > 0 ) positives++;
			if ( a.get(i) ==0 ) zeroes++;
			if ( a.get(i) < 0 ) negatives++;
		}

		if (positives >= 3){
			if ( negatives >=2 ){
				return Math.max (a.get(0)*a.get(1)*a.get(2),
						a.get(0)*a.get(a.size()-1)*a.get(a.size()-2) );
			}
			else return a.get(0)*a.get(1)*a.get(2);
		}

		else if (positives == 2){
			if ( negatives >= 2) return a.get(0)*a.get(a.size()-1)*a.get(a.size()-2);
			else return a.get(0)*a.get(1)*a.get(2);
		} 

		else if (positives == 1){
			if ( negatives >= 2) return a.get(0)*a.get(a.size()-1)*a.get(a.size()-2);
			else return a.get(0)*a.get(1)*a.get(2);
		}

		return a.get(0)*a.get(1)*a.get(2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
