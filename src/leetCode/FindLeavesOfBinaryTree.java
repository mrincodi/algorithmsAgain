package leetCode;

import java.util.ArrayList;
import java.util.List;

import interviewBit.TreeNode;

/**
 * 
 * 
 * LeetCode – Find Leaves of Binary Tree (Java)
 
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree

          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].


 * @author mrincodi
 * 2016-12-12
 * Comment: Very cool program.
 * 
 */
public class FindLeavesOfBinaryTree {

	public List<List<Integer>> findLeaves(TreeNode root) {

		List<List<Integer>> result = new  ArrayList<List<Integer>>();
		 
		 helper ( result, root );
		
		return result;
	}
	
	
	private int helper ( List<List<Integer>>result, TreeNode root){
		
		if ( root == null ) return -1;
		
		int leftHeight = helper (result, root.left);
		int rightHeight = helper (result, root.right);
		int myHeight = Math.max(leftHeight, rightHeight) + 1;
		
		if ( result.size() == myHeight)
			result.add(new ArrayList <Integer>());
		
		result.get(myHeight).add(root.val);
		
		return myHeight;
		
	}
	
	public static void main ( String [] args ){

		TreeNode t = new TreeNode (7);
		t.left = new TreeNode (12);
		t.left.left = new TreeNode (4);
		t.left.right = new TreeNode (8);
		t.left.right.right = new TreeNode (22);
		t.right = new TreeNode (9);
		t.right.right = new TreeNode (6);
		t.right.right.left = new TreeNode (30);
		t.right.right.right = new TreeNode (13);
		t.right.right.right.left = new TreeNode (0);
		
		List<List<Integer>> groups = new FindLeavesOfBinaryTree().findLeaves(t);
		System.out.println(groups);
	}
}
