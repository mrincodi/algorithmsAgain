package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 
 * 
 * Problem Statement
Fox Ciel really wanted to write a task for Topcoder Open. She came up with the following suggestion: "You are given two s: A and B. Compute and return the smallest number of characters we should remove to make the two strings equal." 


This proposal was rejected with the comment that it is too classic. Apparently, everybody knows that it can be solved by using dynamic programming to compute the longest common subsequence of the two strings. 


Ciel then suggested to make the task less classic by adding a single word: changing "smallest number of characters" into "smallest number of distinct characters". More precisely, you are still allowed to remove any subset of characters, but this time we want you to minimize the number of distinct characters among the characters you remove. 


Solve this new version of Ciel's task.
Definition
Class: RemoveCharacters
Method: minimalDistinct
Parameters: String, String
Returns: int
Method signature: int minimalDistinct(String A, String B)
(be sure your method is public)
Limits
Time limit (s): 2.000
Memory limit (MB): 256
Constraints
- A will contain between 1 and 1,000 elements, inclusive.
- B will contain between 1 and 1,000 elements, inclusive.
- Each character in A will be a lowercase English letter (i.e. 'a'-'z').
- Each character in B will be a lowercase English letter (i.e. 'a'-'z').
Examples
0)
"acabc"
"accabcc"
Returns: 1
One optimal solution here is to remove characters at 0-based indices 1 and 6 in the string B. Both removed characters are 'c's. This changes the string B from "accabcc" to "acabc" and makes the two strings equal. As we only removed one distinct character, the correct return value is 1.
1)
"aabbcc"
"ccbbaa"
Returns: 2
One optimal solution is to remove the first four characters of A and the last four characters of B. After this change, both strings become equal to "cc". We removed two distinct characters: some 'a's and some 'b's.
2)
"aaaabc"
"bcaaaaa"
Returns: 1
The optimal solution here is to remove all nine 'a's. Note that we are only interested in minimizing the number of distinct characters among the characters we remove. The total number of removed characters may be arbitrary.
3)
"abcde"
"abcde"
Returns: 0
4)
"abcdefghijklm"
"nopqrstuvwxyz"
Returns: 26
We need to remove all of them.

 * 
 * @author mrincodi
 * 2016-08-31
 * Comments: Good news: works... 
 * Bad news:... when the strings have not too many different characters.
 *
 */
public class RemoveCharacters {

	HashMap < ArrayList <String>, Integer> minNumsHM = new HashMap < ArrayList <String>, Integer> ();

	public int minimalDistinct(String A, String B){

		//First of all, count the characters in A that are not in B and viceversa.
		//Remove them and add 1 to the answer.

		int numDiffLetters = 0;
		TreeSet <Character> charsA = getDiffChars (A );
		Iterator <Character> it = charsA.iterator();

		//First, charsA.
		while (it.hasNext()){
			char c = it.next();
			if (B.indexOf(c)== -1){
				numDiffLetters++;
				A=removeChar(A,c);
			}
		}
		
		TreeSet <Character> charsB = getDiffChars (B );
		it = charsB.iterator();

		//First, charsA.
		while (it.hasNext()){
			char c = it.next();
			if (A.indexOf(c)== -1){
				numDiffLetters++;
				B=removeChar(B,c);
			}
		}

		return numDiffLetters + minimalDistinct1 (A,B);
	}



	public int minimalDistinct1 (String A, String B){
		//System.out.println ( A + "," + B);
		if ( A.equals(B)) return 0;

		if ( A.length()==0) return getDiffChars(B).size();
		if ( B.length()==0) return getDiffChars(A).size();

		ArrayList<String> theStrings = new ArrayList<String>(Arrays.asList(A,B));

		if ( minNumsHM.containsKey(theStrings)) 
			return minNumsHM.get(theStrings);

		TreeSet <Character> chars = getDiffChars (A + B);

		int minNum = A.length() + B.length() + 1;

		Iterator <Character> iter = chars.iterator();

		while (iter.hasNext()){
			char c = iter.next();
			String newA = removeChar ( A, c);
			String newB = removeChar ( B, c);

			int num = 1 + minimalDistinct (newA, newB);
			minNum = Math.min(minNum, num);

		}
		minNumsHM.put(theStrings, minNum);
		return minNum;

	}

	private String removeChar(String a, char c) {
		StringBuffer sb = new StringBuffer ();
		for ( int i = 0; i < a.length();i++){
			if (a.charAt(i)!=c)sb.append(a.charAt(i));
		}
		return sb.toString();
	}


	private TreeSet <Character> getDiffChars(String string) {
		TreeSet <Character> ts = new TreeSet <Character>();
		for (char c: string.toCharArray()){
			ts.add(c);
		}
		return ts;
	}


	public static void main(String[] args) {
		String A = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		String B= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

		
		A = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccddddddddddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkllllllllllllllllllllllllllllllllllllllmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnooooooooooooooooooooooooooooooooooooooppppppppppppppppppppppppppppppppppppppqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrssssssssssssssssssssssssssssssssssssssttttttttttttttttttttttttttttttttttttttuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvwvvvwwwwwwwwwwwvwwwwwwwwwwwwwwwwwwwwwwwwwwxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		B= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccddddddddddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkllllllllllllllllllllllllllllllllllllllmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnooooooooooooooooooooooooooooooooooooooppppppppppppppppppppppppppppppppppppppqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrssssssssssssssssssssssssssssssssssssssttttttttttttttttttttttttttttttttttttttuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuvvvvvvvvvvvvvvvvvvvvvvvvvvvvwvvvvvvvvvwwwwwwvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		
		A="abcdefghijklmnopqrstuvwxyz";
		B="abcdefghijklmnopqrstuvvwvvwwvwwxyz";
		
		int q = new RemoveCharacters().minimalDistinct(A, B);

		System.out.println(q);

	}

}
