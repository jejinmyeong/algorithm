import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int [][] map = new int[N][N];

        int [][] D = {{1, 0},{0, 1},{-1, 0},{0, -1}};

        int x = -1, y = 0, d = 0;
        int tx = -1, ty = -1;

        for (int i = N * N ; i > 0 ; i--) {
            int nx = x + D[d][0];
            int ny = y + D[d][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0) {
                d = (d + 1) % 4;
                nx = x + D[d][0];
                ny = y + D[d][1];
            }

            if (i == M) {
                tx = nx;
                ty = ny;
            }

            map[nx][ny] = i;
            x = nx;
            y = ny;
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(tx + 1).append(" ").append(ty + 1);

        System.out.println(sb);
    }
}