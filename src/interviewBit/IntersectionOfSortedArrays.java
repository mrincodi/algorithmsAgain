package interviewBit;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
 NOTE : For the purpose of this problem ( as also conveyed by the sample case ), 
 assume that elements that appear more than once in both arrays should be included 
 multiple times in the final output. 
 
 * @author Mario
 *
 */
public class IntersectionOfSortedArrays {
		// DO NOT MODIFY THE LISTS
		public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

	        ArrayList <Integer> al = new ArrayList <Integer> ();

	        int i =0, j = 0;

	        while ( i < a.size () && j < b.size () ){
	            int va = a.get(i);
	            int vb = b.get(j);

	            if ( va == vb ) {
	                al.add (va);
	                i++;
	                j++;
	            }
	                
	            else if ( va < vb) i++;
	            else j++;
	        }
	        
	        return al;

		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
