import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [][] map = new int[101][101];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            for (int x = X ; x < X + 10 ; x++) {
                for (int y = Y ; y < Y + 10 ; y++) {
                    map[x][y] = 1;
                }
            }
        }

        int ans = 0;

        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        for (int i = 0 ; i < 101 ; i++) {
            for (int j = 0 ; j < 101 ; j++) {
                if (map[i][j] == 0) continue;

                for (int d = 0 ; d < 4 ; d++) {
                    int nx = i + D[d][0];
                    int ny = j + D[d][1];

                    if (nx > 0 && nx <= 100 && ny > 0 && ny <= 100 && map[nx][ny] == 0) ans++;
                    else if (nx < 1 || nx > 100 || ny < 1 || ny > 100) ans++;
                }
            }
        }

        System.out.println(ans);
    }
}