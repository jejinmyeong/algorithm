package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {
	static int N;
	static int[] scores;
	static int[] kals;
	static int amount;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			amount = Integer.parseInt(st.nextToken());

			scores = new int[N];
			kals = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				kals[i] = Integer.parseInt(st.nextToken());
			}
			ans = 0;
			dfs(0, 0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int sum, int score, int index) {
		if (sum > amount)
			return;
		if (index == N) {
			if (score > ans)
				ans = score;
			return;
		}
		// 해당 인덱스의 재료를 선택했을 때
		dfs(sum + kals[index], score + scores[index], index + 1);
		// 해당 인덱스의 재료를 선택하지 않았을 때
		dfs(sum, score, index + 1);

	}
}
