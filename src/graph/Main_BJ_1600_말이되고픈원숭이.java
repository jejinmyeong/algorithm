package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1600_말이되고픈원숭이 {
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
		int [][][] dp = new int[H][W][K+1];
		
		for (int i = 0 ; i< H ;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < W ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dp 채우기 사전에 큰 값으로 초기화
		// 방법 : 먼저 인접으로 가는 경우로 모두 채움
		// 말의 이동을 사용하면 dp의 3번째 값을 늘려가면서 해당 지점을 채움
		// 도착한 지점에서 나머지 부분을 인접으로만 채움
		// k번째 말의 이동을 할 경우에는 dp k-1번째 이동 값을 이용하여 채움
		
		for (int i = 0 ;i < H ; i++) {
			for (int  j = 0 ; j < W ; j++) {
				for (int k = 0 ; k <= K ; k++) {
					dp[i][j][k] = 999999999;
				}
			}
		}
		/// 출발 지점 값 0으로 변경
		for (int k = 0 ; k <= K ; k++) {
			dp[0][0][k] = 0;
		}
		
		for (int k = 0 ; k <= K ; k++) {
			if (k != 0)
				for (int i = 0 ; i < H ; i++) {
					for (int j = 0 ; j < W ; j++) {
						if (map[i][j] == 1) continue;
						// k가 0이면 인접된 영역으로만 이동
						
						for (int hd = 0 ; hd < 8 ; hd++) {
							int nx = i + HD[hd][0];
							int ny = j + HD[hd][1];
							
							// 유효 범위 검사 map의 범위를 벗어 나는경우, 장애물로 막혀있는 경우
							if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1) continue;
							
							dp[nx][ny][k] = Math.min(dp[nx][ny][k], dp[i][j][k-1]+1);
						}
					}
				}
			for (int i = 0 ; i < H ; i++) {
				for (int j = 0 ; j < W ; j++) {
					for (int d = 0 ; d < 4 ;d++) {
						int nx = i + D[d][0];
						int ny = j + D[d][1];
	
						// 유효 범위 검사 map의 범위를 벗어 나는경우, 장애물로 막혀있는 경우
						if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1) continue;
						
						dp[nx][ny][k] = Math.min(dp[nx][ny][k], dp[i][j][k-1]+1);
					}
				}
			}
		}
		
//		for (int i = 0 ; i < H ; i++) {
//			for (int j = 0 ; j < W ; j++) {
//				System.out.print("[");
//				for (int k = 0 ; k <= K ; k++) {
//					System.out.print(dp[i][j][k]+" ");
//				}
//				System.out.print("]");
//			}
//			System.out.println();
//		}
		
		int ans = dp[H-1][W-1][0];
		for (int k = 1 ; k <= K ; k++) {
			if (ans>dp[H-1][W-1][k]) ans = dp[H-1][W-1][k];
		}
		if (ans == 999999999) ans = -1;
		System.out.println(ans);
		
	}
}
