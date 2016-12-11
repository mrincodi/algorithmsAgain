package interviewBit;

/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 
    
 * @author mrincodi
 *
 */
public class Excel {
	public int titleToNumber(String a) {
		int level = 0;
		int result = 0;
		for ( int i = a.length() - 1; i >=0; i--) {
			char c = a.charAt ( i );

			int cValue = c - 'A' + 1;
			result += cValue * Math.pow (26,level);
			level++;
		}
		return result;
	}

}
