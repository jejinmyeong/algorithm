import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int gcd = GCD(b1, b2);

        int b = gcd * (b1 / gcd) * (b2 / gcd);
        int a = a1 * (b2 / gcd) + a2 * (b1 / gcd);

        gcd = GCD(a, b);

        System.out.println((a / gcd) + " " + (b / gcd));
        
    }

    static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}
