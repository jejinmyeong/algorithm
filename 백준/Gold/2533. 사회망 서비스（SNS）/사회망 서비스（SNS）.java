import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static int N;
    static ArrayList<Integer> [] nodes;
    static int [][] dp;
    static boolean [] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nodes = new ArrayList[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(v);
            nodes[v].add(u);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int idx) {
        visited[idx] = true;
        dp[idx][0] = 0;
        dp[idx][1] = 1;

        for (int child: nodes[idx]) {
            if (visited[child]) continue;
            dfs(child);
            dp[idx][0] += dp[child][1];
            dp[idx][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}