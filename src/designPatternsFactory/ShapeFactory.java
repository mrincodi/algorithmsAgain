package designPatternsFactory;

public class ShapeFactory {

	public Shape getShape (ShapesEnum shapeType, int side){
		switch (shapeType){
		case EQUILATERAL:
			return new EquilateralTriangle(side);
		case SQUARE:
			return new Square(side);
		default:
			break;
		}
		return null;
	}
}
