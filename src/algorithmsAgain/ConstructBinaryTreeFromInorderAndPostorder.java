package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : 
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

Return : 
            1
           / \
          2   3
          
 * @author mrincodi
 * 2016-10-14
 * Comment: My very own recursive approach.
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorder {

    int posorderIndex = 0;
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {

        posorderIndex = inorder.size() - 1;
        return buildTree(inorder, postorder, 0, inorder.size() - 1 );    
	}
	
    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int inorderLeft, int inorderRight) {

        if ( inorderRight < inorderLeft ) return null;
        
        int num = postorder.get(posorderIndex);
        TreeNode result = new TreeNode (num);
        posorderIndex--;
        
        if ( inorderLeft == inorderRight ) return result;
        
        //Now, look for the position of the current node in the segment that was given.
        //Split the segment by calling buildTree for each segment.
        
        //TODO: This could be optimized, perhaps with a hashTree filled up before
        //starting this method.
        int numIndex = -1;
        for ( int i = inorderLeft; i <= inorderRight; i++){
            if ( inorder.get(i) == num ) numIndex = i;
        }
        if ( numIndex == -1) System.out.println ("What?"); //This should not happen.

        result.right =  buildTree ( inorder, postorder, numIndex + 1, inorderRight);
        result.left = buildTree ( inorder, postorder, inorderLeft, numIndex - 1);
        
        return result;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> inorder = new ArrayList<Integer> (Arrays.asList(4,2,5,1,6,3,7));
		
		ArrayList<Integer> postorder = new ArrayList<Integer> (Arrays.asList(4,5,2,6,7,3,1));

		TreeNode t = new ConstructBinaryTreeFromInorderAndPostorder().buildTree(inorder, postorder);
	
		System.out.println("ok");
	}

}
