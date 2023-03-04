package J2023Mar;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_17070_파이프옮기기1 {
    static int N, ans;
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new Point(1, 2), 1);

        System.out.println(ans);
    }

    static void dfs (Point p, int d) {
        if (p.x == N && p.y == N) {
            ans++;
            return;
        }

        // 가로 방향일 경우
        if (d == 1 || d == 3) {
            // 가로로 이동
            int nx = p.x;
            int ny = p.y + 1;

            if (!isOverflow(nx, ny) && map[nx][ny] == 0) {
                dfs(new Point(nx, ny) , 1);
            }
        }
        // 세로 방향일 경우
        if (d == 2 || d == 3) {
            // 세로로 이동
            int nx = p.x + 1;
            int ny = p.y;

            if (!isOverflow(nx, ny) && map[nx][ny] == 0) {
                dfs(new Point(nx, ny), 2);
            }

        }
        // 대각선으로 이동
        int nx = p.x + 1;
        int ny = p.y + 1;
        if (!isOverflow(nx, ny) && map[p.x][ny] == 0 && map[nx][p.y] == 0 && map[nx][ny] == 0) {
            dfs(new Point(nx, ny), 3);
        }
    }

    static boolean isOverflow (int nx, int ny) {
        return nx < 1 || ny < 1 || nx > N || ny > N;
    }
}
