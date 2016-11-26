package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A suboptimal solution of the knapsack problem (with recursion). Just for practicing.
 * @author mrincodi
 *
 */
public class KnapsackRecursive {


	public int knapsack ( int maxWeight, ArrayList <Integer> weights, ArrayList <Integer> values, int currentItem){
		
		if ( maxWeight == 0 )     return 0;
		if (currentItem == 0)  return 0;

		int thisWeight = weights.get(currentItem);
		int thisValue  = values.get(currentItem);

		int bestValueWithoutMe = knapsack (maxWeight, weights, values, currentItem-1);
		
		if ( thisWeight > maxWeight ) return bestValueWithoutMe;

		int bestValueWithMe = thisValue + knapsack (maxWeight - thisWeight, weights, values, currentItem-1);

		
		return Math.max(bestValueWithoutMe, bestValueWithMe);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Integer> weights = new ArrayList <Integer > (Arrays.asList(5,4,6,3));
		ArrayList <Integer> values  = new ArrayList <Integer > (Arrays.asList(10,40,30,50));
		int maxWeight=10;
		
		int result = new KnapsackRecursive().knapsack(maxWeight, weights, values, weights.size()-1);

		System.out.println(result);
	}

}
