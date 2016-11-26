package interviewBit;

public class LengthOfLastWord {



	public int lengthOfLastWord(final String a) {
		if ( a == null || a.length () == 0 ) return 0;

		int i = a.length () - 1;

		while ( i >= 0){
			if ( a.charAt(i) != ' ' ){
				//Start counting cycle.
				int j = i;
				int counter =0;
				while (j >=0 && a.charAt(j) != ' ' ){
					counter++;
					j--;
				}
				return counter;
			}
			i--;
		}
		return 0;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
