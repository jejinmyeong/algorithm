import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int e, d;
        Node(int e, int d) {
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }

        @Override
        public String toString() {
            return this.e + " " + this.d;
        }
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, K;
    static ArrayList<Node> [] nodes;
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Point [] p = new Point[N + 2];

        p[0] = new Point(0, 0);
        p[N + 1] = new Point(10000, 10000);

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            p[i] = new Point(x, y);
        }

        nodes = new ArrayList[N + 2];

        for (int i = 0 ; i < N + 2 ; i++) {
            nodes[i] = new ArrayList<>();
        }

        int max = 0;
        for (int i = 0 ; i < N + 2 ; i++) {
            for (int j = i + 1 ; j < N + 2 ; j++) {
                int d = (int) Math.ceil(Math.sqrt(Math.pow(p[i].x - p[j].x, 2) + Math.pow(p[i].y - p[j].y, 2)) / 10);

                max = Math.max(max, d);

                nodes[i].add(new Node(j, d));
                nodes[j].add(new Node(i, d));
            }
        }

        int start = 0;
        int end = max;

        while(start <= end) {
            int mid = (start + end) / 2;

            boolean res = bfs(mid);

            if (res) end = mid - 1;
            else start = mid + 1;
        }

        System.out.println(start);
    }

    static class Pos {
        int e, c;
        Pos(int e, int c) {
            this.e = e;
            this.c = c;
        }
    }

    static boolean bfs(int l) {
        Queue<Pos> queue = new LinkedList<>();
        boolean [] visited = new boolean[N + 2];

        queue.offer(new Pos(0, 0));
        visited[0] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            if (now.e == N + 1) {
                if (now.c > K + 1) return false;
                else return true;
            }

            for (int i = 1 ; i < nodes[now.e].size() ; i++) {
                Node next = nodes[now.e].get(i);

                if (visited[next.e] || next.d > l) continue;

                visited[next.e] = true;
                queue.offer(new Pos(next.e,now.c + 1));
            }
        }

        return false;
    }
}