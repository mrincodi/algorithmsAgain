package interviewBit;
public class Inversions {

	public static int inversions ( int [] array ){
		return inversions ( array, 0, array.length );	// Void errors don't return a value, so don't write "return".
	}

	public static int inversions ( int [] array, int start, int end ){
		int numberOfInversions = 0;
		int length = end - start;		// Declare variable type!
		if (length <= 1) return 0;
		int middle = start + length/2;
		numberOfInversions = inversions ( array, start, middle );
		numberOfInversions += inversions ( array, middle, end );
		numberOfInversions += merge (array, start, end);
		return numberOfInversions;
	}

	public static int merge ( int [] array, int start, int end ){
		int numberOfInversions=0;
		int length = end - start;		// Declare variable type!
		// MR: TODO: �puedo comenzar un arreglo con un tama�o definido en una variable? How to initialize an array?
		// No, I can't.
		//int [length] new_array;
		int [] new_array = new int [ length ];

		// i is the index for the first half of the array, j for the second half.
		//k is the index for the new array.
		int i=start, j=start + length / 2, k = 0;
		for ( k =0 ; k < length; k++){

			if ( i == start + length / 2 ){
				new_array [ k ] = array [ j ];
				j++;
			}		

			else if ( j == end ){
				new_array [ k ] = array [ i ];
				numberOfInversions++;
				i++;
			}

			else if ( array [ i ] <= array [ j ] ){
				new_array [ k ] = array [ i ];
				i++;
			}
			else if ( array [ j ] < array [ i ]){
				new_array [ k ] = array [ j ];
				numberOfInversions++;
				j++;
			}
		}
		for ( k = 0; k < length; k++)
			array [ k + start ] = new_array [ k ];

		return numberOfInversions;
	}
				
public static void main ( String [] args ) {
		int [] array = { 3,7,5,9,1,0,4 };
		//int [] array = { 2,1,3,4 };
		int numberOfInversions = inversions  ( array );
		for ( int i = 0; i < array.length; i++ )
			System.out.print ( array [ i ] + " " );
		
		System.out.println ( "\n" + numberOfInversions );
	}	
}


	


