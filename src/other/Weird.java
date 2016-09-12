package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Weird {

	public static void main(String[] args) {
		ArrayList <Integer> sera = new ArrayList <Integer>  ( Arrays.asList(3,4,1,2));
		ArrayList <Integer> sera2 = new ArrayList <Integer>  ( Arrays.asList(3,4,1,2));
		
		HashSet < ArrayList <Integer> > hs = new HashSet < ArrayList <Integer> > ();
		
		hs.add(sera);
		
		//Beautiful. I just learned I don't need to do the dance of the Strings anymore.
		if ( hs.contains(sera2))System.out.println("Whoops!!");
		if ( sera.equals(sera2) )  System.out.println("FRESCO!!");
	}

}
