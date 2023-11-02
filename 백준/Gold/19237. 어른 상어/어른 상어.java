import java.util.*;
import java.io.*;

public class Main {
    static class Pos {
        int x, y, d;

        Pos (int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int N, M, K;
    static int [][] map, D = {{},{-1, 0},{1, 0},{0, -1},{0, 1}};
    static int [][][] priorityDirection;
    static Pos [] sharks;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        sharks = new Pos[M + 1];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                int s = Integer.parseInt(st.nextToken());

                if (s != 0) {
                    sharks[s] = new Pos(i, j, 0);
                    map[i][j] = s * 10000 + K;
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= M ; i++) {
            sharks[i].d = Integer.parseInt(st.nextToken());
        }

        priorityDirection = new int[M + 1][5][4];

        for (int i = 1 ; i <= M ; i++) {
            for (int j = 1 ; j <= 4 ; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0 ; k < 4 ; k++) {
                    priorityDirection[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int time = 0;
        int cnt = M;
        boolean [] out = new boolean[M + 1];

        while (++time <= 1000 && cnt > 1) {
            for (int i = 1 ; i <= M ; i++) {
                if (out[i]) continue;
                sharks[i].d = decideDirection(i);
            }
            decreaseCnt();
            for (int i = 1 ; i <= M ; i++) {
                if (out[i]) continue;
                Pos now = sharks[i];

                int nx = now.x + D[now.d][0];
                int ny = now.y + D[now.d][1];

                sharks[i].x = nx;
                sharks[i].y = ny;

                if (map[nx][ny] % 10000 == K) {
                    int n = map[nx][ny] / 10000;
                    if (n > i) {
                        out[n] = true;
                        cnt--;
                        map[nx][ny] = i * 10000 + K;
                    } else if (n < i) {
                        out[i] = true;
                        cnt--;
                    }
                } else {
                    map[nx][ny] = i * 10000 + K;
                }

            }
        }

        if (cnt > 1) {
            System.out.println(-1);
        } else {
            System.out.println(time - 1);
        }


    }

    static void decreaseCnt() {
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (map[i][j] > 0) {
                    map[i][j]--;
                    if (map[i][j] % 10000 == 0) {
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    static int decideDirection(int n) {
        Pos now = sharks[n];
        int temp = -1;

        for (int i = 0 ; i < 4 ; i++) {
            int d = priorityDirection[n][now.d][i];

            int nx = now.x + D[d][0];
            int ny = now.y + D[d][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (map[nx][ny] == 0) {
                return d;
            } else if (map[nx][ny] / 10000 == n && temp == -1) {
                temp = d;
            }
        }

        return temp;
    }

}