package algorithmsAgain;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"

 * @author mrincodi
 * Comments: A beautiful problem. Hash usage is not obvious.
 * My solution works fine, but is a little verbose.
 * InterviewBit solution is concise and worth of a look.
 * I left my comments just for the record.
 * Date: 2016-08-05.
 */
public class Fraction {

		public String fractionToDecimal(int numerator, int denominator) {
		    StringBuffer sb = new StringBuffer ();
		    String result = "";
		    
		    // InterviewBit loves to test with 2147483648,
		    // so let's just work with longs and that's it.
	        ArrayList <Long> numerators = new ArrayList <Long> ();
		    HashMap <Long, Long> h = new HashMap <Long, Long> ();
		    
		    //Get the real part
		    Long numeratorL = new Long (numerator);
		    Long denominatorL = new Long (denominator);
		    
		    Long divisionL = numeratorL/denominatorL;
		    //int division = (int) (long)divisionL;

		    //int division = numerator/denominator;
		    Long remainderL = numeratorL%denominatorL;
	        
	        if ( remainderL == 0 ){
	                    //System.out.println ( "remainder es 0");
	            return ( divisionL + "" );
	        }
	        
	        
	        //Caveat: if division is zero but signs are different, add the minus
	        //to the buffer.
	        if ((numeratorL > 0 && denominatorL < 0 ) || 
	        (numeratorL < 0 && denominatorL > 0 ))
	            sb.append ("-");
	        
	        numeratorL=Math.abs(numeratorL);
	        denominatorL=Math.abs(denominatorL);
	        divisionL=Math.abs(divisionL);
	        remainderL=Math.abs(remainderL);
	        
	        sb.append ( divisionL + ".");
	        
	        //We start saving the remainders and results.
	        boolean repeated = false;
	        numeratorL = remainderL;
	        
	        while ( !repeated ){

	            numeratorL = numeratorL * 10;
	            divisionL = numeratorL/denominatorL;
	            remainderL = numeratorL%denominatorL;

	            //If it's zero then:
	            //Add our current divisions.
	            //Add the current result.
	            if ( remainderL == 0 ){
	                for ( int i = 0; i < numerators.size();i++){
	                    sb.append (h.get(numerators.get(i)) );
	                }
	                sb.append (divisionL);
	                return sb.toString ();
	            }
	            
	            //Look for the current numerator on the HashMap.
	            // If found return sequence of results.

	            //What if result is zero?
	            
	            if (h.containsKey (numeratorL) ){
	                
	                repeated = true; //Numerator previously seen!
	                //System.out.println ("Repetido en... " + numeratorL);
	                
	                //Look for the numerator in the arrayList.
	                //Start adding the results (digits)
	                int pos = 0;
	                
	                while ( pos < numerators.size() && !numerators.get(pos).equals(numeratorL) ){
	                    
	                    //System.out.println (pos + " y numerators.size es " + numerators.size ());
	                    //if ( numerators.get(pos)!= numerator)
	                    //System.out.println ( "Tengo pos " + pos + " que tiene " + 
	                    //numerators.get(pos) + " y hash " + 
	                    //h.get(numerators.get(pos)));
	                    
	                    //System.out.println ( "XXX" + numerators.get(pos)+ "XXX" + numeratorL + "XXX");
	                    sb.append ( h.get(numerators.get(pos)));
	                    pos++;
	                }
	                sb.append ("(");
	                //System.out.println ("Pasamos...");
	                for ( int i = pos; i < numerators.size();i++){
	                    //System.out.println ("Y seguimos..." + i);
	                    sb.append (h.get(numerators.get(i)) );
	                }
	                sb.append (")");
	                return sb.toString ();
	            }
	            
	            //Calculate the next number

	            numerators.add (numeratorL);
	            h.put (numeratorL, divisionL);
	                
	            numeratorL=remainderL;
	        }
	        return sb.toString ();
		}

	public static void main(String[] args) {
		int numerator = 7;
		int denominator=9;
		String result = new Fraction().fractionToDecimal(numerator, denominator);
		System.out.println(result);
	
	}

}
