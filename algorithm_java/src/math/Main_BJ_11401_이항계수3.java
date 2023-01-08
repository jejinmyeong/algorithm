package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11401_이항계수3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int p = 1_000_000_007;

		int N, M;

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		System.out.println(nCr(N, M, p));

	}

	static long nCr(int n, int r, int p) {
		if (r == 0) {
			return 1L;
		}

		long[] fac = new long[n + 1];
		fac[0] = 1;

		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i - 1] * i % p;
		}

		return (fac[n] * pow(fac[r], p - 2, p) % p * pow(fac[n - r], p - 2, p) % p) % p;

	}

	static long pow(long x, int y, int p) {
		long res = 1L;

		x %= p;

		while (y > 0) {
			if (y % 2 == 1) {
				res = (res * x) % p;
			}

			y = y >> 1;
			x = (x * x) % p;
		}

		return res;
	}
}
