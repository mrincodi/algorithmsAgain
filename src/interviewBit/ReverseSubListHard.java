package interviewBit;

/**
 * 
 * This is a very hard problem!
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question. 
See Expected Output

 * @author mrincodi
 * 2016-08-01
 */
//import algorithmsAgain.SwapListNodesInPairs.ListNode;


// Definition for singly-linked list.
class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; next = null; }
}

public class ReverseSubListHard {



	
	//public ListNode reverseBetween(ListNode a, int m, int n) 
	
	public ListNode reverseBetween (ListNode a, int m, int n){
		
		if ( a == null || m >= n ) return a;
		
		if ( m == 1){
			ListNode aa=a;
			//Find n, swap values and call the method again.
			for ( int i = 1; i < n; i++){
				aa=aa.next;
				//System.out.println ( "Y voy por " + aa.val);
			}
			int temp = a.val;
			a.val = aa.val;
			aa.val=temp;
			
			return reverseBetween (a, m+1, n-1);

		}
		
		ListNode base, prev, curr, next, baseNext;

		base = a;
		//First, we get to "base".
		for ( int i = 1; i < m - 1; i++){
			base=base.next;
		}
		
		//System.out.println("Y base es " + base.val);
		
		
		prev = base.next;
		curr = prev.next;
		next = curr.next;
		
		//Now, let's do it! i will be the position of current.
		for ( int i = m; i < n; i++){
			baseNext=base.next;
			base.next=curr;
			prev.next=next;
			curr.next=baseNext;
			
			if ( next == null ) return a;
			
			curr=next;
			next=curr.next;
		}
		
		return a;
	}


	public static void main(String[] args) {
		
		ListNode ln = new ListNode (1);
		ln.next=new ListNode (2);
		ln.next.next=new ListNode (3);
		ln.next.next.next=new ListNode (4);
		ln.next.next.next.next=new ListNode (5);
		ln.next.next.next.next.next=new ListNode (6);
		ln.next.next.next.next.next.next=new ListNode (7);
		ln.next.next.next.next.next.next.next=new ListNode (8);
		ln.next.next.next.next.next.next.next.next=new ListNode (9);
		ln.next.next.next.next.next.next.next.next.next=new ListNode (10);
		
		new ReverseSubListHard ().reverseBetween (ln,3,7);

		while (ln != null){
			System.out.println (ln.val);
			ln=ln.next;
		}
		
	}

}
