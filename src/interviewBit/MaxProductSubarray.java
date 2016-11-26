package interviewBit;

import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
Return an integer corresponding to the maximum product possible.

Example :

Input : [2, 3, -2, 4]
Return : 6 

Possible with [2, 3]

 * @author mrincodi
 * 2016-08-09
 * Comment: Difficult. Interesting to compare it against the max. subarray sum.
 * InterviewBit's solution is shorter, as they use "1" as the smallest value for 
 * maxWithPreviousValuePositive and maxWithPreviousValueNegative.
 * 
 */
public class MaxProductSubarray {


	public int maxProduct(final List<Integer> a) {

		if (a.size()== 1 ) return a.get(0);

		int maxPositive =0, maxNegative=0;
		int maxWithPreviousValuePositive = 0, maxWithPreviousValueNegative = 0;

		if ( a.get(0) >= 0 ){
			maxPositive = a.get(0);
			maxWithPreviousValuePositive = maxPositive;
		}
		else{
			maxWithPreviousValueNegative = maxNegative;
		}

		for ( int i = 1; i< a.size(); i++){
			if ( a.get(i)==0 ){
				maxWithPreviousValuePositive=0;
				maxWithPreviousValueNegative=0;
			}
			if ( a.get(i)>0){
				if ( maxWithPreviousValuePositive == 0 ) 
					maxWithPreviousValuePositive = a.get(i);
				else 
					maxWithPreviousValuePositive*=a.get(i);

				maxWithPreviousValueNegative *= a.get(i);
			}
			else { //Negative number
				if ( maxWithPreviousValueNegative == 0 ){
					if ( maxWithPreviousValuePositive == 0 ){
						maxWithPreviousValueNegative=a.get(i);
					}
					else {
						maxWithPreviousValueNegative=maxWithPreviousValuePositive*a.get(i);
						maxWithPreviousValuePositive=0;
					}
				}
				else {
					maxWithPreviousValuePositive=maxWithPreviousValueNegative*a.get(i);
					maxWithPreviousValueNegative=a.get(i);
				}
			}

			maxPositive = Math.max (maxWithPreviousValuePositive, maxPositive );

		}    
		return maxPositive;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
