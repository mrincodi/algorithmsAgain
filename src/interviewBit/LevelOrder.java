package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

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
 * Comment: Done. Easy, and all too similar to G's interview question. Now, this
 * was inside Graphs, so I can totally use a queue for this, and our beloved
 * BFS.
 */
public class LevelOrder {


	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
		ArrayList<ArrayList<Integer>>result = new ArrayList<ArrayList<Integer>>();
		if (a==null) return result;

		ArrayList<TreeNode>level = new ArrayList<TreeNode>();
		level.add(a);
		result.add(new ArrayList<Integer>(Arrays.asList(a.val)));

		while (level.size()!=0){
			ArrayList<TreeNode>newLevel = new ArrayList<TreeNode>();
			for ( TreeNode t: level){
				if ( t.left != null) newLevel.add(t.left);
				if ( t.right != null) newLevel.add(t.right);
			}
			if (newLevel.size()!=0){
				ArrayList<Integer> resultEntry = new ArrayList<Integer>();
				for (TreeNode node:newLevel)
					resultEntry.add(node.val);

				result.add(resultEntry);
			}
			level=newLevel;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
