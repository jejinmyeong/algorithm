package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1600_말이되고픈원숭이2 {
	static class Monkey {
		int x, y, k, cnt;

		public Monkey(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 방향 정의
		// 상 하 좌 우
		int [][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}};
		// 말의 움직임 8 방향
		int [][] HD = {{-2, -1},{-2, 1},{2, -1},{2, 1},{-1, -2},{-1 , 2},{1, -2},{1, 2}};
		
		int K = Integer.parseInt(br.readLine());
		
		int W, H;
		
		st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[H][W];
		boolean [][][] visited = new boolean[H][W][K+1];
		
		for (int i = 0 ; i< H ;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < W ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Monkey> queue = new LinkedList<>();
		
		visited[0][0][0] = true;
		queue.offer(new Monkey(0, 0, 0, 0));
		
		while (!queue.isEmpty()) {
			Monkey m = queue.poll();
			
			if (m.x == H-1 && m.y == W-1) {
				System.out.println(m.cnt);
				return;
			}
			
			for (int d = 0 ; d < 4 ; d++) {
				int nx = m.x + D[d][0];
				int ny = m.y + D[d][1];
				int cnt = m.cnt;
				int kCnt = m.k;
				
				if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1 || visited[nx][ny][kCnt]) continue;
				
				visited[nx][ny][kCnt] = true;
				queue.offer(new Monkey(nx, ny, kCnt, cnt+1));
			}
			if (m.k == K) continue;
			
			for (int d = 0 ; d < 8 ; d++) {
				int nx = m.x + HD[d][0];
				int ny = m.y + HD[d][1];
				int cnt = m.cnt;
				int kCnt = m.k +1;
				if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1 || visited[nx][ny][kCnt]) continue;
				
				visited[nx][ny][kCnt] = true;
				queue.offer(new Monkey(nx, ny, kCnt, cnt+1));
			}
		}
				System.out.println(-1);
		
	}
}
