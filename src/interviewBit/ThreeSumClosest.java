package interviewBit;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

Example: 
given array S = {-1 2 1 -4}, 
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

 */
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumClosest {


	public int threeSumClosest(ArrayList<Integer> a, int b) {

		//Let's sort the arrayList.
		Integer [] array = a.toArray(new Integer [ a.size() ]);

		Arrays.sort (array);

		ArrayList<Integer> a2 = new ArrayList<Integer> ();

		a2.addAll (Arrays.asList ( array ));

		a=a2;

		int closestSum = a.get(0)+a.get(2)+a.get(1);

		int bestAbsDiff = Math.abs ( closestSum - b);

		//	        for ( int i = 0; i < a.size(); i++ )
		//	            System.out.print ( a.get(i) + " " );

		//	        System.out.println ();

		for ( int i = 0; i < a.size () -2; i++ ){
			for ( int j = i+2; j < a.size(); j++ ){

				for ( int k = i+1; k < j ; k++){

					//		                System.out.println ( "i= " + i + 
					//		                ", j=" + j + ", k=" + k);
					//		                System.out.println ( "Testing " + a.get (i) + 
					//		                ", " + a.get(j) + ", " + a.get(k));
					int currentSum = a.get (i) + a.get(j) + a.get(k);

					int newDiff = currentSum - b;

					int newAbsDiff = Math.abs ( currentSum - b);
					//	                    System.out.println ( newDiff );
					if ( newAbsDiff == 0 ) return b;

					if (  newAbsDiff < bestAbsDiff ) {
						bestAbsDiff = newAbsDiff;
						closestSum = currentSum;
					}

					if ( ( currentSum - b ) > 0 ) {
						//	                        System.out.println ("Out!");
						k=j; //leave this cycle
					}
				}
			}
		}
		return closestSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
