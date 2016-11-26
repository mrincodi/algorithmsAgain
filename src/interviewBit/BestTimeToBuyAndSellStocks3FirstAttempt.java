package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 1 2]
Output : 2

Explanation : 
  Day 1 : Buy 
  Day 2 : Sell
  Day 3 : Buy
  Day 4 : Sell
 * @author mrincodi
 * 2016-10-09
 * Comment: My first attempt, O(n^2).
 *
 */
public class BestTimeToBuyAndSellStocks3FirstAttempt {
	public int maxProfit(final List<Integer> a) {
	    if (a.size() <=1 ) return 0;
	    int maxProfit = maxProfit (a, 0, a.size() - 1);
	    int end = a.size() - 1;
	    for ( int i = 0; i <= end - 1; i++){
	        int profit = maxProfit (a, 0, i) + maxProfit (a, i+1, end);
	        maxProfit = Math.max (profit, maxProfit);
	    }
	    return maxProfit;
	}
    
    private int maxProfit (final List<Integer> a, int start, int end){
        if ( start == end ) return 0;
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for ( int i = start; i <= end; i++){
            int val = a.get(i);
            min = Math.min (min, val);
            int profit = val - min;
            maxProfit = Math.max (maxProfit, profit);
        }
        return maxProfit;

	}
	
	public static void main(String args[]){
		//Integer price[] = {2, 30, 15, 10, 8, 25, 80};
		Integer price[] = {1,7,9,2,1,4,6,2,3};
		//1,7,9,2,1,4,6,2,3
		ArrayList<Integer> priceAL = new ArrayList<Integer>(Arrays.asList(price));
		int n = price.length;
		System.out.println("Maximum Profit = "+ new BestTimeToBuyAndSellStocks3FirstAttempt().maxProfit(priceAL));

	}/* This code is contributed by Rajat Mishra */


}
