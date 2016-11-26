package interviewBit;

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
 * Comment: works, but it breaks interviewBit 
 * because it's recursive. Make it non-recursive.
 */
public class BestTimeToBuyAndSellStocks2Recursive {
	int [] bestBuying;
	int [] bestSelling;

	public int maxProfit(final List<Integer> a) {
		if ( a == null || a.size()==0) return 0;
		bestBuying=new int [ a.size() ]; //Best profits from each position if I have to buy.
		bestSelling=new int [ a.size() ]; //Best profits from each position if I have to sell.

		return maxProfit (true,a,0);
	}

	int maxProfit(boolean canBuy, final List<Integer> a, int pos) {
		if (canBuy){
			if ( pos == a.size() -1 ) return 0; //Buying would be just losing money.
			if ( bestBuying[pos] == 0 ) 
				bestBuying[pos] = Math.max(maxProfit(false,a,pos+1)-a.get(pos),maxProfit(true,a,pos+1));
			return bestBuying[pos];
		}
		else {
			if ( pos == a.size() -1 ) return a.get(pos); //Selling is getting money!
			if ( bestSelling[pos] == 0 ) 
				bestSelling[pos] = Math.max(maxProfit(true,a,pos+1)+a.get(pos),maxProfit(false,a,pos+1));
			return bestSelling[pos];
		}
		//return 0;
	}

}
