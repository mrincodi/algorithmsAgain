package other;

class MyComparator1 implements java.util.Comparator <Integer> {
	@Override
	public int compare (Integer x, Integer y){
		if (Math.abs(x)>Math.abs(y)) return 1;
		if (Math.abs(x)==Math.abs(y)) return 0;
		return -1;
	}
}


public class HashSetAndItsIlk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Change between HashSet, LinkedHashSet and TreeSet. Use aComparator for a TreeMap if you want.
		MyComparator1 aComparator = new MyComparator1 ();
		java.util.TreeSet <Integer> s = new java.util.TreeSet < Integer > (aComparator );

		s.add(5);
		s.add(-4);
		s.add(6);
		s.add(-2);
		s.add(Integer.MAX_VALUE);
		
		java.util.Iterator<Integer> iter = s.iterator();
		
		while (iter.hasNext())
			System.out.println(iter.next());
		
	}

}
