package algorithmsAgain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * 
 * Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

Using recursion is not allowed.

 * @author mrincodi
 * 2016-08-08
 * Comment: Weird... I don't understand it on a first glance.
 * 
 */
public class InorderTraversalNoRecursionInterviewBit {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	// Threaded binary tree Morris traversal
	public ArrayList<Integer> inorderTraversal(TreeNode A) {
		TreeNode current, node;
		ArrayList<Integer> res = new ArrayList<>();

		current = A;

		while (current != null) {

			if (current.left == null) {
				res.add(current.val);
				current = current.right;
			} else {

				node = current.left;
				while (node.right != null && !current.equals(node.right))
					node = node.right;

				if (node.right == null) {
					node.right = current;
					current = current.left;
				} else {
					current = node.right;
					node.right = null;
					res.add(current.val);
					current = current.right;
				}

			}

		}

		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
