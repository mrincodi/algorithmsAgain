package algorithmsAgain;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String args[]) {
		// create priority queue
		PriorityQueue < Integer >  prq = new PriorityQueue < Integer > (); 

		// insert values in the queue
		for ( int i = 3; i  <  10; i++ ){  
			prq.add (new Integer (i)) ; 
		}

		System.out.println ( "Initial priority queue values are: "+ prq);

		// remove 7 from the queue
		boolean isremoved = prq.remove(7);

		System.out.println ( "Return value after remove: "+ isremoved);

		System.out.println ( "Priority queue values after remove: "+ prq);
	}



}
