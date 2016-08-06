package algorithmsAgain;

/**
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3.

  author: mrincodi
  2016-08-02
 */
import java.util.HashSet;

public class ListCycle {

	// Definition for singly-linked list.
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	public ListNode detectCycle(ListNode a) {
		HashSet <ListNode> s = new HashSet <ListNode> ();

		while ( a != null ){
			if (s.contains (a) ) return a;
			s.add (a);
			a=a.next;
		}
		return null;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
