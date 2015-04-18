//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

import java.util.*;

class Interval {
	int start;
	int end;
	
	public Interval() {
		start = 0;
		end = 0;
	}
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public String toString() {
		return "["+start+","+end+"]";
	}
}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}

public class MergeInterval {
	
	public static void printIntervals(ArrayList<Interval> intervals) {
		for(int i = 0; i < intervals.size(); i++) {
			System.out.println(intervals.get(i).toString());
		}
	}

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals.isEmpty() || intervals.size() <= 1) 
			return intervals;
		
		Collections.sort(intervals, new IntervalComparator());
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.start <= prev.end) {
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);
		printIntervals(result);
		return result;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,16));
		merge(intervals);
	}

}
