package interviewBit;

import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : [1, 2, 3]
A height balanced BST  : 

      2
    /   \
   1     3
   
 * @author mrincodi
 * 2016-10-03
 * Comment: A simple, yet very important, problem.
 *
 */
public class SortedArrayToBalancedBST {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
		public TreeNode sortedArrayToBST(final List<Integer> a) {
		    //Recursive.
		    if ( a == null || a.size() == 0 ) return null;
		    return sortedArrayToBST (a, 0, a.size() - 1);
		}
		
		private TreeNode sortedArrayToBST(final List<Integer> a, int indexLeft, int indexRight) {
	        if ( indexLeft > indexRight ) return null;
	        int pos = (indexLeft + indexRight) / 2;
	        TreeNode result = new TreeNode (a.get(pos));
	        if ( indexLeft == indexRight ) return result;

	        result.left = sortedArrayToBST (a,indexLeft,pos -1);
	        result.right = sortedArrayToBST (a,pos + 1, indexRight);
	        return result;
		}
		

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
