package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEX_4012_요리사 {
	static int sumA, sumB;
	static int ans;
	static int[][] ingredient;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());

			ingredient = new int[N][N];

			int[] nums = new int[N];

			for (int i = 0; i < N; i++) {
				nums[i] = i;
			}

			int R = N/2;
			
			ans = Integer.MAX_VALUE;

			int[] res = new int[R];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ingredient[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			comb(0, 0, nums, res, N, R);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void comb(int cnt, int idx, int[] nums, int[] res, int N, int R) {
		
		if (cnt == R) {
			boolean [] selected = new boolean [N];
			int [] res2 = new int[R];
			int no = 0;
			for (int r : res) {
				selected[r] = true;
			}
			for (int i = 0 ; i < N ; i++) {
				if(selected[i]== false) res2[no++] = i;
			}
			sumA = 0; sumB = 0;
			for(int i = 0 ; i < R ; i++) {
				for (int j = i+1 ; j < R; j++) {
					sumA += ingredient[res[i]][res[j]]+ingredient[res[j]][res[i]];
					sumB += ingredient[res2[i]][res2[j]]+ingredient[res2[j]][res2[i]];
				}
			}
			int sub = Math.abs(sumA-sumB);
			if(sub < ans) ans  = sub;

			return;
		}

		for (int i = idx; i < N; i++) {
			res[cnt] = nums[i];
			comb(cnt + 1, i + 1, nums, res, N, R);
		}
	}
}
