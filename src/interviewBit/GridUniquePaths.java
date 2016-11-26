package interviewBit;
/**
 * 
 * Grid Unique PathsBookmark
A robot is located at the top-left corner of an A x B grid (marked �Start� in the diagram below).



The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked �Finish� in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)
              `
              
              Access Hint (NOTE: MR: I didn't use it. I did dynamic programming instead).
              
There is a mathematical approach to solving this problem.

Note that you have to take m + n - 2 steps in total. You have to take (m - 1) steps going down and (n-1) steps going right.

Let 0 denote a down step and 1 denote a right step.

So we need to find out the number of strings of length m + n - 2 which have exactly m - 1 zeroes and n - 1 ones.

Essentially we need to choose the positions of �1s�, and then �0s� fall into the remaining positions.

So, the answer becomes Choose(m+n-2, n - 1).
 * @author Mario
 *
 */
public class GridUniquePaths {

	public int uniquePaths(int a, int b) {

		if ( a < 1 || b < 1 ) return 1;

		int matrix [] [] = new int [ a ][b];	    
		return getPaths ( a, b, 1, 1, matrix); 

	}

	public int getPaths ( int a, int b, int currentX, int currentY, int [][] matrix){
		//System.out.println ( "Analyzing case " + currentX + " " + currentY);
		if (currentX > a || currentY > b ) return 0;
		if (currentX == a && currentY == b ) return 1;
		if ( matrix [ currentX - 1 ][ currentY - 1] != 0 ) return matrix [ currentX - 1][ currentY - 1];
		int goingX = getPaths ( a, b, currentX + 1, currentY, matrix) ;
		int goingY = getPaths ( a, b, currentX, currentY + 1, matrix); 
		int sum = goingX + goingY;
		matrix [ currentX - 1 ][ currentY - 1] = sum;
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
