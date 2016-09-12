package algorithmsAgain;

import java.util.Stack;

/**
 * Write a program to validate if the input string has redundant braces?
Return 0/1 
 0 -> NO 1 -> YES 

Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a + b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0


 * @author mrincodi
 * 2016-09-06
 * Comment: Easy-peasy. I had a wrong definition of redundancy. I thought
 * it was only having something like ((...))... but, more generally, is
 * not having any operation inside two parentheses (considering the inner
 * elements inside parentheses as elements). So ((a)) is redundant.
 *
 */
public class RedundantBraces {

	public int braces(String a) {
		Stack <Character> s = new Stack <Character> ();

		for ( int i = 0; i < a.length(); i++){
			char thisChar =a.charAt (i);
			
			if ( thisChar != ')')
				s.push(thisChar);
			else {
				//pop everything until you get a "(".
				//Notice if we see any sign.
				char popped = s.pop();
				boolean aSign = false;
				while (popped != '('){
					if ( popped == '+' || popped == '-' || popped == '*' || popped == '/')
						aSign = true;
					popped = s.pop();
				}
				if (!aSign) return 1;
			}
		}
		return 0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "((a+b))";
		int t = new RedundantBraces().braces(a);

		System.out.println(t);
	}

}
