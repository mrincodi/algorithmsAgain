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
 * Comment: This is a non-recursive approach (I never thought of a recursive one
 * anyways), optimized with our good old friend TreeMap. It's not intuitive, but
 * this is the idea: go one by one on the preorder positions. For each one:
 * - Look for the value in inorder (x).
 * - Look for the next value in inorder that has already been processed.
 * - If found, check if the left child of the node is occupied or not.
 * - If not, that is the position for x.
 * - If it is, look for the next processed value in inorder.
 * - If no more values, then do the same process in inorder, but now going to the left,
 *   and assigning to the right child if a processed node with the right child free 
 *   is found (it should be).
 *   
 *   The recursive approach followed in interviewBit is much simpler.
 */
public class ConstructBinaryTreeFromInorderAndPreorder2 {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {

		if ( preorder.size () == 0 ) return null;

		HashMap <Integer, Integer> inorderPositions = new HashMap <Integer, Integer> ();

		for ( int i = 0; i < inorder.size(); i++){
			inorderPositions.put(inorder.get(i), i);
		}

		TreeNode result = new TreeNode (preorder.get(0));

		LinkedHashMap <Integer, TreeNode> processed = new LinkedHashMap <Integer, TreeNode> ();
		int rootNumber = preorder.get(0);
		processed.put(rootNumber, result);

		// This TreeMap helps us find the immediately larger or smaller processed position
		// given the position of a new number.
		TreeMap <Integer, Integer> inProcessed = new TreeMap <Integer, Integer> ();
		inProcessed.put(inorderPositions.get(rootNumber), rootNumber);

		for ( int i = 1; i < preorder.size(); i++){
			int number = preorder.get(i);

			//System.out.println("Buscando al " + number);

			//Look for it in inorder.
			int posOfNumberInInorder = inorderPositions.get(number);

			TreeNode newNode = new TreeNode (number);

			//Look what is the rightmost number already processed.
			boolean found=false;
			Integer ceilingPosition = inProcessed.ceilingKey(posOfNumberInInorder);
			while ( ceilingPosition != null && !found){
				int numberToTheRight = inProcessed.get(ceilingPosition);
				TreeNode possibleParent = processed.get(numberToTheRight);
				if ( possibleParent.left == null){
					possibleParent.left = newNode;
					found = true;
				}
				else{
					ceilingPosition = inProcessed.ceilingKey(ceilingPosition+1);
				}
			}

			//Look what is the leftmost number already processed.
			Integer floorPosition = inProcessed.floorKey(posOfNumberInInorder);
			while ( floorPosition != null && !found){
				int numberToTheLeft = inProcessed.get(floorPosition);
				TreeNode possibleParent = processed.get(numberToTheLeft);
				if ( possibleParent.right == null){
					possibleParent.right = newNode;
					found = true;
				}
				else{
					floorPosition = inProcessed.floorKey(floorPosition-1);
				}
			}

			inProcessed.put(inorderPositions.get(number),number);
			processed.put (number,newNode);

			if (!found)  System.out.println ( "Waaaaat???"); //This should not happen.
		}

		return result;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> preorder = new  ArrayList<Integer> (Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> inorder = new  ArrayList<Integer> (Arrays.asList(3,2,4,1,5));

		TreeNode t = new ConstructBinaryTreeFromInorderAndPreorder2().buildTree(preorder, inorder);

	}

}
