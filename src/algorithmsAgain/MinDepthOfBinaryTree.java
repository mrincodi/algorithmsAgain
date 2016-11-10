package algorithmsAgain;

/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
min depth = 2.
 * @author mrincodi
 * 2016-10-24
 * Comment: Easy, but it's important to consider the case in which the node 
 * has only one child.
 *
 */
public class MinDepthOfBinaryTree {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public int minDepth(TreeNode a) {
		if ( a == null ) return 0;
		if ( a.left == null && a.right != null) return minDepth (a.right) + 1;
		if ( a.left != null && a.right == null) return minDepth (a.left) + 1;
		return Math.min (minDepth(a.left), minDepth(a.right)) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
