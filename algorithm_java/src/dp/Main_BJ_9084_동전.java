package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9084_동전 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0 ; tc < T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int [] coins = new int[N];
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(br.readLine());
			
			for (int i = 0 ; i < N ; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			
			int [] dp = new int [K+1];
			dp[0] = 1;
			
			for (int i = 0 ; i < N ; i++) {
				for (int j = coins[i] ; j <= K ; j++) {
					dp[j] += dp[j - coins[i]];
				}
			}
			
			sb.append(dp[K]+"\n");
		}
		System.out.println(sb);
		
	}
}
