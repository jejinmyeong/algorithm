package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_1939_중량제한 {
	static int N, M;
	static ArrayList<int []> [] nodes;
	static int [] weights;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[N+1];
		weights = new int[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1 ; i <= N ; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			nodes[start].add(new int [] {end, weight});
			nodes[end].add(new int [] {start, weight});
		}
		
		st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		dfs(s, e, 0);
		
		System.out.println(weights[e]);
		
	}
	static void dfs(int now, int end, int w) {
		
		if (weights[now] == 0 || weights[now] > w) {
			weights[now] = w;
		} else {
			return;
		}
		
		if (now == end) {
			return;
		}
		visited[now] = true;
		
		for (int i = 0 ; i < nodes[now].size() ; i++) {
			
			dfs(nodes[now].get(i)[0], end, Math.min(w, nodes[now].get(i)[1]));
		}
	}
}
