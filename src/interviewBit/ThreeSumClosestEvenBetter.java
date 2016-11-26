package interviewBit;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

Example: 
given array S = {-1 2 1 -4}, 
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

 */
import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumClosestEvenBetter {


	public int threeSumClosest(ArrayList<Integer> A, int B) {
	    int low, high, mid;
	    Collections.sort(A);
	    int n = A.size();
	    int res = A.get(0) + A.get(1) + A.get(2);
	    
	    if (n == 3) {
	        return res;
	    }
	    
	    int sum;
	    
	    
	    
	    for (low = 0; low < n - 2; low++) {
	        mid = low + 1;
	        high = n - 1;
	        int num = B - A.get(low);
	        
	        while (mid < high) {
	            
	            sum = A.get(mid) + A.get(high);
	            
	            if (sum == num)
	                return B;
	            else if (sum < num) {
	                mid++;
	            } else {
	                high--;
	            }
	            
	            int diff = Math.abs(sum - num);
	            int otherDiff = Math.abs(res - B);
	            
	            if (diff < otherDiff)
	                res = sum + A.get(low);
	            
	        }
	        
	    }
	    
	    
	    return res;
	    
	    
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
