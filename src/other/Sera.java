package other;

import java.util.Arrays;

public class Sera {

	public static void main ( String [] args ){

		
		java.util.TreeMap <Integer, java.util.ArrayList <Integer>> tm = 
				new java.util.TreeMap <Integer, java.util.ArrayList<Integer>>(
						java.util.Collections.reverseOrder());
		
		tm.put (5,new java.util.ArrayList<Integer>(Arrays.asList(6,8,2,-2)));
		tm.put (4,new java.util.ArrayList<Integer>(Arrays.asList(3,2,3)));
		tm.put (-7,new java.util.ArrayList<Integer>(Arrays.asList(6)));
		tm.put (0,new java.util.ArrayList<Integer>(Arrays.asList(3,2,1,0)));
		tm.put (-9,new java.util.ArrayList<Integer>(Arrays.asList(-324,990,1)));
		
		for ( java.util.Map.Entry<Integer, java.util.ArrayList<Integer>> e: tm.entrySet()){
			int num = e.getKey();
			java.util.ArrayList <Integer> values = e.getValue();
			System.out.println(num +",  " + values);
		}
	}
}
