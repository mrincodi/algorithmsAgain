package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Max Continuous Series of 1s
You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.

 * @author mrincodi
 *
 */
public class MaxContinuousSeriesof1s {
	public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
		ArrayList<Integer> best = new  ArrayList<Integer> ();

		int i = 0;
		while (i < a.size()){
			//System.out.println ( "Entro. i vale " + i);
			ArrayList<Integer> current = new  ArrayList<Integer> ();
			int j = i;
			boolean endIt=false;
			int leftToFlip=b;
			int newI = i;
			while ( j < a.size() && !endIt){
				//System.out.println ( "j vale " + j);
				if (a.get(j)==1) current.add(j);
				else {
					if ( leftToFlip == 0 ){
						endIt = true;
					}
					else {
						if ( leftToFlip == b ){
							//We move the pointer of i 
							//to the next position after the first zero found,
							newI=j+1;
						}
						//but in any case...
						current.add(j);
						leftToFlip--;
					}
				}
				j++;
			}
			if ( j == a.size())  i = a.size(); // let's get out of here.
			else if ( newI==i) i++; // b=0 and this was a 0.
			else i=newI;
			
			if ( current.size () > best.size() )
				best = current;
		}

		return best;
	}

	public static void main(String[] args) {
		ArrayList <Integer>  al = new ArrayList <Integer> ( Arrays.asList(0,1,1,1,0,0,1,0,1,1,1,1,1,0,0,0,0,0));
		
		ArrayList <Integer>  result = new MaxContinuousSeriesof1s ().maxone(al, 3);
		
		for ( int i = 0; i < result.size(); i++ )
			System.out.println("--> "+ result.get(i));
		// TODO Auto-generated method stub

	}

}
