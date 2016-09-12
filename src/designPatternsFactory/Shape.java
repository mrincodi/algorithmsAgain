package designPatternsFactory;


public interface Shape {

	//int qq=7;
	
	void draw();
	
	default void empanadas (){
		System.out.println ("Sabrosongas");
	}

}
