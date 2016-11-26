package interviewBit;

public class ValidBinarySearchTree {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	class Pair {
		int smallest;
		int greatest;

		Pair (int s, int g){ this.smallest=s; this.greatest=g; }
	}
	boolean isValid = true;
	Pair error = new Pair (-1, -1);

	public int isValidBST(TreeNode a) {
		if ( a == null ) return 1;
		getLimits (a);
		return isValid?1:0;
	}

	private Pair getLimits ( TreeNode t ){
		//if (t == null) return error; //This should not happen.

		if ( !isValid) return error;

		//if (t.left == null && t.right == null ) return new Pair (t.val, t.val);

		Pair result = new Pair (-1, -1);
		if ( t.left != null){
			Pair leftPair = getLimits (t.left);
			if ( !isValid ) return error;
			if ( leftPair.greatest >= t.val ) {
				isValid = false; 
				return error;
			}
			result.smallest = leftPair.smallest;
		}
		else
			result.smallest = t.val;

		if ( t.right != null){
			Pair rightPair = getLimits (t.right);
			if ( !isValid ) return error;
			if ( rightPair.smallest <= t.val ) {
				isValid = false;
				return error;
			}
			result.greatest = rightPair.greatest;
		}
		else
			result.greatest = t.val;

		return result;
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode (3);
		t.left = new TreeNode (2);
		t.right = new TreeNode (4);
		t.left.left = new TreeNode (1);
		t.left.right = new TreeNode (3);
//		t.left = new TreeNode (3);
//		t.left = new TreeNode (3);
//		t.left = new TreeNode (3);
//		t.left = new TreeNode (3);

		int r = new ValidBinarySearchTree().isValidBST(t);
		System.out.println(r);
	}

}
