package algorithmsAgain;

/**
 * 
 * Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.


 * @author mrincodi
 * 2016-08-09
 * Comment: Well, this solution works, but InterviewBit complains a StackOverflowError.
 * I see that a recursive approach may produce it for a large tree.
 * InterviewBit
 */
public class FlattenBinaryTreeToLinkedListRecursive {

	public TreeNode flatten(TreeNode a) {
	    
	    if ( a == null ) return a;
	    
	    if ( a.left != null ){

	        TreeNode pointer = a.left;
	        while (pointer.right != null)
    	        pointer=pointer.right;

            pointer.right = a.right;
                
            a.right = a.left;
            a.left = null;
	    }
	    
	    a.right=flatten (a.right);
	    
	    return a;
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
