package interviewBit;

import java.util.Stack;

/**
 * 
 * 
Given a BST node, return the node which has value just greater than the given node.

Example:

Given the tree

               100
              /   \
            98    102
           /  \
         96    99
          \
           97
Given 97, you should return the node corresponding to 98 as thats the value just greater than 97 in the tree.
If there are no successor in the tree ( the value is the largest in the tree, return NULL).

Using recursion is not allowed.

Assume that the value is always present in the tree.

PROBLEM APPROACH:

Complete solution in the hint.

 * @author Mario
 * 2016-10-24
 * Comment: OK, this is not an obvious problem, but it's one of the ones that have to be understood and then "memorized".
 * Doing this with recursion is also interesting. And getting the _previous_ value should be interesting too!
 *
 */
public class NextGreaterNumberBST {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode getSuccessor(TreeNode A, int B) {

		Stack <TreeNode > s = new Stack <TreeNode>();

		if ( A == null ) return null;

		s.push (A);

		TreeNode pointer = A.left;

		while ( pointer != null ){
			s.push (pointer);
			pointer = pointer.left;
		}

		boolean getNext = false;

		while ( !s.isEmpty () ){
			pointer = s.pop();

			if ( getNext ) return pointer;

			if (pointer.val == B ){
				getNext =true;
			}

			if ( pointer.val > B )
				return null;

			if ( pointer.right != null ){
				pointer = pointer.right;
				s.push (pointer);
				pointer = pointer.left;

				while ( pointer != null ){
					s.push (pointer);
					pointer = pointer.left;
				}
			}
		}


		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
