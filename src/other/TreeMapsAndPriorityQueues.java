package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Let's test:
 * Comparable interfaces.
 *    Making a class with a comparable interface and sorting it.
 *    Using priority queues with a comparator.
 *    Using treesets
 * @author mrincodi
 *
 */
class StringBackwards implements java.lang.Comparable <StringBackwards>{

	String s;

	public StringBackwards (String s){
		super();
		this.s=s;
	}

	@java.lang.Override
	public int compareTo ( StringBackwards other ){

		//Put the string backwards.
		char [] ca = s.toCharArray();

		for ( int i = 0; i < ca.length/2; i++){
			char temp = ca [ i ];
			ca [ i ] = ca [ ca.length - i -1];
			ca [ ca.length - i -1]=temp;
		}

		String sReversed = new String (ca);

		ca = other.s.toCharArray();
		//Put the other string backwards.
		for ( int i = 0; i < ca.length /2; i++){
			char temp = ca [ i ];
			ca [ i ] = ca [ ca.length - i -1];
			ca [ ca.length - i -1]=temp;
		}

		String otherReversed = new String (ca);
		return sReversed.compareTo (otherReversed);

	}	
}

public class TreeMapsAndPriorityQueues {

	public static void main (String [] args){
		StringBackwards s = new StringBackwards ("gaseosazzz");
		StringBackwards t = new StringBackwards ("empanada");

		System.out.println("Sorting an array...");
		StringBackwards [] sArray = new StringBackwards [2]  ;

		sArray[0]=s;
		sArray[1]=t;

		java.util.Arrays.sort(sArray);

		for ( int i = 0; i< sArray.length;i++){
			System.out.println(sArray[i].s);
		}

		System.out.println("\n");
		System.out.println("Sorting an arrayList...");
		ArrayList <StringBackwards> al = new ArrayList <StringBackwards> ( Arrays.asList(s,t));

		Collections.sort(al);

		for ( int i = 0; i< sArray.length;i++){
			System.out.println(al.get(i).s);
		}

		//Now, let's use a priority queue (heap).
		System.out.println("\n");
		System.out.println("And now with a PriorityQueue...");
		java.util.PriorityQueue <StringBackwards > pl = new java.util.PriorityQueue <StringBackwards> ();
		
		String [] wordies = { "bunuelo", "empanada", "arroz", "zanahoria", "papitas", "yuca" };

		//The following can be done with a single command, with addAll.
		for ( String word: wordies){
			pl.add(new StringBackwards (word));
		}
		
		//Now I want to see them sorted!
		
		while (!pl.isEmpty()){
			System.out.println(pl.remove().s);
		}
		
		//I just wanted to see what hapens. Now I know.
		//Exception in thread "main" java.lang.ClassCastException: other.Nada cannot be cast to java.lang.Comparable
//		java.util.PriorityQueue <Nada> pl2 = new java.util.PriorityQueue <Nada> ();
//		
//		Nada e = new Nada ();
//		pl2.add (e);
//		Nada e2 = new Nada ();
//		pl2.add (e2);
//		
//		pl2.remove();
		
		//Treesets!
		java.util.HashSet <StringBackwards> hs = new java.util.HashSet <StringBackwards> (); 
		java.util.LinkedHashSet <StringBackwards> lhs = new java.util.LinkedHashSet<StringBackwards> ();
		java.util.TreeSet <StringBackwards> ts = new java.util.TreeSet <StringBackwards> ();
		
		for ( String word: wordies){
			hs.add(new StringBackwards(word));
			lhs.add(new StringBackwards(word));
			ts.add(new StringBackwards(word));
		}
		
		java.util.Iterator <StringBackwards> it;
		
		System.out.println("\n");
		System.out.println("And now with a HashSet (order is not guaranteed, I promess)...");
		it = hs.iterator();		
		while (it.hasNext()) System.out.println(it.next().s);
		
		//Now, let's get the elements of lhs in order.

		System.out.println("\n");
		System.out.println("And now with a LinkedHashSet...");
		it = lhs.iterator();		
		while (it.hasNext()) System.out.println(it.next().s);

		

		System.out.println("\n");
		System.out.println("And now with a TreeSet...");
		it = ts.iterator();		
		while (it.hasNext()) System.out.println(it.next().s);

		//Treemaps vs treesets...
		

		System.out.println("\n");
		System.out.println("And now with a TreeMap...");
		java.util.TreeMap <StringBackwards, Integer> tm = new java.util.TreeMap <StringBackwards, Integer> ();

		for ( String word: wordies){
			tm.put(new StringBackwards(word),word.length());
		}
		
		while (!tm.isEmpty()){
			StringBackwards sb = tm.firstKey();
			System.out.println(sb.s);
			tm.remove(sb);
		}
		
	}
}

class Nada {
	
}
