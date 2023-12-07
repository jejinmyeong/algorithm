import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static class Pos {
        int x, y;
        StringBuilder sb;

        Pos(int x, int y, StringBuilder sb) {
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int [][] map = new int[5][5];

        for (int i = 0 ; i < 5 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 5 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        HashSet<String> set = new HashSet<>();

        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        for (int i = 0 ; i < 5 ; i++) {
            for (int j = 0 ; j < 5 ; j++) {
                Queue<Pos> queue = new ArrayDeque<>();
                queue.offer(new Pos(i, j, new StringBuilder().append(map[i][j])));

                for (int n = 1 ; n < 6 ; n++) {
                    int end = queue.size();

                    for (int q = 0 ; q < end ; q++) {
                        Pos now = queue.poll();

                        for (int d = 0 ; d < 4 ; d++) {
                            int nx = now.x + D[d][0];
                            int ny = now.y + D[d][1];

                            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

                            queue.offer(new Pos(nx, ny, new StringBuilder().append(now.sb).append(map[nx][ny])));
                        }
                    }
                }

                while (!queue.isEmpty()) {
                    set.add(queue.poll().sb.toString());
                }
            }
        }

        System.out.println(set.size());
    }
}
