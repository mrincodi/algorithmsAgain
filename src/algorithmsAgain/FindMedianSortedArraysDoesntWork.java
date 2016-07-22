package algorithmsAgain;

import java.util.ArrayList;
import java.util.List;

public class FindMedianSortedArraysDoesntWork {

	public double median ( ArrayList a ){
		if ( a.size == 0 ) return -1; //TODO: Throw exception!

		if ( a.size % 2 == 1 ) return (double) a.get (a.size()/2);

		else {
			return (double) ( (double) a.get (a.size()/2 -1) + (double) a.get (a.size()/2 ) )/2;
		}
		return -1;
	}

	public void insertElement (int value, Arraylist c ){
		int pos = getPositionForValue (value, c, 0, b.size());
		b.add (pos, value);
	}

	piblic int getPositionForValue (int value, Arraylist b, int inf, int sup){
		if (inf == sup) return inf;


	}

	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

		ArrayList c = new ArrayList <Integer> (b);
		for ( int i = 0; i < a.size(); i++ ){
			insertElement (a.get (i), c);
		}

		return median ( c );

	}
}

_______________________


Idea2:


public class Solution {



	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

		int m = a.size();
		int n = b.size();

		if ( m == 0 ){
			if ( n %2 == 1 ) return b.get (n /2 );
			else return ((double) ((double) b.get (n /2 -1 ) + (double) (b.get (n /2 ) / 2); 
		}
		//Get two limit numbers.
		int i = a.size()/2;
		int j = b.size()/2;

		//If both are odd, move i 1 to the right.

		if ( i % 2 == 1 && j % 2 == 1){
			i++;
		}

		return findMedianSortedArrays ( a, b, i, j );

	}


	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b, int i, int j) {
		int m = a.size();
		int n = b.size();

		int minLeft = 0;
		int maxLeft = 0;
		int minRight = 0;
		int maxRight = 0;

		//From the "left set, get the minimum value.
		//Get the minLeft.
		if ( i == 0 ) {
			// This means all the elements in A are bigger than B.
			// so treat both arrays as a single one.
			if ( m == n ) return (b.get(n-1)+a.get(0))/2;
			if ( n%2 == 0) return (b.get(j-1)+b.get(j))/2;
			else return (b.get(j));
		}

		if ( j == 0 ) {
			// This means all the elements in B are bigger than A.
			// so treat both arrays as a single one.
			if ( m == n ) return (a.get(m-1)+b.get(0))/2;
			if ( m%2 == 0) return (a.get(i-1)+a.get(i))/2;
			else return (a.get(j));
		}

		if ( i == m ){
			//All the elements of A are smaller than B's!
			if ( m == n ) return (a.get(m-1)+b.get(0))/2;
			if ( n%2 == 0) return (b.get(j-1)+b.get(j))/2;
			else return (b.get(j));
		}

		if ( j == n ){
			//All the elements of B are smaller than A's!
			if ( m == n ) return (b.get(m-1)+a.get(0))/2;
			if ( m%2 == 0) return (a.get(i-1)+a.get(i))/2;
			else return (a.get(i));
		}


		//Finally, we're in the middle for both counters!
		minLeft = Math.min (a.get(0),b.get(0));
		minRight = Math.max (a.get(i-1),b.get(j-1));
		maxLeft= Math.min (a.get(i),b.get(j));
		maxRight= Math.max (a.get(m-1).b.get(n-1));

		if ( maxLeft < minRight ){
			//We found it!
			if ( (m %2 == 0 &&  n %2 == 0 ) || ( m%2==1 && n%2 == 1 )){
				return ((maxLeft+minRight)/2);
			}
			else{
				if ( m > n ) return a.get(i);
				else return b.get(j);
			}
		}

		else {
			// Decide where to move i.
			int newI=0;
			int diff=0;
			if ( a.get(i)==maxLeft ){
				diff = - i / 2;
			}
			else {
				diff = ( m - i ) / 2;

			}
		}

	}


}

}
