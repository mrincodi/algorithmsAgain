package algorithmsAgain;

/**
 * Given a binary tree, invert the binary tree and return it. 
Look at the example for more details.

Example : 
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7
invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4
 * @author mrincodi
 * 2016-08-08
 * Comment: Easiest one.
 */
public class InvertTree {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public TreeNode invertTree(TreeNode root) {
	        
	        TreeNode result = root;
	        if (root==null ) return null;
	        
	        TreeNode temp = root.left;
	        root.left = root.right;
	        root.right = temp;
	        
	        invertTree (root.left);
	        invertTree (root.right);
	        
	        return result;
	    }
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
