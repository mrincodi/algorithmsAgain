package topcoder;

import java.util.HashMap;

/**
 * 
 * Problem Statement
There is a card and at the beginning there is a number s on it, in each step you can do one of this operation:
Suppose the number on this card is x, change it into 2x+1.
Suppose the number on this card is x, change it into 3x+1.
Please compute and return the minimal number of operations to change the number of your card into t. If that is impossible, return -1.
Definition
Class: MultiplyXPlusOne
Method: minimalSteps
Parameters: int, int
Returns: int
Method signature: int minimalSteps(int s, int t)
(be sure your method is public)
Limits
Time limit (s): 2.000
Memory limit (MB): 256
Constraints
- s will be between 0 and 1,000,000, inclusive.
- t will be between 0 and 1,000,000, inclusive.
Examples
0)
1
22
Returns: 3
First we use operation 1, the number will become 2*1+1 = 3. Then we use operation 1 again, we get 3*2+1 = 7. Last we use operation 2, it will be 7*3+1 = 22.
1)
1
31
Returns: 3
Although we can get it by 1, 3, 7, 15, 31, we could use less steps by 1, 3, 10, 31.
2)
100
99
Returns: -1
We can't decrease the number, so it is impossible to get 99 from 100.
3)
55555
1000000
Returns: 3
4)
1
1
Returns: 0

 * @author mrincodi
 * 2016-08-27
 * Comment: Holy guacamole! An easy one!
 *
 */
public class MultiplyXPlusOne {
    HashMap <Integer, Integer> stepsHash = new HashMap <Integer, Integer> ();
    
	public int minimalSteps(int x, int y) {
        if ( x == 0 && y == 0 ) return 0;
        if ( x == 0 || y == 0 ) return -1;
        if ( (x>0 && y < 0 ) || ( x < 0 && y > 0 )) return -1;
        
        if ( y < x ) return -1;
        if ( y == x ) return 0;
        
        if ( stepsHash.containsKey ( x ) ) return stepsHash.get(x);
        
        int result = -1;
        int result2x = minimalSteps (2*x + 1, y);
        int result3x = minimalSteps (3*x + 1, y);
        
        if ( result2x == -1 && result3x == -1 ) result = -1;
        else if ( result2x == -1 ) result = result3x + 1;
        else if ( result3x == -1 ) result = result2x + 1;
        else result = Math.min (result2x, result3x) + 1;
            
        stepsHash.put (x,result);
        return result;
    }
}
    
        
        
        
        