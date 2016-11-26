package interviewBit;

/**
 * 
 * Given two binary trees T1 and T2, you have to find minimum number of insertions to be done in T1 to make it structurally identical to T2. Return -1 if not possible.

Notes 
- Assume insertions are done in a normal fashion in the BSTs.
- Assume while inserting, if the value of a node v is equal to value being inserted, we insert it in left subtree of node v.
- You can insert any positive or negative integer.

Example :

Input 1: 

T1:       10
         / \
        9   20

T2:       5
         / \
        2   7
       /
      1

If you insert 8 into T1, it will be structurally identical to T2. Hence answer is 1.


Input 2: 

T1:       10
         / \
        9   20

T2:       5
           \
            7

You cannot make T1 and T2 structurally identical. Hence answer is -1.
See Expected Output

 * @author mrincodi
 * 2016-08-29
 * Comment: Beautiful (and easy) problem!
 *
 */
public class BuildIdenticalTrees {


	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	public int cntMatrix(TreeNode a, TreeNode b) {

		if ( a == null && b == null ) return 0;

		if ( a != null && b == null ) return -1;

		if ( a == null ) return 1 + cntMatrix ( null, b.left ) + cntMatrix ( null, b.right );

		//if ( a.left != null && b.left == null ) return -1;

		//if ( a.right != null && b.right == null ) return -1;

		int leftResult = cntMatrix ( a.left, b.left );

		if ( leftResult == -1 ) return -1;

		int rightResult = cntMatrix ( a.right, b.right );

		if ( rightResult == -1 ) return -1;

		return leftResult + rightResult;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
