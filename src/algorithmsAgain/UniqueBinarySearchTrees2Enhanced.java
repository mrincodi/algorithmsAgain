package algorithmsAgain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Unique Binary Search Trees IIBookmark Suggest Edit
Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

Example :

Given A = 3, there are a total of 5 unique BST’s.


   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * @author mrincodi
 * 2016-08-24
 * Comment: Wow! It worked with just the numbers!
 */
public class UniqueBinarySearchTrees2Enhanced {

	HashMap < Integer, Integer> ArraysToNumTrees = new HashMap < Integer, Integer>  ();
	
	public int numTrees (int a) {
		//TODO: What if a is "big". When does it overflow?
		int result = 0;
		if ( a <= 1 ) return 1;
		
		if ( ArraysToNumTrees.containsKey(a)) return ArraysToNumTrees.get(a);

		for ( int i = 1; i<=a;i++){
			result += numTrees (i-1) * numTrees (a - i );
		}
		ArraysToNumTrees.put(a, result);
		return result;
	}
	
	public static void main ( String [] args ){
		int a = 10;
		int nt = new UniqueBinarySearchTrees2Enhanced().numTrees(a);
		System.out.println(nt);
	}
}
