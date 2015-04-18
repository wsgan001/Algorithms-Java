//Given a set of non-overlapping & sorted intervals, 
//insert a new interval into the intervals (merge if necessary).

//Example 1:
//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//Example 2:
//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

//This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

//class Interval {
//	int start;
//	int end;
//	
//	public Interval() {
//		start = 0;
//		end = 0;
//	}
//	
//	public Interval(int start, int end) {
//		this.start = start;
//		this.end = end;
//	}
//	
//	public String toString() {
//		return "["+start+","+end+"]";
//	}
//}

import java.util.*;

public class InsertInterval {
	
	public static void printIntervals(ArrayList<Interval> intervals) {
		for(int i = 0; i < intervals.size(); i++) {
			System.out.println(intervals.get(i).toString());
		}
	}

	public static ArrayList<Interval> insertInterval(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (Interval interval: intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
				continue;
			} else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
				continue;
			} if (interval.start >= newInterval.end || interval.end <= newInterval.start) {
				newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
			}
				
		}
		result.add(newInterval);
		printIntervals(result);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,16));
		Interval newInterval = new Interval(4,9);
		insertInterval(intervals, newInterval);
	}

}
