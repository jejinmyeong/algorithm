import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = gcd(a, b);

            long ans = (long) (a / gcd) * (b / gcd) * gcd;

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}