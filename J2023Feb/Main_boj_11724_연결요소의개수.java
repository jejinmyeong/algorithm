package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_11724_연결요소의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> [] nodes = new ArrayList[N + 1];

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

        boolean [] visited = new boolean[N + 1];
        int cnt = 0;

        while (true) {
            Queue<Integer> queue = new LinkedList<>();

            for (int n = 1 ; n <= N ; n++) {
                if (visited[n]) continue;
                queue.offer(n);
                visited[n] = true;
                break;
            }

            if (queue.isEmpty()) break;

            cnt++;

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int k = 0 ; k < nodes[now].size() ; k++) {
                    int next = nodes[now].get(k);

                    if (visited[next]) continue;
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        System.out.println(cnt);
    }
}
