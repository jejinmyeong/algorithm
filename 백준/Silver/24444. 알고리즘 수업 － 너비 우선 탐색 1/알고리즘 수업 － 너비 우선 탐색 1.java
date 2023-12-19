import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Integer> [] nodes = new List[N + 1];

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
            Collections.sort(nodes[i]);
        }

        int [] res = new int[N + 1];
        boolean [] visited = new boolean[N + 1];
        int idx = 1;

        Queue<Integer> queue = new ArrayDeque<>();

        res[R] = idx++;
        visited[R] = true;
        queue.offer(R);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0 ; i < nodes[now].size() ; i++) {
                int next = nodes[now].get(i);

                if (visited[next]) continue;

                res[next] = idx++;
                visited[next] = true;
                queue.offer(next);
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            System.out.println(res[i]);
        }

    }
}
