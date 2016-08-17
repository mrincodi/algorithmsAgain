package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MyComparator implements Comparator <Integer>{

	@Override
	public int compare (Integer a, Integer b){
		if (Math.sin(a)>Math.sin(b) ) return 1;
		if (Math.sin(b)<Math.sin(a) ) return -1;
			
		return 0;
	}
	
}

public class PinoPriorityQueue {

	// OJO: Var names.
	// OJO Defining arrays OK.

	public int [] heapSort ( int [] vals ){
		
		Integer [] array = { 5,4,6,7};
		ArrayList <Integer> al = new ArrayList <Integer> ( Arrays.asList(array));
		int [] sorted = new int [vals.length];
		MyComparator myComparator = new MyComparator();
		PriorityQueue <Integer > heap = new PriorityQueue <Integer> (10, myComparator);

		for ( int val: vals )
			heap.add (val);

		for ( int i=0;i<vals.length; i++ )
			sorted[i] = heap.remove ();

		return sorted;
	}

	
	public static void main ( String [] args ){
		int [] vals = {9,7,4,9,14,-1,0,3,3};
		int [] sorted =  new PinoPriorityQueue().heapSort (vals);

		for ( int val: sorted ){
			System.out.println ( val );
		}

	}
}
