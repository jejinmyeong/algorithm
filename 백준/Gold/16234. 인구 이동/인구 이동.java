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
    static int N, L, R;
    static int [][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while(bfs()) {
            ans++;
        }

        System.out.println(ans);
    }

    static boolean bfs() {
        int [][] visited = new int[N][N];
        Queue<Point> queue = new LinkedList<>();

        int [][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int cnt = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (visited[i][j] != 0) continue;

                cnt++;
                queue.offer(new Point(i, j));
                visited[i][j] = cnt;

                while (!queue.isEmpty()) {
                    Point now = queue.poll();

                    for (int d = 0 ; d < 4 ; d++) {
                        int nx = now.x + D[d][0];
                        int ny = now.y + D[d][1];

                        if (isOverflow(nx, ny) || visited[nx][ny] != 0 || Math.abs(map[now.x][now.y] - map[nx][ny]) < L || Math.abs(map[now.x][now.y] - map[nx][ny]) > R) continue;

                        visited[nx][ny] = cnt;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }

        if (cnt == N * N) return false;
        int [] sum = new int[cnt + 1];
        int [] count = new int[cnt + 1];

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                sum[visited[i][j]] += map[i][j];
                count[visited[i][j]]++;
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = sum[visited[i][j]] / count[visited[i][j]];
            }
        }

        return true;
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }
}