package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2293_동전1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] dp = new int [k+1];
		int [] type = new int [n];
		
		for (int i = 0 ; i < n ; i++) {
			type[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(type);
		
		int minCoin = type[0];
		
		dp[minCoin] = 1;
		
		for (int i = minCoin+1 ; i <= k ; i++) {
			int temp = 0;
			for (int j = 0 ; j < n ; j++) {
				if (i - type[j] > 0) break;
				if (i % type[j] == 0) temp++;
				temp+= dp[i-type[j]];
			}
			dp[i] = temp;
		}
		
		System.out.println(Arrays.toString(dp));
		
		
	}
}
