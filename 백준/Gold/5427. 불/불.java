import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y, c;

        Point (int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    static int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char [][] map = new char[h][w];
            ArrayList<Point> fires = new ArrayList<>();

            Point start = null;

            for (int i = 0 ; i < h ; i++) {
                String input = br.readLine();
                for (int j = 0 ; j < w ; j++) {
                    char c = input.charAt(j);

                    if (c == '@') start = new Point(i, j, 0);
                    else if (c == '*') fires.add(new Point(i, j, 0));
                    map[i][j] = c;
                }
            }

            sb.append(bfs(start, map, fires, w, h)).append("\n");

        }

        System.out.print(sb);
    }

    static String bfs(Point start, char [][] map, ArrayList<Point> fires, int w, int h) {
        Queue<Point> human = new LinkedList<>();
        Queue<Point> fire = new LinkedList<>();
        boolean [][] visited = new boolean[h][w];

        for (Point f: fires) {
            fire.offer(f);
        }

        human.offer(start);
        visited[start.x][start.y] = true;

        while (!human.isEmpty()) {

            int end = fire.size();

            for (int i = 0 ; i < end ; i++) {
                Point f = fire.poll();

                for (int d = 0 ; d < 4 ; d++) {
                    int nx = f.x + D[d][0];
                    int ny = f.y + D[d][1];

                    if (isOverflow(nx, ny, w, h) || map[nx][ny] == '#' || map[nx][ny] == '*') continue;

                    map[nx][ny] = '*';
                    fire.offer(new Point(nx, ny, 0));
                }
            }

            end =  human.size();

            for (int i = 0 ; i < end ; i++) {
                Point now = human.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + D[d][0];
                    int ny = now.y + D[d][1];

                    if (isOverflow(nx, ny, w, h)) return String.valueOf(now.c + 1);
                    if (visited[nx][ny] || map[nx][ny] != '.') continue;

                    visited[nx][ny] = true;
                    human.offer(new Point(nx, ny, now.c + 1));
                }
            }
        }

        return "IMPOSSIBLE";
    }

    static boolean isOverflow(int nx, int ny, int w, int h) {
        return nx < 0 || ny < 0 || nx >= h || ny >= w;
    }
}
