package interviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be atleast N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).

 * @author mrincodi
 *
 *Comment: This is InterviewBit's answer. Yeah, it's better because it doesn't clone and also because it
 *uses the previous successful hashmap in each iteration.
 */
public class WindowStringInterviewBit {

	private HashMap<Character, Integer> count;
	private HashMap<Character, Integer> hashMap;

	public String minWindow(String S, String T) {

		int start = 0;
		int end = 0;
		int n;
		char c;
		int val;

		if (S == null || T == null)
			return null;

		count = new HashMap<>();
		hashMap = new HashMap<>();

		n = T.length();

		//Create two hashmaps, count and hashMap.
		//count has how many of each character.
		//hashMap has zeroes in it.
		for (int i = 0; i < n; i++) {
			c = T.charAt(i);
			add(count, c , 1);
			add(hashMap, c, 0);
		}

		ArrayList<Integer> res = new ArrayList<>();
		n = S.length();

		//end is 0 at the beginning.
		//n is the number of elements of S.
		while (end < n) {
			c = S.charAt(end);
			add(hashMap, c, 1);
			while (start < end) {
				decrement(hashMap, S.charAt(start));
				if (!validString()) {
					add(hashMap, S.charAt(start), 1);
					break;
				}
				start++;
			}
			updateResult(res, start, end);
			end++;
		}

		if (res.size() == 0)
			return "";

		start = res.get(0);
		end = res.get(1);

		return S.substring(start, end + 1);

	}

	public void add(HashMap<Character, Integer> map, char key, int v) {
		int val;
		val = v;
		if (map.containsKey(key)) {
			val += map.get(key);
		}
		map.put(key, val);
	}

	public void decrement(HashMap<Character, Integer> map, char key) {
		int val;
		if (!map.containsKey(key))
			return;
		val = map.get(key);
		val--;
		map.put(key, val);
	}

	public void updateResult(ArrayList<Integer> res, int start, int end) {
		if (!validString())
			return;

		int i, j;

		if (res.size() == 0) {
			res.add(start);
			res.add(end);
			return;
		}

		i = res.get(0);
		j = res.get(1);

		if (j - i <= end - start)
			return;

		res.clear();
		res.add(start);
		res.add(end);
	}

	public boolean validString() {
		for (Map.Entry<Character, Integer> entry : count.entrySet()) {
			char key = entry.getKey();
			int val = entry.getValue();
			if (val > hashMap.get(key))
				return false;
		}
		return true;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S= "AAAAAAAAAAASAAAAAAAAAAAAAAAAAAASSAAAAAAAAAAAAAssssssAAAAASAAAAAAASSSA";
		String T = "SSSSA";

		String qq = new WindowStringInterviewBit().minWindow(S, T);

		System.out.println(qq);
	}

}
