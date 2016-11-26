package interviewBit;


/**
 * 
 * Given two sequences S, T, count number of unique ways in sequence S, to form a subsequence that is identical to the sequence T.

 Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none ) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not). 
Example :
 S = "rabbbit" T = "rabbit" 

Return 3. And the formations as follows:

S1= "ra_bbit" 
S2= "rab_bit" 
S3="rabb_it"
"_" marks the removed character.

 * @author mrincodi
 * 2016-10-11
 * Comment: Not easy. I got the relation matrix[i-1][j]+matrix[i-1][j-1] from somewhere else. 
 * TODO: I still need to understand it through.
 *
 */
public class DistinctSubsequences {

	public int numDistinct(String S, String T) {
		if ( S.length () < T.length () ) return 0;
		if ( S.length () == T.length () )
			return S.equals (T)?1:0;

		int [][] matrix = new int [S.length()][T.length()];

		int count = 0;
		for ( int i = 0; i < S.length(); i++){
			if ( S.charAt(i) == T.charAt (0))
				count++;
			matrix[i][0]=count;
		}

		for ( int i = 1; i < S.length(); i++){
			for ( int j = 1; j < T.length(); j++){
				if ( T.charAt(j)==S.charAt(i))
					matrix[i][j]=matrix[i-1][j]+matrix[i-1][j-1];
				else
					matrix[i][j]=matrix[i-1][j];

			}
		}

		return matrix [S.length()-1][T.length()-1];
	}

	public static void main(String[] args) {
		String S = "rabbbitt";
		String T = "rabit";
		
		int n = new DistinctSubsequences().numDistinct(S, T);
		System.out.println(n);

	}

}
