package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;

public class BlackShapesBad {

	public int black(ArrayList<String> a) {
		if ( a.size()==0 ) return 0;
		if ( a.size()==1 ){
			String s = a.get(0);
			int howMany=0;
			boolean prevIsX=false;
			for ( int i = 0; i < a.get(0).length(); i++ ){
				if (s.charAt(i)=='X'){
					if (!prevIsX){
						howMany++;
						prevIsX=true;
					}
				}
				else {
					prevIsX=false;
				}
			}
			return howMany;
		}

		int howMany=0;
		for (int i = 1; i < a.size(); i++ ){
			String s1 = a.get(i-1);
			String s2= a.get(i);

			boolean prevIsX=false;
			boolean connectedDown=false;
			for (int j = 0; j < s2.length();j++){
				//prevIsX=false;

				if (s1.charAt(j)=='X'){
					prevIsX=true;
					if (s2.charAt(j)=='X') connectedDown = true;
				}
				else {
					if (prevIsX){
						if ( !connectedDown) howMany++;
						prevIsX=false;
					}
				}
			}
		}

		//Now work with the last one. Just count the connected X's.
		boolean prevIsX=false;
		String s = a.get(a.size()-1);
		for ( int i = 0; i < a.get(a.size()-1).length(); i++ ){
			if (s.charAt(i)=='X'){
				if (!prevIsX){
					howMany++;
					prevIsX=true;
				}
			}
			else {
				prevIsX=false;
			}
		}

		return howMany;
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
		int b = new BlackShapesBad().black (al);

		System.out.println(b);

	}

}
