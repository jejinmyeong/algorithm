import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = n - m;

        long c1 = count(5, n) - count(5, m) - count(5, k);
        long c2 = count(2, n) - count(2, m) - count(2, k);

        System.out.println(Math.min(c1, c2));

    }

    static long count(int d, int num) {
        long cnt = 0;

        while (num >= d) {
            cnt += num / d;
            num /= d;
        }

        return cnt;
    }
}