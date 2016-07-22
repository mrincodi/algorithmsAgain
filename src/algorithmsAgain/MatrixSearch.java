package algorithmsAgain;

/**
 * Matrix Search
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem

mrincodi, 2016-07-06
 */
import java.util.ArrayList;

public class MatrixSearch {


	void printy (String s ){
		//System.out.println ( s);
	}
	public int get ( int pos, ArrayList<ArrayList<Integer>> a){
		int numCols = a.get(0).size();
		int row = pos / numCols;
		int col = pos % numCols;
		printy ( "Para " + pos + " tengo row " + row  + " y col " + col );
		return a.get(row).get(col);
	}

	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

		int howMany = a.size() * a.get(0).size();

		printy( "Tengo " + howMany + "elementos ");

		int inf = 0, sup = howMany - 1;

		int pos = ( sup + inf )  / 2;
		while ( inf <= sup && inf >= 0 && sup < howMany){

			pos = ( sup + inf ) / 2;
			printy ( "Y pos vale " + pos );
			int val = get ( pos, a );

			if ( val == b ) return 1;

			if ( val > b ) // Go to the left.
				sup = pos - 1;
			else
				inf = pos + 1;
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
