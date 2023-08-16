import java.util.*;
import java.io.*;

public class Main {
    static int [][] dp;
    static ArrayList<Character> res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N, M, K;

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];
        res = new ArrayList<>();

        solution(N, M, K);

        if (check(N, M) < K) {
            System.out.println(-1);
            return;
        }

        for (char c: res) {
            sb.append(c);
        }

        System.out.println(sb);
    }

    static int check(int n, int m) {
        if (n == 0 || m == 0) {
            return 1;
        }

        if (dp[n][m] != 0) return dp[n][m];

        return dp[n][m] = Integer.min(check(n - 1, m) + check(n, m - 1), 1_000_000_001);
    }

    static void solution(int n, int m, int k) {
        if (n == 0) {
            for (int i = 0 ; i < m ; i++) {
                res.add('z');
            }
            return;
        }

        if (m == 0) {
            for (int i = 0 ; i < n ; i++) {
                res.add('a');
            }
            return;
        }

        int check = check(n - 1, m);

        if (check < k) {
            res.add('z');
            solution(n, m - 1, k - check);
        } else {
            res.add('a');
            solution(n - 1, m, k);
        }

    }
}