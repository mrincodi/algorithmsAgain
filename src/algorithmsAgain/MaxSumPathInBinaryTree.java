package algorithmsAgain;

/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

       1
      / \
     2   3
Return 6.

 * @author Mario
 * 2016-08-012
 * Comment: Beautiful problem! I am only using a global variable for the sum. 
 * InterviewBit's solution creates a whole parallel tree.
 */
public class MaxSumPathInBinaryTree {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	int bestPathSum = 0;
	public int maxPathSum(TreeNode a) {
		if ( a == null ) return 0;
		bestPathSum=a.val;
		getBestStrings (a);

		return bestPathSum;
	}

	int getBestStrings (TreeNode a){
		if ( a == null ) return 0;

		int result = a.val;

		if ( a.left == null && a.right == null ){
			bestPathSum = Math.max ( a.val, bestPathSum);
			return a.val;
		}
		if (a.right == null){
			result = Math.max (a.val, a.val + getBestStrings (a.left));
			bestPathSum = Math.max ( result, bestPathSum);
			return result;
		}
		if (a.left == null){
			result = Math.max (a.val, a.val + getBestStrings (a.right));
			bestPathSum = Math.max ( result, bestPathSum);
			return result;
		}
		int sumLeft = getBestStrings (a.left);
		int sumRight = getBestStrings (a.right);

		result = Math.max (
				Math.max (a.val, a.val + sumLeft),
				a.val + sumRight);

		int bestPathWithMe = Math.max ( result, a.val + sumLeft + sumRight );

		bestPathSum = Math.max ( bestPathWithMe, bestPathSum);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
