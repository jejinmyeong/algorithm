import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int N;
    static int [][] map;
    static boolean [][] visited;
    static int ans;
    static int [][] D = {{0, 0},{-1, 0},{0, 1},{1, 0},{0, -1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        ans = Integer.MAX_VALUE;

        backtracking( 0, 0);

        System.out.println(ans);

    }

    static void backtracking(int k, int sum) {
        if (k == 3) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 1 ; i < N ; i++) {
            for (int j = 1 ; j < N ; j++) {
                boolean flag = true;
                int temp = 0;
                for (int d = 0 ; d < 5 ; d++) {
                    int nx = i + D[d][0];
                    int ny = j + D[d][1];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                        flag = false;
                        break;
                    }
                    temp += map[nx][ny];
                }

                if (!flag) continue;

                for (int d = 0 ; d < 5 ; d++) {
                    int nx = i + D[d][0];
                    int ny = j + D[d][1];

                    visited[nx][ny] = true;
                }

                backtracking(k + 1, sum + temp);

                for (int d = 0 ; d < 5 ; d++) {
                    int nx = i + D[d][0];
                    int ny = j + D[d][1];

                    visited[nx][ny] = false;
                }
            }
        }
    }
}