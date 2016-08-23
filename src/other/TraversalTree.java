package other;

import java.util.ArrayList;
import java.util.LinkedList;

class BNode {
	int val;
	BNode left;
	BNode right;

	BNode ( int val ){
		this.val=val;
		this.left=null;
		this.right=null;
	}
}



public class TraversalTree {

	ArrayList <Integer> traversal (BNode root){

		ArrayList <Integer> result = new ArrayList <Integer> ();
		if ( root == null) return result;
		LinkedList <BNode> queue = new LinkedList <BNode> (); //<- OJO.

		queue.add (root);

		while (!queue.isEmpty ()){
			BNode thisNode = queue.remove();
			result.add (thisNode.val);
			if (thisNode.left != null) queue.add(thisNode.left);
			if (thisNode.right != null) queue.add(thisNode.right);
		}

		return result;
	}

	public static void main(String[] args) {
		BNode root = new BNode (6);
		root.left = new BNode (3);
		root.right = new BNode (12);

		root.left.left = new BNode (1);
		root.left.right = new BNode (5);
		root.right.left = new BNode (8);
		root.right.right = new BNode (20);
		root.right.left.right = new BNode (10);

		ArrayList <Integer> result = new TraversalTree().traversal(root);

		for ( int val: result){
			System.out.println(val);
		}

	}

}
