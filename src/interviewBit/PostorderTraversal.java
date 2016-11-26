package interviewBit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * Given a binary tree, return the postorder traversal of its nodes’ values.

Example :

Given binary tree

   1
    \
     2
    /
   3
return [3,2,1].

Using recursion is not allowed.

 * @author mrincodi
 * 2016-10-19
 * Comment: I'm not going to lie: I had previously looked on how to solve 
 * this with two stacks (what both InterviewBit and I do here). The solution 
 * with one stack is not intuitive at all:
 * http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
 */
public class PostorderTraversal {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
		public ArrayList<Integer> postorderTraversal(TreeNode a) {
		    ArrayList<Integer> result = new ArrayList<Integer> ();
	        if ( a == null) return result;	    
		    
		    Stack <TreeNode> s = new Stack <TreeNode> ();
		    Stack <TreeNode> resp = new Stack <TreeNode>();
		    
		    s.push(a);
		    
		    while (!s.isEmpty ()){
		        TreeNode node = s.pop();
		        resp.push(node);
		        if (node.left != null) s.push (node.left);
		        if (node.right != null) s.push (node.right);
		    }
		    
		    while (!resp.isEmpty()){
		        result.add(resp.pop().val);
		    }
		    return result;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
