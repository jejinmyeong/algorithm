package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1194_달이차오른다가자 {
	
	static int N, M, ans = 987654321;
	static char [][] map;
	static int [][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	static boolean [][][] visited;
	static String locks = "ABCDEF";
	static String keys = "abcdef";
	static int INF = 987654321;
	
	static class point {
		int x, y, cnt;
		int key;
		public point(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		
		map = new char [N][M];
		visited = new boolean[N][M][64];
		
		int curX = 0, curY = 0;
		for (int i = 0 ; i < N ; i++) {
			String input = br.readLine();
			for (int j = 0 ; j < M ; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '0') {
					curX = i;
					curY = j;
				}
			}
		}
		
		bfs(curX, curY);
		
		if (ans == INF)ans = -1;
		System.out.println(ans);
	}
	
	static void bfs(int x, int y) {
		Queue<point> queue = new LinkedList<>();
		queue.offer(new point(x, y, 0, 0));
		
		while(!queue.isEmpty()) {
			point now = queue.poll();
			int cnt = now.cnt;
			int key = now.key;
			
			if (map[now.x][now.y] == '1') {
				if (ans > now.cnt) ans = now.cnt;
				return;
			}
			
			for (int d = 0 ; d < 4 ; d++) {
				
				int nx = now.x + D[d][0];
				int ny = now.y + D[d][1];
				
				if (nx < 0 || ny < 0 || nx >=N || ny >= M || visited[nx][ny][key] || map[nx][ny] == '#') continue;
								
				if (locks.contains(String.valueOf(map[nx][ny]))) {
					int door = (1 << (map[nx][ny] - 65)) & key;
					
					// 열쇠가 있으면
					if (door > 0) {
						visited[nx][ny][key] = true;
						queue.offer(new point(nx, ny, cnt+1, key));
					}else {
						continue;
					}
				} else if (keys.contains(String.valueOf(map[nx][ny]))) {
					int nKey = (1<< (map[nx][ny] - 97)) | key;
					
					if (!visited[nx][ny][nKey]) {
						visited[nx][ny][nKey] = true;
						visited[nx][ny][key] = true;
						queue.offer(new point(nx, ny, cnt+1, nKey));
					}
				} else {
					visited[nx][ny][key] = true;
					queue.offer(new point(nx, ny, cnt+1, key));
				}
			}
		}
	}
}
