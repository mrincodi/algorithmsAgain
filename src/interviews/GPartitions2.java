package interviews;

import java.util.HashMap;

/**
 * Given a non-negative number called "sum" and a number "partitions", 
 * in how many ways could I partition "partitions" non-negative numbers so their sum 
 * would add up to "sum"? Commutative sums are different (1+2+3 and 3+2+1 
 * are different ways of partitioning "6" with 3 partitions.

 * @author mrincodi
 * 2016-09-27
 * Comment: The "brute-force" (recursive) approach (greatly) enhanced with a HashMap.
 */
public class GPartitions2 {

	HashMap <String, Long> previousPartitions = new HashMap <String, Long>();
	long getNumberOfPartitions (int sum, int n){

		if ( n <= 1 ) return 1L;

		String thisPartition = sum + " " + n;
		
		if ( previousPartitions.containsKey(thisPartition) )
				return previousPartitions.get(thisPartition);
				
		long num = 0;
		for ( int i = 0; i<= sum; i++){
			num += getNumberOfPartitions(sum - i, n -1 );
		}
		
		previousPartitions.put(thisPartition, num);
		return num;
	}
	
	public static void main(String[] args) {

		int sum = 100;
		int n = 15;
		long num = new GPartitions2().getNumberOfPartitions(sum, n);
		System.out.println(num);
	}

}
