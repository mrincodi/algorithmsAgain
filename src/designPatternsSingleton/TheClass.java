package designPatternsSingleton;

public class TheClass {

	public static void main(String[] args) {
		TheSingleton theSingleton = TheSingleton.getInstance();
		
		String theSecretInfo = theSingleton.getTheInfo();

		System.out.println(theSecretInfo);
	}

}
