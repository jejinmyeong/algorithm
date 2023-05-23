import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static boolean [] visited;
    static StringBuilder sb;
    static int idx = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        PriorityQueue<Integer> [] E = new PriorityQueue[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            E[i] = new PriorityQueue<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            E[u].offer(v);
            E[v].offer(u);
        }

        int [] V = new int[N + 1];

        dfs(V, E, R);

        for (int i = 1 ; i <= N ; i++) {
            sb.append(V[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs (int [] V, PriorityQueue<Integer> [] E, int R) {
        V[R] = idx++;
        visited[R] = true;

        while (!E[R].isEmpty()) {
            int x = E[R].poll();

            if (!visited[x]) {
                dfs(V, E, x);
            }
        }
    }
}
