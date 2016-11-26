package interviewBit;
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
 * Comment: My first approach, with an array of HashTables, and recursion.
 *
 */
public class CoinSumInfiniteFirstApproach {

	    ArrayList < HashMap <Integer, Integer > > prevCalculations = new ArrayList < HashMap <Integer, Integer > >();

	    public int coinchange2(ArrayList<Integer> coins, int value) {
	        for ( int i = 0; i < coins.size() ; i++ ){
	            prevCalculations.add(new HashMap <Integer, Integer >());
	        }
	        return coinchange2 (coins, value, 0);
	    }
	    
	    private int coinchange2(ArrayList<Integer> coins, int value, int index) {

	        int result = 0;
	        if ( index >= coins.size() ) return 0;

	        if ( prevCalculations.get(index).containsKey(value)){
//	        	System.out.println ( "Hey! " + index + " " + value);
	            return prevCalculations.get(index).get(value);
	        }
	            
	        int num = coins.get( index );
	        
	        int thisCoinSum = 0;
	        while (thisCoinSum < value ){
	            result = ( result + coinchange2(coins, value - thisCoinSum, index + 1)) % 1000007;
	            thisCoinSum += num;
	        }
	        if ( thisCoinSum == value ) result = (result + 1)%1000007;
	        
	        prevCalculations.get(index).put(value, result);
	        return result;
	    }

	public static void main(String[] args) {
		Integer [] array = { 1,5,10,25 };
		ArrayList <Integer> coins = new ArrayList <Integer> (Arrays.asList(array));
		int value = 10000;
		int ways = new CoinSumInfiniteFirstApproach().coinchange2(coins, value);
		System.out.println(ways);
	}

}
