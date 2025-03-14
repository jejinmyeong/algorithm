import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken()),
            X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken()),
            P = Integer.parseInt(st.nextToken()), R = H / 2, ans = 0;

        for (int i = 0 ; i < P ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            if ((x <= X + W && x >= X && y <= Y + H && y >= Y) ||
                (X - x) * (X - x) + (Y + R - y) * (Y + R - y) <= R * R ||
                (X + W - x) * (X + W - x) + (Y + R - y) * (Y + R - y) <= R * R
            ) ans ++;
        }

        System.out.println(ans);
    }
}

