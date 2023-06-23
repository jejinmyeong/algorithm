import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y - o.y;
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Point [] points = new Point[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);
        }

        Arrays.sort(points);

        int ans = 0;

        int start = points[0].x;
        int end = points[0].y;

        for (int i = 1 ; i < N ; i++) {
            if (points[i].x > end) {
                ans += end - start;
                start = points[i].x;
            }
            end = Math.max(end, points[i].y);
        }

        ans += end - start;

        System.out.println(ans);
    }
}