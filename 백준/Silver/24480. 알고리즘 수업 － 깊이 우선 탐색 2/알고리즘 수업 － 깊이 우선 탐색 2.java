import java.util.*;
import java.io.*;
import java.math.*;
public class Main {

    static List<Integer> [] nodes;
    static int idx;
    static boolean [] visited;
    static int [] res;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        nodes = new List[N + 1];

        for (int i = 0 ; i <= N ; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(v);
            nodes[v].add(u);
        }

        for (int i = 0 ; i <= N ; i++) {
            Collections.sort(nodes[i], (a, b) -> b - a);
        }

        visited = new boolean[N + 1];
        res = new int[N + 1];

        dfs(R);

        for (int i = 1 ; i <= N ; i++) {
            System.out.println(res[i]);
        }

    }
    static void dfs(int p) {
        res[p] = ++idx;
        visited[p] = true;

        for (int i = 0 ; i < nodes[p].size() ; i++) {
            int c = nodes[p].get(i);

            if (visited[c]) continue;
            dfs(c);
        }
    }
}
