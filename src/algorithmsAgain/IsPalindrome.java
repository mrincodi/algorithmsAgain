package algorithmsAgain;

public class IsPalindrome {
	public boolean isAlphanumeric ( char c ){
		if ( c >= 'A' && c <= 'Z') return true;
		if ( c >= 'a' && c <= 'z') return true;
		if ( c >= '0' && c <= '9') return true;
		return false;
	}
	public int isPalindrome(String a) {

		String xa = a.toLowerCase();

		int i = 0, j = a.length ()-1;
		char c = '0';

		while ( i < j ){

			char aa = xa.charAt(i);
			char bb = xa.charAt(j);

			//System.out.println ("Voy por chars " + i +  ", " + a.charAt(i)  +" and " + j + ", " + a.charAt(j));

			if ( !isAlphanumeric(aa)){
				i++;
			}
			else {
				if ( !isAlphanumeric(bb)){
					j--;
				}
				else {
					//System.out.println ("Ambos son alfa.");
					if ( aa != bb){
						return 0;
					}
					else {
						i++;
						j--;
					}
				}
			}
		}
		return 1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub                 mmmmmmmmmmmm
	}

}
