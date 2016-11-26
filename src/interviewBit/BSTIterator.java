package interviewBit;

import java.util.ArrayList;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Try to optimize the additional space complexity apart from the amortized time complexity. 
 * @author mrincodi
 * 2016-08-21
 * 
 */
public class BSTIterator {


	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	ArrayList <Integer> nodeList;
	int currentNodeIndex;

	public BSTIterator(TreeNode root) {
		//Create an ArrayList with the InOrder ordering of the nodes.
		nodeList = inOrder (root);
		currentNodeIndex=0;
	}

	ArrayList <Integer> inOrder ( TreeNode tree ){

		//Complexity: O(n).

		ArrayList <Integer> result = new ArrayList <Integer>  ();
		if ( tree == null ) return result;
		result.addAll ( inOrder (tree.left ));
		result.add (tree.val);
		result.addAll ( inOrder (tree.right ));
		return result;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return ( currentNodeIndex < nodeList.size() );

	}

	/** @return the next smallest number */
	public int next() {
		if ( currentNodeIndex == nodeList.size() ) return -1; // TODO: Throw exception??

		int result = nodeList.get(currentNodeIndex);
		currentNodeIndex++;
		return result;
	}


	/**
	 * Your Solution will be called like this:
	 * Solution i = new Solution(root);
	 * while (i.hasNext()) System.out.print(i.next());
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
