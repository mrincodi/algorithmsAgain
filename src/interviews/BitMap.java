package interviews;

import java.util.Queue;
import java.util.LinkedList;

//Bitmaps... With bits!

class APosition {
	int row;
	int col;
	APosition (int row, int col ){
		this.row=row;
		this.col=col;
	}
}

public class BitMap {
	
	int width;
	int height;
	private int realWidth;
	byte [] [] bitmap;
	

	public BitMap ( int [][] intBitmap ) throws Exception{
		height = intBitmap.length;
		width = height > 0 ? intBitmap[0].length:0;
		if ( height == 0 ) realWidth = 0;
		else realWidth = intBitmap[0].length / 8 + (intBitmap[0].length % 8 == 0?0:1);

		bitmap = new byte [height][realWidth];
		
		for ( int row = 0; row < height; row++){
			for ( int col = 0; col < width; col++ ){
				int value = intBitmap[row][col];
				if ( value != 0 && value != 1 )throw new Exception ("The matrix must have only 0's and/or 1's");
				boolean bValue = value==1;
				setValue (bValue,row,col);
			}
		}
	}

	public void setValue(boolean value, int row, int col) throws Exception {
		if ( !isValidPos (row,col) ) throw new Exception ();
		
		//Get the byte, change it and put it back.
		byte oldByte = bitmap[row][col/8];
		if (value) 
			oldByte |= ( 1 << col % 8 );
		else
			oldByte &= ~(1 << col % 8);

		bitmap[row][col/8] = oldByte;
	}

	public int getValue (int row, int col ) throws Exception {
		if ( !isValidPos (row,col) ) throw new Exception ();
		return bitmap[row][col/8]>>(col%8)&1;
	}

	public void fill (int row, int col) throws Exception{

		if ( !isValidPos (row,col) ) throw new Exception ("Invalid position for the bitmap");
		if ( getValue (row, col)== 1 ) return;

		setValue(true,row,col);
		//Let’s do a BFS.
		Queue <APosition> posQueue = new LinkedList <APosition> ();

		posQueue.add (new APosition (row, col));

		while (!posQueue.isEmpty()){
			APosition thisPos = posQueue.remove();
			//setValue(true,thisPos.row,thisPos.col);

			//Get all neighbors whose position is zero,
			//and add them to the queue.

			APosition [] neighbors = {
					new APosition (thisPos.row, thisPos.col - 1),
					new APosition (thisPos.row, thisPos.col + 1),
					new APosition (thisPos.row - 1, thisPos.col),
					new APosition (thisPos.row + 1, thisPos.col)
			};
			
			for ( int i = 0; i < neighbors.length; i++){
				if (isValidPos (neighbors [ i ]) && getValue(neighbors [ i ])==0){
					setValue(true,neighbors [ i ]);

					posQueue.add(neighbors [ i ]);
				}
			}
		}
	}

	private void setValue(boolean b, APosition aPosition) throws Exception {
		setValue (b, aPosition.row, aPosition.col);
		
	}

	private int getValue(APosition position) throws Exception {
		return getValue (position.row, position.col);
	}

	private boolean isValidPos(APosition position) {
		return isValidPos (position.row, position.col);
	}

	public boolean isValidPos (int row, int col ){
		return !( row < 0 || col < 0 || row >= height || col >= width );
	}

	public void print () throws Exception{
		for ( int row = 0; row < height; row++ ){
			for ( int col= 0; col < width; col++ ){
				if ( getValue(row,col)==1 ) System.out.print ("#");
				else System.out.print (" ");
			}
			System.out.println ();
		}
	}

	public static void main ( String [] args ) throws Exception{
		
		int [][] bitmap = {	
				{1,1,1,1,1,0,1,1,1,1},
				{1,0,1,0,1,0,1,0,0,0},
				{1,0,1,0,1,0,0,0,0,0},
				{1,0,1,1,1,1,1,1,0,0},
				{1,1,1,1,0,1,0,0,0,0}};

//		int [][] bitmap = {	
//				{1,0,0,0,1,0,1,1,1,1},
//				{1,0,1,0,1,0,1,0,0,0},
//				{1,0,1,0,0,0,0,0,0,0},
//				{1,0,1,1,1,1,1,1,0,0},
//				{0,1,1,1,0,1,0,0,0,0}};

		BitMap bm = new BitMap(bitmap);
		bm.print ();
		bm.fill (1,1);
		System.out.println ();
		bm.print ();
	}
}


