package algorithmsAgain;

import java.util.ArrayList;

/**
 * 
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example :
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

If it is not possible to reach the end index, return -1.

 * @author mrincodi
 * 2016-09-19
 * Comment: The typical DP approach... But there is even a better DP approach!
 * 
 */
public class MinJumpsArrayON2 {
		public int jump(ArrayList<Integer> a) {
		    
		    if ( a == null || a.size() <= 1 ) return 0;
		    
		    int finalPos = a.size() - 1;
		    
		    int [] jumps = new int [ a.size() - 1 ];
		    
		    for ( int pos = jumps.length - 1; pos >= 0; pos--){
		        int maxJump = a.get(pos);
		        int minNumberOfJumps = 0;
		        
		        getMinJumps:
		        for ( int thisJump = maxJump; thisJump >= 1; thisJump--){
		            
		            if ( pos + thisJump > finalPos ) continue;
		            
		            if ( pos + thisJump == finalPos ){
	    	            minNumberOfJumps=1;
	    	            break getMinJumps;
		            }
		            
		            if ( jumps [ pos + thisJump ] != 0){
	                    if ( minNumberOfJumps != 0)	                
		                    minNumberOfJumps = Math.min ( minNumberOfJumps, jumps [ pos + thisJump ] + 1 );
	                    else
	                        minNumberOfJumps = jumps [ pos + thisJump ] + 1;
		            }
		        }
		        
		        jumps [ pos ] = minNumberOfJumps;
		        
		        
		    }
		    
		    return jumps[0]==0?-1:jumps[0];
		    
		}

}
