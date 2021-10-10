package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_4013_특이한자석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());

			Deque<Integer>[] mag = new ArrayDeque[4];

			for (int i = 0; i < 4; i++) {
				mag[i] = new ArrayDeque<>();
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					mag[i].add(Integer.parseInt(st.nextToken()));
				}
			}

			int[][] roMag = new int[K][2];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				roMag[k][0] = Integer.parseInt(st.nextToken());
				roMag[k][1] = Integer.parseInt(st.nextToken());
			}

			int ans = 0;

			for (int k = 0; k < K; k++) {
				int idx = roMag[k][0] - 1; // 자석의 인덱스
				int d = roMag[k][1]; // 방향
				int dd = roMag[k][1];

				Queue<int[]> queue = new LinkedList<>();
				
				queue.offer(new int [] {idx, d});

				// 첫 자석 기준으로 옆 자석에 영향을 미치는지 확인
				// 기준 자석보다 오른쪽에 있는 경우 현재 자석의 2번째 인덱스와 다음 자석 6번째 인덱스 비교
				for (int i = idx; i < 3; i++) {
					int m1 = -1; // 현재 자석의 2번째 인덱스 추출
					int m2 = -1; // 현재 자석의 6번째 인덱스 추출
					d *= -1;

					// 현재 자석의 앞 2개를 맨뒤로 보낸다.
					for (int r = 0; r < 2; r++) {
						mag[i].offer(mag[i].poll());
					}
					// 다음 자석의 뒤 2개를 맨 앞으로 보낸다.
					for (int r = 0; r < 2; r++) {
						mag[i + 1].push(mag[i + 1].pollLast());
					}

					m1 = mag[i].peekFirst();
					m2 = mag[i + 1].peekFirst();

					// 다음 자석을 원래 상태로 되돌림
					for (int r = 0; r < 2; r++) {
						mag[i + 1].offer(mag[i + 1].poll());
					}
					// 현재 자석을 원래 상태로 되돌림
					for (int r = 0; r < 2; r++) {
						mag[i].push(mag[i].pollLast());
					}

					// 다른 극이면 회전을 해야하니 다음 자석의 인덱스와 회전 방향 queue에 삽입
					if (m1 != m2) {
						queue.add(new int[] { i + 1, d });
					} else {
						break;
					}
				}

				// 기준 자석보다 왼쪽에 있는 경우
				for (int i = idx; i > 0; i--) {
					int m1 = -1;
					int m2 = -1;
					dd *= -1;

					// 이전 자석의 앞 두개를 뒤로 옮김
					for (int r = 0; r < 2; r++) {
						mag[i - 1].offer(mag[i - 1].poll());
					}
					// 현재 자석의 뒤 두개를 앞으로 이동 시킴
					for (int r = 0; r < 2; r++) {
						mag[i].push(mag[i].pollLast());
					}
					
					m1 = mag[i - 1].peekFirst();
					m2 = mag[i].peekFirst();

					for (int r = 0; r < 2; r++) {
						mag[i].offer(mag[i].poll());
					}
					for (int r = 0; r < 2; r++) {
						mag[i - 1].push(mag[i - 1].pollLast());
					}

					if (m1 != m2) {
						queue.add(new int[] { i - 1, dd });
					} else {
						break;
					}
				}
				
				while (!queue.isEmpty()) {
					int[] temp = queue.poll();

					if (temp[1] == 1) {
						mag[temp[0]].push(mag[temp[0]].pollLast());
					} else {
						mag[temp[0]].offer(mag[temp[0]].poll());
					}
				}

			}
			for (int c = 0; c < 4; c++) {
				if (mag[c].peekFirst() == 1) {
					ans += Math.pow(2, c);
				}
			}

			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
