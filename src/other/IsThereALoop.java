package other;

public class IsThereALoop {

	public boolean isThereALoop (String s ){
		if (s.length() == 0) return false;

		int x = 0, y = 0;
		char dir = 'X';
		java.util.HashSet<java.util.ArrayList <Integer>> steppedOn = new java.util.HashSet<java.util.ArrayList <Integer>> ();

		if ( !isValidDirection(s.charAt(0))) return false; //Or throw exception.
		dir = s.charAt(0);

		for ( int i = 0; i < s.length(); i++){

			char c = s.charAt(i);
			if (c == 'G'){
				switch (dir){
				case 'N':
					y++;
					break;

				case 'S':
					y--;
					break;

				case 'E':
					x++;
					break;

				case 'W':
					x--;
					break;

				default:
					break;

				}
				java.util.ArrayList <Integer> pos = new java.util.ArrayList <Integer> (java.util.Arrays.asList(x,y));
				if ( steppedOn.contains(pos)) return false;
				steppedOn.add(pos);
			}
			else {
				if (!isValidDirection(c)) return false;
				dir = c;
			}

		}
		return true;
	}

	private boolean isValidDirection (char c ){
		if ( 	c != 'N' && 
				c != 'S' &&
				c != 'E' &&
				c != 'W' ) return false;	//Or throw exception.

		return true;
	}

	public static void main(String[] args) {
		String s = "NNGGGGGGSNGEGSGGGGEGGSGGGGGGGGGGGGGWGGGGNGGGGNGG";
		boolean r = new IsThereALoop().isThereALoop(s);
		System.out.println(r);

	}

}
