import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static int N, M, ans;
    static int [][] map, D = {{-1, 0},{0, 1},{1, 0},{0, -1}}, dp;
    static boolean [][] visited;
    static boolean isCycle;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                char c = input.charAt(j);

                if (c == 'H') map[i][j] = -1;
                else map[i][j] = c - '0';
            }
        }

        dp = new int[N][M];
        visited = new boolean[N][M];

        visited[0][0] = true;
        dfs(new Point(0, 0, 1));

        if (isCycle) System.out.println(-1);
        else System.out.println(ans);
    }

    static class Point {
        int x, y, cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static void dfs(Point now) {
        dp[now.x][now.y] = now.cnt;
        ans = Math.max(ans, now.cnt);

        for (int d = 0 ; d < 4 ; d++) {
            int nx = now.x + D[d][0] * map[now.x][now.y];
            int ny = now.y + D[d][1] * map[now.x][now.y];

            if (isOverflow(nx, ny) || map[nx][ny] == -1 || now.cnt < dp[nx][ny]) continue;

            if (visited[nx][ny]) {
                isCycle = true;
                return;
            }

            visited[nx][ny] = true;
            dfs(new Point(nx, ny, now.cnt + 1));
            visited[nx][ny] = false;
        }
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }
}