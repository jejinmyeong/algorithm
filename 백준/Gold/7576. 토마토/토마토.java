import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Tomato{
		int x, y, day;

		public Tomato(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
	}
	static int M,N,ans;
	static int [][] d = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	static Queue<Tomato> queue;
	static int [][] matrix;
	static int tNum, ttNum;
	static boolean [][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		matrix = new int[N][M];
		visited = new boolean[N][M];
		
		queue = new LinkedList<>();
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < M ; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (matrix[i][j] == 1) {
					tNum++;
					ttNum++;
					queue.offer(new Tomato(i, j, 0));
				}else if (matrix[i][j] == 0) {
					ttNum++;
				}
			}
		}
		if (tNum == ttNum) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
		if (tNum == ttNum) {
			System.out.println(ans);
		}else System.out.println(-1);
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			Tomato t = queue.poll();
			
			for (int i = 0 ; i < 4 ; i++) {
				int nx = t.x + d[i][0];
				int ny = t.y + d[i][1];
				int tday = t.day+1;
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				if (matrix[nx][ny] == 0) {
					if (tday > ans) ans = tday;
					matrix[nx][ny] = 1;
					tNum++;
					queue.offer(new Tomato(nx, ny, tday));
				}
			}
		}
	}
}
