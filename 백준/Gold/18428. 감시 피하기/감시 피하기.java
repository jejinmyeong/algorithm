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
    static int N;
    static char [][] map;
    static int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    static List<Pos> teachers, students;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        teachers = new ArrayList<>();
        students = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                char c = st.nextToken().charAt(0);

                if (c == 'T') {
                    teachers.add(new Pos(i, j));
                } else if (c == 'S') {
                    students.add(new Pos(i, j));
                }

                map[i][j] = c;
            }
        }

        bt(0, 0, 0);

        System.out.println("NO");
    }

    static void bt (int x, int y, int k) {
        if (k == 3) {
            boolean [][] vision = chekcVision();

            boolean flag = false;
            for (Pos s: students) {
                if (vision[s.x][s.y]) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        int nx = y + 1 == N ? x + 1 : x;
        int ny = y + 1 == N ? 0 : y + 1;

        if (nx >= N) return;

        if (map[x][y] == 'X') {
            map[x][y] = 'O';
            bt(nx, ny, k + 1);
            map[x][y] = 'X';
        }

        bt(nx, ny, k);
    }

    static boolean [][] chekcVision() {
        boolean [][] vision = new boolean[N][N];

        for (Pos t: teachers) {
            vision[t.x][t.y] = true;
            for (int d = 0 ; d < 4 ; d++) {
                Queue<Pos> queue = new ArrayDeque<>();
                queue.offer(t);

                while (!queue.isEmpty()) {
                    Pos now = queue.poll();

                    int nx = now.x + D[d][0];
                    int ny = now.y + D[d][1];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 'O') continue;

                    vision[nx][ny] = true;
                    queue.offer(new Pos(nx, ny));
                }
            }
        }

        return vision;
    }
}