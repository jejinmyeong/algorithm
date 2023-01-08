package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1753_최단경로 {
	static class Edge implements Comparable<Edge> {
		int end, weight;

		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int INF = 987654321;
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine());
		
		ArrayList<Edge> [] edgelist = new ArrayList[V+1];
		int [] distance = new int [V+1];
		
		Arrays.fill(distance, INF);
		
		for (int i = 1 ; i < V+1 ; i++) {
			edgelist[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgelist[start].add(new Edge(end, weight));
		}
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean [] visited = new boolean[V+1];
		queue.add(new Edge(S, 0));
		distance[S] = 0;
		
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			
			if(visited[cur.end]) continue;
			visited[cur.end] = true;
			
			for (Edge edge : edgelist[cur.end]) {
				if (distance[edge.end] > distance[cur.end]+ edge.weight) {
					distance[edge.end] = distance[cur.end] + edge.weight;
					queue.add(new Edge(edge.end, distance[edge.end]));
				}
			}
		}
		
		for (int i = 1 ; i < V+1 ; i++) {
			if(distance[i] == INF) System.out.println("INF");
			else System.out.println(distance[i]);
		}
		
		
	}
}