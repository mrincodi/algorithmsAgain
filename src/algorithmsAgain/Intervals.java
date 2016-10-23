package algorithmsAgain;

import java.util.ArrayList;

/**
 * 
 * Problem "Merge Intervals" from InterviewBit.
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.

HINT: Note that if max(a,c) > min(b,d), then the intervals do not overlap. Otherwise, they overlap.

 * @author Mario
 *
 */
public class Intervals {

//	class Interval {
//		int start;
//		int end;
//		Interval() { start = 0; end = 0; }
//		Interval(int s, int e) { start = s; end = e; }
//	}

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
				result.add (intervals.get(ii++));

			}

			result.add (newInterval);

			while (ii<intervals.size()){
				result.add (intervals.get(ii++));
			}
		}

		else {
			//OK! There are intersections! Let's merge them.
			int newStart = Math.min (newInterval.start, intersections.get(0).start);
			int newEnd =   Math.max (newInterval.end, intersections.get(intersections.size()-1).end);
			Interval newMerged = new Interval (newStart, newEnd);

			//Now, let's add this interval.
			int ii=0;

			//First, we add all the intervals before newMerged.
			while (ii<intervals.size() && intersections.get(0).start != intervals.get(ii).start){
				result.add (intervals.get(ii));
				ii++;
			}

			//Now, we add the newMerged.
			result.add (newMerged);

			//We ignore the merged intervals.
			ii += intersections.size();

			//We add the rest of the intervals.
			while (ii<intervals.size()){
				result.add (intervals.get(ii));
				ii++;
			}
		}
		return result;
	}
}


/**
 * Their solution:

 public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    
        int start, end;
        int startIndex, endIndex;
        int i;
        
        start = newInterval.start;
        end = newInterval.end;
        i = 0;
        
        startIndex = endIndex = -1;
        
        for (Interval in : intervals) {
            
            if (start >= in.start && start <= in.end)
                startIndex = i;
            
            if (end >= in.start && end <= in.end)
                endIndex = i;
            
            i++;
        }
        
        if (startIndex == -1 && endIndex == -1) {
            
            startIndex = 0;
            
            for (i = 0; i < intervals.size(); i++) {
                if (start > intervals.get(i).end) {
                    startIndex = i + 1;
                }
            }
            
            endIndex = intervals.size() - 1;
            
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (end < intervals.get(i).start) {
                    endIndex = i - 1;
                }
            }
            
            for (i = startIndex; i <= endIndex; i++) {
                intervals.remove(startIndex);
            }
            
            intervals.add(startIndex, newInterval);
            
            return intervals;
        }
        
        if (startIndex == -1) {
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (start <= intervals.get(i).start)
                    startIndex = i;
            }
        }
        
        if (endIndex == -1) {
            for (i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).end)
                    endIndex = i;
            }
        }
        
        start = Math.min(intervals.get(startIndex).start, start);
        end = Math.max(intervals.get(endIndex).end, end);
        
        intervals.get(startIndex).start = start;
        intervals.get(startIndex).end = end;
        
        for (i = startIndex + 1; i <= endIndex; i++) {
            intervals.remove(startIndex + 1);
        }
    
        return intervals;
    
    }
}
*/
