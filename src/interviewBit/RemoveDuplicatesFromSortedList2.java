package interviewBit;

/**
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 * @author mrincodi
 * 2016-12-29
 * Comment: A tad difficult... and a tad verbose: both cycles can be made a single one with some thinking.
 * InterviewBit intelligently uses an initial "helper" node and then returns helper.next.
 *
 */
public class RemoveDuplicatesFromSortedList2 {
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     public int val;
	 *     public ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */
	public ListNode deleteDuplicates(ListNode a) {

		if ( a == null || a.next == null) return a;
		ListNode base = null;
		ListNode prevValid = base;
		ListNode pointer = a;

		//Let''s fix the base first.

		outer:
			while (pointer != null ){
				if ( pointer.next == null)
					return pointer;
				else {
					if (pointer.next.val != pointer.val){
						base = pointer;
						prevValid = base;
						break;
					}
					else {
						ListNode pointer2 = pointer.next;
						while (pointer2 != null){
							if (pointer2.val == pointer.val ){
								pointer2 = pointer2.next;
							}
							else {
								pointer = pointer2;
								continue outer;
							}
						}
						if ( pointer2 == null ) return null;
					}
				}
			}

		//System.out.println("Weno...");
		// Now, let's fix the following elements after the base is calculated.
		prevValid=base;
		pointer = base.next;
		outer2:
			while (pointer != null ){
				if ( pointer.next == null){
					prevValid.next = pointer;
					return base;
				}

				else {
					if (pointer.next.val != pointer.val){
						prevValid.next = pointer;
						prevValid=pointer;
						pointer=pointer.next;
					}
					else {
						ListNode pointer2 = pointer.next;
						while (pointer2 != null){
							if (pointer2.val == pointer.val ){
								pointer2 = pointer2.next;
							}
							else {
								pointer = pointer2;
								continue outer2;
							}
						}
						if ( pointer2 == null ){
							prevValid.next=null;
							return base;
						}
					}
				}
			}
		return base;
	}


	public static void main(String[] args) {
		System.out.println("HELLOOOOO...");
		int [] vals = { 1,1,2,2,3,3,4,5,5,5,5,6,6,7,8,9,10,10,11 }; 
		ListNode list = ListNode.makeList(vals);
		ListNode rd = new RemoveDuplicatesFromSortedList2().deleteDuplicates(list);
		while ( rd != null){
			System.out.println(rd.val);
			rd=rd.next;
		}
	}

}
