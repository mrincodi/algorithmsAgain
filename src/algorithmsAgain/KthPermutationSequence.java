package algorithmsAgain;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"

 Good questions to ask the interviewer :
What if n is greater than 10. How should multiple digit numbers be represented in string?
> In this case, just concatenate the number to the answer.
> so if n = 11, k = 1, ans = "1234567891011"
Whats the maximum value of n and k?
> In this case, k will be a positive integer thats less than INT_MAX.
> n is reasonable enough to make sure the answer does not bloat up a lot.

 * @author mrincodi
 * A very difficult problem indeed!
 * This answer passed the correctness test but it would produce 
 * a division by 0 when calculating time complexity.
 */
public class KthPermutationSequence {



	public String getPermutation(int n, int k) {

		ArrayList <Integer> al = new ArrayList <Integer> ();
		return getPermutation (n, k-1, al);
	}

	public String getPermutation(int n, int k, ArrayList <Integer> al) {

		if ( n == 1 ){
			//Get the number in al that is not there.
			Collections.sort(al);
			for ( int i = 1; i <= al.size();i++){
				if (!al.contains(i)) return i+"";
			};
			int qq = al.size()+1;
			return qq + "";
		}

		//Calculate this digit.
		int thisDigitRaw = (k/factorial(n-1))+1;

		int thisDigit=thisDigitRaw;
		
		int left = thisDigit;
		int i=1;
		while ( left > 0 ){
			if ( al.contains(i)){
				thisDigit++;
			}
			else{
				left--;
			}
			i++;
		}

		//Calculate k for the next element.
		int nextK = k - ( (thisDigitRaw - 1) * factorial(n-1) );

		//Now, calculate the following elements.
		al.add(thisDigit);
		return thisDigit + getPermutation(n-1,nextK, al);

	}

	public int factorial (int n ){
		if (n <=1) return 1;
		return n*factorial (n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String qq = new KthPermutationSequence ().getPermutation (12, 44);
		System.out.println(qq);

	}

}
