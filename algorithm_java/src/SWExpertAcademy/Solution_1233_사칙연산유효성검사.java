package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int ans = 1;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				char c = st.nextToken().charAt(0);
				if(c == '+' || c == '-' || c == '/' || c == '*') {
					if(!st.hasMoreTokens()) {
						ans = 0;
					}
				}else {
					if(st.hasMoreTokens()) {
						ans = 0;
					}
				}
			}

			System.out.println("#"+tc+" "+ans);
		}
	}
}
