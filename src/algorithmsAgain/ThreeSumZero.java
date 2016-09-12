package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

public class ThreeSumZero {

	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
		ArrayList <ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if ( a.size () < 3 ) return result;

		LinkedHashMap <Integer, Integer> references = new  LinkedHashMap <Integer, Integer> ();

		Collections.sort (a);
		ArrayList<Integer> b = new ArrayList<Integer> ();
		b.add (a.get(0));

		int numTimes = 1;
		int prevVal = a.get(0);

		for (int i = 1; i < a.size(); i++){
			int val = a.get(i);
			if ( val == prevVal) numTimes++;
			else {
				prevVal = val;
				numTimes = 1;
			}
			if ( numTimes <= 3 )
				b.add(val);

			references.put (val,b.size()-1);
		}

		//Now, let's find the triplets.
		for ( int i = 0; i < b.size()-2; i++){
			int x = b.get(i);
			for ( int j = i+ 1; j < b.size() -1; j++){
				int y = b.get(j);
				int z = -(x+y);
				if ( references.containsKey (z) && references.get(z) > j ){
					ArrayList<Integer> resultEntry = new ArrayList <Integer> (Arrays.asList (x,y,z));
					//TODO: Fix the "contains" part. I shouldn't need to do this check.
					if (result.size () == 0 || !result.contains(resultEntry ))
						result.add (resultEntry);
				}
			}

		}

		return result;
	}


	public static void main(String[] args) {
		ArrayList <Integer> a = new ArrayList <Integer> (Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 ));
		ArrayList <ArrayList <Integer>> result = new ThreeSumZero().threeSum(a);
		System.out.println("---> " + result);


	}

}
