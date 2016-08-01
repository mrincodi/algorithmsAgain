package algorithmsAgain;

/**
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

 * @author mrincodi
 * 2016-08-01
 *
 */
public class PartitionList {


	//Definition for singly-linked list.
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	public class Solution {
		public ListNode partition(ListNode a, int b) {

			if ( a == null ) return null;

			ListNode beforeOrig = null;
			ListNode afterOrig = null;
			ListNode before = null;
			ListNode after = null;


			while ( a != null){
				if ( a.val < b ){
					if (beforeOrig == null ) { 
						beforeOrig = new ListNode (a.val);
						before=beforeOrig;
					}
					else {
						before.next=new ListNode (a.val);
						before=before.next;
					}
				}
				else {
					if (after == null ) {
						afterOrig = new ListNode (a.val);
						after = afterOrig;
					}
					else {
						after.next=new ListNode (a.val);
						after=after.next;
					}
				}
				a=a.next;
			}

			if ( beforeOrig == null ) return afterOrig;
			else {
				before.next=afterOrig;
				return beforeOrig;
			}

		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
