package designPatternsFactory;

public class ShapesMain {

	public static void main(String[] args) {
		int side = 23;
		Shape equi = new ShapeFactory().getShape(ShapesEnum.EQUILATERAL, side);
		Shape squa = new ShapeFactory().getShape(ShapesEnum.SQUARE, side);
		
		int area = equi.getArea();
		
		System.out.println(area);
		
		area = squa.getArea();

		System.out.println(area);
		
	}

}
