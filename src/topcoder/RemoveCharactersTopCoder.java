package topcoder;

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
 * Comments: Some explanations I found out, inline.
 *
 */
public class RemoveCharactersTopCoder {
    public int minimalDistinct(String A, String B) {
        int[] f = new int[26];
        for (char c = 'a'; c <= 'z'; c++) {
            for (char d = c; d <= 'z'; d++) {
                String a = "";
                String b = "";
                for (char e : A.toCharArray()) {
                    if (e == c || e == d) {
                        a += e;
                    }
                }
                for (char e : B.toCharArray()) {
                    if (e == c || e == d) {
                        b += e;
                    }
                }
                System.out.println(a + "," + b);
                
                //MR: Here it's making a matrix of chars vs. chars that puts 0 if the substrings made 
                //with the two chars only are equal (0=yes, 1=no).
                if (!a.equals(b)) {
                    f[c - 'a'] |= 1 << (d - 'a');
                    f[d - 'a'] |= 1 << (c - 'a');
                }
            }
        }        
        
        // Here, we see what combinations of letters taken out from both strings
        // gives us a zero matrix.
        // If the matrix is zero, both strings are equal (TODO: demonstrate).
        // The smallest combination is the winner.
        int ans = 0;
        all:
        for (int i = 0; i < 1 << 26; i++) {
        	System.out.println (i);
            if (Integer.bitCount(i) <= ans) continue;
            for (int j = 0; j < 26; j++) {
                if (((i >> j) & 1) == 0) continue;
                if ((f[j] & i) != 0) {
                    continue all;
                }
            }
            ans = Integer.bitCount(i);
        }
        return 26 - ans;
    }
 
    
	public static void main(String[] args) {
		System.out.println(1<<26);

		String A = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		String B= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

		
		A = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccddddddddddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkllllllllllllllllllllllllllllllllllllllmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnooooooooooooooooooooooooooooooooooooooppppppppppppppppppppppppppppppppppppppqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrssssssssssssssssssssssssssssssssssssssttttttttttttttttttttttttttttttttttttttuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvwvvvwwwwwwwwwwwvwwwwwwwwwwwwwwwwwwwwwwwwwwxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		B= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccddddddddddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkllllllllllllllllllllllllllllllllllllllmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnooooooooooooooooooooooooooooooooooooooppppppppppppppppppppppppppppppppppppppqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrssssssssssssssssssssssssssssssssssssssttttttttttttttttttttttttttttttttttttttuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuvvvvvvvvvvvvvvvvvvvvvvvvvvvvwvvvvvvvvvwwwwwwvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		
		A="abcdefghijklmnopqrstuvwxyz";
		B="abcdefghijklmnopqrstuvvwvvwwvwwxyz";
		
		A="aaaabbcc";
		B="aabbaa";
		int q = new RemoveCharactersTopCoder().minimalDistinct(A, B);

		System.out.println(q);

	}
}
