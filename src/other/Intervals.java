package other;

import java.util.ArrayList;
import java.util.Arrays;


class Pair {
	int x;
	int y;
	Pair (int x, int y){this.x=x; this.y=y;}
}


/**
 * 
You have k lists of sorted integers. Find the smallest range that includes at least one number from each of the k lists. 

For example, 
List 1: [4, 10, 15, 24, 26] 
List 2: [0, 9, 12, 20] 
List 3: [5, 18, 22, 30] 

The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from list 2, and 22 from list 3.

 * 
 * @author mrincodi
 * Comment: This is INCOMPLETE. The good news is that I was right on my solution.
 * 
 */
public class Intervals {

	Pair getSmallestInterval (ArrayList<ArrayList<Integer>> arrays){

		//We need an array of pointers.
		ArrayList <Integer> pointers = new ArrayList <Integer> ();

		for ( int i = 0; i < arrays.size(); i++){
			if (arrays.get(i).size() == 0 ) return null;
			pointers.add (0);
		}

		boolean numbersLeft = true;
		Pair bestPair = null;
		int shortestLength = 0;
		while (numbersLeft){
			//TODO: Find the new smallest one.
			Pair p1 = getNewRange(pointers,arrays);

			int newLength=p1.y - p1.x;

			if ( bestPair == null || newLength < shortestLength ){
				bestPair = p1;
				shortestLength = newLength;
			}
			
			numbersLeft = checkIfNumbersLeft(pointers,arrays);
		}
		return bestPair;
	}

	private boolean checkIfNumbersLeft(ArrayList<Integer> pointers, ArrayList<ArrayList<Integer>> arrays) {
		for ( int i = 0; i < pointers.size(); i++){
			if (arrays.get(i).size()-1 < pointers.get(i) ) return true;
		}
		return false;
	}

	private Pair getNewRange(ArrayList<Integer> pointers, ArrayList<ArrayList<Integer>> arrays) {

		Pair p = new Pair (0,0);

		int smallestNumber = arrays.get(0).get(0);
		int arrayWithSmallest = 0;
		int greatestNumber = arrays.get(0).get(0);
		int arrayWithGreatest = 0;

		for ( int i = 1; i < pointers.size(); i++){
			ArrayList <Integer> array = arrays.get(i);
			int pointer = pointers.get(i);
			int number = array.get(pointer);

			if ( number < smallestNumber ){
				smallestNumber=number;
				arrayWithSmallest=i;
			}

			if ( number > greatestNumber ){
				greatestNumber=number;
				arrayWithGreatest=i;
			}
		}

		p=new Pair (smallestNumber, greatestNumber);
		if ( pointers.get(arrayWithSmallest) < arrays.get(arrayWithSmallest).size()){
			pointers.set(arrayWithSmallest,pointers.get(arrayWithSmallest)+1);
		}

		if ( pointers.get(arrayWithGreatest) < arrays.get(arrayWithSmallest).size()){
			pointers.set(arrayWithGreatest,pointers.get(arrayWithSmallest)+1);
		}

		return p;
	}

	public static void main(String[] args) {
		
		ArrayList < ArrayList <Integer> > arrays = new ArrayList < ArrayList <Integer> > ();
		arrays.add(new ArrayList<Integer>(Arrays.asList(4,10,15,24,26)));
		arrays.add(new ArrayList<Integer>(Arrays.asList(0,9,12,20)));
		arrays.add(new ArrayList<Integer>(Arrays.asList(5,18,22,30)));
		
		Pair p = new Intervals().getSmallestInterval(arrays);
		System.out.println(p.x + "," + p.y);

	}

}
