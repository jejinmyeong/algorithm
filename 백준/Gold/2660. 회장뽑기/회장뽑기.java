import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer> [] nodes = new List[N + 1];

        for (int i = 0 ; i <= N ; i++) {
            nodes[i] = new ArrayList<>();
        }

        while (true) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (u == -1 && v == -1) {
                break;
            }

            nodes[u].add(v);
            nodes[v].add(u);
        }

        int min = Integer.MAX_VALUE;
        List<Integer> candidates = new ArrayList<>();

        for (int i = 1 ; i <= N ; i++) {
            boolean [] visited = new boolean[N + 1];
            Queue<int []> queue = new ArrayDeque<>();
            visited[i] = true;
            queue.offer(new int [] {i, 0});

            int cnt = 0;

            while (!queue.isEmpty()) {
                int [] now = queue.poll();

                for (int j = 0 ; j < nodes[now[0]].size() ; j++) {
                    int next = nodes[now[0]].get(j);

                    if (visited[next]) continue;

                    visited[next] = true;
                    cnt = now[1] + 1;
                    queue.offer(new int [] {next, cnt});
                }
            }

            if (cnt < min) {
                min = cnt;
                candidates.clear();
            } else if (cnt > min) {
                continue;
            }
            candidates.add(i);
        }

        sb.append(min).append(" ").append(candidates.size()).append("\n");

        for (int c: candidates) {
            sb.append(c).append(" ");
        }

        System.out.println(sb);
    }
}