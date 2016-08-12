package testsAgain;

import static testsAgain.TestingStaticImports.*;	

public class TestingStaticImports2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d = empa + 1;					//Static variable
		String [] strings = { "Em", "pa", "nada"};
		vayaMethod (strings);				// Static method.
		TestingStaticImports.main(strings); // The main of TestingStaticImports (overwritten by this one).
		main (strings);						// Ourselves!
		
	}
	

}
