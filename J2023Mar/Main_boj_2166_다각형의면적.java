package J2023Mar;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_2166_다각형의면적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Point [] dots = new Point[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots[i] = new Point(x, y);
        }

        double ans = 0;

        for (int i = 0 ; i < N ; i++){
            ans += (double) dots[i].x * dots[(i + 1) % N].y - (double) dots[(i + 1) % N].x * dots[i].y;
        }

        ans = Math.abs(ans);
        ans *= 10;
        ans /= 20;

        System.out.println(String.format("%.1f", ans));
    }
}
