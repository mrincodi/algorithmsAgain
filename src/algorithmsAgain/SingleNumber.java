package algorithmsAgain;

/**
 * Single NumberBookmark Suggest Edit
Given an array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SingleNumber {

	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
		HashSet <Integer> h = new HashSet <Integer> ();

		for ( int i = 0; i < a.size(); i++ ){
			int number = a.get(i);
			if (!h.contains ( number ))
				h.add (number);
			else
				h.remove (number);
		}

		Iterator iter = h.iterator ();

		return (Integer) iter.next();

	}

}
