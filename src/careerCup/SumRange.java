package careerCup;

import java.util.ArrayList;

class Pair {
	int x;
	int y;

	Pair (int x, int y){
		this.x=x;
		this.y=y;
		//TODO: Pair of numbers in JAva? Entry? Coordinates?
	}
}

/**
 * 
 * https://www.careercup.com/question?id=5768048830054400
 * 
 * Write a function that takes as input an array of integers A, and two integers low and high. 

Your function has to output pairs of indices: {(i,j), ...} 

Where each pair of indices denotes that the subarray of A[i...j] has a sum in the range low <= sum <= high. 

Apparently there are algorithms better than O(N^2).

TODO: Perhaps I could enhance it with DP? A matrix (i, j) with the values from i to j?
 * @author mrincodi
 *
 */
public class SumRange {


	ArrayList <Pair> getPairs ( int min, int max, int [] numbers ){
		if ( min > max) return null;

		ArrayList <Pair> pairs = new ArrayList <Pair> ();

		for ( int i = 0; i < numbers.length; i++){
			int thisSum = 0;
			for ( int j = i; j < numbers.length;j++){
				thisSum += numbers[j];
				if (thisSum >= min && thisSum <= max) pairs.add(new Pair (i, j));
			}
		}
		return pairs;

	}	


	public static void main ( String [] args ){
		int [] values = { 6,8,7,-2,-3,9,0,0,2,-2,-3};
		int min = 4;
		int max = 9;
		ArrayList <Pair> ps = new SumRange().getPairs (min,max,values);

		for ( Pair p: ps){
			System.out.println( p.x + " " + p.y);
		}
	}
}
