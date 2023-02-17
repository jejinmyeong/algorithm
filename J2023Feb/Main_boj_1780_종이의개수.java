package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1780_종이의개수 {
    static int [][] map;
    static int [] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        ans = new int[3];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        dfs (0, 0, N);

        for (int i : ans) {
            sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs (int x, int y, int len) {
        int init = map[x][y];
        boolean flag = true;
        loop: for (int i = x ; i < x + len ; i++)
            for (int j = y ; j < y + len ; j++)
                if (map[i][j] != init) {
                    flag = false;
                    break loop;
                }

        if (flag) {
            ans[init]++;
            return;
        }

        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                dfs (x + len / 3 * i, y + len / 3 * j, len / 3);
            }
        }

    }
}
