package interviewBit;

public class QuickSort {
	public static void quicksort ( int [] array ){
		quicksort (array, 0, array.length );
	}

	public static void quicksort ( int [] array, int start, int end ){

		if ( end - start <= 1 || start < 0 || end > array.length ) return ; //Attention to bound cases!

		// Take a random pivot position.
		//int r = getRandomNumber (start, end );

		int pivotPosition = start + new java.util.Random().nextInt (end - start); // Start - end vs. end - start!
		//pivotPosition=1;
		int pivotValue = array [ pivotPosition ];
		int smallerElements [] = new int [ array.length ];
		int greaterElements [] = new int [ array.length ];
		int smallerElementsIndex = 0;
		int greaterElementsIndex = 0;

		System.out.println(pivotValue);
		for ( int i = start; i < end; i++ ){
			if ( array [ i ] < pivotValue )
				smallerElements [ smallerElementsIndex++ ] = array [ i ];
			else if ( array [ i ] > pivotValue )
				greaterElements [ greaterElementsIndex++ ] = array [ i ];
		}
		int i = 0;
		for ( i = 0; i < smallerElementsIndex; i++ ){
			array [ start + i ] =  smallerElements [ i ];
		}
		array [ start + smallerElementsIndex ] = pivotValue;	//Never assign an array to a value of itself, when you;re playing with the same array!
															//You were assuming that the program would always get into the previous loop.
															//so don't ever work with indexes outside loops. Better to have variables for the limits.
															// Also, if you are working with sub-arrays, remember to always add the start segment to the array position you're working with! 
		for ( i = 0; i < greaterElementsIndex; i++ ){
			array [ start + smallerElementsIndex + 1 + i ] =  greaterElements [ i ];
		}

		quicksort ( array, start, start + smallerElementsIndex );
		quicksort ( array, start + smallerElementsIndex+1, end );
	}

	public static void main ( String [] args ){
		int [] array = { 7,5,6,8,4,3,9,1,2,0 };
		
		quicksort ( array );
		for ( int i = 0; i < array.length; i++ )
			System.out.print ( array [ i ] + " ");

	}
}

