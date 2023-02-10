package J2023Feb;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_boj_1774_우주신과의교감 {
    static class Edge implements Comparable<Edge> {
        int s, e;
        double d;
        Edge (int s, int e, double d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo (Edge o) {
            return this.d - o.d > 0 ? 1 : -1;
        }
    }

    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Point [] points = new Point[N + 1];
        parents = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);
        }

        for (int i = 1 ; i <= N ; i++) {
            parents[i] = i;
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s, e);
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 1 ; i < N ; i++) {
            for (int j = i + 1 ; j <= N ; j++) {
                double distance = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));

                edges.add(new Edge(i, j, distance));
            }
        }

        Collections.sort(edges);
        double ans = 0D;
        int cnt = 0;


        for (int i = 0 ; i < edges.size() ; i++) {
            if (union(edges.get(i).s , edges.get(i).e)) {
                ans += edges.get(i).d;

                if (++cnt == N) break;
            }
        }

        System.out.println(String.format("%.2f", ans));

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