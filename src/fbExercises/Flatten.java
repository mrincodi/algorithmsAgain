package fbExercises;

import interviewBit.TreeNode;;

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
 * 2016-11-12
 * Comment: My solution.
 */
public class Flatten {
	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
		public TreeNode flatten(TreeNode a) {
		    
		    TreeNode pointer = a;
		    if ( a == null ) return null;
		    
		    flatten (a.left);
		    flatten (a.right);
		    
		    //Go to your rightmost node to the left.
		    //Not having to do this makes FB's solution better.
		    if (a.left != null ){
		        pointer = a.left;
	            while (pointer.right != null)
	                pointer= pointer.right;
	                
	            pointer.right = a.right;
	            a.right = a.left;
	            a.left = null;
		    }
		    
		    return a;
		}
		

}
