package interviewBit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class LinkedListNode {
	int key;
	int value;
	LinkedListNode previous;
	LinkedListNode next;

	LinkedListNode (int key, int value, LinkedListNode previous, LinkedListNode next){
		this.key=key;
		this.value=value;
		this.previous=previous;
		this.next=next;
	}
}

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

 NOTE: If you are using any global variables, make sure to clear them in the constructor. 
Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 
         
 * @author mrincodi
 * Comment: A hard but important problem.
 * Took me some time because I thought I could use some of Java's classes
 * (like LinkedHashMap). In the end, I made it by hand.
 * InterviewBit also did it by hand. 
 */
public class LeastRecentlyUsedCache {

	int capacity;
	int usage;
	LinkedListNode start;
	LinkedListNode end;
	HashMap <Integer, LinkedListNode> h;

	public LeastRecentlyUsedCache(int capacity) {
		this.capacity=capacity;
		this.usage=0;
		this.start =null;
		this.h = new HashMap <Integer, LinkedListNode>();

	}

	public int get(int key) {
//		System.out.println("get: " + key);
		int returnValue = -1;
		if (h.containsKey (key) ) {

			returnValue=h.get(key).value;
			putNodeAtStart (h.get(key));
		}
//		System.out.println("Key: " + key + ", value " + returnValue );
//		printQueue();
		
		//Remove this:

		System.out.print(returnValue + " ");
		return returnValue;
	}

	public void set(int key, int value) {

//		System.out.println("set: key: " + key + ", value: " + value);
		//If the key already exists...

		if (h.containsKey(key)){
			//Update the node with the new value. Usage stays the same.
			LinkedListNode node = h.get(key);
			node.value = value;

			//Put the existing node at the beginning
			// of the Linked List.
			putNodeAtStart ( node );
		}

		else {

			//Are we below capacity?
			if (usage == capacity ){
				//Evict the oldest one. Don't forget to keep end updated.
				removeOldest ();
			}

			usage++;
			//Create the new node.
			LinkedListNode newNode = new LinkedListNode (key, value, null, start );
			if ( start != null) start.previous=newNode;
			start = newNode;
			if ( usage == 1) end = newNode;

			h.put(key, newNode);
		}

//		printQueue();
	}

	/**
	 * Puts an existing node at the beginning of the double linkedlist.
	 * 
	 */ 
	void putNodeAtStart (LinkedListNode node ){
		if ( start == node ) return; //It was already the first one.
		else {
			//Let's save the values.
			//Was there a previous node? There should be.
			LinkedListNode previous=node.previous;
			LinkedListNode next=node.next;

			//Before we fix things, notice that if the node we query
			//is the last one, we need to modify end.
			if ( end == node ) end = previous;

			node.previous= null;
			node.next=start;
			if (start!=null) start.previous=node;
			start=node;

			//fix the remaining nodes.
			if ( previous != null ){ //This should always happen.
				previous.next=next;
			}

			if (next!=null){
				next.previous=previous;
			}
		}
	}

	void removeOldest (){
		if ( end == null ) return;

		int oldKey = end.key;

		h.remove (oldKey);
		usage--;

		if ( end.previous != null ){
			end.previous.next = null;
			end = end.previous;
		}
		else
			end = null;
	}

	void printQueue (){
		
		System.out.print("Queue: ");
		if (start != null ){

			LinkedListNode lln = start;
			while ( lln != null ){
				System.out.print(lln.key + " ");
				lln=lln.next;
			}
		}
//		System.out.println();
		
		//Remove this:
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		try {
//			String input = br.readLine();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		Solution s = new Solution (3);
		//		s.set(1, 4);
		//		s.set (2,5);
		//		s.set(7, 8);
		//		s.get(1);
		//		s.set(9, 3);
		//		int q;
		//		q = s.get(1);
		//		System.out.println(q);
		//		q = s.get(2);
		//		System.out.println(q);
		//		q = s.get(7);
		//		System.out.println(q);
		//		q = s.get(9);
		//		System.out.println(q);
		//		



		/*
		 * 59 7 S 2 1 S 1 10 S 8 13 G 12 S 2 8 G 11 G 7 S 14 7 S 12 9 S 7 10 G 11 S 9 3 S 14 15 G 15 G 9 S 4 13 G 3 S 13 7 G 2 S 5 9 G 6 G 13 S 4 5 S 3 2 S 4 12 G 13 G 7 S 9 7 G 3 G 6 G 2 S 8 4 S 8 9 S 1 4 S 2 9 S 8 8 G 13 G 3 G 13 G 6 S 3 8 G 14 G 4 S 5 6 S 10 15 G 12 S 13 5 S 10 9 S 3 12 S 14 15 G 4 S 10 5 G 5 G 15 S 7 6 G 1 S 5 12 S 1 6 S 11 8
		 */


		/*
		 * Your function returned the following :
-1 -1 -1 -1 -1 3 -1 8 -1 7 7 10 2 -1 8 7 2 7 -1 15 12 9 12 6 -1 4 
The expected returned value :
-1 -1 -1 -1 -1 3 -1 8 -1 7 7 -1 2 -1 8 7 2 7 -1 -1 12 -1 12 6 -1 -1 
		 */

		LeastRecentlyUsedCache s = new LeastRecentlyUsedCache (7);

		//		s.set(4, 7);
		//		s.set(4,5);
		//		s.get(4);
		//


		s.set(2,1);
		s.set(1,10);
		s.set(8,13);
		s.get(12);
		s.set(2,8);
		s.get(11);
		s.get(7);
		s.set(14,7);
		s.set(12,9);
		s.set(7,10);
		s.get(11);
		s.set(9,3);
		s.set(14,15);
		s.get(15);
		s.get(9);
		s.set(4,13);
		s.get(3);
		s.set(13,7);
		s.get(2);
		s.set(5,9);
		s.get(6);
		s.get(13);
		s.set(4,5);
		s.set(3,2);
		s.set(4,12);
		s.get(13);
		s.get(7);
		s.set(9,7);
		s.get(3);
		s.get(6);
		s.get(2);
		s.set(8,4);
		s.set(8,9);
		s.set(1,4);
		s.set(2,9);
		s.set(8,8);
		s.get(13);
		s.get(3);
		s.get(13);
		s.get(6);
		s.set(3,8);
		s.get(14);
		s.get(4);
		s.set(5,6);
		s.set(10,15);
		s.get(12);
		s.set(13,5);
		s.set(10,9);
		s.set(3,12);
		s.set(14,15);
		s.get(4);
		s.set(10,5);
		s.get(5);
		s.get(15);
		s.set(7,6);
		s.get(1);
		s.set(5,12);
		s.set(1,6);
		s.set(11,8);


	}

}
