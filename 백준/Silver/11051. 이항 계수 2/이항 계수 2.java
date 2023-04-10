import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int p = 10_007;

        System.out.println(nCr(N, M, p));
    }

    static int nCr(int n, int r, int p) {
        if (r == 0) return 1;

        int [] fac = new int[n + 1];
        fac[0] = 1;

        for (int i = 1 ; i <= n ; i++) {
            fac[i] = fac[i - 1] * i % p;
        }

        return fac[n] * pow(fac[r], p - 2, p) % p * pow(fac[n - r], p - 2, p) % p;
    }

    static int pow(int x, int y, int p) {
        int res = 1;

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