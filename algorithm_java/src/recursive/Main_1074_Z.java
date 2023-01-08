package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	static int count;

	static void countZ(int n, int r, int c) {
		if (n == 1) {
			return;
		}
		
		n /= 2;
		// 왼쪽위 사분변
		if (r < n && c < n) {

		}
		// 왼쪽 아래 사분변
		else if (r >= n && c < n) {
			count += 2* n * n;
			r -= n;
		}
		// 오른쪽 위 사분면
		else if (r < n && c >= n) {
			count += n * n;
			c -= n;
		}
		// 오른쪽 아래 사분면
		else {
			count += 3 * n * n;
			r -= n;
			c -= n;
		}
		countZ(n, r, c);

	}

	static int exp(int N) {
		if (N == 1)
			return 2;

		int r = exp(N / 2);
		int res = r * r;
		
		if(N%2 == 1) res *= 2;

		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N, r, c;
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int n = exp(N);
		countZ(n, r, c);
		System.out.println(count);

	}
}
