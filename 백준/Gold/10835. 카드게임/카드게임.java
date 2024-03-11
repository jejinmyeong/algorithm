import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;
    static int [] left, right;
    static int [][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        left = new int[N];
        right = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs (int l, int r) {
        if (l == N || r == N) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int res = Math.max(dfs(l + 1, r), dfs(l + 1, r + 1));

        if (left[l] > right[r]) {
            res = Math.max(res, right[r] + dfs(l, r + 1));
        }

        return dp[l][r] =  res;
    }
}