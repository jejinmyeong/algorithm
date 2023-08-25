import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Point [] points = new Point[3];

        for (int i = 0 ; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(ccw(points[0], points[1], points[2]));
    }

    static int ccw (Point p1, Point p2, Point p3) {
        int a = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
        int b = p1.y * p2.x + p2.y * p3.x + p3.y * p1.x;

        if (a - b > 0) return 1;
        else if (a == b) return 0;
        else return - 1;
    }
}