package other;
import java.util.ArrayList;
import java.util.Arrays;

import algorithmsAgain.CaptureRegionsOnBoard;

/**
 * This is just algorithmsAgain.CaptureRegionsOnBoard, again, for practicing. Dismiss.
 * @author mrincodi
 *
 */
public class CROB {

	public void solve(ArrayList<ArrayList<Character>> a) {
		//Find the borders and "color" the patches that touch them, with a special color.

		if (a.size() == 0) return;
		if (a.get(0).size()==0) return;
		//TODO: Test that all arraylists have the same length.

		int length = a.size();
		int width = a.get(0).size();
		for ( int i = 0; i < length; i++){
			paint (a,0,i,'O','A');
			paint (a,length-1,i,'O','A');
		}
		for ( int i = 0; i <width; i++ ){
			paint (a,i,0,'O','A');
			paint (a,i,width - 1,'O','A');
		}
		for ( int i = 1; i < length - 1; i++){
			for (int j = 1; j < width - 1; j++ ){
				paint (a,i,j,'O','X');
			}
		}

		for ( int i = 0; i < length; i++){
			paint (a,0,i,'A','O');
			paint (a,length-1,i,'A','O');
		}
		for ( int i = 0; i <width; i++ ){
			paint (a,i,0,'A','O');
			paint (a,i,width - 1,'A','O');
		}
	}

	private void paint (ArrayList<ArrayList<Character>> a, int row, int col, char before, char after){
		if ( row < 0 || col < 0 || row >= a.size() || col >= a.get(0).size() ) return;
		if (a.get(row).get(col)!= before ) return;
		a.get(row).set(col,after);
		paint(a,row-1,col,before,after);
		paint(a,row,col-1,before,after);
		paint(a,row+1,col,before,after);
		paint(a,row,col+1,before,after);
	}


	
	public static void main(String[] args) {
		//		
		//		char [] qq = new String ( "XOOOOOOX").toCharArray();
		//		Character [] qqw = { 'y', 't'};
		//		 ArrayList<Character> abc = new ArrayList<Character> (Arrays.asList(qqw));
		ArrayList<ArrayList<Character>> a = new  ArrayList<ArrayList<Character>> ();
		
		String [] rows = {"OOX", "OOO", "XXX", "XXX", "XOX", "XOX", "XXO" };
		
		for ( String row:rows){
			a.add(new ArrayList<Character>(Arrays.asList(CaptureRegionsOnBoard.toCharacterArray(row))));
		}
		
//		a.add(new ArrayList<Character>(Arrays.asList(toCharacterArray("XOOOOOOX"))));
//		a.add(new ArrayList<Character>(Arrays.asList(toCharacterArray("XXOOXOOX"))));
//		a.add(new ArrayList<Character>(Arrays.asList(toCharacterArray("OXXOXOXX"))));
//		
		//a.add(new ArrayList<Character>(Arrays.asList('X','O','X')));
		//a.add(new ArrayList<Character>(Arrays.asList('X','X','X')));
		//a.add(new ArrayList<Character>(Arrays.asList('O')));
		//a.add(new ArrayList<Character>(Arrays.asList()));


		new CROB().solve(a);
		for ( int i = 0 ; i < a.size(); i++){
			for (int j = 0; j < a.get(0).size(); j++){
				System.out.print(new CaptureRegionsOnBoard().getChar(a,i,j));
			}
			System.out.println();;
		}
	}
}
