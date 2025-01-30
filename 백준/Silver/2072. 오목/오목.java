import java.io.*;
import java.util.*;

public class Main {
    static int [][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[20][20];

        for (int i = 0 ; i < 20 ; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = i % 2;

            if (i < 8) continue;

            if (isCompelete(y, x)) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(-1);
    }

    static int [][] D = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    private static boolean isCompelete(int y, int x) {
        int [] sum = {1, 1, 1, 1};

        for (int d = 0 ; d < 8 ; d++) {
            int nx = x + D[d][1];
            int ny = y + D[d][0];

            while (true) {
                if (nx < 0 || ny < 0 || nx >= 19 || ny >= 19 || map[ny][nx] != map[y][x]) break;

                sum[d % 4]++;
                nx += D[d][1];
                ny += D[d][0];
            }
        }

        if (sum[0] == 5 || sum[1] == 5 || sum[2] == 5 || sum[3] == 5) return true;

        return false;
    }
}
