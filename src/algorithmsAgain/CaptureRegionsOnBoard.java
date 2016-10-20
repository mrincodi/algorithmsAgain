package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 * @author mrincodi
 * 2016-09-11
 * Comment: Easy, but boundary values were killing me.
 */
public class CaptureRegionsOnBoard {
	int numRows = 0;
	int numCols = 0;

	public void solve(ArrayList<ArrayList<Character>> a) {
		if (a == null || a.size() == 0 || a.get(0).size() == 0 ) return;

		numRows = a.size();
		numCols = a.get(0).size();

		//Now, look for covered regions in the matrix.
		//Which is to say,
		//Go over the borders. If you find a O, cover that region with an indicator 
		// (for example, 'Q'). Then, cover the rest with X.
		//First row:
		for ( int i = 0; i < numCols; i++){
			char c = getChar (a,0,i);
			if ( c == 'O'){
				paint (a, 0, i, 'Q');
			}	        
		}

		//Last row:
		for ( int i = 0; i < numCols; i++){
			char c = getChar (a,numRows - 1,i);
			if ( c == 'O'){
				paint (a, numRows - 1, i, 'Q');
			}	        
		}

		//First column:
		for ( int i = 0; i < numRows; i++){
			char c = getChar (a,i,0);
			if ( c == 'O'){
				paint (a, i, 0, 'Q');
			}	        
		}	    

		//Last column:
		for ( int i = 0; i < numRows; i++){
			char c = getChar (a,i, numCols -1);
			if ( c == 'O'){
				paint (a, i, numCols -1, 'Q');
			}	        
		}	    

		repaint (a);

	}

	private void repaint ( ArrayList<ArrayList<Character>> a){
		for ( int row = 0; row < numRows; row++){
			for ( int col = 0; col < numCols; col++){
				if ( getChar(a,row,col)=='Q')
					putChar(a,row,col,'O');
				else
					putChar(a,row,col,'X');
			}
		}
	}

	private void paint ( ArrayList<ArrayList<Character>> a, int row, int col, char c){
		if ( getChar(a,row,col)=='O'){
			putChar(a,row,col,c);

			//Look at the neighbors.
			if ( row > 0 ) paint (a, row - 1, col, c);
			if ( row < numRows - 1 ) paint (a, row + 1, col, c);
			if ( col > 0) paint (a, row, col - 1, c);
			if ( col < numCols - 1 ) paint (a, row, col + 1, c);

		}
	}

	public char getChar (ArrayList<ArrayList<Character>> a, int x, int y){
		return (a.get(x).get(y));
	}

	private void putChar (ArrayList<ArrayList<Character>> a, int x, int y, char c){
		a.get(x).set(y,c);
	}

	public static Character[] toCharacterArray( String s ) {

		if ( s == null ) {
			return null;
		}

		int len = s.length();
		Character[] array = new Character[len];
		for (int i = 0; i < len ; i++) {
			array[i] = new Character(s.charAt(i));
		}

		return array;
	}




	public static void main(String[] args) {
		//		
		//		char [] qq = new String ( "XOOOOOOX").toCharArray();
		//		Character [] qqw = { 'y', 't'};
		//		 ArrayList<Character> abc = new ArrayList<Character> (Arrays.asList(qqw));
		ArrayList<ArrayList<Character>> a = new  ArrayList<ArrayList<Character>> ();
		
		String [] rows = {"OOX", "OOO", "XXX", "XXX", "XOX", "OXX", "XOO" };
		
		for ( String row:rows){
			a.add(new ArrayList<Character>(Arrays.asList(toCharacterArray(row))));
		}
		
//		a.add(new ArrayList<Character>(Arrays.asList(toCharacterArray("XOOOOOOX"))));
//		a.add(new ArrayList<Character>(Arrays.asList(toCharacterArray("XXOOXOOX"))));
//		a.add(new ArrayList<Character>(Arrays.asList(toCharacterArray("OXXOXOXX"))));
//		
		//a.add(new ArrayList<Character>(Arrays.asList('X','O','X')));
		//a.add(new ArrayList<Character>(Arrays.asList('X','X','X')));
		//a.add(new ArrayList<Character>(Arrays.asList('O')));
		//a.add(new ArrayList<Character>(Arrays.asList()));


		new CaptureRegionsOnBoard().solve(a);
		for ( int i = 0 ; i < a.size(); i++){
			for (int j = 0; j < a.get(0).size(); j++){
				System.out.print(new CaptureRegionsOnBoard().getChar(a,i,j));
			}
			System.out.println();;
		}
	}

}
