package algorithmsAgain;

public class SwapListNodesInPairs {

	// Definition for singly-linked list.
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	public ListNode swapPairs(ListNode a) {
		if ( a == null ) return null;

		if (a.next == null) return new ListNode (a.val);

		ListNode bHead = new ListNode (a.next.val);
		ListNode b = bHead;
		b.next = new ListNode (a.val);
		b=b.next;

		a=a.next.next;

		while (a != null){
			if (a.next == null) {
				b.next = new ListNode (a.val);
				break;
			}
			else {
				b.next = new ListNode (a.next.val);
				b.next.next = new ListNode (a.val);
				a=a.next.next;
				b=b.next.next;
			}
		}

		return bHead;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
