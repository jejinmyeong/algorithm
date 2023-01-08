package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_5644_무선충전 {
	static int sum;

	static class AP implements Comparable<AP> {
		int x;
		int y;
		int c;
		int p;

		public AP(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(AP o) {
			// TODO Auto-generated method stub
			return o.p - this.p;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st2;

		int[][] d = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // X상우하좌

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 총 이동시간
			int A = Integer.parseInt(st.nextToken()); // BC의 개수

			int[] curA = { 1, 1 };
			int[] curB = { 10, 10 };

			sum = 0;

			int[] moveInfoA = new int[M];
			int[] moveInfoB = new int[M];
			AP[] ap = new AP[A];

			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveInfoA[i] = Integer.parseInt(st.nextToken());
				moveInfoB[i] = Integer.parseInt(st2.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				ap[i] = new AP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			List<AP> s1 = scope(curA[1], curA[0], ap);
			List<AP> s2 = scope(curB[1], curB[0], ap);

			Collections.sort(s1);
			Collections.sort(s2);

			sum(s1, s2);

			for (int i = 0; i < M; i++) {
				curA[1] += d[moveInfoA[i]][1];
				curA[0] += d[moveInfoA[i]][0];
				curB[1] += d[moveInfoB[i]][1];
				curB[0] += d[moveInfoB[i]][0];
				s1 = scope(curA[1], curA[0], ap);
				s2 = scope(curB[1], curB[0], ap);

				Collections.sort(s1);
				Collections.sort(s2);

				sum(s1, s2);
			}
			System.out.println("#" + tc + " " + sum);
		}

	}

	static List<AP> scope(int x, int y, AP[] ap) {
		List<AP> in = new ArrayList<AP>();

		for (AP a : ap) {
			if (Math.abs(x - a.x) + Math.abs(y - a.y) <= a.c)
				in.add(a);
		}

		return in;
	}

	static void sum(List<AP> s1, List<AP> s2) {
		int s1Size = s1.size(), s2Size = s2.size();
		if (s1Size != 0 && s2Size != 0) {
			if (s1.get(0) != s2.get(0)) {
				sum += s1.get(0).p;
				sum += s2.get(0).p;
			} else {
				if (s1Size + s2Size == 2) {
					sum += s1.get(0).p;
				} else if (s1Size == 1 || s2Size == 1) {
					if (s1Size > s2Size) {
						sum += s1.get(1).p + s2.get(0).p;
					} else {
						sum += s1.get(0).p + s2.get(1).p;
					}
				} else {
					if (s1.get(1).p > s2.get(1).p) {
						sum += s1.get(1).p + s2.get(0).p;
					} else {
						sum += s1.get(0).p + s2.get(1).p;
					}

				}
			}

		} else if (s1Size != 0) {
			sum += s1.get(0).p;

		} else if (s2Size != 0) {
			sum += s2.get(0).p;
		}
	}
}
