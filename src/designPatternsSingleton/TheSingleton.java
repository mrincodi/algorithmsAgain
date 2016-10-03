package designPatternsSingleton;

public class TheSingleton {
	
	private static TheSingleton theInstance = new TheSingleton();

	private int theNumber = 7;
	private String theInfo = "Top seeeeeecret.";
	
	
	private TheSingleton (){}
	
	public void printMessage (){
		System.out.println("Tolis");
	}
	
	public static TheSingleton getInstance (){
		return theInstance;
	}

	public int getTheNumber() {
		return theNumber;
	}

	public void setTheNumber(int theNumber) {
		this.theNumber = theNumber;
	}

	public String getTheInfo() {
		return theInfo;
	}

	public void setTheInfo(String theInfo) {
		this.theInfo = theInfo;
	}

}
