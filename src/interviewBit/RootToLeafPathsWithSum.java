package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]

 * @author mrincodi
 * 2016-10-22
 * Comment: Elementary. If InterviewBit had told me that all the nodes had non-negative
 * integers only, it would have been faster.
 */
public class RootToLeafPathsWithSum {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();

		if ( root == null ) return result;

		if ( root.left == null && root.right == null && root.val == sum){
			result.add ( new ArrayList<Integer> (Arrays.asList(root.val)));
			return result;
		}

		if ( root.left != null ){
			result = pathSum(root.left, sum - root.val);
		}

		if ( root.right != null ){
			result.addAll(pathSum(root.right, sum - root.val));
		}

		for ( ArrayList<Integer> path: result){
			path.add(0,root.val);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
