package interviewBit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * There are N coins (Assume N is even) in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins. Assume that you go first.

Write a program which computes the maximum amount of money you can win.

Example:

suppose that there are 4 coins which have value
1 2 3 4
now you are first so you pick 4
then in next term
next person picks 3 then
you pick 2 and
then next person picks 1
so total of your money is 4 + 2 = 6
next/opposite person will get 1 + 3 = 4
so maximum amount of value you can get is 6

 * @author mrincodi
 * Comment: This solution is right, if we don't consider the fact that player 2 is
 * also trying to maximize his profit.
 * The problem statement doesn't say this.
 */
public class CoinsInALine {

    HashMap<String,Integer> h = new HashMap<String,Integer>();

	public int maxcoin(ArrayList<Integer> a) {
	    if (a.size() == 0 ) return 0;
	    return maxcoin(0,a.size() -1, a);
	}
	
	public int maxcoin(int left, int right, ArrayList<Integer> a) {
	    
	    int val = 0;
	    String s = left +","+right;
	    if (h.containsKey(s)) return h.get(s);
	    
	    if (left == right) {
	        val= a.get(left);
	    }
	    
	    else if (left + 1 == right ){
	        val = Math.max(a.get(left),a.get(right));
	    }
	    else {
	        int val1 = a.get(left)  + maxcoin (left + 2, right, a);
    	    int val2 = a.get(left)  + maxcoin (left + 1, right - 1, a);
	        int val3 = a.get(right) + maxcoin (left + 1, right - 1, a);
	        int val4 = a.get(right) + maxcoin (left , right - 2, a);
	        
	        val = Math.max (val1, val2);
	        val = Math.max (val, val3);
	        val = Math.max (val, val4);
	        
	    }
	    
    	h.put(s,val);
	    return val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
