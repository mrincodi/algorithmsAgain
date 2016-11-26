package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerOfTwoInteger {
	    public boolean isPower(int A) {
	        double x=2;
		    double i;
		    if(A==1) return true;
		    for(i=2;(i<33)&&(x<=(double)(Math.pow(2,16)));i++)
		    {   
		        if(Math.pow(x,i)==(double)A) return true;
		        if(Math.pow(x,i) >= (Math.pow(2,32))) {i=1;x++;}
		    }
		    return false;
	    }


	public static void main(String[] args) {
		int n = 1024000000;
		boolean b = new PowerOfTwoInteger().isPower(n);
		System.out.println(b);


	}

}
