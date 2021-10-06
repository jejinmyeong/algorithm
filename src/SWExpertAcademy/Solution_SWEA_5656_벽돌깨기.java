package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5656_벽돌깨기 {

	static int N, W, H, total; // N : 떨어뜨릴 구슬 개수 W : 열길이 H : 행길이
	static int ans;
	static int[][] map;
	static int[][] D = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			
			total = 0;
			// map 채우기
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						total++;
				}
			}

			ans = total;

			dropMarble(0, 0);
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}

	static void dropMarble(int cnt, int broken) {
		if (cnt == N) {
			ans = Math.min(ans, total - broken);
//			for (int i = 0 ; i < H ; i++) {
//				for (int j = 0 ; j < W ; j++) {
//					System.out.print(map[i][j] +" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			return;
		}

		// 맵 복사
		int[][] cMap = new int[H][W];
		copyArray(cMap);

		Queue<int[]> queue = new LinkedList<>();
		// 0열 ~ W-1 열 까지 구슬을 떨어뜨림
		for (int i = 0; i < W; i++) {
			int temp = 0;
			// 제일 위 벽돌 찾기
			for (int j = 0; j < H; j++) {
				// 벽돌이 존재하면 queue에 추가하고 반복문 탈출
				if (map[j][i] != 0) {
					// {x좌표, y좌표, pow}
					queue.add(new int[] { j, i, map[j][i] });
					temp++;
					map[j][i] = 0;
					break;
				}
			}
			// 연쇄적으로 벽돌 부수기 총 부순 벽돌 개수 카운트
			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				if (now[2] == 1) {
					continue;
				}

				// 상하좌우 c 칸만큼 반복 pow가 2이면 1회 3면 2회
				for (int b = 1; b < now[2]; b++) {

					// d = 0 : 상 1 : 하 2 : 좌 3 : 우
					for (int d = 0; d < 4; d++) {
						int nx = now[0] + D[d][0] * b;
						int ny = now[1] + D[d][1] * b;

						// 범위 체크
						if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 0)
							continue;

						queue.offer(new int[] { nx, ny, map[nx][ny] });
						map[nx][ny] = 0;
						temp++;
					}
				}

			}

			// map에 빈칸 생긴거 채우기
			dropMap();
			// 다음으로
			dropMarble(cnt + 1, broken+temp);
			// 이전상태로 맵 되돌리기
			returnArray(cMap);
		}
	}

	static void copyArray(int[][] cMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				cMap[i][j] = map[i][j];
			}
		}
	}

	static void returnArray(int[][] cMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = cMap[i][j];
			}
		}
	}

	static void dropMap() {
		for (int i = 0; i < W; i++) {
			int fst = -1; // 최초 0의 위치
			for (int j = H - 1; j >= 0; j--) {
				// fst에 값이 없고 map이 0 이면 가장 낮은위치에 0이 존재하는 것
				if (map[j][i] == 0 && fst == -1) {
					fst = j;
				}
				// 아랫쪽에 0이 존재하고 위 벽돌이 존재하는 경우
				else if (fst != -1 && map[j][i] != 0) {
					map[fst][i] = map[j][i];
					map[j][i] = 0;
					fst -= 1;
					j = fst;
				}
			}
		}
	}
}
