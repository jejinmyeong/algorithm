package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_1249_보급로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = 987654321;
		int [][] D = {{-1, 0},{1, 0},{0, -1},{0, 1}};
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int [][] map = new int [N][N];
			for (int i = 0 ; i < N ; i++) {
				String st = br.readLine();
				for (int j = 0 ; j < N ; j++) {
					map[i][j] = st.charAt(j) - '0';
				}
			}
			Queue<int []> queue = new LinkedList<>();
			int [][] dist = new int [N][N];
			boolean [][] visited = new boolean[N][N];
			
			for (int i = 0 ; i < N ; i++) {
				Arrays.fill(dist[i], INF);
			}
			
			queue.offer(new int [] {0, 0});
			dist[0][0] = map[0][0];
			visited[0][0] = true;
			
			while(!queue.isEmpty()) {
				int [] now = queue.poll();
				
				
				for (int d = 0 ; d < 4 ; d++) {
					int nx = now[0] + D[d][0];
					int ny = now[1] + D[d][1];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					
					if (!visited[nx][ny] || dist[nx][ny] > dist[now[0]][now[1]] + map[nx][ny]) {
						dist[nx][ny] = dist[now[0]][now[1]] + map[nx][ny];
						visited[nx][ny] = true;
						queue.offer(new int [] {nx, ny});
					}
				}
				
			}
			
			sb.append("#"+tc+" "+dist[N-1][N-1]+"\n");
			
		}
		System.out.println(sb);
		
	}
}
