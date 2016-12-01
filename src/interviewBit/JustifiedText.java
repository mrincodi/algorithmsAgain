package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible.
If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

Your program should return a list of strings, where each string represents a single line.

Example:

words: ["This", "is", "an", "example", "of", "text", "justification."]

L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]
 Note: Each word is guaranteed not to exceed L in length. 
 
 * @author mrincodi
 * 2016-12-01
 * Comment: not my most beautiful piece of code, but works and is efficient. It can be enhanced using a StringBuffer instead of Strings.
 */
public class JustifiedText {

	public ArrayList<String> fullJustify(ArrayList<String> words, int lineSize) {
		ArrayList<String> result = new ArrayList<String>();
		int i = 0;
		while ( i < words.size()){
			String thisLine = words.get(i);

			int numCharsUsed = words.get(i).length();
			int numNonspaceChars = numCharsUsed;

			if ( numCharsUsed >= lineSize){
				thisLine = words.get(i);
				i++;
			}
			else {
				int j = 1;

				inner:
					while ( i + j < words.size()){
						if (numCharsUsed+1+words.get(i + j).length() < lineSize){
							numCharsUsed=numCharsUsed+1+words.get(i + j).length();
							numNonspaceChars+=words.get(i + j).length();

							j++;
						}
						else if (numCharsUsed+1+words.get(i + j).length() == lineSize){
							numCharsUsed=numCharsUsed+1+words.get(i + j).length();
							numNonspaceChars+=words.get(i + j).length();
							break inner;
						}
						else {
							j--;
							break inner;
						}
					}

				if ( i + j == words.size()){
					//We got to the end.
					for ( int k = i + 1; k< words.size(); k++){
						thisLine +=" ";
						thisLine += words.get(k);
					}
					while (thisLine.length()<lineSize )
						thisLine += " ";
					i=words.size();
				}
				else {

					//Calculate spaces for justification.
					int numWords = j + 1;
					if ( numWords == 1){
						thisLine = words.get(i);
						while (thisLine.length()<lineSize )
							thisLine += " ";
						i++;
					}
					else {
						int totalSpaces = lineSize - numNonspaceChars;
						int minSpaceBetweenWords = totalSpaces / (numWords-1);
						int extraSpaces = totalSpaces % (numWords-1);

						String minSpaceBlock = "";
						for ( int k = 0; k < minSpaceBetweenWords; k++){
							minSpaceBlock+=" ";
						}

						for ( int k = 1; k < numWords; k++){

							thisLine += minSpaceBlock;
							if (extraSpaces > 0){
								thisLine += " ";
								extraSpaces--;
							}
							thisLine+= words.get(i+k);
						}

						i=i+numWords;
					}
				}
			}

			result.add(thisLine);
		}
		return result;	    
	}



	public static void main(String[] args) {
		String frase = "Hola, Kamila. Cómo estás. Éste es un programa que estoy haciendo. Eres bella.";
		ArrayList<String> words = new ArrayList<String> ( Arrays.asList(frase.split(" ") ));
		int lineSize = 10;
		ArrayList<String> result = new JustifiedText().fullJustify(words, lineSize);

		for (String line:result)
			System.out.println(line);

	}

}
