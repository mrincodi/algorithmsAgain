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
 * Comment: Yeah, this one works, but I think I don't need a HashMap whose key are the
 * subarrays. I think with only the lengths of the arrays will suffice.  
 */
public class UniqueBinarySearchTrees2 {

	HashMap < ArrayList <Integer>, Integer> ArraysToNumTrees = new HashMap < ArrayList <Integer>, Integer>  ();
	
	public int numTrees (int a) {
		//TODO: What if a is "big". When does it overflow?
		if ( a < 0 ) return 0;
		ArrayList <Integer> numbers = new ArrayList < Integer > ();
		for ( int i = 1; i <= a; i++ )
			numbers.add (i);

		return numTrees (numbers);
	}

	private int numTrees ( ArrayList <Integer> numbers ){
		if ( ArraysToNumTrees.containsKey(numbers)) return ArraysToNumTrees.get(numbers);

		if ( numbers == null || numbers.size () == 0 )
			return 1;
		
		if (numbers.size() == 1 ) return 1;
		
		int result = 0;
		for ( int i = 0; i < numbers.size(); i++ ){
			ArrayList <Integer> smallerNumbers = new ArrayList <Integer> (numbers.subList (0,i));
			ArrayList <Integer> greaterNumbers;
			if ( i < numbers.size() - 1)
				greaterNumbers = new ArrayList <Integer> (numbers.subList (i+1,numbers.size()));
			else
				greaterNumbers = new ArrayList <Integer> ();


			int smallerResult = numTrees (smallerNumbers);
			int greaterResult = numTrees (greaterNumbers);

			result = result + ( smallerResult * greaterResult );
		}

		ArraysToNumTrees.put(numbers, result);
		return result;

	}
	
	public static void main ( String [] args ){
		int a = 10;
		int nt = new UniqueBinarySearchTrees2().numTrees(a);
		System.out.println(nt);
	}
}
