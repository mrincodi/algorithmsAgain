package designPatternsFactory;

/**
 * I don't see why
 * @author mrincodi
 *
 */
public class FactoryPatternDemo {

	public static void main(String[] args) {
		//ShapeFactory sf = new ShapeFactory();
		
		Shape shape1 = ShapeFactory.getShape("CIRCLE");
		Shape shape2 = ShapeFactory.getShape("SQUARE");
		
		
		shape1.draw();
		shape2.draw();

		//System.out.println(Shape.qq);
	}

}
