import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int [][] map = new int[N + 1][N + 1];

        for (int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        String [] changeDirection = new String[10001];

        for (int i = 0 ; i < L ; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            changeDirection[t] = d;
        }

        int [][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Deque<Point> deque = new LinkedList<>();
        deque.offer(new Point(1, 1));
        boolean [][] visited = new boolean[N + 1][N + 1];
        visited[1][1] = true;

        int ans = 0;
        int d = 0;

        while(true) {
            // 전진 방향 결정
            if ("D".equals(changeDirection[ans])) {
                d = (d + 1) % 4;
            } else if ("L".equals(changeDirection[ans])) {
                d = (d + 3) % 4;
            }
            ans++;
            // 머리 우선 전진
            Point now = deque.peekLast();

            int nx = now.x + D[d][0];
            int ny = now.y + D[d][1];

            if (isOverflow(nx, ny, N) || visited[nx][ny]) break;

            deque.offer(new Point(nx, ny));
            visited[nx][ny] = true;

            // 사과를 만나나?
            if (map[nx][ny] != 1) {
                Point tail = deque.poll();
                visited[tail.x][tail.y] = false;
            } else {
                map[nx][ny] = 0;
            }
        }

        System.out.println(ans);

    }

    static boolean isOverflow(int nx, int ny, int N) {
        return nx < 1 || ny < 1 || nx > N || ny > N;
    }
}