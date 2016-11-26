package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Max Rectangle in Binary MatrixBookmark Suggest Edit
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0 
    ]

Output : 4 

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)

 * @author mrincodi
 * Comment: I was in the right track. Got help from the hints.
 * Partial solutions should be used to add up to the final solution afterwards.
 */
public class MaxRectangleInBinaryMatrix {

	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
		if ( a.size() == 0 || a.get(0).size()==0) return 0;

		int rows =a.size();
		int cols = a.get(0).size();

		int [] [] maxFromHereInRow = new int [rows][cols];

		//First we fill up the rectangle of "best rows".
		for ( int i = 0; i < rows; i++){
			int j = 0;
			while ( j < cols){
				if (a.get(i).get(j)==0) {
					maxFromHereInRow[i][j]=0;
					j++;
				}

				else {
					int num1sInRow=0;

					int k = j;
					while (k < cols && a.get(i).get(k)==1){
						num1sInRow++;
						k++;
					}

					for ( k = j;num1sInRow>=1;k++){
						maxFromHereInRow[i][j]=num1sInRow;
						num1sInRow--;
						j++;
					}
					
//					System.out.println(i + "," + j);
					
				}
			}
		}

//		System.out.println ( "Hey!");
		//Now, let's use this matrix to get the largest rectangle.
		int bestArea=0;
		for ( int i = 0; i < rows; i++){
			for ( int j = 0; j < cols; j++){
				if (maxFromHereInRow[i][j]!=0){
					//Go down!
					int widthSoFar = maxFromHereInRow[i][j];
					int bestAreaSoFar = widthSoFar;

					int y = i + 1; //We'll go down until we find a zero.

					while ( y < rows && maxFromHereInRow[y][j] != 0){
						int thisWidth = maxFromHereInRow[y][j];
						widthSoFar = Math.min (widthSoFar, thisWidth);
						int thisArea = widthSoFar * (y-i + 1);
						bestAreaSoFar = Math.max (thisArea, bestAreaSoFar);

						y++;
					}
					bestArea=Math.max(bestAreaSoFar,bestArea);

				}
			}
		}
		return bestArea;
	}


	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>>al =new ArrayList<ArrayList<Integer>> ();
		
		al.add(new ArrayList <Integer>(Arrays.asList(1,1,0,1)));
		al.add(new ArrayList <Integer>(Arrays.asList(1,0,0,1)));
		al.add(new ArrayList <Integer>(Arrays.asList(1,1,1,0)));
		al.add(new ArrayList <Integer>(Arrays.asList(1,1,1,1)));
		
		int area = new MaxRectangleInBinaryMatrix().maximalRectangle(al);
		
		System.out.println(area);
		
		// TODO Auto-generated method stub

	}

}
