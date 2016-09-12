package other;

/**
 * 
 * https://www.careercup.com/question?id=5763139615326208
 * A matrix is "Toepliz" if each descending diagonal from left to right is constant. Given an M x N matrix write the method isToepliz to determine if a matrix is Toepliz. 

Example: 
Input: 
67892 
46789 
14678 
01467 

Output: 
True

 * @author mrincodi
 * 2016-08-18
 * Comment: Works.
 */
public class IsToepliz {

	boolean isToepliz ( int [][] matrix ){
		if ( matrix == null ) return false;

		int height = matrix.length;
		if ( height == 0 ) return true;

		int width = matrix[0].length;
		if ( width == 0 ) return true;

		for ( int i = height - 1; i >=0; i-- ){
			int initialValue = matrix [i][0];
			for ( int j = 1; j + i < height && i < width; j++)
				if ( matrix [j+i][j] != initialValue ) 
					return false;				

		}

		//Now, the other diagonals.
		for ( int i = 1; i < width; i++){
			int initialValue = matrix [0][i];
			for ( int j = 1; j + i <height && j < width; j++)
				if ( matrix [j][i+j] != initialValue) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int [] [] matrix = { {6,7,8,9,2}, 
				{4,6,7,8,9 },
				{1,4,6,7,8},
				{0,1,4,6,7}} ;

		System.out.println( new IsToepliz().isToepliz(matrix));


	}

}
