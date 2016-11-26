package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array   QuestionEditorial Solution  My Submissions
Total Accepted: 3648
Total Submissions: 5796
Difficulty: Easy
Contributors: yuhaowang001
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * @author mrincodi
 * 2016-11-21
 * Comment: I knew it already. Good one.
 * 
 *
 */
public class DisappearedNumbers {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if ( nums.length <= 1 ) return result;
		for ( int i = 0; i < nums.length; i++){
			if ( nums [ i ] == i + 1) continue;
			boolean keepOnIt = true;
			while ( keepOnIt ){
				if ( nums [ nums [ i ] - 1 ]  == nums [ i ]) keepOnIt = false;
				else{
					//Swap numbers.
					int temp = nums [ nums [ i ] - 1 ];
					nums [ nums [ i ] - 1 ] = nums [ i ];
					nums [ i ] = temp;
				}
			}
		}

		//Now, just go over the array.
		for ( int i = 0; i < nums.length; i++)
			if ( nums [ i ] != i + 1) result.add (i+1);

		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
