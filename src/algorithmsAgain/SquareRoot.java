package algorithmsAgain;

/**
 * Square Root of IntegerBookmark Suggest Edit
Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY

2016-07-07, Thursday.
 * @author Mario
 *
 */
public class SquareRoot {

	public int sqrt(int a) {

		if ( a == 0 ) return 0;
		//I start with half the number.

		boolean found = false;

		long inf = 1;
		long sup = (long) a;
		long la = (long) a;

		while ( !found ){
			long middle = ( sup + inf ) / 2;
			//System.out.println ( "Tengo " + inf + " ," + sup + " y " + middle);

			//System.out.println ( middle);
			long square = middle*middle;

			if ( square == la) return (int) middle;

			if ( square < la ) {
				if ( ( middle + 1) * (middle + 1 ) > la ) return (int) middle;
				else {
					inf = middle + 1;
				}
			}
			else {
				sup = middle - 1;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
