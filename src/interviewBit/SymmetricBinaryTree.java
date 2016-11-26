package interviewBit;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric. 
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * @author mrincodi
 * 2016-08-08
 */
public class SymmetricBinaryTree {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public int isSymmetric(TreeNode a) {

		if ( a == null ) return 1;
		if ( isSymmetric (a.left, a.right) ) return 1;
		return 0;
	}

	boolean isSymmetric (TreeNode a, TreeNode b){
		if ( a== null && b == null ) return true;
		if ( a!= null && b == null ) return false;
		if ( a== null && b != null ) return false;

		if ( a.val != b.val ) return false;

		return isSymmetric (a.left, b.right ) && isSymmetric (a.right, b.left );
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
