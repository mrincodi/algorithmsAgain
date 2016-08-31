package topcoder;

/**
 * 
 * 
 *     	
A substring of a string is any non-empty contiguous subsequence of its characters. For example, both "abc" and "bcd" are substrings of "abcde", but "ace" is not a substring of "abcde".



A string is called constant if all of its characters are the same. For example, "a" and "bbbbb" are constant strings, but "aba" is not a constant string.



Two substrings of the same string are considered distinct if they start or end at a different position. For example, the string "ababab" contains three distinct copies of the substring "ab", and the string "aaaa" contains two distinct copies of the substring "aaa".



Bear Limak is creating a new account and he needs to choose a password. His password should satisfy the following security requirements:

The password must be a string of length N.
Each character of the password must be either 'a' or 'b'.
For each i between 1 and N, inclusive, the password must contain exactly x[i-1] constant substrings of length i.
You are given the int[] x with N elements. Help Limak: find and return a valid password! If there are many valid passwords, return the lexicographically smallest of them. If there are no valid passwords, return "" (i.e., an empty string).

 
Definition
    	
Class:	BearPasswordLexic
Method:	findPassword
Parameters:	int[]
Returns:	String
Method signature:	String findPassword(int[] x)
(be sure your method is public)
    
 
Constraints
-	N will be between 1 and 50, inclusive.
-	x will contain exactly N elements.
-	Each element in x will be between 0 and N, inclusive.
 
Examples
0)	
    	
{5,0,0,0,0}
Returns: "ababa"
Since the given int[] x has five elements, the password must contain exactly five characters. A password must contain x[0] = 5 constant substrings of length 1, and 0 constant substrings of bigger lengths. The only two valid passwords are "ababa" and "babab". The first one is smaller lexicographically.
1)	
    	
{4,2,1,0}
Returns: "aaab"
2)	
    	
{3,1,1}
Returns: ""
3)	
    	
{4,3,2,1}
Returns: "aaaa"
4)	
    	
{0}
Returns: ""
5)	
    	
{4,0,3,2}
Returns: ""

 * @author niyaznigmatul
 * 2016-08-30
 * Comment: I talked with niyaznigmatul about this problem.
 * He changes the array x so the subarray of size k, smaller than l, are
 * contained in the one in l.
 * Then he makes the String with the new array.
 * 
 * His explanation:
 * At first I made x[i] equals to the number of substrings of length i in string, so that no bigger length could be made. And then I checked that it's possible and generated such string. 

If there is substring of length a, it contains (a - b + 1) substrings of length b.

So x[a] -= (a - b + 1) * x[b];
 * 
 * 
 */
public class BearPasswordLexic {
    public String findPassword(int[] x) {
        x = x.clone();
        int n = x.length;
        for (int i = n - 2; i >= 0; i--) {
            int len = i + 1;	
            for (int j = i + 1; j < n; j++) {
                int len2 = j + 1;
                x[i] -= x[j] * (len2 - len + 1);
            }
            if (x[i] < 0) {
                return "";
            }
        }
        int all = 0;
        for (int i = 0; i < n; i++) {
            all += (i + 1) * x[i];
        }
        if (all != n) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        all:
        while (sb.length() < n) {
            if (cur == 0) {
                for (int i = n - 1; i >= 0; i--) {
                    if (x[i] > 0) {
                        --x[i];
                        for (int j = 0; j <= i; j++) {
                            sb.append('a');
                        }
                        cur ^= 1;
                        continue all;
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if (x[i] > 0) {
                        --x[i];
                        for (int j = 0; j <= i; j++) {
                            sb.append('b');
                        }
                        cur ^= 1;
                        continue all;
                    }
                }
            }
        }
        return sb.toString();
    }
 
    
    public static void main ( String [] args ){
    	int []x = {7, 3, 1, 0, 0, 0, 0};
    	String q = new BearPasswordLexic().findPassword(x);
    	System.out.println (q);
    }
}
