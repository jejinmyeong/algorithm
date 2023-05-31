import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static int N;
    static int [][] map, D = {{-1, -1},{-1, 1}};
    static int [] res;
    static boolean [][] visited, isBlack;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        isBlack = new boolean[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                if ((i + j) % 2 == 0) {
                    isBlack[i][j] = true;
                }
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = new int[2];

        dfs(0, true, 0);
        dfs(0, false, 0);

        System.out.println(res[0] + res[1]);

    }

    static void dfs(int idx, boolean black, int cnt) {
        for (int i = idx ; i < N * N ; i++) {
            int x = i / N;
            int y = i % N;

            if (map[x][y] == 0 || isBlack[x][y] != black || !check(x, y)) continue;

            visited[x][y] = true;
            dfs(i + 1, black, cnt + 1);
            visited[x][y] = false;
        }

        res[black ? 0 : 1] = Math.max(res[black ? 0 : 1], cnt);
    }

    static boolean check(int x, int y) {
        for (int d = 0 ; d < 2 ; d++) {
            int nx = x;
            int ny = y;
            while (!isOverflow(nx, ny)) {
                if (visited[nx][ny]) return false;

                nx += D[d][0];
                ny += D[d][1];
            }
        }

        return true;
    }

    static boolean isOverflow (int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }
}
