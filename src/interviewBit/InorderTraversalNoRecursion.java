package interviewBit;

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
 * Comment: Not as simple as it seems! I used a hashset to keep track
 * of the nodes already visited!
 * 
 */
public class InorderTraversalNoRecursion {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode a) {

		ArrayList<Integer> result = new ArrayList<Integer> ();

		HashSet <TreeNode> hs = new HashSet <TreeNode> ();

		if (a == null) return result;

		Stack < TreeNode > s = new Stack <TreeNode > ();


		TreeNode b = a;

		s.push (b);

		while (! s.isEmpty ()){
			b = s.peek();

			//Check the position to the left.
			if ( b.left != null && !hs.contains (b.left)){
				s.push(b.left);
			}
			else if (!hs.contains (b)){
				hs.add(b);
				result.add(b.val);
			}
			else if (b.right != null && !hs.contains (b.right)){
				s.push( b.right );
			}
			else
				s.pop();
		}

		return result; 


	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
