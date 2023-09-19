import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int gcd = Integer.parseInt(st.nextToken());
        long lcm = Integer.parseInt(st.nextToken());

        long target = gcd * lcm;

        int a = 0, b = 0;

        for (int i = gcd ; i <= Math.sqrt(target) ; i+= gcd) {
            if (target % i == 0 && gcd(i, (int)(target / i)) == gcd) {
                a = i;
                b = (int) (target / i);
            }
        }

        System.out.println(a + " " + b);
    }

    static long gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
