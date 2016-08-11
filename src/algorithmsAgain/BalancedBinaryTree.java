package algorithmsAgain;

/**
 * Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 * @author mrincodi
 * Comment: I could have used also a global variable instead,
 * and use inside myDepth, while myDepth calculates the depth.
 */
public class BalancedBinaryTree {

	public int isBalanced(TreeNode a) {

		if ( a == null ) return 1;

		if ( myDepth (a ) == -1) return 0;
		else return 1;

	}

	public int myDepth ( TreeNode n ){
		if ( n== null) return 0;

		int leftDepth  = myDepth (n.left);
		int rightDepth = myDepth (n.right);

		if ( leftDepth == -1 || rightDepth == -1) return -1;

		if (Math.abs ( leftDepth - rightDepth ) > 1 ) return -1;

		return 1 + Math.max ( leftDepth, rightDepth);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
