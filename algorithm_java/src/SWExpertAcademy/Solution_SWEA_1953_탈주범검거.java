package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1953_탈주범검거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		int[][] D = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 상 우 하 좌 상

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int N, M, R, C, L;

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int[] start = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			L = Integer.parseInt(st.nextToken());

			int[][] map;

			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 1 : 상하좌우 2 : 상하 3: 좌우 4: 상 -> 우 5: 하 -> 우 6: 하 -> 좌 7: 상 -> 좌

			Queue<int[]> queue = new LinkedList<>();
			
			boolean [][][] visited = new boolean[N][M][L+1];

			queue.offer(new int[] { start[0], start[1], 1 });
			int [][] dist = new int [N][M];
			visited[start[0]][start[1]][1] = true;

			while (!queue.isEmpty()) {
				int[] now = queue.poll();
//				System.out.println(Arrays.toString(now));
				
				int x = now[0];
				int y = now[1];
				int cnt = now[2];

				
				dist[x][y] = 1;
				
				if (cnt == L) continue;

				int s = 0;
				int e = 1;
				int t = 1;

				if (map[x][y] == 1) {
				} else if (map[x][y] == 2) {
					t = 2;
				} else if (map[x][y] == 3) {
					s = 1;
					t = 2;
				} else if (map[x][y] == 4) {
					e = 3;
				} else if (map[x][y] == 5) {
					s = 1;
					e = 2;
				} else if (map[x][y] == 6) {
					s = 2;
					e = 1;
				} else if (map[x][y] == 7) {
					s = 3;
					e = 0;
				}

				for (int d = s; d < 5 - e; d += t) {
					int nx = x + D[d][0];
					int ny = y + D[d][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || visited[nx][ny][cnt+1])
						continue;

					if (map[x][y] == 1) {
						if (d == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7))
							continue;
						else if (d == 1 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5))
							continue;
						else if (d == 2 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6))
							continue;
						else if (d == 3 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7))
							continue;
					} else if (map[x][y] == 2) {
						if (d == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7))
							continue;
						else if (d == 2 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6))
							continue;
					} else if (map[x][y] == 3) {
						if (d == 1 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5))
							continue;
						else if (d == 3 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7))
							continue;
					} else if (map[x][y] == 4) {
						if (d == 0 && (map[nx][ny] == 3 || map[nx][ny] == 7 || map[nx][ny] == 4))
							continue;
						else if (d == 1 && (map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 4))
							continue;
					} else if (map[x][y] == 5) {
						if (d == 1 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5))
							continue;
						else if (d == 2 && (map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 5))
							continue;
					} else if (map[x][y] == 6) {
						if (d == 2 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6))
							continue;
						else if (d == 3 && (map[nx][ny] == 2 || map[nx][ny] == 7 || map[nx][ny] == 6))
							continue;
					}else if (map[x][y] == 7) {
						if (d == 3 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7))
							continue;
						else if (d == 4 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7))
							continue;
					}
					
					visited[nx][ny][cnt+1] = true;
					queue.offer(new int[] { nx, ny, cnt + 1 });
				}
			}
			int ans = 0;
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < M ; j++) {
					if(dist[i][j] == 1) ans++;
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		
		System.out.println(sb);
	} // end Main
}
