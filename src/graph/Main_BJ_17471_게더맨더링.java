package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17471_게더맨더링 {
	static int N, ans;
	static int [] pop;
	static ArrayList<Integer> [] nodes;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		pop = new int[N+1];
		nodes = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1 ; i <= N ; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(st.nextToken());
			
			nodes[i] = new ArrayList<>();
			for (int j = 0 ; j < end ; j++) {
				nodes[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		ans = Integer.MAX_VALUE;
		subSet(1);
		if (ans == Integer.MAX_VALUE) ans = -1;
		
		System.out.println(ans);
		
	}
	
	static void subSet(int idx) {
		if (idx == N+1) {
			if (isConn()) {
				int sumA = 0, sumB = 0;
				for (int i = 1 ; i <= N ; i++) {
					if (visited[i]) sumA += pop[i];
					else sumB += pop[i];
				}
				
				ans = Math.min(ans, Math.abs(sumA-sumB));
			}
			return;
		}
		
		visited[idx] = true;
		subSet(idx+1);
		visited[idx] = false;
		subSet(idx+1);
		
	}
	
	static boolean isConn() {
		boolean [] v = new boolean[N+1];
		
		int startA = -1;
		for (int i = 1 ; i <= N ; i++) {
			if (visited[i]) {
				startA = i;
				break;
			}
		}
		int startB = -1;
		for (int i = 1 ; i <= N ; i++) {
			if (!visited[i]) {
				startB = i;
				break;
			}
		}
		
		if (startA == -1 || startB == -1) return false;
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(startA);
		v[startA] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 0 ; i < nodes[now].size() ; i++) {
				if (v[nodes[now].get(i)]) continue;
				if (!visited[nodes[now].get(i)]) continue;
				v[nodes[now].get(i)] = true;
				queue.add(nodes[now].get(i));
			}
		}
		
		queue.offer(startB);
		v[startB] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 0 ; i < nodes[now].size() ; i++) {
				if (v[nodes[now].get(i)]) continue;
				if (visited[nodes[now].get(i)]) continue;
				v[nodes[now].get(i)] = true;
				queue.add(nodes[now].get(i));
			}
		}
		
		for (int i = 1 ; i <= N ; i++) {
			if (!v[i]) return false;
		}
		
		return true;
		
	}
}
