package interviews;

import java.util.Arrays;

/**
 * Given a non-negative number called "sum" and a number "partitions", 
 * in how many ways could I partition "partitions" non-negative numbers so their sum 
 * would add up to "sum"? Commutative sums are different (1+2+3 and 3+2+1 
 * are different ways of partitioning "6" with 3 partitions.

 * @author mrincodi
 * 2016-09-27
 * Comment: Duh! A single array does the work! Amazing!!
 * 
 */
public class GPartitions4 {

	public long getNumberOfPartitions (int n, int p){
		if ( n < 1 || p < 1 ) return 0;
		
		long [] array = new long [ n + 1 ];

		Arrays.fill(array, 1);
		
			for (int partIndex = 2; partIndex <= p; partIndex++){
				for ( int numIndex = 1; numIndex <= n; numIndex++){

				array[numIndex]+=array[numIndex-1];
			}
		}
		return array[n];
	}
	
	public static void main(String[] args) {
		int sum = 100;
		int n = 10;
		long num = new GPartitions4().getNumberOfPartitions(sum, n);
		System.out.println(num);
	}

}
