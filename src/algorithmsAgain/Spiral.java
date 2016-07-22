package algorithmsAgain;

// Still not OK.

public class Spiral {

	public static void printSpiral ( int [][] m ){
		if ( m.length == 0 || m.length %2 == 0 ) return;

		for ( int index = 0; index < m.length/2 - 1; index++){
			System.out.println ("\nx1");
			for ( int i = index; i < m.length - index; i++ )
				System.out.print ( m [ index ][ i ] + " ");
				
			System.out.println ("\nx2");
			
			for ( int i = index + 1; i < m.length - index; i++ )
				System.out.print ( m [ i ][ m.length - index - 1 ] + " ");

			System.out.println ("\nx3");

			for ( int i = index + 2; i < m.length - index + 1; i++ )
				System.out.print ( m [ m.length - index - 1 ][ m.length - index - i  ] + " ");

			System.out.println ("\nx4");

			for ( int i = index + 2; i < m.length - index ; i++ )
				System.out.print ( m [ m.length - index - i ][ index ] + " ");

			//System.out.println ();

		}

		System.out.print ( m [ m.length/2 ][m.length/2 ] );
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] m = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{10, 11, 12, 13, 14, 15, 16, 17, 18},
				{19, 20, 21, 22, 23, 24, 25, 26, 27},
				{28, 29, 30, 31, 32, 33, 34, 35, 36},
				{37, 38, 39, 40, 41, 42, 43, 44, 45},
				{46, 47, 48, 49, 50, 51, 52, 53, 54},
				{55, 56, 57, 58, 59, 60, 61, 62, 63},
				{64, 65, 66, 67, 68, 69, 70, 71, 72},
				{73, 74, 75, 76, 77, 78, 79, 80, 81}};
		
		printSpiral ( m );

	}

}
