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
 * Comment: The elementary approach. Requires 2 passes to the array.
 *
 */
public class SortByColor1 {

	public void sortColors(ArrayList<Integer> a) {
		int num0s = 0;
		int num1s = 0;
		int num2s = 0;

		for ( int color:a){
			switch (color){
			case 0:
				num0s++;
				break;

			case 1:
				num1s++;
				break;

			case 2:
				num2s++;
				break;

			default:
				break;
			}
		}

		for ( int i = 0;i < num0s; i++ ){
			a.set(i,0);
		}
		for ( int i = 0; i < num1s; i++ ){
			a.set(num0s + i,1);
		}
		for ( int i = 0; i < num2s; i++ ){
			a.set(num0s + num1s + i,2);
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
