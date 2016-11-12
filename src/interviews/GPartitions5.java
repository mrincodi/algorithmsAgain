package interviews;

import java.util.HashMap;

/**
 * Given a non-negative number called "sum" and a number "partitions", 
 * in how many ways could I partition "partitions" non-negative numbers so their sum 
 * would add up to "sum"? Commutative sums are different (1+2+3 and 3+2+1 
 * are different ways of partitioning "6" with 3 partitions.
 * 

 * @author mrincodi
 * 2016-09-27
 * Comment: The answer is Combinations(sum + partitions - 1, partitions - 1) = 
 * (s + p - 1)!/((s + p - 1 - p + 1)!(p - 1)!) =
 * (s + p - 1)!/(s!(p - 1)!)=
 * (s + 1)(s + 2)...(s + p - 1)/(1.2.3...(p - 1))
 * Sources:
 * http://math.stackexchange.com/questions/502724/how-many-weak-compositions-of-n-with-k-parts-up-to-reflection
 * Pseudo-demonstration:
 * http://www.math.ucsd.edu/~gptesler/184a/slides/184a_ch5slides_14-handout.pdf
 */
public class GPartitions5 {

	
	long getNumberOfPartitions (int sum, int part){

		if ( sum < 0 || part <= 0 ) return 1;

		long numerator = 1L;
		for (int i = sum + 1; i <= sum + part - 1;i++){
			numerator*=i;
		}
		
		long denominator = 1;
		for ( int i = 2; i <= part - 1; i++)
			denominator*=i;
		
		return numerator/denominator;
	}
	
	public static void main(String[] args) {

		int sum = 100;
		int n = 10;
		long num = new GPartitions5().getNumberOfPartitions(sum, n);
		System.out.println(num);
	}

}
