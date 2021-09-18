package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_BJ_17472_다리만들기2 {
	static class Edge implements Comparable<Edge>{
		int x, y, w;

		public Edge(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Edge [x=" + x + ", y=" + y + ", w=" + w + "]";
		}
		
		
	}
	
	static int N, M, size;
	static int [][] map;
	static boolean [][] visit;
	static int [][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	static ArrayList<ArrayList<int[]>> islands;
	static ArrayList<int[]> totalLand;
	static ArrayList<Edge> arr;
	static int [] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		islands = new ArrayList<>();
		
		totalLand = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) totalLand.add(new int [] {i, j});
			}
		}
		
		splitIsland();	// 각 섬 분리
		
		size = islands.size();
		
		arr = new ArrayList<>();
		parent = new int [size];
		
		bridge();	// 각 섬간 최소 다리 길이 구하기
		
		Collections.sort(arr);
		init();
		
		int ans = 0;
		for (int i = 0 ; i < arr.size() ; i++) {
			//System.out.println(Arrays.toString(parent));
			Edge edge = arr.get(i);
			if(!isSameParent(edge.x, edge.y)) {
				ans += edge.w;
				union(edge.x, edge.y);
			}
			
		}
		if (ans == 0) ans = -1;
		
		
//		for (Edge e : arr) {
//			System.out.println(e);
//		}
		
//		for(int i = 0 ; i < islands.size() ; i++) {
//			System.out.print("섬"+i+" : ");
//			for (int j = 0 ; j < islands.get(i).size(); j++) {
//				int [] cur = islands.get(i).get(j);
//				System.out.print("["+cur[0]+" "+cur[1]+"] ");
//			}
//			System.out.println();
//		}
		System.out.println(ans);
	}
	
	static void init() {
		for(int i = 0 ; i < size ; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) parent[y] = x;
	}
	
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) return true;
		else return false;
	}
	
	// 섬 분리하기 bfs
	public static void splitIsland() {
		
		int idx = 0;
		for (int [] land : totalLand) {
			int x = land[0];
			int y = land[1];
			
			if (visit[x][y]) continue;
			
			Queue<int[]> queue = new LinkedList<>();
			
			queue.offer(new int [] {x, y});
			
			islands.add(new ArrayList<>());
			while(!queue.isEmpty()) {
				int [] cur = queue.poll();
				int curX = cur[0];
				int curY = cur[1];
				
				if (visit[curX][curY]) continue;
				
				visit[curX][curY] = true;
				islands.get(idx).add(new int [] {curX, curY});
				
				for (int d = 0 ; d < 4 ; d++) {
					int nx = curX + D[d][0];
					int ny = curY + D[d][1];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					
					if (map[nx][ny] == 1) queue.offer(new int [] {nx, ny});
				}
			}
			idx++;
		}
	}
	// 각 섬의 연결 최소 값 구하기
	
	static void bridge() {
		for (int i = 0 ; i < size ; i++) {
			for (int j = i+1 ; j < size ; j++) {
				// x 인덱스 또는 y 인덱스가 같아야 직선으로 연결 가능
				ArrayList<int[]> i1 = islands.get(i);
				ArrayList<int[]> i2 = islands.get(j);
				int s1 = i1.size();
				int s2 = i2.size();
				int temp = Integer.MAX_VALUE;
				for (int m = 0 ; m < s1 ; m++) {
					for (int n = 0 ; n < s2 ; n++) {
						int x1 = i1.get(m)[0];
						int y1 = i1.get(m)[1];
						int x2 = i2.get(n)[0];
						int y2 = i2.get(n)[1];
						
						if (x1 != x2 && y1 != y2) continue;
						
						if (x1 == x2) {
							int res = available(x1, y1, y2, 0);
							//System.out.print("섬"+i+":"+x1+" "+y1 +" , 섬"+j+" :"+x2+" "+y2 +" res:"+ res);
							if (res > 1 && temp > res) {
								temp = res;
							}
							//System.out.println(" temp :"+temp);
						} else if (y1 == y2) {
							int res = available(y1, x1, x2, 1);
							//System.out.print("섬"+i+":"+x1+" "+y1 +" , 섬"+j+" :"+x2+" "+y2 +" res:"+ res);
							if (res > 1 && temp > res) {
								temp = res;
							}
							//System.out.println(" temp :"+temp);
						}
					}
				}
				//System.out.println("섬 "+i+" 섬"+j +"다리 최소값 :"+temp);
				if (temp > 1 && temp < Integer.MAX_VALUE) arr.add(new Edge(i, j, temp));
				
			}
		}
	}
	
	// 연결이 가능한지 여부 확인
	
	static int available(int v0, int v1, int v2, int d)	{
		int s = Math.min(v1, v2);
		int e = Math.max(v1, v2);
		
		int sum = 0;
		if (d == 0) {	// x 값이 같을 때
			for (int i = s+1 ; i < e ; i++) {
				if (map[v0][i] != 0) return -1;
				
				sum++;
			}
		} else {
			for (int i = s+1 ; i < e ; i++) {
				if (map[i][v0] != 0) return -1;
				
				sum++;
			}
		}
		
		return sum;
	}
	
}
