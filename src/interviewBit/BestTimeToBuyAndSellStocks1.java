package interviewBit;

import java.util.List;

/**
 * 
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example :

Input : [1 2]
Return :  1
 * @author mrincodi
 * 2016-10-09
 * Comment: None.
 *
 */
public class BestTimeToBuyAndSellStocks1 {

	public int maxProfit(final List<Integer> a) {
	    if (a.size() == 0 ) return 0;
	    int minSoFar = Integer.MAX_VALUE;
	    int maxProfitSoFar = 0;
	    
	    for ( int i = 0; i < a.size(); i++ ){
	        int val = a.get(i);
	        minSoFar = Math.min (minSoFar, val);
	        int profit = val - minSoFar;
	        maxProfitSoFar = Math.max (maxProfitSoFar, profit);
	    }
	    
	    return maxProfitSoFar;
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
