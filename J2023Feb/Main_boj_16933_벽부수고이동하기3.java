package J2023Feb;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_16933_벽부수고이동하기3 {
    static int N, M, K;
    static int [][] map, D = {{0, -1},{0, 1},{1, 0},{-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static class Node {
        Point p;
        int cnt, b, night;
        Node (Point p, int cnt, int b, int night) {
            this.p = p;
            this.cnt = cnt;
            this.b = b;
            this.night = night;
        }
    }

    static int bfs () {
        Queue<Node> queue = new LinkedList<>();
        boolean [][][][] visited = new boolean[N][M][K + 1][2];

        queue.offer(new Node(new Point(0, 0), 1, 0, 0));
        visited[0][0][0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.p.x == N - 1 && now.p.y == M - 1) {
                return now.cnt;
            }

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.p.x + D[d][0];
                int ny = now.p.y + D[d][1];

                if (isOverflow(nx, ny)) continue;


                if(map[nx][ny] == 0) {
                    if(visited[nx][ny][now.b][(now.night + 1) % 2]) continue;

                    queue.add(new Node(new Point(nx, ny), now.cnt+1, now.b, (now.night + 1) % 2));
                    visited[nx][ny][now.b][(now.night + 1) % 2] = true;
                }else {
                    if (now.b >= K) continue;

                    if(now.night == 0 && !visited[nx][ny][now.b + 1][(now.night + 1) % 2]) {
                        visited[nx][ny][now.b + 1][(now.night + 1) % 2] = true;
                        queue.add(new Node(new Point(nx, ny), now.cnt+1, now.b + 1, (now.night + 1 % 2)));
                    }else if(now.night == 1 && !visited[now.p.x][now.p.y][now.b][(now.night + 1) % 2]) {
                        visited[now.p.x][now.p.y][now.b][(now.night + 1) % 2] = true;
                        queue.add(new Node(new Point(now.p.x, now.p.y), now.cnt+1, now.b, (now.night + 1) % 2));
                    }
                }
            }
        }

        return -1;

    }

    static boolean isOverflow (int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }
}
