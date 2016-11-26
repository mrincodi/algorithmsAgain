package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * Knight movement on a chess board

Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination or not.

Knight's movements

The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.

If yes, then what would be the minimum number of steps for the knight to move to the said point.
If knight can not move from the source point to the destination point, then return -1

Input:

N, M, x1, y1, x2, y2
where N and M are size of chess board
x1, y1  coordinates of source point
x2, y2  coordinates of destination point
Output:

return Minimum moves or -1
Example

Input : 8 8 1 1 8 8
Output :  6

 * @author mrincodi
 * 2016-10-20
 * Comment: This doesn't work right. For example, it fails with
 * 13,17,8,9,4,6
 * It should give 3 but this gives 5.
 * I think the reason is because I am doing a DFS instead of a BFS.
 * Instead of debugging this even more, I'm going to try with a BFS, which is the 
 * right way.
 *
 */
public class KnightOnChessBoardWrong {
	HashMap <ArrayList<Integer>, Integer> already = 
			new HashMap <ArrayList<Integer>, Integer>();

	public int knight(int N, int M, int x1, int y1, int x2, int y2) {
		return knight (N,M,x1,y1,x2,y2,new HashSet<ArrayList<Integer>>());
	}

	public int knight(int N, int M, int x1, int y1, int x2, int y2, HashSet<ArrayList<Integer>> prevPos) {
		if ( x1 == 7  && y1 == 7 ) 
			System.out.println("What");

		if ( x1 == 6  && y1 == 5 ) 
			System.out.println("Wh00");
		
		if ( prevPos.contains (new ArrayList<Integer>(Arrays.asList(x1, y1)))) return -1;
		prevPos.add(new ArrayList<Integer>(Arrays.asList(x1, y1)));

		if ( already.containsKey (new ArrayList<Integer>(Arrays.asList(x1, y1))))
			return  already.get(new ArrayList<Integer>(Arrays.asList(x1, y1)));

		int result = Integer.MAX_VALUE;
		if ( x1==x2 && y1==y2) {
			already.put(new ArrayList<Integer>(Arrays.asList(x1, y1)),0);
			return 0;
		}

		ArrayList < ArrayList < Integer> > positions = new ArrayList < ArrayList < Integer> > ();
		positions.add (new ArrayList<Integer>(Arrays.asList(x1-1,y1+2)));
		positions.add (new ArrayList<Integer>(Arrays.asList(x1-2,y1+1)));
		positions.add (new ArrayList<Integer>(Arrays.asList(x1-2,y1-1)));
		positions.add (new ArrayList<Integer>(Arrays.asList(x1-1,y1-2)));
		positions.add (new ArrayList<Integer>(Arrays.asList(x1+1,y1-2)));
		positions.add (new ArrayList<Integer>(Arrays.asList(x1+2,y1-1)));
		positions.add (new ArrayList<Integer>(Arrays.asList(x1+1,y1+2)));
		positions.add (new ArrayList<Integer>(Arrays.asList(x1+2,y1+1)));

		for (int i = 0; i < positions.size(); i++ ){
			int x = positions.get(i).get(0);
			int y = positions.get(i).get(1);
			if ( x >= 1 && x <= N && y >= 1 && y <= M ){

				HashSet<ArrayList<Integer>> newprevPos = new HashSet<ArrayList<Integer>>(prevPos);
				//newprevPos.add (new ArrayList<Integer>(Arrays.asList(x,y)));

				int numPos = knight (N,M,x,y,x2,y2,newprevPos);

				if ( numPos != -1){
					result = Math.min (result, 1 + numPos);
				}
			}
		}

		if ( result == Integer.MAX_VALUE) result = -1;
		already.put(new ArrayList<Integer>(Arrays.asList(x1, y1)),result);
		
		if ( x1 == 6  && y1 == 5 ) 
			System.out.println("Wh00");
		return result;
	}

	public static void main(String[] args) {
		int n = new KnightOnChessBoardWrong().knight(13,17,8,9,4,6);
		System.out.println(n);

	}

}
