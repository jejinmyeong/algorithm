import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N, M, K, ans = -1_000_000_000;
    static int [][] map, D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    static boolean [][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bt(0, 0, 0, 0);

        System.out.println(ans);

    }

    static void bt (int k, int x, int y, int sum) {
        if (k == K) {
            ans = Math.max(ans, sum);
            return;
        }

        if (x >= N || y >= M) return;

        boolean flag = true;

        for (int d = 0 ; d < 4 ; d++) {
            int nx = x + D[d][0];
            int ny = y + D[d][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if (visited[nx][ny]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            visited[x][y] = true;
            bt(k + 1, y + 1 == M ? x + 1 : x, y + 1 == M ? 0 : y + 1, sum + map[x][y]);
            visited[x][y] = false;
        }
        bt(k, y + 1 == M ? x + 1 : x, y + 1 == M ? 0 : y + 1, sum);
    }
}