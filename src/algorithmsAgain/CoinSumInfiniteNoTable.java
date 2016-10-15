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
 * Comment: using only one array! Beautiful!
 *
 */
public class CoinSumInfiniteNoTable {

	public int coinchange2(ArrayList<Integer> coins, int value) {

		int [] coinsInfo = new int [value+1];
		coinsInfo[0]=1;

		for ( int coinIndex = 0; coinIndex < coins.size(); coinIndex++ ){
			int coinVal = coins.get(coinIndex);
			for ( int i = coinVal;i<=value;i++){
				coinsInfo[i]=(coinsInfo[i]+coinsInfo[i-coinVal])%1000007;
			}
		}
		return coinsInfo[value];
	}

	public static void main(String[] args) {
		Integer [] array = { 1,5,10,25 };
		ArrayList <Integer> coins = new ArrayList <Integer> (Arrays.asList(array));
		//for ( int value = 1; value <= 10000; value ++){
		int value = 10000;
		int ways = new CoinSumInfiniteNoTable().coinchange2(coins, value);
		System.out.println(value + ":" + ways);
		//}
	}
}
