package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * 
 * @author mrincodi
 * 2016-11-22
 * Comment: This solution fails for this input:
 * [[560,248],[0,16],[30,250],[950,187],[630,277],[950,187],[-212,-268],[-287,-222],
 * [53,37],[-280,-100],[-1,-14],[-5,4],[-35,-387],[-95,11],[-70,-13],[-700,-274],
 * [-95,11],[-2,-33],[3,62],[-4,-47],[106,98],[-7,-65],[-8,-71],[-8,-147],[5,5],
 * [-5,-90],[-420,-158],[-420,-158],[-350,-129],[-475,-53],[-4,-47],[-380,-37],
 * [0,-24],[35,299],[-8,-71],[-2,-6],[8,25],[6,13],[-106,-146],[53,37],[-7,-128],
 * [-5,-1],[-318,-390],[-15,-191],[-665,-85],[318,342],[7,138],[-570,-69],[-9,-4],
 * [0,-9],[1,-7],[-51,23],[4,1],[-7,5],[-280,-100],[700,306],[0,-23],[-7,-4],
 * [-246,-184],[350,161],[-424,-512],[35,299],[0,-24],[-140,-42],[-760,-101],
 * [-9,-9],[140,74],[-285,-21],[-350,-129],[-6,9],[-630,-245],[700,306],[1,-17],
 * [0,16],[-70,-13],[1,24],[-328,-260],[-34,26],[7,-5],[-371,-451],[-570,-69],
 * [0,27],[-7,-65],[-9,-166],[-475,-53],[-68,20],[210,103],[700,306],[7,-6],
 * [-3,-52],[-106,-146],[560,248],[10,6],[6,119],[0,2],[-41,6],[7,19],[30,250]]
 * 
 * Output: 21
 * Expected: 22
 * 
 * Also, I am not considering that there may be repeated points.
 * 
 */
public class MaxPointsOnALine {
	//Definition for a point.
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}

	public int maxPoints(Point[] points) {
		int result = 0;
		if ( points.length <= 2 ) return points.length;
		HashMap <ArrayList<Double>, HashSet<Point>> pointsInLine = new HashMap <ArrayList<Double>, HashSet<Point>> ();

		for ( int i = 0; i < points.length - 1; i++ ){
			for ( int j = i+1; j < points.length; j++){
				//Calculate m.
				Point p = points[i];
				Point q = points[j];
				double m = 0;
				double b=0;
				double y2=(double)q.y;
				double y1=(double)p.y;
				double x2=(double)q.x;
				double x1=(double)p.x;

				if ( x2 == x1 ) {
					m = Integer.MAX_VALUE;  //Special case.
					b = x1;    //Special case.
				}
				else{ 
					m = (y2-y1)/(x2-x1);
					b = y1-m*x1;
				}

				ArrayList mAndB= new ArrayList (Arrays.asList(m,b));
				if ( !pointsInLine.containsKey(mAndB) ){
					pointsInLine.put (mAndB, new HashSet<Point>());
				}
				pointsInLine.get(mAndB).add(p);
				pointsInLine.get(mAndB).add(q);

				result = Math.max (result,pointsInLine.get(mAndB).size());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
