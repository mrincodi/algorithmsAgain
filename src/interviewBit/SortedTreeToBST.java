package interviewBit;

import java.util.ArrayList;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3
 * @author mrincodi
 * 2016-08-13
 * Comment: ? This has nothing to do with graphs, but whatever. ;)
 */
public class SortedTreeToBST {


	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     public int val;
	 *     public ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */
	public TreeNode sortedListToBST(ListNode a) {
		//Pass the elements to an ArrayList.
		ArrayList <Integer>al = new ArrayList <Integer> ();

		while ( a != null){
			al.add (a.val);
			a=a.next;
		}

		// Call a recursive method with this ArrayList.

		TreeNode t = makeTree ( al);

		return t;
	}

	TreeNode makeTree (ArrayList <Integer> al ){
		if (al == null | al.size () == 0 ) return null;

		if ( al.size() == 1 ) return new TreeNode (al.get(0));

		//Get half value.
		int middlePos = al.size()/2;

		TreeNode t = new TreeNode (al.get(middlePos));


		t.left = makeTree (new ArrayList <Integer> (al.subList (0, middlePos)));
		t.right = makeTree (new ArrayList <Integer> (al.subList (middlePos+1, al.size())));


		return t;
	}







	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
