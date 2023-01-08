package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_3109_빵집 {
	static int R, C;
	static char[][] map;
	static int[][] directions = { { 1, -1 }, { 1, 0 }, { 1, 1 } }; // 대각선 위, 오른쪽, 대각선 아래

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());	// 열 개수
		C = Integer.parseInt(st.nextToken());	// 행 개수

		map = new char[R][C];					// map

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int ans = 0;
		
		for(int i = 0 ; i < R ; i++) {
			if(stealGas(0, i)) ans++;
//			for(int j = 0 ; j < R ; j++ ) {
//				System.out.println(Arrays.toString(map[j]));
//			}
//			System.out.println();
		}
		
		System.out.println(ans);

	}

	static boolean stealGas(int x, int y) {
		if (x == C - 1) {	// map의 제일 오른쪽 끝에 도착하면
			return true;
		}
		
		map[y][x] = 'o';

		for (int i = 0; i < 3; i++) {
			int nextX = x + directions[i][0];	// 다음  x좌표
			int nextY = y + directions[i][1];	// 다음  y좌표
			
			//System.out.println("x :"+nextX+" y :"+nextY);

			if (nextX >= C || nextY < 0 || nextY >= R || map[nextY][nextX] == 'x' || map[nextY][nextX] == 'o') // map 범위를 벗어나는지? 이동하는 곳이 건물인지? 이미 지나간 곳인지? 체크
				continue;
			map[nextY][nextX] = 'o';
			
			if(stealGas(nextX, nextY)) return true;
			
			map[nextY][nextX] = '.';
		}
		
		map[y][x] = '.';
		
		return false;
	}
}
