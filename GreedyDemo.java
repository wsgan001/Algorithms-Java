import java.util.ArrayList;
import java.util.Arrays;


public class GreedyDemo {

//	You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
//	Example:
//
//	Consider the following 6 activities. 
//	     start[]  =  {1, 3, 0, 5, 8, 5};
//	     finish[] =  {2, 4, 6, 7, 9, 9};
//	The maximum set of activities that can be executed 
//	by a single person is {0, 1, 3, 4}
	
	public static void activitySelection(int[] s, int[] f) {
		int n = s.length;
		for (int i = 0; i < n-1; i++)
			for (int j = i + 1; j < n; j++)
				if (f[i] > f[j]) {
					int temp = s[i]; s[i] = s[j]; s[j] = temp;
					temp = f[i]; f[i] = f[j]; f[j] = temp;
				}
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(0);
		int i = 0;
		for (int j = 1; j < n; j++)
			if (s[j] >= f[i]) {
				res.add(j);
				i = j;
			}
		for (i = 0; i < res.size(); i++)
			System.out.print(res.get(i) + " ");
	}
	
//	Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1. How to maximize total profit if only one job can be scheduled at a time.
//
//	Examples:
//
//	Input: Four Jobs with following deadlines and profits
//	  JobID    Deadline      Profit
//	    a        4            20   
//	    b        1            10
//	    c        1            40  
//	    d        1            30
//	Output: Following is maximum profit sequence of jobs
//	        c, a   
//
//
//	Input:  Five Jobs with following deadlines and profits
//	   JobID     Deadline     Profit
//	     a         2           100
//	     b         1           19
//	     c         2           27
//	     d         1           25
//	     e         3           15
//	Output: Following is maximum profit sequence of jobs
//	        c, a, e
	public static void jobSequence(int[] d, int[] p) {
		int n = d.length;
		int total = 0;
		//sort by decreasing profits
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (p[i] < p[j]) {
					int temp = p[i]; p[i] = p[j]; p[j] = temp;
					temp = d[i]; d[i] = d[j]; d[j] = temp;
				}
		//find max deadline
		int m = 0;
		for (int i = 0; i < n; i++)
			m = Math.max(m, d[i]);
		boolean[] free = new boolean[m + 1];
		Arrays.fill(free, true);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int slot = findSlot(i, d[i], free);
			if (slot != -1) {
				total += p[i];
				res.add(p[i]);
				free[slot] = false;
			}
		}
		
		//print result;
		System.out.println(total);
		for (int i = 0; i < res.size(); i++)
			System.out.println(res.get(i) + " ");
	}
	
	public static int findSlot(int u, int index, boolean[] free) {
		for (int i = index; i >= 1; i--)
			if (free[i])
				return i;
		return -1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] start =  {1, 3, 0, 5, 8, 5};
//		int[] finish =  {2, 4, 6, 7, 9, 9};
//		activitySelection(start, finish);
		int[] d = {2,1,2,1,3};
		int[] p = {100,19,27,25,15};
		jobSequence(d, p);
	}

}
