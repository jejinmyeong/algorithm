package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1865_웜홀 {
    static class Node {
        int e, w;

        Node (int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    static ArrayList<Node> [] nodes;
    static int N;
    static final int INF = 987654321;
    static int [] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0 ; tc < TC ; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            Arrays.fill(dist, INF);
            nodes = new ArrayList[N + 1];
            for (int i = 0 ; i <= N ; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0 ; i < M ; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                nodes[u].add(new Node(v, w));
                nodes[v].add(new Node(u, w));
            }

            for (int i = 0 ; i < W ; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                nodes[u].add(new Node(v, -w));
            }

            boolean cycle = false;
            for (int i = 1 ; i <= N ; i++) {
                if (bellmanFord(i)) {
                    cycle = true;
                    sb.append("YES").append("\n");
                    break;
                }
            }

            if (!cycle) sb.append("NO").append("\n");

        }
        System.out.print(sb);
    }

    static boolean bellmanFord (int start) {
        dist[start] = 0;
        boolean flag = false;

        for (int i = 1 ; i < N ; i++) {
            flag = false;

            for (int j = 1 ; j <= N ; j++) {
                for (Node n : nodes[j]) {
                    if (dist[i] != INF && dist[n.e] > dist[j] + n.w) {
                        dist[n.e] = dist[j] + n.w;
                        flag = true;
                    }
                }
            }

            if (!flag) break;
        }

        if (flag) {
            for (int i = 0 ; i <= N ; i++) {
                for (Node n : nodes[i]) {
                    if (dist[i] != INF && dist[n.e] > dist[i] +n.w) return true;
                }
            }
        }

        return false;
    }
}
