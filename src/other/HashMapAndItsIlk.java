package other;

import java.util.Map;

public class HashMapAndItsIlk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Change between HashMap, LinkedHashMap and TreeMap.
		java.util.TreeMap <Integer, Integer> h = new java.util.TreeMap < Integer, Integer > ();

		h.put(5, 7);
		h.put(4, 6);
		h.put(6, 7);
		h.put(2, 2);
		h.put(Integer.MAX_VALUE, 7);
		
		Map.Entry<Integer, Integer> entryi = h.firstEntry();
		
		System.out.println("--> " + entryi.getKey());
		for ( java.util.Map.Entry<Integer, Integer > entry : h.entrySet() ){
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}
	}

}
