package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9372_상근이의여행 {
	static class Edge {
		int start, end;

		public Edge(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
	}
	
	static void make() {
		parents = new int[N];
		for (int i = 0 ; i < N ; i++) {
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
	
	static int N, M;
	static Edge [] edgelist;
	static int [] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			edgelist = new Edge[M];
			
			for (int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				edgelist[i] = new Edge(start-1, end-1);
			}
			
			make();
			
			int result = 0 , cnt = 0;
			
			for (int i = 0 ; i < M ; i++) {
				if (union(edgelist[i].start, edgelist[i].end)) {
					result += 1;
					if (++cnt == N-1) break;
				}
			}
			
			sb.append(result+"\n");
			
		}
		
		System.out.println(sb);
		
	}
}
