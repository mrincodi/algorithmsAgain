package algorithmsAgain;

/**
 * Stock Buy Sell to Maximize Profit
The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.


We strongly recommend that you click here and practice it, before moving on to the solution.


If we are allowed to buy and sell only once, then we can use following algorithm. Maximum difference between two elements. Here we are allowed to buy and sell multiple times. Following is algorithm for this problem.
1. Find the local minima and store it as starting index. If not exists, return.
2. Find the local maxima. and store it as ending index. If we reach the end, set the end as ending index.
3. Update the solution (Increment count of buy sell pairs)
4. Repeat the above steps if end is not reached.
CJava

 * @author Mayank Jaiswal (mrincodi: I just copied-pasted this.)
 * 2016-10-04
 * Comment: Simpler than you think.
 * 
 */
public class StockBuySellMR {

	// This function finds the buy sell schedule for maximum profit
	void stockBuySell(int price[], int n){
		int i = 0;
		if ( price.length <= 1 ) {
			System.out.println("NO PROFIT");
			return;
		}

		while (  i < price.length - 1 ){
			//Get minimum
			while (  i < price.length - 1  && price[i+1] <= price [ i  ]) i++;


			if ( i == price.length - 1 ){
				System.out.println("NO PROFIT");
				return;
			}

			int minimumI = i;
			i++;

			//Now, get maximum.

			//Get maximum
			while ( i < price.length - 1 && price[i+1] >= price [ i ]) i++;

			int maximumI = i;

			System.out.println("Buy on day: " +  minimumI + "        " + "Sell on day : " + maximumI);

			i++;
		}

	}

	public static void main(String args[]) {
		StockBuySellMR stock = new StockBuySellMR();

		// stock prices on consecutive days
		int price[] = {100, 180, 260, 310, 40, 535, 695	};
		int n = price.length;

		// function call
		stock.stockBuySell(price, n);
	}
}
