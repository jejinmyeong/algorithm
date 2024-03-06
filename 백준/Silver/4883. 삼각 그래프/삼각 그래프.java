import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int [][] D = {{-1, -1},{-1, 0},{-1, 1},{0, -1}};

        int idx = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            
            if (N == 0) break;

            int [][] map = new int[N][3];

            for (int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0 ; j < 3 ; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int [][] dist = new int[N][3];

            for (int i = 0 ; i < N ; i++) {
                Arrays.fill(dist[i], 1_000_000_000);
            }

            dist[0][0] = 1_000_000_000;
            dist[0][1] = map[0][1];
            dist[0][2] = map[0][1] + map[0][2];

            for (int i = 1 ; i < N ; i++) {
                for (int j = 0 ; j < 3 ; j++) {
                    for (int d = 0 ; d < 4 ; d++) {
                        int nx = i + D[d][0];
                        int ny = j + D[d][1];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= 3) continue;

                        dist[i][j] = Math.min(dist[i][j], dist[nx][ny] + map[i][j]);
                    }
                }
            }

            sb.append(idx++ + ". " + dist[N - 1][1]).append("\n");
        }

        System.out.print(sb);
    }
}