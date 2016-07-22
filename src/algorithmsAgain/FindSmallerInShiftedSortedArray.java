package algorithmsAgain;

public class FindSmallerInShiftedSortedArray{
	public static int getSmaller ( int [] array, int startPos, int endPos ) throws java.lang.Exception {
		if (startPos >= endPos || startPos <0 || endPos > array.length) throw new java.lang.Exception ();

		if (startPos+1 == endPos ) return array [ startPos ];

		if ( array [ startPos ] < array [ endPos - 1] ) return array [ startPos ];

		int middlePos = startPos + (endPos - startPos) /2;

		if ( array [ startPos] < array [ middlePos ] )
			return getSmaller(array, middlePos , endPos );
		else {
			//You need to check the following! There is no escape.
			if ( array [ middlePos - 1 ] > array [ middlePos ] ) return array [ middlePos ];
			else 	return getSmaller(array, startPos, middlePos );
		}
	}

	public static void main ( String [] args ) throws java.lang.Exception{
		//int [] array = {84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83 };
		
		int [] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,0 };
		int min = FindSmallerInShiftedSortedArray.getSmaller ( array, 0, array.length );
		System.out.println ( min );
	}
}

