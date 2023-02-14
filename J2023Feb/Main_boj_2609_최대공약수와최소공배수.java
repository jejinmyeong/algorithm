package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int gcd = GCD(n1, n2);

        System.out.println(gcd);
        System.out.println(n1/gcd * n2/gcd * gcd);


    }

    static int GCD (int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}
