package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_12851_숨바꼭질2 {
	static int ans, cnt, end;
	static int N, K;
	static int dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		ans = Math.abs(K - N); // 최장 시간
		if (ans == 0) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		if (ans == 1) {
			System.out.println(1);
			System.out.println(1);
			return;
		}
		cnt = 1; // 방법의 수
		dp = new int[100_001];
		
		if (K*2 < 100_000) {
			end = K*2;
		}else {
			end = 100_000;
		}
		
		for (int i = 0; i <= end; i++) {
			dp[i] = Math.abs(i - N);
		}

		dfs(N, 0);

		System.out.println(ans);
		System.out.println(cnt);
	}

	static void dfs(int x, int t) {
		// 현재 걸린 시간이 총 최소시간보다 큰경우 리턴
		if (t > ans) {
			return;
		}
		// 현재 걸린시간이 최소시간보다 작거나 같으면서 수빈이의 위치와 동생의 위치가 같은경우
		if (x == K) {
			// 걸린시간이 전체 최소시간보다 짧으면
			// 최소 시간을 t로 update하고
			// 현재까지의 방법의 수를 0으로 초기와
			if (ans > t) {
				ans = t;
				cnt = 1;
			}
			// 걸린시간과 최소시간이 같으면
			// 방법의 수를 1 추가
			// 방법의 수가 똑같은 경우가 생기는지 확인
			else if (ans == t) {
				cnt++;
			}
			return;
		}

		// 왼쪽으로 가는 경우, 오른쪽으로 가는 경우, 순간이동 하는 경우 모두 탐색
		// 점의 영역 확인
		// 현재 위치에서 순간이동했을때 위치가 범위 안인경우 *2를 했을 때 0보다 작은 경우는 없다
		if (x != 0 && x * 2 <= end) {
			if (dp[2 * x] >= t + 1) {
				dp[2 * x] = t + 1;
				dfs(2 * x, t + 1);
			}
		}
		// 현재 위치에서 왼쪽으로 이동했을 때 위치가 0보다 크거나 같은 경우
		if (x - 1 >= 0) {
			if (dp[x - 1] >= t + 1) {
				dp[x - 1] = t + 1;
				dfs(x - 1, t + 1);
			}
		}
		// 현재 위치에서 오른쪽으로 이동했을 때 위치가 100_000 보다 작거나 같은 경우
		if (x + 1 <= end) {
			if (dp[x + 1] >= t + 1) {
				dp[x + 1] = t + 1;
				dfs(x + 1, t + 1);
			}

		}

	}

}
