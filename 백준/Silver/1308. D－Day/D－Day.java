import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int [] M = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int [] dp = new int[12];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dp[0] = 0;

        for (int i = 1 ; i < 12 ; i++) {
            dp[i] = dp[i - 1] + M[i - 1];
        }

        st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int dy = Integer.parseInt(st.nextToken());
        int dm = Integer.parseInt(st.nextToken());
        int dd = Integer.parseInt(st.nextToken());

        if (dy > y + 1000 || (y + 1000 == dy && dm >= m && dd >= d)) {
            System.out.println("gg");
            return;
        }

        System.out.println("D-" + (calcDay(dy, dm, dd) - calcDay(y, m, d)));

    }

    static int calcDay (int y, int m, int d) {
        int day = 0;
        for (int i = 1; i < y ; i++) {
            day += 365;
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                day += 1;
            }
        }

        day += dp[m - 1];

        if (((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) && m > 2) {
            day += 1;
        }

        day += d;

        return day;
    }
}