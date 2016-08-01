package algorithmsAgain;

import java.util.HashSet;


/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

 Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 * @author mrincodi
 * Date: 2016-08-01
 */
public class IntersectionOfLinkedLists {

	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		HashSet < ListNode > s = new HashSet < ListNode > ();

		if (a == null || b == null ) return null;

		while (a != null ){
			if ( a == b){
				return a;
			}
			s.add (a);
			a=a.next;
		}

		b=b.next;
		while ( b != null ){
			if (s.contains (b)){
				return b;
			}
			b=b.next;
		}
		return null;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
