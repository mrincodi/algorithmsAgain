package other;

import java.util.ArrayList;
import java.util.Arrays;

public class MinTrianglePathDP {

	int smallestPath ( ArrayList < ArrayList <Integer >> triangle ){

		if ( triangle.size() == 0 ) return 0;
		if ( triangle.size() == 1 ) return triangle.get(0).get(0);
				
		for ( int i = 1; i < triangle.size(); i++){
			
			for ( int j = 0; j < i + 1; j++){
				int thisVal = triangle.get(i).get(j);
				int newVal = 0;
				
				if ( j == 0)
					newVal = thisVal + triangle.get(i-1).get(0);
				
				else if ( j == i )
					newVal = thisVal + triangle.get(i-1).get(j-1);
				
				else 
					newVal = thisVal + Math.min(
						triangle.get(i-1).get(j-1),
						triangle.get(i-1).get(j));
				
				triangle.get(i).set(j, newVal);
			}
		}
		
		//Calculate the smallest value at the end.
		int min = triangle.get(triangle.size()-1).get(0);
		for ( int val: triangle.get(triangle.size()-1)){
			min = Math.min(min, val);
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList < ArrayList <Integer >> triangle = new ArrayList < ArrayList <Integer >> ();
		triangle.add(new ArrayList <Integer> (Arrays.asList(2)));
		triangle.add(new ArrayList <Integer> (Arrays.asList(4,4)));
		triangle.add(new ArrayList <Integer> (Arrays.asList(8,5,6)));
		triangle.add(new ArrayList <Integer> (Arrays.asList(4,2,6,2)));
		triangle.add(new ArrayList <Integer> (Arrays.asList(1,5,2,3,4)));
		
		System.out.println(new MinTrianglePathDP().smallestPath(triangle));
		
	}

}
