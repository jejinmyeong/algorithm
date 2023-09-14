import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [][] capacity = new int[52][52];
        int [][] flow = new int[52][52];
        List<Integer> [] edges = new List[52];

        for (int i = 0 ; i < 52 ; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = atoi(st.nextToken().charAt(0));
            int v = atoi(st.nextToken().charAt(0));
            int w = Integer.parseInt(st.nextToken());

            capacity[u][v] += w;
            capacity[v][u] += w;
            edges[u].add(v);
            edges[v].add(u);
        }

        int ans = 0;

        while (true) {
            int [] parents = new int[52];
            Arrays.fill(parents, -1);
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(0);
            parents[0] = 0;

            while (!queue.isEmpty() && parents[25] == -1) {
                int now = queue.poll();
                for (int next: edges[now]) {
                    if (parents[next] == -1 && capacity[now][next] - flow[now][next] > 0) {
                        queue.add(next);
                        parents[next] = now;
                    }
                }
            }

            if (parents[25] == -1) break;

            int min = Integer.MAX_VALUE;
            for (int i = 25 ; i != 0; i = parents[i]) {
                min = Math.min(min, capacity[parents[i]][i] - flow[parents[i]][i]);
            }
            for (int i = 25 ; i != 0 ; i = parents[i]) {
                flow[parents[i]][i] += min;
                flow[i][parents[i]] -= min;
            }

            ans += min;
        }

        System.out.println(ans);
    }

    static int atoi(char c) {
        if ('a' <= c && c <= 'z') c -= 6;
        return c - 'A';
    }
}