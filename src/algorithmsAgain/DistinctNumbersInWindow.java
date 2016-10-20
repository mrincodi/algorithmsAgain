package algorithmsAgain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * 
 * 
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:
- If K > N, return empty array.

For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].
 * @author mrincodi
 * 2016-10-19
 * Comment: Easy.
 *
 */
public class DistinctNumbersInWindow {

	    public ArrayList<Integer> dNums(ArrayList<Integer> numbers, int windowSize) {
	        HashMap <Integer, Integer> numberTimes = new HashMap <Integer, Integer> ();
	        ArrayList <Integer> result = new ArrayList <Integer> ();
	        
	        if (windowSize > numbers.size() ) return result;
	        
	        // Fill out the HashMap.
	        for ( int i = 0; i < windowSize; i++){
	            int num = numbers.get(i);
	            if ( numberTimes.containsKey (num) ) numberTimes.put(num, numberTimes.get(num)+1);  
	            else numberTimes.put(num, 1);
	        }

	        result.add (numberTimes.keySet().size());
	        
	        for ( int i = 1; i < numbers.size() - windowSize + 1; i++ ){
	            int prevNum = numbers.get(i-1);
	            numberTimes.put ( prevNum, numberTimes.get(prevNum)-1);
	            if (numberTimes.get(prevNum) == 0) numberTimes.remove(prevNum);
	            int num = numbers.get(i + windowSize - 1);
	            if ( numberTimes.containsKey (num) ) numberTimes.put(num, numberTimes.get(num)+1);  
	            else numberTimes.put(num, 1);
	            
	            result.add (numberTimes.keySet().size());
	        }
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
