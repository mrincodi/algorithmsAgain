package interviewBit;

import java.util.HashMap;
import java.util.List;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 
 * @author mrincodi
 * 2016-08-12
 * Comment: Greedy?? This is an elementary problem (no showing off, I promise).
 */
public class MajorityElement {

	public int majorityElement(final List<Integer> a) {
		HashMap <Integer, Integer> h = new HashMap  <Integer, Integer> ();

		for ( int elem : a ){
			if (!h.containsKey(elem) ) h.put(elem,1);
			else h.put(elem,h.get(elem)+1);
		}

		int currentMax = 0;
		int currentElemMax = 0;
		for ( int elem : h.keySet ()){
			if (h.get(elem) > currentMax ) {
				currentElemMax = elem;
				currentMax=h.get(elem);
			}
		}

		return currentElemMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
