package interviewBit;

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
 * Comment: A very important problem, and not easy... until you see 
 * InterviewBit's solution and realize how easy it actually is. My 
 * solution works and passes, but uses a hashSet and is a bit convoluted.
 */
public class PreorderTraversalWithHashSet {

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
	    
	    	HashSet <TreeNode> inResult = new HashSet <TreeNode> ();
	    
	    	s.push(a);
	    
	    	while (!s.isEmpty ()){
	    		TreeNode node = s.peek();
	    		if (!inResult.contains(node)){
	    			inResult.add(node);
	    			result.add(node.val);
	    			if ( node.left != null ) s.push (node.left);
	    			else if ( node.right != null ) s.push (node.right);
	    			else s.pop();
	    		}
	    		else {
	    			if ( node.right == null ) s.pop();
	    			else {
	    				if (inResult.contains(node.right)) s.pop();
	    				else s.push(node.right);
	    			}
	    		}
	    	}
	    	return result;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
