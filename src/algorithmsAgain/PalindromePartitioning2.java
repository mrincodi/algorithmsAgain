package algorithmsAgain;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example : 
Given 
s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

 * @author Mario
 * 2016-08-12
 * Comment: Enhancement with respect to PalindromePartitioning, with an array.
 */
public class PalindromePartitioning2 {
	int [] bestCuts;
	public int minCut(String a) {
		bestCuts = new int[ a.length() ];
		return minCut2 (a) -1;
	}

	public int minCut2(String a) {
		if (a.length () == 0 ) return 0;

		int pos = bestCuts.length- a.length();

		if (bestCuts[pos ] != 0)
			return bestCuts[pos ];

		//Calculate the best cuts.
		boolean aCutFound = false;
		int myBestCut=-1;
		for ( int i = 0; i < a.length();i++ ){
			if (isPalindrome (a.substring (0,i+1) ) ){
				int thisCut = minCut2 (a.substring (i+1, a.length ()));
				if ( thisCut >= 0 ) {
					//System.out.println ( "Hey!!" + thisCut);

					if ( !aCutFound){
						aCutFound=true;
						myBestCut=thisCut+1;
					}
					else {
						thisCut +=1;
						myBestCut=Math.min(thisCut,myBestCut);
					}
				}
			}
		}
		bestCuts[pos]=myBestCut;
		return myBestCut;
	}

	boolean isPalindrome (String a ){
		if ( a==null||a.length() <=1) return true;
		for (int i = 0; i < a.length()/2;i++){
			if (a.charAt(i)!=a.charAt(a.length()-i-1) ) return false;
		}
		return true;
	}


	public static void main(String[] args) {

		String a = "aab";
		int q = new PalindromePartitioning2().minCut(a);
		System.out.println (q);
	}

}
