package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1922_네트워크연결 {
    static class Edge implements Comparable<Edge> {
        int s, e, w;
        Edge (int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo (Edge o) {
            return this.w - o.w;
        }
    }

    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Edge [] edges = new Edge[M];
        parents = new int[N + 1];

        for (int i = 0 ; i <= N ; i++) {
            parents[i] = i;
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s, e, w);
        }

        Arrays.sort(edges);

        int cnt = 0, ans = 0;

        for (int i = 0 ; i < M ; i++) {
            if (union(edges[i].s , edges[i].e)) {
                ans += edges[i].w;
                if (++cnt == N) break;
            }
        }

        System.out.println(ans);
    }

    static boolean union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        parents[b] = a;
        return true;
    }

    static int find (int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}