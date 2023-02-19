package J2023Feb;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_16236_아기상어 {

    static int N;
    static int [][] map, D = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        Point shark = null;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Point(i, j);
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(bfs(shark));

    }

    static class Node {
        Point p;
        int cnt;

        Node (Point p, int cnt) {
            this.p = p;
            this.cnt = cnt;
        }
    }

    static int bfs (Point init) {
        Point now = init;
        int cnt = 0;
        int size = 2;
        int eats = 0;
        while (true) {
            Node next = findClosestFish(now, size);

            if (next.p == null) break;

            map[next.p.x][next.p.y] = 0;
            now = next.p;
            cnt += next.cnt;
            eats++;

            if (eats == size) {
                eats = 0;
                size++;
            }
        }

        return cnt;
    }

    static Node findClosestFish (Point init, int size) {
        Queue<Node> queue = new LinkedList<>();
        boolean [][] visited = new boolean[N][N];

        queue.offer(new Node(init, 0));
        visited[init.x][init.y] = true;

        int cnt = Integer.MAX_VALUE;
        Point temp = null;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.cnt > cnt) continue;

            if ((map[now.p.x][now.p.y] != 0 && map[now.p.x][now.p.y] < size) && (temp == null || temp.x > now.p.x || (temp.x == now.p.x && temp.y > now.p.y))) {
                // x가 가장 작은 거 -> y가 가장 작은 거
                temp = new Point(now.p.x, now.p.y);
                cnt = Math.min(cnt, now.cnt);
                continue;
            }

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.p.x + D[d][0];
                int ny = now.p.y + D[d][1];

                if (isOverflow(nx, ny) || visited[nx][ny] || map[nx][ny] > size) continue;

                queue.offer(new Node(new Point(nx, ny), now.cnt + 1));
                visited[nx][ny] = true;
            }
        }

        return new Node(temp, cnt);
    }

    static boolean isOverflow (int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }
}
