package algorithmsAgain;

import java.util.ArrayList;

public class SumRootToLeafNumbersLongNumbers {


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

		int totalSum = 0;
		ArrayList < String  > numbers = getNumbersStrings (a);
		for ( int i = 0; i < numbers.size();i++){
			System.out.println(numbers.get(i));
			int thisNumber = Integer.parseInt (numbers.get(i));

			totalSum = (totalSum + thisNumber) % 1003;
		}	    
		return totalSum;
	}

	private ArrayList < String  >  getNumbersStrings ( TreeNode a){
		ArrayList < String  > result = new ArrayList < String  >();
		if ( a.left == null && a.right == null) {
			result.add (a.val + "");
			return result;
		}

		if ( a.left != null ){
			ArrayList < String  > resultLeft = getNumbersStrings (a.left);
			for ( int i = 0; i < resultLeft.size(); i++){
				String number = a.val + resultLeft.get(i);
				result.add(number);
			}        


		}

		if (a.right != null){
			ArrayList < String  > resultRight = getNumbersStrings (a.right);
			for ( int i = 0; i < resultRight.size(); i++){
				String number = a.val + resultRight.get(i);
				result.add(number);
			}
		}    
		return result;
	}


	public static void main(String[] args) {
		TreeNode t = new TreeNode (9);
		t.left=new TreeNode (5);
		t.left.left=new TreeNode (4);
		t.left.right=new TreeNode (5);
		t.right=new TreeNode (9);
		t.right.left=new TreeNode (0);
		
		int sum = new SumRootToLeafNumbersLongNumbers().sumNumbers(t);
		System.out.println(sum);

	}

}
