package algorithmsAgain;

import java.util.ArrayList;

/**
 * Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

 Note: m and n will be at most 100. 
 
 * @author mrincodi
 * 2016-08-10
 * Comment: Another classic of dynamic programming...
 */
public class UniquePathsInAGrid {

	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
		if ( a.size() ==0 || a.get(0).size() == 0 ) return 0;
		int n = a.size();   //num rows
		int m = a.get(0).size(); // num cols

		int mat[][]=new int [n][m];
		mat[0][0]=1;

		//System.out.println ( "====>" + n );
		for (int i = 0; i < n; i++){
			for ( int j = 0; j < m; j++){
				if (a.get(i).get(j)==1) 
					mat [i][j]=0;
				else {
					if ( i == 0 && j >= 1){
						mat[0][j]=mat[0][j-1];
					}
					if ( i > 0 ){
						if (j == 0) mat[i][j]=mat[i-1][j];
						else
							mat[i][j]=mat[i-1][j]+mat[i][j-1];
					}
				}
				//System.out.print (mat[i][j] + " ");
			}
			//System.out.println ();
		}
		return mat [n-1][m-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
