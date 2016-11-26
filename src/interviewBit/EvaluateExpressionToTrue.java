package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given expression with operands and operators (OR , AND , XOR) , in how many ways can you evaluate the expression to true, by grouping in different ways? Operands are only true and false.
Input:
 string : T|F&T^T here '|' will represent or operator '&' will represent and operator '^' will represent xor operator 'T' will represent true operand 'F' will false 

Output:
 different ways % MOD where MOD = 1003 

Example:
 string : T|F only 1 way (T|F) => T so output will be 1 % MOD = 1 
 
 * @author mrincodi
 * 2016-10-24
 * Comment: Nice problem. Challenging. InterviewBit solves it with 2 tables instead of 2 HashMaps, and uses one single
 * method that always calculate the number of evaluations to true and to false.
 */
public class EvaluateExpressionToTrue {

	HashMap <ArrayList<Integer>,Integer> tr = new HashMap <ArrayList<Integer>,Integer> ();
	HashMap <ArrayList<Integer>,Integer> fa = new HashMap <ArrayList<Integer>,Integer> ();

	public int cnttrue(String a) {
		if ( a == null || a.length () == 0 ) return 0;

		return cnttrue ( a, 0, a.length() - 1);
	}

	private int cnttrue(String a, int start, int end) {
		//System.out.println(start + ", " + end);
		int result = 0;

		if ( end == start ){
			return a.charAt(start)=='T'?1:0;
		}

		ArrayList <Integer> interval = new ArrayList <Integer> ( Arrays.asList (start, end) );
		if ( tr.containsKey (interval) ) return tr.get(interval);

		for ( int i = start + 1; i < end; i = i+2 ){
			char sign = a.charAt (i);
			int numways = 0;

			switch (sign){
			case '&':
				numways = cnttrue(a,start,i-1)*cnttrue(a,i+1,end);
				break;

			case '|':
				numways = cnttrue(a,start,i-1)*cnttrue(a,i+1,end) +
				cnttrue(a,start,i-1)*cntfalse(a,i+1,end) +
				cntfalse(a,start,i-1)*cnttrue(a,i+1,end);
				break;

			case '^':
				numways = cnttrue(a,start,i-1)*cntfalse(a,i+1,end) +
				cntfalse(a,start,i-1)*cnttrue(a,i+1,end);
				break;

			default:
				break;
			}

			result += (numways % 1003);
		}

		tr.put (interval,result);
		return result % 1003;
	}

	private int cntfalse(String a, int start, int end) {

		int result = 0;

		if ( end == start ){
			return a.charAt(start)=='F'?1:0;
		}

		ArrayList <Integer> interval = new ArrayList <Integer> ( Arrays.asList (start, end) );
		if ( fa.containsKey (interval) ) return fa.get(interval);

		for ( int i = start + 1; i < end; i = i+2 ){
			char sign = a.charAt (i);
			int numways = 0;

			switch (sign){
			case '&':
				numways = cntfalse(a,start,i-1)*cntfalse(a,i+1,end) +
				cnttrue(a,start,i-1)*cntfalse(a,i+1,end) +
				cntfalse(a,start,i-1)*cnttrue(a,i+1,end);
				;
				break;

			case '|':
				numways = cntfalse(a,start,i-1)*cntfalse(a,i+1,end);
				break;

			case '^':
				numways = cnttrue(a,start,i-1)*cnttrue(a,i+1,end) +
				cntfalse(a,start,i-1)*cntfalse(a,i+1,end);
				break;

			default:
				break;
			}

			result += (numways%1003);
		}

		fa.put (interval,result);
		return result%1003;
	}




	public static void main(String[] args) {
		String s = "T^T^T^F|F&F^F|T^F^T";

		int num = new EvaluateExpressionToTrue().cnttrue(s);

		System.out.println(num);

	}

}
