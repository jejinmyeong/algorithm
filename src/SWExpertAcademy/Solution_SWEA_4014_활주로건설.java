package SWExpertAcademy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4014_활주로건설 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int[][] D = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N, X;

			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			int[][] map;
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			
			// 현재의 높이와 이전의 높이가 다른 경우에 두 높이의 차가 양수인 경우와 음수인 경우로 나누어 생각
			// 양수인 경우 -> 이전의 높이가 높다고 하고 다음 X 개의 map 값이 현재와 동일한지 확인
			// 음수인 경우 -> 이전의 높이가 낮다고 하고 이전 X 개의 map 값이 이전과 동일한지 확인
			// 가로방향 먼저 탐색
			loop: for (int i = 0; i < N; i++) {
				boolean[] visited = new boolean[N];
				for (int j = 1; j < N; j++) {
					boolean[] temp = new boolean[N];
					if (map[i][j - 1] != map[i][j]) {
						if (map[i][j - 1] - map[i][j] == 1) {
							int now = map[i][j];
							int ny = j;
							temp[ny] = true;
							for (int k = 0; k < X - 1; k++) {
								// 오른쪽 탐색
								ny += D[3][1];
								// 범위 확인
								if (ny >= N || map[i][ny] != now || visited[ny])
									continue loop;
								temp[ny] = true;
							}
							// 여기 까지 왔으면 높이차이 극복 가능
						} else if (map[i][j - 1] - map[i][j] == -1) {
							int now = map[i][j - 1];
							int ny = j - 1;
							temp[ny] = true;
							for (int k = 0; k < X - 1; k++) {
								ny += D[2][1];

								if (ny < 0 || map[i][ny] != now || visited[ny])
									continue loop;
								temp[ny] = true;
							}
						} else continue loop;
						// 여기 까지 왔으면 높이차이 극복 가능
						// 한번 사용한 활주로는 다시 사용할 수 없으므로 방문 체크
						// 활주로 건설에 성공한 부분 visited에 갱신
						for (int v = 0; v < N; v++) {
							visited[v] = visited[v] | temp[v];
						}
					}
				}
				ans++;
			}
			// 세로방향 탐색
			loop: for (int i = 0; i < N; i++) {
				boolean[] visited = new boolean[N];
				for (int j = 1; j < N; j++) {
					boolean[] temp = new boolean[N];
					if (map[j - 1][i] != map[j][i]) {
						if (map[j-1][i] - map[j][i] == 1) {
							int now = map[j][i];
							int nx = j;
							temp[nx] = true;
							for (int k = 0; k < X - 1; k++) {
								// 아래쪽 탐색
								nx += D[1][0];
								// 범위 확인
								if (nx >= N || map[nx][i] != now || visited[nx])
									continue loop;
								temp[nx] = true;
							}
							// 여기 까지 왔으면 높이차이 극복 가능
						} else if (map[j-1][i] - map[j][i] == -1) {
							int now = map[j-1][i];
							int nx = j - 1;
							temp[nx] = true;
							for (int k = 0; k < X - 1; k++) {
								nx += D[0][0];

								if (nx < 0 || map[nx][i] != now || visited[nx])
									continue loop;
								temp[nx] = true;
							}
						} else continue loop;
						// 여기 까지 왔으면 높이차이 극복 가능
						// 한번 사용한 활주로는 다시 사용할 수 없으므로 방문 체크
						// 활주로 건설에 성공한 부분 visited에 갱신
						for (int v = 0; v < N; v++) {
							visited[v] = visited[v] | temp[v];
						}
					}
				}
				ans++;
			}
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		
		System.out.println(sb);
	}
}
