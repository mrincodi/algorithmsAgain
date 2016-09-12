package other;

import java.util.ArrayList;
import java.util.Arrays;

public class MinTrianglePath {

	int smallestPath ( ArrayList < ArrayList <Integer >> triangle ){
		return smallestPath (triangle, 0, 0 );
	}

	private int smallestPath ( ArrayList < ArrayList <Integer >> triangle, int row, int pos ){
		if (triangle.size() == 0 ) return 0;
		if ( row == triangle.size() -1 ) return triangle.get(row).get(pos);

		//get neighbors "down".
		int smallestLeft = smallestPath ( triangle, row + 1, pos );
		int smallestRight = smallestPath ( triangle, row + 1, pos+1 );

		return triangle.get(row).get(pos) + Math.min (smallestLeft, smallestRight);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList < ArrayList <Integer >> triangle = new ArrayList < ArrayList <Integer >> ();
		triangle.add(new ArrayList <Integer> (Arrays.asList(2)));
		triangle.add(new ArrayList <Integer> (Arrays.asList(4,4)));
		triangle.add(new ArrayList <Integer> (Arrays.asList(8,5,6)));
		triangle.add(new ArrayList <Integer> (Arrays.asList(4,2,6,2)));
		triangle.add(new ArrayList <Integer> (Arrays.asList(1,5,2,3,4)));
		
		System.out.println(new MinTrianglePath().smallestPath(triangle));
		
	}

}
