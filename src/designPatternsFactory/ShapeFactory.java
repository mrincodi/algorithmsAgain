package designPatternsFactory;

public abstract class ShapeFactory {

	/**
	 * Comment: I don't see why this method cannot be static...
	 * and why can't be the whole class abstract, for that matter.
	 * @param shape
	 * @return
	 */
	public static Shape getShape (String shape){
		if ( shape == "CIRCLE")
			return new Circle();
		else if ( shape == "SQUARE")
			return new Square();
		
		return null;
	}
	
	//public abstract int tt ();
	
}
