package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_6064_카잉달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int gcd = GCD(N, M);

            if (Math.abs(x - y) % gcd != 0) {
                sb.append(-1).append("\n");
                continue;
            }

            int lcm = M * N / gcd;
            int n = 0;
            int ans = 0;
            while (n * M < lcm) {
                if ((n * M + x - y) % N == 0) {
                    ans = n * M + x;
                    break;
                }
                n++;
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static int GCD (int x, int y) {
        return y == 0 ? x : GCD(y, x % y);
    }
}
