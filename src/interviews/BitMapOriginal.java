package interviews;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 
 * @author mrincodi Rincon (mrincodi)
 * 2016-09-13
 */
class Position {
	int row;
	int col;
	Position (int row, int col ){
		this.row=row;
		this.col=col;
	}
}

public class BitMapOriginal {
	int width;
	int height;
	int [] [] bitmap;

	public BitMapOriginal ( int [][] bitmap ){
		height = bitmap.length;
		width = height > 0 ? bitmap[0].length:0;
		//TODO: should validate that the matrix contains only 0’s and 1’s.
		this.bitmap = bitmap;
	}

	public int getValue (int row, int col ) throws Exception {
		if ( !isValidPos (row,col) ) throw new Exception ();
		return bitmap[row][col];
	}

	public void fill (int row, int col) throws Exception{
		if ( !isValidPos (row,col) ) throw new Exception ();
		if ( getValue (row, col)== 1 ) return;

		//Let’s do a BFS.
		Queue <Position> posQueue = new LinkedList <Position> ();

		posQueue.add (new Position (row, col));

		while (!posQueue.isEmpty()){
			Position thisPos = posQueue.remove();
			bitmap[thisPos.row][thisPos.col]=1;

			//Get all neighbors whose position is zero,
			//and add them to the queue.


			Position [] neighbors = {
					new Position (thisPos.row, thisPos.col - 1),
					new Position (thisPos.row, thisPos.col + 1),
					new Position (thisPos.row - 1, thisPos.col),
					new Position (thisPos.row + 1, thisPos.col)
			};
			
			for ( int i = 0; i < neighbors.length; i++){
				if (isValidPos (neighbors [ i ]) && getValue(neighbors [ i ])==0)
					posQueue.add(neighbors [ i ]);
			}
		}
	}
	
	private int getValue(Position position) throws Exception {
		return getValue (position.row, position.col);
	}

	private boolean isValidPos(Position position) {
		return isValidPos (position.row, position.col);
	}


	public boolean isValidPos (int row, int col ){
		if ( row < 0 || col < 0 || row >= height || col >= width ) return false;
		return true;
	}

	public void print (){
		for ( int row = 0; row < height; row++ ){
			for ( int col= 0; col < width; col++ ){
				if ( bitmap[row][col]==1 ) System.out.print ("#");
				else System.out.print (" ");
			}
			System.out.println ();
		}
	}

	public static void main ( String [] args ) throws Exception{
		//		int [][] bitmap = {	
		//		{1,1,1,1,1,0,1,1,1,1},
		//		{1,0,1,0,1,0,1,0,0,0},
		//		{1,0,1,0,1,0,0,0,0,0},
		//		{1,0,1,1,1,1,1,1,0,0},
		//		{1,1,1,1,0,1,0,0,0,0}};

		int [][] bitmap = {	
				{1,0,0,0,1,0,1,1,1,1},
				{1,0,1,0,1,0,1,0,0,0},
				{1,0,1,0,0,0,0,0,0,0},
				{1,0,1,1,1,1,1,1,0,0},
				{0,1,1,1,0,1,0,0,0,0}};


		BitMapOriginal bm = new BitMapOriginal(bitmap);
		bm.print ();
		bm.fill (1,1);
		System.out.println ();
		bm.print ();
	}
}


