package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,
Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].

 * @author mrincodi
 * 2016-12-01
 * Comment: Easy, but careful with the equals()!
 */
public class RemoveDuplicatesFromSortedArray2 {

	public int removeDuplicates(ArrayList<Integer> a) {
	    
	    if (a.size () <= 2 ) return a.size();

	    int i = 0;  //Last position of the result ArrayList.
	    int j = 1;  //Iterator over the ArrayList.
	    int numOfRepetitions = 1;
	    
	    while ( j < a.size() ){
	        if (a.get(j).equals(a.get(j-1))){
	            numOfRepetitions++;
	            if ( numOfRepetitions < 3 )
	                i++;
	        }
	        else {
	            numOfRepetitions=1;
	            i++;
	        }

	        a.set(i,a.get(j));
	        j++;

	    }
	    
	    //a = a.subList (0,i).clear();
	 
	    return i+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Integer> a = new ArrayList  <Integer> ( Arrays.asList(5000,5000,5000,5000));
		
		int q = new RemoveDuplicatesFromSortedArray2().removeDuplicates(a);
		
		System.out.println(q);
		System.out.println(a);


	}

}
