package interviewBit;

/**
 * Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST 

 * @author mrincodi
 * 2016-08-08
 * Comment: Seems many of these tree problems are solved 
 * with lots of recursions and global variables.
 */
public class KthSmallestElementInTree {

	/*
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */


	int count;
	boolean found;
	int valueFound;

	public int kthsmallest(TreeNode root, int k) {
		inOrder (root, k);
		return valueFound;
	}

	public void inOrder (TreeNode root, int k) {
		if (root==null) return;

		if ( found ) return;

		inOrder (root.left, k);

		if ( found ) return;

		count++;

		if ( count == k ){
			found = true;
			valueFound = root.val;
			return;
		}

		inOrder (root.right, k);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
