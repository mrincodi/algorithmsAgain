package algorithmsAgain;

import java.util.ArrayList;

/**
 * Given an inorder traversal of a cartesian tree, construct the tree.

 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree. 
 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : [1 2 3]

Return :   
          3
         /
        2
       /
      1
 * @author mrincodi
 * 2016-08-08
 * Comment: Another easy one.
 */
public class InorderTraversalOfCartesianTree {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode buildTree(ArrayList<Integer> a) {

		if ( a == null || a.size () == 0) return null;

		// Find the largest one.
		int i = 0;

		TreeNode largest = null;
		int posLargest = -1;

		while (i < a.size ()){
			if (largest == null || a.get(i) > largest.val){
				largest = new TreeNode(a.get(i));
				posLargest=i;
			} 
			i++;
		}

		//System.out.println ( "Y posLargest es " + posLargest);
		// Get the subArray with the elements to the left of a.
		ArrayList<Integer> leftArray  = new ArrayList<Integer> (a.subList (0, posLargest));   
		ArrayList<Integer> rightArray = new ArrayList<Integer> (a.subList (posLargest + 1, a.size()));   

		TreeNode leftTree = buildTree  (leftArray);
		TreeNode rightTree = buildTree (rightArray);

		largest.left  = leftTree;
		largest.right = rightTree;

		return largest;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
