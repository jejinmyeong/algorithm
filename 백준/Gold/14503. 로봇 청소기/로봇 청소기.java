import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Robot {
        int r, c, d;
        Robot (int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Robot> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        queue.offer(new Robot(r, c, d));

        int [][] map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
        boolean [][] visited = new boolean[N][M];

        int ans = 0;

        while(!queue.isEmpty()) {
            Robot now = queue.poll();

            if (map[now.r][now.c] == 0) {
                map[now.r][now.c] = 2;
                visited[now.r][now.c] = true;
                ans++;
            }

            boolean flag = false;

            for (int i = 0 ; i < 4 ; i++) {
                int nx = now.r + D[i][0];
                int ny = now.c + D[i][1];

                if (map[nx][ny] != 0) continue;
                flag = true;
            }

            if (!flag) {
                int nx = now.r + D[(now.d + 2) % 4][0];
                int ny = now.c + D[(now.d + 2) % 4][1];

                if (map[nx][ny] == 1) break;

                queue.offer(new Robot(nx, ny, now.d));
            } else {
                int nx = now.r + D[(now.d + 3) % 4][0];
                int ny = now.c + D[(now.d + 3) % 4][1];

                if (map[nx][ny] == 0) {
                    queue.offer(new Robot(nx, ny, (now.d + 3) % 4));
                } else queue.offer(new Robot(now.r, now.c, (now.d + 3) % 4));
            }
        }

        System.out.println(ans);

    }
}