package algorithmsAgain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
 * Comment: With a BFS. Adding the node to "already" breaks InterviewBit in //1 but not in //2.
 * Notice that adding it to "already" as soon as we add them to the queue is the optimal way.
 *
 */
class Position{
	int x;
	int y;
	Position (int x, int y){
		this.x=x;
		this.y=y;
	}
	
	@Override
    public boolean equals(Object obj) {
		//System.out.println("Wepa");
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return false;
        if (this == obj)
            return true;
        Position node = (Position) obj;
        if (this.x == node.x && this.y == node.y)
            return true;
        return false;
    }
	
	// Woooow. Creepy. I should probably memorize this.
	// This is needed when using contains in a hashset of this type, because if the hashcode is different, it
	// won't even run equals.
    @Override
    public int hashCode() {
        return (int) ((31 * x + y) & 0x7fffffff);
    }

	public boolean isValid(int n, int m) {
		return (this.x >= 1 && this.y >= 1 && this.x <= n && this.y <= m);
	}

	public void print (){
		System.out.println(this.x + "," + this.y);
	}
}
public class KnightOnChessBoard {

	public int knight(int N, int M, int x1, int y1, int x2, int y2) {

		if (x1 == x2 && y1 == y2) return 0;

		Position start = new Position(x1,y1);
		Position end = new Position(x2,y2);

		HashSet <Position> already = new HashSet <Position>();
		Queue <Position> q = new LinkedList <Position>();

		q.add(start);
		q.add(null);
		already.add(start);
		int level = 0;

		while (!q.isEmpty()){
			Position p = q.remove();
			// already.add(p);	//1
			//if ( p != null ) p.print();

			if (p!= null){
				if ( p.equals(end)) return level;
				else {
					ArrayList <Position> nextPositions = new ArrayList <Position>();
					nextPositions.add(new Position (p.x - 2,p.y -1));
					nextPositions.add(new Position (p.x - 1,p.y -2));
					nextPositions.add(new Position (p.x - 2,p.y +1));
					nextPositions.add(new Position (p.x - 1,p.y +2));
					nextPositions.add(new Position (p.x + 2,p.y -1));
					nextPositions.add(new Position (p.x + 1,p.y -2));
					nextPositions.add(new Position (p.x + 2,p.y +1));
					nextPositions.add(new Position (p.x + 1,p.y +2));

					for ( Position nextP: nextPositions){
						if (nextP.isValid (N,M) && !already.contains(nextP)){
							already.add(nextP);	//2
							q.add(nextP);
						}
					}
				}
			}
			else {
				level++;
				if ( !q.isEmpty()) q.add(null);
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int n = new KnightOnChessBoard().knight(2,20,1,18,1,5);
		System.out.println(n);

	}

}
