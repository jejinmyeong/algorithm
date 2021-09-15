package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2636_치즈 {
	static int H, W , cnt, time, ans;
	static int [][] map;
	static boolean [][] visited;
	static int [][] d = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int [H][W];
		
		for (int i = 0 ; i < H ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < W ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cnt++;
			}
		}
		
		time = 0;
		while (true) {
			if (cnt == 0) break;
			ans = cnt;
			thawCheese();
			
		}
		
		System.out.println(time);
		System.out.println(ans);
	}
	
	static void thawCheese() {
		time++;
		Queue<int[]> q = new LinkedList<int[]>();
		
		visited = new boolean[H][W];
		
		q.offer(new int [] {0,0});
		visited[0][0] = true;
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			
			for (int i = 0 ; i < 4 ; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= H || ny < 0 || ny >= W || visited[nx][ny]) continue;
				
				if (map[nx][ny] == 1) {
					cnt--;
					map[nx][ny] = 0;
				} else {
					q.offer(new int [] {nx, ny});
				}
				visited[nx][ny] = true;
			}
		}
	}
}
