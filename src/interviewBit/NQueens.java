package interviewBit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 * @author mrincodi
 *
 */
public class NQueens {

	public ArrayList<ArrayList<String>> solveNQueens(int a) {

		ArrayList<Integer> board = new ArrayList<Integer> ();


		ArrayList<ArrayList<String>> stringBoards = new ArrayList<ArrayList<String>>  ();

		ArrayList<ArrayList<Integer>> intBoards = solveNQueens( a, board);

		for ( int i = 0; i < intBoards.size();i++){
			ArrayList<Integer> anIntSolution = intBoards.get(i);
			ArrayList<String> aStringSolution = new ArrayList<String> ();

			//For each board, we go row by row.
			for ( int row = 0; row < anIntSolution.size(); row++){
				int col = anIntSolution.get(row);
				StringBuffer sb = new StringBuffer ();
				for ( int colPrint = 0; colPrint < a; colPrint++){
					if (colPrint==col) sb.append("Q");
					else sb.append(".");
				}
				aStringSolution.add(sb.toString());
			}
			stringBoards.add(aStringSolution);
		}
		//TODO: From ArrayList<ArrayList<Integer>> to ArrayList<ArrayList<String>>

		return stringBoards;

	}

	ArrayList<ArrayList<Integer>> solveNQueens(int a, ArrayList<Integer> board) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		if (a == board.size()) return result;

		int myRow = board.size();

		//system.out.println("\n Entering myRow = " + myRow);

		//For the next step of the board, we calculate the possible positions.
		for ( int myCol = 0; myCol < a; myCol++ ){
			//system.out.println("myRow = " + myRow + " and myCol = " + myCol);
			// Let's calculate if we're being attacked at this row and col,
			// by looking at all the other positions.

			boolean attacked = false;
			for ( int otherRow = 0; otherRow < board.size(); otherRow++){
				int otherCol = board.get(otherRow);
				int badCol1 = myCol - (myRow-otherRow);
				int badCol2 = myCol + (myRow-otherRow);

				//Attacked?
				if ( (otherCol == myCol) ||
						(otherCol == badCol1 ) ||
						(otherCol == badCol2 ))
					attacked = true;

			}

			if (!attacked){
				//system.out.println("All-right! Pos. is not attacked!"); 
				//We found a possible one!
				if ( myRow == a - 1){
					//This is a solution!
					//system.out.println("WEPAAAA!");
					board.add(myCol);
					result.add(board);
					return result;
				}
				else {
					//Add current position, run method again and add the
					//response array, if it's not null.
					//system.out.println("Adding position and calling again...");
					ArrayList<Integer> board2 = (ArrayList<Integer>) board.clone();
					board2.add(myCol);

//					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//					try {
//						String input = br.readLine();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}

					ArrayList<ArrayList<Integer>> partialResult = solveNQueens( a, board2);

					//system.out.println("\nI am back at myRow = " + myRow + " and myCol = " + myCol);

					if ( partialResult.size() != 0){
						//system.out.println("WOW! EncontrE una soluciOn!");
						result.addAll(partialResult);

					}
					else {
						//system.out.println("Hmm... Nada.");
					}					
				}

			}

		}


		return result;
	}


	public static void main ( String [] args ){
		int a = 4;
		ArrayList<ArrayList<String>> nq = new NQueens ().solveNQueens(a);

		for ( int i = 0; i < nq.size(); i++){
			ArrayList<String> solution = nq.get(i);
			for ( int j = 0; j < solution.size(); j++){
				System.out.println(solution.get(j));
			}
			System.out.println();
		}
	}
}
