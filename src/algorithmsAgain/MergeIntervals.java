package algorithmsAgain;

import java.util.ArrayList;

public class MergeIntervals {

	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new  ArrayList<Interval> ();

		if ( intervals.size() == 0 ){
			result.add (newInterval);
			return result;
		}
		//TODO: What if new interval's size is 0?

		ArrayList<Interval> intersections = new  ArrayList<Interval> ();
		//Let's collect the intersecting intervals (if any), inside an array.

		for ( int i = 0; i < intervals.size(); i++){
			if (Math.max (newInterval.start, intervals.get(i).start) <= Math.min (newInterval.end, intervals.get(i).end)       ){       
				intersections.add ( intervals.get(i));
			}
		}

		//Now, let's merge if we need to.
		if (intersections.size() == 0 ) {
			//Let's just decide where this new interval will go.

			if ( intervals.get(0).start > newInterval.end ){
				//Just put this new interval at the beginning.
				result.add (newInterval);
				result.addAll (intervals);
				return result;
			}

			if ( intervals.get(intervals.size()-1).end < newInterval.start ){
				//Just put this new interval at the end.
				result.addAll (intervals);
				result.add (newInterval);
				return result;
			}

			//The interval goes in the middle of two intervals. Let's find which.

			int ii = 0;
			while ( intervals.get(ii).end < newInterval.start ){
				//	                System.out.println ("AAA HOla. Voy a aNadir la pos. " + ii + ", " + intervals.get(ii));

				result.add (intervals.get(ii++));

			}

			//	            System.out.println ("BBB HOla. Voy a aNadir la pos. " + ii + ", " + intervals.get(ii));
			result.add (newInterval);

			while (ii<intervals.size()){
				//	               System.out.println ("CCC HOla. Voy a aNadir la pos. " + ii + ", " + intervals.get(ii));

				result.add (intervals.get(ii++));
			}
		}

		else {
			//OK! There are intersections! Let's merge them.
			int newStart = Math.min (newInterval.start, intersections.get(0).start);
			int newEnd =   Math.max (newInterval.end, intersections.get(intersections.size()-1).end);
			Interval newMerged = new Interval (newStart, newEnd);

			//Now, let's add this interval.

			//First, we add all the intervals before newMerged.

			//Counter for intervals.
			int ii=0;

			while (ii<intervals.size() && intersections.get(0).start != intervals.get(ii).start){
				result.add (intervals.get(ii));
				ii++;
			}

			//Now, we add the newMerged.
			result.add (newMerged);

			//We ignore the merged intervals.
			ii += intersections.size();
			/*
	            int jj=0;
	            while (jj<intervals.size() && intersections.get(ii).start ==  intervals.get(ii).start){
	                ii++;
	            }
			 */

			//We add the rest of the intervals.
			while (ii<intervals.size()){
				result.add (intervals.get(ii));
				ii++;
			}
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
