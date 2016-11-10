package algorithmsAgain;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 * @author mrincodi
 * Date: 2016-08-07
 * Comment: Easiest problem... but I want to do it also with a different comparator,
 * for the sake of practicing.
 */
public class MergeKSortedLists {

	public ListNode1 mergeKLists(ArrayList<ListNode1> a) {

		if ( a.size () == 0 ) return null;	    
		//Let's use a PriorityQueue.
		PriorityQueue <Integer> pq = new PriorityQueue <Integer> ();

		for ( int i = 0; i < a.size();i++ ){
			ListNode1 current = a.get(i);
			while (current != null ){
				pq.add ( current.val);
				current = current.next;
			}
		}

		//Now, create a new list and add them in order.

		if (pq.isEmpty() ) return null;
		int value = pq.remove (); //Get the smallest element of the priority queue (heap).
		ListNode1 result = new ListNode1 (value);
		ListNode1 resultPoint = result;

		while (!pq.isEmpty () ){
			value = pq.remove (); //Get the smallest element of the priority queue (heap).
			resultPoint.next = new ListNode1 (value);
			resultPoint=resultPoint.next;
		}

		return result;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//Definition for singly-linked list.
class ListNode1 {
	public int val;
	public ListNode1 next;
	ListNode1(int x) { val = x; next = null; }
}
