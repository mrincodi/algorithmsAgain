package algorithmsAgain;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Just practicing howto do an inorder to a tree.
 * @author mrincodi
 * 2016-10-07
 *
 */
public class InOrder {

	public ArrayList <Integer> inOrder (TreeNode t){
		ArrayList <Integer> result = new ArrayList <Integer> ();

		Stack <TreeNode > stack = new Stack < TreeNode > ();

		addLeftNodes(stack,t);

		while (!stack.isEmpty()){
			TreeNode aNode = stack.pop();

			int val = aNode.val;
			result.add(val);
			if ( aNode.right != null)
				addLeftNodes(stack, aNode.right);
		}

		return result;
	}


	void addLeftNodes (Stack <TreeNode> s, TreeNode t){
		s.push(t);
		if ( t.left!= null) addLeftNodes(s, t.left);
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
		ArrayList <Integer> a = new InOrder().inOrder(t);
		System.out.println(a);
	}
}
