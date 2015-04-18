package RECAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphDemo {

	static int n;
	static int[][] a;
	static int[][] c;
	static int[][] f;
	static boolean[] free;
	static int[] component;
	static int[] tr;
	static int comCount;
	static final int oo = 1000000000;
	
	public static void readData() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		a = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				a[i][j] = 0;
		for (int k = 0; k < m; k++) {
			int i = in.nextInt();
			int j = in.nextInt();
			int c = in.nextInt();
			a[i][j] = c;
			a[j][i] = c;
		}
		
		free = new boolean[n + 1];
		component = new int[n + 1];
	}
	
	public static void bfs(int u, int com) {
		if (!free[u]) return;
		free[u] = false;
		component[u] = com;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(u);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 1; i <= n; i++) 
				if (free[i] && a[v][i] > 0) {
					queue.add(i);
					free[i] = false;
					component[i] = com;
				}
		}
		
	}
	
	public static void bfsTraverse() {
		Arrays.fill(free, true);
		Arrays.fill(component, 0);
		comCount = 0;
		for (int i = 1; i <= n; i++)
			if (free[i]) {
				comCount++;
				bfs(i, comCount);
			}
		for (int i = 1; i <= n; i++)
			System.out.print(component[i] + " ");
		System.out.println();
	}
	
	public static void dfs(int u, int com) {
		free[u] = false;
		component[u] = com;
		for (int i = 1; i <= n; i++)
			if (free[i] && a[u][i] > 0)
				dfs(i,com);
	}
	
	public static void dfsTraverse() {
		Arrays.fill(free, true);
		Arrays.fill(component, 0);
		comCount = 0;
		for (int i = 1; i <= n; i++)
			if (free[i]) {
				comCount++;
				dfs(i, comCount);
			}
		for (int i = 1; i <= n; i++)
			System.out.print(component[i] + " ");
		System.out.println();
	}
	
	public static boolean dfsWithLevel(int u, int[] lvl,int[] tr, int level) {
		lvl[u] = level;
		for (int i = 1; i <= n; i++) {
			if (i != u && lvl[i] != 0 && lvl[i] != level - 1 && a[u][i] > 0) {
				//print result
				int end = u;
				while (end != i) {
					System.out.print(end + " <- ");
					end = tr[end];
				}
				System.out.println(i);
				return true;
			}
			if (lvl[i] == 0 && a[u][i] > 0) {
				tr[i] = u;
				return dfsWithLevel(i, lvl, tr,level + 1);
			}
		}
		return false;
	}
	
	public static void findCycle() {
		Arrays.fill(free, true);
		int[] lvl = new int[n + 1];
		Arrays.fill(lvl, 0);
		int[] tr = new int[n + 1];
		Arrays.fill(tr, 0);
		boolean hasCycle = dfsWithLevel(1, lvl, tr, 1);
		System.out.println(hasCycle);
	}
	
	
	public static void dijk(int start, int end) {
		Arrays.fill(free, true);
		int[] d = new int[n + 1];
		
		int[][] c = a.clone();
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				if (c[i][j] == 0)
					c[i][j] = oo;
		
		for (int i = 0; i <= n; i++)
			d[i] = oo;
		d[start] = 0;
		
		int[] tr = new int[n + 1];
		Arrays.fill(tr, 0);
		
		for (int p = 1; p < n; p++) {
			int min = oo;
			int u = 0;
			for (int i = 1; i <= n; i++)
				if (free[i] && min > d[i]) {
					min = d[i];
					u = i;
				}
			if (u == end) break;
			free[u] = false;
			for (int i = 1; i <= n; i++)
				if (free[i] && d[i] > d[u] + c[u][i]) {
					d[i] = d[u] + c[u][i];
					tr[i] = u;
				}
		}
		if (d[end] == oo)
			return;
		System.out.println(d[end]);
		int v = end;
		ArrayList<Integer> path = new ArrayList<Integer>();
		while (v != start) {
			path.add(v);
			v = tr[v];
		}
		path.add(v);
		for (int i : path) 
			System.out.print(i + " ");
	}
	
	public static void prim() {
		Arrays.fill(free, true);
		int[] d = new int[n + 1];
		for (int i = 0; i <= n; i++)
			d[i] = oo;
		d[1] = 0;
		int[] tr = new int[n + 1];
		
		int[][] c = a.clone();
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				if (c[i][j] == 0)
					c[i][j] = oo;
		
		
		for (int p = 1; p < n; p++) {
			int min = oo;
			int u = 0;
			for (int i = 1; i <= n; i++) 
				if (free[i] && min > d[i]) {
					min = d[i];
					u = i;
				}
			if (u == 0) {
				System.out.println("Graph not conected");
				return;
			}
			free[u] = false;
			for (int i = 1; i <= n; i++)
				if (free[i] && d[i] > c[u][i]) {
					d[i] = c[u][i];
					tr[i] = u;
				}
					
		}
		int w = 0;
		for (int i = 2; i <= n; i++) {
			System.out.println(i + " --- " + tr[i]);
			w += c[i][tr[i]];
		}
		System.out.println(w);
	}
	
	public static boolean findPath(int start, int end) {
		tr = new int[n + 1];
		Arrays.fill(tr, 0);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (int v = 1; v <= n; v++)
				if (tr[v] == 0 && a[u][v] > f[u][v]) {
					tr[v] = u;
					if (v == end) {
						return true;
					}
					queue.add(v);
				}
		}
		return false;
	}
	
	public static void incFlow(int start, int end) {
		int delta = oo;
		int v = end;
		while (v != start) {
			int u = tr[v];
			if (c[u][v] - f[u][v] < delta)
				delta = c[u][v] - f[u][v];
			v = u;
		}
		v = end;
		while (v != start) {
			int u = tr[v];
			f[u][v] = f[u][v] + delta;
			c[u][v] = c[u][v] - delta;
			v = u;
		}
	}
	
	
	public static void maxFlow() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt();
		int t = in.nextInt();
		a = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				a[i][j] = 0;
		for (int k = 0; k < m; k++) {
			int i = in.nextInt();
			int j = in.nextInt();
			int c = in.nextInt();
			a[i][j] = c;
			a[j][i] = c;
		}

		f = new int[n + 1][n + 1];
		c = a.clone();
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				f[i][j] = 0;
		while (true) {
			if (!findPath(s,t)) break;
			incFlow(s,t);
		}
		
		//print result
		int res = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				if (f[i][j] > 0) {
					System.out.println("f["+i+","+j+"] = " + f[i][j]);
					if (i == s)
						res += f[i][j];
				}
		System.out.println(res);
	}
	
	public static void euler() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
		Stack<Integer> st = new Stack<Integer>();
		st.add(1);
		while (!st.isEmpty()) {
			int u = st.peek();
			for (int i = 1; i <= n; i++)
				if (a[u][i] > 0) {
					a[u][i] = 0;
					a[i][u] = 0;
					st.push(i);
					break;
				}
			if (u == st.peek()) {
				System.out.print(st.pop() + " ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readData();
//		dfsTraverse();
//		findCycle();
//		dijk(1,5);
//		prim();
//		maxFlow();
		euler();
	}

}
