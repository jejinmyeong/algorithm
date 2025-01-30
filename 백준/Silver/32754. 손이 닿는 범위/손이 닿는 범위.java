import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int ans = 0;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());

            // 중점
            double cx = (x1 + x3) / 2d;
            double cy = (y1 + y3) / 2d;

            // 대각선 길이
            double R2 = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3)) / 2;

            // 원점과 중점의 거리
            double d = Math.sqrt(cx * cx + cy * cy);

            if (d <= R + R2) ans++;
        }

        System.out.println(ans);
    }
}
