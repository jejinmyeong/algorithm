import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean [] available = new boolean[1000];
        int ans = 0;

        for (int i = 123 ; i < 1000 ; i++) {
            int h = i / 100 % 10;
            int t = i / 10 % 10;
            int n = i % 10;

            if (h == 0 || t == 0 || n == 0) continue;
            if (h == t || h == n || t == n) continue;

            ans++;
            available[i] = true;
        }

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            int h = num / 100 % 10;
            int t = num / 10 % 10;
            int n = num % 10;

            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int a = 123 ; a < 1000 ; a++) {
                if (!available[a]) continue;

                int ns = 0;
                int nb = 0;

                int nh = a / 100 % 10;
                int nt = a / 10 % 10;
                int nn = a % 10;

                if (h == nh) ns++;
                if (t == nt) ns++;
                if (n == nn) ns++;
                if (h == nt || h == nn) nb++;
                if (t == nh || t == nn) nb++;
                if (n == nh || n == nt) nb++;

                if (strike != ns || ball != nb) {
                    ans--;
                    available[a] = false;
                }

            }
        }

        System.out.println(ans);
    }
}


