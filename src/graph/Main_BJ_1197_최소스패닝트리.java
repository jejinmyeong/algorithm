package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_BJ_1197_최소스패닝트리 {
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static void make() {
		parents = new int [V];
		
		for (int i = 0 ; i < V ; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int V, E;
	static Edge [] edgelist;
	static int [] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgelist = new Edge[E];
		
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgelist[i] = new Edge(start-1, end-1, weight);
		}
		
		Arrays.sort(edgelist);
		
		make();
		
		int cnt = 0, result = 0;
		
		for (int i = 0 ; i < E ; i++) {
			if (union(edgelist[i].start, edgelist[i].end)) {
				result += edgelist[i].weight;
				if (++cnt == V-1) break;
			}
		}
		
		System.out.println(result);
	}
}
