package topcoder;
import java.math.BigInteger; 
import java.util.*; 

/**
 * 
 * Problem Statement
You are given a b containing a sequence of n positive integers: b[0], ..., b[n-1]. We are now looking for another sequence a = {a[0], ..., a[n-1]}. This sequence should have the following properties:
The elements of the sequence a should be distinct.
Each a[i] should be an integer greater than 1.
For each i, the value a[i]^b[i] (that is, a[i] to the power b[i]) should be divisible by p[i], where p[i] is the product of all other elements of a. (I.e. p[i] = a[0]*a[1]*...*a[i-1]*a[i+1]*...*a[n-1].)
Determine whether there is at least one sequence with the desired properties. Return "Possible" (quotes for clarity) if such a sequence exists and "Impossible" otherwise.
Definition
Class: DivisibleSetDiv1
Method: isPossible
Parameters: int[]
Returns: String
Method signature: String isPossible(int[] b)
(be sure your method is public)
Limits
Time limit (s): 2.000
Memory limit (MB): 256
Constraints
- b will contain between 2 and 50 elements, inclusive.
- Each element in b will be between 1 and 10, inclusive.
Examples
0)
{2,1}
Returns: "Possible"
Here, we have the following requirements:
The values a[0] and a[1] should be distinct positive integers, both greater than 1.
The value a[0]^2 should be divisible by a[1].
The value a[1]^1 should be divisible by a[0].
One sequence with the above properties is the sequence a = {2, 4}.
1)
{1,1}
Returns: "Impossible"
In this test case the requirements imply that a[0] must be divisible by a[1] and vice versa. This is possible only if a[0] = a[1]. However, the elements of a must be distinct, so there is no valid sequence.
2)
{7, 7, 7}
Returns: "Possible"
For example, a = {12, 54, 18}.
3)
{5,3,5,4,6,1,3,7,9,6,2,5,4,1,1,9,6,10,10,6,10,7,7,8}
Returns: "Impossible"
 * @author ?
 * from https://community.topcoder.com/stat?c=problem_solution&cr=22777715&rd=16776&pm=14362
 * Comment: ??? I don't have a clue!!
 *
 */
public class DivisibleSetDiv1 { 

	public String isPossible(int[] b) { 
		BigInteger denom = BigInteger.ONE; 
		for (int x : b) { 
			denom = denom.multiply(BigInteger.valueOf(x + 1)); 
		} 

		System.out.println("denom: " + denom);
		BigInteger num = BigInteger.ZERO; 
		for (int x : b) { 

			num = num.add(denom.divide(BigInteger.valueOf(x + 1))); 

		} 
		System.out.println("num: " + num);

		int cmp = num.compareTo(denom); 
		if (cmp > 0) { 
			return "Impossible"; 
		} 
		if (cmp < 0) { 
			return "Possible"; 
		} 

		for (int i = 0; i < b.length; i++) 
			for (int j = i + 1; j < b.length; j++) { 
				if (b[i] == b[j]) { 
					return "Impossible"; 
				} 
			} 

		return "Possible"; 
	} 


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] b = 	{7, 7, 7};

		String isIt = new DivisibleSetDiv1().isPossible(b);
		System.out.println(isIt);
	}

}
