package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_2606_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> [] nodes = new ArrayList[N + 1];

        for (int i = 0 ; i <= N ; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodes[s].add(e);
            nodes[e].add(s);
        }

        boolean [] visited = new boolean[N + 1];

        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int ans = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0 ; i < nodes[now].size() ; i++) {
                int next = nodes[now].get(i);

                if (visited[next]) continue;

                queue.offer(next);
                visited[next] = true;
                ans++;
            }
        }

        System.out.println(ans);

    }
}
