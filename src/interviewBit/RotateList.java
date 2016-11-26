package interviewBit;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 * @author mrincodi
 * 2016-10-04
 * Comment: A classic. Boundaries are always tricky.
 */
public class RotateList {

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     public int val;
	 *     public ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */
	public ListNode rotateRight(ListNode a, int b) {

		if ( a == null ) return a;

		ListNode pointer = a;
		int length = 1;
		while (pointer.next != null){
			length++;
			pointer=pointer.next;
		}

		ListNode lastNode = pointer;

		b=b%length;

		if ( b == 0 ) return a;
		if (length == 1 ) return a;

		//Now, get to the right position.
		ListNode previousPointer=a;
		pointer = a.next;
		for ( int i = 1; i<length - b; i++){
			previousPointer=pointer;
			pointer = pointer.next;
		}

		//Now, fix the LinkedList.
		ListNode result  = pointer;
		lastNode.next = a;
		previousPointer.next = null;

		return result;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
