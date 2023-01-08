package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2629_양팔저울 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int [] weights = new int [N];
		for (int i = 0 ; i < N ; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int [] res = new int [K];
		int maxW = 0;
		int total = 0;
		
		for (int i = 0 ; i < K ; i++) {
			res[i] = Integer.parseInt(st.nextToken());
			total += res[i];
			if(res[i] > maxW) maxW = res[i];
		}
		
		int [] dp = new int [maxW+total+1];
		dp[0] = 1;
		int temp = 0; // 현재 사용된 추의 총 합
		
		for (int i = 0 ; i < N ; i++) {
			temp += weights[i];
			for (int j = weights[i] ; j <= temp ; j++) {
				dp[j] += dp[j-weights[i]];
			}
			System.out.println(Arrays.toString(dp));
		}
		
		for (int i = 0 ; i < K ; i++) {
			boolean flag = false;
			if (dp[res[i]]>0) {
				sb.append("Y"+" ");
				continue;
			}
			for (int j = 0 ; j < N ; j++) {
				if (dp[res[i]+weights[j]]>0) {
					sb.append("Y"+" ");
					flag = true;
					break;
				}
			}
			if (!flag) sb.append("N"+" ");
		}
		System.out.println(sb);
	}
}
