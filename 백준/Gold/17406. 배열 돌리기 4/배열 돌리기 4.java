import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static class Info {
        int s, r, c;

        Info (int s, int r, int c) {
            this.s = s;
            this.r = r;
            this.c = c;
        }
    }
    static int N, M, K, ans;
    static int [][] arr;
    static boolean [] visited;
    static Info [] infos;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= M ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        infos = new Info[K];
        visited = new boolean[K];

        for (int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            infos[i] = new Info(s, r, c);
        }

        ans = Integer.MAX_VALUE;

        dfs(0);

        System.out.println(ans);
    }

    static void dfs (int k) {
        if (k == K) {
            ans = Math.min(ans, calcScore());
            return;
        }

        for (int i = 0 ; i < K ; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            rotate(i);
            dfs(k + 1);
            visited[i] = false;
            rollback(i);
        }

    }

    static int calcScore () {
        int res = Integer.MAX_VALUE;

        for (int i = 1 ; i <= N ; i++) {
            int sum = 0;
            for (int j = 1 ; j <= M ; j++) {
                sum += arr[i][j];
            }

            res = Math.min(res, sum);
        }

        return res;
    }

    static void rotate (int idx) {
        for (int s = 1 ; s <= infos[idx].s ; s++) {
            int row_min = infos[idx].r - s;
            int row_max = infos[idx].r + s;
            int col_min = infos[idx].c - s;
            int col_max = infos[idx].c + s;

            int temp = arr[row_min][col_min];

            for (int i = row_min + 1 ; i <= row_max ; i++) {
                arr[i - 1][col_min] = arr[i][col_min];
            }

            for (int i = col_min + 1 ; i <= col_max ; i++) {
                arr[row_max][i - 1] = arr[row_max][i];
            }

            for (int i = row_max - 1 ; i >= row_min ; i--) {
                arr[i + 1][col_max] = arr[i][col_max];
            }

            for (int i = col_max - 1 ; i >= col_min ; i--) {
                arr[row_min][i + 1] = arr[row_min][i];
            }

            arr[row_min][col_min + 1] = temp;
        }
    }

    static  void rollback (int idx) {
        for (int s = 1 ; s <= infos[idx].s ; s++) {
            int row_min = infos[idx].r - s;
            int row_max = infos[idx].r + s;
            int col_min = infos[idx].c - s;
            int col_max = infos[idx].c + s;

            int temp = arr[row_min][col_min];

            for (int i = col_min + 1 ; i <= col_max ; i++) {
                arr[row_min][i - 1] = arr[row_min][i];
            }

            for (int i = row_min + 1 ; i <= row_max ; i++) {
                arr[i - 1][col_max] = arr[i][col_max];
            }

            for (int i = col_max - 1 ; i >= col_min ; i--) {
                arr[row_max][i + 1] = arr[row_max][i];
            }

            for (int i = row_max - 1 ; i >= row_min ; i--) {
                arr[i + 1][col_min] = arr[i][col_min];
            }

            arr[row_min + 1][col_min] = temp;
        }
    }
}