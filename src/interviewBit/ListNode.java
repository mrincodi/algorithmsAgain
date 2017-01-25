package interviewBit;

public class ListNode {

	
	// Definition for singly-linked list.

		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
		
		public static ListNode makeList ( int [] vals){
			ListNode result = new ListNode (vals[0]);
			ListNode pointer = result;
			for (int i=1;i<vals.length; i++){
				pointer.next = new ListNode (vals[i]);
				pointer=pointer.next;
			}
			return result;
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
