import java.util.*;
import java.io.*;
import java.math.*;

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

        Point [] points = new Point[26];

        for (int i = 0 ; i < 5 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 5 ; j++) {
                points[Integer.parseInt(st.nextToken())] = new Point(i, j);
            }
        }

        boolean [][] visited = new boolean[5][5];

        int ans = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 0 ; i < 5 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 5 ; j++) {
                Point call = points[Integer.parseInt(st.nextToken())];

                visited[call.x][call.y] = true;

                // 가로 확인
                for (int r = 0 ; r < 5 ; r++) {
                    if (!visited[call.x][r]) break;
                    if (r == 4) cnt++;
                }

                // 세로 확인
                for (int c = 0 ; c < 5 ; c++) {
                    if (!visited[c][call.y]) break;
                    if (c == 4) cnt++;
                }

                // 대각선 확인
                if (call.x == call.y) {
                    for (int k = 0 ; k < 5 ; k++) {
                        if (!visited[k][k]) break;
                        if (k == 4) cnt++;
                    }
                }

                if (call.x + call.y == 4) {
                    for (int k = 0 ; k < 5 ; k++) {
                        if (!visited[4 - k][k]) break;
                        if (k == 4) cnt++;
                    }
                }

                if (cnt >= 3) {
                    ans = Math.min(ans, i * 5 + j + 1);
                }

            }
        }

        System.out.println(ans);
    }
}


