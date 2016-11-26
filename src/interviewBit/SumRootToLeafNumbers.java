package interviewBit;

public class SumRootToLeafNumbers {
	int MODULO = 1003;

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    
	public int sumNumbers(TreeNode a) {
		if ( a == null ) return 0;
		return sumNumbers (a, 0);
	}

	private int sumNumbers(TreeNode a, int digits) {
		
		//This shouldn't happen.
		//if ( a == null ) return ( Integer.parseInt(digitsS) % MODULO);
		int newDigits =  ( digits * 10 + a.val ) % MODULO;
		
		if (a.left == null && a.right == null )  return newDigits;		
		
		if ( a.right == null ) return ( sumNumbers (a.left, newDigits) % MODULO );
		if ( a.left == null ) return ( sumNumbers (a.right, newDigits) % MODULO );
		
		return ( sumNumbers (a.left, newDigits) + sumNumbers (a.right, newDigits) ) % MODULO;
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode (5);
		t.left=new TreeNode (1);
		t.left.left=new TreeNode (2);
		
		int sum = new SumRootToLeafNumbers().sumNumbers(t);
		System.out.println(sum);

	}

}
