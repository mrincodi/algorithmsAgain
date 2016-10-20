package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:

OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X
Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX
is just one single connected black shape.

 * @author mrincodi
 * Date: ??
 * Comment:
 */
public class BlackShapes {

	public int black(ArrayList<String> a) {

		char [] [] m = new char [a.size()][a.get(0).length()];
		
		for ( int i = 0; i < a.size(); i++){
			for ( int j = 0; j < a.get(0).length();j++){
				m[i][j]=a.get(i).charAt(j);
			}
		}

		int howMany=0;
		for ( int i = 0; i < a.size(); i++){
			for ( int j = 0; j < a.get(0).length();j++){
				char c = m[i][j];
				if ( c == 'X'){
					//color the matrix.
					color (m, i, j);
					howMany++;
				}
			}
		}
		return howMany;
	}

	private void color(char[][] m, int i, int j) {
		if ( i < 0 || i >= m.length || j < 0 || j >= m[0].length) return;

		char c = m[i][j];
		if ( c == 'X'){
			m[i][j]='A';
			color (m, i-1,j);
			color (m, i+1,j);
			color (m, i,j-1);
			color (m, i,j+1);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList <String > al = new ArrayList <String> (Arrays.asList ( 
				"XOOOOOXXOX", 
				"OOXXXXOOXX", 
				"XXOXXOOXXO", 
				"OXOXXXXXXO", 
				"XOXXOXOXXX", 
				"OOOOOOOXOO", 
				"XOXXXOOXOX", 
				"XXXOXOXXXO" ));
		int b = new BlackShapes().black (al);

		System.out.println(b);

	}

}
