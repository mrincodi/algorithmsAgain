package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * You are given the following :

A positive number N
Heights : A list of heights of N persons standing in a queue
Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
You need to return list of actual order of persons’s height

Consider that heights will be unique

Example

Input : 
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
Output : 
actual order is: 5 3 2 1 6 4 
So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

You can do similar inference for other people in the list.

 * @author mrincodi
 *
 */
public class OrderOfPeoplesHeights {

	
	
		public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
		    
		    Collections.sort(heights);
		    
		    //Create array of empty values
		    ArrayList <Integer> current = new ArrayList <Integer> ();
		    for ( int i = 0; i < heights.size(); i++){
		        current.add (0);
		    }
		    return order (heights,infronts,current);
		}
		
		public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts, ArrayList<Integer> current) {     

	        //Count how many zeros are in the current list.
	        int pos=0;
	        for ( int i = 0; i < heights.size(); i++ ){
	            if ( current.get(i)!=0) pos++;
	        }
	        
	        if ( pos == heights.size()) return current; //We're done.
	        
	        //Get the height we'll be working with.
	        int thisHeight = heights.get(pos);
	        
	        //Look for the next available positions.
	        int occupiedPositions = 0;
	        for ( int i = 0; i < current.size();i++){
	            if (current.get(i)== 0){//Let's consider this position.
	                if (infronts.get(i)-occupiedPositions == i){
	                    //This is a possibility.
	                    //Create a new current array and call the method again.
	                    ArrayList<Integer> current2 = new ArrayList<Integer> (current);
	                    current2.set(i,thisHeight);
	                    ArrayList<Integer> current3 = order  (heights,infronts,current2);
	                    if ( current3 != null ) return current3;
	                }
	            }
	            else {
	                occupiedPositions++;
	            }
	        }
	        return null;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> heights = new ArrayList<Integer> (Arrays.asList(86,77));
		ArrayList<Integer> infronts = new ArrayList<Integer> (Arrays.asList(0,1));
		
		
		
		ArrayList<Integer> result = new OrderOfPeoplesHeights().order(heights, infronts);

		for (int x: result){
			System.out.println(x);
		}
	}

}
