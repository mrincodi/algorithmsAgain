package algorithmsAgain;

import java.util.ArrayList;

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
 * Comment: The obvious solution. I am using two arrays (left and right sides).
 *
 */
public class LargestRectangleInHistogramSlow {

	
		public int largestRectangleArea(ArrayList<Integer> a) {
		    
		    if ( a.size () == 0 ) return 0;
		    if ( a.size () == 1 ) return a.get(0);
		    
		    int [] leftArray = new int [ a.size() ];
		    int [] rightArray = new int [ a.size () ];
		    
		    for ( int i = 1; i < a.size(); i++){
		        int thisHeight = a.get(i);
		        int j = i - 1;
		        int numHigher = 0;
		        while (j >= 0 && a.get(j) >= thisHeight ) {
		            j--;
		            numHigher++;
		        }
		        leftArray[i]=numHigher;
		    }

		    for ( int i = 0; i < a.size() - 1; i++){
		        int thisHeight = a.get(i);
		        int j = i+1;
		        int numHigher = 0;
		        while (j < a.size () && a.get(j) >= thisHeight ) {
		            j++;
		            numHigher++;
		        }
		        rightArray[i]=numHigher;
		    }
		    
		    //Now, join the values and choose the largest.
	        int largest = 0;
		    for ( int i = 0; i < a.size(); i++){
		        int thisSum = a.get(i) * (leftArray [i] + rightArray[i] + 1);
		        largest = Math.max (thisSum, largest);
		    }
		    
		    return largest;
		    
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
