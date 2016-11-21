package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes: 
- Expected solution is linear in time and constant in space.

For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.

 * @author mrincodi
 * 2016-11-19
 * Comment: Finally, a decent solution. Reversing that half list was... Ugh: pointer nightmare
 *
 */
public class PalindromeList {


	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     public int val;
	 *     public ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */
	public int lPalin(ListNode A) {

		if ( A == null ) return 1;
		if (A.next == null ) return 1;

		ListNode start = A;
		ListNode pointer = A;

		//First, find out the length of the list.
		int n = 1;
		while (pointer.next != null){
			n++;
			pointer=pointer.next;
		}

		//Just a quick check right now.
		if ( pointer.val != start.val ) return 0;

		//All-right! What's the middle of the array?
		int middle=n/2;
		if ( n%2==1) 
			middle++;

		//Get to that position.
		pointer = start;
		for ( int i =1; i < middle ;i++)
			pointer = pointer.next;

		pointer.next = reverse (pointer.next);        

		boolean areTheyEqual = areBothListsEqual (start, pointer.next);

		return areTheyEqual?1:0;

	}

	private ListNode reverse (ListNode node){

		ListNode start = node;

		ListNode end = start;

		while (end.next != null){
			ListNode temp = end.next.next;
			end.next.next=start;
			start=end.next;
			end.next=temp;
		}
		return start;

	}

	public boolean areBothListsEqual ( ListNode listA, ListNode listB ){

		if (listA==null && listB == null) return true;

		while ( listB != null ){
			if (listA.val != listB.val ) return false;
			listA=listA.next;
			listB=listB.next;
		}

		return true;
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<Integer> (Arrays.asList(1,2,3,4,4,3,2,1));
		
		ListNode list = new ListNode (al.get(0));
		ListNode pointer = list;
		for ( int i = 1; i< al.size();i++){
			pointer.next=new ListNode(al.get(i));
			pointer = pointer.next;
		}
		
		int is = new PalindromeList().lPalin(list);
		System.out.println(is);

	}

}
