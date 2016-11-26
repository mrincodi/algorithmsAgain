package interviewBit;

import java.util.ArrayList;

/**
 * 
 * Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]

 * @author mrincodi
 * 2016-11-18
 * Comment: Second approach. Only one pass to the array.
 * The challenge is how to generalize this for n colors.
 *
 */
public class SortByColor {
	public void sortColors(ArrayList<Integer> a) {
		if ( a.size() <= 1 ) return;


		int zeroLimit = 0;
		int twoLimit = a.size() - 1;


		for ( int i = 0; i <= twoLimit; ){
			int color = a.get(i);
			if ( color == 0){
				int temp = a.get(zeroLimit);
				a.set(zeroLimit,0);
				a.set(i,temp);
				zeroLimit++;
				i++;
			}
			else if ( color == 2){
				int temp = a.get(twoLimit);
				a.set(twoLimit,2);
				a.set(i,temp);
				twoLimit--;
			}
			else i++;
		}
	}
}
