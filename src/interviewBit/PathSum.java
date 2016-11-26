package interviewBit;
/**
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 * @author mrincodi
 * 2016-10-18
 * Comment: Eazzzzzy.
 */
public class PathSum {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public int hasPathSum(TreeNode a, int b) {
		if ( a == null ) return 0;  // Or perhaps 1, if an empty tree is considered to have total sum "0".
		if ( a.left == null && a.right == null && a.val == b) return 1;
		if ( hasPathSum (a.left,  b - a.val) == 1 ) return 1;
		if ( hasPathSum (a.right, b - a.val) == 1 ) return 1;
		return 0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
