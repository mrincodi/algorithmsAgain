package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;



public class ConstructBinaryTreeFromInorderAndPreorder1 {

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
		processed.put(preorder.get(0), result);

		for ( int i = 1; i < preorder.size(); i++){
			int number = preorder.get(i);

			//System.out.println("Buscando al " + number);

			//Look for it in inorder.
			int posOfNumberInInorder = inorderPositions.get(number);

			TreeNode newNode = new TreeNode (number);

			//Look what is the rightmost number already processed.
			boolean found=false;
			for ( int j = posOfNumberInInorder + 1; j < inorder.size() && !found; j++){
				int numberToTheRight = inorder.get(j);
				if ( processed.containsKey(numberToTheRight)){
					TreeNode possibleParent = processed.get(numberToTheRight);
					if ( possibleParent.left == null){
						possibleParent.left = newNode;
						found = true;
					}
				}
			}

			for ( int j = posOfNumberInInorder - 1; j >= 0 && !found; j--){
				int numberToTheLeft = inorder.get(j);
				if ( processed.containsKey(numberToTheLeft)){
					TreeNode possibleParent = processed.get(numberToTheLeft);
					if ( possibleParent.right == null){
						possibleParent.right = newNode;
						found = true;
					}
				}
			}
			
			processed.put (number,newNode);

			if (!found)  System.out.println ( "Waaaaat???"); //This should not happen.
		}

		return result;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> preorder = new  ArrayList<Integer> (Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> inorder = new  ArrayList<Integer> (Arrays.asList(3,2,4,1,5));
		
		TreeNode t = new ConstructBinaryTreeFromInorderAndPreorder1().buildTree(preorder, inorder);

	}

}
