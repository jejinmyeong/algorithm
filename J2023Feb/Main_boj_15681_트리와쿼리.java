package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_boj_15681_트리와쿼리 {

    static int N, R, Q;
    static int [] dp;
    static ArrayList<Integer> [] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        ArrayList<Integer> [] edges = new ArrayList[N + 1];
        tree = new ArrayList[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            edges[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }


        for (int i = 1 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges[u].add(v);
            edges[v].add(u);
        }

        // 간선 정보를 이용해서 트리를 구성
        boolean [] visited = new boolean[N + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(R);
        visited[R] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0 ; i < edges[now].size() ; i++) {
                int next = edges[now].get(i);
                if (visited[next]) continue;

                visited[next] = true;
                tree[now].add(next);
                queue.offer(next);
            }
        }

        dp = new int[N + 1];

        dfs(R);

        for (int i = 0 ; i < Q ; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.print(sb);
    }

    static int dfs (int now) {
        if (tree[now].size() == 0) {
            dp[now] = 1;
            return 1;
        }

        int cnt = 1;
        for (int i = 0 ; i < tree[now].size() ; i++) {
            cnt += dfs(tree[now].get(i));
        }

        dp[now] = cnt;
        return cnt;
    }
}