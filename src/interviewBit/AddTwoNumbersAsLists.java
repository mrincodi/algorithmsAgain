package interviewBit;

/**
 * 
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.

 * @author mrincodi
 *
 */
public class AddTwoNumbersAsLists {

	//	 Definition for singly-linked list.
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}


	public ListNode addTwoNumbers(ListNode a, ListNode b) {
		if ( a == null && b == null ) return new ListNode (0);

		if ( a == null ){
			ListNode t = new ListNode (0);
			a = t;
		}
		else if ( b == null ){
			ListNode t = new ListNode (0);
			b = t;
		}

		//Let's add the first two digits, to create the answer.
		int carry = 0;
		int cVal = a.val + b.val;
		if (cVal >= 10){
			carry = 1;
			cVal = cVal%10;
		}
		ListNode cOrig = new ListNode (cVal);
		ListNode c=cOrig;

		a=a.next;
		b=b.next;
		while ( a != null && b!= null){
			cVal = a.val + b.val + carry;
			if (cVal >= 10){
				carry = 1;
				cVal = cVal%10;
			}
			else carry = 0;

			c.next=new ListNode (cVal);
			c=c.next;
			a=a.next;
			b=b.next;
		}

		//Now, one of both lists (or both) may be null.
		//If both are null...
		if (a == null && b==null ){
			//System.out.println ("HEY! TerminE a la vez. " + carry);
			if ( carry == 1 ) c.next=new ListNode (1);
		}
		//We want the longer one to be "a", so if a is null...
		else {
			if ( a == null ) a=b;

			while (a != null ){
				cVal = a.val + carry;
				if ( cVal >=10 ){
					carry = 1;
					cVal=cVal%10;
				}
				else carry = 0;

				c.next=new ListNode (cVal);
				c=c.next;
				a=a.next;
			}
			if ( carry == 1 ) c.next=new ListNode (1);
		}
		return cOrig;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
