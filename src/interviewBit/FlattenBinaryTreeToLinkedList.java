package interviewBit;

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
 * Comment: The non-recursive approach!
 */
public class FlattenBinaryTreeToLinkedList {
	public TreeNode flatten(TreeNode a) {
	    
	    TreeNode mainPointer = a;
	    
	    while (mainPointer != null){
	    
	        if ( mainPointer.left != null ){

	            TreeNode pointer = mainPointer.left;
	            while (pointer.right != null)
    	            pointer=pointer.right;

                pointer.right = mainPointer.right;
                
                mainPointer.right = mainPointer.left;
                mainPointer.left = null;
    	    }
    	    mainPointer=mainPointer.right;
	    }
	    return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
