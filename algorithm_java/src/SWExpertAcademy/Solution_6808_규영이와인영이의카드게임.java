package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
	static int[] kCards;
	static int[] iCards;
	static int[] res;
	static boolean[] visited;
	static int win, lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			kCards = new int[9];
			iCards = new int[9];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				kCards[i] = Integer.parseInt(st.nextToken());
			}
			int idx = 0;
			C: for (int i = 1; i <= 18; i++) {
				for (int Kc : kCards) {
					if (Kc == i)
						continue C;
				}
				iCards[idx++] = i;
			}

			win = 0;
			lose = 0;
			visited = new boolean[iCards.length];
			res = new int[iCards.length];
			perm(0);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}

	static void perm(int n) {
		if (n == res.length) {
			game(res);
			return;
		}

		for (int i = 0; i < iCards.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				res[n] = iCards[i];
				perm(n + 1);
				visited[i] = false;
			}
		}

	}

	static void game(int[] res) {
		int kScore = 0;
		int iScore = 0;
		for (int i = 0; i < 9; i++) {
			if (kCards[i] > res[i]) {
				kScore += kCards[i] + res[i];
			} else if (kCards[i] < res[i]) {
				iScore += kCards[i] + res[i];
			}
		}

		if (kScore > iScore)
			win++;
		else if(kScore < iScore)
			lose++;
	}
}
