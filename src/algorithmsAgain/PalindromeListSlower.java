package algorithmsAgain;

/**
 * 
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes: 
- Expected solution is linear in time and constant in space.

For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.

 * @author mrincodi
 * 2016-09-16
 * Comment: This solution does the work, albeit not that fast. 
 * The key here is to notice that:
 *  - To check palindrome, we just have to reverse latter half of linked list and then we can in (n/2) steps total can compare if all elements are same or not.
	- For finding mid point, first we can in O(N) traverse whole list and calculate total number of elements.
	- Reversing is again O(N). 
 */
public class PalindromeListSlower {



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
		middle++;
		if ( n%2==1) 
			middle++;

		//Get to that position.
		pointer = start;
		for ( int i =1; i < middle;i++)
			pointer = pointer.next;

		reverse (pointer);        

		boolean areTheyEqual = areBothListsEqual (start, pointer);

		return areTheyEqual?1:0;

	}

	public void reverse (ListNode node){
		ListNode start = node;
		ListNode pointer = node;

		if ( node == null || node.next == null) return;
		//Get to the end.
		int n = 1;
		while (pointer.next!= null){
			n++;
			pointer=pointer.next;
		}

		//All-right, now let's start swapping.

		int i = 1;
		while (i <= n/2 ){
			ListNode pointerStart=start;
			ListNode pointerEnd=start;

			//First, get to the pointerStart node.
			for ( int j = 1; j < i; j++ )
				pointerStart=pointerStart.next;

			//Now, get to the pointerEnd node.
			for ( int j = 1; j <= n - i; j++ )
				pointerEnd=pointerEnd.next;

			//now, swap the _values_!
			int temp = pointerStart.val;
			pointerStart.val=pointerEnd.val;
			pointerEnd.val=temp;

			i++;            
		}

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
		ListNode list = new ListNode (7);
		list.next = new ListNode (9);
		list.next.next = new ListNode (9);
		list.next.next.next = new ListNode (7);
		int is = new PalindromeListSlower().lPalin(list);
		System.out.println(is);

	}

}
