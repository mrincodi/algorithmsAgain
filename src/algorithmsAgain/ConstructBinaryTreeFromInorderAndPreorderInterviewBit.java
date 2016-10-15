package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;


/**
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input :
        Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

Return :
            1
           / \
          2   3
 * @author mrincodi
 * 2016-09-29
 * Comment: The recursive approach followed by interviewBit.
 */
public class ConstructBinaryTreeFromInorderAndPreorderInterviewBit {
	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	ArrayList<Integer> preorder, inorder;

	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {

		if (preorder == null || inorder == null || preorder.size() == 0 || inorder.size() == 0)
			return null;

		if (preorder.size() != inorder.size())
			return null;

		this.preorder = preorder;
		this.inorder = inorder;

		return rec(0, preorder.size() - 1, 0);

	}


	private TreeNode rec(int start, int end, int index) {

		if (start > end)
			return null;

		TreeNode root = new TreeNode(preorder.get(index));

		int i = start;

		for (; i <= end; i++) {
			if (inorder.get(i).intValue() == root.val)
				break;
		}

		root.left = rec(start, i - 1, index + 1);
		root.right = rec(i + 1, end, index + i - start + 1);

		return root;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> preorder = new  ArrayList<Integer> (Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> inorder = new  ArrayList<Integer> (Arrays.asList(3,2,4,1,5));

		TreeNode t = new ConstructBinaryTreeFromInorderAndPreorderInterviewBit().buildTree(preorder, inorder);

	}

}
