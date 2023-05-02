import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        final int [][] D = {{},{0, 1},{0, -1},{-1, 0},{1, 0}};

        int now = 0;
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        int nowTop = 0;

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            int d = Integer.parseInt(st.nextToken());

            int nx = x + D[d][0];
            int ny = y + D[d][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            x = nx;
            y = ny;

            int temp = now;

            if (d == 1) {
                now = right;
                right = nowTop;
                nowTop = left;
                left = temp;
            } else if (d == 2) {
                now = left;
                left = nowTop;
                nowTop = right;
                right = temp;

            } else if (d == 3) {
                now = top;
                top = nowTop;
                nowTop = bottom;
                bottom = temp;

            } else if (d == 4) {
                now = bottom;
                bottom = nowTop;
                nowTop = top;
                top = temp;
            }

            if (map[x][y] == 0) map[x][y] = now;
            else {
                now = map[x][y];
                map[x][y] = 0;
            }

            sb.append(nowTop).append("\n");
        }

        System.out.print(sb);
    }
}