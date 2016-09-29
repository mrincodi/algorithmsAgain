package algorithmsAgain;

import java.util.ArrayList;

/**
 * 
 * Remove Element

Given an array and a value, remove all the instances of that value in the array. 
Also return the number of elements left in the array after the operation.
It does not matter what is left beyond the expected length.

 Example:
If array A is [4, 1, 1, 2, 1, 3]
and value elem is 1, 
then new length is 3, and A is now [4, 2, 3] 
Try to do it in less than linear additional space complexity.

 * @author mrincodi
 * 2016-09-29
 * Comment: The obvious solution; takes too long for InterviewBit.
 *
 */
public class RemoveElementFromArray1 {



	public int removeElement(ArrayList<Integer> a, int num) {

		if ( a.size() == 0 ) return 0;

		boolean finish = false;
		int i = 0;
		while ( !finish){
			int thisNum = a.get(i);
			if (thisNum == num){
				a.remove(i);
			}
			else i++;

			if (i == a.size()) finish=true;
		}

		return i;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
