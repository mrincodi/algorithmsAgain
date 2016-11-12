package interviews;

/**
 * Given a non-negative number called "sum" and a number "partitions", 
 * in how many ways could I partition "partitions" non-negative numbers so their sum 
 * would add up to "sum"? Commutative sums are different (1+2+3 and 3+2+1 
 * are different ways of partitioning "6" with 3 partitions.

 * @author mrincodi
 * 2016-09-27
 * Comment: Enhanced with a matrix m (partitions x sums). 
 * m (p, s) = SUM (i: from 0 to s) of (m(p-1,i)).
 * 
 */
public class GPartitions3 {

	
	long getNumberOfPartitions (int sum, int part){

		if ( sum < 0 || part <= 0 ) return 1;

		long [][] m  = new long [ part + 1][sum + 1];
		
		for ( int i = 0; i<= sum; i++)
			m[1][i]=1;
		
		for ( int i = 1; i<= part; i++)
			m[i][1]=1;
		
		for ( int thisPart = 2; thisPart <= part; thisPart++){
			for (int thisSum = 1; thisSum <= sum; thisSum++){
				for ( int i = 0; i <= thisSum; i++)
					m[thisPart][thisSum]+=m[thisPart-1][i];
			}
		}
		
		return m[part][sum];
	}
	
	public static void main(String[] args) {

		int sum = 100;
		int n = 10;
		long num = new GPartitions3().getNumberOfPartitions(sum, n);
		System.out.println(num);
	}

}
