package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		char[] tank = { '^', 'v', '<', '>' };

		int d = 0;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] maps = new char[H][W];

			// 현재 위치
			int x = 0;
			int y = 0;

			for (int i = 0; i < H; i++) {
				char map[] = br.readLine().toCharArray();

				for (int j = 0; j < W; j++) {
					maps[i][j] = map[j];
					// 처음에 S가 나올수 있으므로 처음에 방향을 정해줘야 함.
					if (maps[i][j] == '^') {
						d = 0;
						x = i;
						y = j;
					} else if (maps[i][j] == 'v') {
						d = 1;
						x = i;
						y = j;
					} else if (maps[i][j] == '<') {
						d = 2;
						x = i;
						y = j;
					} else if (maps[i][j] == '>') {
						d = 3;
						x = i;
						y = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			char[] command = br.readLine().toCharArray();

			for (int i = 0; i < N; i++) {
				if (command[i] == 'S') {
					int pox = x;
					int poy = y;
					while (true) {
						pox += (1 * dx[d]);
						poy += (1 * dy[d]);
						if (pox < 0 || pox >= H || poy < 0 || poy >= W) {
							break;
						}
						if (maps[pox][poy] == '*') {
							maps[pox][poy] = '.';
							break;
						} else if (maps[pox][poy] == '#') {
							break;
						}
					}

				} else {
					switch (command[i]) {
					case 'U':
						d = 0;
						maps[x][y] = '^';
						break;
					case 'D':
						d = 1;
						maps[x][y] = 'v';
						break;
					case 'L':
						d = 2;
						maps[x][y] = '<';
						break;
					case 'R':
						d = 3;
						maps[x][y] = '>';
					}
					if (x + (1 * dx[d]) >= 0 && x + (1 * dx[d]) < H && y + (1 * dy[d]) >= 0 && y + (1 * dy[d]) < W) {
						if (maps[x + (1 * dx[d])][y + (1 * dy[d])] == '.') {
							maps[x][y] = '.';
							x += (1 * dx[d]);
							y += (1 * dy[d]);
							maps[x][y] = tank[d];
						}
					}

				}
	
			}
			System.out.print("#" + tc + " ");
			for (int k = 0; k < H; k++) {
				for (int j = 0; j < W; j++) {
					System.out.print(maps[k][j]);
				}
				System.out.println();
			}

		}
	}

}
