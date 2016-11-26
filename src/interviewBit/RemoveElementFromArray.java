package interviewBit;

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
 * Comment: The 2-pointer solution that InterviewBit wanted.
 *
 */
public class RemoveElementFromArray {
	public int removeElement(ArrayList<Integer> a, int num) {

        int howMany=0;


        if ( a.size() == 0 ) return 0;
        int startPointer = 0, endPointer = 0;

        while ( endPointer < a.size() ){
            int number = a.get (endPointer);
            if ( number == num )
                endPointer++;
            else{
                a.set(startPointer, number);
                startPointer++;
                endPointer++;
                howMany++;
            }
        }
            
        return howMany;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
