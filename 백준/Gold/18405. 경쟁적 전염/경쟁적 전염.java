import java.util.*;
import java.io.*;
import java.math.*;
public class Main {

    static int N, K, S;
    static int [][] map, D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bfs();
        
        System.out.println(map[x - 1][y - 1]);

    }

    static class Point implements Comparable<Point> {
        int x, y, n;

        Point(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }

        @Override
        public int compareTo(Point o) {
            return this.n - o.n;
        }
    }
    static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (map[i][j] != 0) queue.offer(new Point(i, j, map[i][j]));
            }
        }

        boolean [][] visited = new boolean[N][N];

        int time = 0;
        while (time <= S) {
            int len = queue.size();
            PriorityQueue<Point> temp = new PriorityQueue<>();

            for (int i = 0 ; i < len ; i++) {
                Point now = queue.poll();

                if (visited[now.x][now.y]) continue;

                visited[now.x][now.y] = true;
                map[now.x][now.y] = now.n;

                for (int d = 0 ; d < 4 ; d++) {
                    int nx = now.x + D[d][0];
                    int ny = now.y + D[d][1];

                    if (isOverflow(nx, ny) || visited[nx][ny] || map[nx][ny] != 0) continue;

                    temp.offer(new Point(nx, ny, now.n));
                }
            }

            queue = temp;
            time++;
        }
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }
}
