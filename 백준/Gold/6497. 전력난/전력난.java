import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int M, N;
    static Edge [] edges;
    static int [] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (M == 0 && N == 0) break;

            edges = new Edge[N];

            int sum = 0;

            for (int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                sum += w;

                edges[i] = new Edge(u, v, w);
            }

            Arrays.sort(edges);

            make();

            int cnt = 0, result = 0;

            for (int i = 0 ; i < N ; i++) {
                if (union(edges[i].u, edges[i].v)) {
                    result += edges[i].w;
                    if (++cnt == M-1) break;
                }
            }

            sb.append(sum - result).append("\n");
        }

        System.out.print(sb);
    }

    static void make () {
        parents = new int[M];

        for (int i = 0 ; i < M ; i++) {
            parents[i] = i;
        }
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
}
