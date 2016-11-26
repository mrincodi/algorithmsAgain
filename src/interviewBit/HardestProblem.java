package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardestProblem {


	/**
	 * Precondition: all members of "a" are smaller than all members of "b".
	 * @param a
	 * @param b
	 * @return
	 */
	public double getMedianWhenOneArrayIsAllSmallerThanTheOther(final List<Integer> a, final List<Integer> b) {

		int m = a.size();
		int n = b.size();
		int i=0,j=0;

		if ( m == n) {
			return (double) ( (double) a.get(m-1) + (double) b.get(0) )/2;
		}

		else if ( m < n ){
			//j = n - ( m + n )/2;
			j = ( m + n )/2 - m;
			if ( ( m %2 ==0 && n % 2 == 0 ) || ( m %2 == 1 && n % 2 == 1 )){
				return ( (double)((double)b.get(j-1)+(double)b.get(j))/2);
			}
			else {
				return (double)b.get(j);
			}
		}

		else if ( m > n ){
			i=(m+n)/2;
			if ( ( m %2 ==0 && n % 2 == 0 ) || ( m %2 == 1 && n % 2 == 1 )){
				return ( (double)((double)a.get(i-1)+(double)a.get(i))/2);
			}
			else {
				return (double)a.get(i);
			}
		}
		return -1;
	}

	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

		int m = a.size();
		int n = b.size();

		System.out.println(m + " y " + n);
		if ( m == 0 ){
			if ( n %2 == 1 ) return b.get (n /2 );
			else return (
					(double) 
					(  ( (double) b.get (n /2 -1 ) + (double) b.get (n /2 ) ) / 2     ) ); 
		}

		if ( n == 0 ){
			if ( m %2 == 1 ) return a.get (m /2 );
			else return (
					(double) 
					(((double) a.get (m /2 -1 ) + (double) a.get (m /2 )) / 2)); 
		}

		// If all the elements on one array are bigger than all the elements in the other side, easily calculate the median.
		int i=0, j=0;

		if ( a.get(m-1) < b.get(0)){ //treat them as a single array.
			return getMedianWhenOneArrayIsAllSmallerThanTheOther(a,b);
		}

		if ( b.get(m-1) < a.get(0)){
			return getMedianWhenOneArrayIsAllSmallerThanTheOther(b,a);
		}

		//Not an easy case, let's get to work.
		//Calculate i and j.

		//Get two limit numbers.
		i = a.size()/2;
		j = b.size()/2;
		
		System.out.println(i + " y " + j);
		
		//If both are odd, move i 1 to the right.
		//TODO: Leave this case for last!
		if ( m % 2 == 1 && n % 2 == 1){
			i++;
		}
		
		System.out.println(i + " " + j);
		return findMedianSortedArrays ( a, b, i, j );
		
	}

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b, int i, int j) {
		int m = a.size();
		int n = b.size();

		int minLeft = 0;
		int maxLeft = 0;
		int minRight = 0;
		int maxRight = 0;
		
		minLeft = Math.min (a.get(0),b.get(0));
		maxLeft = Math.max (a.get(i-1),b.get(j-1));
		minRight= Math.min (a.get(i),b.get(j));
		maxRight= Math.max (a.get(m-1),b.get(n-1));
		
		System.out.println("minLeft = " + minLeft);
		
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

		//TODO: y mucho trabajo por delante...
		return -1;
	}

	public static void main(String[] args) {

		HardestProblem h = new HardestProblem ();

//		List <Integer> b = new ArrayList <Integer> (Arrays.asList(3,5,6,7,9,13,15,26,77,89,91,93,99));
//		List <Integer> a = new ArrayList <Integer> (Arrays.asList(100,104,124,134));

		List <Integer> a = new ArrayList <Integer> (Arrays.asList(3,5,6,7,93,99));
		List <Integer> b = new ArrayList <Integer> (Arrays.asList(1,4,8,104,124,134));

		double d = h.findMedianSortedArrays (a,b);
		System.out.println(d);

	}

}




//
////From the "left set, get the minimum value.
////Get the minLeft.
//if ( i == 0 ) {
//	// This means all the elements in A are bigger than B.
//	// so treat both arrays as a single one.
//	if ( m == n ) return (b.get(n-1)+a.get(0))/2;
//	if ( n%2 == 0) return (b.get(j-1)+b.get(j))/2;
//	else return (b.get(j));
//}
//
//if ( j == 0 ) {
//	// This means all the elements in B are bigger than A.
//	// so treat both arrays as a single one.
//	if ( m == n ) return (a.get(m-1)+b.get(0))/2;
//	if ( m%2 == 0) return (a.get(i-1)+a.get(i))/2;
//	else return (a.get(j));
//}
//
//if ( i == m ){
//	//All the elements of A are smaller than B's!
//	if ( m == n ) return (a.get(m-1)+b.get(0))/2;
//	if ( n%2 == 0) return (b.get(j-1)+b.get(j))/2;
//	else return (b.get(j));
//}
//
//if ( j == n ){
//	//All the elements of B are smaller than A's!
//	if ( m == n ) return (b.get(m-1)+a.get(0))/2;
//	if ( m%2 == 0) return (a.get(i-1)+a.get(i))/2;
//	else return (a.get(i));
//}
//
//
////Finally, we're in the middle for both counters!
//minLeft = Math.min (a.get(0),b.get(0));
//minRight = Math.max (a.get(i-1),b.get(j-1));
//maxLeft= Math.min (a.get(i),b.get(j));
//maxRight= Math.max (a.get(m-1).b.get(n-1));
//
//if ( maxLeft < minRight ){
//	//We found it!
//	if ( (m %2 == 0 &&  n %2 == 0 ) || ( m%2==1 && n%2 == 1 )){
//		return ((maxLeft+minRight)/2);
//	}
//	else{
//		if ( m > n ) return a.get(i);
//		else return b.get(j);
//	}
//}
//
//else {
//	// Decide where to move i.
//	int newI=0;
//	int diff=0;
//	if ( a.get(i)==maxLeft ){
//		diff = - i / 2;
//	}
//	else {
//		diff = ( m - i ) / 2;
//
//	}
//}
//
//}
//
