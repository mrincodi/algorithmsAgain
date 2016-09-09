package algorithmsAgain;

import java.util.ArrayList;
import java.util.Collections;

/**
 * There are N Mice and N holes are placed in a straight line. 
Each hole can accomodate only 1 mouse. 
A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consumes 1 minute.
Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

Example:

positions of mice are:
4 -4 2
positions of holes are:
4 0 5

Assign mouse at position x=4 to hole at position x=4 : Time taken is 0 minutes 
Assign mouse at position x=-4 to hole at position x=0 : Time taken is 4 minutes 
Assign mouse at position x=2 to hole at position x=5 : Time taken is 3 minutes 
After 4 minutes all of the mice are in the holes.

Since, there is no combination possible where the last mouse's time is less than 4, 
answer = 4.
Input:

A :  list of positions of mice
B :  list of positions of holes
Output:

single integer value
 NOTE: The final answer will fit in a 32 bit signed integer. 
 
 * @author mrincodi
 * 2016-09-08
 * Comment: Very easy. I first thought about a crazy recursive method, 
 * but if entries are sorted, it's trivial.
 *
 */
public class AssignMiceToHoles {

	public int mice(ArrayList<Integer> mice, ArrayList<Integer> holes) {
		Collections.sort(mice);
		Collections.sort(holes);

		int maxDistance = Integer.MIN_VALUE;
		for (int i=0;i<mice.size();i++){
			int mouse = mice.get(i);
			int hole = holes.get(i);
			int distance = Math.abs (mouse - hole);
			maxDistance=Math.max(maxDistance, distance);
		}
		return maxDistance;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
