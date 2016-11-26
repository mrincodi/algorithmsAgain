package interviewBit;

import java.util.HashSet;
import java.util.List;


/**
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.



The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

 Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 * @author mrincodi
 * 2016-08-01
 * Comment: OK, this was really easy.
 */
public class ValidSudoku {

	public int isValidSudoku(final List<String> a) {
		//Check rows.
		HashSet <Character> set = new HashSet <Character> ();
		for ( String row : a ){
			set = new HashSet <Character> ();
			for ( int i = 0; i < 9; i++){
				char n = row.charAt(i);
				if (n != '.'){
					if (set.contains(n)) return 0;
					set.add (n);
				}
			}
		}

		//Check columns.
		for ( int col = 0; col < 9; col++){
			set = new HashSet <Character> ();
			for ( int row = 0; row < 9; row++){
				char n = a.get(row).charAt(col);
				if (n != '.'){
					if (set.contains(n)) return 0;
					set.add (n);
				}
			}
		}

		//Check boxes.
		for ( int boxStartRow = 0; boxStartRow < 9; boxStartRow+=3){
			for ( int boxStartCol = 0; boxStartCol < 9; boxStartCol+=3){
				set = new HashSet <Character> ();
				for ( int row = boxStartRow; row < boxStartRow + 3; row++){
					for ( int col = boxStartCol; col < boxStartCol + 3; col++){
						char n = a.get(row).charAt(col);
						if (n != '.'){
							if (set.contains(n)) return 0;
							set.add (n);
						}
					}      
				}
			}	        
		}
		return 1;
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
