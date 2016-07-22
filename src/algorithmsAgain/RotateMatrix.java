package algorithmsAgain;

/**
 * Rotate MatrixBookmark
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]

2016-07-06
 */
import java.util.ArrayList;

public class RotateMatrix {


	public int get ( int x, int y, ArrayList<ArrayList<Integer>> a ){
		return a.get(x).get(y);
	}

	public void put ( int x, int y, int val, ArrayList<ArrayList<Integer>> a ){
		a.get(x).set(y,val);
	}

	public void rotate(ArrayList<ArrayList<Integer>> a) {

		if ( a.size() == 0 ) return;

		for ( int onionLevel = 0; onionLevel < a.size () / 2; onionLevel++ ){
			for ( int i = onionLevel ; i < a.size() - onionLevel - 1; i++ ){

				//Let's rotate the values.
				//For easiness, I'll make two methods for get and put.
				int temp =get (onionLevel, i, a);
				int val =0;

				val = get (a.size () - i - 1, onionLevel, a);
				put (onionLevel, i, val, a);

				val = get (a.size () - onionLevel - 1, a.size () - i - 1, a);
				put (a.size () - i - 1, onionLevel, val, a);

				val = get (i, a.size () - onionLevel - 1, a);
				put (a.size () - onionLevel - 1, a.size () - i - 1, val, a);

				put ( i, a.size () - onionLevel - 1, temp, a );
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
