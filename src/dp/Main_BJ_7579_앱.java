package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_7579_앱 {
	static class App {
		int mem, cost;

		public App(int mem, int cost) {
			super();
			this.mem = mem;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		App [] apps = new App[N+1];
		
		int maxMem = 0;
		final int INF = 1_000_000_001;
		
		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 1 ; i <= N ;i++) {
			apps[i] = new App(Integer.parseInt(st.nextToken()),Integer.parseInt(st2.nextToken()));
			if (maxMem < apps[i].mem) maxMem = apps[i].mem;
		}
		
		int [] dp = new int [M+1];
		int [] before;
		Arrays.fill(dp, INF);
		
		for (int i = 1 ; i <= N ; i++) {
			before = Arrays.copyOf(dp, M+1);
			for (int j = 1 ; j <= M ; j++) {
				if (j <= apps[i].mem) {
					dp[j] = Math.min(before[j], apps[i].cost);
				}else {
					dp[j] = Math.min(before[j], before[j - apps[i].mem] + apps[i].cost);
				}
			}
		}
		
		System.out.println(dp[M]);
	}
}
