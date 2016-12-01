package interviewBit;

/**
 * 
 * 
 * 
 * Zigzag StringBookmark Suggest Edit
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 **Example 2 : **
ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.
 * @author mrincodi
 *
 */

public class ZigzagString {

	public String convert(String a, int b) {

		StringBuffer s = new StringBuffer ();
		if ( b<=1 || a.length() == 0) return a;
		//Go row by row.


		for ( int i = 0; i < b; i++){

			int diffNumber = 0;

			int j = i;

			//First and last rows.
			if ( i == 0 || i == b - 1){
				diffNumber=2*(b-1);
				while ( j < a.length() ){
					s.append(a.charAt(j));
					j = j + diffNumber;
				}
			}
			//middle rows.
			else{
				diffNumber=b-(i+1);

				while ( j < a.length() ){
					s.append (a.charAt (j));
					j = j + 2*diffNumber;
					if ( j < a.length ()){
						s.append (a.charAt (j));
						j = j + 2*i;
					}
				}
			}
		}
		return s.toString ();

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
