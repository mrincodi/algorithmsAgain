package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MaxSumWithoutAdjacentElements {


	public int adjacent(ArrayList<ArrayList<Integer>> a) {

		if (a == null || a.get(0).size()==0) return 0;

		//Let's create a single arrayList! (duh!)
		ArrayList <Integer> al = new ArrayList < Integer >();

		for ( int i = 0; i < a.get(0).size();i++){
			al.add(Math.max(a.get(0).get(i),a.get(1).get(i)));
		}

		//And now...
		int [] maxSumIncludingIArray = new int [ al.size()];
		int [] maxSumNotIncludingIArray = new int [ al.size()];
		int max = 0;
		for ( int i = 0; i < al.size(); i++ ){
			int xa = calculateMaxSumIncludingI (al, i, maxSumIncludingIArray, maxSumNotIncludingIArray);   
			int xb = calculateMaxSumNotIncludingI (al, i, maxSumIncludingIArray, maxSumNotIncludingIArray);

			max = Math.max (xa,max);

		}
		return max;
	}

	private int calculateMaxSumNotIncludingI(ArrayList<Integer> al, int i, int[] maxSumIncludingIArray,
			int[] maxSumNotIncludingIArray) {
		if ( i == 0 ) return 0; //Shouldn't matter.

		if ( i == 1 ) {
			maxSumNotIncludingIArray[1]=al.get(1);
		}
		
		maxSumNotIncludingIArray[i] = Math.max(maxSumIncludingIArray[i-1], maxSumNotIncludingIArray[i-1]);
		return maxSumNotIncludingIArray[i];
	}

	private int calculateMaxSumIncludingI(ArrayList<Integer> a, int i, int[] maxSumIncludingIArray, int [] maxSumNotIncludingIArray) {
		if ( i == 0 ){
			maxSumIncludingIArray[0]=a.get(0);
			return a.get(0);
		}
		
		if ( i == 1 ){
			maxSumIncludingIArray[1]=a.get(1);
			return a.get(1);
		}
		
		int val1 = maxSumNotIncludingIArray[i-1] + a.get(i);
		maxSumIncludingIArray[i]=val1;
		
		return val1;
	}
	
	
	public static void main ( String [] args ){


		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>> ();
		
		a.add(new ArrayList<Integer>(Arrays.asList(5,7,4,3)));
		a.add(new ArrayList<Integer>(Arrays.asList(9,4,6,1)));
		
		int sera = new MaxSumWithoutAdjacentElements().adjacent(a);
		
		System.out.println(sera);
	}


}
