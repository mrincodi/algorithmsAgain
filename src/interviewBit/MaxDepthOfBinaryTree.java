package interviewBit;

/**
 * 
 * Given a binary tree, find its maximum depth.

The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
max depth = 2.

 * @author mrincodi
 * 2016-08-09
 * Comment: Solution was even shorter than interviewBit's one!
 */
public class MaxDepthOfBinaryTree {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public int maxDepth(TreeNode a) {
		if (a == null) return 0;
		else
			return 1 + Math.max (maxDepth (a.left), maxDepth (a.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
