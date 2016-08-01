package jUnitAgain;

import static org.junit.Assert.*;

import org.junit.Test;

public class PinoTests {

	
	
	
//	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	
	
	
	@org.junit.Test
	public void basicMultiplyTest (){
		int x= 545, y=309;
		int realMultiply = x*y;
		int myMultiply = SillyClass.multiply(x, y, false);
		assertEquals(	myMultiply, realMultiply);
	}
	
	
	
	
	
	
	
	
	
	
	@org.junit.Test
	public void assertKowabungaMultiplication (){
		
		int myMult = SillyClass.multiply(33,55, true);
		System.out.println(myMult);
		org.junit.Assert.assertEquals( "Should be 432", 433, myMult);
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
