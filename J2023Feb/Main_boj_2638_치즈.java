package J2023Feb;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_2638_치즈 {

    static int N, M;
    static int [][] map, D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 2][M + 2];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;

        while (bfs() != 0) {
            ans++;
        }

        System.out.println(ans);
    }
    static int bfs () {
        Queue<Point> queue = new LinkedList<>();
        boolean [][] visited = new boolean[N + 2][M + 2];
        int [][] count = new int[N + 2][M + 2];

        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.x + D[d][0];
                int ny = now.y + D[d][1];

                if (isOverflow(nx, ny) || visited[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
                else {
                    count[nx][ny]++;
                }
            }
        }

        int melt = 0;

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= M ; j++) {
                if (count[i][j] > 1) {
                    map[i][j] = 0;
                    melt++;
                }
            }
        }

        return melt;
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx > N || ny > M;
    }
}
