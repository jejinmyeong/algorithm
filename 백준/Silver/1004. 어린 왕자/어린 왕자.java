import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int N = Integer.parseInt(br.readLine());

            int ans = 0;

            for (int i = 0 ; i < N ; i++) {
                // 행성의 중심과 start의 거리와 반지름 보다 작고 end와의 거리가 크면 탈출, 이와 반대여도 탈출, 같으면 이동 안함
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                double d1 = Math.sqrt(Math.pow(start.x - x, 2) + Math.pow(start.y - y, 2));
                double d2 = Math.sqrt(Math.pow(end.x - x, 2) + Math.pow(end.y - y, 2));

                if ((d1 > r && d2 < r) | (d1 < r && d2 > r)) ans++;
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
