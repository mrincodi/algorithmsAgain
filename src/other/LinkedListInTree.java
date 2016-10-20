package other;

import java.util.Arrays;
import java.util.LinkedList;

import algorithmsAgain.TreeNode;

public class LinkedListInTree {
	
	
	boolean containsLinkedList ( LinkedList <Integer> l, TreeNode t ){
		//First, find the first element. Then, find out if the tree is there.
		if ( l == null ) return false;
		if ( t == null ) return false;

		int val = l.get(0);

		if ( t.val == val && startsLinkedList (l, t, 0) ) return true;
		return (containsLinkedList (l, t.left) || containsLinkedList (l, t.right));
	}

	private boolean startsLinkedList ( LinkedList <Integer> l, TreeNode t, int index ){
		if ( t == null) return false;
		if ( l.get(index) != t.val ) return false;
		if ( index == l.size() - 1) return true;
		return startsLinkedList (l,t.left, index + 1) || startsLinkedList (l,t.right, index + 1);
	}
	
	public static void main(String[] args) {
		LinkedList <Integer> l = new LinkedList <Integer> ( Arrays.asList(1,2,3,4));
		TreeNode t = new TreeNode (1);
		t.left=new TreeNode(2);
		t.left.right=new TreeNode(3);
		t.left.right.left=new TreeNode(4);
		t.left.right.left.left=new TreeNode(1);
		t.right=new TreeNode(2);
		t.left.left=new TreeNode(4);
		
		boolean b= new LinkedListInTree().containsLinkedList(l, t);
		System.out.println(b);
	}

}
