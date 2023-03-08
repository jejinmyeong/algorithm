package J2023Mar;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_9328_열쇠 {

    static int N, M, ans;
    static char [][] map;
    static HashSet<Character> keys;
    static int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N + 2][M + 2];

            for (int i = 1 ; i <= N ; i++) {
                String input = br.readLine();
                for (int j = 1 ; j <= M ; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
            }

            String k = br.readLine();
            keys = new HashSet<>();

            for (int i = 0 ; i < k.length() ; i++) {
                if (k.charAt(i) == '0') break;
                keys.add(k.charAt(i));
            }

            ans = 0;
            bfs();

            sb.append(ans).append("\n");

        }

        System.out.print(sb);
    }

    static void bfs () {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        int [][] visited = new int[N + 2][M + 2];
        visited[0][0]++;
        int getKey = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.x + D[d][0];
                int ny = now.y + D[d][1];

                if (isOverflow(nx, ny) || map[nx][ny] == '*' || visited[nx][ny] > getKey) continue;

                if (map[nx][ny] == '$') {
                    ans++;
                    map[nx][ny] = '.';
                }
                else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z' && !keys.contains(map[nx][ny])) {
                    keys.add(map[nx][ny]);
                    getKey++;
                } else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z' && !keys.contains((char) (map[nx][ny] + 32))) {
                    continue;
                }
                visited[nx][ny]++;

                queue.offer(new Point(nx, ny));
            }
        }
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx > N + 1 || ny > M + 1;
    }
}
