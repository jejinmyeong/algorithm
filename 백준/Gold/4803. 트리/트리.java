import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> [] nodes;
    static int trees, cnt;
    static boolean [] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            sb.append("Case ").append(T).append(":").append(" ");

            nodes = new List[N + 1];

            for (int i = 1 ; i <= N ; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0 ; i < M ; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                nodes[u].add(v);
                nodes[v].add(u);
            }

            visited = new boolean[N + 1];

            int treeCnt = 0;

            for (int i = 1 ; i <= N ; i++) {
                if (visited[i]) continue;
                trees = 0;
                cnt = 0;
                dfs(i);

                if (cnt == (trees - 1) * 2) treeCnt++;

            }

            if (treeCnt == 0) {
                sb.append("No trees.");
            } else if (treeCnt == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of").append(" ").append(treeCnt).append(" ").append("trees.");
            }

            sb.append("\n");
            T++;
        }

        System.out.print(sb);

    }

    static void dfs(int x) {
        trees++;
        cnt += nodes[x].size();
        visited[x] = true;
        for (int y: nodes[x]) {
            if (visited[y]) continue;
            dfs(y);
        }
    }
}
