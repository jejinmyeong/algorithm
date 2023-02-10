package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_boj_4386_별자리만들기 {

    static class Point {
        Double x, y;
        Point (Double x, Double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end;
        Double dist;
        Edge (int start, int end, Double dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo (Edge o) {
            return this.dist - o.dist > 0 ? 1 : -1;
        }
    }

    static int N;
    static ArrayList<Edge> edges;
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Point [] stars = new Point[N];
        parents = new int[N];
        edges = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            Double x = Double.parseDouble(st.nextToken());
            Double y = Double.parseDouble(st.nextToken());

            stars[i] = new Point(x, y);
            parents[i] = i;
        }

        for (int i = 0 ; i < N - 1; i++) {
            for (int j = i + 1 ; j < N ; j++) {
                Double d = Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));

                edges.add(new Edge(i, j, d));
            }
        }

        Collections.sort(edges);

        Double ans = 0D;
        int cnt = 0;

        for (int i = 0 ; i < edges.size() ; i++) {
            if (union(edges.get(i).start, edges.get(i).end)) {
                ans += edges.get(i).dist;
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