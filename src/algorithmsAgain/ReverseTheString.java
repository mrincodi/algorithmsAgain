package algorithmsAgain;

/**
 * Given an input string, reverse the string word by word.

Example:

Given s = "the sky is blue",

return "blue is sky the".

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

 * @author mrincodi
 * 2016-08-22
 * Comment: So, yeah, ideally I should have used only StringBuffer, but I used "+"
 * for the last check ups (space at the end, word still not in the string, etc.)
 * Much better than using only "+", though. :)
 * I also didn't use the "split" method of String.
 */
public class ReverseTheString {

	public String reverseWords(String a) {

		StringBuffer sentenceBuffer = new StringBuffer ();
		StringBuffer wordBuffer = new StringBuffer ();

		boolean prevIsSpace=true;
		for ( int i = 0; i < a.length () ; i++ ){
			char x = a.charAt(i);
			if ( x != ' '){
				wordBuffer.append (x + "");
				prevIsSpace=false;
			}
			else {
				if ( !prevIsSpace ){
					wordBuffer.append (" ");
					sentenceBuffer.insert ( 0, wordBuffer);
					wordBuffer = new StringBuffer ();
					prevIsSpace=true;
				}
			}
		}

		String sentence = sentenceBuffer.toString ();
		//Is the last letter a space?
		if ( sentence.length () > 0 && sentence.charAt (sentence.length () - 1) == ' ' )
			sentence = sentence.substring ( 0, sentence.length () - 1 );

		if (wordBuffer.length () != 0){
			if ( sentence.length () > 0 ) sentence = " " + sentence ;

			sentence = wordBuffer.toString() + sentence;
		}

		return sentence;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
