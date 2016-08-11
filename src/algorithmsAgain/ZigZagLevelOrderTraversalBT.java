package algorithmsAgain;

import java.util.ArrayList;


/**
 * 
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example : 
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
]

 * @author mrincodi
 * 2016-08-09
 * Comment: InterviewBit's solution used stacks.
 */
public class ZigZagLevelOrderTraversalBT {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {

		return zigzagLevelOrder ( a, new ArrayList<ArrayList<Integer>> (), 1 );
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a, ArrayList<ArrayList<Integer>> als, int level ) {      

		if (a==null) return als;

		ArrayList<Integer> al = new ArrayList<Integer> ();

		if ( als.size() < level ) //Should be level - 1.
			als.add(al);
		else
			al=als.get(level-1);

		//Even levels go added backwards.
		if ( level %2 == 1 )
			al.add(a.val);
		else
			al.add(0,a.val);

		zigzagLevelOrder (a.left, als, level + 1);
		zigzagLevelOrder (a.right, als, level + 1);

		return als;	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
