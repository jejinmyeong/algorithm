package J2023Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_boj_13172_시그마 {
    static final int mod = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        long ans = 0;

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            long down = Long.parseLong(st.nextToken());
            long up = Long.parseLong(st.nextToken());

            if (down % up == 0) {
                ans = (ans + down / up) % mod;
            } else {
                long gcd = GCD(down, up);

                down /= gcd;
                up /= gcd;

                down = pow(down, mod - 2);

                ans = (ans + down * up) % mod;
            }
        }

        System.out.println(ans);

    }

    static long pow (long a, int k) {
        if (k == 1) {
            return a;
        }

        long res = 1;
        if (k % 2 != 0) res = (res * a) % mod;
        long mul = pow(a, k / 2);
        res = (res * ((mul * mul) % mod)) % mod;

        return res;
    }

    static long GCD (long a, long b) {
        return b == 0 ? a : GCD (b, a % b);
    }
}
