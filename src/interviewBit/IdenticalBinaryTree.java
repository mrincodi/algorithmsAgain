package interviewBit;

public class IdenticalBinaryTree {
	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	/**
	 * 
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 

   1       1
  / \     / \
 2   3   2   3

Output : 
  1 or True
	 * @param a
	 * @param b
	 * @return
	 * 
	 * 2016-08-23
	 * Comment: Fastest program ever! Be quick or be dead! :)
	 */
	public int isSameTree(TreeNode a, TreeNode b) {
		if ( a == null || b == null )
			if ( a != null || b != null ) return 0;
			else return 1;

		if ( a.val != b.val ) return 0;

		return (isSameTree ( a.left, b.left ) & isSameTree ( a.right, b.right )); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
