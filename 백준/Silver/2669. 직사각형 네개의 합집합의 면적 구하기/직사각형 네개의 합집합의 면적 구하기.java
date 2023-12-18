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

        boolean [][] visited = new boolean[101][101];

        for (int i = 0 ; i < 4 ; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1 ; x < x2 ; x++) {
                for (int y = y1 ; y < y2 ; y++) {
                    visited[x][y] = true;
                }
            }
        }

        int ans = 0;

        for (int i = 0 ; i < 101 ; i++) {
            for (int j = 0 ; j < 101 ; j++) {
                if (visited[i][j]) ans++;
            }
        }

        System.out.println(ans);
        
    }
}
