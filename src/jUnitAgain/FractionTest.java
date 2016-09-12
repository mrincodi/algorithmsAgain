package jUnitAgain;

import algorithmsAgain.Fraction;

public class FractionTest {

	Fraction f = new Fraction ();
	
	@org.junit.Test
	public void divisionOfTwoPositivesGivesPositive(){
		int numerator = 14;
		int denominator = 2;
		
		String res = new Fraction().fractionToDecimal(numerator, denominator);
		org.junit.Assert.assertEquals("14 / 2 = 7 !!", "7",res);
		
		org.junit.Assert.assertEquals("30 / 2 = 15 !!", "15", new Fraction().fractionToDecimal(30, 2));
		
		org.junit.Assert.assertEquals("1000 / 10 = 100 !!", "100", new Fraction().fractionToDecimal(1000, 10));
		
	}
	
	@org.junit.Test
	public void divisionOfpositiveOverNegative(){
		
		org.junit.Assert.assertEquals("-14/2=-7", "-7", new Fraction().fractionToDecimal(-14, 2));
		
		org.junit.Assert.assertEquals("-4 / 2 = 2 !!", "-2", new Fraction().fractionToDecimal(-4, 2));
		
	}
	
//	@org.junit.Test
//	public void thisIsAnError(){
//		org.junit.Assert.assertEquals("Something terrible happened!!","-5", new Fraction().fractionToDecimal(-4, 2));
//		
//	}
	
	
	
	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
