import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Pos {
        int x, y;

        Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int [][] map, D = {{0, -1},{-1, -1},{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pos> queue = new ArrayDeque<>();

        queue.offer(new Pos(N - 1, 0));
        queue.offer(new Pos(N - 1, 1));
        queue.offer(new Pos(N - 2, 0));
        queue.offer(new Pos(N - 2, 1));

        for (int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            ArrayList<Pos> clouds = new ArrayList<>();

            while (!queue.isEmpty()) {
                Pos now = queue.poll();

                int nx = (now.x + N * 50 + D[d][0] * s) % N;
                int ny = (now.y + N * 50 + D[d][1] * s) % N;

                clouds.add(new Pos(nx, ny));
            }

            boolean [][] isClouds = new boolean[N][N];

            for (Pos c: clouds) {
                map[c.x][c.y] += 1;
                isClouds[c.x][c.y] = true;
            }

            int [][] temp = map.clone();
            for (Pos c: clouds) {
                int cnt = 0;
                for (int k = 1 ; k < 8 ; k += 2) {
                    int nx = c.x + D[k][0];
                    int ny = c.y + D[k][1];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    if (temp[nx][ny] > 0) cnt++;
                }

                map[c.x][c.y] += cnt;
            }

            for (int i = 0 ; i < N ; i++) {
                for (int j = 0 ; j < N ; j++) {
                    if (map[i][j] < 2 || isClouds[i][j]) continue;
                    map[i][j] -= 2;
                    queue.offer(new Pos(i, j));
                }
            }
        }

        int ans = 0;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                ans += map[i][j];
            }
        }

        System.out.println(ans);
    }
}