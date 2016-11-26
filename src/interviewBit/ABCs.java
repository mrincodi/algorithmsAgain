package interviewBit;

import java.util.HashMap;

/**
 * From CareerCup:
 * https://www.careercup.com/question?id=5717453712654336 
 * Given a length n, return the number of strings of length n that can be made up of the letters 'a', 'b', and 'c', where there can only be a maximum of 1 'b's and can only have up to two consecutive 'c's 

Example: 
findStrings(3) returns 19 
since the possible combinations are: aaa,aab,aac,aba,abc,aca,acb,baa,bac,bca,caa,cab,cac,cba,cbc,acc,bcc,cca,ccb
and the invalid combinations are: 
abb,bab,bba,bbb,bbc,bcb,cbb,ccc

 * @author mrincodi
 *
 */
public class ABCs {

	HashMap <String, Integer> h = new HashMap <String, Integer> ();

	int howManyStrings (int n ){
		int total = howManyStrings (n,false,0);
		return total;
	}

	int howManyStrings (int n, Boolean hasBbeenUsed, int trailingCs){
		if ( n == 0) return 0;
		int total=0;
		if (n == 1){
			total = 1; //a

			if (!hasBbeenUsed) total++; // b

			if ( trailingCs < 2 ) total++; // c

			return total;
		}
		else{
			//Check if we considered this case already.
			String s = n + hasBbeenUsed.toString() + trailingCs;
			if ( h.containsKey(s) ) return h.get(s);

			total=
				howManyStrings (n-1, hasBbeenUsed, 0); //a.
			if (!hasBbeenUsed) total+= howManyStrings (n-1, true, 0); //b
			if ( trailingCs < 2) total+= howManyStrings (n-1, hasBbeenUsed, trailingCs++); //Final c.

			h.put (s, total);
			return total;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = new ABCs().howManyStrings (20);
		System.out.println(a);

	}

}
