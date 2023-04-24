import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> [] nodes;
    static int V;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0 ; tc < T ; tc++) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            nodes = new ArrayList[V + 1];
            for (int i = 0 ; i <= V ; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0 ; i < E ; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                nodes[u].add(v);
                nodes[v].add(u);
            }

            sb.append(bfs() ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);

    }

    static boolean bfs() {
        int [] visited = new int[V + 1];

        Queue<Integer> queue = new LinkedList<>();

        for (int v = 1 ; v <= V ; v++) {
            if (visited[v] == 0) {
                queue.offer(v);
                visited[v] = 1;
            }

            while(!queue.isEmpty()) {
                int now = queue.poll();

                for (int i = 0 ; i < nodes[now].size() ; i++) {
                    int next = nodes[now].get(i);

                    if (visited[next] == visited[now]) {
                        return false;
                    }
                    if (visited[next] == 0) {
                        queue.offer(next);
                        visited[next] = visited[now] == 1 ? 2 : 1;
                    }
                }

            }
        }

        return true;
    }
}