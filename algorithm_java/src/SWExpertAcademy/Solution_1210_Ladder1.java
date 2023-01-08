package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int num = Integer.parseInt(br.readLine());

			int[][] ladders = new int[100][100];
			List<Integer> frist = new ArrayList<>();

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladders[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0 && ladders[i][j] == 1)
						frist.add(j);
				}
			}

			int x, y = 0;
			String flag = null;
			int ans = 0;
			end: for (int i = 0; i < frist.size(); i++) {
				x = frist.get(i);
				ans = x;
				while (true) {
					if (y == 99) {
						if (ladders[y][x] == 2) {
							break end;
						}
						y = 0;
						break;
					}

					if (x > 0 && (flag == null || flag == "left") && ladders[y][x - 1] == 1) {
						if (flag == null)
							flag = "left";
						x -= 1;

					} else if (x < 99 && (flag == null || flag == "right") && ladders[y][x + 1] == 1) {
						if (flag == null)
							flag = "right";
						x += 1;
					} else {
						y += 1;
						flag = null;
					}
				}
			}

			System.out.println("#" + test_case + " " + ans);

		}
	}
}
