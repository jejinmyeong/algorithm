import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean [] visited;
    static ArrayList<Integer> [] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N];

        for (int i = 0 ; i < N ; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(v);
            nodes[v].add(u);
        }

        visited = new boolean[N];

        for (int i = 0 ; i < N ; i++) {
            visited[i] = true;
            if (dfs(0, i)) {
                System.out.println(1);
                return;
            }
            visited[i] = false;
        }

        System.out.println(0);
    }

    static boolean dfs(int cnt, int now) {
        if (cnt == 4) {
            return true;
        }

        for (int j = 0 ; j < nodes[now].size() ; j++) {
            int next = nodes[now].get(j);

            if (visited[next]) continue;
            visited[next] = true;
            if (dfs(cnt + 1, next)) return true;
            visited[next] = false;
        }

        return false;
    }
}
