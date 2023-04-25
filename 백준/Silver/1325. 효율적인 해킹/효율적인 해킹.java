import java.math.*;
import java.util.*;
import java.io.*;

public class Main {

    static boolean [] visited;
    static int [] res;
    static ArrayList<Integer> [] nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];
        for (int i = 1 ; i <= N ; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(v);
        }

        res = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        int max = 0;
        for (int i = 1 ; i <= N ; i++) {
            max = Math.max(max, res[i]);
        }

        for (int i = 1 ; i <= N ; i++) {
            if (max == res[i]) sb.append(i).append(" ");
        }

        System.out.print(sb);
    }

    static void dfs(int now) {
        visited[now] = true;

        for (int next : nodes[now]) {
            if (visited[next]) continue;
            res[next]++;
            dfs(next);
        }
    }
}