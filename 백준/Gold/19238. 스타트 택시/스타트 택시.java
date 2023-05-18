import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, O;
    static int [][] map, D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        O = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) * -1;
            }
        }

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        Point taxi = new Point(x, y);

        Point [] start = new Point[M + 1];
        Point [] end = new Point[M + 1];

        for (int i = 1 ; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            map[sx][sy] = i;
            start[i] = new Point(sx, sy);
            end[i] = new Point(ex, ey);
        }

        Node res;
        while ((res = getClosePerson(taxi)) != null) {
            if (O < res.c) break;

            O -= res.c;
            int idx = map[res.x][res.y];

            int dist = moveDestination(start[idx], end[idx]);

            if (dist < 0 || dist > O) {
                break;
            }

            O += dist;
            map[res.x][res.y] = 0;

            taxi = end[idx];
            M--;
        }

        if (M > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(O);

    }

    static class Node extends Point implements Comparable<Node>{
        int c;
        Node (int x, int y, int c) {
            super(x, y);
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            if (this.c == o.c && this.x == o.x) return this.y - o.y;
            else if (this.c == o.c) return this.x - o.x;
            return this.c - o.c;
        }
    }

    static Node getClosePerson (Point start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean [][] visited = new boolean[N + 1][N + 1];

        queue.offer(new Node(start.x, start.y, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (map[now.x][now.y] > 0) {
                return now;
            }

            if (visited[now.x][now.y]) continue;
            visited[now.x][now.y] = true;

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.x + D[d][0];
                int ny = now.y + D[d][1];

                if (isOverflow(nx, ny) || visited[nx][ny] || map[nx][ny] == -1) continue;

                queue.offer(new Node(nx, ny, now.c + 1));
            }
        }

        return null;
    }

    static int moveDestination (Point start, Point end) {
        Queue<Node> queue = new LinkedList<>();
        boolean [][] visited = new boolean[N + 1][N + 1];

        queue.offer(new Node(start.x, start.y , 0));
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == end.x && now.y == end.y) {
                return now.c;
            }

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.x + D[d][0];
                int ny = now.y + D[d][1];

                if (isOverflow(nx, ny) || visited[nx][ny] || map[nx][ny] == -1) continue;

                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, now.c + 1));
            }
        }

        return -1;
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 1 || ny < 1 || nx > N || ny > N;
    }
}

