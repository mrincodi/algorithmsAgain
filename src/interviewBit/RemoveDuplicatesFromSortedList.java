package interviewBit;

/**
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 * @author mrincodi
 * 2016-12-29
 * Comment: Easy.
 *
 */
public class RemoveDuplicatesFromSortedList {

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     public int val;
	 *     public ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */
	public ListNode deleteDuplicates(ListNode a) {
		if (a == null || a.next == null) return a;

		ListNode pointer = a;
		ListNode pointer2 = a;

		while (pointer != null && pointer.next !=null){
			if ( pointer.next.val != pointer.val){
				pointer = pointer.next;
			}
			else{
				pointer2=pointer.next;
				while (pointer2 != null && pointer2.val == pointer.val)
					pointer2=pointer2.next;

				pointer.next=pointer2;
				pointer=pointer.next;
			}
		}

		return a;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
