package designPatternsSingleton;

public class SingleObject {

	private static SingleObject instance = new SingleObject();
	
	private SingleObject (){}	
	
	public static SingleObject getInstance (){
		return instance;
	}
	
	public void showMessage (){
		System.out.println("Hello, babies!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
