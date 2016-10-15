package algorithmsAgain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.

Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).

Example :

Input : 
	S = [1, 2, 3] 
	N = 4

Return : 4

Explanation : The 4 possible ways are
{1, 1, 1, 1}
{1, 1, 2}
{2, 2}
{1, 3}	
Note that the answer can overflow. So, give us the answer % 1000007
 * @author mrincodi
 * 2016-10-15
 * Comment: using a table really speeds thing up! This solution can be enhanced even 
 * more in terms of space, by using only one arrays. Use the previous value to calculate
 * the next one!
 *
 */
public class CoinSumInfinite {

	    public int coinchange2(ArrayList<Integer> coins, int value) {
	    	int result = 0;
	    	
	    	int [][] table = new int [coins.size()+1][value + 1];
	    	table[0][0]=1;
	    	
	    	for ( int row = 1; row <= coins.size(); row++){
	    		int coinIndex = row - 1;
	    		int coinValue = coins.get(coinIndex);
	    		for ( int col=0; col <= value; col++ ){
	    			int excluded = table [row-1][col];
	    			int included = 0;
	    			int restIfIncluded = col - coinValue;
	    			if ( restIfIncluded >= 0 ){
	    				included = table [ row ][ restIfIncluded ];
	    			}
	    			table [row][col]=(excluded + included)% 1000007;
	    		}
	    	}
	    	result = table[coins.size()][value];
	        return result;
	    }

	public static void main(String[] args) {
		Integer [] array = { 1,5,10,25 };
		ArrayList <Integer> coins = new ArrayList <Integer> (Arrays.asList(array));
		int value = 10000;
		int ways = new CoinSumInfinite().coinchange2(coins, value);
		System.out.println(ways);
	}

}
