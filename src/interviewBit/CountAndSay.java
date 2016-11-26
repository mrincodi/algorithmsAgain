package interviewBit;

public class CountAndSay {

	public String countAndSay(int a) {
		String result = new String ();
		if (a <= 1) return "1";

		String prevResult = "1";
		for ( int i = 2; i <= a; i++){
			char prevNumber = prevResult.charAt(0);
			int numTimes=1;
			int index = 1;

			while ( index < prevResult.length()){
				char currentNumber = prevResult.charAt(index);
				if ( currentNumber == prevNumber )
					numTimes++;
				else {
					result = result + numTimes + prevNumber;
					numTimes = 1;
					prevNumber = currentNumber;
				}
				index++;
			}
			result = result + numTimes + prevNumber;
			prevResult = result;
			result = new String ();
		}
		return prevResult;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
