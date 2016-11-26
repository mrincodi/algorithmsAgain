package interviewBit;

/**
 * 
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.

 * @author InterviewBit
 * This solution is much less wordy.
 *
 */
public class AddTwoNumbersAsListsBetter {

	//	 Definition for singly-linked list.
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	public ListNode addTwoNumbers(ListNode A, ListNode B) {
	    ListNode node;
	    ListNode prev = null;
	    ListNode first = null;
	    int carry = 0;
	    int sum = 0;
	    
	    while (A != null || B != null || carry != 0) {
	        
	        node = new ListNode(0);
	        sum = carry;
	        
	        if (first == null)
	            first = node;
	            
	        if (prev != null)
	            prev.next = node;
	        
	        if (A != null) {
	            sum += A.val;
	            A = A.next;
	        }
	            
	        if (B != null) {
	            sum += B.val;
	            B = B.next;
	        }
	        
	        node.val = sum % 10;
	        
	        sum /= 10;
	        carry = sum;
	        prev = node;
	    }
	    
	    return first;
	    
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
