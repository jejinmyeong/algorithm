package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_boj_10282_해킹 {
    static class Edge implements Comparable<Edge> {
        int end, s;
        Edge (int end, int s) {
            this.end = end;
            this.s = s;
        }

        @Override
        public int compareTo (Edge o) {
            return this.s - o.s;
        }
    }

    static ArrayList<Edge> [] edges;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges = new ArrayList[n + 1];

            for (int i = 1 ; i <= n ; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0 ; i < d ; i++) {
                st = new StringTokenizer(br.readLine());

                int e = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                edges[s].add(new Edge(e, w));
            }

            int [] res = bfs(c);
            sb.append(res[0] + " " + res[1]).append("\n");
        }

        System.out.print(sb);
    }

    static int [] bfs (int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        boolean [] visited = new boolean[n + 1];
        queue.offer(new Edge(start, 0));

        int cnt = 0, time = 0;

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if (visited[now.end]) continue;

            visited[now.end] = true;
            cnt++;
            time = now.s;

            for (int i = 0 ; i < edges[now.end].size() ; i++) {
                Edge next = edges[now.end].get(i);

                if (visited[next.end]) continue;

                queue.offer(new Edge(next.end, now.s + next.s));
            }
        }

        return new int[] {cnt, time};
    }
}
