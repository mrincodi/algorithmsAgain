package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStocks3MR {
	public int maxProfit(final List<Integer> a) {

		// First, calculate best profit from i to n - 1.
		int n = a.size();
		if ( n <= 1 ) return 0;
		int [] profitRtoL = new int [n];
		int maxSoFar = a.get(n-1);
		for ( int i = n -2; i >=0 ;i--){
			int num = a.get(i);
			maxSoFar = Math.max(num, maxSoFar);
			int thisProfit = maxSoFar - num;
			profitRtoL [ i ] = Math.max(profitRtoL[i+1], thisProfit);
		}
		
		//Now, calculate the best profits from left to right!!
		
		if ( n <= 1 ) return 0;
		int [] profitLtoR = new int [n];
		int minSoFar = a.get(0);
		for ( int i = 1; i < n ;i++){
			int num = a.get(i);
			minSoFar = Math.min(num, minSoFar);
			int thisProfit = num - minSoFar;
			profitLtoR [ i ] = Math.max(profitLtoR[i-1], thisProfit);
		}
		
		//And now, le grand finale!
		int bestProfit = profitLtoR[n-1];
		for ( int i = 0; i<n-2; i++){
			int thisSum = profitLtoR[i]+profitRtoL[i+1];
			bestProfit=Math.max(bestProfit, thisSum);
		}
		
		return bestProfit;
	}
	
	public static void main(String args[]){
		//Integer price[] = {2, 30, 15, 10, 8, 25, 80};
		Integer price[] = {1,7,9,2,1,4,6,2,3};
		//1,7,9,2,1,4,6,2,3
		ArrayList<Integer> priceAL = new ArrayList<Integer>(Arrays.asList(price));
		int n = price.length;
		System.out.println("Maximum Profit = "+ new BestTimeToBuyAndSellStocks3MR().maxProfit(priceAL));

	}/* This code is contributed by Rajat Mishra */


}
