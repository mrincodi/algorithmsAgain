package algorithmsAgain;

import java.util.ArrayList;


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
 * Comment: Well, this is InterviewBit's solution. Kind of brute force-ish; nothing to
 * do with graphs.
 */
public class SteppingNumbersInterviewBit {
	
	public ArrayList<Integer> stepnum(int A, int B) {
	    int i;
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    for (i = A; i <= B; i++) {
	        if (validStepNum(i))
	            res.add(i);
	    }
	    
	    return res;
	    
	}
	
	private boolean validStepNum(int num) {
	    int last = num % 10;
	    int cur;
	    num /= 10;
	    
	    while (num > 0) {
	        cur = num % 10;
	        if (Math.abs(cur - last) == 1) {
	            last = cur;
	            num /= 10;
	        } else {
	            return false;
	        }
	    }
	    
	    return true;
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
