package algorithmsAgain;

import java.util.Arrays;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a 
 * given stock on day i.

Design an algorithm to find the maximum profit. You may complete as 
many transactions as you like (ie, buy one and sell one share of the 
stock multiple times). However, you may not engage in multiple 
transactions at the same time (ie, you must sell the stock before 
you buy again).

Example :

Input : [1 2 3]
Return : 2

 * @author mrincodi
 * 2016-08-12
 * Comment: works. Note to self: It doesn't need to be recursive always.
 * Even less when I am using something like an array for DP.
 */
public class BestTimeToBuyAndSellStocks2 {

	public int maxProfit(final List<Integer> a) {
		if ( a == null || a.size()==0) return 0;
		int [] bestBuying=new int [ a.size() ]; //Best profits from each position if I have to buy.
		int [] bestSelling=new int [ a.size() ]; //Best profits from each position if I have to sell.

		//Set the final values of the array.
		bestSelling[a.size()-1] = a.get(a.size()-1);

		for ( int pos = a.size()-2; pos >=0; pos-- ){
			bestBuying[pos] = Math.max (bestSelling[pos+1]-a.get(pos),
					bestBuying[pos+1]);
			bestSelling[pos] = Math.max(bestBuying[pos+1]+a.get(pos),
					bestSelling[pos+1]);
		}

		return bestBuying [0];
	}
	
	public static void main ( String [] args ){
		java.util.ArrayList <Integer> a = new java.util.ArrayList <Integer> (Arrays.asList(7,8,40));
		int best = new BestTimeToBuyAndSellStocks2().maxProfit(a);
		System.out.println(best);
		
	}
}

