package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;

			char[] farm = new char[N];

			for (int i = 0; i < N; i++) {
				farm = br.readLine().toCharArray();
				for(int j = Math.abs(i- N/2); j < N-Math.abs(i- N/2);j++) {
					ans+=farm[j]-'0';
				}
			}


			sb.append("#" + tc + " "+ans+"\n");
		}
		
		System.out.println(sb);

	}
}
