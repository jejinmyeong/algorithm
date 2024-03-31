import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int [] A = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

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

        boolean [] visited = new boolean[N + 1];

        int sum = 0;

        for (int i = 1 ; i <= N ; i++) {
            if (visited[i]) continue;

            int min = A[i];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int d = 0 ; d < nodes[now].size() ; d++) {
                    int next = nodes[now].get(d);

                    if (visited[next]) continue;

                    min = Math.min(min, A[next]);
                    visited[next] = true;
                    queue.offer(next);
                }
            }

            sum += min;
        }

        if (sum > K) {
            System.out.println("Oh no");
        } else {
            System.out.println(sum);
        }
    }
}