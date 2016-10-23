package algorithmsAgain;

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
 * Comments: Ideal solution, O(n log n) because of the initial sorting.
 * If intervals were already sorted, it would be O(n). (!)
 *
 */


// Definition for an interval.
//class Interval {
//	int start;
//	int end;
//	Interval() { start = 0; end = 0; }
//	Interval(int s, int e) { start = s; end = e; }
//}

public class MergeOverlappingIntervalsInterviewBit {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new IntervalComp());
        ArrayList<Interval> res;
        Interval inter;
        int n = intervals.size();
        res = new ArrayList<>();
        
        for (int i = 0; i < n;) {
            
            inter = new Interval(intervals.get(i).start, intervals.get(i).end);
            Interval next;
            i++;
            
            while (i < n) {
                next = intervals.get(i);
                if (overlap(inter, next)) {
                    inter.end = Math.max(inter.end, next.end);
                    i++;
                } else {
                    break;
                }
            }
            
            res.add(inter);
            
        }
        
        return res;
    }
    
    private boolean overlap(Interval int1, Interval int2) {
        
        if (int1.end >= int2.start && int1.start <= int2.end)
            return true;
            
        return false;
        
    }
    
    private class IntervalComp implements Comparator<Interval> {
        
        @Override
        public int compare(Interval interval1, Interval interval2) {
            int cmp =  Integer.compare(interval1.start, interval2.start);
            if (cmp != 0)
                return cmp;
            cmp = Integer.compare(interval1.end, interval2.end);
            return cmp;
        }

	}

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval> ();


		intervals.add(new Interval (5,6));
		intervals.add(new Interval (2,4));
		intervals.add(new Interval (1,2));
		intervals.add(new Interval (1,2));
		//intervals.add(new Interval (0,7));


		ArrayList<Interval> mergedIntervals = new MergeOverlappingIntervalsInterviewBit().merge(intervals);

		for ( Interval inter : mergedIntervals){
			System.out.println(inter.start + "," + inter.end);
		}

	}

}
