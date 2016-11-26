package interviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.

 * @author mrincodi
 * 2016-10-22
 * Comments: Yeah, works, but it's not ideal. It's unnecessarily O(n^2). I am adding all the elements that are not
 * not being intersected, over and over. For ideal solution (O(n log n), see InterviewBit's (O (n log n ) because of the
 * needed initial sort of the intervals).
 * Tricky problem; simpler than what it looks. Also, tricky because of the sorting class that needed to be created.
 * 
 *
 */


// Definition for an interval.
//class Interval {
//	int start;
//	int end;
//	Interval() { start = 0; end = 0; }
//	Interval(int s, int e) { start = s; end = e; }
//}

public class MergeOverlappingIntervals {

	class IntervalsComparator implements Comparator <Interval>{
		@Override
		public int compare (Interval a, Interval b){
			if (a.start > b.start) return 1;
			if (a.start == b.start) return 0;
			return -1;
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if ( intervals.size () <= 1 ) return intervals;
		ArrayList<Interval> prevIntervals = new ArrayList<Interval> ();

		Collections.sort (intervals, new IntervalsComparator ());

		for ( int intervalsIndex = 0; intervalsIndex < intervals.size(); intervalsIndex++){
			Interval interval = intervals.get(intervalsIndex);
			boolean finish = false;

			int prevIntervalsIndex = 0;
			while (!finish){

				if ( prevIntervals.size() == 0 || prevIntervalsIndex == prevIntervals.size()){
					prevIntervals.add(interval);
					finish = true;
				}
				else {
					Interval prevInterval = prevIntervals.get(prevIntervalsIndex);

					if ( interval.start > prevInterval.end){
						prevIntervalsIndex++;
					}
					else {
						prevIntervals.remove(prevIntervalsIndex);
						//interval.start = Math.min(prevInterval.start, interval.start);
						interval.end = Math.max(prevInterval.end, interval.end);
					}
				}
			}
		}
		return prevIntervals;
	}

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval> ();


		intervals.add(new Interval (5,6));
		intervals.add(new Interval (2,4));
		intervals.add(new Interval (1,2));
		intervals.add(new Interval (1,2));
		//intervals.add(new Interval (0,7));


		ArrayList<Interval> mergedIntervals = new MergeOverlappingIntervals().merge(intervals);

		for ( Interval inter : mergedIntervals){
			System.out.println(inter.start + "," + inter.end);
		}

	}

}
