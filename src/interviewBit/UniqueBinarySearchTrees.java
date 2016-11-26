package interviewBit;

import java.util.ArrayList;

/*8
 * 
 * Given A, generate all structurally unique BST’s (binary search trees) that store values 1...A.

Example : 
Given A = 3, your program should return all 5 unique BST’s shown below.


   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * 2016-10-07
 * Comment: Cool, but definitely could have been enhanced with maps.
 * 
 */
public class UniqueBinarySearchTrees {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	//TODO: Enhance with a HashMap, for known subtrees.
	public ArrayList<TreeNode> generateTrees(int a) {
		if (a <= 0 ) return null;

		return generateTrees(1, a);
	}

	private ArrayList<TreeNode> generateTrees(int left, int right) {

		ArrayList<TreeNode> result = new ArrayList<TreeNode> ();

		if (left > right ) {
			result.add(null);
			return result;
		}

		if ( left == right ){
			result.add ( new TreeNode (left));
			return result;
		}

		for ( int i = left; i <= right; i++){
			ArrayList<TreeNode> leftSubsets = generateTrees (left, i-1);
			ArrayList<TreeNode> rightSubsets = generateTrees (i+1, right);

			//Now, create the trees!
			for ( TreeNode leftTree:leftSubsets ){
				for ( TreeNode rightTree:rightSubsets ){
					TreeNode thisTree = new TreeNode (i);
					thisTree.left = leftTree;
					thisTree.right = rightTree;
					result.add (thisTree);
				}
			}
		} 
		return result;
	}



	public static void main(String[] args) {
		int n = 3;
		ArrayList<TreeNode> trees = new UniqueBinarySearchTrees().generateTrees(n);
		System.out.println("the end");
	}

}
