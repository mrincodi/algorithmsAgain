package interviewBit;

import java.util.ArrayList;
import java.util.Collections;


/**
 * 
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.

 Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? 
Example :


Input : 
         1
        / \
       2   3

Output : 
       [1, 2]

Explanation : Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST     

 * @author mrincodi
 * 2016-12-01
 * Comment: No constant space (that would be Morris traversal). If you know that in-order must give you the right order, the answer is straightforward. 
 *
 */
public class RecoverBinarySearchTree {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public ArrayList<Integer> recoverTree(TreeNode a) {
		//First get the in-order
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> inOrder = getInOrder (a);
		ArrayList<Integer> extra = new ArrayList<Integer> (inOrder);
		Collections.sort(extra);

		for ( int i = 0; i< inOrder.size(); i++ ){

			if ( inOrder.get(i) != extra.get(i)){
				result.add(inOrder.get(i));
			}

		}
		Collections.sort (result);
		return result;
	}

	public ArrayList<Integer> getInOrder (TreeNode a){
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if ( a == null ) return result;

		result = getInOrder (a.left);
		result.add (a.val);
		result.addAll(getInOrder(a.right));

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
