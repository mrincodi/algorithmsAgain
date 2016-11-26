package interviewBit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.
 * @author mrincodi
 * 2016-10-16
 * Comment: BFS! I like it better.
 */
public class LevelOrderBFS {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		if ( a == null ) return result;
		Queue <TreeNode> q = new LinkedList <TreeNode> ();
		q.add(a);
		q.add(null);
		
		ArrayList<Integer> resultEntry = new ArrayList<Integer> ();

		while (!q.isEmpty()){
			TreeNode node = q.remove();
			if (node != null){
				resultEntry.add(node.val);
				if ( node.left != null) q.add(node.left);
				if ( node.right != null) q.add(node.right);
			}
			else{
				if ( resultEntry.size() != 0){
					result.add(resultEntry);
					q.add(null);
					resultEntry = new ArrayList<Integer> ();
				}
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode (5);
		t.left = new TreeNode (6);
		t.right = new TreeNode (7);
		t.left.left = new TreeNode (8);
		t.left.right = new TreeNode (9);
		t.right.right = new TreeNode (10);

		 ArrayList<ArrayList<Integer>> r = new LevelOrderBFS().levelOrder(t);

		 for ( ArrayList <Integer> a : r){
			 System.out.println(a);
		 }
	}

}
