package hackerrank;

import java.util.Arrays;

public class P1VMWare {


	static String lexicographically_smallest(String[] substrings) {

		Arrays.sort(substrings);
		String result = "";
		for (String s:substrings){
			result = result + s;
		}
		return result;
	}

	public static void main (String [] args){
		String[] substrings = { "aaa","aab","aba"};
		String h = P1VMWare.lexicographically_smallest(substrings);
		System.out.println(h);
	}
}
