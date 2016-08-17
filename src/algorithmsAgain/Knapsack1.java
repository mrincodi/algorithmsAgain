package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A basic solution of the knapsack problem. Just for practicing.
 * @author mrincodi
 *
 */
public class Knapsack1 {


	public int knapsack ( int maxWeight, ArrayList <Integer> weights, ArrayList <Integer> values){
		
		int [] [] m = new int [weights.size()][maxWeight+1];
		
		for ( int numItemsHere = 0; numItemsHere < weights.size(); numItemsHere++){
			for ( int maxWeightHere = 0; maxWeightHere <= maxWeight; maxWeightHere++){
				if ( numItemsHere == 0 ) {
					m [ numItemsHere ][ maxWeightHere ] = 0;
					continue; //Because there is no capacity in the knapsack (0).
				}
				if ( maxWeightHere == 0 ) {
					m [ numItemsHere ][ maxWeightHere ] = 0; 
					continue; //Because there are no items.
				}
				
				//Take current weight for this item.
				int thisItemWeight = weights.get(numItemsHere);
				if ( thisItemWeight > maxWeightHere)
					m[numItemsHere][maxWeightHere]=m[numItemsHere-1][maxWeightHere];
				else {
					m[numItemsHere][maxWeightHere]=
							Math.max(
									m[numItemsHere-1][maxWeightHere],
									values.get(numItemsHere) + m[numItemsHere-1][maxWeightHere-weights.get(numItemsHere)]);					
				}				
			}
		}
		
		return m [ weights.size()-1][maxWeight];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Integer> weights = new ArrayList <Integer > (Arrays.asList(5,4,6,3));
		ArrayList <Integer> values  = new ArrayList <Integer > (Arrays.asList(10,40,30,50));
		int maxWeight=10;
		
		int result = new Knapsack1().knapsack(maxWeight, weights, values);

		System.out.println(result);
	}

}
