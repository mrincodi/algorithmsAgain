package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Example Histogram

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Example2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.

 * @author mrincodi
 * 2016-09-18
 * Comment: This is a beautiful solution from https://www.youtube.com/watch?v=VNbkzsnllsU
 * and some thinking. Not obvious by any means. Use two stack: one for starting points
 * of rectangles, and another one for heights. Start from the left. If the current height
 * is larger than the current one in the stack (or the 
 * 
 * 
 *
 */
public class LargestRectangleInHistogram {


	public int largestRectangleArea(ArrayList<Integer> a) {

		Stack <Integer> starts = new Stack <Integer > ();
		Stack <Integer> heights = new Stack <Integer > ();

		int maxArea = 0;

		a.add(0);	// For the final calculation!

		for ( int i = 0; i < a.size(); i++){
			int thisHeight = a.get(i);
			if ( starts.isEmpty() || thisHeight > heights.peek()){
				starts.push(i);
				heights.push(thisHeight);
			}
			else if ( thisHeight < heights.peek()){
				// The rectangle at the top of the stack just "died",
				//so calculate its area.
				int previousArea = heights.pop() * (i - starts.peek());
				maxArea = Math.max(maxArea,  previousArea);


				//Finally, put the new height in it's right place.

				while (!heights.isEmpty() && heights.peek() >= thisHeight){
					starts.pop();
					
					previousArea = heights.pop() * (i - starts.peek());
					maxArea = Math.max(maxArea,  previousArea);
					
				}
				heights.push(thisHeight);
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		ArrayList <Integer> a = new ArrayList <Integer> (Arrays.asList(5,6,4,2,4,7,1));
		int area = new LargestRectangleInHistogram().largestRectangleArea(a);
		System.out.println(area);

	}

}
