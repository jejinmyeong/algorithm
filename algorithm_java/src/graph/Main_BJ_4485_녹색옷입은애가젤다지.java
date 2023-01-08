package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_4485_녹색옷입은애가젤다지 {
	static class Node implements Comparable<Node>{
		int end, weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		final int INF = 100_000_000;
		int [][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}};
		int idx = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if (N == 0) break;
			
			ArrayList<Node> [] nodes = new ArrayList[N*N+1];
			
			for (int i = 0 ; i <= N*N ; i++) {
				nodes[i] = new ArrayList<>();
			}
			
			int start = 0;
			
			for (int i = 1 ; i <= N ; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1 ; j <= N ; j++) {
					int w = Integer.parseInt(st.nextToken());
					if (i == 1 && j == 1) start = w;
					for (int d = 0 ; d < 4 ; d++) {
						int nx = i+D[d][0];
						int	ny = j+D[d][1];
						
						if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
						
						nodes[(nx-1)*N+ny].add(new Node((i-1)*N+j, w));
						
					}
					
						
				}
			}
			
			PriorityQueue<Node> queue = new PriorityQueue<>();
			queue.add(new Node(1, 0));
			int [] dist = new int[N*N+1];
			Arrays.fill(dist, INF);
			
			boolean [] visited = new boolean[N*N+1];
			dist[1] = start;
			
			while(!queue.isEmpty()) {
				Node now = queue.poll();
				int cur = now.end;
				
				if (visited[cur]) continue;
				visited[cur] = true;
				
				for (Node node : nodes[cur]) {
					if (dist[node.end] > dist[cur]+node.weight) {
						dist[node.end] = dist[cur]+node.weight;
						queue.add(new Node(node.end , dist[node.end]));
					}
				}
			}
			sb.append("Problem "+(idx++)+": "+dist[N*N]+"\n");
		}
		System.out.println(sb);
	}
}
