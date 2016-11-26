package interviewBit;

import java.util.HashMap;
import java.util.List;

public class Sera {
	// DO NOT MODIFY THE LISTS
	public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {

		HashMap <Integer, Integer> diffsFromB = new  HashMap <Integer, Integer> ();
		HashMap <Integer, Integer> diffsFromA = new  HashMap <Integer, Integer> ();

		outer:
			for ( int i = 0; i < b.size();i++){
				int smallestDiff = Integer.MAX_VALUE;
				inner:
					for ( int j = 0; j < c.size();j++ ){
						int thisDiff = Math.abs(b.get(i)-c.get(j));
						smallestDiff = Math.min (smallestDiff, thisDiff);
						diffsFromB.put (b.get(i), smallestDiff);
						if ( c.get(j) > b.get(i)) continue outer;
					}
			}

		//Now, the differences between a and b:

			outer:
				for ( int i = 0; i < a.size();i++){
					int smallestDiff = Integer.MAX_VALUE;
					inner:
						for ( int j = 0; j < b.size();j++ ){
							int thisDiff = Math.abs(a.get(i)-b.get(j));
							smallestDiff = Math.min (smallestDiff, thisDiff);
							diffsFromB.put (a.get(i), smallestDiff);
							if ( b.get(j) > a.get(i)) continue outer;
						}
				}
			return 0;	            

			//Now, go over the hashMaps.

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
