import java.util.*;
import java.io.*;

public class Main {
    static class Robot {
        int x, y, d;

        Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Robot [] robots = new Robot[N + 1];
        int [][] visited = new int[A + 1][B + 1];

        // N = 0 E = 1 S = 2 W = 3

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            visited[x][y] = i;

            String D = st.nextToken();

            int d = -1;

            if ("N".equals(D)) d = 0;
            else if ("E".equals(D)) d = 1;
            else if ("S".equals(D)) d = 2;
            else d = 3;

            robots[i] = new Robot(x, y, d);
        }

        int [][] D = {{1, 0},{0, 1},{-1, 0},{0, -1}};

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            String com = st.nextToken();
            int repeat = Integer.parseInt(st.nextToken());

            Robot now = robots[idx];

            for (int j = 0 ; j < repeat ; j++) {
                if ("L".equals(com)) {
                    now.d = (now.d + 3) % 4;
                } else if ("R".equals(com)) {
                    now.d = (now.d + 1) % 4;
                } else {
                    visited[now.x][now.y] = 0;

                    int nx = now.x + D[now.d][0];
                    int ny = now.y + D[now.d][1];

                    if (nx < 1 || ny < 1 || nx > A || ny > B) {
                        System.out.println("Robot " + idx + " crashes into the wall");
                        return;
                    } else if (visited[nx][ny] != 0) {
                        System.out.println("Robot " + idx + " crashes into robot " + visited[nx][ny]);
                        return;
                    }

                    now.x = nx;
                    now.y = ny;
                    visited[nx][ny] = idx;
                }
            }
        }

        System.out.println("OK");
    }
}
