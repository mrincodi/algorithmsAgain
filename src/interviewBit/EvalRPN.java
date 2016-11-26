package interviewBit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  
  
 * @author mrincodi
 * 2016-08-02
 * 
 * This solution could be a bit shorter if I used regex to find out if the entry is a number or not.
 */
public class EvalRPN {


	public int evalRPN(ArrayList<String> a) {
		Stack <Integer > s = new Stack <Integer> ();

		for ( int i = 0; i < a.size(); i++){
			String word = a.get(i);
			int val = 0;

			if      (word.equals ( "+" )){
				s.push ( s.pop() + s.pop() );
			}
			else if (word.equals ( "-" )){
				int val1=s.pop();
				int val2=s.pop();
				s.push ( val2 - val1 );
			}
			else if (word.equals ( "*" )){
				s.push ( s.pop() * s.pop() );
			}
			else if (word.equals ( "/" )){
				int val1=s.pop();
				int val2=s.pop();
				s.push ( val2 / val1 );
			}
			else {
				s.push (Integer.parseInt(word));
			}
		}

		return (s.pop());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
