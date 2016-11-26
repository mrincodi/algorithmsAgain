package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

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
 * 2016-08-09
 * Comment: Sheesh... I took like 2 hours on this simple problem because I 
 * misunderstood that the heights were linked to the infronts. I thought that 
 * the positions of the queue where linked to the infronts!! :( So dismiss this one,
 * mmmkay?
 */
public class OrderOfPeoplesHeightsWrong {



	public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {

		//We create a hash of keys,values for the heights and positions.

		HashMap <Integer, Integer> h = new HashMap <Integer, Integer> ();

		for ( int i = 0 ; i < heights.size(); i++){
			h.put(heights.get(i), infronts.get(i));
		}

		Collections.sort(heights);

		//Create array of empty values, where we'll put the results.
		ArrayList <Integer> current = new ArrayList <Integer> ();
		for ( int i = 0; i < heights.size(); i++){
			current.add (0);
		}

		for ( int pos = 0; pos < heights.size(); pos++){

			//Get the height we'll be working with.
			int thisHeight = heights.get(pos);

			//How many free positions should be before this person?
			int howManyFreePositions = h.get(thisHeight);

			//Look for the right position.
			boolean gotPosition = false;
			int i = 0;
			int counter = 0;
			while (i < current.size() && !gotPosition){
				int val = current.get(i);
				if (val == 0){
					if ( counter == howManyFreePositions)
						gotPosition = true;
					else {
						counter++;
						i++;
					}
				}
				else
					i++;
			}

			//Put the value there! That's it.
			current.set(i, thisHeight);
		}
		
		return current;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> heights = new ArrayList<Integer> (Arrays.asList(1,6,2,3,5,4));
		ArrayList<Integer> infronts = new ArrayList<Integer> (Arrays.asList(1,0,2,2,1,0));

		ArrayList<Integer> result = new OrderOfPeoplesHeightsWrong().order(heights, infronts);

		for (int x: result){
			System.out.println(x);
		}
	}

}
