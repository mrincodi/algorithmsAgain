package algorithmsAgain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
/**
 * 
 * Given a binary tree, return the preorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

Using recursion is not allowed.

 * @author mrincodi
 * 2016-10-18
 * Comment: A very important problem. This is the right response.
 */
public class PreorderTraversal {
	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if ( a == null) return result;
		Stack <TreeNode> s = new Stack <TreeNode> ();
		s.push(a);
		while (!s.isEmpty()){
			TreeNode node = s.pop();
			result.add(node.val);
			if (node.right != null)s.push(node.right);// This was the trick. Right before left.
			if (node.left != null)s.push(node.left);
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
