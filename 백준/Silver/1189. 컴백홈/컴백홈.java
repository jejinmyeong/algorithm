import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int R, C, K, ans;
    static boolean [][] visited, map;
    static int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        visited = new boolean[R][C];

        for (int i = 0 ; i < R ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < C ; j++) {
                if (line.charAt(j) == '.') map[i][j] = true;
            }
        }

        visited[R - 1][0] = true;
        dfs (R - 1, 0, 1);

        System.out.println(ans);
    }

    static void dfs (int x, int y, int cnt) {
        if (x == 0 && y == C - 1) {
            if (cnt == K) ans++;
            return;
        }
        
        if (cnt >= K) return;

        for (int d = 0 ; d < 4 ; d++) {
            int nx = x + D[d][0];
            int ny = y + D[d][1];

            if (isOverflow(nx, ny) || visited[nx][ny] || !map[nx][ny]) continue;
            
            visited[nx][ny] = true;
            dfs(nx, ny, cnt + 1);
            visited[nx][ny] = false;
        }
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= R || ny >= C;
    }
}