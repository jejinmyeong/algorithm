package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_2887_행성터널 {
    static class Point {
        int num, x, y, z;
        Point(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

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

    static int N;
    static int [] parents;
    static Edge [] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Point [] planets = new Point[N];
        parents = new int [N];

        for (int i = 0 ; i < N ; i++) {
            parents[i] = i;
        }

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets[i] = new Point(i, x, y, z);
        }

        edges = new Edge[(N - 1) * 3];

        Arrays.sort(planets, (p1, p2) -> p1.x - p2.x);
        for (int i = 1 ; i < N ; i++) {
            edges[i - 1] = (new Edge(planets[i-1].num, planets[i].num, Math.abs(planets[i - 1].x - planets[i].x)));
        }
        Arrays.sort(planets, (p1, p2) -> p1.y - p2.y);
        for (int i = 1 ; i < N ; i++) {
            edges[N - 1 + i - 1] = (new Edge(planets[i-1].num, planets[i].num, Math.abs(planets[i - 1].y - planets[i].y)));
        }
        Arrays.sort(planets, (p1, p2) -> p1.z - p2.z);
        for (int i = 1 ; i < N ; i++) {
            edges[(N - 1) * 2 + i - 1] = (new Edge(planets[i-1].num, planets[i].num, Math.abs(planets[i - 1].z - planets[i].z)));
        }

        Arrays.sort(edges);

        int cnt = 0, ans = 0;


        for (int i = 0 ; i < edges.length ; i++) {
            if (union(edges[i].s, edges[i].e)) {
                ans += edges[i].w;
                if (++cnt == N) break;
            }
        }

        System.out.println(ans);

    }

    static boolean union(int a, int b) {
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