package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14502_연구소 {
	static int N, M, ans;
	static int [][] map;
	static int [][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < M ; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
			}
		}
		
		makeWall(0);
		
		System.out.println(ans);
	}
	static void makeWall(int cnt) {
		if (cnt == 3) {
			int temp = cntSafety(spreadVirus());
			if (ans< temp) ans = temp;
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if (map[i][j] != 0) continue;
				
				map[i][j] = 1;
				makeWall(cnt+1);
				map[i][j] = 0;
			}
		}
	}
	
	static int[][] spreadVirus() {
		Queue<int[]> queue = new LinkedList<>();
		
		int [][] vMap = new int[N][M];
		copyMap(vMap);
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if (vMap[i][j] == 2) queue.offer(new int [] {i, j});
			}
		}
		
		while(!queue.isEmpty()) {
			int [] v = queue.poll();
			
			for (int d = 0 ; d < 4 ; d++) {
				int nx = v[0] + D[d][0];
				int ny = v[1] + D[d][1];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if (vMap[nx][ny] == 0) {
					vMap[nx][ny] = 2;
					queue.offer(new int [] {nx, ny});
				}
			}
		}
		
		return vMap;
	}
	static void copyMap(int [][] cMap) {
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j< M ; j++) {
				cMap[i][j] = map[i][j];
			}
		}
	}
	
	static int cntSafety(int [][] vMap) {
		int ans = 0;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if (vMap [i][j] == 0) ans++;
			}
		}
		return ans;
	}
}

