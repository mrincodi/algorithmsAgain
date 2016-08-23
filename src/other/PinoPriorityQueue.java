package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MyComparator implements Comparator <Integer>{

	@Override
	public int compare (Integer a, Integer b){
		if (Math.abs(a)>Math.abs(b) ) return 1;
		if (Math.abs(a)<Math.abs(b) ) return -1;

		return 0;
	}

}

public class PinoPriorityQueue {

	// OJO: Var names.
	// OJO Defining arrays OK.

	public int [] heapSort ( int [] vals){
		return heapSort (vals, new MyComparator());
	}


	public int [] heapSort ( int [] vals, Comparator <Integer> c ){

		int [] sorted = new int [vals.length];
		Comparator <Integer> myComparator = c;
		PriorityQueue <Integer > heap = new PriorityQueue <Integer> (10, myComparator);

		for ( int val: vals )
			heap.add (val);

		for ( int i=0;i<vals.length; i++ )
			sorted[i] = heap.remove ();

		return sorted;
	}


	public static void main ( String [] args ){
		int [] vals = {9,-7,4,-9,14,-1,0,3,3};
		int [] sorted =  new PinoPriorityQueue().heapSort (vals);

		for ( int val: sorted ){
			System.out.println ( val );
		}

		sorted = new PinoPriorityQueue().heapSort (vals, Collections.reverseOrder(new MyComparator()));

		for ( int val: sorted ){
			System.out.println ( val );
		}

		System.out.println("---------------");


		java.util.PriorityQueue <Integer> pq = new java.util.PriorityQueue <Integer> (Collections.reverseOrder ());

		pq.add (7);
		pq.add (2);
		pq.add (9);
		pq.add (-1);
		pq.add (0);
		pq.add (100);
		pq.add (4);

		while (!pq.isEmpty() ){
			System.out.println ( pq.remove ());
		}




	}
}
